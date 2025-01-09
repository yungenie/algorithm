package study.etc.test;

public class StringTest {
    public static void main(String[] args) {
        String str = "ab";

        boolean equals = "AB".equals(str);
        System.out.println(equals);

        String str2 = "AB";

        char charAt1 = str.charAt(0);
        char charAt = str2.charAt(0);

        System.out.println(charAt1);
        System.out.println(charAt);

        // equals() 테스트
        System.out.println("Hello".equalsIgnoreCase("hello")); // true
        System.out.println("Hello".equalsIgnoreCase("HELLO")); // true
        System.out.println("Hello".equals("HELLO")); // false
        System.out.println("Hello".equals("hello")); // false
        System.out.println("Hello".equals("Hello")); // true


        // substring 테스트
        // subString(시작인덱스) >> 지정한 시작인덱스 부터 끝까지
        // subString(시작인덱스, 끝 인덱스) >> 지정한 시작 인덱스 부터 지정한 끝 인덱스-1 까지. (끝 인덱스 포함하지 않음)
        System.out.println(str.substring(0));
        String text = "Small";
        System.out.println("=======substring()테스트========");
        System.out.println(text.substring(0,2)); // Sm


    }
}
