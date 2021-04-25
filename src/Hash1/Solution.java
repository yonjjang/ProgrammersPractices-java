package Hash1;
import java.util.HashMap;
import java.util.Set;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> map1 = new HashMap();
        for (int i=0; i<participant.length; i++){
            String key = participant[i];
            if (map1.containsKey(key)){
                map1.put(key, map1.get(key)+1);
            } else {
                map1.put(key, 1);
            }
        }
        
        for (int i=0; i<completion.length; i++){
            String key = completion[i];
            if (map1.get(key) == 1){
                map1.remove(key);
            } else if (map1.get(key) > 1) {
                map1.put(key, map1.get(key)-1);
            }
        }    
        
        Set<String> keys = map1.keySet();
        
        for (String key : keys){
            answer = key;
        }
        
        return answer;
    }
}