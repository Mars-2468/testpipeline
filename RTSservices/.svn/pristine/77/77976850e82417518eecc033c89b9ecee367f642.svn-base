package com.mars.rti.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mars.rti.dao.CollectionBufferDAO;
import com.mars.rti.model.CollectionBuffer;
import com.mars.rti.service.CollectionBufferService;


@Service("CollectionBufferService")
public class CollectionBufferServiceImpl implements CollectionBufferService {
	
	
	@Autowired
	private CollectionBufferDAO collectionBufferDAO;

	@Override
	public CollectionBuffer saveCollectionBuffer(CollectionBuffer collectionBuffer) {
		return collectionBufferDAO.saveCollectionBuffer(collectionBuffer);
		
		
	}

	

	@Override
	public CollectionBuffer getBufferPgData(String UniqPgid) {
		return collectionBufferDAO.getBufferPgData(UniqPgid);
		
	}
	@Override
	public CollectionBuffer getCollection(long id) {
		// TODO Auto-generated method stub
		return collectionBufferDAO.getCollection(id);	}



	@Override
	public CollectionBuffer saveCollectionbuffer(CollectionBuffer collectionBuffer,String tnxid) {
		return collectionBufferDAO.saveCollection(collectionBuffer,tnxid);
	}



	@Override
	public CollectionBuffer getCollections(String rtiApplicationId) {
		// TODO Auto-generated method stub
		return collectionBufferDAO.getCollections(rtiApplicationId);
	}



	@Override
	public void saveCollectionBufferList(
			List<CollectionBuffer> listcollectionbuffer) {
		// TODO Auto-generated method stub
		collectionBufferDAO.saveCollectionBufferList(listcollectionbuffer);
	}



	@Override
	public CollectionBuffer getCollectionId(Long i) {
		// TODO Auto-generated method stub
		return collectionBufferDAO.getCollectionId(i);
	}
	


}



