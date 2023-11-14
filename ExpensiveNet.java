import java.io.*;
import java.util.*;

public class ExpensiveNet {
    public static class Edge {
        private int end;
        private int weight;


        public Edge(Integer end, Integer weight) {
            this.end = end;
            this.weight = weight;
        }


        public int getWeight() {
            return weight;
        }


        public int getEnd() {
            return end;
        }


        public int compare(Edge e) {
            return e.getWeight() - this.getWeight();
        }
    }

    public static Integer[][] graph;
    static PriorityQueue<Edge> edges;
    static int[] added;

    public static void main(String[] args) {
        getGraph();
        OptionalInt max = getSpanningTree();
        if (max.isEmpty()) {
            System.out.println("Oops! I did it again");
        } else {
            System.out.println(max.getAsInt());
        }
    }

    private static void getGraph() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String[] args = reader.readLine().split(" ");
            int v = Integer.parseInt(args[0]);
            int e = Integer.parseInt(args[1]);
            graph = new Integer[v + 1][v + 1];
            for (int i = 0; i < e; i++) {
                String[] line = reader.readLine().split(" ");
                int firstV = Integer.parseInt(line[0]);
                int secondV = Integer.parseInt(line[1]);
                int weight = graph[firstV][secondV] != null ? Integer.max(graph[firstV][secondV], Integer.parseInt(line[2]))
                        : Integer.parseInt(line[2]);
                graph[firstV][secondV] = weight;
                graph[secondV][firstV] = weight;
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static OptionalInt getSpanningTree() {
        int mstLength = 0;
        added = new int[graph.length];
        List<Integer> values = new ArrayList<>();
        edges = new PriorityQueue<>(Edge::compare);
        int v = 1;
        added[v] = 1;
        addToEdges(v);
        while (Arrays.stream(added).sum() < graph.length - 1 && edges.size() > 0) {
            Edge max = edges.poll();
            if (added[max.getEnd()] == 0) {
                mstLength += max.getWeight();
                added[max.getEnd()] = 1;
                addToEdges(max.getEnd());
            }
        }
        if (Arrays.stream(added).sum() < graph.length - 1) {
            return OptionalInt.empty();
        } else {
            return OptionalInt.of(mstLength);
        }
    }


    private static void addToEdges(int vertex) {
        for (int i = 0; i < graph.length; i++) {
            if (graph[vertex][i] != null && added[i] != 1) {
                edges.add(new Edge(i, graph[vertex][i]));
            }
        }
    }
}
