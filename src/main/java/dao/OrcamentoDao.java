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
import java.util.List;
import modelo.Orcamento;
import modelo.Produto;

/**
 *
 * @author Weslley Leocádio
 */
public class OrcamentoDao {

    private final Conexao con = new Conexao();

    private final String INSERTORCAMENTO = "INSERT INTO orcamento(id_orcamento, id_cliente, data_pedido, situacao) VALUES (?,?,?,?)";

    private final String UPDATEORCAMENTO = "UPDATE ORCAMENTO SET id_cliente = ? , data_pedido = ?, situacao = ? WHERE ID_ORCAMENTO = ?";

    private final String DELETEORCAMENTO = " DELETE FROM ORCAMENTO WHERE ID_ORCAMENTO = ?";

    private final String LISTORCAMENTO = "SELECT * FROM ORCAMENTO";

    private final String BUSCARORCAMENTO = "SELECT * FROM ORCAMENTO WHERE id_cliente = ?";

    private final String BUSCARULTIMOORCAMENTO = "SELECT ID_ORCAMENTO FROM ORCAMENTO ORDER BY ID_ORCAMENTO DESC";

    private final String PAGARORCAMENTO = "UPDATE orcamento SET situacao = 'PAGO' WHERE orcamento.ID_ORCAMENTO = ?;";

    public boolean pagarOrcamento(Orcamento u) {
        try {

            // CONECTA
            con.conecta();
            PreparedStatement preparaInstrucao;
            preparaInstrucao = con.getConexao().prepareStatement(PAGARORCAMENTO);

            // SETA OS VALORES DA INSTRUCAO
            // OBS: PASSA OS PARAMETROS NA ORDEM DAS ? DA INSTRUCAO
            preparaInstrucao.setInt(1, u.getId_orcamento());

            System.out.println(preparaInstrucao);
            preparaInstrucao.execute();
            System.out.println("pago");

            // DESCONECTA
            con.desconecta();

            return true;

        } catch (SQLException e) {
            return false;

        }
    }

    public boolean insertOrcamento(Orcamento u) {
         
      
        try {
            System.out.println("chegou");
            // CONECTA
            con.conecta();
            PreparedStatement preparaInstrucao;
            preparaInstrucao = con.getConexao().prepareStatement(INSERTORCAMENTO);

            // SETA OS VALORES DA INSTRUCAO
            // OBS: PASSA OS PARAMETROS NA ORDEM DAS ? DA INSTRUCAO
            preparaInstrucao.setInt(1, u.getId_orcamento());
            preparaInstrucao.setInt(2, u.getId_cliente());
            u.setData_pedido(new java.util.Date());
            java.sql.Date dataSql = new java.sql.Date(u.getData_pedido().getTime());
            preparaInstrucao.setDate(3, dataSql);
            preparaInstrucao.setString(4, u.getSituacao());

            System.out.println(preparaInstrucao);
            preparaInstrucao.execute();
            System.out.println("inseriu");
            // DESCONECTA
            con.desconecta();

            return true;

        } catch (SQLException e) {
            return false;

        }
        
      
    }

    public int getIdUltimoOrcamento() {
        try {
            // CONECTA
            con.conecta();
            PreparedStatement preparaInstrucao;
            preparaInstrucao = con.getConexao().prepareStatement(BUSCARULTIMOORCAMENTO);

            // EXECUTA A INSTRUCAO
            ResultSet rs = preparaInstrucao.executeQuery();

            //TRATA O RETORNO DA CONSULTA
            rs.next();
            int idUltimoOrcamento = rs.getInt(1);

            con.desconecta();

            return idUltimoOrcamento;

        } catch (SQLException e) {
            return 0;

        }
    }

    public boolean updateOrcamento(Orcamento u) {
        try {
            // CONECTA
            con.conecta();
            PreparedStatement preparaInstrucao;
            preparaInstrucao = con.getConexao().prepareStatement(INSERTORCAMENTO);
            // SETA OS VALORES DA INSTRUCAO
            // OBS: PASSA OS PARAMETROS NA ORDEM DAS ? DA INSTRUCAO

            preparaInstrucao.setInt(1, u.getId_cliente());
            u.setData(new java.util.Date());
            java.sql.Date dataSql = new java.sql.Date(u.getData_pedido().getTime());
            preparaInstrucao.setDate(2, dataSql);
            preparaInstrucao.setString(3, u.getSituacao());
            preparaInstrucao.setInt(4, u.getId_orcamento());
            // EXECUTA A INSTRUCAO
            preparaInstrucao.execute();

            // DESCONECTA
            con.desconecta();

            return true;

        } catch (SQLException e) {
            return false;

        }

    }

    public boolean deleteOrcamento(int u) {
        try {
            // CONECTA
            con.conecta();
            PreparedStatement preparaInstrucao;
            preparaInstrucao = con.getConexao().prepareStatement(DELETEORCAMENTO);

            // SETA OS VALORES DA INSTRUCAO
            // OBS: PASSA OS PARAMETROS NA ORDEM DAS ? DA INSTRUCAO
            preparaInstrucao.setInt(1, u);

            // EXECUTA A INSTRUCAOs
            preparaInstrucao.execute();

            // DESCONECTA
            con.desconecta();

            return true;

        } catch (SQLException e) {
            return false;

        }
    }

    public ArrayList<Orcamento> listOrcamento() {
        ArrayList<Orcamento> lista = new ArrayList<>();

        try {
            // CONECTA
            con.conecta();
            PreparedStatement preparaInstrucao;
            preparaInstrucao = con.getConexao().prepareStatement(LISTORCAMENTO);

            // EXECUTA A INSTRUCAO
            ResultSet rs = preparaInstrucao.executeQuery();

            //TRATA O RETORNO DA CONSULTA
            while (rs.next()) { //enquanto houver registro

                //ainda tem que criar oconstrutor
                Orcamento u = new Orcamento(rs.getInt("id_orcamento"), rs.getInt("id_cliente"), rs.getDate("data_pedido"), rs.getString("situacao"));                //lista.add(u); 
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

    public ArrayList<Orcamento> listOrcamentoCliente(int i) {
        ArrayList<Orcamento> lista = new ArrayList<>();

        try {
            // CONECTA
            con.conecta();
            PreparedStatement preparaInstrucao;
            preparaInstrucao = con.getConexao().prepareStatement(BUSCARORCAMENTO);
            preparaInstrucao.setInt(1, i);
            // EXECUTA A INSTRUCAO
            ResultSet rs = preparaInstrucao.executeQuery();

            //TRATA O RETORNO DA CONSULTA
            while (rs.next()) { //enquanto houver registro

                //ainda tem que criar oconstrutor
                Orcamento u = new Orcamento(rs.getInt("id_orcamento"), rs.getInt("id_cliente"), rs.getDate("data_pedido"), rs.getString("situacao"));                //lista.add(u); 
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

    //===================================tabela produto-orcamento====================================================
    private final String INSERTPRODUTO_ORCAMENTO = "INSERT INTO produto_orcamento (id_orcamento, id_produto) VALUES (?,?)";
    private final String UPDATEPRODUTO_ORCAMENTO = "UPDATE produto_orcamento SET id_orcamento = ? ,id_produto= ? WHERE ID_PRODUTO_ORCAMENTO = ?)";
    private final String DELETEPRODUTO_ORCAMENTO = " DELETE FROM produto_orcamento WHERE id_orcamento = ?";

    private final String LISTPRODUTO_ORCAMENTO = "SELECT id_produto FROM PRODUTO_ORCAMENTO where id_orcamento=?";

    public boolean insertProduto_Orcamento(int orc, int pro) {
        try {
            // CONECTA
            con.conecta();
            PreparedStatement preparaInstrucao;
            preparaInstrucao = con.getConexao().prepareStatement(INSERTPRODUTO_ORCAMENTO);
            // SETA OS VALORES DA INSTRUCAO
            // OBS: PASSA OS PARAMETROS NA ORDEM DAS ? DA INSTRUCAO
            preparaInstrucao.setInt(1, orc);
            preparaInstrucao.setInt(2, pro);

            // EXECUTA A INSTRUCAO
            preparaInstrucao.execute();
            System.out.println("pronto");
            // DESCONECTA
            con.desconecta();

            return true;

        } catch (SQLException e) {
            return false;

        }

    }
     public ArrayList<Produto> listProdutosOrcamento(int i) {
        ArrayList<Produto> lista = new ArrayList<>();

        try {
            // CONECTA
            con.conecta();
            PreparedStatement preparaInstrucao;
            preparaInstrucao = con.getConexao().prepareStatement(LISTPRODUTO_ORCAMENTO);
            preparaInstrucao.setInt(1, i);
            // EXECUTA A INSTRUCAO
            ResultSet rs = preparaInstrucao.executeQuery();

            //TRATA O RETORNO DA CONSULTA
            while (rs.next()) { //enquanto houver registro

                //ainda tem que criar oconstrutor
                Produto u = new Produto(rs.getInt("ID"),rs.getString("NOME"),rs.getString("DESCRICAO"),rs.getDouble("PRECO"));
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

}
