package poo;

import java.util.Scanner;

import static poo.Campeonato.*;

public class Teste {
    public static void main(String [] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("CAMPEONATO!");
        System.out.println("digite 1 para jogar...");
        System.out.println("digite qualquer outra coisa para sair...");
        String variavel = scanner.nextLine();
        try{
            int entrada = Integer.parseInt(variavel);
            if(entrada == 1){
                numerodeclubes();
                jogarcamp();
            }else{
                System.out.println("O JOGO FOI ENCERRADO!");
                System.out.println("saindo da aplicação...");
                System.exit(0);
            }
        }catch(NumberFormatException e){
            System.out.println("O JOGO FOI ENCERRADO!");
            System.out.println("saindo da aplicação...");
            System.exit(0);
        }

    }

    public static void numerodeclubes(){
        Scanner scanner = new Scanner(System.in);
        short quantidade;
        short estruturadecontrole = 0;
        System.out.println("digite quantos clubes irão jogar o campeonato: ");
        quantidade = scanner.nextShort();
        while(estruturadecontrole < quantidade){
            CriarClube();
            estruturadecontrole++;
        }
    }

    public static void CriarClube(){
        String nomedoclube;
        Scanner scan = new Scanner(System.in);
        System.out.println("digite o nome do seu clube: ");
        nomedoclube = scan.nextLine();
        Clubes clube = new Clubes(nomedoclube);
        listadeclubes.add(clube);
        listadeclubesimutavel.add(clube);
    }

}
