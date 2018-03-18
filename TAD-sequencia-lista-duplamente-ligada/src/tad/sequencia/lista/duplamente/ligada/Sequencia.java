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
        this.inicio = new No();
        this.fim = new No();
        this.tamanho = 0;
    }
    
    public No getInicio() {
        return inicio;
    }

    public void setInicio(No inicio) {
        this.inicio = inicio;
    }

    public No getFim() {
        return fim;
    }

    public void setFim(No fim) {
        this.fim = fim;
    }

    
    @Override
    public int size() {
        return this.tamanho;
    }

    @Override
    public boolean isEmpty() {
        return (tamanho == 0);
    }

    @Override
    public boolean isFirst(No n) {
        return (n.getAnterior() == this.getInicio());
    }

    @Override
    public boolean isLast(No n) {
        return (n.getProximo()== this.getFim());
    }

    @Override
    public No first() {
       return this.getInicio().getProximo();
    }

    @Override
    public No last() {
       return this.getFim().getAnterior();
    }

    @Override
    public No before(No n) {
        return n.getAnterior();
    }

    @Override
    public No after(No n) {
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
        novoAnterior.setProximo(novoNo);
        tamanho++;
        return size();
    }

    @Override
    public Object insertAfter(No n, Object o) {
        No antigoNo = n;
        No novoProximo = antigoNo.getProximo();
        No novoNo = new No(o,antigoNo, novoProximo);
        antigoNo.setProximo(novoNo);
        novoProximo.setAnterior(novoNo);
        tamanho++;
        return size();
    }

    @Override
    public void insertFirst(Object o) {
        No novoProximo = getInicio().getProximo();
        No novoNo = new No(o, this.getInicio(), novoProximo);
        novoProximo.setAnterior(novoNo);
        getInicio().setProximo(novoNo);
        ++tamanho;
    }

    @Override
    public void insertLast(Object o) {
        No novoAnterior = getFim().getAnterior();
        No novoNo = new No(o, novoAnterior , this.getFim());
        novoAnterior.setProximo(novoNo);
        getFim().setAnterior(novoNo);
        ++tamanho;
    }

    @Override
    public Object remove(No n) {
        Object elemRemovido = n.getElem();
        n.getAnterior().setProximo(n.getProximo());
        n.getProximo().setAnterior(n.getAnterior());
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
        No antigoNo = atRank(r);
        No novoNo = new No(o, antigoNo.getAnterior(), antigoNo);
        antigoNo.getAnterior().setProximo(novoNo);
        antigoNo.setAnterior(novoNo);
        ++tamanho;
    //Basicamente faz o mesmo que os metodos insert(). Coleguinha quer isso mesmo?
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
            no = getInicio().getProximo();
            for(int i = 0; i<r; ++i){
		no = no.getProximo();
            }
	} else {
            no = getFim().getAnterior();
            for(int i=0; i<size()-r-1; ++i){
		no = no.getAnterior();
            }
	}
	return no;	
    }

    @Override
    public Object rankOf(No n) {
        No ini = getInicio().getProximo();
        int r = 0;
        while(ini != n && ini!= getFim()){
            ini = ini.getProximo();
            r++;
        }
        return r;
    }
}
