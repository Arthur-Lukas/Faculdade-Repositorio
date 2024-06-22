package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import model.Ebook;
import model.Genero;

public class EbookDao {

	public static void cadastrarEbook( Ebook livro){
		String sql = "INSERT INTO ebooks (titulo, autor, lancamento, id_genero, paginas) VALUES (?,?,?,?,?)";	
		PreparedStatement ps = null;

		try {
			Connection conn = factory.Conexao.getConexao();
			ps = conn.prepareStatement(sql); 
			ps.setString(1, livro.titulo );
			ps.setString(2, livro.autor );
			ps.setInt(3, livro.lancamento );
			ps.setInt(4, livro.genero.getId() );
			ps.setInt(5, livro.paginas);
			ps.execute();
			//factory.Conexao.fecharConn( conn );
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.toString());
		}
	}

	public static void editarEbook(Ebook livro){
		String sql = "UPDATE ebooks SET titulo =  ? , autor = ? , lancamento = ?, id_genero =?, paginas =? WHERE id = ? ";	
		PreparedStatement ps = null;

		try {
			Connection conn = factory.Conexao.getConexao();
			ps = conn.prepareStatement(sql);
			ps.setString(1, livro.titulo );
			ps.setString(2, livro.autor );
			ps.setInt(3, livro.lancamento);
			ps.setInt(4, livro.genero.getId());
			ps.setInt(5, livro.id);
			ps.setInt(6, livro.paginas);
			ps.execute();
			factory.Conexao.fecharConn( conn );
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.toString());
		}
	}

	public static void excluirEbook( int idLivro ){
		String sql = "DELETE FROM ebooks WHERE id = ? ";	
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

	public static List<Ebook> getEbook(){
		List<Ebook> lista = new ArrayList<Ebook>();
		String sql = 	" SELECT l.id, l.titulo, l.autor, l.lancamento, g.id, g.nome, l.paginas " + 
                        " FROM ebooks l" + 
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

					Ebook liv = new Ebook();
					liv.id = rs.getInt(1);
					liv.titulo = rs.getString(2);
					liv.autor = rs.getString(3);
					liv.lancamento = rs.getInt(4);
					liv.genero = gen;
					liv.paginas = rs.getInt(6);
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