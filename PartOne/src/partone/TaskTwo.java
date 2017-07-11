package partone;

import java.util.LinkedHashMap;
import java.util.Map;

public class TaskTwo {
    public static void main(String[] args) {
        TaskTwo taskTwo = new TaskTwo();
        taskTwo.method("My dog saw another dog playing in the garden. Second dog is not my dog. Either this is not my garden.");
    }

    void method(String input){
        Map<String, Integer> map = new LinkedHashMap<>();
        int a = 0;

        String[] array = input.split(" ");
        for(String s : array){
         if(s.charAt(s.length()-1) == '.'){
            s = s.substring(0, s.length()-1);
        }
               if(!map.containsKey(s)){
                   map.put(s, ++a);
               }
        }

        for(String s : array){
            if(s.charAt(s.length()-1) == '.'){
                s = s.substring(0, s.length()-1);
                System.out.printf("%d. ", map.get(s));
            }
            else{
                System.out.printf("%d ", map.get(s));
            }
        }
    }
}
