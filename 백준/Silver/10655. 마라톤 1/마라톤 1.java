import java.util.*;
import java.io.*;

public class Main {
	
	static int N, distance;
	static int[][] arr;
	static int result = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][2];
		
		StringTokenizer st;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
			if(i >= 1) {
				distance += Math.abs(arr[i][0] - arr[i-1][0]) +Math.abs(arr[i][1] - arr[i-1][1]); 
			}
		}
		
		for(int i = 1; i < N-1 ; i++) {
			int original = Math.abs(arr[i][0]-arr[i-1][0]) 
					+ Math.abs(arr[i][1]-arr[i-1][1])
					+ Math.abs(arr[i][0]-arr[i+1][0]) 
					+ Math.abs(arr[i][1]-arr[i+1][1]);
			int jump = Math.abs(arr[i-1][0] - arr[i+1][0])
					+ Math.abs(arr[i-1][1] - arr[i+1][1]);
			
			result = Math.min(result, distance - original + jump);
		}		
		System.out.println(result);
		
		
	}

}