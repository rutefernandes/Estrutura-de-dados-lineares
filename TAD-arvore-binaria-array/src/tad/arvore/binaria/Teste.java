package tad.arvore.binaria;

import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rute
 */
public class Teste {

    public static void main(String[] args) {
        ArvoreBinariaArray arvore = new ArvoreBinariaArray(6);
        arvore.adicionar(7);
        arvore.adicionar(9);
        arvore.adicionar(1);
        arvore.adicionar(-2);
        arvore.adicionar(2);
        arvore.adicionar(-1);
        arvore.adicionar(3);
        arvore.adicionar(-3);
        arvore.adicionar(4);
        
        System.out.println(arvore);
        
        No busca;
        try {
            busca = arvore.buscar(2);
            System.out.println(arvore.hasLeft(busca));
        } catch (NotFoundException ex) {
            ex.printStackTrace();
        }
        System.out.println(arvore.height());
    }
    
}