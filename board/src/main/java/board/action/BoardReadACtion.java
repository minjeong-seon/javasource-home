package board.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import board.domain.BoardDTO;
import board.domain.PageDTO;
import board.service.BoardReadService;

public class BoardReadACtion implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request) throws Exception {
		// get 
		int bno = Integer.parseInt(request.getParameter("bno"));
		// 페이지 나누기 정보
		String criteria = request.getParameter("criteria"); 
		String keyword = request.getParameter("keyword"); 
		int page = Integer.parseInt(request.getParameter("page")); 
		int amount = Integer.parseInt(request.getParameter("amount")); 
		PageDTO pageDto = new PageDTO(criteria, keyword, page, amount);
		
		// service
		BoardReadService service = new BoardReadService();
		BoardDTO dto = service.read(bno);
		
		request.setAttribute("dto", dto);
		request.setAttribute("pageDto", pageDto);
		// readForm.jsp
		return new ActionForward(false, "readform.jsp");
	}

}
