
public class fibo {

	public static int f(int n) {
		
		if(n == 1 || n == 2) {
			return 1;
		}
		
		else {
			return f(n-1) + f(n-2);
		}
	}
	
	public static long dyf(int n) {
		
		long[] arr = new long[1000];
		arr[1] = 1;
		arr[2] = 1;
		
		for(int i = 3; i <= n; i++) {
			arr[i] = arr[i-1] + arr[i-2];
		}
		
		return arr[n];
	}
	
//	public static void main(String args[]) {
//		System.out.println(f(30));
//		System.out.println(dyf(100));
//		
//	}
	
}
