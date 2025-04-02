package study.programmers.hash;

import java.util.HashMap;

/**
 * 서로 다른 옷의 조합의 수
 * 종류가 1개일 때 (개수 a로 가정) -> a -> (a+1)-1
 * 종류가 2개일 때 (개수 b로 가정) -> a+b+ab -> (a+1)(b+1)-1
 * 종류가 3개일 때 (개수 c로 가정) -> a+b+c+ab+ac+bc -> (a+1)(b+1)(c+1)-1
 *
 * 위와 같은 식으로 일반화 할 수 있다.
 * 1을 더하는 이유는 해당 종류를 선택하지 않았지만, 다른 종류 1개를 선택한 경우의 식을 만들어내기 위해
 * 1을 빼는 이유는 아무것도 착용하지 않는 경우 제거
 *
 * (a+1)(b+1)(c+1) 모든 경우의 조합의 개수
 * ❌❌❌ (아무것도 선택하지 않음)
 * ✅❌❌ (a에서 하나 선택, b와 c는 선택 안 함)
 * ❌✅❌ (b에서 하나 선택, a와 c는 선택 안 함)
 * ❌❌✅ (c에서 하나 선택, a와 b는 선택 안 함)
 * ✅✅❌ (a와 b에서 선택, c는 선택 안 함)
 * ✅❌✅ (a와 c에서 선택, b는 선택 안 함)
 * ❌✅✅ (b와 c에서 선택, a는 선택 안 함)
 * ✅✅✅ (a, b, c 모두 선택)
 */
public class Ex04_의상 {
    public int solution(String[][] clothes) {
        int answer = 1;

        HashMap<String, Integer> map = new HashMap<>();
        for (String[] arr :  clothes) {
            map.put(arr[1], map.getOrDefault(arr[1], 0) + 1);
        }

        for (int cnt : map.values()) {
            answer *= (cnt + 1);
        }

        return answer - 1;
    }

    public static void main(String[] args) {
        Ex04_의상 T = new Ex04_의상();
        System.out.println(T.solution(new String[][]{
                {"yellow_hat", "headgear"},
                {"blue_sunglasses", "eyewear"},
                {"green_turban", "headgear"}
        }));

    }
}