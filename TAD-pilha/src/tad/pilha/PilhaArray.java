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
public class PilhaArray implements Pilha {
    private Object S[];
    private int t = -1;
    private int fc;
    
    public PilhaArray(int tamanho, int crescimento){
        this.fc = (crescimento<=0)? 0: crescimento;
        S = new Object[tamanho];
    }
    
    @Override
    public int size() {
        if(isEmpty()){
            return 0;
        }
        return this.t + 1;
    }

    @Override
    public boolean isEmpty() {
        if(t == -1){
            return true;
        }
        return false;
    }

    @Override
    public void push(Object o){
        int segura;
        if(t>=S.length-1){
            if(fc==0){
                segura= size()*2;
            } else {
                segura= size()+fc;
            }
             Object aux[]=new Object[segura];
             for(int i = 0; i< S.length; ++i){
                 aux[i]=S[i];
                 S=aux;
             }
        }
        S[++t]=o;
    }

    @Override
    public Object pop()throws EPilhaVazia {
        if(isEmpty()){
          throw new EPilhaVazia("Pilha vazia");
        }
         return S[t--];
    }

    @Override
    public Object top() throws EPilhaVazia {
        if(isEmpty()){
            throw new EPilhaVazia("Pilha vazia");
        } else {
            return S[t];
        }
        
    }
    
}