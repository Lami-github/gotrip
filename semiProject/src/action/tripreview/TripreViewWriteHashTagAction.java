package action.tripreview;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.CommandAction;
import tripreview.TripreviewDBBean;

public class TripreViewWriteHashTagAction implements CommandAction { 
	public String requestPro(HttpServletRequest request,
			HttpServletResponse response) throws Throwable {
		
		TripreviewDBBean dbPro = TripreviewDBBean.getInstance();
		
		String country = "나라";
		String season = "계절";
		String thema = "테마";
		
		List countryList;
		List seasonList;
		List themaList;
				
		countryList = dbPro.getHashTag(country);
		seasonList = dbPro.getHashTag(season);
		themaList = dbPro.getHashTag(thema);
		
		request.setAttribute("countryList", countryList);
		request.setAttribute("seasonList", seasonList);
		request.setAttribute("themaList", themaList);
		
		return "/NA/tripreView/writeHashtag.jsp";
	}
}