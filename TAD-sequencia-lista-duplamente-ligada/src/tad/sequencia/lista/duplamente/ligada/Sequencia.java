package tad.sequencia.lista.duplamente.ligada;

/**
 *
 * @author rute
 */
public class Sequencia implements ISequencia{
    private No proximo;
    private No anterior;
    private int tamanho;
    
    @Override
    public int size() {
        return this.tamanho;
    }

    @Override
    public boolean isEmpty() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isFirst(No n) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isLast(No n) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object first() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object last() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object before(No n) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object after(No n) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void replaceElement(No n, Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void swapElements(No n, No q) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insertLast(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object replaceAtRank(int r) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insertAtRank(int r) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object removeAtRank(int r) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object atRank(int r) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object rankOf(No n) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
