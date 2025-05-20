package koreaIT.service;

import koreaIT.Member;
import koreaIT.container.Container;
import koreaIT.dao.MemberDao;

import java.sql.Connection;
import java.util.Map;

public class MemberService {
    private Connection conn;
    private MemberDao memberDao = null;


    public MemberService() {
        this.conn = Container.conn;
        this.memberDao = Container.memberDao;
    }

    public boolean isLoginJoinable(String loginId) {

        return memberDao.isLoginJoinable(loginId);
    }

    public int doJoin(String loginId, String loginPw, String name) {
        return memberDao.doJoin(loginId, loginId, name);
    }

    public Member getMemberByLoginId(String loginId) {
        Map<String, Object> memberMap = memberDao.getMemberByLoginId(loginId);

        Member member = new Member(memberMap);

        return member;
    }
}
