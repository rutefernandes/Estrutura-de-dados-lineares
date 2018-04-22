/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tad.arvore.binaria;

/**
 *
 * @author tiago
 */
public class No {
    private Object elemento;
    private int pai;
    private int index;
    
    public No (Object elemento, int pai, int index) {
        this.elemento = elemento;
        this.pai = pai;
        this.index = index;
    }

    public Object getElemento() {
        return elemento;
    }

    public void setElemento(Object elemento) {
        this.elemento = elemento;
    }

    public int getPai() {
        return pai;
    }

    public void setPai(int pai) {
        this.pai = pai;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getFilhoEsquerda() {
        return this.index*2;
    }

    public int getFilhoDireita() {
        return (this.index*2) + 1;
    }
    
    
}
