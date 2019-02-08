package chatting;

import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import chatting.*;

@ServerEndpoint("/broadcasting")
public class Broadsocket {

	private static Set<Session> clients = Collections.synchronizedSet(new HashSet<Session>());

	@OnMessage
	public void onMessage(String message, Session session) throws IOException, Exception {
		System.out.println(message);
		
		int trade_num = Integer.parseInt(message.substring(message.indexOf("|")+2,message.length()));
		String msg = message.substring(0,message.indexOf("|")-1);
		
		ChatDBBean chatDB = ChatDBBean.getInstance();
		chatDB.chatInsert(msg,trade_num);
		
		synchronized (clients) {
			// Iterate over the connected sessions
			// and broadcast the received message
			for (Session client : clients) {
				if (!client.equals(session)) {
					client.getBasicRemote().sendText(msg);
				}
			}
		}
	}

	@OnOpen
	public void onOpen(Session session) {
		// Add session to the connected sessions set
		System.out.println(session + "¿‘¿Â");
		clients.add(session);
	}

	@OnClose
	public void onClose(Session session) {
		// Remove session from the connected sessions set
		System.out.println(session + "≈¿Â");
		clients.remove(session);
	}
}