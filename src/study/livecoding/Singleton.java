package study.livecoding;

public class Singleton {

    // 외부 생성 금지
    private Singleton() {}

    // 인스턴스 생성 (static 클래스를 통해 인스턴스화)
    private static class InnerInstanceClass {
        public static final Singleton INSTANCE = new Singleton();
    }

    // 인스턴스 사용 (static 메서드 통해 인스턴스 얻을 수 있도록)
    public static Singleton getInstance() {
        return InnerInstanceClass.INSTANCE;
    }
}
