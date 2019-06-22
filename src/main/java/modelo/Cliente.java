
package modelo;

import java.util.Date;
import java.util.Objects;


public class Cliente {

    private Integer id;
    private String nome;
    private String rua;
    private String numero, bairro;
    private String telefone;
    private String cidade;
    private String cpf;
    private Date data_nascimento;
    private String complemento;
    private Boolean administrador=false;
    private String login;
    private String senha;

    public Cliente() {
    }


    
  

    public Cliente(String nome, String rua, String numero, String bairro, String telefone, String cidade, String cpf, Date data_nascimento, String complemento, Boolean administrador, String login, String senha) {
        this.nome = nome;
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.telefone = telefone;
        this.cidade = cidade;
        this.cpf = cpf;
        this.data_nascimento = data_nascimento;
        this.complemento = complemento;
        this.administrador = administrador;
        this.login = login;
        this.senha = senha;
    }


   



    public Cliente(Integer id, String nome, String rua, String numero, String bairro, String telefone, String cidade, String cpf, Date data_nascimento, String complemento, Boolean administrador, String login, String senha) {
        this.id = id;
        this.nome = nome;
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.telefone = telefone;
        this.cidade = cidade;
        this.cpf = cpf;
        this.data_nascimento = data_nascimento;
        this.complemento = complemento;
        this.administrador = administrador;
        this.login = login;
        this.senha = senha;
    }

    

    public Cliente(Integer id, String nome, String rua, String numero, String bairro, String telefone, String cidade, String cpf) {
        this.id = id;
        this.nome = nome;
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.telefone = telefone;
        this.cidade = cidade;
        this.cpf = cpf;
      
    }

    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(Date data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public Boolean getAdministrador() {
        return administrador;
    }

    public void setAdministrador(Boolean administrador) {
        this.administrador = administrador;
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

    @Override
    public String toString() {
        return "Cliente{" + "id=" + id + ", nome=" + nome + ", rua=" + rua + ", numero=" + numero + ", bairro=" + bairro + ", telefone=" + telefone + ", cidade=" + cidade + ", cpf=" + cpf + ", data_nascimento=" + data_nascimento + ", complemento=" + complemento + ", administrador=" + administrador + ", login=" + login + ", senha=" + senha + '}';
    }

   

    
    

}
