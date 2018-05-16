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
public class ItemNaoEncontradoException extends Exception {

    /**
     * Creates a new instance of <code>ItemNaoEncontradoException</code> without
     * detail message.
     */
    public ItemNaoEncontradoException() {
    }

    /**
     * Constructs an instance of <code>ItemNaoEncontradoException</code> with
     * the specified detail message.
     *
     * @param msg the detail message.
     */
    public ItemNaoEncontradoException(String msg) {
        super(msg);
    }
}
