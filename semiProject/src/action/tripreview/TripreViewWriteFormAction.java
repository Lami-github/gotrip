package action.tripreview;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import java.io.*;


import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import controller.CommandAction;
import photo.PhotoDBBean;
import tripreview.TripreviewDBBean;

import org.apache.commons.fileupload.disk.DiskFileItemFactory;

public class TripreViewWriteFormAction implements CommandAction { 
	public String requestPro(HttpServletRequest request,
			HttpServletResponse response) throws Throwable {
		String realPath = "";
		String savePath = "imgSave";
		String photo_id ="";
		ServletContext context = request.getSession().getServletContext();
		realPath = context.getRealPath(savePath);
		
		try {
			MultipartRequest multi = new MultipartRequest(request,realPath,5*1024*1024,"utf-8",new DefaultFileRenamePolicy());
			
		String t_htag = multi.getParameter("t_htag");
		String t_subject = multi.getParameter("t_subject");
		String t_content = multi.getParameter("t_content");
		String id = multi.getParameter("id");
				
		TripreviewDBBean dbPro = TripreviewDBBean.getInstance();
		
		Enumeration e=multi.getFileNames();
			
		while(e.hasMoreElements()) {
			String strName = (String)e.nextElement();
			String fileName = multi.getFilesystemName(strName);
			String imgPath = realPath + fileName;
		if(fileName != null) {	
		PhotoDBBean dbPhoto = PhotoDBBean.getInstance();
			dbPhoto.setPhoto(fileName,imgPath);
			
			photo_id += dbPhoto.getPhoto_id()+" ";
		}
		}
		dbPro.setTripreViewList(id,t_subject,t_content,photo_id,t_htag);
		
		}catch (Exception e) {
            e.printStackTrace();
		} 
	return "/NA/tripreView/writeFormPro.jsp";
	}
}

