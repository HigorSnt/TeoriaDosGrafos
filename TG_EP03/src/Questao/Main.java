package Questao;

import ImportGraph.DefaultVertex;
import ImportGraph.ImportGraph;
import ImportGraph.RelationshipEdge;

import java.util.Iterator;
import java.util.Set;

import org.jgrapht.Graph;
import org.jgrapht.alg.clique.DegeneracyBronKerboschCliqueFinder;
import org.jgrapht.graph.SimpleGraph;
import org.jgrapht.io.EdgeProvider;
import org.jgrapht.io.GmlImporter;
import org.jgrapht.io.ImportException;
import org.jgrapht.io.VertexProvider;

/**
 * 
 * @author HIGOR SANTOS DE BRITO DANTAS
 * @author GABRIEL CARVALHO DE LIMA
 * @author MATHEUS HENRIQUE FERNANDES JUSTINO
 *
 */

public class Main {

    public static void main(String[] args) {
    	Graph<DefaultVertex, RelationshipEdge> graph = new SimpleGraph<>(RelationshipEdge.class);
    	VertexProvider <DefaultVertex> vp1 = (label,attributes) -> new DefaultVertex (label,attributes);
    	EdgeProvider <DefaultVertex,RelationshipEdge> ep1 = (from,to,label,attributes) -> new RelationshipEdge(from,to,attributes);
    	GmlImporter <DefaultVertex,RelationshipEdge> gmlImporter = new GmlImporter <> (vp1,ep1);
  	    
    	try {
    		gmlImporter.importGraph(graph, ImportGraph.readFile("./graphs/lesmis.gml"));
    	} catch (ImportException e) {
    		throw new RuntimeException(e);
    	}
    	
    	Scores scores = new Scores();
    	System.out.println("--------   CLOSENESS CENTRALITY   --------" + System.lineSeparator());
        System.out.println(scores.closenessCentrality(graph) + System.lineSeparator());
        System.out.println("--------   ALPHA CENTRALITY   --------" + System.lineSeparator());
        System.out.println(scores.alphaCentrality(graph) + System.lineSeparator());
        System.out.println("--------   BETWEENNESS CENTRALITY   --------" + System.lineSeparator());
        System.out.println(scores.betweennessCentrality(graph) + System.lineSeparator());
        System.out.println("------------------------------------------------------------------------------");
        System.out.println("|-> COEFICIENTE DE AGRUPAMENTO (CLUSTERING COEFFICIENT) | " + String.format("%.4f", scores.clusteringCoeficient(graph)) + "	     |");
        System.out.println("|-> DIÂMETRO (DIAMETER)					| " + scores.diameter(graph) + "	    	     |");
        System.out.println("|-> DISTÂNCIA (DISTANCE)				| " + scores.distance(graph) + "	    	     |");
        System.out.println("------------------------------------------------------------------------------");
        
        DegeneracyBronKerboschCliqueFinder <DefaultVertex, RelationshipEdge> clique = new DegeneracyBronKerboschCliqueFinder <> (graph); 
        Iterator <Set<DefaultVertex>> it2 = clique.iterator();
	    System.out.print(System.lineSeparator() + "DegenearyBronKerboschCliqueFinder maximal cliques: \n");
	    while (it2.hasNext()) {
	    	System.out.print(it2.next() + " ");
	    }
    }
}
