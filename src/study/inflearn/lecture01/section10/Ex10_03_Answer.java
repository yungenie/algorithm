package study.inflearn.lecture01.section10;

import java.util.Scanner;

/**
 * 최대 부분 증가수열
 */
public class Ex10_03_Answer {
    static int[] dy;
    public int solution(int[] arr){
        int answer=0;
        dy=new int[arr.length];
        dy[0]=1;
        for(int i=1; i<arr.length; i++){
            int max=0;
            for(int j=i-1; j>=0; j--){
                if(arr[j]<arr[i] && dy[j]>max) max=dy[j];
            }
            dy[i]=max+1;
            answer=Math.max(answer, dy[i]);
        }
        return answer;
    }

    public static void main(String[] args){
        Ex10_03_Answer T = new Ex10_03_Answer();
        Scanner kb = new Scanner(System.in);
        int n=kb.nextInt();
        int[] arr=new int[n];
        for(int i=0; i<n; i++){
            arr[i]=kb.nextInt();
        }
        System.out.print(T.solution(arr));
    }

}

/*
9
2 7 5 8 6 4 7 12 3
>> 5

8
5 3 7 8 6 2 9 4
>> 4
 */