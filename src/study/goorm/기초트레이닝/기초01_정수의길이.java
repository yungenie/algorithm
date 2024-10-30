package study.goorm.기초트레이닝;

import java.io.*;

public class 기초01_정수의길이 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        System.out.println(input.length());
    }
}
