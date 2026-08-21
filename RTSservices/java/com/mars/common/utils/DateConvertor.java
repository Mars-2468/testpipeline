/**
 * 
 */
package com.mars.common.utils;

import java.util.Collection;
import java.util.HashMap;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.PropertyUtils;

public class DateConvertor {

	private static DateConvertor convertor = null;
	private HashMap<String, String> hstClassFields = new HashMap<String, String>();

	private DateConvertor() {
		
		/* JBPM Model Classes */
		hstClassFields.put("EgovProcDefn","createDate,updateDate");
		
		/* Common Model Classes */		
		hstClassFields.put("UserRole","userRoleEndDate,userRoleStDate");
	
		/* Common Search Classes */	

		
		/* Common DWR Classes */
		
		/* Core Core Model Classes */
		
		/* Core Core Search Classes */

		/* Core Core DWR Classes */
		
		}

	public static DateConvertor getInstance() {
		if (convertor == null) {
			convertor = new DateConvertor();
		}
		return convertor;
	}

	public void converDateForUI(Object object) {
		try {
			if(object == null) return;
			
			String strClassName = object.getClass().getSimpleName();
			if(strClassName != null && strClassName.contains("$"))
			{
				strClassName = strClassName.substring(0,strClassName.indexOf("$"));
			}
			// Object of type List
			if(object instanceof Collection)
			{
				for (Object childObject : (Collection)object)
				{
					String strPackageName = childObject.getClass().getPackage().getName();
					if(strPackageName.endsWith(".model") || strPackageName.endsWith(".search") || strPackageName.endsWith(".dwr"))
					{
						if (hstClassFields.containsKey(strClassName)) {
							String strValues = hstClassFields.get(strClassName).toString();
							if (strValues != null) {
								String[] strFieldsArray = strValues.split(",");
								for (String strFieldName : strFieldsArray) {
									strFieldName = strFieldName.trim();
									try {
										String strValue = BeanUtils.getProperty(childObject, strFieldName);
										if(strValue != null)
										{
											strValue = strValue.replaceAll("-", "/");
											PropertyUtils.setProperty(childObject, strFieldName, strValue);
											//System.out.println("new values" + strValue);
										}
									} catch (Exception e) {
										// TODO Auto-generated catch block
										System.out.println(e.getMessage());
									}
								}
							}
						}
					}
				}
			}
			
			// Object of type Model
			else if (hstClassFields.containsKey(strClassName)) {
				String strValues = hstClassFields.get(strClassName).toString();
				if (strValues != null) {
					String[] strFieldsArray = strValues.split(",");
					for (String strFieldName : strFieldsArray) {
						strFieldName = strFieldName.trim();
						try {
							String strValue = BeanUtils.getProperty(object, strFieldName);
							if(strValue != null)
							{
								strValue = strValue.replaceAll("-", "/");
								PropertyUtils.setProperty(object, strFieldName, strValue);
								//System.out.println("new values" + strValue);
							}
						} catch (Exception e) {
							// TODO Auto-generated catch block
							System.out.println(e.getMessage());
						}
					}
				}
			}
		} catch (Exception exception) {
			System.out.println(exception.getMessage());
		}
	}

	public void converDateForDB(Object object) {
		try {
			if(object == null) return;
			
			String strClassName = object.getClass().getSimpleName();
			if (hstClassFields.containsKey(strClassName)) {
				String strValues = hstClassFields.get(strClassName).toString();
				if (strValues != null) {
					String[] strFieldsArray = strValues.split(",");
					for (String strFieldName : strFieldsArray) {
						strFieldName = strFieldName.trim();
						try {
							String strValue = BeanUtils.getProperty(object, strFieldName);
							if(strValue != null)
							{
								strValue = strValue.replaceAll("/", "-");
								PropertyUtils.setProperty(object, strFieldName, strValue);
								//System.out.println("new values" + strValue);
							}
						} catch (Exception e) {
							// TODO Auto-generated catch block
							System.out.println(e.getMessage());
						}
					}
				}
			}
		} catch (Exception exception) {
			System.out.println(exception.getMessage());
		}
	}


}
