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
    Comparator c = new Comparator();
    private ArrayList<No> inOrder = new ArrayList<No>();
    private ArrayList<No> preOrder = new ArrayList<No>();
    private ArrayList<No> posOrder = new ArrayList<No>();
    
    public ArvoreBinaria(){
        this.raiz = null;
        this.tamanho = 0;
    }
    
    public ArvoreBinaria(int o){
        raiz = new No(o);
	tamanho++;
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
    public Iterator nos() { 
        return (root()==null)?null:inOrder(root());
    }

    @Override
    public Iterator elements() { 
        Iterator itr = (root()==null)?null:inOrder(root()); 
        ArrayList elementos = new ArrayList();
        while(itr.hasNext()) {
            No no = (No) itr.next();
            int elemento = no.getElemento();
            elementos.add(elemento);
        }
        itr = elementos.iterator();
        return itr; 
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
        return (no==null)? false : (no.getFilhoDireita()!=null || no.getFilhoEsquerda()!= null);
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
        return (isRoot(no)?0:1+depth(parent(no)));
    }

    @Override
    public No leftChild(No no) {
        return hasLeft(no)?(no.getFilhoEsquerda()):null;
    }

    @Override
    public No rightChild(No no) {
        return hasRight(no)?(no.getFilhoDireita()):null;
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
        int resultado;
        if(isEmpty()){
            setRaiz(novoNo);
            tamanho++;
            System.out.println(novoNo+" adicionado como Raiz.");
        } else {
            No segura = buscar(o, getRaiz());
            resultado = (int) c.compare(segura.getElemento(), novoNo.getElemento());
            if(resultado==0){
                System.out.println("Elemento ja existe.");
            } else if(resultado>0){
                segura.setFilhoEsquerda(novoNo);
                novoNo.setPai(segura);
                tamanho++;
                System.out.println( novoNo + " adicionado a esquerda de " + segura.getElemento());
            } else if(resultado<0){
                segura.setFilhoDireita(novoNo);
                novoNo.setPai(segura);
                tamanho++;
                System.out.println( novoNo + " adicionado a direita de " + segura.getElemento());
            }
        }
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
    
    public int replace(No n1, int o){
        int oldN = n1.getElemento();
        n1.setElemento(o);
        return oldN;
    }

    @Override
    public No remover(No no) {
        boolean hasleft = hasLeft(no);
        boolean hasright = hasRight(no);
        No pai = no.getPai();
        No oldN = no;
        No r = no;
        if(isExternal(no)){
            
        } else if(hasleft && !hasright){
            No filhoE = no.getFilhoEsquerda();
            no.setElemento(filhoE.getElemento());
            no.setFilhoEsquerda(null);
            filhoE.setPai(null);
            return oldN;
        } else if(!hasleft && hasright){
            No filhoD = no.getFilhoDireita();
            no.setElemento(filhoD.getElemento());
            no.setFilhoDireita(null);
            filhoD.setPai(null);
            return oldN;
        } else if(hasleft && hasright){
            No ref = this.rightChild(no);
            while (this.leftChild(ref) != null) {
                ref = this.leftChild(ref);
            }
            no.setElemento(ref.getElemento());
            r = ref;
        }
        int resultado = (int) c.compare(r.getElemento(), r.getPai().getElemento());
        if(resultado>0){
            r.getPai().setFilhoDireita(null);
        } else{
            r.getPai().setFilhoEsquerda(null);
        }
        r.setPai(null);
        return oldN;
    }

    @Override
    public void mostrar() {
        System.out.println(this.toString());
    }
    
       
    public Iterator preOrder(){
        preOrder = new ArrayList();
        return (root()==null)?null:preOrder(root()); 
    }
    
    public Iterator preOrder(No v){
        preOrder.add(v);
        if(leftChild(v)!=null){
            preOrder(leftChild(v));
        }
        if(rightChild(v)!=null){
            preOrder(rightChild(v));
        }
        Iterator itr = preOrder.iterator();
        return itr;
    }
    
    public Iterator inOrder(){
        inOrder = new ArrayList();
        return (root()==null)?null:inOrder(root()); 
    }
    
    public Iterator inOrder(No v) { 
        if(isInternal(v)){
            inOrder(leftChild(v)); 
            inOrder.add(v);
        } else if(v!=null) {
            inOrder.add(v);
        }
        if(isInternal(v)){
            inOrder(rightChild(v));
        }
        Iterator itr = inOrder.iterator();
        return itr;
    }
    
    public Iterator posOrder(){
        posOrder = new ArrayList();
        return (root()==null)?null:posOrder(root()); 
    }
    
    public Iterator posOrder(No v){
        if(leftChild(v)!=null){
            posOrder(leftChild(v));
        }
        if(rightChild(v)!=null){
            posOrder(rightChild(v));
        }
        posOrder.add(v);
        Iterator itr = posOrder.iterator();
        return itr;
    }
    
}
