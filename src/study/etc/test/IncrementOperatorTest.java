package study.etc.test;

public class IncrementOperatorTest {
    public static void main(String[] args) {
        // 증감 연산자
        int x = 0;
        x++;
        System.out.println(x); // 1

        x=0;
        int y = x++; // 후위 증가 연산자
        System.out.println(x); //1
        System.out.println(y); //1 >> 0임. x를 y에 대입하고, 이후 x를 증가함.

        x=0;
        y = ++x; // 전위 증가 연산자
        System.out.println(x); // 1
        System.out.println(y); // 1 >> x를 증가 후 y에 대입.
    }
}
