package com.mars.rti.ws.controller;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.mars.rti.model.ProposedTapSize;
import com.mars.rti.service.ProposedTapSizeService;
import com.mars.rti.ws.model.ProposedTapSizeRestDTO;

@Controller
public class ProposedTapSizeRestController {
	
	@Autowired
	private ProposedTapSizeService  proposedTapSizeService;
	@RequestMapping(method = RequestMethod.GET, value ="/getPropertapsize")
	public @ResponseBody ProposedTapSizeRestDTO getPropertapsize(HttpServletResponse reponse) throws ServletException{
		ProposedTapSizeRestDTO proposedTapSizeRestDTO = new ProposedTapSizeRestDTO();
		List<ProposedTapSize> proposedTapSize = new ArrayList<ProposedTapSize>();
		proposedTapSize = proposedTapSizeService.getPropertapsize();
		
		proposedTapSizeRestDTO.setProposedTapSize(proposedTapSize);
		proposedTapSizeRestDTO.setResponse(200);
		proposedTapSizeRestDTO.setResponseStatus("ok");
		return proposedTapSizeRestDTO;
		
	}

}
