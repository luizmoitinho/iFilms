package classes;
public class TNodoPessoa {
	public TInfoPessoa Item;
	public TNodoPessoa Proximo;
	public TNodoPessoa Anterior;
	
	public TNodoPessoa(TInfoPessoa Item){
		this.Item= new TInfoPessoa(Item.nome,Item.email,Item.idade,Item.sexo,Item.senha);
		this.Proximo=null;
		this.Anterior=null;
	}
}
