import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Scanner;

public class CryptoCode {
    public static long getPossible(String code) {
        long result = 0;
        //System.out.println((code));
        if (code.length() == 0 || code.equals("0")) {
            return 0;
        }
        else if (code.length() == 1 || code.equals("10") || code.equals("20")) {
            return 1;
        }
        else {
        	result = d(code);
            return result;
        }
    }
    public static int d(String code) {
    	
    	int l = code.length();
    	int[] dp = new int[5001];

    	dp[0] = 1;
    	dp[1] = 2;
    	if(Integer.parseInt(code.substring(0,2)) > 26)
    		dp[1] = 1;
    	for(int i = 2; i  < l; i++) {
    		String pre = code.substring(i-1,i);
    	    String cur = code.substring(i,i+1);
    	    if(Integer.parseInt(cur) == 0 ||Integer.parseInt(pre) == 0) {
    	    	dp[i] = dp[i-1];
    	    }
    	    	
    	    else if(isok(Integer.parseInt(pre + cur))) {	    		
    	    	dp[i] = dp[i-1] + dp[i-2];
    	    }
    	    else {
    	    	dp[i] = dp[i-1];
    	    }
    	}
//    	for(int i = 0; i  <= l; i++) {
//    		System.out.print(dp[i]+ ",");
//    	
//    	}
//   	System.out.println();
    	return dp[l-1] % 1000000;
    	
    }
   
    public static boolean isok(int n) {
    	if(n > 0 && n <= 26) return true;
    	else return false;
	}
	public static void main(String[] args) throws IOException 
    {
		while(true) {

			
		Scanner s = new Scanner(System.in);

		
		String to = s.nextLine();

        System.out.println(getPossible(to));  
		}
    }
}//			

//  여기에 test code를 작성해서 작성한 함수를 테스트해볼 수 있습니다.
//         System.out.println(getPossible("25114"));    // 6 출력
//         System.out.println(getPossible("1111"));    // 5 출력 
//         System.out.println(getPossible("11111111111111111111"));     // 10946 출력
//		1111111111    89
//		3333333333    1
////    	
//    }
//}