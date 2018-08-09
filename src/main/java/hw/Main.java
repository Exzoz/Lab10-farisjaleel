package hw;

import java.util.Arrays;
import org.jgrapht.Graph;
import org.jgrapht.alg.color.GreedyColoring;
import org.jgrapht.alg.color.SaturationDegreeColoring;
import org.jgrapht.alg.color.SmallestDegreeLastColoring;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;
import org.jgrapht.traverse.BreadthFirstIterator;
import org.jgrapht.traverse.ClosestFirstIterator;
import org.jgrapht.traverse.DepthFirstIterator;
import java.util.Iterator;
import java.util.Map;

public class Main {

    public static void main(final String[] args) {
        final Graph<String, DefaultEdge> myMap = new SimpleGraph<>(DefaultEdge.class);

        //Central country is AT - Austria
        myMap.addVertex(CountryCodes.AT);
        myMap.addVertex(CountryCodes.DE);
        myMap.addVertex(CountryCodes.CZ);
        myMap.addVertex(CountryCodes.SK);
        myMap.addVertex(CountryCodes.HU);
        myMap.addVertex(CountryCodes.SI);
        myMap.addVertex(CountryCodes.IT);
        myMap.addVertex(CountryCodes.CH);
        myMap.addVertex(CountryCodes.LI);

        myMap.addEdge(CountryCodes.AT, CountryCodes.DE);
        myMap.addEdge(CountryCodes.AT, CountryCodes.CZ);
        myMap.addEdge(CountryCodes.AT, CountryCodes.SK);
        myMap.addEdge(CountryCodes.AT, CountryCodes.HU);
        myMap.addEdge(CountryCodes.AT, CountryCodes.SI);
        myMap.addEdge(CountryCodes.AT, CountryCodes.IT);
        myMap.addEdge(CountryCodes.AT, CountryCodes.CH);
        myMap.addEdge(CountryCodes.AT, CountryCodes.LI);

        myMap.addEdge(CountryCodes.DE, CountryCodes.CZ);
        myMap.addEdge(CountryCodes.CZ, CountryCodes.SK);
        myMap.addEdge(CountryCodes.SK, CountryCodes.HU);
        myMap.addEdge(CountryCodes.HU, CountryCodes.SI);
        myMap.addEdge(CountryCodes.SI, CountryCodes.IT);
        myMap.addEdge(CountryCodes.IT, CountryCodes.CH);
        myMap.addEdge(CountryCodes.CH, CountryCodes.DE);
        myMap.addEdge(CountryCodes.CH, CountryCodes.LI);


        System.out.println("============= Central country first BreadthFirstIterator: =============");
        print(new BreadthFirstIterator<>(myMap, CountryCodes.AT));

        System.out.println("============= Edge country first BreadthFirst Iterator: =============");
        print(new BreadthFirstIterator<>(myMap, CountryCodes.CH));

        System.out.println("============= Central country first ClosestFirstIterator: =============");
        print(new ClosestFirstIterator<>(myMap, CountryCodes.AT));

        System.out.println("============= Edge country first ClosestFirstIterator: =============");
        print(new ClosestFirstIterator<>(myMap, CountryCodes.CH));

        System.out.println("============= Central country first DepthFirstIterator: =============");
        print(new DepthFirstIterator<>(myMap, CountryCodes.AT));

        System.out.println("============= Edge country first DepthFirstIterator: =============");
        print(new DepthFirstIterator<>(myMap, CountryCodes.CH));

        System.out.println("============= Colors by GreedyColoring: =============");

        GreedyColoring gc = new GreedyColoring(myMap);
        Map<String, Integer> colors = gc.getColoring().getColors();
        Iterator<Map.Entry<String, Integer>> it = colors.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, Integer> entry = it.next();
            System.out.println(entry);
        }
    }

    private static void print(final Iterator<String> iterator) {
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}

