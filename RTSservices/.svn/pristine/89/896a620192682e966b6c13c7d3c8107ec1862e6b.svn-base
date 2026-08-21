package com.mars.common.utils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.event.SaveOrUpdateEvent;
import org.hibernate.event.def.DefaultSaveOrUpdateEventListener;

/**
 * Audit Log Listener is used to log insert, update, Complete list of
 * listeners/events.
 * 
 * @see org.hibernate.event.EventListeners
 */
public final class SaveOrUpdateHibernateListener extends DefaultSaveOrUpdateEventListener
{
    private static final long serialVersionUID = 1L;

    private static Log log = LogFactory.getLog(SaveOrUpdateHibernateListener.class);

    public void onSaveOrUpdate(SaveOrUpdateEvent event) throws HibernateException
    {
	try
	{
	    Object object = event.getObject();
	    if (object != null)
	    {
		String strPackageName = object.getClass().getPackage().getName();
		if (strPackageName.startsWith("com.egov") && (strPackageName.endsWith("model") || strPackageName.endsWith("search") || strPackageName.endsWith(".dwr")))
		{
		    event.setObject(object);
		}
	    }
	} catch (Exception e)
	{
	    System.out.println(e.getMessage());
	    log.error("Unable to process audit log for SaveOrUpdate operation", e);
	}
	super.onSaveOrUpdate(event);
    }

}
