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
		
		String commentId = request.getParameter("id"); //�ڸ�Ʈ �ۼ��ϴ� ��� id(���� �α����ѻ���� id)
		int t_num = Integer.parseInt(request.getParameter("t_num"));// �Խñ۹�ȣ
		String commentText = request.getParameter("commentText"); //�ڸ�Ʈ ����
				
		
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
		request.setAttribute("commentId", commentId); // �ڸ�Ʈ�ۼ��� ���̵�
		request.setAttribute("count", new Integer(count)); // �ش�� �ڸ�Ʈ ��ü ����
		request.setAttribute("imgPath", imgPath); // �ش�� �̹����н� �迭
		request.setAttribute("tripreViewContent", tripreViewContent); // �ش�� ���� ��ü
		request.setAttribute("tripreViewCommentList", tripreViewCommentList); // �ش�� ��ü �ڸ�Ʈ�� ����Ʈ��
				
		return "/NA/tripreView/contentForm.jsp";
	}
}