/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.OrcamentoDao;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import modelo.Cliente;
import modelo.Orcamento;
import modelo.Produto;

/**
 *
 * @author Weslley Leocádio
 */
@ManagedBean
@javax.faces.bean.ApplicationScoped
public class OrcamentoBean {

    private List<Produto> carrinho;
    Produto produto;

    public OrcamentoBean() {
        carrinho = new ArrayList<>();
        produto = new Produto();
    }

    public void adicionar(Produto p) {
        carrinho.add(p);
        produto = new Produto();
    }
    public void removerCarrinho(Produto p){
        carrinho.remove(p);
        
    }

    public void finalizar() {
        FacesContext fc = FacesContext.getCurrentInstance();
        ExternalContext ec = fc.getExternalContext();
        HttpSession s = (HttpSession) ec.getSession(true);
        Cliente c = (Cliente) s.getAttribute("admin-logado");
        //System.out.println(c.toString());

        OrcamentoDao a = new OrcamentoDao();
        Orcamento orc = new Orcamento(c.getId());

        a.insertOrcamento(orc);
        for (int i = 0; i < carrinho.size(); i++) {
            a.insertProduto_Orcamento(a.getIdUltimoOrcamento(), carrinho.get(i).getId_produto());

        }
        carrinho = new ArrayList<>();
        

    }

    public List<Produto> getCarrinho() {
        return carrinho;
    }

    public void setCarrinho(List<Produto> carrinho) {
        this.carrinho = carrinho;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

}
