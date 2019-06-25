
package modelo;

import java.util.Date;
import java.util.List;

public class Orcamento {
    private int id_orcamento;
    private int id_cliente;
    private Date data_pedido;
    private String situacao;
    private List<Produto> produtos;

    public Orcamento() {
    }

    public Orcamento(int id_cliente, Date data_pedido, String situacao) {
        this.id_cliente = id_cliente;
        this.data_pedido = data_pedido;
        this.situacao = situacao;
    }

    public Orcamento(int id_orcamento, int id_cliente, Date data_pedido, String situacao) {
        this.id_orcamento = id_orcamento;
        this.id_cliente = id_cliente;
        this.data_pedido = data_pedido;
        this.situacao = situacao;
    }

    public Orcamento(int id_orcamento, int id_cliente, Date data_pedido, String situacao, List<Produto> produtos) {
        this.id_orcamento = id_orcamento;
        this.id_cliente = id_cliente;
        this.data_pedido = data_pedido;
        this.situacao = situacao;
        this.produtos = produtos;
    }

    public Orcamento(int id_cliente, Date data_pedido, String situacao, List<Produto> produtos) {
        this.id_cliente = id_cliente;
        this.data_pedido = data_pedido;
        this.situacao = situacao;
        this.produtos = produtos;
    }
    

    public int getId_orcamento() {
        return id_orcamento;
    }

    public void setId_orcamento(int id_orcamento) {
        this.id_orcamento = id_orcamento;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public Date getData_pedido() {
        return data_pedido;
    }

    public void setData_pedido(Date data_pedido) {
        this.data_pedido = data_pedido;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }
    
    
    

    @Override
    public String toString() {
        return "Orcamento{" + "id_orcamento=" + id_orcamento + ", id_cliente=" + id_cliente + ", data_pedido=" + data_pedido + ", situacao=" + situacao + '}';
    }

    public void setData(Date date) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  
    
    
    
    
}
