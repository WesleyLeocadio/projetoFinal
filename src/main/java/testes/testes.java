/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testes;

import conexao.Conexao;
import dao.ClienteDao;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import modelo.Cliente;

/**
 *
 * @author Weslley Leocádio
 */
public class testes {
    
    
    
    public static void main(String[] args) {
        ClienteDao dao =  new ClienteDao();
   

        Cliente a = new Cliente("Pronto", "sao raimundo", "5", "principal", "21232323", "ielmo marinho", "120.888.794-71", "bola",false,"admin","12345");
        dao.insertCliente(a);
       // dao.insertCliente(a);
       // dao.insertCliente(a);

       // dao.updateCliente(a);
        //dao.deleteCliente(2);
      ArrayList<Cliente> agenda= dao.listCliente();
        for (int i = 0; i <agenda.size(); i++) {
            System.out.println(i);
        }
                
    }
}
