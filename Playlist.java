package Projetos;
import java.util.Random;

public class Playlist {
	String nomePlaylist;
    Musicas [] musicas;
    int quantidadeMusicas;
    Random sorteioDeCodigo = new Random();
    String descricao;
    
    // construtor da playlist
    Playlist(String nomePlaylist, int quantidadeMusicas, String descricao){
        this.nomePlaylist = nomePlaylist;
        this.quantidadeMusicas = 0;
        this.musicas = new Musicas[quantidadeMusicas];
        this.descricao = descricao;
    }
    
    // funcao de adicionar musica 
    boolean adicionarMusica (Musicas novaMusica){
        if (quantidadeMusicas >= musicas.length){
            return false;
        }
        novaMusica.codigo = sorteioDeCodigo.nextInt(900) + 100;
        musicas[quantidadeMusicas] = novaMusica;
        quantidadeMusicas++;
        System.out.println("Musica adicionada! Codigo: "+ novaMusica.codigo +"");
        return true;
    }

    // funcao de remover musica por titulo 
    boolean removerPorTitulo(String titulo){
        for (int i = 0; i < quantidadeMusicas; i++){
            if (musicas[i].titulo.equals(titulo)){
                for (int j = i; j < quantidadeMusicas - 1; j++){
                    musicas[j] = musicas[j + 1];
                }
                musicas[quantidadeMusicas - 1] = null;
                quantidadeMusicas--;
                return true;
            }
        }
        return false;
    }
    
    // funcao de remover Musica por codigo
    boolean removerPorCodigo(int codigo){
        for (int i = 0; i < quantidadeMusicas; i++){
            if (musicas[i].codigo == codigo){
                for (int j = i; j < quantidadeMusicas - 1; j++){
                    musicas[j] = musicas[j + 1];
                }
                musicas[quantidadeMusicas - 1] = null;
                quantidadeMusicas--;
                return true;
            }
        }
        return false;
    }

    // funcao de exibir playlist
    void exibirPlaylist() {
		System.out.println("\n=================================");
		System.out.println("\n======= PLAYLYST: " + this.nomePlaylist + " =======");
		System.out.println (this.descricao);
		System.out.println("---------------------------------");
		
		if (quantidadeMusicas == 0) {
			System.out.println("A playlist está vazia!");
		} else {
			for (int i = 0; i < quantidadeMusicas; i++) {
				if (musicas[i] != null) {
					System.out.printf("%02d. %s\n", i + 1, musicas[i]);	
				}
			}
		}
		System.out.println("=================================");
	}
    
    // funcao para buscar por artista
    Musicas[] buscarPorArtista(String artista){
    	Musicas[] musicasEncontradas = new Musicas [quantidadeMusicas];
		int contador = 0;
		for (int i = 0; i < quantidadeMusicas; i++) {
			if (musicas[i].artista.equalsIgnoreCase(artista)) {
				musicasEncontradas[contador] = musicas[i];
				contador++;
			}
		}
		Musicas[]resultadoFinaldasEncontradas = new Musicas[contador];
		for (int i = 0; i < contador; i++) {
			resultadoFinaldasEncontradas[i] = musicasEncontradas[i];
		}
		return resultadoFinaldasEncontradas;
	}
    
    // funcao para exibir o tempo total
    void exibirTempoTotal(){
        int totalSegundos = 0;
        for (int i = 0; i < quantidadeMusicas; i++){
            totalSegundos += musicas[i].duracao;
        }
        int minutos = totalSegundos / 60;
        int segundos = totalSegundos % 60;
        System.out.println ("Tempo total da playlist: ["+ minutos +" : "+ segundos +" ]");
    }
    
    // funcao para favoritar musica
    boolean favoritarMusica(String nomeMusica){
        for (int i = 0; i < quantidadeMusicas; i++){
            if (musicas[i].titulo.equals(nomeMusica)){
                musicas[i].favorita = true;
                return true;
            }
        }
        return false;
    }
    
    // funcao para exibir a quantidade de musicas
    void exibirQuantidadesDeMusicas(){
        System.out.println("A playlist "+ nomePlaylist  +" tem "+ quantidadeMusicas +" musica(s).");
    }

   void exibirFavoritas() {
    	boolean temFavorita = false;
    	for (int i = 0; i < quantidadeMusicas; i++) {
    		if (musicas[i].favorita == true) {
    			System.out.println(musicas[i].toString());
    			temFavorita = true;
    		}
    		if (temFavorita == false) { 
    			System.out.println("Nenhuma musica favoritada!");
    		}
    		
    	}
    }
}

