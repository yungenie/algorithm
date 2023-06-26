package study.inflearn.lecture02.section08;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 최소 환승 경로 - 그래프 최단거리 : Graph
 * 틀림
 */
public class Ex08_02 {
    public int solution(int[][] routes, int s, int e){
        int answer = 0;

        HashMap<Integer, Integer> map = new LinkedHashMap<>();
        int n = routes.length;
        for (int i = 0; i < n; i++) {
            for (int x : routes[i]) {
                map.put(x, map.getOrDefault(x, 0) + 1);
            }
        }

        ArrayList<Integer> arr = new ArrayList<>();
        for (Integer key : map.keySet()) {
            if (map.get(key) > 1) {
                arr.add(key);
            }
        }

        HashMap<Integer, ArrayList<int[]>> line = new LinkedHashMap<>();
        for (int i = 0; i < arr.size(); i++) {
            for (int[] route : routes) {
                int finalI = i;
                if (Arrays.stream(route).anyMatch(x -> x == arr.get(finalI))) {
                    line.putIfAbsent(arr.get(i), new ArrayList<int[]>());
                    line.get(arr.get(i)).add(route);
                }
            }     
        }

        // sort by key
        List<Map.Entry<Integer, ArrayList<int[]>>> entries =
                line.entrySet().stream()
                        .sorted(Map.Entry.comparingByKey())
                        .collect(Collectors.toList());

        int L = 0;
        for (Map.Entry<Integer, ArrayList<int[]>> entry : entries) {
            System.out.println("L = " + L);
            for (int[] ints : entry.getValue()) {
                System.out.println("Arrays.toString(ints) = " + Arrays.toString(ints));
                for (int i : ints) {
                    if (i == e) {
                        return L;
                    }
                }
            }
            L++;
        }

       /* int L = 0;
        for (ArrayList<int[]> ints : line.values()) {
            //System.out.println("L = " + L);
            for (int[] anInt : ints) {
                //System.out.println("anInt = " + Arrays.toString(anInt));
                for (int i : anInt) {
                    if (i == e) {
                        answer = L;
                    }
                }
            }
            L++;
        }*/

        return -1;
    }

    public static void main(String[] args){
        Ex08_02 T = new Ex08_02();
        //System.out.println(T.solution(new int[][]{{1, 2, 3, 4, 5, 6, 19}, {2, 7, 8, 13}, {5, 9, 10}, {9, 11, 12, 18}, {13, 14, 15}, {14, 12, 16, 17}}, 1, 12));
        System.out.println(T.solution(new int[][]{{1, 3, 5, 7}, {9, 3, 12}, {6, 5, 8}, {2, 8, 14, 15}, {2, 14, 16}}, 1, 14));
        //System.out.println(T.solution(new int[][]{{7, 12},{5, 19},{7, 19},{9, 12, 13},{9, 5, 15}}, 9, 19));
       // System.out.println(T.solution(new int[][]{{1, 2, 3, 4, 5},{9, 7, 10},{7, 6, 3, 8}, {5, 11, 8, 12}}, 1, 10));
    }
}
