/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tad.fila;

/**
 *
 * @author rute
 */
public class FilaListaEncadeada implements Fila {

    private No inicio;
    private No fim;
    private int tamanho;
    
    public FilaListaEncadeada() {
        this.inicio = null;
        this.fim = null;
        this.tamanho = 0;
    }

    @Override
    public void enfileirar(Object o) {
        if (this.inicio == null) {
            this.inicio = new No(o, null);
            this.fim = this.inicio;
        } else {
            No novo = new No(o, null);
            this.fim.setProxNo(novo);
            this.fim = novo;
        }
        this.tamanho++;
    }

    @Override
    public Object desenfileirar() throws EFilaVazia {
        No ref = this.inicio;
        if (ref == null)
            throw new EFilaVazia("Fila Vazia");
        this.inicio = this.inicio.getProxNo();
        this.tamanho--;
        return ref.getValor();
    }

    @Override
    public Object inicio() throws EFilaVazia {
        if (this.inicio == null)
            throw new EFilaVazia("Fila Vazia");
        return this.inicio.getValor();
    }

    @Override
    public int tamanho() {
        return this.tamanho;
    }

    @Override
    public boolean estaVazia() {
        return this.inicio == null;
    }
    
}