package DynamicProgramming;

import java.io.*;
import java.util.*;

public class CreatingString {

    public static HashSet<String> arr = new HashSet<>();

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        boolean[] used = new boolean[s.length()];
        helper(s, "", used);

        // HashSet → ArrayList for sorting
        ArrayList<String> ans = new ArrayList<>(arr);
        Collections.sort(ans);

        System.out.println(ans.size());
        for (int i = 0; i < ans.size(); i++) {
            System.out.println(ans.get(i));
        }
    }

    public static void helper(String str, String temp, boolean[] used) {

        if (temp.length() == str.length()) {
            arr.add(temp);   // HashSet removes duplicates
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            if (!used[i]) {
                used[i] = true;
                helper(str, temp + str.charAt(i), used);
                used[i] = false;
            }
        }
    }
}
