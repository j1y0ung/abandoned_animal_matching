package controller.member;

import javax.servlet.http.HttpSession;

public class MemberSessionUtils {
	public static final String MEMBER_SESSION_KEY = "mem_id";
	
	/* 현재 로그인한 사용자의 ID를 구함 */
    public static String getLoginMemberId(HttpSession session) {
        String mem_id = (String)session.getAttribute(MEMBER_SESSION_KEY);
        return mem_id;
    }

    /* 로그인한 상태인지를 검사 */
    public static boolean hasLogined(HttpSession session) {
        if (getLoginMemberId(session) != null) {
            return true;
        }
        return false;
    }

    /* 현재 로그인한 사용자의 ID가 userId인지 검사 */
    public static boolean isLoginMember(String mem_id, HttpSession session) {
        String loginMember = getLoginMemberId(session);
        if (loginMember == null) {
            return false;
        }
        return loginMember.equals(mem_id);
    }
}