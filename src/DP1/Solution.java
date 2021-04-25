package DP1;
import java.lang.Math;
class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        int maxLength = triangle.length;
        
        int[][] tree = new int[maxLength][maxLength];
        for (int i=0; i<triangle.length; i++){
            for (int j=0; j<triangle[i].length; j++){
                tree[i][j] = 0;
            }
        }
        tree[0][0] = triangle[0][0];
        
        for (int i=1; i<triangle.length; i++){
            for (int j=0; j<=i; j++){
                if (j==0){
                    tree[i][j] = tree[i-1][j]+triangle[i][j];    
                    //System.out.println(tree[i][j]);
                } else if (i==j){
                    tree[i][j] = tree[i-1][j-1]+triangle[i][j];
                    //System.out.println(tree[i][j]);
                } else {
                    tree[i][j] = Math.max(tree[i-1][j-1]+triangle[i][j], tree[i-1][j]+triangle[i][j]);
                    //System.out.println(tree[i][j]);
                }
            }
        }
        
        for (int i=0; i<tree[maxLength-1].length; i++){
            if (answer < tree[maxLength-1][i]){
                answer = tree[maxLength-1][i];
            }
        }
        
        return answer;
    }
}