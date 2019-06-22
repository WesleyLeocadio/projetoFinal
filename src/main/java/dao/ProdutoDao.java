/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexao.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Produto;

/**
 *
 * @author Weslley Leocádio
 */
public class ProdutoDao {
    private final Conexao con = new Conexao();
    
   
    private final String INSERTPRODUTO = "INSERT INTO PRODUTO (NOME,DESCRICAO, PRECO, QUANTIDADE) VALUES (?,?,?,?)";
    
    private final String UPDATEPRODUTO = "UPDATE PRODUTO SET NOME= ?,DESCRICAO= ?,PRECO= ? ,QUANTIDADE=? WHERE ID = ?";

    private final String DELETEPRODUTO = " DELETE FROM PRODUTO WHERE ID = ?";
    
    private final String LISTPRODUTO= "SELECT * FROM PRODUTO";
    
    private final String LISTP = "SELECT * FROM PRODUTO WHERE ID = ?";
    
    private final String UPDATEQUANTIDADE = "UPDATE PRODUTO SET QUANTIDADE = ? WHERE ID = ?";
   

    private final String BUSCARPRODUTO = "SELECT * FROM PRODUTO WHERE UPPER(NOOME) LIKE ?";
    
    public boolean insertProduto(Produto u) {
		try {
			// CONECTA
			con.conecta();
				PreparedStatement preparaInstrucao;
			preparaInstrucao = con.getConexao().prepareStatement(INSERTPRODUTO);

			// SETA OS VALORES DA INSTRUCAO
			// OBS: PASSA OS PARAMETROS NA ORDEM DAS ? DA INSTRUCAO
			preparaInstrucao.setString(1, u.getNome().toUpperCase());
			preparaInstrucao.setString(2, u.getDescricao().toUpperCase());
			preparaInstrucao.setDouble(3, u.getPreco());
                        preparaInstrucao.setInt(4, u.getQuantidade());
			

			// EXECUTA A INSTRUCAO
			preparaInstrucao.execute();
                        System.out.println("add produto");
			// DESCONECTA
			con.desconecta();
			
			return true;

		} catch (SQLException e) {
			return false;

		}
                
    
    }
    public boolean updateProduto(Produto u) {
		try {
			con.conecta();
                        PreparedStatement preparaInstrucao;
			preparaInstrucao = con.getConexao().prepareStatement(UPDATEPRODUTO);
                        preparaInstrucao.setString(1, u.getNome().toUpperCase());
			preparaInstrucao.setString(2, u.getDescricao().toUpperCase());
			preparaInstrucao.setDouble(3, u.getPreco());
                        preparaInstrucao.setInt(4, u.getQuantidade());
			preparaInstrucao.setInt(5, u.getId_produto());
                        
			preparaInstrucao.execute();
                        System.out.println("atualizaou");

			con.desconecta();
			
			return true;

		} catch (SQLException e) {
			return false;

		}
                
    
    }
    public boolean updateQuantidade(int u, int id) {
		try {
			// CONECTA
			con.conecta();
                        PreparedStatement preparaInstrucao;
			preparaInstrucao = con.getConexao().prepareStatement(UPDATEQUANTIDADE);
			// SETA OS VALORES DA INSTRUCAO
			// OBS: PASSA OS PARAMETROS NA ORDEM DAS ? DA INSTRUCAO
			preparaInstrucao.setInt(1, u);
    			preparaInstrucao.setInt(2, id);
                        
			// EXECUTA A INSTRUCAO
			preparaInstrucao.execute();
                        System.out.println("atualizaou a quantidade");

			// DESCONECTA
			con.desconecta();
			
			return true;

		} catch (SQLException e) {
			return false;

		}
                
    
    }
    public boolean deleteProduto(int u) {
		try {
			// CONECTA
			con.conecta();
			PreparedStatement preparaInstrucao;
			preparaInstrucao = con.getConexao().prepareStatement(DELETEPRODUTO);

			// SETA OS VALORES DA INSTRUCAO
			// OBS: PASSA OS PARAMETROS NA ORDEM DAS ? DA INSTRUCAO
			preparaInstrucao.setInt(1, u);

			// EXECUTA A INSTRUCAO
			preparaInstrucao.execute();

			// DESCONECTA
			con.desconecta();
			
			return true;

		} catch (SQLException e) {
			return false;

		}
	}
    
    public ArrayList<Produto> listProduto() {
		ArrayList<Produto> lista = new ArrayList<>(); 

		try {
			// CONECTA
			con.conecta();
			PreparedStatement preparaInstrucao;
			preparaInstrucao = con.getConexao().prepareStatement(LISTPRODUTO); 
			
			// EXECUTA A INSTRUCAO
			ResultSet rs = preparaInstrucao.executeQuery(); 
			
			//TRATA O RETORNO DA CONSULTA
			while (rs.next()) { //enquanto houver registro
				Produto u = new Produto(rs.getInt("ID"),rs.getString("NOME"),rs.getString("DESCRICAO"),rs.getDouble("PRECO"),rs.getInt("QUANTIDADE"));
				
                                lista.add(u); 
			}
			// DESCONECTA
			con.desconecta();
		} catch (SQLException e) {
                     System.out.println(e.getMessage());
		}
		///////////////////Collections.sort(lista);/////////////////////////
		return lista;
	}
    
    
    
      public Produto listP( Produto a) {
         
               try {
            // CONECTA
            con.conecta(); 
            PreparedStatement preparaInstrucao;
            preparaInstrucao = con.getConexao().prepareStatement(LISTP);
             preparaInstrucao.setInt(1, a.getId_produto());

            // EXECUTA A INSTRUCAO
           preparaInstrucao.executeQuery(); 

             
            // DESCONECTA
            con.desconecta();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
             
        ///////////////////Collections.sort(lista);/////////////////////////
        return a;
    }
}
