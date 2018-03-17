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
public class FilaArray implements Fila {
    private Object Arr[];
    private int i;
    private int f;
    private final int fc;
    
    public FilaArray(int tamanho, int crescimento){
        this.fc = (crescimento<=0)? 0 : crescimento;
        Arr = new Object[tamanho];
    }
    
    @Override
    public int tamanho() {
        return (Arr.length - i + f)%Arr.length;
    }

    @Override
    public boolean estaVazia() {
        return i==f;
    }

    @Override
    public Object inicio() throws EFilaVazia {
        if (estaVazia())
            throw new EFilaVazia("Fila vazia");
        return Arr[i];
    }

    @Override
    public void enfileirar(Object o) {
        Object aux[];
        int cont;
        
        if(tamanho() == Arr.length-1){
            if(fc == 0){
               aux = new Object[Arr.length*2];
            } else {
               aux = new Object[Arr.length + fc];
            }
            for (cont = 0; cont < tamanho(); cont++) {
                aux[cont] = Arr[(this.i + cont) % Arr.length];
            }
            this.i = 0;
            this.f = cont;
            Arr = aux;
        }
        
        Arr[f] = o;
        f = (f+1)%Arr.length;
        
    }

    @Override
    public Object desenfileirar() throws EFilaVazia {
        Object s;
        if(estaVazia()){
            throw new EFilaVazia("Fila vazia");
        } else {
            s = Arr[i];
            i = (i+1)%Arr.length;
        }
        return s;
    }
    
}
