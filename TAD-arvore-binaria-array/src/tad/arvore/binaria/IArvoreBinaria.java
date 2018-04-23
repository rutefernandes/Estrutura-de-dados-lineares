/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tad.arvore.binaria;
import java.util.Iterator;

/**
 *
 * @author tiago
 */

public interface IArvoreBinaria {
    /* Métodos genéricos */
    public int size();
    public boolean isEmpty();
    public int height();
    /** Retorna um iterator com os elementos armazenados na árvore */
    public Iterator elements();
    /** Retorna um iterator com as posições (nós) da árvore */
    public Iterator nos();

    /* Métodos de acesso*/
    public No root();
    public No parent(No no);
    public Iterator children(No no);

    /* Métodos de consulta */
    public boolean isInternal(No no);
    public boolean isExternal(No no);
    public boolean isRoot(No no);
    public int depth(No no);

    /* Métodos de atualização */
    public Object replace(No no, Object o);    

   /* Métodos da arvore binaria */
    public No leftChild(No no);
    public No rightChild(No no);
    public boolean hasLeft(No no);
    public boolean hasRight(No no);
    
    public void adicionar(Object o);
    public No buscar(Object k);
    public No remover(No no);
    public void mostrar();
}
