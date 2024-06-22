/***************************************************************************************************************
 * 
Neste projeto que eu dediquei muito tempo amor e carinho, tentei implementar tudo aquilo que eu aprendi nas aulas de programação do primeiro semestre da faculdade 
com o professor Adalto Selau. Ester projeto é um CRUD que implementei com o paradigma de POO na linguagem Java junto com a linguagem Mysql para a criação de um banco de dados.
Temos classes e suas características.
  - Aqui estão variáveis do tipo: int, String, char e boolean
  - E aqui eu implementei alguns métodos como: switch case, do while, try catch, if else, for, list, array list
  - Há também características privadas que só são acessiveis através dos métodos 'get' e modificadas através de 'set'

 ***************************************************************************************************************/

package aplication1;

import java.util.List;

import javax.swing.JOptionPane;

import dao.GeneroDao;
import dao.LivroDao;
import model.Genero;
import model.Livro;

public class Main {
    public static void main(String[] args) {

        List<Genero> generos = GeneroDao.getGenero(); //Listas que pega a lista do banco de dados
        List<Livro> livros = LivroDao.getLivro();

        int opcao;

        try {//Try para ter uma exceção caso a pessoa digite algo diferente do esperado
            do{ //Laço de repetição para que o menu continue mostrando as opções até digitarem '0'
                opcao = mostrarMenu();
                switch (opcao) {
                    case 0:
                        break;
                    case 1: //Cadastrar genero
                        generos = GeneroDao.getGenero();
                        cadastrarGenero();
                        break;
                    case 2://Deletar genero
                        excluirGenero();
                        break;
                    case 3://Vizualizar todos os generos
                        generos = GeneroDao.getGenero();
                        listarGenero(generos);
                        break;
                    case 4://Cadastrar novo livro
                        generos = GeneroDao.getGenero();//Isso é para atualizar a lista de generos
                        if (generos.size()==0) {
                            JOptionPane.showMessageDialog(null,"É necessário cadastrar um gênero primeiro!");
                            cadastrarGenero();
                            generos = GeneroDao.getGenero();//Atualizar a lista de generos antes de cadastrar algum livro, pq se n tiver isto, não vai aparecer nenhum genero para selecionar
                            cadastrarLivro(generos);
                        }else{
                            cadastrarLivro(generos);
                        }
                        break;
                    case 5://Atualizar livro
                        livros = LivroDao.getLivro();
                        atualizarLivro(livros);
                        break;
                    case 6://Deletar livro
                        excluirLivro();
                        break; 
                    case 7://Mostrar biblioteca
                        livros = LivroDao.getLivro();
                        listarLivros(livros); 
                        break;
                    default:
                        JOptionPane.showMessageDialog(null,"Digite uma das opções disponíveis por favor\nEsta não é uma opção válida!");
                        break;
                }
            }while(opcao!=0);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Opção inválida!");
            return;
        }
    }

    public static int mostrarMenu(){// Classe para mostrar o menu para o usuário

        String texto = "Minha biblioteca\nOlá! Seja bem vindo a sua biblioteca online pessoal\nSelecione uma opção\n"+
        "\n1 - Cadastrar novo gênero"+
        "\n2 - Deletar gênero"+
        "\n3 - Ver os generos que tem\n"+

        "\n4 - Cadastrar novo livro"+
        "\n5 - Atualizar algum livro"+
        "\n6 - Deletar livro"+
        "\n7 - Mostrar coleção\n"+
        "\n0 - Para sair";
            
        int opcao = -1;
        String opcaoDigitada = JOptionPane.showInputDialog(texto);
        if(!opcaoDigitada.isEmpty()){
            opcao = Integer.valueOf(opcaoDigitada);
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

        Livro novoLivro = new Livro(0,titulo, autor, intAno, genSelecionado);
        LivroDao.cadastrar(novoLivro);
        JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");
    }

    public static void atualizarLivro(List<Livro>livros){//5 Método para atualizar livros

        String texto = "Escolha um livro para atualizar";
        for (Livro l : livros) {
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

        Livro livSelecionado = null;
        // Encontrar o livro com o ID especificado
        for (Livro l : livros) {
            if(l.id == idLivro){
                livSelecionado = l;
            }
        }
           
        if (livSelecionado == null) {
            JOptionPane.showMessageDialog(null, "Livro não encontrado. Operação cancelada.");
            return;
        }
        // Obter novos valores do usuário
        String titulo = JOptionPane.showInputDialog("Qual é o título do livro?", livSelecionado.titulo);
        String autor = JOptionPane.showInputDialog("Qual o nome do autor deste livro?", livSelecionado.autor);
        
        int anoLancamento = livSelecionado.lancamento; // valor padrão

        try {
        String lanDigitado = JOptionPane.showInputDialog("Em que ano ele foi lançado?", String.valueOf(livSelecionado.lancamento));
            if (!lanDigitado.isEmpty()) {
                anoLancamento = Integer.parseInt(lanDigitado);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Ano de lançamento inválido. Mantendo o valor original.");
        }
        // Atualizar os atributos do livro selecionado
        livSelecionado.titulo = titulo;
        livSelecionado.autor = autor;
        livSelecionado.lancamento = anoLancamento;
        // Chamar o método de atualização no DAO
        LivroDao.editar(livSelecionado);
        
        JOptionPane.showMessageDialog(null, "Livro atualizado com sucesso!");
    }

    public static void excluirLivro(){//6 Método para excluir um livro
        List<Livro> livros = LivroDao.getLivro();

        String texto = "Escolha um livro para deletar\n";
        for (Livro l : livros) {
            texto += "\n"+l.id+" - "+l.titulo;
        }

        texto += "\n\nDigite o id correspondente";
        String idDigitado = JOptionPane.showInputDialog(texto);

        String input = JOptionPane.showInputDialog(null, "Tem certeza que gostaria de deletar este livro? (s/n)");

        if (input != null) {
            
            boolean booleanValue;

            // Verifica se a entrada é 'true' ou 'false'
            if (input.equalsIgnoreCase("S")||input.equalsIgnoreCase("s")) {
                
                booleanValue = true;

                if(!idDigitado.isEmpty()){
                    int idLivro = Integer.valueOf(idDigitado);
                    LivroDao.excluirLiv(idLivro);
                    JOptionPane.showMessageDialog(null,"Deletado com sucesso!");
                }

            } else if (input.equalsIgnoreCase("n")||input.equalsIgnoreCase("N")) {
                booleanValue = false;

            } else {
                JOptionPane.showMessageDialog(null, "Entrada inválida. Por favor, digite 's' ou 'n'.");
                return;
            }
        }
    }

    public static void listarLivros(List<Livro>livros){ //7 Método para listar os livros

        if (livros.size()<=0) {
            JOptionPane.showMessageDialog(null,"Lista vázia");
        }else{
            String texto = "Todos os livros";
            for (Livro l : livros) {
                texto +=    "\n\n" +l.id+" - "+"Titúlo: "+l.titulo+
                            "\n      Autor: "+l.autor+"\n      Gênero: "+l.genero.getNome()+
                            "\n      Ano de lançamento: "+l.lancamento;
            }
            JOptionPane.showMessageDialog(null,texto);
        }
    }
}