/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arvore;

/**
 *
 * @author tiago
 */
public class InvalidPositionException extends Exception {

    /**
     * Creates a new instance of <code>InvalidPositionException</code> without
     * detail message.
     */
    public InvalidPositionException() {
    }

    /**
     * Constructs an instance of <code>InvalidPositionException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public InvalidPositionException(String msg) {
        super(msg);
    }
}
