package DFS1;

class Solution {
    public int solution(int[] numbers, int target) {
        int answer = 0;
        
        answer += dfs(numbers, target, 0, 0);
        return answer;
    }
    
    public int dfs (int[] numbers, int target, int index, int preSum){
        if (index == numbers.length){
            if (target == preSum){
                return 1;
            } else {
                return 0;
            }
        } else {
            int answer = 0;
            answer += dfs(numbers, target, index+1, preSum + numbers[index]);
            answer += dfs(numbers, target, index+1, preSum - numbers[index]);
            return answer;
        }
        
    }
}