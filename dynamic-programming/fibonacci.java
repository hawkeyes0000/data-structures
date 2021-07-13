/*

    Demonstrate nth fibonacci number using plain recursion and memoization
    
*/

public class Main
{
    // plain recursion
    static long dumbFibo(long n)
    {
        if (n <= 2)
        {
            return 1;
        }
        return dumbFibo(n - 1) + dumbFibo(n - 2);
    }
    
    // memoization
    static long wiseFibo(int n, long[] memo)
    {
        if(memo[n] != 0)
        {
            return memo[n];
        }
        if(n <= 2)
        {
            return 1;
        }
        memo[n] = wiseFibo(n-1, memo) + wiseFibo(n-2, memo);
        return memo[n];
    }
    
    // utility function to print the nth fibonacci value
    static void print(long message)
    {
        System.out.println(message);
    }
    
    public static void main(String[] args)
    {
        int n = 4;
        print(wiseFibo(n, new long[n+1]));
    }
}
