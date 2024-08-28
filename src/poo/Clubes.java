package poo;

public class Clubes {
    String nome;
    int pontos;
    int saldogols;

    Clubes(String nome){
        this.nome = nome;
        pontos = 0;
        saldogols = 0;
    }


    public void ganhar (int saldogols){
        pontos += 3;
        this.saldogols += saldogols;
    }

    public void empatar (){
        pontos ++;
    }

    public void perder (int saldogols){
        this.saldogols -= saldogols;
    }
}
