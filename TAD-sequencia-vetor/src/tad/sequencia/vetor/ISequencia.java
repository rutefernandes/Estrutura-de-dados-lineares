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
    public PosArray first();
    public PosArray last();
    public PosArray before(PosArray n);
    public PosArray after(PosArray n);
    public Object replaceElement(PosArray n, Object o);
    public void swapElements(PosArray n, PosArray q);
    public Object insertBefore(PosArray n, Object o);
    public Object insertAfter(PosArray n, Object o);
    public void insertFirst(Object o);
    public void insertLast(Object o);
    public Object remove(PosArray n); 
    public Object elemAtRank(int r) throws EColocacaoInvalida;
    public Object replaceAtRank(int r, Object o) throws EColocacaoInvalida;
    public void insertAtRank(int r, Object o) throws EColocacaoInvalida;
    public Object removeAtRank(int r) throws EColocacaoInvalida;
    public Object atRank(int r) throws EColocacaoInvalida;
    public Object rankOf(Object n);  
}
