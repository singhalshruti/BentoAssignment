import java.util.HashMap;
import java.util.Map;
import java.util.*;

public class PrintAnagrams {
    public static void main(String[] args) {
        List<String> wordDictionary = new ArrayList<>(
                Arrays.asList("vase", "bat", "gods", "latte", "name", "apres", "spit", "joke", "ham", "dog", "act", "tale", "parse", "pits", "asper", "tab", "table", "mane", "late", "god", "cat", "table", "save", "spare"));
        List<List<String>> anagramList = groupAnagrams(wordDictionary);
    }
    public static List<List<String>> groupAnagrams(List<String> wordDictionary) {
        if (wordDictionary.isEmpty()) {
            return new ArrayList();
        }  
        Map<String, List> ans = new HashMap<String, List>();
        List<String> anagramPairList = new ArrayList<>();
        for (String s : wordDictionary) {
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String key = String.valueOf(ca);
            if (ans.containsKey(key)) {
                anagramPairList = (ans.get(key));
                if (anagramPairList != null && anagramPairList.size() >= 1) {
                    for (String anagram : anagramPairList) {
                        if(!anagram.equals(s)){
                        System.out.println(anagram + " " + s);
                        }
                        else{
                            //The following two words were duplicates in the list but are still technically anagrams so still printing them
                        System.out.println(anagram + " " + s);   
                        }
                    }
                }
            } else if (!ans.containsKey(key)) {
                ans.put(key, new ArrayList());
            }
            ans.get(key).add(s);
        }
        return new ArrayList(ans.values());
    }
}