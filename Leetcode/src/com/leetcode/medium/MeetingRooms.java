package com.leetcode.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class MeetingRooms {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[][] intervals = {
				{0,30},
				{5,10},
				{15,20}
		};
		System.out.println("Number" + minMeetingRooms(intervals));
	}

	public  static int minMeetingRooms(int[][] intervals) {
        List<int[]> l = new ArrayList<>();
	for (int[] i : 
			intervals) {
		l.add(i);
	}
	Collections.sort(l, new Comparator<int[]>(){
		@Override
		public int compare(int[] o1, int[] o2) {
			return o1[0] - o2[0];
		}
	});
	int ans = 0;
	Queue<Integer> q = new PriorityQueue<>();
	for (int[] i : 
			l) {
		if (!q.isEmpty() && q.peek() <= i[0]) {
			q.poll();
		}
		q.add(i[1]);
		ans = Math.max(q.size(), ans);
	}

	return ans;
    }
}
