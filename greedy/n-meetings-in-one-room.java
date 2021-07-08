/*
    
    There is one meeting room in a firm. There are N meetings in the form of (S[i], F[i]) where S[i] is start time of meeting i and F[i] is finish time of meeting i.
    What is the maximum number of meetings that can be accommodated in the meeting room when only one meeting can be held in the meeting room at a particular time? 
    Also note start time of one chosen meeting can't be equal to the end time of the other chosen meeting.

    Example 1:

    Input:
    N = 6
    S[] = {1,3,0,5,8,5}
    F[] = {2,4,6,7,9,9}
    Output: 
    4
    Explanation:
    Four meetings can be held with
    given start and end timings.

    Example 2:

    Input:
    N = 8
    S[] = {75250, 50074, 43659, 8931, 11273,
    27545, 50879, 77924}
    F[] = {112960, 114515, 81825, 93424, 54316,
    35533, 73383, 160252}
    Output: 
    3
    Explanation:
    Only three meetings can be held
    with given start and end timings.

    Expected Time Complexity : O(N*LogN)
    Expected Auxilliary Space : O(N)
  
*/

/*
    Sort the activities by finish time.
    Then, compare the start time of current activity to the finish time of previous activity. If it is greater, increment meeting
*/

// Meeting object template
class Meeting
{
    int start;
    int end;
    Meeting(int s, int e)
    {
        this.start = s;
        this.end = e;
    }
}

class Solution 
{
    //Function to find the maximum number of meetings that can
    //be performed in a meeting room.
    public static int maxMeetings(int start[], int end[], int n)
    {
        int meetings = 0;
        // MinHeap
        PriorityQueue<Meeting> pq = new PriorityQueue<>((a,b)->Integer.compare(a.end, b.end));
        for(int i = 0; i < n; i++)
        {
            pq.add(new Meeting(start[i], end[i]));
        }
        int lastMeetingEndTime = Integer.MIN_VALUE;
        while(!pq.isEmpty())
        {
            Meeting m = pq.poll();
            if(m.start > lastMeetingEndTime)
            {
                lastMeetingEndTime = m.end;
                meetings += 1;
            }
        }
        return meetings;
    }
}
