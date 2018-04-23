package tad.arvore.binaria;

/**
 *
 * @author rute
 */
public class Comparator implements IComparator {

    @Override
    public int compare(int x, int y) {
        int r=0;
        if(x<y){
            r=-1;
        } else if(x>y){
            r=1;
        }
        return r;
    }
    
}
