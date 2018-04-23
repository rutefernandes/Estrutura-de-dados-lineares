package tad.arvore.binaria;

/**
 *
 * @author rute
 */
public class Comparator implements IComparator {

    @Override
    public int compare(Object x, Object y) {
        return (int) x - (int) y;
    }
    
}
