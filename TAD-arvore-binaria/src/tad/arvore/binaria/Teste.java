package tad.arvore.binaria;

import java.util.Iterator;

/**
 *
 * @author rute
 */
public class Teste {

    public static void main(String[] args) {
        ArvoreBinaria arvore = new ArvoreBinaria(6);
        arvore.adicionar(7);
        arvore.adicionar(9);
        arvore.adicionar(1);
        arvore.adicionar(2);
        arvore.adicionar(3);
        arvore.adicionar(4);
        No busca = arvore.buscar(2);
        System.out.println(arvore.hasLeft(busca));
        System.out.println(arvore.height());
    }
    
}
