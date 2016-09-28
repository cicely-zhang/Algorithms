package advancedAlgorithms;

public class MeetingRoomInterval implements Comparable<MeetingRoomInterval> {
	
	int start;
	int end;
	
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
		return this.start * this.end;
	}
	
	
}
