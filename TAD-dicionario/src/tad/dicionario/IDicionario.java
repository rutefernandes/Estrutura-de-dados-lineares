/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tad.dicionario;

import java.util.Iterator;

/**
 *
 * @author tiago
 */
public interface IDicionario {
    public Object findElement(Object k) throws ItemNaoEncontradoException;
    public void insertItem(Object k, Object o) throws TabelaCheiaException;
    public Item removeElement(Object k) throws ItemNaoEncontradoException;
    public int size();
    public boolean isEmpty();
    public Iterator keys();
    public Iterator elements();
}
