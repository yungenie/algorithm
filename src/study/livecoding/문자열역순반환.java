package study.livecoding;

public class 문자열역순반환 {
    public static void main(String[] args) {
        String str = "abcdefg";
        StringBuilder sb = new StringBuilder(str);
        sb.reverse();
        System.out.println("sb = " + sb);
    }
}
