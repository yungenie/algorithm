package study.inflearn.lecture01.section2;

import java.util.Scanner;

public class Ex02_03_문장속단어 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] sentence = sc.nextLine().split(" ");

        int maxWordLength = 0;
        for (int i = 0; i < sentence.length; i++) {
            maxWordLength = Math.max(maxWordLength, sentence[i].length());
        }

        for (int i = 0; i < sentence.length; i++) {
            if (maxWordLength == sentence[i].length()) {
                System.out.println(sentence[i]);
                break;
            }
        }

    }
}
