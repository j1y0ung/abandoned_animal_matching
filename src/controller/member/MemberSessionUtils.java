package controller.member;

import javax.servlet.http.HttpSession;

public class MemberSessionUtils {
	public static final String MEMBER_SESSION_KEY = "mem_id";
	
    public static String getLoginMemberId(HttpSession session) {
        String mem_id = (String)session.getAttribute(MEMBER_SESSION_KEY);
        return mem_id;
    }
    
    public static String getMembership(HttpSession session) {
        String membership = (String)session.getAttribute("membership");
        return membership;
    }

    public static boolean hasLogined(HttpSession session) {
        if (getLoginMemberId(session) != null) {
            return true;
        }
        return false;
    }

    public static boolean isLoginMember(String mem_id, HttpSession session) {
        String loginMember = getLoginMemberId(session);
        if (loginMember == null) {
            return false;
        }
        return loginMember.equals(mem_id);
    }
}