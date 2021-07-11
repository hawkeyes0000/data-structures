/*
    
    Given arrival and departure times of all trains that reach a railway station. Find the minimum number of platforms required for the railway 
    station so that no train is kept waiting.
    Consider that all the trains arrive on the same day and leave on the same day. Arrival and departure time can never be the same for a train 
    but we can have arrival time of one train equal to departure time of the other. At any given instance of time, same platform can not be used 
    for both departure of a train and arrival of another train. In such cases, we need different platforms.


    Example 1:

    Input: n = 6 
    arr[] = {0900, 0940, 0950, 1100, 1500, 1800}
    dep[] = {0910, 1200, 1120, 1130, 1900, 2000}
    Output: 3
    Explanation: 
    Minimum 3 platforms are required to 
    safely arrive and depart all trains.

    Example 2:

    Input: n = 3
    arr[] = {0900, 1100, 1235}
    dep[] = {1000, 1200, 1240}
    Output: 1
    Explanation: Only 1 platform is required to 
    safely manage the arrival and departure 
    of all trains. 

    Note: Time intervals are in the 24-hour format(HHMM) , where the first two characters represent hour (between 00 to 23 ) and the last 
    two characters represent minutes (between 00 to 59).

    Expected Time Complexity: O(nLogn)
    Expected Auxiliary Space: O(n)
    
*/

class TimeTemplate
{
    int time;
    boolean isArrival;
    
    TimeTemplate(int t, boolean f)
    {
        this.time = t;
        this.isArrival = f;
    }
}

class MyComparator implements Comparator<TimeTemplate>
{
    public int compare(TimeTemplate t1, TimeTemplate t2)
    {   // departure of one can be same as arrival of another
        if(t1.time == t2.time)
        {
            return Boolean.compare(t2.isArrival, t1.isArrival);
        }
        return Integer.compare(t1.time, t2.time);
    }
}

class Solution
{
    //Function to find the minimum number of platforms required at the
    //railway station such that no train waits.
    static int findPlatform(int arr[], int dep[], int n)
    {
        int maxPlatform = 1;
        PriorityQueue<TimeTemplate> pq = new PriorityQueue<>(new MyComparator());
        for(int i = 0; i < n; i++)
        {
            pq.add(new TimeTemplate(arr[i], true));
            pq.add(new TimeTemplate(dep[i], false));
        }
        int currentPlatformCount = 0;
        while(!pq.isEmpty())
        {
            TimeTemplate t = pq.poll();
            if(t.isArrival)
            {
                currentPlatformCount++;
            }
            else
            {
                currentPlatformCount--;
            }
            if(currentPlatformCount > maxPlatform)
            {
                maxPlatform = currentPlatformCount;
            }
        }
        return maxPlatform;
    }
}

