package aplication1;

import javax.swing.JOptionPane;

import dao.LivroDao;
import model.Livro;

public class Main {
    public static void main(String[] args) {

        String toInt = JOptionPane.showInputDialog(
        "Minha biblioteca\nOlá! Seja bem vindo a sua biblioteca online pessoal\nSelecione uma opção"+
        "\n1 - Cadastrar novo livro"+
        "\n2 - Atualizar algum livro"+
        "\n3 - Deletar de sua biblioteca"+
        "\n4 - Veja a sua coleção!");
        
        try {
            LivroDao livroDao = new LivroDao();

            int opcao = Integer.parseInt(toInt);
            switch (opcao) {
                case 1:
                    //Cadastrar livro no banco de dados
                    
                    Livro livro = new Livro();
                    livro.setTitulo("Orgulho e preconceito");
                    livro.setAutor("Gabi Florêncio");
                    livro.setLancamento(2000);
                    
                    //Para cadastrar um contato é a opção abaixo, descomentea para habilitar
                    livroDao.save(livro); 
                    JOptionPane.showMessageDialog(null,"livro salvo no banco de dados!");
                    break;
                case 2:
                    Livro l1 = new Livro();
                    l1.setTitulo("O Conde de monte Cristo");
                    l1.setAutor("Alexandre Dumas");
                    l1.setLancamento(2000);
                    l1.setId(44);
            
                    //Comando para realizar o update
                    livroDao.update(l1);
                    //Atualizar o livro no banco de dados
                    break;
                case 3:
                    //Deletar um livro
                        livroDao.deleteByID(45);
                        JOptionPane.showMessageDialog(null, "Item deletado de sua biblioteca");
                    break;
                case 4:
                    //Mostrar a lista de livros salvos
                    for(Livro c : livroDao.getLivros()){

                        JOptionPane.showMessageDialog(null,"Livro: "+ c.getTitulo());
                        System.out.println(c.getTitulo());
                    }
                    break;
                default:
                    JOptionPane.showMessageDialog(null,"Número inválido, digite uma opção válida!");
                    break;
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null,"Não é uma opção válida, digite um número");
        }
    }
}