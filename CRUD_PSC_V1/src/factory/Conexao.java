package factory;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

adicionei uma linha
public class Conexao {

    private static final String URL = "jdbc:mysql://localhost:3306/db_biblioteca";
    private static final String  USER = "root";
    private static final String PASSWORD = "";

    public static Connection getConexao()throws Exception{
    Class.forName("com.mysql.jdbc.Driver");
    Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
        return connection;
    }
    
    public static void main( String[]args )throws Exception{
        Connection conn = getConexao();
		if( conn != null ){
            JOptionPane.showMessageDialog(null, "Conexão obtida");
            conn.close();
			}
		}
	}

