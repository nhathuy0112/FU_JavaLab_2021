package Lab_1;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

public class P_008{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your content");
        String s = input.nextLine();
        input.close();
        System.out.println(word_count(s));
        System.out.println(character_count(s));
    }

    public static Map<String,Integer> word_count(String s){
        Map<String,Integer> word_map = new HashMap<String,Integer>();
        StringTokenizer t = new StringTokenizer(s);
        while(t.hasMoreTokens()){
            String token = t.nextToken();
            if(word_map.containsKey(token))
                word_map.put(token, word_map.get(token)+1);
            else    
                word_map.put(token, 1);
        }
        return word_map;
    }

    public static Map<Character,Integer> character_count(String s){
        Map<Character,Integer> character_map = new HashMap<Character,Integer>();
        for(char c:s.toCharArray()){
            if(Character.isSpaceChar(c)) continue;
            if(character_map.containsKey(c))
                character_map.put(c, character_map.get(c)+1);
            else 
                character_map.put(c, 1);
        }
        return character_map;
    }
}