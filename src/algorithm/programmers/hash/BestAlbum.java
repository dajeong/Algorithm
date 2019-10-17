package algorithm.programmers.hash;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 스트리밍 사이트에서 장르 별로 가장 많이 재생된 노래를 <strong>두 개씩</strong> 모아 베스트 앨범을 출시하려 합니다. 노래는 고유 번호로 구분하며, 노래를 수록하는 기준은 다음과 같습니다.
 * <p>
 * 속한 노래가 많이 재생된 장르를 먼저 수록합니다.
 * 장르 내에서 많이 재생된 노래를 먼저 수록합니다.
 * 장르 내에서 재생 횟수가 같은 노래 중에서는 고유 번호가 낮은 노래를 먼저 수록합니다.
 * 노래의 장르를 나타내는 문자열 배열 genres와 노래별 재생 횟수를 나타내는 정수 배열 plays가 주어질 때, 베스트 앨범에 들어갈 노래의 고유 번호를 순서대로 return 하도록 solution 함수를 완성하세요.
 * <p>
 * 제한사항
 * genres[i]는 고유번호가 i인 노래의 장르입니다.
 * plays[i]는 고유번호가 i인 노래가 재생된 횟수입니다.
 * genres와 plays의 길이는 같으며, 이는 1 이상 10,000 이하입니다.
 * 장르 종류는 100개 미만입니다.
 * 장르에 속한 곡이 하나라면, 하나의 곡만 선택합니다.
 * 모든 장르는 재생된 횟수가 다릅니다.
 * 입출력 예
 * genres	plays	return
 * [classic, pop, classic, classic, pop]	[500, 600, 150, 800, 2500]	[4, 1, 3, 0]
 * 입출력 예 설명
 * classic 장르는 1,450회 재생되었으며, classic 노래는 다음과 같습니다.
 * <p>
 * 고유 번호 3: 800회 재생
 * 고유 번호 0: 500회 재생
 * 고유 번호 2: 150회 재생
 * pop 장르는 3,100회 재생되었으며, pop 노래는 다음과 같습니다.
 * <p>
 * 고유 번호 4: 2,500회 재생
 * 고유 번호 1: 600회 재생
 * 따라서 pop 장르의 [4, 1]번 노래를 먼저, classic 장르의 [3, 0]번 노래를 그다음에 수록합니다.
 * <p>
 */
public class BestAlbum {

    /**
     * @param genres (ex. {"classic", "pop", "classic", "classic", "pop"})
     * @param plays  (ex. {500, 600, 150, 800, 2500})
     * @return (ex. {4, 1, 3, 0})
     */
    public int[] solution(String[] genres, int[] plays) {

        int[] idx = new int[genres.length];
        for (int i = 0; i < genres.length; i++) {
            idx[i] = i;
        }

        for (int i = 0; i < genres.length - 1; i++) {
            for (int j = i + 1; j < plays.length; j++) {
                if (plays[j] > plays[i]) {
                    int playsTemp = plays[j];
                    plays[j] = plays[i];
                    plays[i] = playsTemp;
                    String genresTemp = genres[j];
                    genres[j] = genres[i];
                    genres[i] = genresTemp;
                    int idxTemp = idx[j];
                    idx[j] = idx[i];
                    idx[i] = idxTemp;
                }
            }
        }

        Map<String, List<Integer>> map = new LinkedHashMap<>();
        int length = 0;
        for (int i = 0; i < genres.length; i++) {
            List<Integer> idxList = map.getOrDefault(genres[i], new ArrayList<>());
            if (idxList.size() == 2) continue;
            idxList.add(idx[i]);
            length++;
            map.put(genres[i], idxList);
        }

        int[] answer = new int[length];
        int i = 0;
        for (Map.Entry<String, List<Integer>> entry : map.entrySet()) {
            for (int resultIdx : entry.getValue()) {
                answer[i++] = resultIdx;
            }
        }
        return answer;
    }

    private void print(int[] something) {
        for (int aSomething : something) {
            System.out.print(aSomething + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        BestAlbum bestAlbum = new BestAlbum();
        int[] solution = bestAlbum.solution(new String[]{"classic", "pop", "classic", "classic", "pop"}, new int[]{500, 600, 150, 800, 2500});
        bestAlbum.print(solution);
    }
}
