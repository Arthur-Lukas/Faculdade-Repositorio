package model;

public class ClienteJuridico extends Cliente{

	public String cnpj;

	public ClienteJuridico(){
		super();
		System.out.println("Cliente Jurídico");
	}

	public ClienteJuridico(String nome){
		super(nome);
	}

	@Override
	public String toString() {
		String txt =    "-------------------------------------"+
				"\nNome da Empresa: " + this.nome + 
				"\nCNPJ: " + this.cnpj + 
				"\nEndereço: " + this.endereco + 
				"\nCidade: " + this.cidade.nome;
		return txt;
	}

}
