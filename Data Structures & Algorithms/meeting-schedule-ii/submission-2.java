/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        Collections.sort(intervals, (a,b) -> (a.start-b.start));
        PriorityQueue<Integer> q=new PriorityQueue<Integer>();
        for(int i=0;i<intervals.size();i++){
            if(!(q.isEmpty() || q.peek()>intervals.get(i).start)){
                q.remove();
            }
            q.add(intervals.get(i).end);
        }
        return q.size();
    }
}
