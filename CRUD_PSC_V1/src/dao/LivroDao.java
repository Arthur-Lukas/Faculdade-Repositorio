package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import factory.Conexao;
import model.Livro;

public class LivroDao {

    public void save (Livro livro ){
        String sql = "INSERT INTO livros (titulo, autor, lancamento) VALUE (?,?,?)";

        Connection conn = null;
        PreparedStatement pstm = null;

        try{
            conn = Conexao.getConexao();

            pstm = (PreparedStatement) conn.prepareStatement(sql);

            pstm.setString(1, livro.getTitulo());
            pstm.setString(2, livro.getAutor());
            pstm.setInt(3, livro.getLancamento());

            pstm.execute();
        }catch (Exception e) {
            e.printStackTrace();
        }finally{
            try {
                if(pstm!=null){
                    pstm.close();
                }
                if(conn!=null){
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void update (Livro livro){
        String sql = "UPDATE livros SET titulo = ?, autor = ?, lancamento = ? WHERE id = ?";

        Connection conn = null;
        PreparedStatement pstm = null;

        try { 
            //É aqui que faz a conexão com o banco
            conn= Conexao.getConexao();
            pstm = (PreparedStatement) conn.prepareStatement(sql);

            pstm.setString(1, livro.getTitulo());
            pstm.setString(2, livro.getAutor());
            pstm.setInt(3, livro.getLancamento());

            pstm.setInt(4, livro.getId());

            pstm.execute();
        } catch (Exception e) {
           e.printStackTrace();
            }finally{
                try{if(pstm!=null){
                    pstm.close();
                }
                if(conn!=null){
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void deleteByID(int id){
        String sql = ("DELETE FROM livros WHERE id = ?");
        Connection conn = null;
        PreparedStatement pstm = null;

        try{
            conn = Conexao.getConexao();
            pstm = (PreparedStatement) conn.prepareStatement(sql);
            pstm.setInt(1, id);

            pstm.execute();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try {
                if(pstm!=null){
                    pstm.close();
                }
                if(pstm!=null){
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static List<Livro> getLivros(){
        List <Livro> livros = new ArrayList<Livro>();
        
        String sql = "SELECT * FROM livros";

        PreparedStatement pstm = null;
        ResultSet rset = null;
        Connection conn = null;
        
        try{
            conn = Conexao.getConexao();
            pstm = (PreparedStatement) conn.prepareStatement(sql);
            rset = pstm.executeQuery();
            
            while (rset.next()) {
                Livro livro = new Livro();

                livro.setId(rset.getInt("id"));
                livro.setTitulo(rset.getString("titulo"));
                livro.setAutor(rset.getString("autor"));
                livro.setLancamento(rset.getInt("lancamento"));
                livros.add(livro);
            }
        }
    
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e.toString());
        }return livros;
    }
}
