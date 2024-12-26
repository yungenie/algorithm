package study.etc.test;

public class SwitchCaseTest {
    public static void main(String[] args) {
        String cmd = "pop";

        switch (cmd) {
            case "push":
                System.out.println("case push");
            case "pop":
                System.out.println("case pop");
            case "last":
                System.out.println("case last");
        }

        /**
         * switch case break 없는 경우 참인 조건문에서 빠져나오지 않고 그 뒤 case 모두 실행된다.
         */

    }
}
