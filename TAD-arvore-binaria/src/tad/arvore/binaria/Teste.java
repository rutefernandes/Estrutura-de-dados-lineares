package tad.arvore.binaria;

import java.util.Iterator;

/**
 *
 * @author rute
 */
public class Teste {

    public static void main(String[] args) {
        ArvoreBinaria arvore = new ArvoreBinaria();
        //5 12 2 9 21 19 25 2 
        arvore.adicionar(5);
        arvore.adicionar(12);
        arvore.adicionar(2);
        arvore.adicionar(1);
        arvore.adicionar(9);
        arvore.adicionar(21);
        arvore.adicionar(19);
        arvore.adicionar(25);
        No busca = arvore.buscar(12);
        System.out.println(arvore.remover(busca));
        arvore.mostrar();
        Iterator v = arvore.inOrder();
        while(v.hasNext()) {
            Object element = v.next();
            System.out.print(element + " ");
        }
    }
    
}
