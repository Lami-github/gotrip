package action.buyer;

import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import buyer.BuyerDBBean;
import controller.CommandAction;
import photo.PhotoDBBean;

public class BuyerWriteFormAction implements CommandAction {
	public String requestPro(HttpServletRequest request,
			HttpServletResponse response) throws Throwable {
		
		String realPath = "";
		String savePath = "imgSave";
		String photo_id ="";
		
		ServletContext context = request.getSession().getServletContext();
		realPath = context.getRealPath(savePath);
		
		try {
			MultipartRequest multi = new MultipartRequest(request,realPath,5*1024*1024,"utf-8",new DefaultFileRenamePolicy());
			
		String b_subject = multi.getParameter("b_subject");
		String b_country = multi.getParameter("b_country");
		String b_item = multi.getParameter("b_item");
		int b_count = Integer.parseInt(multi.getParameter("b_count"));
		int b_price = Integer.parseInt(multi.getParameter("b_price"));
		String b_content = multi.getParameter("b_content");
		String id = multi.getParameter("id");
				
		BuyerDBBean dbPro = BuyerDBBean.getInstance();

		int check = dbPro.pointcheck(id, b_price);			
		if (check == 1) {
			Enumeration e=multi.getFileNames();
			
			while(e.hasMoreElements()) {
				String strName = (String)e.nextElement();
				String fileName = multi.getFilesystemName(strName);
				String imgPath = realPath + fileName;
			
				PhotoDBBean dbPhoto = PhotoDBBean.getInstance();
				dbPhoto.setPhoto(fileName,imgPath);
				
				photo_id += dbPhoto.getPhoto_id()+" ";
			
			}
		dbPro.setBuyerBoardList(id,b_subject,b_country,b_item,b_count,b_price,b_content,photo_id);
		}
		}catch (Exception e) {
            e.printStackTrace();
		} 
	return "/NA/buyer/writeFormPro.jsp";
	}
}
