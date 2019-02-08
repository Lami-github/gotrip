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
		
		
		String commentId = request.getParameter("id"); //코멘트 작성하는 사람 id(현재 로그인한사람의 id)
	
		int b_num = Integer.parseInt(request.getParameter("b_num"));// 게시글번호
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

		request.setAttribute("commentId", commentId); // 코멘트작성자 아이디
		request.setAttribute("count", new Integer(count)); // 해당글 코멘트 전체 개수
		request.setAttribute("photos", photos);
		request.setAttribute("imgPath", imgPath); // 해당글 이미지패스 배열
		request.setAttribute("buyerBoardContent", buyerBoardContent); // 해당글 내용 객체
		request.setAttribute("buyerBoardCommentList", buyerBoardCommentList); // 해당글 전체 코멘트들 리스트로
		
		return "/NA/buyer/contentForm.jsp";
	}
}