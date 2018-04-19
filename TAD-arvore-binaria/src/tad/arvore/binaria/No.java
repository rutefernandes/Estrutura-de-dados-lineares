package tad.arvore.binaria;

/**
 *
 * @author rute
 */
public class No {
    private int elemento;
    private No pai;
    private No filhoEsquerda;
    private No filhoDireta;
    
    public No(){
    }
    
    public No(int elemento){
        this.elemento = elemento;
    }
    
    public No(int elemento, No pai, No filhoEsquerda, No filhoDireta){
        super();
        this.pai = pai;
        this.filhoEsquerda = filhoEsquerda;
        this.filhoDireta = filhoDireta;
    }
    
    public int getElemento() {
        return elemento;
    }

    public void setElemento(int elemento) {
        this.elemento = elemento;
    }

    public No getPai() {
        return pai;
    }

    public void setPai(No pai) {
        this.pai = pai;
    }

    public No getFilhoEsquerda() {
        return filhoEsquerda;
    }

    public void setFilhoEsquerda(No filhoEsquerda) {
        this.filhoEsquerda = filhoEsquerda;
    }

    public No getFilhoDireta() {
        return filhoDireta;
    }

    public void setFilhoDireta(No filhoDireta) {
        this.filhoDireta = filhoDireta;
    }

}
