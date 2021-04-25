package DFS2;
class Solution {
    public int minDepth = 50;
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        boolean[] visited = new boolean[words.length];

        answer = dfs (begin, target, words, visited, 1);

        return answer;
    }


    public int dfs(String begin, String target, String[] words, boolean[] visited, int depth){
        int answer = 0;
        for (int i=0; i<words.length; i++){
            if (visited[i] != true){
                //System.out.println("Loop: "+begin+"/"+words[i]+"/"+depth);
                int cnt = 0;
                for (int j=0; j<words[i].length(); j++){
                    if (begin.charAt(j) != words[i].charAt(j)){
                        cnt++;
                    }
                }
                if (cnt == 1) {
                    if (words[i].equals(target)){
                        //System.out.println("Target 도달 Return: 깊이 "+depth);
                        if (minDepth > depth){
                            minDepth = depth;
                        }
                        return minDepth;
                    } else {
                        //System.out.println("변환: "+begin +"/"+ words[i] +"/"+ target);
                        visited[i] = true;
                        answer = dfs(words[i], target, words, visited, depth+1);
                    }
                }
            }
        }
        //System.out.println("완료: "+begin+"/"+depth+"/"+answer);
        return answer;
    }
}
