package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import model.Genero;

public class GeneroDao {

    public static void cadastrar (String nome){
        String sql = "INSERT INTO genero (nome) VALUES (?)";
        PreparedStatement ps= null;//Esse comando é pra 'simular' a janela do mysql aonde nos manipulamos os códigos

        try {
            Connection conn = factory.Conexao.getConexao();
            ps = conn.prepareStatement(sql);
            ps.setString(1, nome);
            ps.execute();
            factory.Conexao.fecharConn(conn);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,e.toString());
        }
    }

    public static void excluir (int  idGenero){
        String sql = "DELETE FROM genero WHERE id = ?";
        PreparedStatement ps= null;//Esse comando é pra 'simular' a janela do mysql aonde nos manipulamos os códigos

        try {
            Connection conn = factory.Conexao.getConexao();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, idGenero);
            ps.execute();
            factory.Conexao.fecharConn(conn);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,e.toString());
        }
    }

    public static List<Genero>getGenero(){
        List<Genero> lista = new ArrayList<Genero>();
        
        String sql = "SELECT * FROM genero ORDER BY id";
        PreparedStatement ps= null;

        try {
            Connection conn = factory.Conexao.getConexao();
            ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            if (rs!=null) {
                while(rs.next()){
                    Genero ge = new Genero();
                    ge.id = rs.getInt(1);
                    ge.nomeGe = rs.getString(2);
                    lista.add(ge);
                }
            }
            factory.Conexao.fecharConn(conn);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,e.toString());
        }
        return lista;
    }
}