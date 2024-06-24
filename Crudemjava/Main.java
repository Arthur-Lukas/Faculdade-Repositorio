
import java.util.Date;

import ContatoDAO;
import Contato;

//MVC
/*
 * Model
 * View
 * Controller
 */

public class main {

	public static void main(String[] args) {
		
		ContatoDAO contatoDao = new ContatoDAO();

		Contato contato = new Contato();
		contato.setNome("João");
		contato.setIdade(16);
		contato.setDataCadastro(new Date());
		
		contatoDao.save(contato);
		
		//Visualiza��o dos registros do banco de dados TODOS
		
		for(Contato c : contatoDao.getContatos()) {
			System.out.println("Contato: "+c.getNome());
		}
	}
}
