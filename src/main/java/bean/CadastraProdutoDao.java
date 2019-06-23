/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.ProdutoDao;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import modelo.Produto;

/**
 *
 * @author Weslley Leocádio
 */
@RequestScoped
@ManagedBean
public class CadastraProdutoDao {

    private Produto novoProduto;
    private List<Produto> produtos= new ArrayList<>();
    ProdutoDao dao = new ProdutoDao();

    public CadastraProdutoDao() {
        this.novoProduto = new Produto();
                produtos = dao.listProduto();

         
    }

    public String cadastrar() {
        produtos = dao.listProduto();
        FacesContext context = FacesContext.getCurrentInstance();
        if (!produtos.contains(novoProduto)) {

            dao.insertProduto(novoProduto);

            FacesMessage mensagem = new FacesMessage("Cadastro realizado com sucesso !!");
            mensagem.setSeverity(FacesMessage.SEVERITY_INFO);
            context.addMessage(null, mensagem);
            novoProduto = new Produto();
            return "";

        } else {
            FacesMessage mensagem = new FacesMessage("Produto já cadastrado");
            mensagem.setSeverity(FacesMessage.SEVERITY_INFO);
            context.addMessage(null, mensagem);
            novoProduto = new Produto();

            return "";
        }

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
