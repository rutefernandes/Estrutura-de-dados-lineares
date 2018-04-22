/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arvore;

import java.util.Iterator;

/**
 *
 * @author tiago
 */
public class Main {
    public static void main(String[] args) {
        ArvoreSimples as = new ArvoreSimples("1");
        
        as.addChild(as.root(), 2);
        as.addChild(as.root(), 3);
        as.addChild(as.root(), "4");
        
        Iterator itr = as.children(as.root());
        
//        as.swapElements((Position) itr.next(),(Position) itr.next());
//        as.replace((Position) itr.next(), "Trocado");
        
        itr = as.children(as.root());
        
        while (itr.hasNext()) {
            Position p = (Position) itr.next();
            as.addChild(p, 6);
            as.addChild(p, 6);
        }
        
        itr = as.children(as.root());
        
        while (itr.hasNext()) {
            Position p = (Position) itr.next();
            Iterator nitr = as.children(p);
            while (nitr.hasNext()) {
                Position pp = (Position) nitr.next();
                as.addChild(pp, 7);
                as.addChild(pp, 7);
            }
        }
        
        itr = as.elements();
        
        while (itr.hasNext()) {
            Object p = itr.next();
            System.out.println(p);
        }
        
        System.out.println("buscando 3: " + as.buscar(7).element());
        
//        System.out.println(as);
        
        
    }
}
