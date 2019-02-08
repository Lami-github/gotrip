package action.traveler;

import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import controller.CommandAction;
import photo.PhotoDBBean;
import traveler.TravelerDBBean;


public class TravelerWriteAction implements CommandAction { 
	public String requestPro(HttpServletRequest request,
			HttpServletResponse response) throws Throwable {
		
		String realPath="";
		String savePath = "imgSave";
		String photo_id ="";
		ServletContext context = request.getSession().getServletContext();
		realPath = context.getRealPath(savePath);
		try {
			MultipartRequest multi = new MultipartRequest(request,realPath,5*1024*1024,"utf-8",new DefaultFileRenamePolicy());
			
		String tr_subject = multi.getParameter("tr_subject");
		String begin_country = multi.getParameter("begin_country");
		String arrived_country = multi.getParameter("arrived_country");
		String begin_day = multi.getParameter("begin_day");
		String arrived_day = multi.getParameter("arrived_day");
		int limit_money = Integer.parseInt(multi.getParameter("limit_money"));
		String tr_content = multi.getParameter("tr_content");
		String id = (String)request.getSession().getAttribute("id");
		
		TravelerDBBean dbPro = TravelerDBBean.getInstance();
		
		Enumeration e=multi.getFileNames();
			
		if(e.hasMoreElements()) {
			String strName = (String)e.nextElement();
			String fileName = multi.getFilesystemName(strName);
			String imgPath = realPath + fileName;
			
		PhotoDBBean dbPhoto = PhotoDBBean.getInstance();
			dbPhoto.setPhoto(fileName,imgPath);
			
			photo_id += dbPhoto.getPhoto_id()+" ";
			
		}
		dbPro.setTravelerBoardList(id,tr_subject,begin_country,arrived_country,begin_day,arrived_day,limit_money,tr_content,photo_id);
		
		}catch (Exception e) {
            e.printStackTrace();
		} 
	return "/NA/traveler/writeFormPro.jsp";
	}
}