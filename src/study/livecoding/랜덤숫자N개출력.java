package study.livecoding;

import java.util.Random;
import java.util.Scanner;

public class 랜덤숫자N개출력 {
    public static void main(String[] args) {

        // 출력할 갯수 입력받기
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();

        // 랜덤 숫자 생성
        Random random = new Random();

        // 랜덤 숫자 출력
        for (int i = 0; i < len; i++) {
            System.out.println(random.nextInt(9) * 1);
        }


    }
}
