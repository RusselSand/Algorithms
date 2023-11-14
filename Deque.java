import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.OptionalInt;

public class Deque {
    private static Integer[] queue;
    private static int maxN;
    private static int head;
    private static int tail;
    private static int size;

    public static void main(String[] args) throws IOException {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            int numberCommands = readInt(reader);
            maxN = readInt(reader);
            queue = new Integer[maxN];
            for(int i = 0; i < numberCommands; i++) {
                readCommands(reader.readLine());
            }
        }
    }

    public static int readInt(BufferedReader reader) throws IOException {
        return Integer.parseInt(reader.readLine());
    }
    public static void readCommands(String command) {
        switch (command) {
            case "pop_front":
                var result = pop_front();
                if(result.isEmpty()){
                    System.out.println("error");
                } else {
                    System.out.println(result.getAsInt());
                }
                break;
            case "pop_back":
                result = pop_back();
                if(result.isEmpty()){
                    System.out.println("error");
                } else {
                    System.out.println(result.getAsInt());
                }
                break;
            default:
                String[] com = command.split(" ");
                if(com[0].equals("push_back")){
                    if(!push_back(Integer.parseInt(com[1]))){
                        System.out.println("error");
                    };
                } else {
                    if(!push_front(Integer.parseInt(com[1]))){
                        System.out.println("error");
                    }
                }
        }
    }

    public static OptionalInt pop_front(){
        OptionalInt result = OptionalInt.empty();
        if(size != 0){
            result = OptionalInt.of(queue[head]);
            queue[head] = null;
            if(size != 1) {
                head = (head + 1) % maxN;
            }
            size--;
        }
        return result;
    }

    public static OptionalInt pop_back(){
        OptionalInt result = OptionalInt.empty();
        if(size != 0){
            result = OptionalInt.of(queue[tail]);
            queue[tail] = null;
            if(size != 1) {
                tail = tail == 0 ? maxN - 1 : tail - 1;
            }
            size--;
        }
        return result;
    }

    public static boolean push_front(int number){
        if(size != maxN){
            if(size > 0){
                head = head == 0? maxN - 1: head - 1;
            }
            queue[head] = number;
            size++;
            return true;
        }
        else {
            return false;
        }
    }
    public static boolean push_back(int number){
        if(size != maxN){
            if(size > 0){
                tail = (tail + 1) % maxN;
            }
            queue[tail] = number;
            size++;
            return true;
        }
        else {
            return false;
        }
    }
}