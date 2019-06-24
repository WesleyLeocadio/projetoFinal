/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testes;

import dao.ProdutoDao;
import java.util.List;
import modelo.Produto;

/**
 *
 * @author Weslley Leocádio
 */
public class TesteProduto {
    public static void main(String[] args) {
        
    
    ProdutoDao dao =  new ProdutoDao();
    Produto p = new Produto(5,"Porta", "Porta com 20x20", 10000, 2);
    dao.updateProduto(p);
    }
    
}
