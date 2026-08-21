package com.mars.rti.dao;

import com.mars.rti.model.EasebuzzWebhook;

public interface EasebuzzWebhookDAO {

	public void saveWebhook(EasebuzzWebhook dto);

	public EasebuzzWebhook getEasebuzz(String id);
	
}
