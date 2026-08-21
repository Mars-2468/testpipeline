package com.mars.rti.dao;

import java.util.List;

import com.mars.rti.model.Collection;
import com.mars.rti.model.CollectionBuffer;
import com.mars.rti.search.RTIApplicationSearch;

public interface CollectionDAO {
	
	public Collection saveCollection(Collection collection);

	public Collection getCollection(long id);
	
	public List<CollectionBuffer> getAllFailedCollections(String sqlQuery,long pageNumber,RTIApplicationSearch searchOptions);

	public void updateAllFailedCollectionList(long collectionBufferId,
			String refNumber);

	public void saveCollectionList(List<Collection> listcollection);

	public long getAllFailedCollectionsCount(String string,
			long longCurrentPage,RTIApplicationSearch searchOptions);
	
	public Collection getCollections(long id);
}
