package TestMixedQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class DeviceNames {
    public static List<String> deviceNamesSystem(List<String> devicenames) {
        // Write your code here
        List<String> uniqueNames = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();

        for(int i = 0; i < devicenames.size(); i++) {
            if(map.containsKey(devicenames.get(i))) {
                map.put(devicenames.get(i), map.get(devicenames.get(i)) + 1);
            }
            else {
                map.put(devicenames.get(i), 0);
            }
            if(map.get(devicenames.get(i)) == 0) {
                uniqueNames.add(devicenames.get(i));
            }
            else {
                uniqueNames.add(devicenames.get(i) + map.get(devicenames.get(i)));
            }
        }
        return uniqueNames;
    }

    public static void main(String[] args) {
        List<String> deviceNames = Arrays.asList("switch", "tv", "switch", "tv", "switch", "tv");
        List<String> result = deviceNamesSystem(deviceNames);
        for(int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i) + " ");
        }


    }
}
