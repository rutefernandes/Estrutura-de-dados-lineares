package tad.sequencia.vetor;

/**
 *
 * @author rute
 */
public class Sequencia implements ISequencia{
    private PosArray S[];
    private int t = -1;
    private int fc;

    public Sequencia(int tamanho, int crescimento){
        this.fc = (crescimento<=0)? 0:crescimento;
        S = new PosArray[tamanho];
    }
    
    @Override
    public int size() {
        if(isEmpty()){
            return 0;
        }
        return t + 1;
    }

    @Override
    public boolean isEmpty() {
        return (t == -1);
    }

    @Override
    public boolean isFirst(Object n) {
        if (!isEmpty())
            return n.equals(first());
        return false;
    }

    @Override
    public boolean isLast(Object n) {
        if (!isEmpty())
            return n.equals(last());
        return false;
    }

    @Override
    public PosArray first() {
        return S[0];
    }

    @Override
    public PosArray last() {
        return S[S.length-1];
    }

    @Override
    public PosArray before(PosArray n){
        return n.rank == 0 ? last() : S[n.rank-1];
    }

    @Override
    public PosArray after(PosArray n){
        return n.rank == S.length-1 ? first() : S[n.rank+1];
    }

    @Override
    public void replaceElementObject(int r, Object o) throws EColocacaoInvalida{
        if (r >= 0 && r < S.length)
            S[r].elemento = o;
        else 
            throw new EColocacaoInvalida();
    }

    @Override
    public void swapElements(PosArray n, PosArray q) {
        int r = n.rank;
        n.rank = q.rank;
        q.rank = r;
        S[q.rank] = q;
        S[n.rank] = n;
    }

    @Override
    public Object insertBefore(PosArray n, Object o) {
        PosArray aux[];
        int cont;
        if (size() == S.length - 1) {
            if(fc == 0){
               aux = new PosArray[S.length*2];
            } else {
               aux = new PosArray[S.length + fc];
            }
            for (cont = 0; cont < size(); cont++) {
                aux[cont] = S[cont];
            }
            S = aux;
        }
        for (int i = t; i >= 0; i--) {
            if (i > n.rank) {
                S[i+1] = S[i];
                S[i+1].rank = i+1;
            } else {
                S[i+1] = S[i];
                S[i+1].rank = i+1;
                S[i] = new PosArray(i, o);
            }
        }
        t++;
        return o;
    }

    @Override
    public Object insertAfter(PosArray n, Object o) {
        PosArray aux[];
        int cont;
        if (size() == S.length - 1) {
            if(fc == 0){
               aux = new PosArray[S.length*2];
            } else {
               aux = new PosArray[S.length + fc];
            }
            for (cont = 0; cont < size(); cont++) {
                aux[cont] = S[cont];
            }
            S = aux;
        }
        for (int i = t; i >= 0; i--) {
            if (i > n.rank) {
                S[i+1] = S[i];
                S[i+1].rank = i+1;
            } else {
                S[n.rank+1] = new PosArray(i, o);
                break;
            }
        }
        t++;
        return o;
    }

    @Override
    public void insertFirst(Object o) {
        insertBefore(first(), o);
    }

    @Override
    public void insertLast(Object o) {
        insertAfter(last(), o);
    }

    @Override
    public Object remove(PosArray n) {
        Object rip = S[n.rank].elemento;
        for (int i = n.rank; i >= 0; i--) {
            if (i <= t) {
                S[i] = S[i+1];
            }
        }
        t--;
        return rip;
    }

    @Override
    public Object elemAtRank(int r) {
        return S[r].elemento;
    }

    @Override
    public Object replaceAtRank(int r, Object o) {
        Object old = S[r].elemento;
        S[r].elemento = o;
        return old;
    }

    @Override
    public void insertAtRank(int r, Object o) {
        insertBefore(S[r], o);
    }

    @Override
    public Object removeAtRank(int r) {
        return remove(S[r]);
    }

    @Override
    public Object atRank(int r) {
        return S[r].elemento;
    }

    @Override
    public Object rankOf(Object n) {
        for (int i = 0; i <= t; i++)
            if(S[i].elemento == n)
                return i;
        return -1; // talvez lançar uma exceção
    }
    
}
