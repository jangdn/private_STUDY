package ch4.structuralpattern.flyweight;

import java.lang.reflect.Field;
import java.util.Arrays;

public class IntegerTest {
    public static void main(String[] args) throws IllegalAccessException {
        // primitive 타입들의 wrapper 클래스의 cache 에 대해서 알아보자
        Integer one = Integer.valueOf(1);
        Integer one2 = Integer.valueOf(1);

        // one2 는 one 에 의해 만들어진 cache 데이터 중 하나가 조회되어 return 될 것이므로 같은 데이터가 조회될 것
        System.out.println(one == one2); // return true

        Integer number = Integer.valueOf(129);
        Integer number2 = Integer.valueOf(129);

        // number 는 128 의 범위 이상에 존재하므로 캐시되지 않음
        System.out.println(number == number2); // return false

        // 실제 캐시값이 어떻게 들어가있는지 뜯어봅시다
        // 실제 캐시값은 사용하는 시점이 아닌 Integer class가 자체적으로 들고있는 형식이네요.
        for (Class<?> declaredClass : one.getClass().getDeclaredClasses()) {
            Field[] declaredFields = declaredClass.getDeclaredFields();
            for (Field declaredField : declaredFields) {
                if (declaredField.getName().equals("cache")) {
                    declaredField.setAccessible(true);
                    Integer[] integers = (Integer[]) declaredField.get(declaredField.getName());
                    System.out.println(declaredField);

                    final int[] i = {0};
                    Arrays.stream(integers).forEach(
                        integer -> {
                            System.out.println("value => " + i[0] + " : " + integer);
                            i[0] =+ 1;
                        }
                    );

                }
            }
        }
    }
}
