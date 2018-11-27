package EP01;
import java.util.Iterator;
import java.util.Set;

import org.jgrapht.Graph;
import org.jgrapht.graph.AsGraphUnion;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;

public class Questao02 {
	
	/**
	 * Classe responsável por gerar a união e interseção dos grafos dados.
	 * 
	 * @param args é a variável padrão do main().
	 * 
	 * @author Gabriel Carvalho de Lima
	 * @author Higor Santos de Brito Dantas
	 * @author Matheus Henrique Fernandes Justino
	 */

	public static void main(String[] args) {
		
		// Gerando grafos
		Graph<String, DefaultEdge> g = new SimpleGraph<>(DefaultEdge.class);
		Graph<String, DefaultEdge> h = new SimpleGraph<>(DefaultEdge.class);
		
		// Adicionando vértices no grafo g
		g.addVertex("d");
		g.addVertex("e");
		g.addVertex("f");
		g.addVertex("c");
		g.addVertex("i");
		
		// Adicionando arestas no grafo g
		g.addEdge("d", "e");
		g.addEdge("e", "c");
		g.addEdge("c", "i");
		g.addEdge("i", "f");
		g.addEdge("f", "d");
		
		// Adicionando vértices no grafo h
		h.addVertex("d");
		h.addVertex("a");
		h.addVertex("g");
		h.addVertex("b");
		
		// Adicionando arestas no grafo h
		h.addEdge("d", "a");
		h.addEdge("a", "g");
		h.addEdge("g", "b");
		h.addEdge("b", "d");
		
		// Resultados:
		System.out.println("Vértices da União dos grafos: " + uniao(g, h).vertexSet());
		System.out.println("Arestas da União dos grafos: " + uniao(g, h).edgeSet());
		System.out.println("\nVértices da Intersecção dos grafos: " + intercecao(g, h).vertexSet());
		System.out.println("Arestas da Intersecção dos grafos: " + intercecao(g, h).edgeSet());
	}
	
	/**
	 * Método responsável por gerar a união dos grafos dados como parâmetro.
	 * 
	 * @param g é um grafo.
	 * @param h é um grafo.
	 * 
	 * @return um grafo com a união entre g e h.
	 */
	
	private static Graph<String, DefaultEdge> uniao(Graph<String, DefaultEdge> g, Graph<String, DefaultEdge> h) {
		// Gerando o grafo da união
		Graph<String, DefaultEdge> novo = new AsGraphUnion<>(g, h);
		return novo;
	}
	
	
	/**
	 * Método responsável por gerar a interseção entre os grafos dados como parâmetro.
	 * 
	 * @param g é um grafo.
	 * @param h é um grafo.
	 * 
	 * @return um grafo que representa a interseção entre g e h
	 */
	
	private static Graph<String, DefaultEdge> intercecao(Graph<String, DefaultEdge> g, Graph<String, DefaultEdge> h) {
		//Gerando o grafo da interseção.
		Graph<String, DefaultEdge> inter = new SimpleGraph<>(DefaultEdge.class);
		
		// Pegando os vértices em comum nos dois grafos.
		for(String e : g.vertexSet()) {
			if (h.containsVertex(e)){
				inter.addVertex(e);
			}
		}
		
		Set<DefaultEdge> allEdge = g.edgeSet();
		Iterator<DefaultEdge> lista = allEdge.iterator();
		
		// Interando sobre as arestas para encontrar as arestas em comum.
		while(lista.hasNext()) {
			DefaultEdge v = lista.next();
			String v1 = v.toString();
			
			if (h.containsEdge(v)) {
				inter.addEdge(Character.toString(v1.charAt(1)), Character.toString(v1.charAt(5)));
			}
		}
		
		return inter;
	}
}
