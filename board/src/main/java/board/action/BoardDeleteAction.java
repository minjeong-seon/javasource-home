package board.action;

import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;

import board.domain.BoardDTO;
import board.service.BoardDeleteService;
import board.service.BoardReadService;
import board.service.BoardUpdateService;

public class BoardDeleteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request) throws Exception {
		// post
		int bno = Integer.parseInt(request.getParameter("bno"));
		String password = request.getParameter("password");
		
		// 페이지 나누기 정보
		String criteria = request.getParameter("criteria"); 
		String keyword = URLEncoder.encode(request.getParameter("keyword"), "utf-8"); 
		String page = request.getParameter("page"); 
		String amount = request.getParameter("amount");		
		
		
		BoardDeleteService service = new BoardDeleteService();		
		String path = "";
		if(service.delete(bno,password)) {
			path = "list.do?criteria="+criteria+"&keyword="+keyword+"&page="+page+"&amount="+amount;
		}else {
			path = "modify.do?bno="+bno+"&criteria="+criteria+"&keyword="+keyword+"&page="+page+"&amount="+amount;
		}		
		
		return new ActionForward(true, path);
	}
}
