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
import modelo.Orcamento;
import modelo.Produto;

/**
 *
 * @author Weslley Leocádio
 */
@ManagedBean
@javax.faces.bean.ApplicationScoped
public class ListaOrcamentosBean {
private List<Orcamento> orcamentos = new  ArrayList<>();

OrcamentoDao dao= new OrcamentoDao();
    Produto produto;
    
    
    
    
    
    
    
    public void realizarPagamento(Orcamento orc){
        dao.pagarOrcamento(orc);
        orcamentos = dao.listOrcamento();
    
    }
    public ListaOrcamentosBean() {
        orcamentos=dao.listOrcamento() ;
    }

    public List<Orcamento> getOrcamentos() {
        return orcamentos;
    }

    public void setOrcamentos(List<Orcamento> orcamentos) {
        this.orcamentos = orcamentos;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
    
    
    
    
}
