/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tad.pilha;

/**
 *
 * @author rute
 */
public class PilhaListaEncadeada implements Pilha{
    private No topo;
    private int tamanho;
    
    public int size () {
        return this.tamanho;
    }
    
    public boolean isEmpty() {
        return this.tamanho == 0;
    }
    
    public No top() throws EPilhaVazia {
        if (this.topo != null)
            return this.topo;
        else
            throw new EPilhaVazia("Pilha Vazia");
    }
    
    public void push (Object valor) {
        No novoNo = new No(valor, this.topo);
        this.topo = novoNo;
        this.tamanho++;
    }
    
    public No pop () throws EPilhaVazia {
        No antigoTopo = this.topo;
        if (antigoTopo != null) {
            this.topo = antigoTopo.getProxNo();
            this.tamanho--;
        } else {
            throw new EPilhaVazia("Pilha Vazia");
        }
        return antigoTopo;
    }
    
}