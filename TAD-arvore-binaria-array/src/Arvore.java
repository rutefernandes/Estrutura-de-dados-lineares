/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dayan
 */
public class Arvore {
    private Elemento ele;
    private Arvore   dir;
    private Arvore   esq;
    private int posicao;
    private int r = 1;
    private int e = r*2;
    private int d = (r*2) + 1;
    public static  Integer [] elementos;
    private int p;

    public int getPosicao() {
        return posicao;
    }

    public void setPosicao(int posicao) {
        this.posicao = posicao;
    }
    
    
    
    public  Integer[] getElementos() {
        return elementos;
    }

    public void setElementos(Integer[] elementos) {
        this.elementos = elementos;
    }
    
    
    
    public Arvore() {
        this.ele = null;
        this.esq = null;
        this.dir = null;
        this.elementos = new Integer[20];
    }

    public Arvore(Elemento ele) {
        this.ele = ele;
    }
    
    

    public boolean isEmpty(){
        if(this.ele == null){
            return true;
        }
            return false;
    }
    
    public void inserir(Elemento novo){
        if(isEmpty()){
            this.ele = novo;
            this.ele.setPosicao(r);
            elementos[this.ele.getPosicao()] = this.ele.getValor();
            
        }else{
            Arvore novaArvore = new Arvore(novo);
            if(novo.getValor() < this.ele.getValor()){
                if(this.esq == null){
                    this.esq = novaArvore;
                    if(this.esq.getPosicao()==0){
                        this.esq.getEle().setPosicao(this.ele.getPosicao()*2);
                    }
                    elementos[this.esq.getEle().getPosicao()] = this.esq.getEle().getValor();
                    //System.out.println("Inseri o elemento "+ novo.getValor()+" a esquerda de " + this.esq.getEle().getValor());
                    this.esq.getEle().setPosicao(this.ele.getPosicao()*2);
                    //System.out.println(this.esq.getPosicao());
                    
                }else{
                    //this.esq.getEle().setPosicao(this.esq.getEle().getPosicao()*2);
                    //System.out.println(this.esq.getEle().getPosicao());
                   this.esq.inserir(novo);
                    
                }
            }else if(novo.getValor() > this.ele.getValor()){
                if(this.dir == null){
                    this.dir = novaArvore;     
                    //System.out.println(this.dir.getPosicao());
                    if(this.dir.getPosicao()==0){
                        this.dir.getEle().setPosicao((this.ele.getPosicao()*2)+1);
                    }
                    //System.out.println(this.dir.getPosicao());
                    elementos[this.dir.getEle().getPosicao()] = this.dir.getEle().getValor();  
                    //System.out.println(this.ele.getValor());
                    //System.out.println("Inseri o elemento "+ novo.getValor()+" a direita de " + this.dir.getEle().getValor());
                    this.dir.getEle().setPosicao((this.ele.getPosicao()*2)+1);
                    //System.out.println(this.dir.getEle().getPosicao());
                  //  System.out.println(this.dir.getPosicao());
                    //this.dir.setPosicao(d);
                    //d = (this.dir.getPosicao()*2) +1;
                    //System.out.println(d);
                }
                    
                else{
                    //this.dir.getEle().setPosicao((this.dir.getEle().getPosicao()*2)+1);
                    //System.out.println(this.dir.getEle().getPosicao());
                    this.dir.inserir(novo);
                    
                }
            }
        }
    }
    
    public boolean busca(int valor){
        boolean retorno = false;
        if(isEmpty()){
            return retorno;
        }
        if(valor < elementos[r]){
            if(elementos[r*2]==null){
                return false;
            }else{
                if(elementos[(r*2)*2]==null){
                    
                }
            }
        }
            
            return retorno;
    }
    
    public void imprimirPreOrdem(){
        if(!isEmpty()){
            //System.out.println(elementos[r]);
            System.out.println(this.ele.getValor()+ " ");
            if(this.esq != null){
                this.esq.imprimirPreOrdem();
            }
            if(this.dir != null){
                this.dir.imprimirPreOrdem();
            }
        }
    }
    
    public void imprimirInOrdem(){
        if(!isEmpty()){
            if(this.esq != null){
                this.esq.imprimirInOrdem();
            }
            System.out.print(this.ele.getValor()+" ");
            if(this.dir != null){
                this.dir.imprimirInOrdem();
            }
        }
    }
    
    public void imprimirPosOrdem(){
        if(!isEmpty()){
            if(this.dir != null){
                this.dir.imprimirPosOrdem();
            }
            if(this.esq != null){
                this.esq.imprimirPosOrdem();
            }
            System.out.print(this.ele.getValor()+" ");
        }
    }
    
    public void imprimirInOrdemInvertida(){
        if(!isEmpty()){
            if(this.dir != null){
                this.dir.imprimirInOrdemInvertida();
            }
            System.out.print(this.ele.getValor()+" ");
            if(this.esq != null){
                this.esq.imprimirInOrdemInvertida();
            }
        }
    }
    
    public Elemento getEle() {
        return ele;
    }

    public void setEle(Elemento ele) {
        this.ele = ele;
    }

    public Arvore getDir() {
        return dir;
    }

    public void setDir(Arvore dir) {
        this.dir = dir;
    }

    public Arvore getEsq() {
        return esq;
    }

    public void setEsq(Arvore esq) {
        this.esq = esq;
    }
    
    
}
