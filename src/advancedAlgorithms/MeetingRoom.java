package advancedAlgorithms;

import java.util.*;

/* Questions: 
 * 
 * Given an array of meeting time intervals consisting of start and end times 
 * [[s1,e1],[s2,e2],...] (si < ei), determine if a person could attend all meetings.
 * i.e 
 * 
 * Given [[0, 30],[5, 10],[15, 20]],
	return false.
 * 
 */

public class MeetingRoom {
	
	public boolean canAttendAllMeetings(MeetingRoomInterval[] intervals) {
		Arrays.sort(intervals);
		int latestEndingTime = Integer.MIN_VALUE;
		for(MeetingRoomInterval interval : intervals) {
			if (interval.start < latestEndingTime)
				return false;
			
			if (interval.end > latestEndingTime)
				latestEndingTime = interval.end;
		}
		return true;
	}
	
	/*
	 * We have N meetings, each meeting has a start time and end time, 
	 * how many meeting rooms are required
	 */
	public int calculateMeetingRoomsNeeded(MeetingRoomInterval[] intervals) {
		Arrays.sort(intervals);
		ArrayList<Integer> meetingRoomsCol = new ArrayList<Integer>();
		int latestEndingTime = Integer.MIN_VALUE;
		for(MeetingRoomInterval interval : intervals) {
			if (meetingRoomsCol.size() == 0) {
				meetingRoomsCol.add(interval.end);
				latestEndingTime = interval.end;
				continue;
			}
				
			boolean found = false;
			for (int i = 0; i < meetingRoomsCol.size(); i ++) {
				Integer endTime = meetingRoomsCol.get(i);
				if (interval.start >= endTime) {
					meetingRoomsCol.set(i, interval.end);
					found = true;
					break;
				}
			}
			if (!found)
				meetingRoomsCol.add(interval.end);
		}
		return meetingRoomsCol.size();	
	}
}
