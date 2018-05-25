/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heap;

/**
 *
 * @author tiago
 */
public class Heap {
    private No[] heap;
    private int n;
    
    public Heap () {
        heap = new No[100];
        n = 0;
    }
    
    public No leftChild (No n) {
        return heap[2*n.getIndex()];
    }
    
    public No rightChild (No n) {
        return heap[2*n.getIndex()+1];
    }
    
    public boolean hasLeft (No n) {
        return n.getIndex()*2 > this.n;
    }
    
    public boolean hasRight (No n) {
        return (n.getIndex()*2 + 1) > this.n;
    }
    
    public No parent (No n) {
        return heap[n.getPai()];
    }
    
    public boolean isRoot (No n) {
        return n.getIndex() == 1;
    }
    
    public boolean isLeaf (No n) {
        return n.getIndex()*2 > this.n;
    }
    
    public void upheap (No n) {
        if (!isRoot(n) && n.getChave() < parent(n).getChave()) {
            No pai = parent(n);
            int chave = n.getChave();
            Object valor = n.getValor();
            
            n.setChave(pai.getChave());
            n.setValor(pai.getValor());
            
            pai.setChave(chave);
            pai.setValor(valor);
            
            upheap(pai);
        }
    }
    
    public void downheap (No no) {
        if (isLeaf(no)) return;
        
        No left = leftChild(no);
        No right = rightChild(no);
        No minChild;
        
        if (!hasRight(no)) {
            minChild = left;
        } else {
            minChild = left.getChave() < right.getChave() ? left : right;
        }
        
        if (no.getChave() < minChild.getChave()) return;
        
        int chave = minChild.getChave();
        Object valor = minChild.getValor();
        
        minChild.setChave(no.getChave());
        minChild.setValor(no.getValor());
        
        no.setChave(chave);
        no.setValor(valor);
        
        downheap(minChild);
            
    }
    
    public void insert (int chave, Object valor) {
        heap[++n] = new No(n, chave, valor);
        upheap(heap[n]);
    }
    
    public No removeMin () {
        No min = heap[1];
        No last = heap[n--];
        
        heap[1] = last;
        downheap(heap[1]);
        
        return min;
    }
    
}
