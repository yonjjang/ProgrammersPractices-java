class Solution {
	public int solution(String begin, String target, String[] words) {
		boolean[] visited = new boolean[words.length + 1];	
        for(int i = 0; i < words.length; i++){
            if(target.equals(words[i]))
                return dfs(begin, target, words, visited);
        }
		return 0;
	}
    
    public int dfs(String begin, String target, String[] words, boolean[] visited) {
		int answer = 0;
		String start = "";
		
		for (int i = 0; i < words.length; i++) {
			if (visited[i]) {
                continue;
            }
			for (int j = 0; j < begin.length(); j++) {
				if (j > 0) {
                    start = begin.substring(0, j);
                } else {
                    start = "";
                }
				start += words[i].charAt(j);
                
                if (j < begin.length()-1){
                    start += begin.substring(j+1);
                } else {
                    start += "";
                }
                
				if (start.equals(target)) 
					return 1;
				if (start.equals(words[i])) {
					visited[i] = true;
					answer = 1;
					answer += dfs(start, target, words, visited);
				}
			}
		}
		return answer;
	}
	
}