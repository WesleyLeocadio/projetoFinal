/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Weslley Leocádio
 */
public class Conexao {
     private static final String USERNAME = "root";	
	private static final String PASSWORD = "";
	private static final String URL = "jdbc:mysql://localhost:3306/web?useTimezone=tru&serverTimezone=UTC";
	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private Connection conexao;
    
	

	public void conecta() {
		try {
			Class.forName(DRIVER); //Carrega o driver (inicializa um objeto da classe org.postgresql.Driver) 
			conexao = DriverManager.getConnection(URL, USERNAME,PASSWORD); //Cria a conexao
                        System.out.println("conectou ao banco");
		} catch (ClassNotFoundException | SQLException e) {
			System.err.println(e);
                        System.out.println("Nao conectou");
		}
	}
        
        //METODO QUE DESCONECTA O BANCO DE DADOS
	public void desconecta() {
		try {   
			conexao.close();//fecha a conexao
                        System.out.println("desconectou!");
		} catch (SQLException ex) {
			System.err.println(ex);
                        System.out.println("continua conectado");
		}
	}

	public Connection getConexao() {
		return conexao;
	}
        
    
}
