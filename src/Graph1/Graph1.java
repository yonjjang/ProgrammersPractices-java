package Graph1;

public class Graph1 {

	public static void main(String[] args) {

		int n = 6;
		int[][] vertex = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};

		System.out.println(new Solution().solution(n, vertex));

	}

}
