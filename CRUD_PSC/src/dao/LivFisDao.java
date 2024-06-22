package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import model.Genero;
import model.LivroFisico;

public class LivFisDao {

	public static void cadastrar( LivroFisico livro){
		String sql = "INSERT INTO livrosFisicos (titulo, autor, lancamento, id_genero, preco) VALUES (?,?,?,?,?)";	
		PreparedStatement ps = null;

		try {
			Connection conn = factory.Conexao.getConexao();
			ps = conn.prepareStatement(sql); 
			ps.setString(1, livro.titulo );
			ps.setString(2, livro.autor );
			ps.setInt(3, livro.lancamento );
			ps.setInt(4, livro.genero.getId() );
			ps.setDouble(5, livro.preco);
			ps.execute();
			//factory.Conexao.fecharConn( conn );
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.toString());
		}
	}

	public static void editar(LivroFisico livro){
		String sql = "UPDATE livrosFisicos SET titulo =  ? , autor = ? , lancamento = ?, id_genero =?, preco = ? WHERE id = ? ";	
		PreparedStatement ps = null;

		try {
			Connection conn = factory.Conexao.getConexao();
			ps = conn.prepareStatement(sql);
			ps.setString(1, livro.titulo );
			ps.setString(2, livro.autor );
			ps.setInt(3, livro.lancamento);
			ps.setInt(4, livro.genero.getId());
			ps.setInt(5, livro.id);
			ps.setDouble(5, livro.preco);
			ps.execute();
			factory.Conexao.fecharConn( conn );
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.toString());
		}
	}

	public static void excluirLiv( int idLivro ){
		String sql = "DELETE FROM livrosFisicos WHERE id = ? ";	
		PreparedStatement ps = null;
		try {
			Connection conn = factory.Conexao.getConexao();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, idLivro );
			ps.execute();
			factory.Conexao.fecharConn( conn );
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.toString());
		}
	}

	public static List<LivroFisico> getLivro(){

		List<LivroFisico> lista = new ArrayList<LivroFisico>();
		String sql = 	" SELECT l.id, l.titulo, l.autor, l.lancamento, l.preco, g.id, g.nome " + 
                        " FROM livrosFisicos l" + 
                        " INNER JOIN genero g ON g.id = l.id_genero" + 
                        " ORDER BY l.id ";	
		PreparedStatement ps = null;
		try {
			Connection conn = factory.Conexao.getConexao();
			ps = conn.prepareStatement(sql);
			ResultSet rs =  ps.executeQuery();
			if( rs != null ){
				while ( rs.next() ) {
					Genero gen = new Genero();
					gen.setId(rs.getInt( 5 ));
					gen.setNome(rs.getString( 6 ));

					LivroFisico liv = new LivroFisico();
					liv.id = rs.getInt(1);
					liv.titulo = rs.getString(2);
					liv.autor = rs.getString(3);
					liv.lancamento = rs.getInt(4);
					liv.preco = rs.getDouble(6);
					liv.genero = gen;
					lista.add(liv);
				}
			}			
			//factory.Conexao.fecharConn( conn );
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.toString());
		}
		return lista;
	}
}