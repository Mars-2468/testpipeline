package com.mars.rti.ws.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mars.rti.model.Dogtype;
import com.mars.rti.service.DogtypeService;
import com.mars.rti.ws.model.DogMasterDataRestDTO;

@Controller
public class DogMasterDataRestController {
	@Autowired
	private DogtypeService dogtypeService;

	@RequestMapping(method = RequestMethod.GET, value = "/getDogtype/{dogtype}")
	public @ResponseBody DogMasterDataRestDTO getFeesMaster(
			@PathVariable String dogtype, HttpServletResponse reponse)
			throws ServletException {
		DogMasterDataRestDTO dogMasterDataRestDTO = new DogMasterDataRestDTO();
		
		List<Dogtype> dog = new ArrayList();
	
		dog = dogtypeService.getDogtype(dogtype);
		boolean checkdoogtype = false;
		try {
				if (dogtype.equals("Breed")) {
					dogMasterDataRestDTO.setDogtype(dogtype);
					dogMasterDataRestDTO.setBreedtype(dog);
					checkdoogtype = true;
				} else if (dogtype.equals("Indian")) {
					dogMasterDataRestDTO.setDogtype(dogtype);
					dogMasterDataRestDTO.setIndiantype(dogtypeService.getDogtypes(dogtype).getIndiantype());
					checkdoogtype = true;
				} else {
					checkdoogtype = false;
				}
				if (checkdoogtype == true) {
					dogMasterDataRestDTO.setResponse("Request successfully");
					dogMasterDataRestDTO.setResponseStatus("ok");
					dogMasterDataRestDTO.setResponseCode(200);
					dogMasterDataRestDTO.setStatus("Method Allowed");
				} else {
					dogMasterDataRestDTO.setResponse("Bad Request");
					dogMasterDataRestDTO
							.setResponseStatus("Enter Correct Dog Type");
				}
			
		} catch (Exception ex) {
			ex.printStackTrace();
			dogMasterDataRestDTO.setResponse("Bad Request");
			dogMasterDataRestDTO.setResponseStatus("Data fields are Empty");
			dogMasterDataRestDTO.setResponseCode(405);
			dogMasterDataRestDTO.setStatus("Method not Allowed");

		}

		return dogMasterDataRestDTO;
	}

}
