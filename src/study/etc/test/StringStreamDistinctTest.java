package study.etc.test;

import java.util.Arrays;
import java.util.stream.Stream;

public class StringStreamDistinctTest {
    public static void main(String[] args) {
        /**
         * 문자열을 바로 stream api로 처리하는 기능은 없지만,
         * 문자열을 스트림으로 변환해서 사용할 수 있음.
         */
        String str = "testt";
        Stream<String> ss = Arrays.stream(str.split(""));
        ss.distinct().forEach(System.out::print);
    }
}
