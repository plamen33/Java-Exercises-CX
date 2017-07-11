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
        for(String s : array){
            if(s.charAt(s.length()-1) == '.'){
                s = s.substring(0, s.length()-1);
                dot = true;
            }
            if(!map.containsKey(s)){
                map.put(s, ++a);
                if(dot){ sb.append(" " + a + ".");}
                else{sb.append(" " + a);}
            }
            else{
                if(dot){ sb.append(" " + map.get(s) + ".");}
                else{sb.append(" " + map.get(s));}
            }
            dot = false;
        }
        input = sb.substring(1);
        System.out.println(input);
    }
}
