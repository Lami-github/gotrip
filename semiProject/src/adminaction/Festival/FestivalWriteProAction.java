package adminaction.Festival;

import java.io.IOException;
import java.util.*;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import controller.CommandAction;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import festival.FestivalDBBean;
import festival.FestivalDataBean;
import photo.PhotoDBBean;
import photo.PhotoDataBean;

//涝仿等 臂贸府
public class FestivalWriteProAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8"); // 茄臂 牢内爹
		int size =0;

		String realPath = "";
		String savePath = "imgSave";
		String type = "utf-8";
		String photo_id = "";
		int maxSize = 5 * 1024 * 1024;// 5M

		ServletContext context = request.getSession().getServletContext();
		realPath = context.getRealPath(savePath);
		
		ArrayList saveFiles = new ArrayList();
		ArrayList origFiles = new ArrayList();

		try {
			MultipartRequest multi = new MultipartRequest(request, realPath, maxSize, type,
					new DefaultFileRenamePolicy());

			Enumeration files = multi.getFileNames();
			while (files.hasMoreElements()) {
				String name = (String) files.nextElement();
				saveFiles.add(multi.getFilesystemName(name));
				origFiles.add(multi.getOriginalFileName(name));
			}

		size= Integer.parseInt(multi.getParameter("index"))-1;
		
		for (int i = 0; i < origFiles.size(); i++) {
			String img_name = (String) origFiles.get(i);
			
			PhotoDBBean dbpro = PhotoDBBean.getInstance();
			String img_path = realPath + "/" + (String) origFiles.get(i);
			
			if(i != size) {
				photo_id += dbpro.insertPhoto(img_name,img_path,i,size) + " ";
			}
			else {
				photo_id += dbpro.insertPhoto(img_name,img_path,i,size);
			}
			System.out.println("photo_id::"+photo_id);
			
			
		}
		
		FestivalDataBean article = new FestivalDataBean(); // 单捞磐贸府 后
		article.setF_subject(multi.getParameter("f_subject"));
		
		article.setF_url(multi.getParameter("f_url"));
		
		article.setF_country(multi.getParameter("f_country"));
		article.setF_loc(multi.getParameter("f_loc"));
		article.setF_sdate(multi.getParameter("f_sdate"));
		article.setF_edate(multi.getParameter("f_edate"));
		article.setF_content(multi.getParameter("f_content"));
		article.setPhoto_id(photo_id);

		FestivalDBBean dbPro = FestivalDBBean.getInstance(); // DB贸府
		dbPro.insertArticle(article);
		
		} catch (IOException ioe) {
			System.out.println(ioe);
		} catch (Exception ex) {
			System.out.println(ex);
		}
		return "/JY/Festival/FestivalWritePro.jsp";
	}

}
