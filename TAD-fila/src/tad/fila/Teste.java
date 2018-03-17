/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tad.fila;

import java.util.Scanner;

/**
 *
 * @author rute
 */
public class Teste {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Fila fila;
        System.out.println("---------------------");
        System.out.print("Tipo (1 - Array; 2 - Lista Encadeada): ");
        int tipo = input.nextInt();
        if (tipo == 1) {
            System.out.print("Tamanho da pilha: ");
            int tam = input.nextInt();
            System.out.print("Crescimento: ");
            int cres = input.nextInt();
            fila = new FilaArray(tam, cres);
        } else {
            fila = new FilaListaEncadeada();
        }
        int op = -1;
        while(op!=0){
            menu();
            op = input.nextInt();
            switch(op){
                case 0:
                    System.out.println("Eh isto.");
                    break;
                case 1:
                    try {
                        Object inicio = fila.inicio();
                        System.out.println("Inicio: " + inicio);
                    } catch (EFilaVazia e) {
                        System.out.println("Fila vazia");
                    }
                    break;
                case 2:
                    System.out.println("Tamanho: " + fila.tamanho());
                    break;
                case 3: 
                    int obj = input.nextInt();
                    fila.enfileirar(obj);
                    break;
                case 4:
                    try {
                        Object inicio = fila.desenfileirar();
                        System.out.println("Inicio: " + inicio);
                    } catch (EFilaVazia e) {
                        System.out.println("Fila vazia");
                    }
                    break;
                case 5:
                    if(fila.estaVazia()){
                        System.out.println("Vazia");
                    } else {
                        System.out.println("Nao esta vazia");
                    }
                    break;
                    
                default:
                    System.out.println("Opção inválida.");    
            }
        }
    }
    
    public static void menu(){
        System.out.print("---------------------");
        System.out.print("\n Métodos \n 1 - inicio() \n 2 - tamanho() \n 3 - "
                + "enfileirar() \n 4 - desenfileirar()\n 5 - estaVazia() \n 0 - sair \n ");
    }
}
