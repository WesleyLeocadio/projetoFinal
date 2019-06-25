/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testes;

import dao.OrcamentoDao;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import modelo.Orcamento;

/**
 *
 * @author Weslley Leocádio
 */
public class testeOrcamento {
    public static void main(String[] args) {
        OrcamentoDao dao = new OrcamentoDao();
         Date n = new Date();
        
        java.sql.Date t = new java.sql.Date(n.getTime());

        Orcamento orc = new Orcamento( 1, t, "pendente");
            List<Orcamento> lista= dao.listOrcamentoCliente(1);
            for (int i = 0; i < lista.size(); i++) {
                System.out.println(i);
        }
        // dao.insertOrcamento(orc);
    }
          
}
