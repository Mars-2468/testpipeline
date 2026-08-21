package com.mars.rti.service;

import org.springframework.transaction.annotation.Transactional;

import com.mars.rti.model.EasebuzzWebhook;

@Transactional(readOnly = true)
public interface EasebuzzWebhookService {

	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public void saveWebhook(EasebuzzWebhook dto);
	
	public EasebuzzWebhook getEasebuzz(String string);

}
