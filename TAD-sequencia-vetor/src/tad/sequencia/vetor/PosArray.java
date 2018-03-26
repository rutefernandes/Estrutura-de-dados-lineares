/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tad.sequencia.vetor;

/**
 *
 * @author tiago
 */
public class PosArray {
    public int rank;
    public Object elemento;
    
    public Object getElemento() {
        return this.elemento;
    }
    
    public void setElemento(Object elemento) {
        this.elemento = elemento;
    }
    
    
    public PosArray(int rank, Object elemento) {
        this.rank = rank;
        this.elemento = elemento;
    }
}
