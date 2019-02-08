package action.tripreview;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.CommandAction;
import photo.PhotoDBBean;


public class TripreViewUpdateFormAction implements CommandAction { 
		public String requestPro(HttpServletRequest request,
				HttpServletResponse response) throws Throwable {
			
			String t_subject = request.getParameter("t_subject"); //게시글 제목
			String t_content = request.getParameter("t_content"); //게시글 내용

			int t_num = Integer.parseInt(request.getParameter("t_num"));// 게시글번호
			String t_htag = request.getParameter("t_htag"); //해시태그
			String photo_id = request.getParameter("photo_id"); // 사진 id
			
			
			PhotoDBBean dbPhoto = PhotoDBBean.getInstance();
			String[] photo;
			if(photo_id != null) {
				photo =	dbPhoto.getImgNameAll(photo_id);
				request.setAttribute("photo", photo); 
			}
			
			request.setAttribute("t_subject", t_subject); 
			request.setAttribute("t_content", t_content); 

			request.setAttribute("t_num", new Integer(t_num));
			request.setAttribute("t_htag", t_htag); 
			
			return "/NA/tripreView/updateForm.jsp";
		}
}