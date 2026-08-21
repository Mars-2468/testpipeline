package com.mars.rti.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mars.rti.dao.CollectionDAO;
import com.mars.rti.model.Collection;
import com.mars.rti.model.CollectionBuffer;
import com.mars.rti.search.RTIApplicationSearch;
import com.mars.rti.service.CollectionService;
@Service("CollectionrService")
public class CollectionServiceImpl implements CollectionService {
	
	@Autowired
	private CollectionDAO collectionDAO;

	@Override
	public Collection saveCollection(Collection collection) {
		return collectionDAO.saveCollection(collection);
				
	}

	@Override
	public Collection getCollection(long id) {
		// TODO Auto-generated method stub
		return collectionDAO.getCollection(id);
	}

	@Override
	public List<CollectionBuffer> getAllFailedCollections(String sqlQuery,long pageNumber,RTIApplicationSearch searchOptions) {
		// TODO Auto-generated method stub
		return collectionDAO.getAllFailedCollections(sqlQuery,pageNumber,searchOptions);
	}

	@Override
	public void updateAllFailedCollectionList(long collectionBufferId,
			String refNumber) {
		// TODO Auto-generated method stub
		collectionDAO.updateAllFailedCollectionList(collectionBufferId,refNumber);
		
	}

	@Override
	public void saveCollectionList(List<Collection> listcollection) {
		// TODO Auto-generated method stub
		collectionDAO.saveCollectionList(listcollection);
	}

	@Override
	public long getAllFailedCollectionsCount(String string,
			long longCurrentPage,RTIApplicationSearch searchOptions) {
		// TODO Auto-generated method stub
		return collectionDAO.getAllFailedCollectionsCount(string,longCurrentPage,searchOptions);
	}
	
	@Override
	public Collection getCollections(long id)
	{
		return collectionDAO.getCollections(id);
	}
	
}


