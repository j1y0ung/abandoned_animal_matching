package controller.question;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import model.service.MemberManager;
import model.Question;

public class DownloadFileController implements Controller {
	private static final Logger log = LoggerFactory.getLogger(DownloadFileController.class);
	
	@Override
    public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception {
		request.setCharacterEncoding("UTF-8");
		int que_id = Integer.parseInt(request.getParameter("que_id"));
		
		MemberManager manager = MemberManager.getInstance();
		Question que = manager.findQuestion(que_id);
		
		String filename = que.getFilename();
		
		String uploadFileName = request.getSession().getServletContext().getRealPath("/images") + "/" + filename;
		File downFile = new File(uploadFileName);
		
		if (downFile.exists() && downFile.isFile()) {
			try {
				long filesize = downFile.length();
				
				response.setContentType("application/x-msdownload");
				response.setContentLength((int) filesize);
				String strClient = request.getHeader("user-agent");
				
				if (strClient.indexOf("MSIE 5.5") != -1) {
					response.setHeader("Content-Disposition", "filename="
							+ filename + ";");
				} else {
					response.setHeader("Content-Disposition",
							"attachment; filename=" + filename + ";");
				}
				response.setHeader("Content-Length", String.valueOf(filesize));
				response.setHeader("Content-Transfer-Encoding", "binary;");
				response.setHeader("Pragma", "no-cache");
				response.setHeader("Cache-Control", "private");
				
				byte b[] = new byte[1024];
				
				BufferedInputStream fin = new BufferedInputStream(
						new FileInputStream(downFile));
				
				BufferedOutputStream outs = new BufferedOutputStream(
						response.getOutputStream());
				
				int read = 0;
				
				while ((read = fin.read(b)) != -1) {
					outs.write(b, 0, read);
				}
				outs.flush();
				outs.close();
				fin.close();
			} catch (Exception e) {
				System.out.println("Download Exception : " + e.getMessage());
			}
		} else {
			System.out.println("Download Error : downFile Error [" + downFile + "]");
		}
		return null;
	}
}
