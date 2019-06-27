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
public class ListaOrcamentoClienteDao {
  private List<Orcamento> orcamentos = new  ArrayList<>();

OrcamentoDao dao= new OrcamentoDao();
    Produto produto;
    
    
    
    
    
    
    
    public void realizarPagamento(Orcamento orc){
        dao.pagarOrcamento(orc);
        orcamentos = dao.listOrcamento();
    
    }
    public ListaOrcamentoClienteDao() {
         FacesContext fc = FacesContext.getCurrentInstance();
        ExternalContext ec = fc.getExternalContext();
        HttpSession s = (HttpSession) ec.getSession(true);
        Cliente c = (Cliente) s.getAttribute("usuario-logado");
        orcamentos=dao.listOrcamentoCliente(c.getId()) ;
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
