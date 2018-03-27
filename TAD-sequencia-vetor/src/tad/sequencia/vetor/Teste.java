package tad.sequencia.vetor;

/**
 *
 * @author rute
 */
public class Teste {
    public static void main(String[] args) {
        
        Sequencia s = new Sequencia(5,0);
        s.insertLast("opaa");
        s.insertLast("olha aqui");
        s.insertLast("olha la");
        s.insertLast("bunito");
        
        s.insertAfter(s.atRank(0), "pssst!");
        s.remove(s.atRank(1));
        
        for (int i = 0; i < s.size(); i++)
            System.out.println(s.atRank(i).elemento);
        
        System.out.println("--------------------");
        
        s.swapElements(s.atRank(2), s.atRank(1));
        s.swapElements(s.atRank(3), s.atRank(2));
        
   
            
        s.insertAtRank(0, "BUNITO");
        PosArray n = new PosArray(0, "AH");
        s.insertAfter(n, "aab");
            for (int i = 0; i < s.size(); i++)
            System.out.println(s.atRank(i).elemento);
            System.out.println(s.first().elemento);
        
         

        /*
        

    public PosArray before(PosArray n);
    public PosArray after(PosArray n);
    public Object replaceElement(PosArray n, Object o);
        */
        
        
        
    }
    
}
