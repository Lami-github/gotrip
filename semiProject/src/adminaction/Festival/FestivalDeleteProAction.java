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
import member.MemberDBBean;
import member.MemberDataBean;
import photo.PhotoDBBean;
import photo.PhotoDataBean;

//입력된 글처리
public class FestivalDeleteProAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");//한글 인코딩
        
        int f_num = Integer.parseInt(request.getParameter("num"));
        String photo_id = request.getParameter("photo_id");
        String[] photos = photo_id.split(" ");

        FestivalDBBean dbPro = FestivalDBBean.getInstance();//DB처리
        
        dbPro.deleteArticle(f_num,photos);
        //해당 뷰에서 사용할 속성


        return "/JY/Festival/FestivalModifyPro.jsp";//해당 뷰
	}

}
