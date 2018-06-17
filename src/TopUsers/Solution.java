package TopUsers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import static java.util.stream.Collectors.toMap;

public class Solution {
    public static void main(String[] args) {
        printTopUsers(3);
    }

    public static void printTopUsers(int top) {
        ArrayList<String> comments = new ArrayList<String>() {{
            add("Juan: I like pizza.");
            add("Alejandro: I like vegan pizza.");
            add("Nailah: I like salad.");
            add("Nailah: I love sweet potato pie.");
            add("Alejandro: I love sweet potato pie as well.");
            add("Juilet: I love food in general.");
        }};

        HashMap<String, Integer> spokenWordsByUser = new HashMap<String, Integer>();

        String name = "";
        String[] sentence = {};
        String[] comment = {};

        for (int i = 0; i < comments.size(); i++) {
            comment = comments.get(i).split(":");
            name = comment[0];
            sentence = comment[1].trim().split(" ");
            if (!spokenWordsByUser.containsKey(name)) {
                spokenWordsByUser.put(name, sentence.length);
            } else {
                spokenWordsByUser.put(name, spokenWordsByUser.get(name) + sentence.length);
            }
        }

        Map<String, Integer> sorted = spokenWordsByUser
                .entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .collect(toMap(e -> e.getKey(), e -> e.getValue(), (e1, e2) -> e1, LinkedHashMap::new));


        sorted.entrySet().stream().limit(top).forEach((entry)->{
            System.out.println(entry.getKey() + ": " + entry.getValue());
        });
    }
}


class User {
    public String name;
    public int comments;
}