package poo;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class Campeonato {

    static ArrayList<Clubes> listadeclubes = new ArrayList<>();
    static ArrayList<Clubes> listadeclubesimutavel = new ArrayList<>();

    //A ordem dos elementos de LDC muda e de LDCI não muda

    public static void jogarcamp(){
        int rodada = 2;
        while(rodada!=0) {
            if(rodada==2){

                System.out.println("##  INICIANDO PRIMEIRO TURNO  ##");
            } else if (rodada ==1) {
                System.out.println("##  INICIANDO SEGUNDO TURNO  ##");
            }
            for (int i = 0; i < listadeclubesimutavel.size(); i++) {
                for (int j = i + 1; j < listadeclubesimutavel.size(); j++) {
                    System.out.println("os times: " + listadeclubesimutavel.get(i).nome + " e " + listadeclubesimutavel.get(j).nome + " jogarão agora");
                    jogarpt(listadeclubesimutavel.get(i), listadeclubesimutavel.get(j));
                    getclassificacao();
                }
            }
            rodada--;
        }
        System.out.println("O CAMPEAO FOI O TIME: "+getcampeao());
    }

    public static void jogarpt(Clubes time1, Clubes time2){
        Random random = new Random();
        int gols1 = random.nextInt(0,6);
        int gols2 = random.nextInt(0,6);
        int diferenca = Math.abs(gols1-gols2);
        if(gols1>gols2){
            time1.ganhar(diferenca);
            System.out.println("o time "+time1.nome+" ganhou a partida de "+gols1+" gols a "+gols2);
            time2.perder(diferenca);
        } else if (gols2>gols1) {
            time2.ganhar(diferenca);
            System.out.println("o time "+time2.nome+" ganhou a partida de "+gols2+" gols a "+gols1);
            time1.perder(diferenca);
        }else{
            time1.empatar();
            time2.empatar();
            System.out.println("os times "+time1.nome+" e "+time2.nome+" empataram com "+gols1+" gols cada.");
        }
    }

    public static String getcampeao(){
        return listadeclubes.get(0).nome;
    }

    public static void getclassificacao(){
        Scanner scanner = new Scanner(System.in);
        for(int i=0; i<listadeclubes.size(); i++){
            for(int j=0; j<listadeclubes.size()-1-i;j++){
                Clubes clubeatual = listadeclubes.get(j);
                Clubes proximoclube = listadeclubes.get(j+1);
                if(clubeatual.pontos<proximoclube.pontos){
                    listadeclubes.set(j, proximoclube);
                    listadeclubes.set(j+1, clubeatual);
                } else if (clubeatual.pontos== proximoclube.pontos) {
                    if(clubeatual.saldogols<proximoclube.saldogols){
                        listadeclubes.set(j, proximoclube);
                        listadeclubes.set(j+1, clubeatual);
                    }
                }
            }
        }

        System.out.println("----------------------------------");
        System.out.println("classificação: ");
        for( Clubes c : listadeclubes){
            System.out.println(c.nome+": "+c.saldogols+" saldo de gols, "+c.pontos+" pontos");
        }
        System.out.println("----------------------------------");

        System.out.println("Aperte enter para continuar: ");
        scanner.nextLine();

    }

}
