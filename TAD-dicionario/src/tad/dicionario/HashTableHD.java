/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tad.dicionario;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author tiago
 */
public class HashTableHD implements IDicionario {
    private final int SIZE = 97;
    private final int Q = 89;
    private Item[] map = null;
    private int size;
    
    public HashTableHD() {
        map = new Item[SIZE];
        size = 0;
        for (int i = 0; i < SIZE; i++) {
            map[i] = null;
        }
    }
    
    @Override
    public Object findElement(Object k) throws ItemNaoEncontradoException {
        int d = (int) k; // TODO: Dispersão
        int passo = Q - d % Q;
        int hash = d % SIZE;
        int count = 0;
        
        while(map[hash] != null && !map[hash].chave.equals(k)){
            hash += passo;
            if(count == SIZE)
                    throw new ItemNaoEncontradoException();
            count++;
        }
        
        if(map[hash] == null || map[hash] instanceof Available)
            throw new ItemNaoEncontradoException();

        return map[hash].valor;
        
    }

    @Override
    public void insertItem(Object k, Object o) throws TabelaCheiaException{
        int d = (int) k; // TODO: Dispersão
        int passo = Q - d % Q;
        int hash = d % SIZE;
        int count = 0;
        while (map[hash] != null && !(map[hash] instanceof Available) && !map[hash].chave.equals(k)) {
            hash += passo;
            if (count == SIZE)
                throw new TabelaCheiaException();
            count++;
        }
        map[hash] = new Item(k, o); // TODO: encadear elementos iguais
        size++;
    }

    @Override
    public Item removeElement(Object k) throws ItemNaoEncontradoException {
        int d = (int) k; // TODO: Dispersão
        int passo = Q - d % Q;
        int hash = d % SIZE;
        int count = 0;
        
        while(map[hash] != null && !(map[hash] instanceof Available) && !map[hash].chave.equals(k)){
            hash += passo;
            if(count == SIZE)
                    throw new ItemNaoEncontradoException("");
            count++;
        }
        
        if(map[hash] == null)
            throw new ItemNaoEncontradoException("");
        
        Item old = map[hash];
        
        map[hash] = new Available(old.chave, old.valor);
        
        size--;
        
        return old;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Iterator keys() {
        ArrayList<Object> keys = new ArrayList<Object>();
        
        for (Item i : map) {
            if (i != null && !(i instanceof Available))
                keys.add(i.chave);
        }
        
        return keys.iterator();
    }

    @Override
    public Iterator elements() {
        ArrayList<Object> keys = new ArrayList<Object>();
        
        for (Item i : map) {
            if (i != null && !(i instanceof Available))
                keys.add(i.valor);
        }
        
        return keys.iterator();
    }
    
}
