/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tad.dicionario;

import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tiago
 */
public class Teste {
    public static void main(String[] args) {
        HashTableLP ht = new HashTableLP();
        
        try {
            ht.insertItem(1, "Opa");
            ht.insertItem(2, "Meu");
            ht.insertItem(3, "Bom");
            ht.insertItem(98, "Noventa e Oito");
        } catch (TabelaCheiaException ex) {
            ex.printStackTrace();
        }
        
        try {
//            System.out.println(ht.findElement(1));
//            System.out.println(ht.findElement(2));
//            System.out.println(ht.findElement(3));
//            System.out.println(ht.findElement(98));
            
            Item i = ht.removeElement(2);
//            
//            System.out.println(i.chave);
//            System.out.println(i.valor);
            
//            
//            System.out.println(ht.findElement(98));
//            System.out.println(ht.findElement(3));
//            System.out.println(ht.findElement(2));
        } catch (ItemNaoEncontradoException ex) {
//            ex.printStackTrace();
        }
        
        try {
            ht.insertItem(98, "Noventa e Oito");
        } catch (TabelaCheiaException ex) {
            Logger.getLogger(Teste.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Iterator itr = ht.elements();
        
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
    }
}
