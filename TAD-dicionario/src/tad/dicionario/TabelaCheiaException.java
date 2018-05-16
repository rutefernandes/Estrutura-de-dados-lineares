/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tad.dicionario;

/**
 *
 * @author tiago
 */
public class TabelaCheiaException extends Exception {

    /**
     * Creates a new instance of <code>TabelaCheiaException</code> without
     * detail message.
     */
    public TabelaCheiaException() {
    }

    /**
     * Constructs an instance of <code>TabelaCheiaException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public TabelaCheiaException(String msg) {
        super(msg);
    }
}
