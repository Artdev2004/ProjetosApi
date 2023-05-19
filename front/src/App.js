
import { useEffect, useState } from 'react';
import './App.css';
import Formulario from './Formulario';
import Tabela from './Tabela';

function App() {

  // Objeto produto 
const produto = {
  codigo : 0,
  nome : '',
  marca : ''
}

  // UseState 
  const [produtos, setProdutos] = useState([])
  const [btnCadastrar, setBtnCadastrar] = useState(true)
  const [objProduto, setObjProduto] = useState(produto)

  console.log(objProduto)

  // UseEffect 
  useEffect(()=>{
    fetch("http://localhost:8080/listar")
    .then(retorno => retorno.json())
    .then(retorno_convertido => setProdutos(retorno_convertido));
  }, []);


  //Obtendo os dados do fomrulário
  const aoDigitar = (e) => {
    setObjProduto({...objProduto, [e.target.name]:e.target.value});
  }

  // Cadastrar Produto
  const cadastrar = () => {
    fetch('http://localhost:8080/cadastrar',{
      method:'post',
      body:JSON.stringify(objProduto),
      headers:{
        'Content-type':'application/json',
        'Accept':'application/json'
      }
    })
    .then(retorno => retorno.json())
    .then(retorno_convertido => {
      retorno_convertido.mensagem !== undefined ? alert(retorno_convertido.mensagem) 
      : setProdutos([...produtos, retorno_convertido], alert('Cadastro Realizado com Sucesso'));
      
      limparFormulario()
    })
  }

  // Limpar Fomulario

  const limparFormulario = () => {
    setObjProduto(produto)
    setBtnCadastrar(true);
  }

  // Selecionar Produto
  const selecionarProduto = (indice) =>{
    setObjProduto(produtos[indice]);
    setBtnCadastrar(false);
  }

  // Deletar Produto
  const deletarProduto = () => {
    fetch('http://localhost:8080/deletar/'+objProduto.codigo,{
      method:'delete',
      headers:{
        'Content-type':'application/json',
        'Accept':'application/json'
      }
    })
    .then(retorno => retorno.json())
    .then(retorno_convertido => {
      // Mensagem 
      alert(retorno_convertido.mensagem);


      // Cópia do Vetor de Produtos

      let vetorTemp = [...produtos];

      //Variavel de Indice
      let indice = vetorTemp.findIndex((p) =>{
        return p.codigo === objProduto.codigo;

      });

      //Remover produto do vetor Temporario
      vetorTemp.splice(indice, 1);

      //Atualizar o vetor de produtos
      setProdutos(vetorTemp);

      // Limpar Formulario
      limparFormulario();
    })
  }
  
  // Alterar Produto 
  const atualizarProduto = () => {
    fetch('http://localhost:8080/alterar',{
      method:'put',
      body:JSON.stringify(objProduto),
      headers:{
        'Content-type':'application/json',
        'Accept':'application/json'
      }
    })
    .then(retorno => retorno.json())
    .then(retorno_convertido => {
      retorno_convertido.mensagem !== undefined ? alert(retorno_convertido.mensagem) : 
      alert("Produto Alterado com Sucesso");

      // Cópia do Vetor de Produtos
      let vetorTemp = [...produtos];

      //Variavel de Indice
      let indice = vetorTemp.findIndex((p) =>{
        return p.codigo === objProduto.codigo;
      });

      //Alterar produto do vetor Temporario
      vetorTemp[indice] = objProduto;

      //Atualizar o vetor de produtos
      setProdutos(vetorTemp);
      limparFormulario()
    })
  }
  //Retorno
  return (
    <div>
      <Formulario botao={btnCadastrar} eventoTeclado={aoDigitar} cadastrar={cadastrar} obj={objProduto} cancelar={limparFormulario} deletar={deletarProduto} alterar={atualizarProduto}/>
      <Tabela vetor={produtos} selecionar={selecionarProduto}/>
    </div>
  );
}

export default App;
