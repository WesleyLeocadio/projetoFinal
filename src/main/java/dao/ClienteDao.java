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
import modelo.Cliente;

/**
 *
 * @author Weslley Leocádio
 */
public class ClienteDao {

    private final Conexao con = new Conexao();

    private final String INSERTCLIENTE = "INSERT INTO CLIENTE (nome, rua, numero, bairro, telefone, cidade, cpf, dataNascimento, complemento, administrador,login,senha) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";

    private final String UPDATECLIENTE = "UPDATE CLIENTE SET nome=?, rua = ?, numero = ?, bairro = ?, telefone = ?, cidade = ?, cpf = ?, dataNascimento = ?, complemento = ?, login =?, senha=? WHERE ID = ?";

    private final String DELETECLIENTE = " DELETE FROM CLIENTE WHERE ID = ?";
    private final String LISTCLIENTE = "SELECT * FROM CLIENTE";
    private final String LISTC = "SELECT * FROM CLIENTE WHERE ID = ?";

    private final String BUSCARCLIENTE = "SELECT * FROM CLIENTE WHERE UPPER(NOOME) LIKE ?";

    public boolean insertCliente(Cliente u) {
        try {
            // CONECTA

            con.conecta();
            PreparedStatement preparaInstrucao;
            preparaInstrucao = con.getConexao().prepareStatement(INSERTCLIENTE);
            preparaInstrucao.setString(1, u.getNome().toUpperCase());
            preparaInstrucao.setString(2, u.getRua().toUpperCase());
            preparaInstrucao.setString(3, u.getNumero().toUpperCase());
            preparaInstrucao.setString(4, u.getBairro().toUpperCase());
            preparaInstrucao.setString(5, u.getTelefone().toUpperCase());
            preparaInstrucao.setString(6, u.getCidade().toUpperCase());
            preparaInstrucao.setString(7, u.getCpf().toUpperCase());
            java.sql.Date dataSql = new java.sql.Date(u.getData_nascimento().getTime());
            preparaInstrucao.setDate(8, dataSql);
            preparaInstrucao.setString(9, u.getComplemento().toUpperCase());
            preparaInstrucao.setBoolean(10, u.getAdministrador());

            preparaInstrucao.setString(11, u.getLogin().toUpperCase());
            preparaInstrucao.setString(12,u.getSenha().toUpperCase() );

            // EXECUTA A INSTRUCAO
            preparaInstrucao.execute();
            System.out.println("foi");
            // DESCONECTA
            con.desconecta();

            return true;

        } catch (SQLException e) {
            return false;

        }

    }

    public boolean updateCliente(Cliente u) {
        try {
            System.out.println(" Objeto "+u.toString());
            con.conecta();
            PreparedStatement preparaInstrucao;
            preparaInstrucao = con.getConexao().prepareStatement(UPDATECLIENTE);
            preparaInstrucao.setString(1, u.getNome().toUpperCase());
            preparaInstrucao.setString(2, u.getRua().toUpperCase());
            preparaInstrucao.setString(3, u.getNumero().toUpperCase());
            preparaInstrucao.setString(4, u.getBairro().toUpperCase());
            preparaInstrucao.setString(5, u.getTelefone().toUpperCase());
            preparaInstrucao.setString(6, u.getCidade().toUpperCase());
            preparaInstrucao.setString(7, u.getCpf().toUpperCase());
            java.sql.Date dataSql = new java.sql.Date(u.getData_nascimento().getTime());

            preparaInstrucao.setDate(8, dataSql);
            preparaInstrucao.setString(9, u.getComplemento().toUpperCase());
               preparaInstrucao.setString(10, u.getLogin().toUpperCase());
            preparaInstrucao.setString(11,u.getSenha().toUpperCase() );
           preparaInstrucao.setInt(12, u.getId());

               
            // EXECUTA A INSTRUCAO
            System.out.println(preparaInstrucao);
            preparaInstrucao.execute();
            System.out.println("=====================");
            // DESCONECTA
            con.desconecta();

            return true;

        } catch (SQLException e) {
            return false;

        }

    }

    public boolean deleteCliente(int a) {
        try {
            // CONECTA
            con.conecta();
            PreparedStatement preparaInstrucao;
            preparaInstrucao = con.getConexao().prepareStatement(DELETECLIENTE);

            // SETA OS VALORES DA INSTRUCAO
            // OBS: PASSA OS PARAMETROS NA ORDEM DAS ? DA INSTRUCAO
            preparaInstrucao.setInt(1, a);

            // EXECUTA A INSTRUCAO
            preparaInstrucao.execute();
            System.out.println("excluiu");
            // DESCONECTA

            con.desconecta();

            return true;

        } catch (SQLException e) {
            System.out.println("erro ao excluir cliente");
            return false;

        }
    }

    public ArrayList<Cliente> listCliente() {
        ArrayList<Cliente> lista = new ArrayList<>();

        try {
            // CONECTA
            con.conecta();
            PreparedStatement preparaInstrucao;
            preparaInstrucao = con.getConexao().prepareStatement(LISTCLIENTE);

            // EXECUTA A INSTRUCAO
            ResultSet rs = preparaInstrucao.executeQuery();
            //TRATA O RETORNO DA CONSULTA
            while (rs.next()) { //enquanto houver registro
                Cliente u = new Cliente(rs.getInt("id"), rs.getString("nome"), rs.getString("rua"), rs.getString("numero"), rs.getString("bairro"), rs.getString("telefone"), rs.getString("cidade"), rs.getString("cpf"), rs.getDate("dataNascimento"), rs.getString("complemento"), rs.getBoolean("administrador"), rs.getString("login"), rs.getString("senha"));
                System.out.println(u);
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

    public Cliente listC(Cliente a) {

        try {
            // CONECTA
            con.conecta();
            PreparedStatement preparaInstrucao;
            preparaInstrucao = con.getConexao().prepareStatement(LISTC);
            preparaInstrucao.setInt(1, a.getId());

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
