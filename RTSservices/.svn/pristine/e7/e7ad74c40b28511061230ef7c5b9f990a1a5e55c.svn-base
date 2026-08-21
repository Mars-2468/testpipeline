package com.mars.rti.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.mars.rti.model.Collection;
import com.mars.rti.model.CollectionBuffer;
import com.mars.rti.search.RTIApplicationSearch;

public interface CollectionService {
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public Collection saveCollection(Collection collection);
	
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public Collection getCollection(long id);
	
	 public List<CollectionBuffer> getAllFailedCollections(String sqlQuery,long pageNumber,RTIApplicationSearch searchOptions);

		public void updateAllFailedCollectionList(long collectionBufferId,String refNumber);

		

		@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
		public void saveCollectionList(List<Collection> listcollection);

		public long getAllFailedCollectionsCount(
				String string, long longCurrentPage,RTIApplicationSearch searchOptions);


		public Collection getCollections(long id);

}
