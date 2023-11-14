import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HeapSort {
    public static List<Participant> participants = new ArrayList<>();
    public static class Participant {
        private final String name;
        private final int problemsCount;
        private final int penalty;
        public Participant(String rawData){
            String[] data = rawData.split(" ");
            this.name = data[0];
            this.problemsCount = Integer.parseInt(data[1]);
            this.penalty = Integer.parseInt(data[2]);
        }


        private String getName(){
            return name;
        }


        public int compareTo(Participant participant){
            if(this.problemsCount != participant.problemsCount){
                return this.problemsCount - participant.problemsCount;
            }
            if(this.penalty != participant.penalty){
                return participant.penalty - this.penalty;
            }
            return participant.getName().compareTo(this.name);
        }
    }


    public static void main(String[] args) throws IOException {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))){
            int count = Integer.parseInt(reader.readLine());
            participants.add(null);
            for (int i = 0; i < count; i++) {
                Participant participant = new Participant(reader.readLine());
                add(participant);
            }
            for (int i = 0; i < count; i++) {
                writer.write(participants.get(1).getName());
                writer.newLine();
                delete();
            }
        }
    }


    public static void add(Participant participant){
        participants.add(participant);
        int index = participants.size() - 1;
        siftUp(index);
    }


    public static void delete(){
        participants.set(1, participants.get(participants.size()-1));
        participants.remove(participants.size()-1);
        siftDown(1);
    }

    public static void siftUp(int index){
        while(true){
            int parentIndex = index/2;
            if(index == 1 || participants.get(parentIndex).compareTo(participants.get(index)) > 0){
                return;
            }
            Collections.swap(participants, parentIndex, index);
            index = parentIndex;
        }
    }


    public static void siftDown(int index){
        while (true){
            int left = 2 * index;
            int right = 2 * index + 1;
            if(participants.size() - 1 < left){
                return;
            }
            int indexLargest = right <= participants.size() - 1
                    && participants.get(left).compareTo(participants.get(right)) < 0 ? right : left;
            if(participants.get(index).compareTo(participants.get(indexLargest)) > 0){
                return;
            }
            Collections.swap(participants, indexLargest, index);
            index = indexLargest;
        }
    }
}
