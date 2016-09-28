package advancedAlgorithmsTest;

import static org.junit.Assert.*;
import advancedAlgorithms.*;
import org.junit.Test;

public class MeetingRoomTest {

	/*
	 * Given [[0, 30],[5, 10],[15, 20]],
		return false.
	 * 
	 */
	@Test
	public void testMeetingRoomFalseCase() {
		MeetingRoom room = new MeetingRoom();
		assert(room.canAttendAllMeetings(new MeetingRoomInterval[] {new MeetingRoomInterval(0, 30), 
				new MeetingRoomInterval(5, 10), new MeetingRoomInterval(15, 20)}) == false);
	}
	
	/*
	 * Given [[0,3], [5, 7], [7,8]]
	 * return true;
	 */
	@Test
	public void testMeetingRoomTrueCase() {
		MeetingRoom room = new MeetingRoom();
		assert(room.canAttendAllMeetings(new MeetingRoomInterval[] {new MeetingRoomInterval(0, 3), 
				new MeetingRoomInterval(5, 7), new MeetingRoomInterval(7, 8)}) == true);
	}
	
	/*
	 * No meeting
	 */
	@Test
	public void testMeetingRoomNoMeeting() {
		MeetingRoom room = new MeetingRoom();
		assert(room.canAttendAllMeetings(new MeetingRoomInterval[] {}));
	}
	
	/*
	 * Given [[0, 30],[5, 10],[15, 20]],
	 * Need 2 meeting rooms
	 */
	@Test
	public void testHowManyMeetingRooms() {
		MeetingRoom room = new MeetingRoom();
		assert(room.calculateMeetingRoomsNeeded(new MeetingRoomInterval[] {new MeetingRoomInterval(0, 30), 
				new MeetingRoomInterval(5, 10), new MeetingRoomInterval(15, 20)}) == 2);
	}
	
	/*
	 * Given [[0,3], [5, 7], [7,8]]
	 * return 1 meeting room
	 */
	@Test
	public void test1MeetingRooms() {
		MeetingRoom room = new MeetingRoom();
		assert(room.calculateMeetingRoomsNeeded(new MeetingRoomInterval[] {new MeetingRoomInterval(0, 3), 
				new MeetingRoomInterval(5, 7), new MeetingRoomInterval(7, 8)}) == 1);
	}

}
