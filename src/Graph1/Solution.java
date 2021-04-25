package Graph1;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
	
    public int solution(int n, int[][] edge) {
        int answer = 0;
        int max = 0;
        
        // 방문 여부 Array
        int[] visited = new int[n+1];
        
        // 인접행렬을 만들 때, 메모리를 생각해서 Array 보다는 ArrayList로 구현한다.
        ArrayList<Integer>[] list = new ArrayList[n+1];
        
        // BFS 구현을 위한 Queue
        Queue<Integer> q = new LinkedList<>();
        
        for (int i=1; i<list.length; i++) {
        	list[i] = new ArrayList<Integer>();
        }
        
        for (int i=0; i<edge.length; i++) {
        	//System.out.println(i+"/"+edge[i][0]+"/"+edge[i][1]);
        	list[edge[i][0]].add(edge[i][1]);
        	list[edge[i][1]].add(edge[i][0]);
        }
        
        //System.out.println(Arrays.toString(list));
        
        q.offer(1);
        visited[1] = 1;
        while (!q.isEmpty()) {
        	int node = q.poll();
        	for (int i=0; i<list[node].size(); i++) {
        		int connected = list[node].get(i);
        		if (visited[connected] == 0) {
        			q.offer(connected);
        			visited[connected] = visited[node]+1; // 레벨 count
        			max = max<visited[connected]? visited[connected] : max;
        		}
        	}
        }
        
        for (int i=0; i<visited.length; i++) {
        	if (visited[i]==max) {
        		answer++;
        	}
        }
        //System.out.println(max);
        return answer;
    }
    
    
}