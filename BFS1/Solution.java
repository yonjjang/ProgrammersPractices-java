import java.util.Queue;
import java.util.LinkedList;
class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];
        
        for (int i=0; i<n; i++){
            if (!visited[i]){
                answer++;
                bfs(computers, visited, i);
            }
        }
        
        return answer;
    }
    
    public boolean[] bfs(int[][] computers, boolean[] visited, int node){
        Queue<Integer> q = new LinkedList<>();
        q.offer(node);
        visited[node] = true;
        
        while(!q.isEmpty()){
            int curNode = q.poll();
            
            for (int i=0; i<computers.length; i++){
                if (curNode != i && computers[curNode][i] == 1 && !visited[i]){
                    visited[i] = true;
                    q.offer(i);
                }
            }
        }
        
        return visited;
        
        
    }
}