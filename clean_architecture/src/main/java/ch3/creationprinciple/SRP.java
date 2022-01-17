package ch3.creationprinciple;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// solid 법칙 - srp
public class SRP {

    public static void main(String[] args) {
        // A 서비스 개발자
        AMember 안장우 = new AMember("안장우", new ArrayList<>(Arrays.asList(Authority.A_READ_AUTH, Authority.A_UPDATE_AUTH)));
        if (!filterAuth(안장우)) {
            throw new RuntimeException("권한 문제가 있습니다.");
        }
        System.out.println(안장우);

        // B 서비스 개발자
        // Authority 모델이 있네? 같이 써볼까?
        BMember 신재헌 = new BMember("신재헌", new ArrayList<>(Arrays.asList(Authority.B_READ_AUTH, Authority.B_UPDATE_AUTH)));
        if (!filterAuth(신재헌)) {
            throw new RuntimeException("권한 문제가 있습니다.");
        }
        System.out.println(신재헌);

        // A 서비스 개발자가 기존 Authority 모델에 세부 기능 별로 권한을 넣으려함
        NewAMember new안장우 = new NewAMember("안장우", new ArrayList<>(Arrays.asList(Authority.A_READ_AUTH, Authority.A_UPDATE_AUTH)));
        if (!newFilterAuth(안장우)) {
            throw new RuntimeException("권한 문제가 있습니다.");
        }
        System.out.println(안장우);
    }

    private static boolean filterAuth(BMember member) {
        return member.authorities.contains(Authority.B_READ_AUTH);
    }

    private static boolean filterAuth(AMember member) {
        return member.authorities.contains(Authority.A_READ_AUTH);
    }

    @ToString
    @AllArgsConstructor
    static class AMember {
        private String name;
        private List<Authority> authorities;
    }

    @ToString
    @AllArgsConstructor
    static class BMember {
        private String name;
        private List<Authority> authorities;
    }

    enum Authority {
        A_READ_AUTH,
        A_UPDATE_AUTH,

        // 추가
        B_READ_AUTH,
        B_UPDATE_AUTH
    }

    private static boolean newFilterAuth(AMember member) {
        return member.authorities.contains(NewAuthority.A_READ_AUTH) && NewAuthority.A_READ_AUTH.isA기능();
    }

    @ToString
    @AllArgsConstructor
    static class NewAMember {
        private String name;
        private List<Authority> authorities;
    }

    // A를 위한 authority 모델이 변경된다면 B 모델도 변경되어야함
    // SRP 위배
    enum NewAuthority {
        // 변경
        A_READ_AUTH(true, false),
        A_UPDATE_AUTH(true, false),

        // ?????
        B_READ_AUTH(false, false),
        B_UPDATE_AUTH(false, false);

        private boolean a기능;

        public boolean isA기능() {
            return a기능;
        }

        public boolean isB기능() {
            return b기능;
        }

        private boolean b기능;

        NewAuthority(boolean A_a기능, boolean A_b기능) {
            a기능 = A_a기능;
            b기능 = A_b기능;
        }
    }
}
