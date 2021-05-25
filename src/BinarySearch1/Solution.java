package BinarySearch1;
import java.util.Arrays;

class Solution {
	
	public long solution(int n, int[] times) {
		long answer = 0;
    	
    	long min = 1;
    	Arrays.sort(times);
    	long max = times[times.length-1] * (long)n;
    	
    	while(max >= min) {
    		long avail = 0;
    		long mid = (max+min) / 2;
    		
    		for (int time: times) {
    			avail += mid/time;
    		}
    		
    		if (avail >= n) {
    			max = mid-1;
    			answer = mid;
    		} else {
    			min = mid+1;
    		}
    		
    		
    	}    	
        
        return answer;
	}
}