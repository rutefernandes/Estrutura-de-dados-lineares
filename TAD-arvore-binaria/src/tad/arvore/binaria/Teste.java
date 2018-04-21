package tad.arvore.binaria;

/**
 *
 * @author rute
 */
public class Teste {

    public static void main(String[] args) {
        ArvoreBinaria arvore = new ArvoreBinaria(4);
        arvore.adicionar(7);
        arvore.adicionar(6); 
        arvore.adicionar(5);
        arvore.adicionar(8);
        No noBusca = arvore.buscar(6);
        System.out.println(arvore.leftChild(noBusca));
    }
    
}
