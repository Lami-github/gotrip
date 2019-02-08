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
int f_num = Integer.parseInt(request.getParameter("f_num")); //�ش�۹�ȣ
		
		String photoList ="";
		String[] photos=null;
		FestivalDBBean dbPro1 = FestivalDBBean.getInstance(); // DB����
		PhotoDBBean dbPro2 = PhotoDBBean.getInstance(); // DB����
		FestivalDataBean article = new FestivalDataBean();
		article = dbPro1.getArticle(f_num);
		photoList = dbPro2.getArticles(article.getPhoto_id());
		photos = photoList.split(",");
		
		request.setAttribute("photoList", photoList);
		//�ش� �信�� ����� �Ӽ�
		request.setAttribute("article", article);
		request.setAttribute("length", photos.length);
		
		return "/JY/Festival/MainFestivalDetailForm.jsp";
	}

}
