package com.mars.common.utils;

import javax.servlet.http.HttpServletRequest;

public abstract class CommonRequestUtils
{

    public static String getStringDateParameter(HttpServletRequest request, String name)
    {
	String paramval = request.getParameter(name);
	try
	{
	    if (paramval == null)
		return null;
	    else
	    {
		String val = paramval.trim();
		val.replaceAll("/", "-");
		return val;
	    }
	} catch (Exception e)
	{
	    return null;
	}
    }

    public static String getStringParameter(HttpServletRequest request, String name)
    {
	String paramval = request.getParameter(name);
	try
	{
	    if (paramval == null)
		return null;
	    else
		return paramval.trim();
	} catch (Exception e)
	{
	    return null;
	}
    }

    public static String[] getStringParameters(HttpServletRequest request, String name)
    {
	String paramvals[];
	try
	{
	    paramvals = request.getParameterValues(name);
	    return paramvals;
	} catch (Exception e)
	{
	    return new String[0];
	}
    }

    public static Double getDoubleParameter(HttpServletRequest request, String name)
    {
	String paramval = request.getParameter(name);
	try
	{
	    if (paramval == null)
		return 0.0;
	    else
		return Double.parseDouble(paramval.trim());
	} catch (Exception e)
	{
	    return 0.0;
	}
    }

    public static double[] getDoubleParameters(HttpServletRequest request, String name)
    {
	String paramvals[];
	double returnvals[];
	try
	{
	    paramvals = request.getParameterValues(name);
	    returnvals = new double[paramvals.length];
	    if (paramvals.length > 0)
	    {
		for (int i = 0; i < paramvals.length; i++)
		{
		    if (paramvals[i] == null || paramvals[i].trim().equalsIgnoreCase(""))
			returnvals[i] = 0.0;
		    else
			returnvals[i] = Double.parseDouble(paramvals[i].trim());
		}
	    }
	    return returnvals;
	} catch (Exception e)
	{
	    return new double[(int) 0.0];
	}
    }

    public static float getFloatParameter(HttpServletRequest request, String name)
    {
	String paramval = request.getParameter(name);
	try
	{
	    if (paramval == null)
		return (float) 0.0;
	    else
		return Float.parseFloat(paramval.trim());
	} catch (Exception e)
	{
	    return (float) 0.0;
	}
    }

    public static float[] getFloatParameters(HttpServletRequest request, String name)
    {
	String paramvals[];
	float returnvals[];
	try
	{
	    paramvals = request.getParameterValues(name);
	    returnvals = new float[paramvals.length];
	    if (paramvals.length > 0)
	    {
		for (int i = 0; i < paramvals.length; i++)
		{
		    if (paramvals[i] == null || paramvals[i].trim().equalsIgnoreCase(""))
			returnvals[i] = (float) 0.0;
		    else
			returnvals[i] = Float.parseFloat(paramvals[i].trim());
		}
	    }
	    return returnvals;
	} catch (Exception e)
	{
	    return new float[(int) 0.0];
	}
    }

    public static long getLongParameter(HttpServletRequest request, String name)
    {
	String paramval = request.getParameter(name);
	try
	{
	    if (paramval == null)
		return 0;
	    else
		return Long.parseLong(paramval.trim());
	} catch (Exception e)
	{
	    return 0;
	}
    }

    public static long[] getLongParameters(HttpServletRequest request, String name)
    {
	String paramvals[];
	long returnvals[];
	try
	{
	    paramvals = request.getParameterValues(name);
	    returnvals = new long[paramvals.length];
	    if (paramvals.length > 0)
	    {
		for (int i = 0; i < paramvals.length; i++)
		{
		    if (paramvals[i] == null || paramvals[i].trim().equalsIgnoreCase(""))
			returnvals[i] = 0;
		    else
			returnvals[i] = Long.parseLong(paramvals[i].trim());
		}
	    }
	    return returnvals;
	} catch (Exception e)
	{
	    return new long[0];
	}
    }

    public static int getIntParameter(HttpServletRequest request, String name)
    {
	String paramval = request.getParameter(name);
	try
	{
	    if (paramval == null)
		return 0;
	    else
		return Integer.parseInt(paramval.trim());
	} catch (Exception e)
	{
	    return 0;
	}
    }

    public static int[] getIntParameters(HttpServletRequest request, String name)
    {
	String paramvals[];
	int returnvals[];
	try
	{
	    paramvals = request.getParameterValues(name);
	    returnvals = new int[paramvals.length];
	    if (paramvals.length > 0)
	    {
		for (int i = 0; i < paramvals.length; i++)
		{
		    if (paramvals[i] == null || paramvals[i].trim().equalsIgnoreCase(""))
			returnvals[i] = 0;
		    else
			returnvals[i] = Integer.parseInt(paramvals[i].trim());
		}
	    }
	    return returnvals;
	} catch (Exception e)
	{
	    return new int[0];
	}
    }
}
