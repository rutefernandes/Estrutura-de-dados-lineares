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
        arvore.adicionar(5);
        arvore.adicionar(12);
        arvore.adicionar(2);
        arvore.adicionar(1);
        arvore.adicionar(9);
        arvore.adicionar(21);
        arvore.adicionar(19);
        arvore.adicionar(25);
        arvore.mostrar();
        No busca = arvore.buscar(5);
        arvore.remover(busca);
        arvore.mostrar();
    }
    
}
