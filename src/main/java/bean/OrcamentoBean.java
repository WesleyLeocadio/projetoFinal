/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import modelo.Cliente;
import modelo.Produto;

/**
 *
 * @author Weslley Leocádio
 */
@ManagedBean
@javax.faces.bean.ApplicationScoped
public class OrcamentoBean {
    
        private List<Produto> carrinho ;
        Produto produto ;

    public OrcamentoBean() {
        carrinho= new ArrayList<>();
        produto= new Produto();
    }

    public void adicionar(Produto p){
    carrinho.add(p);
    produto= new Produto();
//    FacesContext fc = FacesContext . getCurrentInstance () ;
//ExternalContext ec = fc . getExternalContext () ;
//HttpSession s = ( HttpSession ) ec . getSession ( true ) ;
// Cliente c=(Cliente) s.getAttribute("admin-logado") ;
//        System.out.println(c.toString());
    
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
