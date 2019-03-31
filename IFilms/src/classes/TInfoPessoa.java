package classes;
public class TInfoPessoa {
	protected String nome, email, senha, sexo;
	protected int idade;
	protected String categoriaFavorita;
	
	public TInfoPessoa() {}
	public TInfoPessoa(String nome, String email,int idade, String sexo,String senha) {
		this.nome = nome;
		this.email=email;
		this.senha=senha;
		this.sexo=sexo;
		this.idade =  idade;

		this.categoriaFavorita="";
		
	}
	

	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	

}
