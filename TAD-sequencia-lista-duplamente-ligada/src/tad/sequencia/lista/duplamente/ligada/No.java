package tad.sequencia.lista.duplamente.ligada;

/**
 *
 * @author rute
 */
public class No {
    private Object elem;
    private No anterior;
    private No proximo;
    
    public No(){
        
    }
    
    public No(Object elem, No anterior, No proximo){
        this.elem = elem;
        this.anterior = anterior;
        this.proximo = proximo;
    }
    
    
    public Object getElem(){
        return this.elem;
    }
    
    public void setElem(Object elem){
        this.elem = elem;
    }
    
    public No getAnterior(){
        return this.anterior;
    }
    
    public void setAnterior(No anterior){
        this.anterior = anterior;
    }
    
    public No getProximo(){
        return this.proximo;
    }
    
    public void setProximo(No proximo){
        this.proximo = proximo;
    }
    
    public String toString(){
        return "[" + this.getElem() + "]";
    } 
}
