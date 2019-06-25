/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Weslley Leocádio
 */
public class Produto {
    
    private int id_produto;
    private String nome;
    private String descricao;
    private double preco;


    public Produto() {
    }

    public Produto(String nome, String descricao, double preco) {
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        
    }

    public Produto(int id_produto, String nome, String descricao, double preco) {
        this.id_produto = id_produto;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        
    }

    public int getId_produto() {
        return id_produto;
    }

    public void setId_produto(int id_produto) {
        this.id_produto = id_produto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }



    @Override
    public String toString() {
        return "Produto{" + "id_produto=" + id_produto + ", nome=" + nome + ", descricao=" + descricao + ", preco=" + preco+'}';
    }
    
}
