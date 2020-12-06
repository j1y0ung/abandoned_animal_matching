package controller.member;

import javax.servlet.http.HttpSession;

public class MemberSessionUtils {
	public static final String MEMBER_SESSION_KEY = "mem_id";
	
	/* ���� �α����� ������� ID�� ���� */
    public static String getLoginMemberId(HttpSession session) {
        String mem_id = (String)session.getAttribute(MEMBER_SESSION_KEY);
        return mem_id;
    }

    /* �α����� ���������� �˻� */
    public static boolean hasLogined(HttpSession session) {
        if (getLoginMemberId(session) != null) {
            return true;
        }
        return false;
    }

    /* ���� �α����� ������� ID�� userId���� �˻� */
    public static boolean isLoginMember(String mem_id, HttpSession session) {
        String loginMember = getLoginMemberId(session);
        if (loginMember == null) {
            return false;
        }
        return loginMember.equals(mem_id);
    }
}