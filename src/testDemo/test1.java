package testDemo;

import java.util.HashMap;
import java.util.Map;

/*
Write a program which takes the following string as input and returns a HashMap where key is the string and value is the number of times it occurs.
String input = "red,yellow,blue,red,red,black,yellow, yellow";

 */
public class test1 {
    static void result(String s) {
        Map<String, Integer> map = new HashMap<>();

        String[] str = s.split("[, ]+");
        for(int i = 0; i < str.length; i++) {
            if(map.containsKey(str[i])) {
                map.put(str[i], map.get(str[i]) + 1);
            }
            else {
                map.put(str[i], 1);
            }
        }

        for(Map.Entry entry : map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        result("red,yellow,blue,red,red,black,yellow, yellow");
    }
}
