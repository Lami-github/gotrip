package action.festival;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.CommandAction;
import festival.FestivalDBBean;
import festival.FestivalDataBean;
import photo.PhotoDBBean;





public class FestivalDetailFormAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
int f_num = Integer.parseInt(request.getParameter("f_num")); //해당글번호
		
		String photoList ="";
		String[] photos=null;
		FestivalDBBean dbPro1 = FestivalDBBean.getInstance(); // DB연동
		PhotoDBBean dbPro2 = PhotoDBBean.getInstance(); // DB연동
		FestivalDataBean article = new FestivalDataBean();
		article = dbPro1.getArticle(f_num);
		photoList = dbPro2.getArticles(article.getPhoto_id());
		photos = photoList.split(",");
		
		request.setAttribute("photoList", photoList);
		//해당 뷰에서 사용할 속성
		request.setAttribute("article", article);
		request.setAttribute("length", photos.length);
		
		return "/JY/Festival/MainFestivalDetailForm.jsp";
	}

}
