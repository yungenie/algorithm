package study.inflearn.lecture02.section01;


/**
 * 비밀번호 - 시뮬레이션 & 구현
 *
 */
public class Ex01_07 {
    public int solution(int[] keypad, String password){
        int answer = 0;
        char[] pwdChar = password.toCharArray();

        // 행열 키패드
        int[][] keypadArr = new int[3][3];
        int index = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                keypadArr[i][j] = keypad[index];
                index++;
            }
        }

        // 비밀번호가 입력되는 총 시간
        int first = 0, tempi = 0, tempj = 0;
        for (char c : pwdChar) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    // password 숫자와 동일한 행열 찾기
                    if (keypadArr[i][j] == Character.getNumericValue(c)) {
                        first++;
                        // 이동 시간 = 현재 위치와 그 다음 위치의 차이 구하기(절대값) 및 최대값
                        if (first != 1 ) { // 처음 값은 temp에 저장만 해놓기.
                            int a = Math.abs(tempi - i);
                            int b = Math.abs(tempj - j);
                            int max = Math.max(a, b);
                            answer += max;
                        }
                        tempi = i;
                        tempj = j;
                        break;
                    }
                }
            }
        }

        return answer;
    }

    public static void main(String[] args){
        Ex01_07 T = new Ex01_07();
        System.out.println(T.solution(new int[]{2, 5, 3, 7, 1, 6, 4, 9, 8}, "7596218"));
        System.out.println(T.solution(new int[]{1, 5, 7, 3, 2, 8, 9, 4, 6}, "63855526592"));
        System.out.println(T.solution(new int[]{2, 9, 3, 7, 8, 6, 4, 5, 1}, "323254677"));
        System.out.println(T.solution(new int[]{1, 6, 7, 3, 8, 9, 4, 5, 2}, "3337772122"));
    }
}



/*

- char to int : Character.getNumericValue(); // char 7 -> int 바꾸면 아스키코드값으로 변경되는데 char 7이라는 문자값 그대로 숫자로 변형해줌
- 절대값 : Math.abs();
 */