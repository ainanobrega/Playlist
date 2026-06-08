package Projetos;
import java.util.Scanner;

public class Main {
	static Scanner leitor = new Scanner(System.in);
	static Playlist minhaPlaylist;
	
	static String lerTexto(String mensagem) {
		System.out.println(mensagem);
		return leitor.nextLine();
	}
	
	static int lerNumero(String mensagem) {
		System.out.println(mensagem);
		int numero = leitor.nextInt();
		leitor.nextLine();
		return numero;
	}
	
	static void exibirMenu() {
		System.out.println("\n");
		System.out.println("1 - Adicionar Musica");
		System.out.println("2 - Ver Playlist completa");
		System.out.println("3 - Remover Musica por Codigo");
		System.out.println("4 - Remover Musica por Titulo");
		System.out.println("5 - Buscar Musica por Artista");
		System.out.println("6 - Favoritar Musica");
		System.out.println("7 - Exibir Musicas Favoritas");
		System.out.println("8 - Exibir Tempo Final da Playlist");
		System.out.println("0 - Sair");
	}
	
	
	static void opcaoAdicionarMusica() {
		System.out.println("=== CADASTRANDO MUSICA ===");
		String titulo = lerTexto ("Nome da música: ");
		String artista = lerTexto ("Nome do artista: ");
		int duracao = lerNumero("Duracao(em segundos): ");
		Musicas novaMusica = new Musicas (0,titulo, artista, duracao);		
		minhaPlaylist.adicionarMusica(novaMusica);
		System.out.println("Música cadastrada!");
	}
	
	static void opcaoRemocaoCodigo() {
		System.out.println ("\n------- REMOVER DA PLAYLIST -------");
		int codigo = lerNumero("Codigo da musica que deseja remover: ");
		if (minhaPlaylist.removerPorCodigo(codigo)) {
			System.out.println("Musica removida com sucesso!");
		} else {
			System.out.println("Musica não encontrada");
		}
	}

	static void opcaoRemocaoTitulo() {
		System.out.println ("\n------- REMOVER DA PLAYLIST -------");
		String titulo = lerTexto ("Qual musica deseja remover: ");
		if (minhaPlaylist.removerPorTitulo(titulo)) {
			System.out.println("Musica removida com sucesso!");
		} else {
			System.out.println("Musica não encontrada");
		}
	}

	static Musicas [] opcaoBuscarMusicaPorArtista() {
	    System.out.println("\n------- MUSICAS DE UM ARTISTA -------");
	    String artista = lerTexto("Qual é o artista: ");
	    Musicas[] musicasEncontradas = minhaPlaylist.buscarPorArtista(artista);
	    if (musicasEncontradas.length > 0) {
	        System.out.println("Foram encontradas " + musicasEncontradas.length + " musica(s)");
	        for (Musicas m : musicasEncontradas) {
	            System.out.println("-> " + m);
	        }
	    } else {
	        System.out.println("Nenhuma musica encontrada!");
	    }
	    return musicasEncontradas;
	}
	
	static void opcaoFavoritarMusica() {
	    System.out.println("\n------- FAVORITAR MUSICA -------");
	    String titulo = lerTexto("Nome da musica para favoritar: ");
	    if (minhaPlaylist.favoritarMusica(titulo)) {
	    	System.out.println("Musica favoritada com sucesso!");
	    } else {
	    	System.out.println("Musica nao encontrada!");
	    }
	}
	
	static void opcaoExibirMusicasFavoritas() {
	    System.out.println("\n------- MUSICAS FAVORITAS -------");
	    minhaPlaylist.exibirFavoritas();
	}
	
	static void opcaoTempoFinal() {
	    System.out.println("\n------- TEMPO TOTAL -------");
	    minhaPlaylist.exibirTempoTotal();

	}
	public static void main (String[] args) {
		int tamanho = lerNumero("Qual o tamanho da playlist: ");
		String nomePlaylist = lerTexto("Qual o nome da Playlist: ");
		String nomeDescricao = lerTexto("Qual sera a descricao da sua Playlist: ");
		minhaPlaylist = new Playlist(nomePlaylist, tamanho, nomeDescricao);
		
		int opcao;
		do {
			exibirMenu();
			opcao = lerNumero("Escolha uma opcao:");
			switch (opcao){
				case 1:
					opcaoAdicionarMusica();
					break;
				case 2: 
					minhaPlaylist.exibirPlaylist();
					break;
				case 3: 
					opcaoRemocaoCodigo();
					break;
				case 4: 
					opcaoRemocaoTitulo();
					break;
				case 5: 
					opcaoBuscarMusicaPorArtista();
					break;
				case 6: 
					opcaoFavoritarMusica();
					break;
				case 7: 
					opcaoExibirMusicasFavoritas();
					break;
				case 8: 
					opcaoTempoFinal();
					break;
				case 0:
					System.out.println("Saindo da Playlist...");
					break;
				default: 
					System.out.println("CODIGO INVALIDO! Tente novamente");
			}
		} while (opcao != 0);
	}
}
