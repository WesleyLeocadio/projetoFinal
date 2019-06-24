/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.ProdutoDao;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.application.FacesMessage;
import modelo.Produto;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Weslley Leocádio
 */
@ManagedBean
@javax.faces.bean.ApplicationScoped
public class CadastraProdutoDao {

    private Produto novoProduto;
    private List<Produto> produtos = new ArrayList<>();
    ProdutoDao dao = new ProdutoDao();

    public CadastraProdutoDao() {
        this.novoProduto = new Produto();
        produtos = dao.listProduto();

    }

    public String cadastrar() {

        dao.insertProduto(novoProduto);
        produtos = dao.listProduto();
        novoProduto = new Produto();
        return "";

    }

    public void deletar(int id) {

        dao.deleteProduto(id);
        produtos = dao.listProduto();
        novoProduto = new Produto();
    }

    public String iniciar(Produto p) {

        novoProduto = p;
        System.out.println(novoProduto.getNome());
        return "AtualizarProduto?faces-redirect=true";

    }

    public String  atualizar() {
        Produto n =  new Produto(novoProduto.getId_produto(),novoProduto.getNome(),novoProduto.getDescricao(), novoProduto.getPreco(), novoProduto.getQuantidade());
        dao.updateProduto(n);  
        produtos = dao.listProduto();
        novoProduto = new Produto();
        return "cadastrarProduto?faces-redirect=true";
    }

    public String reinit() {
        novoProduto = new Produto();

        return null;
    }

    public Produto getNovoProduto() {
        return novoProduto;
    }

    public void setNovoProduto(Produto novoProduto) {
        this.novoProduto = novoProduto;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

}
