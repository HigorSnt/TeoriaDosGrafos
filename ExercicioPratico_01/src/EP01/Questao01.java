package EP01;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultEdge;

public class Questao01 {
	
	/**
	 * Classe responsável por gerar o grafo e enviar parâmetros
	 * para ser encontrado seus vizinhos.
	 * 
	 * @param args é a variável padrão do main().
	 * 
	 * @author Gabriel Carvalho de Lima
	 * @author Higor Santos de Brito Dantas
	 * @author Matheus Henrique Fernandes Justino
	 */

	public static void main(String[] args) {
		
		//Criando um grafo orientado
		DefaultDirectedGraph<String, DefaultEdge> g = new DefaultDirectedGraph<>(DefaultEdge.class);
		
		//Adicionando vértices ao grafo gerado
		g.addVertex("a");
		g.addVertex("b");
		g.addVertex("c");
		g.addVertex("d");
		g.addVertex("e");
		g.addVertex("f");
		g.addVertex("g");
		g.addVertex("h");
		
		//Adicionando arestas ao grafo gerado
		g.addEdge("c", "a");
		g.addEdge("f", "a");
		g.addEdge("f", "c");
		g.addEdge("c", "d");
		g.addEdge("d", "f");
		g.addEdge("g", "f");
		g.addEdge("d", "b");
		g.addEdge("d", "e");
		g.addEdge("e", "h");
		g.addEdge("h", "g");
		g.addEdge("g", "e");
		
		// Inicialmente deve-se encontrar os vizinhos de entrada dos vértices desejados.
		ArrayList<String> vizinhosDeA = encontraVizinhos(g, "a");
		ArrayList<String> vizinhosDeE = encontraVizinhos(g, "e");
		
		// Informando os vizinhos de cada vértice pela operação realizada acima.
		System.out.println("Vizinhos diretos de A: " + vizinhosDeA);
		System.out.println("Vizinhos diretos de E: " + vizinhosDeE);
		
		// Gerando listas que irão armazenar os vizinhos indiretos de cada vértice
		ArrayList<String> vizinhosIndiretosDeA = new ArrayList<>();
		ArrayList<String> vizinhosIndiretosDeE = new ArrayList<>();
		
		// Encontrando os vizinhos de entrada dos vizinhos de entrada do vértice a, desde que não seja vizinho direto
		for (String e : vizinhosDeA) {
			vizinhosIndiretosDeA.addAll(verificaJaExisteVizinhos(encontraVizinhos(g, e), vizinhosDeA));
		}
		
		// Encontrando os vizinhos de entrada dos vizinhos de entrada do vértice e, desde que não seja vizinho direto
		for (String e : vizinhosDeE) {
			vizinhosIndiretosDeE.addAll(verificaJaExisteVizinhos(encontraVizinhos(g, e), vizinhosDeE));
		}
		
		// Mostrando o resultado procurado
		System.out.println("\nOs vizinhos indiretos do vértice A: " + vizinhosIndiretosDeA.toString());
		System.out.println("Os vizinhos indiretos do vértice E: " + vizinhosIndiretosDeE.toString());

	}
	
	/**
	 * Verifica se os vizinhos indiretos já são vizinhos diretos.
	 * 
	 * @param lista é uma array com os vizinhos do vizinho direto.
	 * @param vizinhos são os vizinhos diretos do vértice.
	 * 
	 * @return todos os vértices que são apenas vizinhos indiretos.
	 */

	private static ArrayList<String> verificaJaExisteVizinhos(ArrayList<String> lista, ArrayList<String> vizinhos) {
		ArrayList<String> vizinhosIndiretos = new ArrayList<String>();
		for (String v : lista) {
			if (!(vizinhos.contains(v)))
				vizinhosIndiretos.add(v);
		}
		
		return vizinhosIndiretos;
	}
	
	/**
	 * Método responsável por encontrar os vizinhos de um determinado vértice
	 * informado pelo método main().
	 * @param g é o grafo onde o vértice e os seus vizinhos se localizam.
	 * @param base é o vertice que estou querendo encontrar os vizinhos.
	 * 
	 * @return um array com os vizinhos do vértice representado pela variável base.
	 */

	private static ArrayList<String> encontraVizinhos(DefaultDirectedGraph<String, DefaultEdge> g, String base) {
		
		Set<DefaultEdge> allEdge = g.edgeSet();
		Iterator<DefaultEdge> inter = allEdge.iterator();
		ArrayList<String> vizinhos = new ArrayList<>();
		
		while (inter.hasNext()) {
			DefaultEdge v = inter.next();
			if (v.toString().endsWith(base +")")) {
				vizinhos.add(v.toString().substring(1, 2));
			}
		}
		return vizinhos;
	}

}
