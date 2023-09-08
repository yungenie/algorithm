package study.etc;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateSample {
    public static void main(String[] args) {
        String str = "2016-09-15 20:59:57.421";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
        LocalDateTime endDateTime = LocalDateTime.parse(str, formatter);
//        LocalDateTime startDateTime = endDateTime.minusSeconds((long) 0.351); // 초 빼기
        LocalDateTime startDateTime = endDateTime.minusNanos((long) 0.351); // 초 빼기
        // 0.001 더해야함.
        System.out.println(endDateTime);
        System.out.println(startDateTime);
    }
}

/*
시작과 끝의 조건을 정의하지 못함..



 */