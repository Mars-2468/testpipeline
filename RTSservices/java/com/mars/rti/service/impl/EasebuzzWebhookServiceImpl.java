package com.mars.rti.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mars.rti.dao.EasebuzzWebhookDAO;
import com.mars.rti.model.EasebuzzWebhook;
import com.mars.rti.service.EasebuzzWebhookService;

@Service
public class EasebuzzWebhookServiceImpl implements EasebuzzWebhookService{

	@Autowired
	private EasebuzzWebhookDAO easebuzzWebhookDAO;
	
	@Override
	public void saveWebhook(EasebuzzWebhook dto) {
		easebuzzWebhookDAO.saveWebhook(dto);
	}

	@Override
	public EasebuzzWebhook getEasebuzz(String id) {
		// TODO Auto-generated method stub
		return easebuzzWebhookDAO.getEasebuzz(id);
	}

}
