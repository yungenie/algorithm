package study.etc.test;

public class StringIsBlankAndEmptyMethodTest {
    public static void main(String[] args) {
        String str = "hello";
        String str2 = "";
        String str3 = " ";

        /**
         * isEmpty() : 참조값은 있는데 값의 길이가 0인 것
         * isBlank() : 참조값은 있고, 값의 길이가 0이거나 값이 공백이 들어간 것. (empty or white space)
          */

        System.out.println(str.isEmpty()); // false
        System.out.println(str.isBlank()); // false
        System.out.println(str2.isEmpty()); // true
        System.out.println(str2.isBlank()); // true
        System.out.println(str3.isEmpty()); // false
        System.out.println(str3.isBlank()); // true

    }
}
