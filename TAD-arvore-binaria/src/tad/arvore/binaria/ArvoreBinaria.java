package tad.arvore.binaria;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author rute
 */
public class ArvoreBinaria implements IArvoreBinaria{
    private No raiz;
    private int tamanho;
    
    public ArvoreBinaria(){
        this.raiz = null;
        this.tamanho = 0;
    }
    
    public ArvoreBinaria(int o){
        raiz = new No(o);
	tamanho = 1;
    }
    
    public No getRaiz() {
        return raiz;
    }

    public void setRaiz(No raiz) {
        this.raiz = raiz;
    }
    
    public int getTamanho() {
        return tamanho;
    }
    
    @Override
    public int size() {
        return this.getTamanho();
    }

    @Override
    public boolean isEmpty() {
        return (getRaiz() == null);
    }

    @Override
    public int height() { 
        return (root()==null?-1:height(root()));
    }
    
    public int height(No v){
        if(isExternal(v)){
            return 0;
        } else {
            int h=0;
            Iterator itr = children(v);
            while(itr.hasNext()){
               No filho = (No) itr.next();
               h = Math.max(h, height(filho));
           }
            return h+1;
        }
    }
    
    @Override
    public Iterator elements() { //TODO
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Iterator nos() { //TODO
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public No root() {
        return getRaiz();
    }

    @Override
    public No parent(No no) {
        return no.getPai();
    }

    @Override
    public Iterator children(No no) {
       ArrayList<No> n = new ArrayList<No>();
       n.add(no.getFilhoEsquerda());
       n.add(no.getFilhoDireita());
       Iterator itr = n.iterator();
       return itr;
    }

    @Override
    public boolean isInternal(No no) {
        return (no==null)? true : (no.getFilhoDireita()!=null || no.getFilhoEsquerda()!= null);
    }

    @Override
    public boolean isExternal(No no) {
        return (no==null)? true : (no.getFilhoDireita()==null && no.getFilhoEsquerda()==null);
    }

    @Override
    public boolean isRoot(No no) {
        return (no == getRaiz());
    }

    @Override
    public int depth(No no) {
        if(isRoot(no)){
            return 0;
        } else {
            return 1+depth(parent(no));
        }
    }

    @Override
    public Object leftChild(No no) {
        return hasLeft(no)?(no.getFilhoEsquerda().getElemento()):null;
    }

    @Override
    public Object rightChild(No no) {
        return hasRight(no)?(no.getFilhoDireita().getElemento()):null;
    }

    @Override
    public boolean hasLeft(No no) {
        return (no.getFilhoEsquerda() != null);
    }

    @Override
    public boolean hasRight(No no) {
        return (no.getFilhoDireita() != null);
    }

    @Override
    public No buscar(int chave) {
        return buscar(chave, getRaiz());
    }
  
    @Override
    public No buscar(int chave, No atual) {
        if(isExternal(atual)){
            return atual;       
        }
        if(chave < atual.getElemento()){
            return (atual.getFilhoEsquerda()!=null)? buscar(chave, atual.getFilhoEsquerda()) : atual;
        } else if (chave == atual.getElemento()){
           return atual; 
        } else if (chave > atual.getElemento()){
            return (atual.getFilhoDireita()!=null)? buscar(chave, atual.getFilhoDireita()) : atual;
        } else {
            return atual; 
        }
    }

    @Override
    public void adicionar(int o) {
        No novoNo = new No(o);
        if(isEmpty()){
            setRaiz(novoNo);
            tamanho++;
            System.out.println("Elemento adicionado como Raiz.");
        } else {
            No segura = buscar(o, getRaiz());
            if(segura.getElemento() == novoNo.getElemento()){
                System.out.println("Elemento ja existe.");
            } else if(segura.getElemento() > novoNo.getElemento()){
                segura.setFilhoEsquerda(novoNo);
                novoNo.setPai(segura);
                tamanho++;
                System.out.println( novoNo + " adicionado a esquerda de " + segura.getElemento());
            } else if (segura.getElemento() < novoNo.getElemento()){
                segura.setFilhoDireita(novoNo);
                novoNo.setPai(segura);
                tamanho++;
                System.out.println( novoNo + " adicionado a direita de " + segura.getElemento());
            }
        }
    }

    @Override
    public No remover(No no) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mostrar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
