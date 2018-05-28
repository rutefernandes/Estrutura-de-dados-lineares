/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package heap;

/**
 *
 * @author 20171014040022
 */
public class Teste {
    public static int[] heapsort(int[] arr) {
        Heap hp = new Heap();
        int[] ret = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            hp.insert(arr[i], arr[i]);
        }
        
        for (int i = 0; i < arr.length; i++) {
            ret[i] = hp.removeMin().getChave();
        }
        
        return ret;
    }
    
    public static void main(String[] args) {
        int[] arr = {5,2,1,3,6,7,0,9,8,-20,32,54,27,99,63,18,4};
        
        int[] sorted = heapsort(arr);
        
        for (int i = 0; i < sorted.length; i++) {
            System.out.println(sorted[i]);
        }
        
    }
}
