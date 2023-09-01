package study.inflearn.lecture02.section01;


/**
 * 비밀번호 - 시뮬레이션 & 구현
 *
 */
public class Ex01_07 {
    public int solution(int[] keypad, String password){
        int answer = 0;
        char[] pwdChar = password.toCharArray();

        // 키패드 숫자들 배열에 초기화
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
        for (char c : pwdChar) { // 패스워드 숫자와 동일한 키패드 행열 찾기
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (keypadArr[i][j] == Character.getNumericValue(c)) {
                        if (first != 0) {
                            int a = Math.abs(tempi - i);
                            int b = Math.abs(tempj - j);
                            int max = Math.max(a, b);
                            answer += max;
                        } // 키패드 첫 패스워드 0초 이기 때문에 그 다음 패스워드부터 걸리는 시간 카운팅
                        tempi = i;
                        tempj = j;
                        first++;
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