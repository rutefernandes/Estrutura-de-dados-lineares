/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tad.pilha;

import java.util.Scanner;

/**
 *
 * @author rute
 */
public class Teste {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        Pilha p;
        System.out.println("---------------------");
        System.out.print("Tipo (1 - Array; 2 - Lista Encadeada): ");
        int tipo = input.nextInt();
        if (tipo == 1) {
            System.out.print("Tamanho da pilha: ");
            int tam = input.nextInt();
            System.out.print("Crescimento: ");
            int cres = input.nextInt();
            p = new PilhaArray(tam, cres);
        } else {
            p = new PilhaListaEncadeada();
        }
        int op = -1;
        while(op!=0){
            Menu();
            op = input.nextInt();
            switch(op){
                case 1:
                    System.out.println("Size: " + p.size());
                    break;
                case 2:
                    if(p.isEmpty()){
                        System.out.println("Sem elementos na pilha");
                    } else {
                        System.out.println("Pilha com elementos armados");
                    }   
                    break;
                case 3:
                    System.out.print("Valor: ");
                    int v = input.nextInt();
                    p.push(v);
                    break;
                case 4:
                    try {
                        Object x = p.pop();
                        System.out.println("Último inserido: "+ x);
                    } catch (EPilhaVazia e) {
                        System.out.println("Pilha vazia");
                    }
                    break;
                case 5:
                    try {
                        Object x = p.top();
                        System.out.println("Topo da pilha: " + x);
                    } catch (EPilhaVazia e) {
                        System.out.println("Pilha vazia");
                    }
                    break;
                case 0:
                    System.out.println("Eh isto.");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } 
    }
    
    public static void Menu(){
        System.out.print("---------------------");
        System.out.print("\n Métodos \n 1 - size() \n 2 - isEmpty() \n 3 - push() "
            + "\n 4 - pop() \n 5 - top()\n 0 - sair\n");
    }
}
