package partone;

import java.util.LinkedHashMap;
import java.util.Map;

public class TaskTwo {
    public static void main(String[] args) {
        TaskTwo taskTwo = new TaskTwo();
        taskTwo.method("My dog saw another dog playing in the garden. Second dog is not my dog. Either this is not my garden.");
    }

    private void method(String input){
        Map<String, Integer> map = new LinkedHashMap<>();
        int a = 0;

        String[] array = input.split(" ");
        for(String word : array){
         if(word.charAt(word.length()-1) == '.'){
            word = word.substring(0, word.length()-1);
        }
               if(!map.containsKey(word)){
                   map.put(word, ++a);
               }
        }

        for(String word : array){
            if(word.charAt(word.length()-1) == '.'){
                word = word.substring(0, word.length()-1);
                System.out.printf("%d. ", map.get(word));
            }
            else{
                System.out.printf("%d ", map.get(word));
            }
        }
    }
}
