package TP.TP6;

import java.util.HashMap;
import java.util.Map;

public class chiffrement {
    public static HashMap<Character,Character> createKey(int n, String alphabet){
//        if (alphabet.length() < n) throw  new IllegalArgumentException("string size is too small");
        if(alphabet.isEmpty()) throw new IllegalArgumentException("String is empty");

        HashMap<Character,Character> key = new HashMap<>();

        for (int i = 0; i < alphabet.length(); i++ ) {
            if (i+n < 0) {
                key.put(alphabet.charAt(i),alphabet.charAt((i+n) + alphabet.length()) );
            }
            else if (n+i >= alphabet.length()) {
                if ((i+n)-alphabet.length() < alphabet.length()) {
                 key.put(alphabet.charAt(i),alphabet.charAt((i+n)-alphabet.length()));
                }
                else {
                    key.put(alphabet.charAt(i),alphabet.charAt((i+n)-alphabet.length()-alphabet.length()));
                }
            }
            else key.put(alphabet.charAt(i),alphabet.charAt((i+n)));
        }
        return key;
    }
    public static String encode(String text, HashMap<Character,Character> key) {
        StringBuilder encode = new StringBuilder();
        for (char t : text.toCharArray()) {
            encode.append(key.get(t));
        }
        return encode.toString();
    }

    public static void main(String[] args) {
        HashMap<Character,Character> key = createKey(2,"ABCDEFGHIJKLMNOPQRSTUVWXYZ");
        System.out.println(key);
        System.out.println(encode("HELLO", key));
    }
}
