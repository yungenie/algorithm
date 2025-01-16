package study.inflearn.lecture01.section2;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

public class Ex02_01_문자찾기 {

    /**
     *  또 다른 방법은 없을까?
     *
     *  입력받은 문자열이랑 특정문자 둘다 무조건 소문자로 변경?
     *  어떻게 소문자로 변경하지?
     */
    public long solution2(String text, String findText) {
        text = text.toLowerCase();
        findText = findText.toLowerCase();
        // 방법1 - 반복문을 통해 문자요소 하나하나 equals() 비교 후 counting

        // 방법2 - 스트림을 통해서 조건에 요소가 findText와 같으면 count
        // 100개를 넘지 않기 때문에 stream으로 해도 된다.
        // todo stream 100만개 이상부터 성능 떨어진다고 했었나? 까먹음. 찾아보기.
        String finalFindText = findText;
        long count = Stream.of(text).filter(s -> s.equals(finalFindText)).count();

        return count;
    }

    public int solution(String text, String findText) {
        int count = 0;

        // 특정문자 char배열 및 소문자 변환
        char[] findTextArr = findText.toCharArray();
        char findChar = Character.toLowerCase(findTextArr[0]);

        // 문자열 char배열 및 소문자 변환
        char[] textArr = text.toCharArray();
        for (int i = 0; i < textArr.length; i++) {
            if (Character.isUpperCase(textArr[i])) {
                textArr[i] = Character.toLowerCase(textArr[i]);
            }
            if (textArr[i] == findChar) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Ex02_01_문자찾기 T = new Ex02_01_문자찾기();
        Scanner sc = new Scanner(System.in);
        String text = sc.next();
        String findText = sc.next();
        System.out.println(T.solution(text, findText));
        System.out.println(T.solution2(text, findText));
    }
}
