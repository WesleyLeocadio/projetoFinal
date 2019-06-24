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
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import modelo.Cliente;
import modelo.Produto;

/**
 *
 * @author Weslley Leocádio
 */
@RequestScoped
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
         ClienteDao cliente = new ClienteDao();
        List<Cliente> clientes = cliente.listCliente();

        if (!clientes.contains(novoUsuario)) {
            cliente.insertCliente(novoUsuario);
            
            FacesContext context = FacesContext.getCurrentInstance();
            FacesMessage mensagem = new FacesMessage("Cadastro realizado com sucesso !!");
            mensagem.setSeverity(FacesMessage.SEVERITY_INFO);
            context.addMessage(null, mensagem);

            return "index";

        } else {
            FacesContext context = FacesContext.getCurrentInstance();
            FacesMessage mensagem = new FacesMessage("Cliente já cadastrado !!");
            mensagem.setSeverity(FacesMessage.SEVERITY_INFO);
            context.addMessage(null, mensagem);
            return null;
        }

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

   
}
