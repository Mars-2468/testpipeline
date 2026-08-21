package com.mars.rti.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.mars.rti.model.CollectionBuffer;


@Transactional(readOnly = true)
public interface CollectionBufferService {
	
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public CollectionBuffer saveCollectionBuffer(CollectionBuffer collectionbuffer);
	
	
	
	public CollectionBuffer getBufferPgData(String UniqPgid);
	
	
	public CollectionBuffer getCollection(long id);


	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public CollectionBuffer saveCollectionbuffer(CollectionBuffer collectionBuffer, String tnxid);
	
	
	public CollectionBuffer getCollections(String string);
	
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public void saveCollectionBufferList(
			List<CollectionBuffer> listcollectionbuffer);



	public CollectionBuffer getCollectionId(Long colIds);


}
