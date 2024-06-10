package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import model.Cidade;
import model.Cliente;

public class ClienteDAO {

	public static void cadastrar( Cliente cliente){
		String sql = "INSERT INTO cliente (nome, endereco, codCidade) VALUES ( ? , ? , ? )";	
		PreparedStatement ps = null;
		try {
			Connection conn = Conexao.getConexao();
			ps = conn.prepareStatement(sql);
			ps.setString(1, cliente.nome );
			ps.setString(2, cliente.endereco );
			ps.setInt(3, cliente.cidade.id );
			ps.execute();
			//Conexao.fecharConn( conn );
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.toString());
		}
	}

	public static void editar(Cliente cliente){
		String sql = "UPDATE cliente SET nome =  ? , endereco = ? , codCidade = ? WHERE id = ? ";	
		PreparedStatement ps = null;
		try {
			Connection conn = Conexao.getConexao();
			ps = conn.prepareStatement(sql);
			ps.setString(1, cliente.nome );
			ps.setString(2, cliente.endereco );
			ps.setInt(3, cliente.cidade.id);
			ps.setInt(4, cliente.id );
			ps.execute();
			Conexao.fecharConn( conn );
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.toString());
		}
	}

	public static void excluir( int idCliente ){
		String sql = "DELETE FROM cliente WHERE id = ? ";	
		PreparedStatement ps = null;
		try {
			Connection conn = Conexao.getConexao();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, idCliente );
			ps.execute();
			//Conexao.fecharConn( conn );
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.toString());
		}
	}

	public static List<Cliente> getClientes(){
		List<Cliente> lista = new ArrayList<Cliente>();
		String sql = 	" SELECT p.id, p.nome, p.endereco, c.id, c.nome  " + 
				" FROM cliente p  " + 
				" INNER JOIN cidade c ON c.id = p.codCidade " + 
				" ORDER BY p.nome ";	
		PreparedStatement ps = null;
		try {
			Connection conn = Conexao.getConexao();
			ps = conn.prepareStatement(sql);
			ResultSet rs =  ps.executeQuery();
			if( rs != null ){
				while ( rs.next() ) {
					Cidade cid = new Cidade();
					cid.id = rs.getInt( 4 );
					cid.nome = rs.getString( 5 );

					Cliente cli = new Cliente();
					cli.id = rs.getInt(1);
					cli.nome = rs.getString(2);
					cli.endereco = rs.getString(3);
					cli.cidade = cid;
					lista.add(cli);
				}
			}			
			//Conexao.fecharConn( conn );
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.toString());
		}
		return lista;
	}
}