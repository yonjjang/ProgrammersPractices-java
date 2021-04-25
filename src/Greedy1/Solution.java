package Greedy1;
//import java.util.Arrays;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        
        int[] student = new int[n];
        
        for (int i=0; i<n; i++){
            student[i] = 1;
        }
        
        for (int i: lost){
            student[i-1]--;
        }
        
        for (int i: reserve){
            student[i-1]++;
        }
        
        //System.out.println(Arrays.toString(student));
        
        for (int i=0; i<student.length; i++){
            if (student[i] == 0){
                if(i-1>=0 && student[i-1]==2){
                    student[i]++;
                    student[i-1]--;
                } else if (i+1<student.length && student[i+1] ==2){
                    student[i]++;
                    student[i+1]--;
                }
            }
        }
        
        //System.out.println(Arrays.toString(student));
        for (int i: student){
            if (i>0)
                answer++;
        }
        return answer;
    }
}