import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
public class SearchSystem {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int nDoc = Integer.parseInt(reader.readLine());
            List<String> docs = new ArrayList<>();
            for (int i = 0; i < nDoc; i++) {
                docs.add(reader.readLine());
            }
            HashMap<String, HashMap<Integer, Integer>> preparedData = prepareData(docs);
            int nRequest = Integer.parseInt(reader.readLine());
            for (int i = 0; i < nRequest; i++) {
                findRelevant(preparedData, reader.readLine(), nDoc, writer);
                writer.newLine();
            }
        }
    }
    public static void findRelevant(HashMap<String, HashMap<Integer, Integer>> preparedData, String request, int n, BufferedWriter writer) throws IOException {
        Map<Integer, Integer> result = new HashMap<>();
        Set<String> requestSet = Arrays.stream(request.split(" ")).collect(Collectors.toSet());
        for(String word: requestSet){
            if(preparedData.containsKey(word)){
                for(Map.Entry<Integer, Integer> doc: preparedData.get(word).entrySet()){
                    Integer score = 0;
                    if(result.containsKey(doc.getKey())){
                        score = result.get(doc.getKey());
                    }
                    score = score + doc.getValue();
                    result.put(doc.getKey(), score);
                }
            }
        }
        int count = Math.min(result.size(), 5);
        for (int i = 0; i < count; i++) {
            Integer maxKey = getMax(result);
            writer.write(maxKey + " ");
            result.remove(maxKey);
        }
    }
    public static Integer getMax(Map<Integer, Integer> result){
        Integer maxKey = 0;
        Integer maxValue = 0;
        for(Map.Entry<Integer, Integer> pair: result.entrySet()){
            if(maxValue < pair.getValue()){
                maxValue = pair.getValue();
                maxKey = pair.getKey();
            } else if(maxValue.equals(pair.getValue())){
                if(maxKey > pair.getKey()){
                    maxKey = pair.getKey();
                }
            }
        }
        return maxKey;
    }
    public static HashMap<String, HashMap<Integer, Integer>> prepareData(List<String> docs){
        HashMap<String, HashMap<Integer, Integer>> preparedData = new HashMap<>();
        for (int i = 0; i < docs.size(); i++) {
            for(String word: docs.get(i).split(" ")){
                if(!preparedData.containsKey(word)){
                    HashMap<Integer, Integer> r = new HashMap<>();
                    preparedData.put(word, r);
                }
                if(!preparedData.get(word).containsKey(i+1)){
                    preparedData.get(word).put(i + 1, 1);
                } else{
                    preparedData.get(word).put(i + 1, preparedData.get(word).get(i+1) + 1);
                }
            }
        }
        return preparedData;
    }
}
