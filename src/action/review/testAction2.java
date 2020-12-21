package action.review;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dao.ReviewDAO;
import vo.ReviewVO;

// 입양후기 추가작업 후 입양후기 목록 페이지로 이동
@WebServlet("/review/insert2")
public class testAction2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		//doGet(request, response);

		// 늘 언제라도 문자셋을 설정해준다.

		//request.setCharacterEncoding("UTF-8");



		// 파일 업로드 => 클라이언트가 선택한 파일을 서버의 하드디스크에 복사하는 기능

		// 이러한 기능을 수행 하려면 알아햐 하는 것들

		// 1. 목적지(어디로 복사할 것인지) 경로 설정

		// 현재 웹어플리케이션을 기준으로 upload폴더를 만들어 두었다.

		// 실제 경로는 request 를 통해서 알아온다.
//		String path = request.getSession().getServletContext().getRealPath("/");

//		String path = request.getRealPath("/upload");
		String path = request.getSession().getServletContext().getContext("/upload").getRealPath("images");
		System.out.println("path" +path);




		//System.out.println("path:"+ path);

		// 결과 ==> 

		//path :C:\jspStudy\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\day0412밑에upload 



		//파일경로가 잘 생성되는지 확인하기 위해 만들어 놓음

		// 또한 현재 저 밑에 else에 해당하는 문서가 없기에 문자를 쓰기 위해 사용

		// request.setCharacterEncoding("UTF-8"); 이렇게 따로하던것을 

		// 밑에처럼 response.setContentType("text/html;UTF-8"); 이렇게 사용해도 무방하다.

		response.setContentType("text/html; charset=UTF-8");

		PrintWriter out = response.getWriter();

		//out.println("path :"+ path);





		// 2. 클라이언트가 선택한 파일을 서버에 복사하기 위해서는

		// cos.jar가 제공하는 MultipartRequest를 생성한다.

		// 여기까지는 파일업로드만 가능한 상황이다.

		MultipartRequest multi = new MultipartRequest(request, path);



		//MultipartRequest 객체를 생성한 순간 서버에 하드디스크에 파일복사가 일어난다.

		// 나머지 사용자의 입력값을 받아온다.

		// request를 이용하지 않고 MultipartRequest 객체를 통해 받아온다.

//		GoodsVo g = new GoodsVo();
//
//		g.setItem(multi.getParameter("item"));
//
//		g.setPrice(Integer.parseInt(multi.getParameter("price")));
//
//		g.setDetail(multi.getParameter("detail"));
//
//
//
//		// <form action="InsertGoods" method="post" enctype="multipart/form-data">
//
//		// form 태그에 위처럼 되어있을때 
//
//		// <input type="file" name="img">
//
//		// 로부터 받아 오는 것을 파일이름이 아니라 img에 실려오는 것은 파일의 내용이 실려온다.
//
//		// 그래서 다른것처럼 multi.getParameter로 가져오는 것이아니라
//
//		// multi.getFilesystemName("img"); 를 이용하여 업로드한 파일명을 알아 온다.
//
//		g.setImg(multi.getFilesystemName("img"));
//
//
//
//		// 가져온 것을 다 했기에 dao에게 일처리를 맡김
//
//		GoodsDao dao = new GoodsDao();
//
//		int re = dao.insertGoods(g);
//
//
//
//		if(re ==1){
//
//			out.println("성공");
//
//		}else{
//
//			out.println("실패");
//
//		}

	}
} 