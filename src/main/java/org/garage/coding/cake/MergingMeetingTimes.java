package org.garage.coding.cake;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MergingMeetingTimes {

	public static void main(String[] args) {
		MergingMeetingTimes mergingMeetingTimes = new MergingMeetingTimes();
		List<Meeting> meetings = new ArrayList<Meeting>();
		meetings.add(new Meeting(0, 1));
		meetings.add(new Meeting(3, 5));
		meetings.add(new Meeting(4, 8));
		meetings.add(new Meeting(10, 12));
		meetings.add(new Meeting(9, 10));

		mergingMeetingTimes.mergeRanges2(meetings);

	}

// (0,1) (1, 2) -> (0,2)
	// (0, 1) -> ( 0, 1)
	public List<Meeting> mergeRanges2(List<Meeting> meetings) {
		List<Meeting> mergeList = new ArrayList<Meeting>();
		for (int i = 0; i < meetings.size(); i++) {

			int stTime = meetings.get(i).getStartTime();
			stTime = stTime + 1;
			for (int j = stTime; j < meetings.size(); j++) {
				System.out.println(j);
				if ((meetings.get(j).getStartTime() == stTime) && j == meetings.size() - 1) {
					mergeList.add(new Meeting(meetings.get(i).getStartTime(), meetings.get(j).getEndTime()));
				} else {
					// mergeList.add(new Meeting(meetings.get(i).getStartTime(),
					// meetings.get(i).getEndTime()));
				}

			}

			if (stTime == meetings.size()) {
				mergeList.add(new Meeting(meetings.get(i).getStartTime(), meetings.get(i).getEndTime()));
			}

		}
		return mergeList;
	}

//(1,3)(2,4) -> (1,4)
	public List<Meeting> mergeRanges(List<Meeting> meetings) {

		// sort the meetings

		List<Meeting> sortedMeetings = meetings;

		List<Meeting> mergeMeetings = new ArrayList<Meeting>();

		if (sortedMeetings.size() == 1) {
			mergeMeetings = sortedMeetings;
			return sortedMeetings;
		}

		//
		int startTime = -1;
		int endTime = -1;
		int prevStartTime = -1;

//(1,2)(2,3)(3,4)(5,7)(8,10)(9,12)  -> (1,4) (5,7)(8,12)
		for (int i = 0; i < sortedMeetings.size(); i++) {
			Meeting currentMeeting = sortedMeetings.get(i);
			if ((i + 1) < sortedMeetings.size()) {
				Meeting nextMeeting = sortedMeetings.get(i + 1);
				if (nextMeeting.getStartTime() <= currentMeeting.getEndTime()) {
					if ((startTime < 1)) {
						startTime = currentMeeting.getStartTime();
						prevStartTime = currentMeeting.getStartTime();
					}
					endTime = nextMeeting.getEndTime();
				} else {
					System.out.println("1111");
					if (prevStartTime != -1 && currentMeeting.getStartTime() <= prevStartTime) {
						mergeMeetings.add(new Meeting(prevStartTime, currentMeeting.getEndTime()));
					} else {
						mergeMeetings.add(new Meeting(currentMeeting.getStartTime(), currentMeeting.getEndTime()));
					}
					startTime = nextMeeting.getStartTime();
				}

			}
			if (i == sortedMeetings.size() - 1) {
				System.out.println("2222");
				mergeMeetings.add(new Meeting(startTime, currentMeeting.getEndTime()));
				startTime = -1;
				endTime = -1;

			}
		}
		return mergeMeetings;

	}
/**
 * 
 * Runtime -> O(nLogn)
 * Space -> O(n)
 */
	public List<Meeting> mergeRangesFinal(List<Meeting> meetings) {
		
		// Copy to preserve input 
		List<Meeting> mts = new ArrayList<Meeting>(meetings);
		// Collections.copy(mts, meetings);
		
		
		
		
       // Sorting using Lamda !!
		Collections.sort(mts, (Meeting m1, Meeting m2) -> (m1.getStartTime() < m2.getStartTime()) ? -1
				: (m1.getStartTime() > m2.getStartTime()) ? 1 : 0);
		
		// Merge list to be returned
		List<Meeting> mlist = new ArrayList<Meeting>();

		// add 1st element to merge list
		mlist.add(mts.get(0));

		
		for (Meeting m : mts) {
			Meeting lastMeeting = mlist.get(mlist.size() - 1);
			if (lastMeeting.getEndTime() >= m.getStartTime()) {
				// merge meeting, keep updating the endtime mostly
				lastMeeting.setStartTime(Math.min(lastMeeting.getStartTime(), m.getStartTime()));
				lastMeeting.setEndTime(Math.max(lastMeeting.getEndTime(), m.getEndTime()));
			} else {
				// fresh meeting, not merge here
				mlist.add(m);
			}
		}

		return mlist;
	}
}

class Meeting {

	private int startTime;
	private int endTime;

	public Meeting(int startTime, int endTime) {
		// number of 30 min blocks past 9:00 am
		this.startTime = startTime;
		this.endTime = endTime;
	}

	public int getStartTime() {
		return startTime;
	}

	public void setStartTime(int startTime) {
		this.startTime = startTime;
	}

	public int getEndTime() {
		return endTime;
	}

	public void setEndTime(int endTime) {
		this.endTime = endTime;
	}

	@Override
	public String toString() {
		return "Meeting [startTime=" + startTime + ", endTime=" + endTime + "]";
	}

}