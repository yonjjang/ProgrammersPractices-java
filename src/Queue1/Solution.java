package Queue1;
import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        
        Queue<Integer> onBridge = new LinkedList<>();
        Queue<Integer> offBridge = new LinkedList<>();
        Queue<Integer> waiting = new LinkedList<>();
        
        for (int i=0; i<truck_weights.length; i++){
            waiting.offer(truck_weights[i]);
        }
        
        for (int i=0; i<bridge_length; i++){
            onBridge.offer(0);
        }
        
        int onSum = 0;
        int cnt = 99999;
        
        while (!(waiting.isEmpty() && cnt == 0)){
            
            // 다리로 들어올 트럭
            int inTruck = 0;
            if (!waiting.isEmpty()){
                inTruck = waiting.peek();
            }
            // 다리에서 나갈 트럭
            int outTruck = onBridge.peek();
            
            onSum = 0;
            cnt = 0;
            for (int w: onBridge){
                onSum += w;
                if (w > 0){
                    cnt++;
                }
            }
            
            if (onSum+inTruck-outTruck <= weight){
                if (inTruck > 0){
                    inTruck = waiting.poll();
                    cnt++;
                }
                outTruck = onBridge.poll();
                if (outTruck>0) cnt--;
                
                onBridge.offer(inTruck);
                offBridge.offer(outTruck);
            } else {
                outTruck = onBridge.poll();
                if (outTruck>0) cnt--;
                
                onBridge.offer(0);
                offBridge.offer(outTruck);
            }
            answer++;
        }
        
        return answer;
    }
}