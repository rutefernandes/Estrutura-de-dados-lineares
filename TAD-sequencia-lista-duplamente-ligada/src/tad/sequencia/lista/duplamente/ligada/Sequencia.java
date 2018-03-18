package tad.sequencia.lista.duplamente.ligada;

/**
 *
 * @author rute
 */
public class Sequencia implements ISequencia{
    private No inicio;
    private No fim;
    private int tamanho;
    
    public Sequencia() {
        this.inicio = null;
        this.fim = null;
        this.tamanho = -1;
}
    
    @Override
    public int size() {
        return this.tamanho;
    }

    @Override
    public boolean isEmpty() {
        boolean estado = (tamanho == -1)?true:false;
        return estado;
    }

    @Override
    public boolean isFirst(No n) {
        boolean resultado = (n.getAnterior() == this.inicio)?true:false;
        return resultado;
    }

    @Override
    public boolean isLast(No n) {
        boolean resultado = (n.getProximo()== this.fim)?true:false;
        return resultado;
    }

    @Override
    public Object first() {
       return this.inicio.getProximo();
    }

    @Override
    public Object last() {
       return this.fim.getAnterior();
    }

    @Override
    public Object before(No n) {
        return n.getAnterior();
    }

    @Override
    public Object after(No n) {
       return n.getProximo();
    }

    @Override
    public void replaceElement(No n, Object o) {
        n.setElem(o);
    }

    @Override
    public void swapElements(No n, No q) {
        Object segura = n.getElem();
        n.setElem(q.getElem());
        q.setElem(segura);
    }

    @Override
    public Object insertBefore(No n, Object o) {
        No antigoNo = n;
        No novoAnterior = antigoNo.getAnterior();
        No novoNo = new No(o, novoAnterior, antigoNo);
        antigoNo.setAnterior(novoNo);
        tamanho++;
        return size();
    }

    @Override
    public Object insertAfter(No n, Object o) {
        No antigoNo = n;
        No novoProximo = antigoNo.getProximo();
        No novoNo = new No(o,antigoNo, novoProximo);
        antigoNo.setProximo(novoNo);
        tamanho++;
        return size();
    }

    @Override
    public void insertFirst(Object o) {
        No novoProximo = inicio.getProximo();
        No novoNo = new No(o, this.inicio, novoProximo);
        novoProximo.setAnterior(novoNo);
        inicio.setProximo(novoNo);
        ++tamanho;
    }

    @Override
    public void insertLast(Object o) {
        No novoAnterior = fim.getAnterior();
        No novoNo = new No(o, novoAnterior , this.fim);
        novoAnterior.setProximo(novoNo);
        fim.setAnterior(novoNo);
        ++tamanho;
    }

    @Override
    public Object remove(No n) {
        Object elemRemovido = n.getElem();
        n.getAnterior().setProximo(n.getProximo());
        n.getProximo().setAnterior(n.getProximo());
        n.setProximo(null);
        n.setAnterior(null);
        return elemRemovido;
    }

    @Override
    public Object elemAtRank(int r) {
        No no = atRank(r);
        return no.getElem();
    }

    @Override
    public Object replaceAtRank(int r, Object o) {
        No no = atRank(r);
        Object antigoElemento = no.getElem();
        no.setElem(o);
        return antigoElemento;
    }

    @Override
    public void insertAtRank(int r, Object o) {
        //No no = atRank(r); 
        //Qual a diferença desse pro replaceAtRank??
    }

    @Override
    public Object removeAtRank(int r) {
        No no = atRank(r);
        Object elementoRemovido = no.getElem();
        remove(no);
        --tamanho;
        return elementoRemovido;
    }

    @Override
    public No atRank(int r) {
        No no;
        if(r <= size()/2){
            no = inicio.getProximo();
            for(int i = 0; i<r; ++i){
		no = no.getProximo();
            }
	} else {
            no = fim.getAnterior();
            for(int i=0; i<size()-r-1; ++i){
		no = no.getAnterior();
            }
	}
	return no;	
    }

    @Override
    public Object rankOf(No n) {
        No ini = inicio.getProximo();
        int r = 0;
        while(ini != n && ini!= fim){
            ini = ini.getProximo();
            r++;
        }
        return r;
    }
}
