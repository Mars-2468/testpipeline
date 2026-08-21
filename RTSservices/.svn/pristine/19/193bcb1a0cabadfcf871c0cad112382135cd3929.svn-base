package com.mars.common.utils;

import java.util.Collection;
import java.util.Hashtable;
import java.util.List;

import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;

import com.mars.common.service.PermissionService;

public class ObjectDefinitionSourceImpl implements FilterInvocationSecurityMetadataSource
{

    private PermissionService permissionService;

    private Hashtable<String, String> hstRolesPermissions = null;

    public ObjectDefinitionSourceImpl()
    {
    }

    public void setPermissionService(PermissionService permissionService)
    {
	this.permissionService = permissionService;
	if (hstRolesPermissions == null)
	{
		permissionService.setDefaultSchema();
	    hstRolesPermissions = permissionService.getRolePermissions();
	}
    }

    private boolean isSecuredLink(String strLink)
    {
	if (strLink.endsWith(".gif") || strLink.endsWith(".jpg") || strLink.startsWith("/images/") || strLink.startsWith("/styles/") || strLink.startsWith("/scripts/") || strLink.startsWith("/dwr/")
		|| strLink.startsWith("/public/")|| strLink.startsWith("/ws/"))
	    return false;
	return true;
    }

    public void refresh()
    {
	hstRolesPermissions = permissionService.getRolePermissions();
    }

    public Collection<ConfigAttribute> getAllConfigAttributes()
    {
	return null;
    }

    public boolean supports(Class<?> arg0)
    {
	// TODO Auto-generated method stub
	return FilterInvocation.class.isAssignableFrom(arg0);
    }

    public Collection<ConfigAttribute> getAttributes(Object filter) throws IllegalArgumentException
    {
	FilterInvocation filterInvocation = (FilterInvocation) filter;
	String url = filterInvocation.getRequestUrl();

	int firstQuestionMarkIndex = url.indexOf("?");

	if (firstQuestionMarkIndex != -1)
	{
	    url = url.substring(0, firstQuestionMarkIndex);
	}

	if (isSecuredLink(url) && url.indexOf("/") != -1)
	{
	    String strArray[] = url.split("/");
	    if (strArray != null && strArray.length > 2)
	    {
		String strKey = "/" + strArray[1] + "/";
		if (hstRolesPermissions.containsKey(strKey))
		{
		    List<ConfigAttribute> listConfigAttibs = SecurityConfig.createListFromCommaDelimitedString(hstRolesPermissions.get(strKey).toString());
		    return listConfigAttibs;
		} else
		{
		    //List<ConfigAttribute> listConfigAttibs = SecurityConfig.createListFromCommaDelimitedString("ROLE_ADMIN");
		    //return listConfigAttibs;
		}
	    }
	}
	return null;
    }
}
