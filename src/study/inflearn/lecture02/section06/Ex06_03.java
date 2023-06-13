package study.inflearn.lecture02.section06;

import java.util.Arrays;

/**
 * 바둑대회 - 깊이우선탐색 : DFS
 * 조합문제
 */
public class Ex06_03 { // todo 영근이한테 메모리 할당 및 적재 배우기
    int answer, m, n;
    int[] ch, aArr, bArr;
    int[][] cans;

    public void DFS(int L, int s){
        System.out.println("answer = " + System.identityHashCode(answer));
        System.out.println("m = " + System.identityHashCode(m));
        System.out.println("n = " + System.identityHashCode(n));
        System.out.println("ch = " + System.identityHashCode(ch));
        System.out.println("aArr = " + System.identityHashCode(aArr));
        System.out.println("bArr = " + System.identityHashCode(bArr));
        System.out.println("cans = " + System.identityHashCode(cans));
        if (L == m) {
            // 흰돌, 검은돌 선수 인덱스 셋팅
            int aIdx = 0, bIdx = 0;
            for (int x = 0; x < n; x++) {
                if (ch[x] == 1) {
                    aArr[aIdx] = x;
                    aIdx++;
                } else {
                    bArr[bIdx] = x;
                    bIdx++;
                }
            }

            // 흰돌팀과 검은돌팀의 능력차의 최소값
            int sumA = 0, sumB = 0; // todo 전역변수에 선언했었음. 레벨 L이 n/2일 때마다 흰돌팀,검은돌팀이 다른 경우의 수 이므로 초기화 해줘야함.
            for (int y = 0; y < aArr.length; y++) {
                sumA += cans[aArr[y]][0];
                sumB += cans[bArr[y]][1];
            }
            answer = Math.min(answer, Math.abs(sumA - sumB));

        } else {
            for (int i = s; i < n; i++) { // todo i=s 인 이유? 다음 선수를 뽑기 위해서
                // todo if ch[i] == 0인 조건이 빠지는 건지? 어차피 i=s로 했기 때문에 다음 선수를 뽑는다.
                ch[i] = 1;
                DFS(L + 1, i+1);
                ch[i] = 0;
            }
        }
    }

    public int solution(int[][] cans){ // todo 입력데이터 예제에 영향 없이 고정된 값이면 전역변수로 데이터마다 변하는 값이면 지역변수에 초기화 해줘야함.
        answer = Integer.MAX_VALUE; // todo 멤버변수로 초기화해둬서 answer 값을 공유했다.. 지역변수로 수정함.
        this.cans = cans;
        n = cans.length;
        ch = new int[n]; // 팀번호 참가 체크
        m = n/2;
        aArr = new int[m]; // 흰돌선수 인덱스 번호 // todo 배열을 항상 초기화 해주는 게 나을 지.. 덮어쓰일지..
        bArr = new int[m]; // 검은돌선수 인덱스 번호 // todo 배열을 항상 초기화 해주는 게 나을 지.. 덮어쓰일지..
        System.out.println("Arrays.deepToString(cans) = " + Arrays.deepToString(cans));
        DFS(0, 0);

        return answer;
    }

    public static void main(String[] args){
        Ex06_03 T = new Ex06_03();
        System.out.println(T.solution(new int[][]{{87, 84}, {66, 78}, {94, 94}, {93, 87}, {72, 92}, {78, 63}}));
        System.out.println(T.solution(new int[][]{{10, 20}, {15, 25}, {35, 23}, {55, 20}}));
        System.out.println(T.solution(new int[][]{{11, 27}, {16, 21}, {35, 21}, {52, 21}, {25, 33},{25, 32}, {37, 59}, {33, 47}}));
    }
}
