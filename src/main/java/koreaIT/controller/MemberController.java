package koreaIT.controller;

import koreaIT.Member;
import koreaIT.container.Container;
import koreaIT.service.MemberService;

import java.util.Scanner;

public class MemberController {
    private MemberService memberService;
    private Scanner sc;


    public MemberController() {
        this.memberService = Container.memberService;
        this.sc = Container.sc;
    }

    public void doJoin() {

        if (Container.session.isLogined()) {
            System.out.println("로그아웃하고 이용하세요.");
            return;
        }

        String loginId = null;
        String loginPw = null;
        String name = null;

        while (true) {
            System.out.print("새 아이디 : ");
            loginId = sc.nextLine().trim();
            if (loginId.length() == 0 || loginId.contains(" ")) {
                System.out.println("아이디 똑바로 입력하시오.");
                continue;
            }

            boolean isLoginJoin = memberService.isLoginJoinable(loginId);

            if (isLoginJoin) {
                System.out.println(loginId + "는(은) 이미 사용중입니다.");
                continue;
            }
            break;

        }
        while (true) {
            System.out.print("새 비밀번호 : ");
            loginPw = sc.nextLine();

            if (loginPw.length() == 0 || loginPw.contains(" ")) {
                System.out.println("비밀번호 똑바로 입력하시오.");
                continue;
            }
            System.out.print("비밀번호 확인 : ");
            String loginPwCheck = sc.nextLine();
            if (loginPw.equals(loginPwCheck) == false) {
                System.out.println("비밀번호가 일치하지 않습니다.");
                continue;
            }
            break;
        }

        while (true) {
            System.out.print("새 이름 : ");
            name = sc.nextLine().trim();
            if (name.length() == 0 || name.contains(" ")) {
                System.out.println("이름 똑바로 입력하시오.");
                continue;
            }
            break;
        }
        int id = memberService.doJoin(loginId, loginId, name);

        System.out.println(id + "번 회원 생성되었습니다.");

    }

    public void doLogin() {

        if (Container.session.isLogined()) {
            System.out.println("로그아웃하고 로그인하세요.");
            return;
        }


        String loginId;
        String loginPw;

        System.out.println("=== 로그인 ===");

        while (true) {
            System.out.print("로그인 아이디 : ");
            loginId = sc.nextLine();

            if (loginId.length() == 0 || loginId.contains(" ")) {
                System.out.println("아이디 똑바로 입력하시오.");
                continue;
            }

            boolean isJoined = memberService.isLoginJoinable(loginId);

            if (!isJoined) {
                System.out.println(loginId + "는(은) 없습니다.");
                continue;
            }
            break;
        }

        //로그인 아이디 있는 상황
        Member member = memberService.getMemberByLoginId(loginId);


        int MaxCount = 5;
        int tryCount = 0;

        while (true) {
            if (tryCount >= MaxCount) {
                System.out.println("비밀번호가 5회 틀렸습니다. 다시 시도해주세요.");
                break;
            }
            System.out.print("로그인 비밀번호 : ");
            loginPw = sc.nextLine();

            if (loginPw.length() == 0 || loginPw.contains(" ")) {
                System.out.printf("비밀번호 똑바로 입력하시오. (%d/5번)\n", ++tryCount);
                continue;
            }
            if (!loginPw.equals(member.getLoginPw())) {
                System.out.printf("비밀번호가 일치하지 않습니다. (%d/5번)\n", ++tryCount);
                continue;
            }

            // 로그인 상태를 세션에 저장
            Container.session.login(member);

            System.out.println(member.getName() + "님 환영합니다.");
            break;
        }
    }

    public void doLogout() {

        if (Container.session.loginedMember == null) {
            System.out.println("로그인을 먼저 하세요.");
            return;
        }

        Container.session.logout();

        System.out.println("로그아웃 되었습니다.");

    }
}

