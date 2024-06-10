package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import model.Genero;
import model.Livro;

public class LivroDao {

	public static void cadastrar( Livro livro){
		String sql = "INSERT INTO livros (titulo, autor, lancamento, id_genero) VALUES ( ? , ? , ?, ? )";	
		PreparedStatement ps = null;
		try {
			Connection conn = factory.Conexao.getConexao();
			ps = conn.prepareStatement(sql); 
			ps.setString(1, livro.titulo );
			ps.setString(2, livro.autor );
			ps.setInt(3, livro.lancamento );
			ps.setInt(4, livro.genero.id );
			ps.execute();
			//factory.Conexao.fecharConn( conn );
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.toString());
		}
	}

	public static void editar(Livro livro){
		String sql = "UPDATE livros SET titulo =  ? , autor = ? , lancamento = ?, id_genero =? WHERE id = ? ";	
		PreparedStatement ps = null;
		try {
			Connection conn = factory.Conexao.getConexao();
			ps = conn.prepareStatement(sql);
			ps.setString(1, livro.titulo );
			ps.setString(2, livro.autor );
			ps.setInt(3, livro.lancamento);
			ps.setInt(4, livro.genero.id);
			ps.execute();
			factory.Conexao.fecharConn( conn );
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.toString());
		}
	}

	public static void excluir( int idLivro ){
		String sql = "DELETE FROM cliente WHERE id = ? ";	
		PreparedStatement ps = null;
		try {
			Connection conn = Conexao.getConexao();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, idLivro );
			ps.execute();
			factory.Conexao.fecharConn( conn );
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.toString());
		}
	}

	public static List<Livro> getLivro(){
		List<Livro> lista = new ArrayList<Livro>();
		String sql = 	" SELECT l.id, l.titulo, l.autor, l.lancamento, g.id, g.nome " + 
                        " FROM livros l" + 
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
					gen.id = rs.getInt( 5 );
					gen.nomeGe = rs.getString( 6 );

					Livro liv = new Livro();
					liv.id = rs.getInt(1);
					liv.titulo = rs.getString(2);
					liv.autor = rs.getString(3);
					liv.lancamento = rs.getInt(4);
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