/***************************************************************************************************************
 
Neste projeto que eu dediquei muito tempo amor e carinho, tentei implementar tudo aquilo que eu aprendi nas aulas de programação do primeiro semestre da faculdade 
com o professor Adalto Selau. Ester projeto é um CRUD que implementei com o paradigma de POO na linguagem Java junto com a linguagem Mysql para a criação de um banco de dados.
Temos classes e suas características.
  - Aqui estão variáveis do tipo: int, String, char e boolean
  - E aqui eu implementei alguns métodos como: switch case, do while, try catch, if else, for, list, array list
  - Há também características privadas que só são acessiveis através dos métodos 'get' e modificadas através de 'set'
  - Herança: métods 'extends', 'super', 
  - Polimorfismo: pois quando declara os atributos das sub classes junto com os da classe mãe e executando, está fazendo a mesma coisa porem dando resultados diferentes

 ***************************************************************************************************************/

package aplication1;

import java.util.List;

import javax.swing.JOptionPane;

import dao.GeneroDao;
import dao.LivFisDao;
import dao.EbookDao;
import model.Ebook;
import model.Genero;
import model.LivroFisico;

public class Main {
    public static void main(String[] args) {

        List<Genero> generos = GeneroDao.getGenero(); //Listas que pega a lista do banco de dados
        List<Ebook> ebooks = EbookDao.getEbook();
        List<LivroFisico> livrosfisicos = LivFisDao.getLivro();
        
        int opcao = -1;

        do {
            try {
                opcao = mostrarMenu();
    
                switch (opcao) {
                    case 1:
                        generos = GeneroDao.getGenero();
                        cadastrarGenero();
                        break;
                    case 2:
                        generos = GeneroDao.getGenero();
                        excluirGenero();
                        break;
                    case 3:
                        generos = GeneroDao.getGenero();
                        listarGenero(generos);
                        break;
                    case 4:
                        generos = GeneroDao.getGenero();
                        if (generos.size() == 0) {
                            JOptionPane.showMessageDialog(null, "É necessário cadastrar um gênero primeiro!");
                            cadastrarGenero();
                            generos = GeneroDao.getGenero();
                            cadastrarLivro(generos);
                        } else {
                            cadastrarLivro(generos);
                        }
                        break;
                    case 5:
                        ebooks = EbookDao.getEbook();
                        livrosfisicos = LivFisDao.getLivro();
                        atualizarLivro(livrosfisicos,ebooks);
                        break;
                    case 6:
                        ebooks = EbookDao.getEbook();
                        livrosfisicos = LivFisDao.getLivro();
                        excluirLivro();
                        break;
                    case 7:
                        livrosfisicos = LivFisDao.getLivro();
                        listarLivros(livrosfisicos);
                        break;
                    case 8:
                        ebooks = EbookDao.getEbook();// Implementar funcionalidade para listar ebooks
                        listarEbooks(ebooks);
                        break;
                    case 0:
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opção inválida! Digite uma das opções disponíveis.");
                        break;
                }
                
            } catch (NumberFormatException e) {// Essa exceção é capturada quando o usuário digita algo que não pode ser convertido para um número inteiro
                JOptionPane.showMessageDialog(null, "Erro: digite apenas números inteiros para selecionar uma opção.");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro ao executar a operação. Tente novamente.");
            }
        } while (opcao != 0);
    }
    
    public static int mostrarMenu() {
        String texto = "Minha biblioteca\nOlá! Seja bem vindo a sua biblioteca online pessoal\nSelecione uma opção\n" +
            "\n1 - Cadastrar novo gênero" +
            "\n2 - Deletar gênero" +
            "\n3 - Ver os generos que tem\n" +
            "\n4 - Cadastrar livros" +
            "\n5 - Atualizar livro" +
            "\n6 - Deletar algum livro" +
            "\n7 - Listar livros físicos" +
            "\n8 - Listar ebooks\n" +
            "\n0 - Para sair";
        
        int opcao = -1;
        String opcaoDigitada = JOptionPane.showInputDialog(texto);
        
        if (opcaoDigitada != null && !opcaoDigitada.isEmpty()) {
            opcao = Integer.parseInt(opcaoDigitada);
        }
        return opcao;
    }

    public static void cadastrarGenero(){ //1 Método para cadastrar gêneros de livros
        
        String nome = JOptionPane.showInputDialog("Digite o nome do genero: ");
        if(!nome.isEmpty()) //Se não digitar nada, não vai fazer nada
            GeneroDao.cadastrar(nome);// Associando a classe feita no Dao para cadastrar no banco de dados
            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");
    }

    public static void excluirGenero(){//2 Método para excluir um genero
        List <Genero> generos = GeneroDao.getGenero();

        if(generos.isEmpty()){
            JOptionPane.showMessageDialog(null,"Nenhum genero cadastrado para deletar");
            return;
        }
        String texto = "Lista de gêneros\n";
        for (Genero g : generos) {
            texto += "\n"+g.getId()+" - "+g.getNome();
        }

        texto += "\n\nDigite o id que corresponde ao gênero";
        String idDigitado = JOptionPane.showInputDialog(texto);

        String input = JOptionPane.showInputDialog(null, "Tem certeza que deseja deletar este gênero? (s/n)");
        
        // Verifica se a entrada é válida
        if (input != null && input.length() == 1) {
            char ch = input.charAt(0);

            // Verifica o caractere e responde adequadamente
            if (ch == 's' || ch == 'S') {
                try {
                    if(!idDigitado.isEmpty()){
                        int idGenero = Integer.valueOf(idDigitado);
                        GeneroDao.excluir(idGenero);
                        JOptionPane.showMessageDialog(null, "Deletado com sucesso!");
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null,"Este genero não pode ser deletado, delete os livros que estão associados a este gênero antes!");
                    excluirLivro();
                }
            } else if (ch == 'n' || ch == 'N') {
                return;
            } else {
                JOptionPane.showMessageDialog(null, "Você digitou outro caractere.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Entrada inválida. Por favor, digite apenas um caractere.");
        }
    }
    
    public static void listarGenero(List<Genero>generos){ //3 Método para listar os generos

        if (generos.size()<=0) {
            JOptionPane.showMessageDialog(null,"Lista vázia");
        } else {
            String texto = "Todos os generos\n";
            for (Genero g : generos) {
                texto += "\n"+g.getId()+" - "+g.getNome();
            }
            JOptionPane.showMessageDialog(null,texto);
        }
    }

    public static void cadastrarLivro(List<Genero>generos){//4 Método para cadastrar livros

        String escolha = JOptionPane.showInputDialog("Qual tipo de livro você deseja cadastrar?\n\nFísico ou digital?");
        
        if(escolha.equalsIgnoreCase("fisico")){

            String titulo = JOptionPane.showInputDialog("Qual é o título livro?");

            String autor = JOptionPane.showInputDialog("Qual o nome do autor deste livro?");
    
            int intAno = 0; 
    
            String lanDigitado = JOptionPane.showInputDialog("Em que ano ele foi lançado?");
            if (!lanDigitado.isEmpty()) {
                intAno = Integer.valueOf(lanDigitado);
            }
            
            String texto = "Gêneros de livros";
            for (Genero g : generos) {
                texto += "\n"+g.getId()+" - "+g.getNome();
            }
            
            texto += "\nDigite o id que corresponde ao gênero";
            int idGenero = Integer.valueOf(JOptionPane.showInputDialog(texto));
            Genero genSelecionado = null;
            for (Genero g : generos) {
                if(g.getId() == idGenero){
                    genSelecionado = g;
                }
            }

            Double preco = Double.parseDouble(JOptionPane.showInputDialog("Quanto ele custa?"));
    
            LivroFisico novoLivro = new LivroFisico(0,titulo, autor, intAno, genSelecionado, preco);
            LivFisDao.cadastrar(novoLivro);
            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");

        }else if(escolha.equalsIgnoreCase("digital")){

            String titulo = JOptionPane.showInputDialog("Qual é o título livro?");

            String autor = JOptionPane.showInputDialog("Qual o nome do autor?");
    
            int intAno = 0; 
    
            String lanDigitado = JOptionPane.showInputDialog("Em que ano ele foi lançado?");
            if (!lanDigitado.isEmpty()) {
                intAno = Integer.valueOf(lanDigitado);
            }
            
            String texto = "Gêneros de livros";
            for (Genero g : generos) {
                texto += "\n"+g.getId()+" - "+g.getNome();
            }
            
            texto += "\nDigite o id que corresponde ao gênero";
            int idGenero = Integer.valueOf(JOptionPane.showInputDialog(texto));
            Genero genSelecionado = null;
            for (Genero g : generos) {
                if(g.getId() == idGenero){
                    genSelecionado = g;
                }
            }

            int paginas = Integer.valueOf(JOptionPane.showInputDialog("Quantas páginas ele tem?"));
    
            Ebook novoLivro = new Ebook(0,titulo, autor, intAno, genSelecionado, paginas);
            EbookDao.cadastrarEbook(novoLivro);
            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");
        }else{
            JOptionPane.showMessageDialog(null, "Opção inválida!");
            return;
        }
    }
    
    public static void atualizarLivro(List<LivroFisico>livrosfisicos, List<Ebook>ebooks){//5 Método para atualizar livros

        String escolha = JOptionPane.showInputDialog("Qual tipo de livro você deseja cadastrar?\nFísico ou digital?");

        try{
            if(escolha.equalsIgnoreCase("fisico")){

                String texto = "Escolha um livro para atualizar";
                for (LivroFisico l : livrosfisicos) {
                    texto += "\n"+l.id+" - "+l.titulo;
                }

                texto += "\nDigite o id que corresponde";

                int idLivro = 0;
                try {
                    idLivro = Integer.parseInt(JOptionPane.showInputDialog(texto));
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "ID inválido. Operação cancelada.");
                    return;
                }

                LivroFisico livSelecionado = null;
                // Encontrar o livro com o ID especificado
                for (LivroFisico l : livrosfisicos) {
                    if(l.id == idLivro){
                        livSelecionado = l;
                    }
                }
                
                if (livSelecionado == null) {
                    JOptionPane.showMessageDialog(null, "Livro não encontrado. Operação cancelada.");
                    return;
                }
                // Obter novos valores do usuário
                String titulo = JOptionPane.showInputDialog("Coloque um novo titulo", livSelecionado.titulo);
                String autor = JOptionPane.showInputDialog("... E um novo autor", livSelecionado.autor);
                
                int anoLancamento = livSelecionado.lancamento; // valor padrão

                try {
                String lanDigitado = JOptionPane.showInputDialog("E qual a nova data de lançamento?", String.valueOf(livSelecionado.lancamento));
                    if (!lanDigitado.isEmpty()) {
                        anoLancamento = Integer.parseInt(lanDigitado);
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Ano de lançamento inválido. Mantendo o valor original.");
                }

                Double preco = Double.parseDouble(JOptionPane.showInputDialog("Informe o novo valor"));
                // Atualizar os atributos do livro selecionado
                livSelecionado.titulo = titulo;
                livSelecionado.autor = autor;
                livSelecionado.lancamento = anoLancamento;
                livSelecionado.preco = preco;
                // Chamar o método de atualização no DAO
                LivFisDao.editar(livSelecionado);
                
                JOptionPane.showMessageDialog(null, "Livro atualizado com sucesso!");

            }else if(escolha.equalsIgnoreCase("digital")){

                String texto = "Escolha um livro para atualizar";
                for (Ebook l : ebooks) {
                    texto += "\n"+l.id+" - "+l.titulo;
                }

                texto += "\nDigite o id que corresponde";

                int idLivro = 0;
                try {
                    idLivro = Integer.parseInt(JOptionPane.showInputDialog(texto));
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "ID inválido. Operação cancelada.");
                    return;
                }

                Ebook livSelecionado = null;
                // Encontrar o livro com o ID especificado
                for (Ebook l : ebooks) {
                    if(l.id == idLivro){
                        livSelecionado = l;
                    }
                }
                
                if (livSelecionado == null) {
                    JOptionPane.showMessageDialog(null, "Livro não encontrado. Operação cancelada.");
                    return;
                }
                // Obter novos valores do usuário
                String titulo = JOptionPane.showInputDialog("Coloque um novo titulo", livSelecionado.titulo);
                String autor = JOptionPane.showInputDialog("... E um novo autor", livSelecionado.autor);
                
                int anoLancamento = livSelecionado.lancamento; // valor padrão

                try {
                String lanDigitado = JOptionPane.showInputDialog("E qual a nova data de lançamento?", String.valueOf(livSelecionado.lancamento));
                    if (!lanDigitado.isEmpty()) {
                        anoLancamento = Integer.parseInt(lanDigitado);
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Ano de lançamento inválido. Mantendo o valor original.");
                }

                int paginas = Integer.valueOf(JOptionPane.showInputDialog("Informe o novo valor"));
                // Atualizar os atributos do livro selecionado
                livSelecionado.titulo = titulo;
                livSelecionado.autor = autor;
                livSelecionado.lancamento = anoLancamento;
                livSelecionado.paginas = paginas;
                // Chamar o método de atualização no DAO
                EbookDao.editarEbook(livSelecionado);
                
                JOptionPane.showMessageDialog(null, "Livro atualizado com sucesso!");
            }else{
                JOptionPane.showMessageDialog(null, "Opção inválida!");
                return;
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Opção inválida! Por favor digite (fisico) ou (digital)");
            return;
        }
    }

    public static void excluirLivro(){//6 Método para excluir um livro

        List<LivroFisico> livrosfisicos = LivFisDao.getLivro();
        List<Ebook> ebooks = EbookDao.getEbook();

        String escolha = JOptionPane.showInputDialog("Qual tipo de livro você deseja deletar?\nFísico ou digital?");

        if(escolha.equalsIgnoreCase("fisico")){

            String texto = "Escolha um livro da lista para deletar\n";
            for (LivroFisico l : livrosfisicos) {
                texto += "\n"+l.id+" - "+l.titulo;
            }

            texto += "\n\nDigite o id correspondente";
            String idDigitado = JOptionPane.showInputDialog(texto);

            String input = JOptionPane.showInputDialog(null, "Tem certeza que gostaria de deletar este livro? (s/n)");

            if (input != null) {
                
                boolean booleanValue;

                // Verifica se a entrada é 'true' ou 'false'
                if (input.equalsIgnoreCase("S")) {
                    
                    booleanValue = true;

                    if(!idDigitado.isEmpty()){
                        int idLivro = Integer.valueOf(idDigitado);
                        LivFisDao.excluirLiv(idLivro);
                        JOptionPane.showMessageDialog(null,"Deletado com sucesso!");
                    }

                } else if (input.equalsIgnoreCase("n")) {//Ignora se é maiuscuolo ou minusculo e executa do mesmo jeito
                    booleanValue = false;

                } else {
                    JOptionPane.showMessageDialog(null, "Entrada inválida. Por favor, digite 's' ou 'n'.");
                    return;
                }
            }
        }else if(escolha.equalsIgnoreCase("digital")){

            String texto = "Escolha um livro da lista para deletar\n";
            for (Ebook l : ebooks) {
                texto += "\n"+l.id+" - "+l.titulo;
            }

            texto += "\n\nDigite o id correspondente";
            String idDigitado = JOptionPane.showInputDialog(texto);

            String input = JOptionPane.showInputDialog(null, "Tem certeza que gostaria de deletar este livro? (s/n)");

            if (input != null) {
                
                boolean booleanValue;

                // Verifica se a entrada é 'true' ou 'false'
                if (input.equalsIgnoreCase("S")) {
                    
                    booleanValue = true;

                    if(!idDigitado.isEmpty()){
                        int idLivro = Integer.valueOf(idDigitado);
                        EbookDao.excluirEbook(idLivro);
                        JOptionPane.showMessageDialog(null,"Deletado com sucesso!");
                    }

                } else if (input.equalsIgnoreCase("n")) {//Ignora se é maiuscuolo ou minusculo e executa do mesmo jeito
                    booleanValue = false;

                } else {
                    JOptionPane.showMessageDialog(null, "Entrada inválida. Por favor, digite 's' ou 'n'.");
                    return;
                }
            }
        }
    }

    public static void listarLivros(List<LivroFisico>livrosfisicos){ //7 Método para listar os livros

        if(livrosfisicos.isEmpty()){
            JOptionPane.showMessageDialog(null,"Lista vázia");
            return;
        }

        if (livrosfisicos.size()<=0) {
            JOptionPane.showMessageDialog(null,"Lista vázia");
        }else{
            String texto = "Todos os livros";
            for (LivroFisico l : livrosfisicos) {
                texto +=    "\n\n" +l.id+" - "+"Titúlo: "+l.titulo+
                            "\n      Autor: "+l.autor+"\n      Gênero: "+l.genero.getNome()+
                            "\n      Ano de lançamento: "+l.lancamento+
                            "\n      Preço: R$"+l.preco;
            }
            JOptionPane.showMessageDialog(null,texto);
        }
    }

    public static void listarEbooks(List<Ebook>ebooks){ //7 Método para listar os livros

        if(ebooks.isEmpty()){
            JOptionPane.showMessageDialog(null, "Lista vázia!");
            return;
        }

        if (ebooks.size()<=0) {
            JOptionPane.showMessageDialog(null,"Lista vázia");
        }else{
            String texto = "Todos os livros";
            for (Ebook l : ebooks) {
                texto +=    "\n\n" +l.id+" - "+"Titúlo: "+l.titulo+
                            "\n      Autor: "+l.autor+"\n      Gênero: "+l.genero.getNome()+
                            "\n      Ano de lançamento: "+l.lancamento+
                            "\n      N° de pág: "+l.paginas;
            }
            JOptionPane.showMessageDialog(null,texto);
        }
    }
}