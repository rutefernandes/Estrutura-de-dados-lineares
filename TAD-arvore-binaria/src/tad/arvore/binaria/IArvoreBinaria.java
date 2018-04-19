package tad.arvore.binaria;

import java.util.Iterator;

/**
 *
 * @author rute
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
    public int leftChild(No no);;
    public int rightChild(No no);;
    public boolean hasLeft(No no);
    public boolean hasRight(No no);
}
