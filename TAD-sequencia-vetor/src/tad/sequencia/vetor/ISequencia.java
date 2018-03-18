package tad.sequencia.vetor;

/**
 *
 * @author rute
 */
public interface ISequencia {
    public int size();
    public boolean isEmpty();
    public boolean isFirst(Object n);
    public boolean isLast(Object n);
    public Object first();
    public Object last();
    public Object before(Object n);
    public Object after(Object n);
    public void replaceElementObject(Object n, Object o);
    public void swapElements(Object n, Object q);
    public Object insertBefore(Object n, Object o);
    public Object insertAfter(Object n, Object o);
    public void insertFirst(Object o);
    public void insertLast(Object o);
    public Object remove(Object n); 
    public Object elemAtRank(int r);
    public Object replaceAtRank(int r, Object o);
    public void insertAtRank(int r, Object o);
    public Object removeAtRank(int r);
    public Object atRank(int r);
    public Object rankOf(Object n);  
}
