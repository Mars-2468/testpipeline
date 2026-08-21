package com.mars.rti.dao;

import java.util.List;

import com.mars.rti.model.NoDuesCertificate;
import com.mars.rti.search.RTIApplicationSearch;

public interface NoDuesCertificateDAO {

	public void save(NoDuesCertificate noDuesCertificate);

	public List<NoDuesCertificate> getList(
			RTIApplicationSearch rTIApplicationSearch);

	public long getRTIApplicationCount(RTIApplicationSearch searchOptions);

	public NoDuesCertificate get(long id);

	public NoDuesCertificate findFromRTIRefNum(String rtiapplrefno);
}
