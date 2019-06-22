/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.ClienteDao;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import modelo.Cliente;

/**
 *
 * @author Weslley Leocádio
 */
@RequestScoped
@ManagedBean
public class CadastroClienteBean {
    private Cliente novoUsuario;

    public CadastroClienteBean() {
        this.novoUsuario = new Cliente();
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
            return null;
        }

    }

    public Cliente getNovoUsuario() {
        return novoUsuario;
    }

    public void setNovoUsuario(Cliente novoUsuario) {
        this.novoUsuario = novoUsuario;
    }

   
}
