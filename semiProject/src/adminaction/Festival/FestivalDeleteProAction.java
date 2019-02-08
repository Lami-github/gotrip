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

//�Էµ� ��ó��
public class FestivalDeleteProAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");//�ѱ� ���ڵ�
        
        int f_num = Integer.parseInt(request.getParameter("num"));
        String photo_id = request.getParameter("photo_id");
        String[] photos = photo_id.split(" ");

        FestivalDBBean dbPro = FestivalDBBean.getInstance();//DBó��
        
        dbPro.deleteArticle(f_num,photos);
        //�ش� �信�� ����� �Ӽ�


        return "/JY/Festival/FestivalModifyPro.jsp";//�ش� ��
	}

}
