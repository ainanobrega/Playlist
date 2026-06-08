package Projetos;

public class Musicas {
	int codigo;
    String titulo;
    String artista;
    int duracao; 
    boolean favorita;
  
    Musicas (int codigo, String titulo, String artista, int duracao){
        this.codigo = codigo;
        this.titulo = titulo;
        this.artista = artista;
        this.duracao = duracao;
        this.favorita = false;
    }

    public String toString (){
        int minutos = duracao / 60;
        int segundos = duracao % 60;

        return "[# "+ codigo +"] ▶ " + titulo +" - "+ artista + " (" + minutos + " : " + segundos + ")";
    }

}