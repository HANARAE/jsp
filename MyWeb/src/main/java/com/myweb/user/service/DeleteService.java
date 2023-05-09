package com.myweb.user.service;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.myweb.user.model.UserDAO;
import com.myweb.user.model.UserVO;

public class DeleteService implements IUserService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession();
		UserVO vo = (UserVO) session.getAttribute("user");

		String pw = request.getParameter("check_pw");
		String id = vo.getUserId();

		UserDAO dao = UserDAO.getInstance();

		response.setContentType("text/html; charset=UTF-8");

		PrintWriter out = null;
		String htmlCode;



		try {
			if(dao.userCheck(id, pw) == 0) {
				htmlCode = "<script>\r\n"
						+ "alert('비밀번호가 틀렸습니다.');\r\n"
						+ "location.href='/MyWeb/myPage.user';\r\n"
						+ "</script>";
			} else {
				session.invalidate();
				dao.deleteUser(id);
				out = response.getWriter();
				htmlCode = "<script>\r\n"
						+ "alert('회원탈퇴 처리되었습니다.');\r\n"
						+ "location.href='/MyWeb';\r\n"
						+ "</script>";
			}
			out.print(htmlCode);
			out.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}  finally {
			out.close();
		}


	}

}
