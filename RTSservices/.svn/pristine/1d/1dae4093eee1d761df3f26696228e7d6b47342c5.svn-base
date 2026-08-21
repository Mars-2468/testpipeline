package com.mars.common.utils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.event.MergeEvent;
import org.hibernate.event.def.DefaultMergeEventListener;

/**
 * Audit Log Listener is used to log insert, update, Complete list of
 * listeners/events.
 * 
 * @see org.hibernate.event.EventListeners
 */
public final class MergeHibernateListener extends DefaultMergeEventListener
{
    private static final long serialVersionUID = 1L;

    private static Log log = LogFactory.getLog(MergeHibernateListener.class);

    public void onMerge(MergeEvent event) throws HibernateException
    {
	try
	{
	    Object object = event.getOriginal();
	    if (object != null)
	    {
		String strPackageName = object.getClass().getPackage().getName();
		if (strPackageName.startsWith("com.egov") && (strPackageName.endsWith("model") || strPackageName.endsWith("search") || strPackageName.endsWith(".dwr")))
		{
		    event.setEntity(object);
		}
	    }
	} catch (Exception e)
	{
	    System.out.println(e.getMessage());
	    log.error("Unable to process audit log for Merge operation", e);
	}
	super.onMerge(event);
    }

}
