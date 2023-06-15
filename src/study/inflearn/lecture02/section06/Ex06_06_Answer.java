package study.inflearn.lecture02.section06;

/**
 * 알파코드 - 깊이우선탐색 : DFS
 * 메모이제이션
 */
public class Ex06_06_Answer {
    int[] dy;
    public int DFS(int start, String s){ // start는 인덱스 번호 0~N-1
        if(dy[start] > 0) return dy[start]; // 이미 구해진 경우의 수 반환
        if(start < s.length() && s.charAt(start) == '0') return 0; // start가 0~N-1까지 해당하는 문자열이 0인 경우는 재귀함수 커트
        if(start == s.length() -1 || start == s.length()) return 1; // 재귀의 종착점 or 종착점 + 1 인 경우
        else{
            //int res = DFS(start + 1, s);
            //int tmp = Integer.parseInt(s.substring(start, start + 2)); // 2개의 문자열 확인
            //if(tmp <= 26) res += DFS(start + 2, s); // 조합의 경우의 수 구하는 방법
            //return dy[start] = res;

            int tmp = Integer.parseInt(s.substring(start, start + 2));
            if(tmp <= 26) return dy[start] = DFS(start + 1, s) + DFS(start + 2, s);
            else return dy[start] = DFS(start + 1, s);
        }
    }
    public int solution(String s){
        dy = new int[51]; // 문자열 길이 제한이 50을 넘지 않음
        int answer = DFS(0, s);
        return answer;
    }

    public static void main(String[] args){
        Ex06_06_Answer T = new Ex06_06_Answer();
        System.out.println(T.solution("25114"));
        System.out.println(T.solution("23251232"));
        System.out.println(T.solution("21020132"));
        System.out.println(T.solution("21350"));
        System.out.println(T.solution("120225"));
        System.out.println(T.solution("232012521"));
    }
}
