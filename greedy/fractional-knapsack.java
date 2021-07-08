/*

    Given weights and values of N items, we need to put these items in a knapsack of capacity W to get the maximum total value in the knapsack.
    Note: Unlike 0/1 knapsack, you are allowed to break the item. 



    Example 1:

    Input:
    N = 3, W = 50
    values[] = {60,100,120}
    weight[] = {10,20,30}
    Output:
    240.00
    Explanation:Total maximum value of item
    we can have is 240.00 from the given
    capacity of sack. 

    Example 2:

    Input:
    N = 2, W = 50
    values[] = {60,100}
    weight[] = {10,20}
    Output:
    160.00
    Explanation:
    Total maximum value of item
    we can have is 160.00 from the given
    capacity of sack.

    Expected Time Complexity : O(NlogN)
    Expected Auxilliary Space: O(1)
    
*/


class MyComparator implements Comparator<Item>
{
    public int compare(Item i1, Item i2)
    {
        double i1Ratio = i1.value/(double)i1.weight;
        double i2Ratio = i2.value/(double)i2.weight;
        return Double.compare(i2Ratio, i1Ratio);
    }
}

class Solution
{
    //Function to get the maximum total value in the knapsack.
    double fractionalKnapsack(int W, Item arr[], int n) 
    {
        PriorityQueue<Item> pq = new PriorityQueue<>(new MyComparator());
        double maxValue = 0;
        for(int i = 0; i < n; i++)
        {
            pq.add(arr[i]);
        }
        
        for(int j = 0; j < n; j++)
        {
            Item i = pq.poll();
            if(W >= i.weight)
            {
                W -= i.weight;
                maxValue += i.value;
            }
            else
            {
                maxValue += (i.value/(double)i.weight)*(double)W;
                break;
            }
        }
        return maxValue;
    }
}
