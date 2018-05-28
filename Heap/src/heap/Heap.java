/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heap;

import java.util.ArrayList;
import java.util.Iterator;

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
        return n.getIndex()*2 <= this.n;
    }
    
    public boolean hasRight (No n) {
        return (n.getIndex()*2 + 1) <= this.n;
    }
    
    public No parent (No n) {
        return heap[n.getPai()];
    }
    
    public No root() {
        return heap[1];
    }
    
    public boolean isInternal(No no) {
        if (no == null) return false;
        return hasLeft(no);
    }
    
    public boolean isRoot (No n) {
        return n.getIndex() == 1;
    }
    
    public boolean isLeaf (No n) {
        return n.getIndex()*2 > this.n;
    }
    
    public void upheap (No n) {
//        System.out.println(n.getValor());
        No pai = parent(n);
        if (isRoot(n) || pai.getChave() < n.getChave()) return;
        
        int chavePai =  pai.getChave();
        Object valorPai = pai.getValor();
        
        pai.setChave(n.getChave());
        pai.setValor(n.getValor());
        
        n.setChave(chavePai);
        n.setValor(valorPai);
        
        upheap(pai);
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
        No r = new No(min.getIndex(), min.getChave(), min.getValor());
        No last = heap[n--];
        
        heap[1].setChave(last.getChave());
        heap[1].setValor(last.getValor());
        downheap(heap[1]);
        
        return r;
    }
    
    public Iterator inOrder() {
        return inOrder(this.root()).iterator();
    }
    
    private ArrayList inOrder(No n) {
        ArrayList v = new ArrayList();
        if (isInternal(n)) {
            if (this.leftChild(n) != null) {
                v.addAll(inOrder(this.leftChild(n)));
            }
            
            v.add(n);
            
            if (this.rightChild(n) != null) {
                v.addAll(inOrder(this.rightChild(n)));
            }
        } else {
            v.add(n);
        }
        

        return v;
    }
    
    public void mostrar() {
        for (int i = 1; i <= n; i++) {
            System.out.print("{" + heap[i].getChave() + ", " + heap[i].getValor() + "}, ");
        }
        System.out.println("");
    }
    
//    public String toString () {
//        Iterator itr = inOrder();
//        int h = this.height() + 5;
//        int l = this.size() + 5;
//        
//        Object matrix[][] = new Object[h][l];
//        
//        int i = 0;
//        while (itr.hasNext()) {
//            No n = (No) itr.next();
//            int d = this.depth(n);
//            matrix[d][i] = n.getElemento();
//            i++;
//        }
//        
//        String str = "";
//        
//        for (i = 0; i < h; i++){
//            for (int j = 0; j < l; j++) {
//                str += matrix[i][j] == null ? "  " : ((int) matrix[i][j] >= 0 ? " " + matrix[i][j] : matrix[i][j]);
//            }
//            str += "\n";
//        }
//        
//        return str;
//    }
//
//    
//    public void mostrar() {
//        System.out.println(toString());
//    }
    
}
