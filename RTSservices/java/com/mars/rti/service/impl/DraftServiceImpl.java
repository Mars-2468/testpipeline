package com.mars.rti.service.impl;



import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import org.hibernate.type.NullableType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mars.common.model.DeliveryMode;
import com.mars.common.model.DeliveryModeFields;
import com.mars.common.service.RegNumGenarationService;
import com.mars.rti.model.Draft;
import com.mars.rti.model.DraftType;
import com.mars.rti.search.DraftSearch;
import com.mars.rti.utils.CoreConstants;
  
@Service("draftService") 
public class DraftServiceImpl implements com.mars.rti.service.DraftService{

 
	@Autowired
	com.mars.rti.dao.DraftDAO draftDao;
	
	@Autowired
    private RegNumGenarationService regNumGenarationService;
	
	public Draft get(long id){
		return draftDao.get(id);
	}
 
	@Transactional(readOnly = false, rollbackFor = java.lang.Exception.class)
	public void save(Draft entity) {
		setDraftNumber(entity);
		draftDao.save(entity);
	}
	private void setDraftNumber(Draft entity) {
		if(entity.getDraftId() <= 0){
			String regEntityName = CoreConstants.DRAFT_GENERATION_SCREEN	; 
			String preFix="DEPT_CODE/[DATE]/";
			String postFix = "";
			Boolean resetFlag=true;
			int year = Integer.parseInt(entity.getCreationDate().substring(6,10));
			String property="entityName";
			String regNum = regNumGenarationService.getRegistrationNumber(property, regEntityName,preFix,postFix,year);

			if(regNum != null ) {
				//Calendar cal=Calendar.getInstance();
			    //int year=cal.get(Calendar.YEAR);
				try{
					//if(entity.getRtiApplication().getApplicationDepartment().getCode()==null || entity.getRtiApplication().getApplicationDepartment().getCode().length()==0){
						regNum = regNum.replace("DEPT_CODE", entity.getRtiApplication().getApplicationDepartment().getName().substring(0,3));
					//}else{
						//regNum = regNum.replace("DEPT_CODE", entity.getRtiApplication().getApplicationDepartment().getCode());
					//}
					// regNum = regNum.replace("SEC_CODE", entity.getSection().getCode());
				     regNum = regNum.replace("[DATE]", entity.getCreationDate() .substring(0, 10).replace("/", ""));
				//regNum = regNum.replace("[WARD_CODE]", entity.getRegistrationUnit().getWard().getCode());
				 entity.setDraftNumber("DRFT/"+regNum);
				}catch (NullPointerException nullpointerexception) {	
					System.out.println(nullpointerexception);
					entity.setDraftNumber("");
					throw new NullPointerException();
				} 
				catch(Exception ex){
					System.out.println(ex);
					entity.setDraftNumber("");
					throw new RuntimeException(ex.getCause());
				}
			}
		}
	}
	
    public Draft merge(Draft entity){
    	return draftDao.merge(entity);
    }
 
    public void delete(long id) {
    	draftDao.delete(id);
    }
	
 
	public List<Draft> getAll(){
		return draftDao.getAll();
	}
 
    public void saveAll(List<Draft> listDraft){
    	draftDao.saveAll(listDraft);
    }
    
 
    public void deleteAll(List<Draft> listDraft){
    	draftDao.deleteAll(listDraft);
    }
    
   
	public List<Draft> getDraftList(long pageNumber,String orderBy, String sortBy){
		return draftDao.getDraftList(pageNumber, orderBy, sortBy);
	} 
 
	public List<Draft> getDraftListBySearch(DraftSearch draftSearch){
		return draftDao.getDraftListBySearch(draftSearch);
	}	
	 
	public long getDraftCount(){
		return draftDao.getDraftCount();
	}
	  
	public long getDraftCountBySearch(DraftSearch draftSearch){
		return draftDao.getDraftCountBySearch(draftSearch);
	}
 
    public List<Draft> findByProperty(String propertyName, Object value){
    	return draftDao.findByProperty(propertyName, value);
    }

	public Draft checkForDuplicates(Draft draft){
		return draftDao.checkForDuplicates(draft);
	}
	
	public List<Draft> getListByNamedQuery(String namedQuery, Hashtable<String, Object> hstKeyValues){
		return draftDao.getListByNamedQuery(namedQuery, hstKeyValues);
	}
 
	public List<Draft> getEntityListBySQLQuery(String strSql, Hashtable<String, NullableType> hstDataTypes){
		return draftDao.getEntityListBySQLQuery(strSql, hstDataTypes);
	}
 
	public List<ArrayList> getListBySQLQuery(String strSql, Hashtable<String, NullableType> hstDataTypes){
		return draftDao.getListBySQLQuery(strSql, hstDataTypes);
	}
 
	public List<DeliveryMode> getDraftModeList(){
		return draftDao.getDraftModeList();
	}
	
	public DeliveryMode getDraftMode(long id){
		return draftDao.getDraftMode(id);
	}
	
	public DeliveryModeFields getDraftModeFields(long id){
		return draftDao.getDraftModeFields(id);
	}
	
	public List<DraftType> getAllDraftType(){
		return draftDao.getAllDraftType();
	}
	
	public DraftType getDraftTypeById(long id){
		return draftDao.getDraftTypeById(id);
	}
}

