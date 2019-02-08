package action.tripreview;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.CommandAction;
import photo.PhotoDBBean;
import tripreview.TripreviewDBBean;
import tripreview.TripreviewDataBean;
import tripreview.comment.TripreViewCommentDBBean;


public class TripreContentFormAction implements CommandAction { 
	public String requestPro(HttpServletRequest request,
			HttpServletResponse response) throws Throwable {
		
		String commentId = request.getParameter("id"); //코멘트 작성하는 사람 id(현재 로그인한사람의 id)
		int t_num = Integer.parseInt(request.getParameter("t_num"));// 게시글번호
		String commentText = request.getParameter("commentText"); //코멘트 내용
				
		
		int count = 0;
		
		List tripreViewCommentList = null;
		TripreViewCommentDBBean dbcPro = TripreViewCommentDBBean.getInstance();
		if(commentText != null) {
			dbcPro.setTripreViewComment(commentId,t_num,commentText);
			}
		tripreViewCommentList = dbcPro.getTripreViewComment( t_num);
		count = dbcPro.getTripreViewCommentCount(t_num);
		
		String[] imgPath = null;
		TripreviewDBBean dbPro = TripreviewDBBean.getInstance();
		TripreviewDataBean tripreViewContent = dbPro.getContentForm(t_num);
		PhotoDBBean dbPhoto = PhotoDBBean.getInstance();
		if((tripreViewContent.getPhoto_id() != null)&(tripreViewContent.getPhoto_id() != ""))
			imgPath = dbPhoto.getImgNameAll(tripreViewContent.getPhoto_id());
		
		request.setAttribute("t_num", new Integer(t_num));
		request.setAttribute("commentId", commentId); // 코멘트작성자 아이디
		request.setAttribute("count", new Integer(count)); // 해당글 코멘트 전체 개수
		request.setAttribute("imgPath", imgPath); // 해당글 이미지패스 배열
		request.setAttribute("tripreViewContent", tripreViewContent); // 해당글 내용 객체
		request.setAttribute("tripreViewCommentList", tripreViewCommentList); // 해당글 전체 코멘트들 리스트로
				
		return "/NA/tripreView/contentForm.jsp";
	}
}