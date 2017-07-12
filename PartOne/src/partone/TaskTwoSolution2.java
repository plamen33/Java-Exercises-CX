package partone;

import java.util.LinkedHashMap;
import java.util.Map;

public class TaskTwoSolution2 {
    public static void main(String[] args) {
        TaskTwoSolution2 taskTwo = new TaskTwoSolution2();
        taskTwo.method("My dog saw another dog playing in the garden. Second dog is not my dog. Either this is not my garden.");
    }

    void method(String input){
        Map<String, Integer> map = new LinkedHashMap<>();
        int a = 0;

        String[] array = input.split(" ");
        boolean dot = false;
        StringBuilder sb = new StringBuilder();
        for(String word : array){
            if(word.charAt(word.length()-1) == '.'){
                word = word.substring(0, word.length()-1);
                dot = true;
            }
            if(!map.containsKey(word)){
                map.put(word, ++a);
                if(dot){ sb.append(" " + a + ".");}
                else{sb.append(" " + a);}
            }
            else{
                if(dot){ sb.append(" " + map.get(word) + ".");}
                else{sb.append(" " + map.get(word));}
            }
            dot = false;
        }
        input = sb.substring(1);
        System.out.println(input);
    }
}
