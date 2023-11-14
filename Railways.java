import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class Railways {
    public static List<Integer>[] graph;
    public static int[] colors;
    public static void main(String[] args){
        getGraph();
        boolean result = checkGraph();
        if(result){
            System.out.println("YES");
        }
        else {
            System.out.println("NO");
        }
    }

    public static boolean DFS(int startVertex){
        Stack<Integer> stack = new Stack<>();
        stack.push(startVertex);
        while(!stack.empty()){
            int v = stack.pop();
            if(colors[v] == 0){
                colors[v] = 1;
                stack.push(v);
                List<Integer> next = graph[v];
                for(int w: next){
                    if(colors[w] == 0){
                        stack.push(w);
                    } else if(colors[w] == 1){
                        return false;
                    }
                }
            }
            else if (colors[v] == 1){
                colors[v] = 2;
            }
        }
        return true;
    }

    public static boolean checkGraph(){
        for (int i = 0; i < graph.length; i++) {
            if (colors[i] == 0) {
                if(!DFS(i)){
                    return false;
                }
            }
        }
        return true;
    }


    private static void getGraph(){
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            int cities = Integer.parseInt(reader.readLine());
            graph = new ArrayList[cities];
            for (int i = 0; i < cities; i++) {
                List<Integer> info = new ArrayList<>();
                graph[i] = info;
            }
            colors = new int[cities];
            int n = cities - 1;
            for (int i = 0; i < n; i++) {
                String line = reader.readLine();
                char[] roads = line.toCharArray();
                for (int j = i + 1; j < cities; j++) {
                    Character letter = roads[j - i - 1];
                    if(letter.equals('B')){
                        graph[j].add(i);
                    } else {
                        graph[i].add(j);
                    }
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
} 