package algorithm.programmers;

import java.util.ArrayList;
import java.util.List;

public class P17676 {
    static class Log {
        long start;
        long end;

        public Log(long start, long end) {
            this.start = start;
            this.end = end;
        }
    }

    public int solution(String[] lines) {

        // 1 hour = 60 * 60000 = 3600000 ms
        // 1 min = 60 s = 60 * 1000 = 60000 ms
        // 1s 1000 ms
        // 1 ms
        long begin = 23 * 3600000 + 59 * 60000 + 59 + 1000 + 999;
        long last;
        List<Log> logList = new ArrayList<>();
        for (String line : lines) {
            String[] logSplit = line.split(" ");
            long endTime = timeStampToMillis(logSplit[1]);
            long startTime = endTime - secondToMillis(logSplit[2]);
            begin = Math.min(begin, startTime);
            logList.add(new Log(startTime, endTime));
        }
        last = logList.get(logList.size() - 1).end;

        int answer = 0;
        int tps = 0;
        for (long startPoint = begin; startPoint + 1000 <= last; startPoint++) {
            long endPoint = startPoint + 1000;
            for (Log log : logList) {
                if (startPoint == log.start) {
                    tps++;
                }
                if (startPoint == log.end) {
                    tps --;
                }
            }
            answer = Math.max(answer, tps);
        }
        System.out.println(answer);

        return answer;
    }

    public long timeStampToMillis(String timestamp) {
        String[] times = timestamp.split(":");
        int hour = Integer.parseInt(times[0]);
        int min = Integer.parseInt(times[1]);
        String[] secArr = times[2].split("\\.");
        int sec = Integer.parseInt(secArr[0]);
        int millis = 0;
        if (secArr.length == 2) {
            millis = Integer.parseInt(secArr[1]);
        }
        return (hour * 3600000) + (min * 60000) + (sec * 1000) + millis;
    }

    public int secondToMillis(String second) {
        String[] secArr = second.replace("s", "").split("\\.");
        int millis = Integer.parseInt(secArr[0]);
        if (secArr.length == 2) {
            millis += Integer.parseInt(secArr[1]);
        }
        return millis;
    }

    public static void main(String[] args) {
        new P17676().solution(new String[]{"2016-09-15 20:59:57.421 0.351s",
                "2016-09-15 20:59:58.233 1.181s",
                "2016-09-15 20:59:58.299 0.8s",
                "2016-09-15 20:59:58.688 1.041s",
                "2016-09-15 20:59:59.591 1.412s",
                "2016-09-15 21:00:00.464 1.466s",
                "2016-09-15 21:00:00.741 1.581s",
                "2016-09-15 21:00:00.748 2.31s",
                "2016-09-15 21:00:00.966 0.381s",
                "2016-09-15 21:00:02.066 2.62s"});
    }
}
