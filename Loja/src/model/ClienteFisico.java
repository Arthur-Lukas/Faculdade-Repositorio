package model;

public class ClienteFisico extends Cliente{
	public String cpf;
	public double altura;
	public boolean casado;

	public ClienteFisico(){
		super();
	}

	public ClienteFisico(String name){
		super(name);
	}

	public ClienteFisico(String name, String cpf){
		super(name);
		this.cpf = cpf;
	}

	public ClienteFisico(int id, String nome, String end, Cidade cidade, String cpf, double altura, boolean casado){
		super(id, nome, end, cidade);
		this.cpf = cpf;
		this.altura = altura;
		this.casado = casado;
		System.out.println( this );
	}

	@Override
	public String toString() {
		String txtCasado = "Não";
		if( this.casado ){
			txtCasado = "Sim";
		}

		return super.toString() + "\nAltura: " + this.altura +
					  "\nCasado: " + txtCasado + 
					  "\nCPF: " + this.cpf;
	}
}
