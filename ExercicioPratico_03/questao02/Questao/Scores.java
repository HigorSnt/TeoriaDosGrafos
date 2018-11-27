package Questao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.jgrapht.Graph;
import org.jgrapht.alg.cycle.PatonCycleBase;
import org.jgrapht.alg.scoring.AlphaCentrality;
import org.jgrapht.alg.scoring.BetweennessCentrality;
import org.jgrapht.alg.scoring.ClosenessCentrality;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.traverse.BreadthFirstIterator;

import Aux.Fatorial;
import ImportGraph.DefaultVertex;
import ImportGraph.RelationshipEdge;

/**
 * 
 * Classe adaptada dos exemplos disponibilizados.
 * 
 * @author HIGOR SANTOS DE BRITO DANTAS
 * @author GABRIEL CARVALHO DE LIMA
 * @author MATHEUS HENRIQUE FERNANDES JUSTINO
 *
 */

public class Scores {
	
	public String closenessCentrality(Graph <DefaultVertex, RelationshipEdge> graph) {
		ClosenessCentrality <DefaultVertex, RelationshipEdge> cc = new ClosenessCentrality <> (graph);
		return printOrderedDouble (cc.getScores(),0);
	}
	
	public String alphaCentrality(Graph <DefaultVertex, RelationshipEdge> graph) {
		AlphaCentrality <DefaultVertex, RelationshipEdge> ac = new AlphaCentrality <> (graph,0.1);
		return printOrderedDouble(ac.getScores(), 0);
	}
	
	public String betweennessCentrality(Graph <DefaultVertex, RelationshipEdge> graph) {
		BetweennessCentrality <DefaultVertex, RelationshipEdge> bc = new BetweennessCentrality <> (graph,true);
		return printOrderedDouble(bc.getScores(), 0);
	}
	
	public int diameter(Graph <DefaultVertex, RelationshipEdge> graph) {
		int diameter = 0;
		ArrayList <Integer> a = get_allpathLenghts(graph);
		int sum = 0;
		
		for(int i=0; i < a.size() ; i++) {
			sum = sum + a.get(i);
			if (diameter<a.get(i)) {
				diameter = a.get(i);
			}
		}
		
		return diameter;
	}
	
	public double distance(Graph <DefaultVertex, RelationshipEdge> graph) {
		ArrayList <Integer> a = get_allpathLenghts(graph);
		int sum = 0;
		for (Integer integer : a) {
			sum += integer;
		}
		
	    return sum / a.size();
	}
	
	public double clusteringCoeficient(Graph <DefaultVertex, RelationshipEdge> graph) {
		double triplets = get_NTriplets(graph);
        double triangles = get_NTriangles(graph);
	    
        return 3*triangles/triplets;
	}
	
	private static <V> String printOrderedDouble (Map <V,Double> M, int count) {
		Set<Entry<V, Double>> set = M.entrySet();
        List<Entry<V, Double>> list = new ArrayList<Entry<V, Double>>(set);
        Collections.sort( list, new Comparator<Map.Entry<V, Double>>()
        {
            public int compare( Map.Entry<V, Double> o1, Map.Entry<V, Double> o2 ) {
                return (o2.getValue()).compareTo( o1.getValue() );
            }
        } );
        
        if (count == 0) {
        	count = list.size();
        }
        
        String s = "";
        
        for (int i = 0; i<count; i++) {
        	Entry<V,Double> e = list.get(i);
        	s += e.getKey()+": "+ String.format("%.2f",(e.getValue()))+ "; ";
        }
        return s;
	}
	
	private static <V,E> double get_NTriplets (Graph <V, E> g) {
	 	
		double triplets = 0;
		BreadthFirstIterator <V,E> cfi = 
				new BreadthFirstIterator <> (g);
		while (cfi.hasNext()) {
			V v = cfi.next();
			int n = (g.edgesOf(v)).size();
			if (n >=2) {
				triplets = triplets + Fatorial.factorial(n) / (2* Fatorial.factorial(n-2));
			}
		}
		return triplets;
	}
	
	private static <V,E> double get_NTriangles (Graph <V,E> g) {
		double triangles = 0;
		PatonCycleBase <V,E> pc = new PatonCycleBase <> (g);
		Iterator <List<E>> it2 = ((pc.getCycleBasis()).getCycles()).iterator();
	    while (it2.hasNext()) {
	    	List <E> s = it2.next();
	    	if ((s).size()==3) {
	    		triangles++;
	    	}
	    }
	    return triangles;
	}
	
	private static <V,E> ArrayList <Integer> get_allpathLenghts (Graph <V,E> g) {
    	DijkstraShortestPath <V,E>  p = 
    			new DijkstraShortestPath <> (g);
    	ArrayList <Integer> a = new ArrayList <Integer> ();
    	BreadthFirstIterator <V,E> pf = 
    			new BreadthFirstIterator <> (g);
    	while (pf.hasNext()) {
    		V v1 = pf.next();
    		Iterator <V> vs = g.vertexSet().iterator();
    		while (vs.hasNext()) {
    			V v2 = vs.next();
    			int dist = (p.getPath(v1, v2)).getLength();
    			if (v1.equals(v2) == false) {
    				a.add(dist);
    			}
    		}			
    	}
        return a;
    }
	
}
