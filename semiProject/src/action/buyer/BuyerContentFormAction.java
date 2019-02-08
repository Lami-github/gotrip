package action.buyer;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import buyer.BuyerDBBean;
import buyer.BuyerDataBean;
import buyer.comment.BuyerCommentDBBean;
import controller.CommandAction;
import photo.PhotoDBBean;

public class BuyerContentFormAction implements CommandAction { 
	public String requestPro(HttpServletRequest request,
			HttpServletResponse response) throws Throwable {
		
		
		String commentId = request.getParameter("id"); //�ڸ�Ʈ �ۼ��ϴ� ��� id(���� �α����ѻ���� id)
	
		int b_num = Integer.parseInt(request.getParameter("b_num"));// �Խñ۹�ȣ
		String photos = "";
			
	
		int count = 0;
		
		List buyerBoardCommentList = null;
		BuyerCommentDBBean dbcPro = BuyerCommentDBBean.getInstance();

		buyerBoardCommentList = dbcPro.getBuyerBoardComment(b_num);
		count = dbcPro.getBuyerBoardCommentCount(b_num);
		
		String[] imgPath = null;
		BuyerDBBean dbPro = BuyerDBBean.getInstance();
		BuyerDataBean buyerBoardContent = dbPro.getContentForm(b_num);
		PhotoDBBean dbPhoto = PhotoDBBean.getInstance();
		if((buyerBoardContent.getPhoto_id() != null)&(buyerBoardContent.getPhoto_id() != ""))
			imgPath = dbPhoto.getImgNameAll(buyerBoardContent.getPhoto_id());
		System.out.println("asdfasd:"+buyerBoardContent.getPhoto_id());
		photos = buyerBoardContent.getPhoto_id().substring(0,buyerBoardContent.getPhoto_id().length()-1);
		System.out.println("photos: " +photos);

		request.setAttribute("commentId", commentId); // �ڸ�Ʈ�ۼ��� ���̵�
		request.setAttribute("count", new Integer(count)); // �ش�� �ڸ�Ʈ ��ü ����
		request.setAttribute("photos", photos);
		request.setAttribute("imgPath", imgPath); // �ش�� �̹����н� �迭
		request.setAttribute("buyerBoardContent", buyerBoardContent); // �ش�� ���� ��ü
		request.setAttribute("buyerBoardCommentList", buyerBoardCommentList); // �ش�� ��ü �ڸ�Ʈ�� ����Ʈ��
		
		return "/NA/buyer/contentForm.jsp";
	}
}