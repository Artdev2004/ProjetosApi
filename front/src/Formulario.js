function Formulario({botao, eventoTeclado, cadastrar, obj, cancelar, deletar, alterar}){
    return(
        <form>
            <input type="text" value={obj.nome} onChange={eventoTeclado} name='nome' placeholder="Nome" id="form-control-nome" className="form-control" />
            <input type="text" value={obj.marca}onChange={eventoTeclado} name='marca' placeholder="Marca" className="form-control" />

            {
                botao
                ?
                <input type="button" value="Cadastrar"  onClick={cadastrar} className="btn btn-primary"/>
                :
                <div>
                    <input type="button" onClick={alterar} value="Atualizar" className="btn btn-warning" />
                    <input type="button" onClick={deletar} value="Deletar" className="btn btn-danger" />
                    <input type="button" onClick={cancelar} value="Cancelar" className="btn btn-secondary" />
                </div>
            }
           
            
        </form>
    )
}

export default Formulario;