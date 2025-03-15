import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Optional;
import java.util.Stack;

public class Chapter5 {
    public static int countPrimes(int n){
        int count=0;
        for(int i=2; i<=n ; i++)
            if(isPrime(i)) count++;

        return count;
    }

    public static boolean isPrime(int num){
        int end = (int) Math.sqrt(num);
        for(int i=2; i <=  end; i++){
            if(num%i == 0)
                return false;
        }
        return true;
    }

    public static int countPrimes2(int n){
        boolean[] isPrime = new boolean[n+1];

        Arrays.fill(isPrime, true);
        for(int i=2; i*i <= n; i++ ){
            if(isPrime[i]){
                for(int j=i*2; j<=n ; j = j+i)
                    isPrime[j] = false;
            }
        }

        int count=0;
        for(int i =2; i <= n; i++)
            if(isPrime[i]) count++;

        return count;
    }
    static int base = 1237;
    public static int superPow(int a, Stack<Integer> b){
        //a^b[n-1]* superPow(a, b)^10
        if(b.empty())
            return 1;

        int result1 = mypow(a, b.pop());
        int result2 = mypow(superPow(a, b), 10);
        return (result1*result2) % base;
    }

    public static int mypow(int a, int pow){
        // (a*b)% c = a%c * b%c %c
        if(pow ==0)
            return a % base;

        int result= 1;
        for(int i=0; i<pow; i++){
            result = result * a;
            result %= base;
        }
        return result;
    }


    public static int minEatingSpeed(int[] piles, int H) {
        int max = Arrays.stream(piles).max().getAsInt();
        int result = -1;
        for (int i = 1; i <= max; i++) {
            if (canFinish(piles, H, i)) {
                return i;
            }

        }
        return result;

    }

    public static int minEatingSpeed2(int[] piles, int H){
        int max = Arrays.stream(piles).max().getAsInt();
        int left = 0;
        int right = piles.length + 1;
        while(left < right){
            int mid = left+(right-left)/2;
            if (canFinish(piles, H, mid)) {
                right = mid;
            }else
                left = mid+1;

        }
        return left;
    }

    public static boolean canFinish(int[] piles, int H, int speed){
        int remain = H;
        Stack<Integer> stk = new Stack<>();
        for(int i=0; i< piles.length; i++)
            stk.push(piles[i]);

        while(remain > 0 && !stk.empty()){
            int pileNum = stk.pop();
            if( pileNum > speed){
                stk.push(pileNum-speed);
            }
            remain--;
        }

        if(remain >= 0 && stk.empty())
            return true;
        return false;
    }

    public static int shipWithinDays(int[] weights, int days){
        int right= Arrays.stream(weights).sum() + 1;
        int left= Arrays.stream(weights).max().getAsInt();

        while(left < right){
            int cap = left + (right - left)/2;
            if(canShip(weights, days, cap)){
                right = cap;
            } else
                left = cap + 1;
        }
        return left;
    }

    public static boolean canShip(int[] weights, int days, int cap){
        int i = 0;
        for (int day = 0; day < days; day++){
            int tmpCap = cap;
            while((tmpCap -= weights[i]) >= 0){
                i++;
                if(i==weights.length)
                    return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] piles = {2,34,5,1};

        System.out.println(minEatingSpeed(piles, 10));

    }
}
