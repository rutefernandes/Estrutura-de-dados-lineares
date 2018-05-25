/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heap;

/**
 *
 * @author tiago
 */
public class No {
    private int index;
    private int chave;
    private Object valor;

    public No(int index, int chave, Object valor) {
        this.index = index;
        this.chave = chave;
        this.valor = valor;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getChave() {
        return chave;
    }

    public void setChave(int chave) {
        this.chave = chave;
    }

    public int getPai() {
        if (index % 2 == 0) {
            return index / 2;
        } else {
            return (index-1) / 2;
        }
    }

    public Object getValor() {
        return valor;
    }

    public void setValor(Object valor) {
        this.valor = valor;
    }
}
