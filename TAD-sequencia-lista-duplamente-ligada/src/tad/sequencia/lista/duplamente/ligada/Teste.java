package tad.sequencia.lista.duplamente.ligada;

/**
 *
 * @author rute
 */
public class Teste {

    public static void main(String[] args) {
        Sequencia s = new Sequencia();
        Object o = "objeto";
        int r = 3;
        s.insertLast("c");
        s.insertBefore(s.last(), "b");
        s.insertBefore(s.last().getAnterior(), "a");
        s.insertAtRank(2, "lalas");
        
        try {
            s.atRank(5);
        } catch (EIndexInvalido e) {
            System.out.println("Posição inválida");
        }
        
        /* Metodos 
        s.size();
        s.isEmpty();
        s.isFirst(no);
        s.isLast(no);
        s.first();
        s.last();
        s.before(no);
        s.after(no);
        s.replaceElement(no,o);
        s.swapElements(no,n2);
        s.insertBefore(no,o);
        s.insertAfter(no,o);
        s.insertFirst(o);
        s.insertLast(o);
        s.remove(no); 
        s.elemAtRank(r);
        s.replaceAtRank(r, o);
        s.insertAtRank(r,o);
        s.removeAtRank(r);
        s.atRank(r);
        s.rankOf(no);
        */
    }
    
}
