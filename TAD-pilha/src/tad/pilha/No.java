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
public class No {
private Object valor;
    private No proxNo;
    
    public No (Object valor, No proxNo) {
        this.valor = valor;
        this.proxNo = proxNo;
    }
    
    public void setValor (Object valor){
        this.valor = valor;
    }
    
    public Object getValor () {
        return this.valor;
    }
    
    public void setProxNo (No proxNo) {
        this.proxNo = proxNo;
    }
    
    public No getProxNo () {
        return this.proxNo;
    }
    
    @Override
    public String toString () {
        return "" + this.valor;
    }
}
