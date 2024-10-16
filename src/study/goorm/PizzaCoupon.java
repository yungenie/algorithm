package study.goorm;

import java.util.Scanner;

public class PizzaCoupon {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // n은 구름이가 처음에 가지고 있는 피자 판 수 또는 쿠폰 수
        int m = sc.nextInt(); // m은 피자 한 판을 교환하는 데 필요한 쿠폰 수

        // 최대 피자 판 수를 계산하는 메서드 호출
        int maxPizzas = getMaxPizzas(n, m);

        // 결과 출력
        System.out.println(maxPizzas);
    }

    public static int getMaxPizzas(int n, int m) {
        // 구름이가 먹을 수 있는 피자 수를 초기값으로 설정 (처음에 x개의 쿠폰으로 피자 n판을 시킴)
        int totalPizzas = n;

        // 현재 가지고 있는 쿠폰 수
        int coupons = n;

        // 쿠폰을 사용하여 더 이상 피자를 주문할 수 없을 때까지 반복 (현재 쿠폰 수 >= 교환 가능한 최소 쿠폰 수)
        while (coupons >= m) {
            // 쿠폰으로 피자를 시켜 먹을 수 있는 판 수
            int addPizzas = coupons / m;

            // 시킨 피자 수만큼 총 피자 수에 더해줌
            totalPizzas += addPizzas;

            // 시킨 피자로 인해 추가로 얻은 쿠폰 수를 업데이트
            // (추가로 얻은 쿠폰 = 시킨 피자 수 addPizzas, 남은 쿠폰 = 시킨 후 남은 쿠폰 coupons % m)
            coupons = addPizzas + coupons % m;
        }

        return totalPizzas;
    }
}
