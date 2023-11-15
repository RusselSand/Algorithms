import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
public class EfficientQuickSort {
    private static class User{
        private final String name;
        private final int numberOfTasks;
        private final int penalty;
        @Override
        public String toString() {
            return name;
        }
        public String getName() {
            return name;
        }
        public int getNumberOfTasks() {
            return numberOfTasks;
        }
        public int getPenalty() {
            return penalty;
        }
        public User(String name, int numberOfTasks, int penalty) {
            this.name = name;
            this.numberOfTasks = numberOfTasks;
            this.penalty = penalty;
        }
        public int compareTo(User user){
            if(this.numberOfTasks != user.getNumberOfTasks()){
                return this.numberOfTasks - user.getNumberOfTasks();
            }
            if(this.penalty != user.getPenalty()){
                return user.getPenalty() - this.penalty;
            }
            return user.getName().compareTo(this.name);
        }
    }
    public static void main(String[] args) throws IOException {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            int number = Integer.parseInt(reader.readLine());
            List<User> users = new ArrayList<>();
            for(int i = 0; i < number; i++){
                List<String> data = Arrays.stream(reader.readLine().split(" ")).collect(Collectors.toList());
                User user = new User(data.get(0), Integer.parseInt(data.get(1)), Integer.parseInt(data.get(2)));
                users.add(user);
            }
            inPlaceQuickSort(users, 0, number-1);
            users.forEach(System.out::println);
        }
    }

    private static void inPlaceQuickSort(List<User> users, int start, int end){
        if(end - start == 1){
            if(users.get(start).compareTo(users.get(end)) < 0){
                Collections.swap(users, start, end);
            }
            return;
        } else if(end - start < 1){
            return;
        }
        int middle = (end + start)/2;
        int left = start;
        int right = end;
        User pivot = users.get(middle);
        while(left <= right){
            while(users.get(left).compareTo(pivot) > 0){
                left++;
            }
            while(users.get(right).compareTo(pivot) < 0){
                right--;
            }
            if(left >= right){
                break;
            }
            Collections.swap(users, left, right);
        }
        inPlaceQuickSort(users, start, left);
        inPlaceQuickSort(users, right, end);
    }

}
