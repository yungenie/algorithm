package study.inflearn.lecture02.section06;

/**
 *  알파코드 - 깊이우선탐색 : DFS
 *  경우의 수 조합을 메모이제이션으로 등록
 */
public class Ex06_06_02_Answer {
    int[] dy;
    String s;
    int n;
    public int DFS(int start){
        /*
            앞 문제들은 데이터의 조합을 완전탐색으로 구했다면,
            이 문제는 경우의 수 조합으로 메모이제이션으로 시간복잡도를 줄인다.
            예를 들어,
            2로 시작할 때 '5114'의 모든 경우의 수 + 25로 시작할 때 '114'의 모든 경우의 수를 더한다.
         */
        if(dy[start] > 0) return dy[start];
        /*
            입력예제 1번 '25114' 재귀함수 탐색할 때
            2 5 1 1 4 1개씩 뻗어나갈 때
                - 레벨 3, 두번째 1에서는 start 3이되고
                - subStr 계산에 의해서 DFS(5)가 다시 탐색되기 때문에
                - start == n인 종착점 + 1 경우의 조건을 추가로 넣어줘야한다.
                - 또한, '0'은 알파벳 암호 번호에 없으므로 주어진 데이터의 인덱스 범위 내에서만 확인 가능하다.
                - start < n 의 조건이 들어간다.
                - 조건을 넣어주지 않으면 위와 같이 start가 5인 경우 s.charAt(start) 조건에서 IndexOutofRange 에러난다.
         */
        if(start < n && s.charAt(start) == '0') return 0;
        if(start == n-1 || start == n) return 1; // 재귀의 종착점 or 종착점 + 1 인 경우
        else{
            /*
                마지막 스택에 쌓인 DFS()의 결과값이 밑에 쌓인 DFS()의 res에 반환됨.
                재귀함수가 1개 있었을 경우에는 하위레벨에서 요소 1개씩 쭉이어서 쌓였다가 백트랙킹하지만
                재귀함수가 2개 있는 경우는 하위레벨에서 요소 1개에서 다시 재귀함수를 탐색한다.
             */
            int res = DFS(start + 1);
            /*
                처음 재귀함수는 요소 1개씩만 보기 때문에
                백트랙킹으로 요소를 2개 이상씩 탐색할 때 알파벳 암호 범위를 체크한다.
             */
            int tmp = Integer.parseInt(s.substring(start, start + 2));
            if(tmp <= 26) res += DFS(start + 2);
            return dy[start] = res;
        }
    }

    public int solution(String s){
        this.s = s;
        n = s.length();
        dy = new int[51]; // 인덱스 : 부모레벨, 값 : 자식레벨 경우의 수 조합
        int answer = DFS(0);
        return answer;
    }

    public static void main(String[] args){
        Ex06_06_02_Answer T = new Ex06_06_02_Answer();
        System.out.println(T.solution("25114"));
        System.out.println(T.solution("23251232"));
        System.out.println(T.solution("21020132"));
        System.out.println(T.solution("21350"));
        System.out.println(T.solution("120225"));
        System.out.println(T.solution("232012521"));
    }
}
