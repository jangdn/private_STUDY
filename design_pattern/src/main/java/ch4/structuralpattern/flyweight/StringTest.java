package ch4.structuralpattern.flyweight;

import net.bytebuddy.agent.builder.AgentBuilder;

public class StringTest {
    public static void main(String[] args) {
        String jangdn = "jangdn";
        String jangdnNew = "jangdn";
        String jangdnNewNew = "jangdn2";
        String jangdn2 = new String(jangdn);
        String jangdn3 = new String("jangdn");
        String anotherJangdn = new String("another");

        // jangdn 과 jangdn2.intern 은 intern 메소드에 의해 constant pool 에서 조회해온 String 주소 값이 return 될 것이므로 true
        System.out.println(jangdn == jangdn2.intern());

        // String 자체가 flyweight 패턴으로 구현되어있다고 오판하여 해당 주소값이 같은지를 테스트해봄 -> false 나오는게 정상
        System.out.println(jangdn == jangdnNewNew);

        String newJangdn = "newJangdn";
        String newnewJangdn = new String("newnewJangdn");

        // 두개의 데이터는 초기 hash 값이 0으로 같고, char List 에 의해 만들어진 hash 값이 계속해서 더해지면서 hashCode 값이 만들어짐
        // char List 형의 주소값부터 데이터까지 모두 같으므로 해당 값은 같게 나와야 함.
        System.out.println(jangdn.hashCode() == jangdn2.hashCode());

        // TODO 리터럴형은 어떻게 객체를 만들어낼까?
    }
}
