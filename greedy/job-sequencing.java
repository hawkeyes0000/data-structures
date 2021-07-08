/*

    Given a set of N jobs where each job i has a deadline and profit associated to it. Each job takes 1 unit of time to complete and only one job can be 
    scheduled at a time. We earn the profit if and only if the job is completed by its deadline. The task is to find the maximum profit and the number of jobs done.

    Note: Jobs will be given in the form (Job id, Deadline, Profit) associated to that Job.


    Example 1:

    Input:
    N = 4
    Jobs = (1,4,20)(2,1,10)(3,1,40)(4,1,30)
    Output:
    2 60
    Explanation:
    2 jobs can be done with
    maximum profit of 60 (20+40).

    Example 2:

    Input:
    N = 5
    Jobs = (1,2,100)(2,1,19)(3,2,27)
    (4,1,25)(5,1,15)
    Output:
    2 127
    Explanation:
    2 jobs can be done with
    maximum profit of 127 (100+27).

    Expected Time Complexity: O(NlogN)
    Expected Auxilliary Space: O(N)

*/

/*
    Sort jobs by their profit in descending order.
    For each job, put that job in the last possible position according to its deadline. Maintain a boolean[] freeSlot to keep track of free slots. If the freeSlot[deadline]
    is occupied, decrement upto > 0. If deadline is > 0, increment maxJob and maxProfit.
*/

/*
    class Job
    {
        int id, int deadline, int profit;
    }
*/

class Solution
{
    //Function to find the maximum profit and the number of jobs done.
    int[] JobScheduling(Job arr[], int n)
    {
        int maxProfit = 0;
        int maxJobs = 0;
        PriorityQueue<Job> pq = new PriorityQueue<>((a,b)->Integer.compare(b.profit, a.profit));
        boolean[] isOccupied = new boolean[101];
        for(int i = 0; i < n; i++)
        {
            pq.add(new Job(arr[i].id, arr[i].deadline, arr[i].profit));
        }
        
        while(!pq.isEmpty())
        {
            Job j = pq.poll();
            int jDeadLine = j.deadline;
            int jProfit = j.profit;
            while(jDeadLine > 0  && isOccupied[jDeadLine])
            {
                jDeadLine--;
            }
            if(jDeadLine > 0)
            {
                isOccupied[jDeadLine] = true;
                maxProfit += jProfit;
                maxJobs += 1;
            }   
        }
        return (new int[] {maxJobs, maxProfit});
    }
}
