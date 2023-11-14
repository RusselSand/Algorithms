import java.io.*;
import java.util.Objects;
import java.util.OptionalInt;

public class HashTable {

    static class Pair {
        public Integer key;
        public Integer value;


        public Pair(Integer key, Integer value){
            this.key = key;
            this.value = value;
        }
    }


    static class Node{
        public Pair value;
        public Node next;


        public Node(Pair value, Node next){
            this.next = next;
            this.value = value;
        }
    }



    private static final Node[] pairs = new Node[131072];
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int operationsNumber = Integer.parseInt(reader.readLine());
            for (int i = 0; i < operationsNumber; i++) {
                String command = reader.readLine();
                doCommand(command, writer);
            }
        }
    }


    public static void doCommand(String command, BufferedWriter writer) throws IOException{
        String[] commandValues = command.split(" ");
        OptionalInt result;
        switch (commandValues[0]){
            case("get"):
                result = get(Integer.parseInt(commandValues[1]));
                print(writer, result);
                break;
            case("delete"):
                result = delete(Integer.parseInt(commandValues[1]));
                print(writer, result);
                break;
            default:
                put(Integer.parseInt(commandValues[1]), Integer.parseInt(commandValues[2]));
        }
    }



    private static void print(BufferedWriter writer, OptionalInt result) throws IOException {
        if(result.isPresent()){
            writer.write(Integer.toString(result.getAsInt()));
        } else{
            writer.write("None");
        }
        writer.newLine();
    }



    private static int getSize(int operations){
        int n = 1;
        while(operations > 2){
            operations = operations / 2;
            n++;
        }
        return n;
    }

    private static OptionalInt get(Integer key){
        int bucket = getBucket(key);
        Node search = getNode(key, bucket);
        if(search == null){
            return OptionalInt.empty();
        }
        return OptionalInt.of(search.value.value);
    }



    private static Node getNode(Integer key, int bucket){
        if(pairs[bucket] == null){
            return null;
        }
        Node search = pairs[bucket];
        while(search != null){
            if(Objects.equals(search.value.key, key)){
                return search;
            }
            search = search.next;
        }
        return null;
    }


    private static OptionalInt delete(Integer key){
        int bucket = getBucket(key);;
        if(pairs[bucket] == null){
            return OptionalInt.empty();
        }
        Node search = pairs[bucket];
        Node prev = null;
        while(search != null){
            if(Objects.equals(search.value.key, key)){
                OptionalInt result = OptionalInt.of(search.value.value);
                if(prev == null){
                    pairs[bucket] = search.next;
                } else {
                    prev.next = search.next;
                }
                return result;
            }
            prev = search;
            search = search.next;
        }
        return OptionalInt.empty();
    }


    private static void put(Integer key, Integer value){
        int bucket = getBucket(key);
        Node search = getNode(key, bucket);
        if(search != null){
            search.value.value = value;
            return;
        }
        Pair pair = new Pair(key, value);
        Node node = new Node(pair, null);
        if(pairs[bucket] != null){
            node.next = pairs[bucket];
        }
        pairs[bucket] = node;
    }


    private static int getBucket(Integer key){
        return (pairs.length - 1) & key;
    }
}
