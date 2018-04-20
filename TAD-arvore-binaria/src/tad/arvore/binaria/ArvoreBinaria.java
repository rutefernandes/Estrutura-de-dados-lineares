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
    
    @Override
    public int size() {
        return this.tamanho;
    }

    @Override
    public boolean isEmpty() {
        return (getRaiz() == null);
    }

    @Override
    public int height() { //DOING
        No raiz = getRaiz();
        if(isExternal(raiz)){
                return 0;
        } else {
                int altura = 0;
                return 1+ altura;
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
       ArrayList n = new ArrayList();
       n.add(no.getFilhoEsquerda());
       n.add(no.getFilhoDireita());
       Iterator filhos = n.iterator();
       return filhos;
    }

    @Override
    public boolean isInternal(No no) {
        return (no.getFilhoDireita()!=null || no.getFilhoEsquerda()!= null);
    }

    @Override
    public boolean isExternal(No no) {
        return (no.getFilhoDireita()==null && no.getFilhoEsquerda()== null);
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
    public int replace(No no, int o) {
        int antigo = no.getElemento();
        no.setElemento(o);
        return antigo;
    }

    @Override
    public Object leftChild(No no) {
        return (no.getFilhoEsquerda().getElemento());
    }

    @Override
    public Object rightChild(No no) {
        return (no.getFilhoDireita().getElemento());
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
    public void buscar(int posicao) {
        buscar(posicao, getRaiz());
    }
  
    @Override
    public No buscar(int posicao, No atual) {
        if(isExternal(atual)){
            return atual;       
        }
        if(posicao < atual.getElemento()){
            return buscar(posicao, atual.getFilhoEsquerda());
        } else if (posicao == atual.getElemento()){
           return atual; 
        } else if (posicao > atual.getElemento()){
            return buscar(posicao, atual.getFilhoDireita());
        } else {
            return atual; 
        }
    }

    @Override
    public void adicionar(int o) {
        No novoNo = new No(o);
        if(isEmpty()){
            setRaiz(novoNo);
        } else {
            No segura = buscar(o, getRaiz());
            //substituir no ja existente
            if(segura.getElemento() == novoNo.getElemento()){
                No pai = parent(segura);
                No filhoEsquerda = segura.getFilhoEsquerda();
                No filhoDireita = segura.getFilhoDireita();
                
                filhoEsquerda.setPai(novoNo);
                filhoDireita.setPai(novoNo);
                if(pai.getElemento()>novoNo.getElemento()){
                    pai.setFilhoEsquerda(novoNo);
                } else {
                    pai.setFilhoDireita(novoNo);
                }
                
                novoNo.setPai(pai);
                novoNo.setFilhoDireita(filhoEsquerda);
                novoNo.setFilhoEsquerda(filhoDireita);
                
                segura.setPai(null);
                segura.setFilhoDireita(null);
                segura.setFilhoEsquerda(null);
            //inserir na direita de um no externo
            } else if(segura.getElemento() > novoNo.getElemento()){
                segura.setFilhoDireita(novoNo);
                novoNo.setPai(segura);
            //inserir na esquerda de um no externo
            } else if (segura.getElemento() < novoNo.getElemento()){
                segura.setFilhoEsquerda(novoNo);
                novoNo.setPai(segura);
            }
        }
    }
    
}
