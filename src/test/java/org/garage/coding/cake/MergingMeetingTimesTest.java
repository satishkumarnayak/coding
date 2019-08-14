
package org.garage.coding.cake;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class MergingMeetingTimesTest {

	MergingMeetingTimes mergeMeeting;

	@Before
	public void setUp() throws Exception {
		mergeMeeting = new MergingMeetingTimes();
	}

//	@Test
	public void testAllMeetingInMap() {
		Meeting[] meetArray = { new Meeting(0, 1), new Meeting(3, 5), new Meeting(4, 8), new Meeting(10, 12),
				new Meeting(9, 10) };

		List<Meeting> meetings = new ArrayList<Meeting>();
		List<Meeting> asList = Arrays.asList(meetArray);

		mergeMeeting.mergeRanges(meetings);
	}

//	@Test
	public void testMergeMeeting() {

		List<Meeting> meetings = new ArrayList<Meeting>();
		meetings.add(new Meeting(0, 1));
		meetings.add(new Meeting(2, 3));

		List<Meeting> mergeRanges = mergeMeeting.mergeRanges(meetings);
		System.out.println(mergeRanges.toString());

	}

	// @Test
	public void testMergeMeeting2() {

		List<Meeting> meetings = new ArrayList<Meeting>();
		meetings.add(new Meeting(0, 1));
		meetings.add(new Meeting(1, 2));

		List<Meeting> mergeRanges = mergeMeeting.mergeRanges(meetings);
		System.out.println(mergeRanges.toString());

	}

//	@Test
	public void testMergeMeeting1Meeting() {

		List<Meeting> meetings = new ArrayList<Meeting>();
		meetings.add(new Meeting(1, 3));
		// meetings.add(new Meeting(2, 4));

		List<Meeting> mergeRanges = mergeMeeting.mergeRangesFinal(meetings);
		// System.out.println(mergeRanges.toString());
		assertEquals("[Meeting [startTime=1, endTime=3]]", mergeRanges.toString());

	}

	@Test
	public void testMergeMeeting2Meeting1Overlap() {

		List<Meeting> meetings = new ArrayList<Meeting>();
		meetings.add(new Meeting(1, 3));
		meetings.add(new Meeting(2, 4));

		List<Meeting> mergeRanges = mergeMeeting.mergeRangesFinal(meetings);
		// System.out.println(mergeRanges.toString());
		assertEquals("[Meeting [startTime=1, endTime=4]]", mergeRanges.toString());

	}

	@Test
	public void testMergeMeeting2MeetingNoOverlap() {

		List<Meeting> meetings = new ArrayList<Meeting>();
		meetings.add(new Meeting(1, 3));
		meetings.add(new Meeting(5, 6));

		List<Meeting> mergeRanges = mergeMeeting.mergeRangesFinal(meetings);
		// System.out.println(mergeRanges.toString());
		assertEquals("[Meeting [startTime=1, endTime=3], Meeting [startTime=5, endTime=6]]", mergeRanges.toString());

	}

	@Test
	public void testMergeMeeting2MeetingContinuous() {

		List<Meeting> meetings = new ArrayList<Meeting>();
		meetings.add(new Meeting(1, 2));
		meetings.add(new Meeting(2, 3));

		List<Meeting> mergeRanges = mergeMeeting.mergeRangesFinal(meetings);
		// System.out.println(mergeRanges.toString());
		assertEquals("[Meeting [startTime=1, endTime=3]]", mergeRanges.toString());

	}

	@Test
	public void testMergeMeeting4Meeting2Overlap() {

		List<Meeting> meetings = new ArrayList<Meeting>();
		meetings.add(new Meeting(1, 3));
		meetings.add(new Meeting(2, 4));
		meetings.add(new Meeting(8, 10));
		meetings.add(new Meeting(9, 12));

		List<Meeting> mergeRanges = mergeMeeting.mergeRangesFinal(meetings);
		// System.out.println(mergeRanges.toString());
		assertEquals("[Meeting [startTime=1, endTime=4], Meeting [startTime=8, endTime=12]]", mergeRanges.toString());

	}

	@Test
	public void testMergeMeeting4Meeting3Overlap() {

		List<Meeting> meetings = new ArrayList<Meeting>();
		meetings.add(new Meeting(1, 2));
		meetings.add(new Meeting(2, 3));
		meetings.add(new Meeting(3, 4));
		meetings.add(new Meeting(5, 7));
		meetings.add(new Meeting(8, 10));
		meetings.add(new Meeting(9, 12));

		List<Meeting> mergeRanges = mergeMeeting.mergeRangesFinal(meetings);
		System.out.println(mergeRanges.toString());
		 assertEquals("[Meeting [startTime=1, endTime=4], Meeting [startTime=5, endTime=7], Meeting [startTime=8, endTime=12]]", mergeRanges.toString());

	}
	
	@Test
	public void testMergeMeeting4Meeting3OverlapUnSorted() {

		List<Meeting> meetings = new ArrayList<Meeting>();
		meetings.add(new Meeting(1, 2));
		meetings.add(new Meeting(5, 7));
		meetings.add(new Meeting(2, 3));
		meetings.add(new Meeting(9, 12));
		meetings.add(new Meeting(3, 4));
		meetings.add(new Meeting(8, 10));
		

		List<Meeting> mergeRanges = mergeMeeting.mergeRangesFinal(meetings);
	//	System.out.println(mergeRanges.toString());
		 assertEquals("[Meeting [startTime=1, endTime=4], Meeting [startTime=5, endTime=7], Meeting [startTime=8, endTime=12]]", mergeRanges.toString());

	}

}
