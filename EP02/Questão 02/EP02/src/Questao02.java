import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.jgrapht.GraphPath;
import org.jgrapht.alg.shortestpath.AllDirectedPaths;
import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultEdge;

/**
 * Classe responsável por auxiliar ao planejamento de trânsito de uma cidade.
 * 
 * @author GABRIEL CARVALHO DE LIMA
 * @author HIGOR SANTOS DE BRITO DANTAS
 * @author MATHEUS HENRIQUE FERNANDES JUSTINO
 */

public class Questao02 {
	
	public static void main(String[] args) {
		
		/* Gerando um grafo g */
		DefaultDirectedGraph<String, DefaultEdge> g = new DefaultDirectedGraph<>(DefaultEdge.class);
		
		System.out.println("SOLUÇÃO DA QUESTÃO 02\n");
		
		g.addVertex("1");		g.addVertex("2");
		g.addVertex("3");		g.addVertex("4");
		g.addVertex("5");		g.addVertex("6");
		g.addVertex("7");		g.addVertex("8");
		g.addVertex("9");		g.addVertex("10");
		g.addVertex("11");		g.addVertex("12");
		g.addVertex("13");		g.addVertex("14");
		g.addVertex("15");		g.addVertex("16");
		g.addVertex("17");		g.addVertex("18");
		g.addVertex("19");		g.addVertex("20");
		
		g.addEdge("1", "2");	g.addEdge("2", "6");	g.addEdge("6", "5");
		g.addEdge("5", "1");	g.addEdge("6", "7");	g.addEdge("7", "3");
		g.addEdge("3", "2");	g.addEdge("3", "4");	g.addEdge("8", "4");
		g.addEdge("8", "7");	g.addEdge("5", "9"); 	g.addEdge("9", "10");
		g.addEdge("6", "10");	g.addEdge("11", "10");	g.addEdge("11", "7");
		g.addEdge("12", "11");	g.addEdge("8", "12");	g.addEdge("13", "9");
		g.addEdge("13", "14");	g.addEdge("14", "10");	g.addEdge("15", "14");
		g.addEdge("11", "15");	g.addEdge("16", "15");	g.addEdge("12", "16");
		g.addEdge("17", "13");	g.addEdge("17", "18");	g.addEdge("14", "18");
		g.addEdge("19", "18");	g.addEdge("15", "19");	g.addEdge("20", "16");
		g.addEdge("20", "19");
		
		/** Criando uma nova instância do grafo g. */
		AllDirectedPaths <String,DefaultEdge> p = new AllDirectedPaths <> (g);
		
		System.out.println("RESPOSTA DA QUESTÃO 02 - PARTE 1:\n");
		
		/** Chama uma função auxiliar pra pegar cada vértice e verificar quais
		 * vértices não tem como trafegar em ambos sentidos. */
		LinkedHashMap <String, List<String>> ambosSentidos = trafegarAmbosSentidos(g, p);
		
		/** Imprime os vértices que não tem como chegar partindo de um t. */
		for (String t : ambosSentidos.keySet()) {
			System.out.println("Tendo o vértice " + t + " como origem não é possível chegar nos"
					+ " seguintes vértices:\n");
			System.out.println(ambosSentidos.get(t));
		}
		
		System.out.println("\nRESPOSTA DA QUESTÃO 02 - PARTE 2:\n");
		
		/** Chama uma função auxiliar pra pegar os percursos que são impossíveis. */
		System.out.println("São vértices inacessíveis:");
		System.out.println("OBS.: Como são vértices inacessíveis, nenhum caminho que tenha eles como"
				+ " chegada será possível");
		List <String> cruzamentosInacessiveis = verticesInacessiveis(g);
		for (String e : cruzamentosInacessiveis) {
			System.out.println(e);
		}
		
		System.out.println("\nRESPOSTA DA QUESTÃO 02 - PARTE 3:\n");
		
		/** Tamanho  dos percursos possíveis */
		List<GraphPath<String, DefaultEdge>> caminhos;
		for (String v : g.vertexSet()) {
			for (String x : g.vertexSet()) {
				if (x.equals(v)) {
					continue;
				}
				caminhos = p.getAllPaths(v, x, true, null);
				System.out.println("Percurso: (" + v + " -> " + x + "):" );
				System.out.println(caminhos);
				System.out.println(tamanho(caminhos));
			}
			
		}
		
	}
	
	/**
	 * Dado um grafo g, será analisado quais vértices de g não possuem algum percurso
	 * entre eles.
	 * 
	 * @param g é um grafo.
	 * @param p é uma instância do grafo g.
	 * 
	 * @return Retorna um map que manterá a ordem de entrada, onde o vértice de origem é a chave
	 * e o valor é uma lista com todos os vértices que não tem caminho possível entre eles.
	 */
	public static LinkedHashMap<String, List<String>> trafegarAmbosSentidos(DefaultDirectedGraph<String, DefaultEdge> g,
			AllDirectedPaths <String,DefaultEdge> p){
		LinkedHashMap <String, List<String>> ambosSentidos = new LinkedHashMap<>();
		
		for (String origem : g.vertexSet()) {
			List <String> vertices = new ArrayList<>();
			for (String destino : g.vertexSet()) {
				
				List<GraphPath<String, DefaultEdge>> caminhos = p.getAllPaths(origem, destino, true, null);
				
				if (caminhos.size() == 0) {
					vertices.add(destino);
				}
			ambosSentidos.put(origem, vertices);
			}
		}
		return ambosSentidos;
	}
	
	/**
	 * Dado um grafo g, essa função irá pegar cada vértice e analisar o grau de entrada,
	 * se o grau de entrada for 0 significa que esse vértice é inacessível a partir de qualquer outro.
	 * 
	 * @param g é um grafo.
	 * @return uma lista com todos os vértices que possuem grau 0 de entrada.
	 */
	public static List<String> verticesInacessiveis(DefaultDirectedGraph<String, DefaultEdge> g){
		List <String> saida = new ArrayList<>();
		
		for (String e : g.vertexSet()) {
			if (g.inDegreeOf(e) == 0) {
				saida.add(e);
			}
		}
		
		return saida;
	}
	
	/**
	 * Dado os percursos possíveis entre dois vértices, esta função irá analisar qual o maior e o
	 * menor caminho possível, e o tamanho médio de todos os caminhos.
	 * 
	 * @param caminhos é uma lista com os percursos possíveis entre dois vértices
	 * @return Retorna uma string contendo o tamanho do maior e menor percurso e a média 
	 * entre todos eles.
	 */
	public static String tamanho (List<GraphPath<String, DefaultEdge>> caminhos) {
		if (caminhos.size() == 0) {
			return "MAIOR PERCURSO: 0 trechos, MENOR PERCURSO: 0 trechos, "
					+ " MÉDIA: 0.0\n";
		}
		
		int maior = caminhos.get(0).getLength();
		int menor = caminhos.get(0).getLength();
		double soma = 0;
		
		for (GraphPath<String, DefaultEdge> graphPath : caminhos) {
			if (graphPath.getLength() > maior) {
				maior = graphPath.getLength();
			}
			if (graphPath.getLength() < menor) {
				menor = graphPath.getLength();
			}
			soma += graphPath.getLength();
		}
		
		return "MAIOR PERCURSO: " + maior + " trechos, MENOR PERCURSO: " + menor + " trechos, "
				+ " MÉDIA: " + (soma / caminhos.size()) + "\n";
	}
	
}