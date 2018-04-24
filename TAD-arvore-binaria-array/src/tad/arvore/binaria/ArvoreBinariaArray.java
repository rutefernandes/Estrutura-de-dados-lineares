/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tad.arvore.binaria;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/**
 *
 * @author tiago
 */
public class ArvoreBinariaArray implements IArvoreBinaria{
    private No[] arvore;
    private int r;
    
    public ArvoreBinariaArray (int el) {
        this.arvore = new No[10];
        this.arvore[1] = new No(el, 0, 1);
        r = 2;
    }
    
    
    /**
     * 
     * @param n
     * @param w
     * @return int r
     * se r == 0 n == w
     * se r < 0 n < w
     * se r > 0 n > w
     */
    
    private int compare (Object n, Object w) {
        Comparator c = new Comparator();
        return c.compare(n, w);
    }

    @Override
    public int size() {
        return this.r - 1;
    }

    @Override
    public boolean isEmpty() {
        return r == 0;
    }

    @Override
    public int height() {
        return altura(this.root());
    }
    
    private int altura(No n) {
        if (isExternal(n)) {
            return 0;
        } else {
            int h = 0;
            h = Math.max(h, altura(this.leftChild(n)));
            h = Math.max(h, altura(this.rightChild(n)));
            return 1+h;
        }
    }
    
    public Iterator preOrder() {
        return preOrder(this.root()).iterator();
    }
    
    private ArrayList preOrder(No n) {
        ArrayList v = new ArrayList();
        v.add(n);
        if (isInternal(n)) {
            if (this.leftChild(n) != null) {
                v.addAll(preOrder(this.leftChild(n)));
            }
            
            if (this.rightChild(n) != null) {
                v.addAll(preOrder(this.rightChild(n)));
            }
        }
        
        return v;
    }
    
    public Iterator postOrder() {
        return postOrder(this.root()).iterator();
    }
    
    private ArrayList postOrder(No n) {
        ArrayList v = new ArrayList();
        if (isInternal(n)) {
            if (this.leftChild(n) != null) {
                v.addAll(postOrder(this.leftChild(n)));
            }
            
            if (this.rightChild(n) != null) {
                v.addAll(postOrder(this.rightChild(n)));
            }
        }
        v.add(n);

        return v;
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

    @Override
    public Iterator elements() {
        Iterator itr = nos();
        ArrayList arr = new ArrayList();
        while (itr.hasNext()) {
            No n = (No) itr.next();
            arr.add(n.getElemento());
        }
        
        return arr.iterator();
    }

    @Override
    public Iterator nos() {
        return preOrder();
    }

    @Override
    public No root() {
        return this.arvore[1];
    }
    
    private void root(No no) {
        this.arvore[1] = no;
    }

    @Override
    public No parent(No no) {
        return this.arvore[no.getPai()];
    }

    @Override
    public Iterator children(No no) {
        No filhos[] = new No[2];
        filhos[0] = this.leftChild(no);
        filhos[1] = this.rightChild(no);
        return Arrays.asList(filhos).iterator();
    }

    @Override
    public boolean isInternal(No no) {
        if (no == null) return false;
        return (no.getFilhoEsquerda() < this.arvore.length && this.arvore[no.getFilhoEsquerda()] != null) 
            || (no.getFilhoDireita() < this.arvore.length && this.arvore[no.getFilhoDireita()] != null);
    }

    @Override
    public boolean isExternal(No no) {
        return !isInternal(no);
    }

    @Override
    public boolean isRoot(No no) {
        return no.getPai() == 0;
    }

    @Override
    public int depth(No no) {
        if (isRoot(no))
            return 0;
        else
            return 1+depth(this.parent(no));
    }

    @Override
    public Object replace(No no, Object o) {
        Object old = no.getElemento();
        no.setElemento(o);
        return old;
    }

    @Override
    public No leftChild(No no) {
        return this.arvore[no.getFilhoEsquerda()];
    }

    @Override
    public No rightChild(No no) {
        return this.arvore[no.getFilhoDireita()];
    }

    @Override
    public boolean hasLeft(No no) {
        return no.getFilhoEsquerda() < this.arvore.length && this.arvore[no.getFilhoEsquerda()] != null;
    }

    @Override
    public boolean hasRight(No no) {
        return no.getFilhoDireita() < this.arvore.length && this.arvore[no.getFilhoDireita()] != null;
    }
    
    private void expandTree () {
        No arrTmp[] = new No[this.arvore.length * 2];
        for (int i = 0; i < this.arvore.length; i++) {
            arrTmp[i] = this.arvore[i];
        }
        this.arvore = arrTmp;
    }
    
    @Override
    public void adicionar(Object o) {
        Comparator c = new Comparator();
        int resultado;
        if(isEmpty()) {
            this.root(new No(o, 0, 1));
            this.r++;
        } else {
            No novoNo = null;
            No segura = buscar(o, this.root());
            resultado = (int) c.compare(segura.getElemento(), o);
            if(resultado==0){
                return;
            } else if(resultado>0){
                novoNo = new No(o, segura.getIndex(), segura.getFilhoEsquerda());
            } else if(resultado<0){
                novoNo = new No(o, segura.getIndex(), segura.getFilhoDireita());
            }
            
            if (novoNo != null) {
                if (novoNo.getIndex() > this.arvore.length -1) {
                    expandTree();
                }
                this.arvore[novoNo.getIndex()] = novoNo;
                this.r++;
            }
        }
        
    }
    
    // Adicionar recursivo
    private void adicionar (Object o, No no) {
        int nxt;
        if (compare(no.getElemento(), o) > 0) {
            nxt = no.getFilhoEsquerda();
        } else if (compare(no.getElemento(), o) < 0) {
            nxt = no.getFilhoDireita();
        } else {
            return;
        }
        
        if (nxt > this.arvore.length) {
            No arrTmp[] = new No[this.arvore.length*2];
            for (int i = 0; i < this.arvore.length; i++) {
                arrTmp[i] = this.arvore[i];
            }
            this.arvore = arrTmp;
        }
        
        if (this.arvore[nxt] == null) {
            this.arvore[nxt] = new No(o, no.getIndex(), nxt);
            this.r++;
        } else {
            adicionar (o, this.arvore[nxt]);
        }
    }

    @Override
    public No buscar(Object k) {
        No n = buscar(k, this.root());
        
//        if (compare(n.getElemento(), k) != 0) {
//            throw new NotFoundException();
//        }
        
        return n;
    }

    private No buscar(Object k, No no) {
        if (isExternal(no)) {
            return no;
        }
        
        if (compare(k, no.getElemento()) < 0) {
            return this.leftChild(no) != null ? buscar(k, this.leftChild(no)) : no;
        } else if (compare(k, no.getElemento()) == 0) {
            return no;
        } else {
            return this.rightChild(no) != null ? buscar(k, this.rightChild(no)) : no;
        }
    }

    @Override
    public No remover(No no) {
        No old = new No(no.getElemento(), no.getPai(), no.getIndex());
        if (isExternal(no)) {
            this.replace(no, null);
        } else if (hasLeft(no) && !hasRight(no)) {
            No left = this.leftChild(no);
            this.replace(no, left);
//            this.replace(left, null);
            this.arvore[left.getIndex()] = null;
        } else if (!hasLeft(no) && hasRight(no)) {
            No right = this.rightChild(no);
            this.replace(no, right);
//            this.replace(right, null);
            this.arvore[right.getIndex()] = null;
        } else {
            ArrayList<No> inOrder = inOrder(no);
            No predecessor = inOrder.get(inOrder.indexOf(no)-1);
            
            this.replace(no, predecessor.getElemento());
            this.arvore[predecessor.getIndex()] = null;
        }
        
        this.r--;
        return old;
    }
    
    public String toString () {
        Iterator itr = inOrder();
        int h = this.height() + 5;
        int l = this.size() + 5;
        
        Object matrix[][] = new Object[h][l];
        
        int i = 0;
        while (itr.hasNext()) {
            No n = (No) itr.next();
            int d = this.depth(n);
            matrix[d][i] = n.getElemento();
            i++;
        }
        
        String str = "";
        
        for (i = 0; i < h; i++){
            for (int j = 0; j < l; j++) {
                str += matrix[i][j] == null ? "  " : ((int) matrix[i][j] >= 0 ? " " + matrix[i][j] : matrix[i][j]);
            }
            str += "\n";
        }
        
        return str;
    }

    @Override
    public void mostrar() {
        System.out.println(toString());
    }

    
}
