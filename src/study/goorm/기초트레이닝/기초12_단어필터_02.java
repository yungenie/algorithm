package study.goorm.기초트레이닝;

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class 기초12_단어필터_02 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫 번째 줄: 단어 S와 메시지 E의 길이
        String[] lengths = br.readLine().split(" ");
        int lenS = Integer.parseInt(lengths[0]);
        int lenE = Integer.parseInt(lengths[1]);

        String S = br.readLine(); // 두 번째 줄: 단어 S (소문자로 통일)
        String E = br.readLine(); // 세 번째 줄: 메시지 E

        // 필터링 적용
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < E.length(); i++) {
            // 한 글자씩 추가
            sb.append(E.charAt(i));

            // 현재 sb에서 뽑아낸 S와 실제S 같으면(대소문자 구별 안함) S 삭제
            if (sb.length() >= S.length() &&
                    sb.substring(sb.length() - S.length()).equalsIgnoreCase(S)) {
                sb.delete(sb.length() - S.length(), sb.length());
            }
        }

        // 최종 결과 출력 (비어 있으면 "EMPTY")
        System.out.println(sb.length() == 0 ? "EMPTY" : sb.toString());

    }
}
/**
 * 입력 케이스
 *
 * GOORM
 * GOORMasDgoorm
 *
 * goorm
 * GOORMasDgoorm
 *
 * goorm
 * GOORMasDGOORM
 *
 * a
 * bc
 *
 * aa
 * aaa
 *
 * abc
 * ababcabcabc
 *
 * 예외 케이스
 * ab
 * AbABab
 * EMPTY
 *
 * ab
 * aabb
 * EMPTY
 *
 * ab
 * AbAbaBDD
 *
 */