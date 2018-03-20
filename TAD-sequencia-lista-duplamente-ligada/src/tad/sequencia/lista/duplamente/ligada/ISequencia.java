package tad.sequencia.lista.duplamente.ligada;
public interface ISequencia {
    public int size();
    public boolean isEmpty();
    public boolean isFirst(No n);
    public boolean isLast(No n);
    public No first();
    public No last();
    public No before(No n);
    public No after(No n);
    public Object replaceElement(No n, Object o);
    public void swapElements(No n, No q);
    public Object insertBefore(No n, Object o);
    public Object insertAfter(No n, Object o);
    public void insertFirst(Object o);
    public void insertLast(Object o);
    public Object remove(No n); 
    public Object elemAtRank(int r);
    public Object replaceAtRank(int r, Object o);
    public void insertAtRank(int r, Object o);
    public Object removeAtRank(int r);
    public No atRank(int r);
    public Object rankOf(No n);
}
