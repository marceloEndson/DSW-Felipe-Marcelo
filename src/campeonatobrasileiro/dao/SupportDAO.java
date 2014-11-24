package campeonatobrasileiro.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class SupportDAO {

	public static Connection getConnection()
	{	
		try
		{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost/campeonatobrasileiro", "root", "123456");
			conexao.setCatalog("campeonatobrasileiro");
			return conexao;
			
		} catch (SQLException e)
		{
			System.out.println("N�o foi poss�vel estabelecer uma conex�o com o banco de dados - erro de SQL");
			System.out.println(e.getMessage());
			return null;
		} catch (ClassNotFoundException e)
		{
			System.out.println("N�o foi poss�vel estabelecer uma conex�o com o banco de dados - driver n�o encontrado");
			return null;
		} catch (InstantiationException e)
		{
			System.out.println("N�o foi poss�vel estabelecer uma conex�o com o banco de dados - erro de instancia��o do driver");
			return null;
		} catch (IllegalAccessException e)
		{
			System.out.println("N�o foi poss�vel estabelecer uma conex�o com o banco de dados - acesso ilegal no driver");
			return null;
		}
	}
	
	public static void log(String mensagem)
	{
		System.out.println(mensagem);
	}
	
}