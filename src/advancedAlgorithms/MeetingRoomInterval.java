package advancedAlgorithms;

public class MeetingRoomInterval implements Comparable<MeetingRoomInterval> {
	
	int start;
	int end;
	
	private enum IntervalType {
		type1,
		type2,
		type3
	}
	
	public MeetingRoomInterval () {
		start = 0; 
		end = 0;
	}
	
	public MeetingRoomInterval(int start, int end) {
		this.start = start;
		this.end = end;
	}
	
	@Override
	public int compareTo(MeetingRoomInterval interval) {
		return this.start - interval.start;
		
	}
	
	@Override
	public boolean equals(Object obj) {
		MeetingRoomInterval interval = (MeetingRoomInterval) obj;
		return (this.start == interval.start && this.end == interval.end);
	}
	
	@Override 
	public int hashCode() {
		for (int i = 0; i < IntervalType.values().length; i ++) {
			IntervalType atype=IntervalType.values()[i];
		}
		return this.start * this.end;
		
		
	}
	
	
}
