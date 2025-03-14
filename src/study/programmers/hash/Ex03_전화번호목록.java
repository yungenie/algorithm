package study.programmers.hash;

import java.util.Arrays;

/**
 * 틀려서 리서치 함.
 * Arrays.sort(문자열 배열) : 숫자가 아니라 숫자 문자열이라서 숫자 크기 비교로 정렬하는게 아니라, 문자열 사전 순으로 첫글자를 기준으로 비교하고, 같으면 다음 글자 비교로 정렬됨.
 * 예를 들어) 입력예제 1번을 ["119", "97674223", "1195524421"] 정렬하면 [119, 1195524421, 97674223] 접두어 관계가 있는 요소들은 인접하게 배치되어 출력된다.
 *
 * A.startsWith(B) : 특정문자 B가 A 문자열에서 시작하는지 여부 체크
 */
public class Ex03_전화번호목록 {

    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book); // 정렬
        System.out.println(Arrays.toString(phone_book));
        for (int i = 0; i < phone_book.length - 1; i++) {
            if (phone_book[i + 1].startsWith(phone_book[i])) {  // 접두어 체크
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Ex03_전화번호목록 t = new Ex03_전화번호목록();
        System.out.println(t.solution(new String[]{"119", "97674223", "1195524421"}));
        System.out.println(t.solution(new String[]{"123", "456", "789"}));
        System.out.println(t.solution(new String[]{"12","123","1235","567","88"}));
        System.out.println(t.solution(new String[]{"819232312", "976", "119552", "2"}));
    }
}
