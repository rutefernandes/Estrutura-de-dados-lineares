/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dayan
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Arvore arvore = new Arvore();
        arvore.inserir(new Elemento(10));
        arvore.inserir(new Elemento(5));
        arvore.inserir(new Elemento(4));
        arvore.inserir(new Elemento(3));
        arvore.inserir(new Elemento(8));
        arvore.inserir(new Elemento(12));
        arvore.inserir(new Elemento(15));
        arvore.inserir(new Elemento(18));
        //arvore.inserir(new Elemento(20));
        
        Integer[] recebe = new Integer [20];
        //System.out.println(arvore.getEsq().getPosicao());
        //System.out.println(arvore.getEsq().getDir().getPosicao());
         //System.out.println(arvore.getEsq().getEsq().getPosicao());
        //System.out.println(arvore.getDir().getPosicao());
        recebe = arvore.getElementos();
        //Elemento elemento = new Elemento(5);
        //recebe[1] = elemento.getValor();
        //System.out.println(recebe[1]);
        //System.out.println(recebe[2]);

        for (int i = 1; i < recebe.length; i++) {
            System.out.println(i + " - "+recebe[i]);
        }
        
        //arvore.imprimirPreOrdemArray();
        arvore.busca(12);
        arvore.busca(30);
    }
    
}
