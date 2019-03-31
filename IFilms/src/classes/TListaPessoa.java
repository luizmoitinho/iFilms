package classes;
public class TListaPessoa {
	
	public TNodoPessoa Primeiro;
	private TNodoPessoa Ultimo;
	
	public TListaPessoa()
	{
		Cria();
	}
	private void Cria(){
		TInfoPessoa Item=new TInfoPessoa();
		this.Primeiro=new TNodoPessoa(Item);
		this.Ultimo=this.Primeiro;
		this.Primeiro.Proximo=null;
		this.Primeiro.Anterior=null;
	}
	private boolean Vazia() {
		return this.Primeiro.Proximo==null? true:false;

	}
	public void InsereFinal(TInfoPessoa Item){
		TNodoPessoa N=new TNodoPessoa(Item); //Novo Elemento
		N.Proximo=null;
		if(Vazia())
			N.Anterior=null;
		else
			N.Anterior=this.Ultimo;
		this.Ultimo.Proximo=N;
		this.Ultimo=N;
	}
	
	public void imprimePessoas() {
		if(Vazia())
			System.out.println("Lista vazia");
		else {
			TNodoPessoa aux = this.Primeiro.Proximo;
			while(aux!=null) {
				System.out.println("Nome...:"+ aux.Item.getNome()+
									"\nEmail.: "+aux.Item.getEmail());
				System.out.println("---------------------------");
				aux=aux.Proximo;
			}
		}
		
	}
	public TNodoPessoa pesquisaUsuario(String email, String senha) {
		TNodoPessoa aux = this.Primeiro.Proximo;
		while(aux!=null) {
			if(aux.Item.email.equals(email)  & aux.Item.senha.equals(senha))
				break;
			
			aux =  aux.Proximo;
			
		}
		return aux;
		
	}
	
}
