package tad.arvore.binaria;

/**
 *
 * @author rute
 */
public class Comparator implements IComparator {

    @Override
    public Object compare(Object x, Object y) {
        return (int) x - (int) y;
    }
    
}
