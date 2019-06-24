/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.ClienteDao;
import dao.ProdutoDao;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import modelo.Cliente;
import modelo.Produto;

/**
 *
 * @author Weslley Leocádio
 */
@ViewScoped
@ManagedBean
public class CadastroClienteBean {

    private Cliente novoUsuario;
    private List<Cliente> clientes = new ArrayList<>();
    ClienteDao dao = new ClienteDao();

    public CadastroClienteBean() {
        this.novoUsuario = new Cliente();
        clientes = dao.listCliente();
    }

    public String cadastrar() {

        dao.insertCliente(novoUsuario);

        clientes = dao.listCliente();
        novoUsuario = new Cliente();

        FacesContext context = FacesContext.getCurrentInstance();
        FacesMessage mensagem = new FacesMessage("Cadastro realizado com sucesso !!");
        mensagem.setSeverity(FacesMessage.SEVERITY_INFO);
        context.addMessage(null, mensagem);

        return "index";

    }

    public void inicializarCampos(Cliente p) {
        novoUsuario = p;
        gamb = p.getId();
        System.out.println(gamb);

    }
    public int gamb = 0;

    public String atualizar() {
        novoUsuario.setId(gamb);

        dao.updateCliente(novoUsuario);
        novoUsuario = new Cliente();
        clientes = dao.listCliente();
        gamb = 0;
        return "";
    }
    public void deletar(Cliente p){
     dao.deleteCliente(p.getId());
      novoUsuario = new Cliente();
        clientes = dao.listCliente();
        gamb = 0;
     
    }

    public void limpar() {
        novoUsuario = new Cliente();
    }

    public Cliente getNovoUsuario() {
        return novoUsuario;
    }

    public void setNovoUsuario(Cliente novoUsuario) {
        this.novoUsuario = novoUsuario;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public int getGamb() {
        return gamb;
    }

    public void setGamb(int gamb) {
        this.gamb = gamb;
    }

}
