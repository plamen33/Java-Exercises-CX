package partone;
/**
 * Java is the best, who's the next
 */
import java.util.LinkedHashMap;
import java.util.Map;

public class TaskOne {
    public static void main(String[] args) {
        TaskOne one = new TaskOne();
        one.method("I love to play soccer.");
    }

    void method(String input){
        input = input.replace(" ", "");
        char[] array = input.toCharArray();
        Map<Character, Integer> map = new LinkedHashMap<>();
        for(int i = 0; i < array.length; i++){
            if(map.containsKey(array[i])){
                map.put(array[i], map.get(array[i])+1);
            }
            else{
                map.put(array[i], 1);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(Map.Entry e: map.entrySet()){
            //System.out.printf("%s->%d, ", e.getKey(), e.getValue());
            sb.append(e.getKey()+"->"+e.getValue()+", ");
        }
        String result = sb.toString();
        result = result.substring(0, result.length()-2);
        System.out.println(result);
    }
}
