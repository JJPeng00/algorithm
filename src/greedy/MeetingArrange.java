package greedy;


import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

public class MeetingArrange {

    public static class Meeting {
        public int start;
        public int end;

        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static int meetingArrange(Meeting[] meetings) {
        if (meetings == null || meetings.length < 1) {
            return 0;
        }
        return meetingFullyArrange(meetings, 0, 0);
    }

    private static int meetingFullyArrange(Meeting[] meetings, int arrangedCount, int timeLine) {
        if (meetings.length == 0) {
            return arrangedCount;
        }
        int maxCount = arrangedCount;
        for (int i = 0; i < meetings.length; i++) {
            if (meetings[i].start >= timeLine) {//如果当前会议可选，那选择当前会议，并再对剩余的会议进行选择
                Meeting[] meetingLeft = copyExceptIndex(meetings, i);//复制出剩下的会议，再进行递归，也可以通过记录当前选择的会议再恢复现场的方式进行递归
                maxCount = Math.max(maxCount,meetingFullyArrange(meetingLeft, arrangedCount + 1, meetings[i].end));
            }
        }
        return maxCount;
    }

    private static Meeting[] copyExceptIndex(Meeting[] meetings, int index) {
        Meeting[] copy = new Meeting[meetings.length - 1];
        int copyIndex = 0;
        for (int i = 0; i < meetings.length; i++) {
            if (i != index) {
                copy[copyIndex++] = meetings[i];
            }
        }
        return copy;
    }

    public static int greedyArrange(Meeting[] meetings) {
        Arrays.sort(meetings, new MyMeetingComparator());
        int maxCount = 0;
        int timeLine = 0;
        for (Meeting meeting : meetings) {
            if (timeLine <= meeting.start) {
                maxCount++;
                timeLine = meeting.end;
            }
        }
        return maxCount;
    }


    private static class MyMeetingComparator implements Comparator<Meeting> {

        @Override
        public int compare(Meeting o1, Meeting o2) {
            return (o1.end - o2.end);
        }
    }

    // for test
    public static Meeting[] generatePrograms(int programSize, int timeMax) {
        Meeting[] ans = new Meeting[(int) (Math.random() * (programSize + 1))];
        for (int i = 0; i < ans.length; i++) {
            int r1 = (int) (Math.random() * (timeMax + 1));
            int r2 = (int) (Math.random() * (timeMax + 1));
            if (r1 == r2) {
                ans[i] = new Meeting(r1, r1 + 1);
            } else {
                ans[i] = new Meeting(Math.min(r1, r2), Math.max(r1, r2));
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int programSize = 12;
        int timeMax = 20;
        int timeTimes = 1000000;
        for (int i = 0; i < timeTimes; i++) {
            Meeting[] programs = generatePrograms(programSize, timeMax);
            if (meetingArrange(programs) != greedyArrange(programs)) {
                System.out.println("Oops!");
            }
        }
        System.out.println("finish!");
    }
}
