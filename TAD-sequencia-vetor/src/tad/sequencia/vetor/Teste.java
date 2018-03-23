package tad.sequencia.vetor;

/**
 *
 * @author rute
 */
public class Teste {
    public static void main(String[] args) {
        
        Sequencia s = new Sequencia(5,0);
        PosArray p = new PosArray(4, "olhei");
        PosArray q = new PosArray(1, "olha");
    //nullpointerexcetpion    s.replaceElementObject(2, teste);
        Object teste = "at";
    //    s.insertAfter(p, teste);
     //   System.out.println(s.before(p));
        s.insertFirst(teste);
     //   System.out.println(s.last());
     //   System.out.println(s.elemAtRank(0));  
     //   System.out.println(s.isFirst(teste)); 
//        s.insertAtRank(0, teste);
          s.rankOf("at");
        
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
