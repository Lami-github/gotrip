package adminaction.Festival;

import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.CommandAction;
import festival.FestivalDBBean;
import festival.FestivalDataBean;
import photo.PhotoDBBean;
import photo.PhotoDataBean;

public class FestivalModifyFormAction implements CommandAction { //회원인증 폼 처리

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		String f_num = request.getParameter("num"); // 페이지 번호
		
		
		List photoList = null;
		
		FestivalDBBean dbPro1 = FestivalDBBean.getInstance(); // DB연동
		PhotoDBBean dbPro2 = PhotoDBBean.getInstance(); // DB연동
		FestivalDataBean article = new FestivalDataBean();
		article=dbPro1.getArticle(Integer.parseInt(f_num));
		
		/*photoList = dbPro2.getArticles(article.getPhoto_id());
		
		request.setAttribute("photoList", photoList);*/
		request.setAttribute("article", article);
		request.setAttribute("modify", 1);
		
		return "/JY/Festival/FestivalWriteForm.jsp";//해당 
	}

}
