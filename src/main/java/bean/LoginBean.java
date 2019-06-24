/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.ClienteDao;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import modelo.Cliente;

/**
 *
 * @author Weslley Leocádio
 */
@RequestScoped
@ManagedBean
public class LoginBean {

    private String login;
    private String senha;

    public String autentica() {

        FacesContext context = FacesContext.getCurrentInstance();

        ClienteDao cliente = new ClienteDao();
       

        for (Cliente u : cliente.listCliente()) {

            if (u.getLogin().equals(this.getLogin())) {
                if (u.getSenha().equals(this.getSenha())) {
                    if (u.getAdministrador() == true) {
                        ExternalContext ec = context.getExternalContext();
                        HttpSession s = (HttpSession) ec.getSession(true);
                        s.setAttribute("admin-logado", u);
                        System.out.println("usuario é adm");
                        return "/administracao/principal?faces-redirect=true";
                    } else {
                        ExternalContext ec = context.getExternalContext();
                        HttpSession s = (HttpSession) ec.getSession(true);
                        s.setAttribute("usuario-logado", u);
                        System.out.println("usuario nao é adm");
                        return "/clientes/principal?faces-redirect=true";
                    }

                }
            }
           
        }
            FacesMessage mensagem = new FacesMessage("Usuario/senha invalidos!");
            mensagem.setSeverity(FacesMessage.SEVERITY_ERROR);
            context.addMessage(null, mensagem);
            
            return null;

    }

    public String sair() {
        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext ec = context.getExternalContext();
        HttpSession s = (HttpSession) ec.getSession(true);
        s.invalidate();
        return "/index?faces-redirect=true";
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}
