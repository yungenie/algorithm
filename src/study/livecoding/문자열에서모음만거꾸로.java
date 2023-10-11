package study.livecoding;

import java.util.HashSet;

public class 문자열에서모음만거꾸로 {
    public static void main(String[] args) {
        String str = "bacedufivo";
        StringBuilder sb = new StringBuilder(str);

        HashSet<Character> vowel = new HashSet<>();
        vowel.add('a');
        vowel.add('e');
        vowel.add('i');
        vowel.add('o');
        vowel.add('u');

        int left = 0, right = str.length()-1;

        while (left < right) {

            char curLeft = str.charAt(left);
            char curRight = str.charAt(right);

            // 모음이 담긴 HashSet 탐색하면서 포함되지 않으면 왼쪽, 오른쪽 거리 좁히기
            while (!vowel.contains(curLeft)) {
                left++;
            }
            while (!vowel.contains(curRight)) {
                right--;
            }

            // 모음이라면 변경하기
            sb.setCharAt(left, curRight);
            sb.setCharAt(right, curLeft);

            // 왼쪽, 오른쪽 거리 좁히기
            left++;
            right--;
        }

        System.out.println(sb);
    }
}
