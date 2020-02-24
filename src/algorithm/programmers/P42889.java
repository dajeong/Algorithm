package algorithm.programmers;

import java.util.ArrayList;
import java.util.List;

public class P42889 {

    public int[] solution(int N, int[] stages) {

        final List<Stage> stageList = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            int unclear = 0;
            int reach = 0;
            for (int stage : stages) {
                if (stage == i) {
                    unclear++;
                    reach++;
                }
                if (stage > i) {
                    reach++;
                }
            }
            stageList.add(new Stage(i, reach == 0 ? 0 : (double) unclear / reach));
        }

        stageList.sort((o1, o2) ->
                Double.compare(o2.getFailRates(), o1.getFailRates()));

        return stageList.stream().mapToInt(Stage::getStageNo).toArray();
    }

    class Stage {
        private int stageNo;
        private double failRates;

        Stage(int stageNo, double failRates) {
            this.stageNo = stageNo;
            this.failRates = failRates;
        }

        int getStageNo() {
            return stageNo;
        }

        double getFailRates() {
            return failRates;
        }
    }
}
