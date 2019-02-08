package action.chatting;

import java.util.ArrayList;

import javax.servlet.http.*;

import controller.CommandAction;
import chatting.*;

public class ChatAction implements CommandAction {
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable{
		
		ArrayList chatlist = new ArrayList();
		String id2 = request.getParameter("id2");
		int trade_num = Integer.parseInt(request.getParameter("trade_num"));
			
		ChatDBBean chatDB = ChatDBBean.getInstance();
		chatlist = chatDB.chatData(trade_num);
		
		request.setAttribute("chatlist", chatlist);
		request.setAttribute("trade_num", trade_num);

		return "/mj/chat/broadcast.jsp"; 
		
		
	}
}