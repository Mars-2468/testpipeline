package com.mars.common.utils;

import java.io.File;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringEscapeUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Filter;
import org.hibernate.Session;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.mars.rti.model.RTIApplication;
import com.mars.rti.utils.CoreConstants;

/**

 * <p>Title: CommonUtils.java </p>

 * <p>Description: This class is a common utility functions</p>

 * Copyright (c) 2014 for Mars Telecom Systems Pvt Ltd

 * @version: 1.0

 * @author : Mars Telecom Systems

 */
public class CommonUtils
{

    /** The log. */
    private static Log log = LogFactory.getLog(CommonUtils.class);


    public static List getReportsCategory()
    {
		List<String> listReportCategory = new ArrayList<String>();

		listReportCategory.add("RBD");

		return listReportCategory;
    }

    public static List getReportDataTypes()
    {
	List<String> listDataTypeCategory = new ArrayList<String>();
	listDataTypeCategory.add("Date");
	listDataTypeCategory.add("Double");
	listDataTypeCategory.add("Float");
	listDataTypeCategory.add("Integer");
	listDataTypeCategory.add("Long");
	listDataTypeCategory.add("String");

	return listDataTypeCategory;
    }

    public static List getInternalEntityNames()
    {
	List<String> listEntityNames = new ArrayList<String>();

	listEntityNames.add("Month");
	listEntityNames.add("NodeMaster");
	listEntityNames.add("Ward");
	listEntityNames.add("Sector");
	listEntityNames.add("FinancialYear");
	listEntityNames.add("CollectionCenter");
	listEntityNames.add("Stage");
	listEntityNames.add("PlotType");
	listEntityNames.add("Plot");
    listEntityNames.add("Hidden");
    listEntityNames.add("AUDIT_ENTITY_NAME");
    listEntityNames.add("AUDIT_PROPERTY_NAME");

	listEntityNames.add("RBD_CHART_TYPE");
	listEntityNames.add("RBD_BIRTHS_CHART_TYPE");
	listEntityNames.add("RBD_DEATHS_CHART_TYPE");
	listEntityNames.add("RBD_STILLBIRTHS_CHART_TYPE");
	listEntityNames.add("RBD_YEAR");
	listEntityNames.add("RBD_QUARTER");


	return listEntityNames;
    }


    /* This method is used in Reports*/
    @SuppressWarnings("unchecked")
    public static List<String[]> getReportMonths()
    {
	List<String[]> alstrMonths = new ArrayList<String[]>();

	alstrMonths.add(new String[] { "1", "January" });
	alstrMonths.add(new String[] { "2", "February" });
	alstrMonths.add(new String[] { "3", "March" });
	alstrMonths.add(new String[] { "4", "April" });
	alstrMonths.add(new String[] { "5", "May" });
	alstrMonths.add(new String[] { "6", "June" });
	alstrMonths.add(new String[] { "7", "July" });
	alstrMonths.add(new String[] { "8", "August" });
	alstrMonths.add(new String[] { "9", "September" });
	alstrMonths.add(new String[] { "10", "October" });
	alstrMonths.add(new String[] { "11", "November" });
	alstrMonths.add(new String[] { "12", "December" });

	return alstrMonths;
    }


    /**
     * This is a static method used for comparing the 2 sets and returns the
     * difference as another set.
     *
     * @param srcCollection as Collection object
     * @param destCollection the dest collection
     * @param MethodName the method name
     *
     * @return collection Collection object.
     */
    @SuppressWarnings("unchecked")
    public static Collection compareSets(Collection srcCollection, Collection destCollection, String MethodName)
    {
	if (log.isDebugEnabled())
	{
	    log.debug("compareSets method is called ");
	}
	// Declaring a new collectin object
	Collection collection = new HashSet();

	// cheking if destCollectin is not null and size >0
	if (destCollection != null && destCollection.size() > 0)
	{
	    srcCollection = new HashSet(srcCollection);
	    destCollection = new HashSet(destCollection);
	    Iterator iterator = srcCollection.iterator();
	    try
	    {
		while (iterator.hasNext())
		{
		    Object objSrc = iterator.next();
		    Iterator iterator4Dest = destCollection.iterator();
		    String strSrcValue = "'" + objSrc.getClass().getMethod(MethodName, null).invoke(objSrc, null) + "'";
		    while (iterator4Dest.hasNext())
		    {
			Object objDest = iterator4Dest.next();
			String strDestValue = "'" + objDest.getClass().getMethod(MethodName, null).invoke(objDest, null) + "'";

			if (strSrcValue.equals(strDestValue))
			{
			    log.debug("Object Matched and will be removed");
			    collection.add(objSrc);
			}
		    }
		}
	    } catch (Exception exception)
	    {
		log.error(exception.getMessage());
		exception.printStackTrace();
	    }
	    srcCollection.removeAll(collection);

	    return srcCollection;
	}
	return srcCollection;
    }

    /**
     * Gets the max page.
     *
     * @param longCount the long count
     *
     * @return the max page
     */
    public static long getMaxPage(long longCount)
    {
	long longMaxPage = -1;
	if (longCount > 0)
	{
	    if ((longCount % Constants.DEFAULT_ROWS_PER_PAGE) == 0)
	    {
		longMaxPage = (longCount / Constants.DEFAULT_ROWS_PER_PAGE);
	    } else
	    {
		longMaxPage = (longCount / Constants.DEFAULT_ROWS_PER_PAGE) + 1;
	    }
	}
	return longMaxPage;
    }

    /**
     * Check pagination attributes.
     *
     * @param request the request
     *
     * @return the long
     */
    public static long checkPaginationAttributes(HttpServletRequest request)
    {
	// Pagination related code.
	long longCurrentPage = 1;
	String strPaginationClicked = Constants.STATUS_NO_LABEL;

	if (request.getParameter("isPaginationClicked") != null && request.getParameter("isPaginationClicked").length() > 0)
	{
	    strPaginationClicked = request.getParameter("isPaginationClicked");
	}

	if (request.getParameter("currentPage") != null && request.getParameter("currentPage").length() > 0 && strPaginationClicked.equalsIgnoreCase(Constants.STATUS_YES_LABEL))
	{
	    longCurrentPage = Long.parseLong(request.getParameter("currentPage").toString());
	}// end

	if (request.getParameter("isPaginationClicked") != null && request.getParameter("isPaginationClicked").length() > 0)
	{
	    strPaginationClicked = request.getParameter("isPaginationClicked");
	}

	if (request.getParameter("currentPage") != null && request.getParameter("currentPage").length() > 0 && strPaginationClicked.equalsIgnoreCase(Constants.STATUS_YES_LABEL))
	{
	    longCurrentPage = Long.parseLong(request.getParameter("currentPage").toString());
	}// end
	return longCurrentPage;
    }

    /**
     * This is a static method to get request parameter.
     *
     * @param request the request
     * @param strParameter the str parameter
     *
     * @return Inward Number as String
     */
    public static String getParameterFromRequest(HttpServletRequest request, String strParameter)
    {
	String strValue = request.getParameter(strParameter);
	if (strValue == null || strValue.length() == 0)
	{
	    if (request.getAttribute(strParameter) != null)
	    {
		strValue = request.getAttribute(strParameter).toString();
	    }
	}
	return strValue;
    }

    /**
     * This is a static method used to escape characters.
     *
     * @param strSearchString as String
     *
     * @return strSearcgString as String
     */
    public static String getEscapedSQLString(String strSearchString)
    {
	if (log.isDebugEnabled())
	{
	    log.debug("getEscapedString method is called ");
	}
	if (strSearchString != null && strSearchString.length() > 0)
	{
	    strSearchString = StringEscapeUtils.escapeSql(strSearchString);
	}
	return strSearchString;
    }

    /**
     * Returns Date object formatted for current system date
     *
     * @return
     */
    public static Date getCurrentFormattedDate()
    {

		String dateStr = getCurrentStringDate();
		return CommonUtils.getFormattedDate(dateStr);
    }

    /**
     * Returns String object of current date formatted
     *
     * @return
     */
    public static String getCurrentStringDate()
    {

	DateFormat dateFormat = new SimpleDateFormat(Constants.DATE_DB_FORMAT);
	Date date = new Date();
	return dateFormat.format(date);
    }
    /**
     *
     * This is a static method to get the date object for a give string
     *
     *
     *
     * @param strDate
     *
     *          as String
     *
     *
     *
     * @return date as formated date.
     */

    public static Date getFormattedDate(String strDate)
    {

		if (log.isDebugEnabled())
		{
		    log.debug("getFormattedDate method is called ");
		}
		Date date = null;
		try
		{
		    if (strDate != null && strDate.length() > 0)
		    {
			DateFormat dateFormat = new SimpleDateFormat(Constants.DATE_FORMAT);
			date = dateFormat.parse(strDate);
		    }
		} catch (Exception Exception)
		{
			 try {
				if (strDate != null && strDate.length() > 0)
				{
					DateFormat dateFormat = new SimpleDateFormat(Constants.DATE_UI_FORMAT);
					date = dateFormat.parse(strDate);
				 }
			} catch (ParseException e) {
			    log.error(Exception.getStackTrace());
			    throw new RuntimeException(Exception.getCause());
			}
		}
		return date;
    }

    public static String getFormattedStringFromDate(Date date)
    {
	if (log.isDebugEnabled())
	{
	    log.debug("getFormattedDate method is called ");
	}
	try
	{
	    if (date != null)
	    {
		DateFormat dateFormat = new SimpleDateFormat(Constants.DATE_FORMAT);
		return dateFormat.format(date);
	    }
	} catch (Exception Exception)
	{
	    log.error(Exception.getStackTrace());
	    throw new RuntimeException(Exception.getCause());
	}
	return "";
    }

    /**
     * Returns String object of current date formatted as "dd/mm/yyyy"
     *
     * @return
     */
    public static String getCurrentStringUIDate()
    {

    DateFormat dateFormat = new SimpleDateFormat(Constants.DATE_UI_FORMAT);
    Date date = new Date();
    return dateFormat.format(date);
    }

    /**
     * This is a static method to get the FinancialYearStartDate
     *
     * @return
     */
    public static String getFinancialYearStartDate()
    {

	Date date = new Date();
	Calendar calendar = Calendar.getInstance();
	calendar.setTime(date);
	int currentYear = calendar.get(Calendar.YEAR);
	int month = calendar.get(Calendar.MONTH);

	int previousYear = currentYear - 1;

	if (month >= 3)
	    return  "01/04/" + currentYear;
	else
	    return  "01/04/" + previousYear;
    }

    public static boolean deleteFileFromSystem(String baseDir, String filePath, String fileName) throws Exception {
		String fullPath = "";
		// Delete file form The given Path
		if (baseDir != null && baseDir.length() > 0)
			fullPath = fullPath + baseDir + "/";

		if (filePath != null && filePath.length() > 0)
			fullPath = fullPath + filePath + "/";

		if (fileName != null && fileName.length() > 0)
			fullPath = fullPath + fileName;

		boolean success = true;
		File file = new File(fullPath);
		if (file.exists())
			success = file.delete();
		else
			// If file does not exist then we can say that this operation is
			// success
			success = true;
		return success;
	}

	 // Used in Demand Notice Reports
	public static List<String[]> getInputTypes()
    {
		ArrayList alstrMonths = new ArrayList();
		alstrMonths.add(Constants.INPUT_TYPE_DATE, Constants.INPUT_TYPE_DATE_LABEL);
		alstrMonths.add(Constants.INPUT_TYPE_TEXTBOX, Constants.INPUT_TYPE_TEXTBOX_LABEL);
		alstrMonths.add(Constants.INPUT_TYPE_TEXTAREA, Constants.INPUT_TYPE_TEXTAREA_LABEL);
		return alstrMonths;
    }

	public static long getDays(String strDate1,String strDate2){
		Date date1 = getFormattedDate(strDate1);
		Date date2 = getFormattedDate(strDate2);
		Date fromDate;
		Date toDate;
		if(date1.after(date2)){
			fromDate=date1;
			toDate=date2;
		}
		else{
			fromDate=date2;
			toDate=date1;
		}

		long days = (fromDate.getTime() - toDate.getTime())/86400000;
		return days;
	}
	
	

	public static long getNumberOfDays(String strDate1,String strDate2){
		Date date1 = getFormattedDate(strDate1);
		Date date2 = getFormattedDate(strDate2);
		
		Date fromDate;
		Date toDate;
		if(date1.after(date2)){
			fromDate=date1;
			toDate=date2;
		}
		else{
			fromDate=date2;
			toDate=date1;
		}

		long days = (fromDate.getTime() - toDate.getTime())/86400000;
		return days+1;
	}
	
	public static boolean checkPermission(HttpServletRequest request, String url){
		
		HttpSession session = request.getSession();
		Hashtable hstRolesPermissions = (Hashtable) session.getAttribute("rolesPermissions");
    	if(hstRolesPermissions.containsKey(url))
     	   return  true;
    	
    	return false;
	}
	
	public static List<String[]> getProductStatus() {

		List<String[]> alstrStatus = new ArrayList<String[]>();

		alstrStatus.add(new String[] { "0", "InActive" });
		alstrStatus.add(new String[] { "1", "Active" });

		return alstrStatus;
	}
	
	public static HttpSession getHttpSession(){
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		HttpSession httpSession= request.getSession();
		return httpSession;
		
		
		
	}
	
	public static void setFilter(Session session){
		/*HttpSession httpSession= getHttpSession();
		Filter filter = session.enableFilter("tenancyFilter");	
		filter.setParameter("tenancyId", httpSession.getAttribute("loginTenencyId"));*/
		
		HttpSession httpSession= getHttpSession();
		Object loginTenencyId = httpSession.getAttribute("loginTenencyId");
		
		if(loginTenencyId != null){
			int tenancyId = (Integer)loginTenencyId;
			if(tenancyId != 0){
				Filter filter = session.enableFilter("tenancyFilter");				
				//filter.setParameter("tenancyId",httpSession.getAttribute("loginTenencyId"));
				filter.setParameter("tenancyId",tenancyId);				
			}
		}

	}
	
	public static void setFilter(Session session, int tenancyId){
		
				Filter filter = session.enableFilter("tenancyFilter");				
				//filter.setParameter("tenancyId",httpSession.getAttribute("loginTenencyId"));
				filter.setParameter("tenancyId",tenancyId);		
		

	}
	
	public static int getTenancyId(){
		HttpSession httpSession= getHttpSession();
		int tenancyId=(Integer)httpSession.getAttribute("loginTenencyId");
		return tenancyId;
		
	}
	
	
	public static String AmtToWords(Double amt)
	{	String retString ="";
		String amtString = "";		
	 	NumberFormat myFormat = new DecimalFormat("#0.00");
	 	amtString = myFormat.format(amt);
	 	String[] vals  = amtString.replace(".",":").split(":");
	 	
	 	if(vals.length == 2)
	 	{	if(Long.valueOf(vals[0])== 1)
	 		{	retString =  "ONE RUPEE";
	 		}
	 		else
	 		{	retString = convert(Long.valueOf(vals[0]));
		 		retString = retString + " RUPEES";
	 		}
		 	if(Long.valueOf(vals[1])>0)
		 	{
		 		retString = retString + " AND " + convert(Long.valueOf(vals[1]));
		 		retString = retString + " PAISE";
		 	}
			return retString + " ONLY";
	 	}
	 	else
	 	{
	 		return "*ERROR*";
	 	}
		
	}
	
	public static String convert(long number) {
	    // 0 to 9 999 999 999
	    if (number == 0) { return "ZERO"; }
	    if (number > Long.valueOf("9999999999") ) {return "* NIL *" ;}
	    String snumber = Long.toString(number);

	    // pad with "0"
	    String mask = "0000000000";
	    DecimalFormat df = new DecimalFormat(mask);
	    snumber = df.format(number);

	    // XXXnnnnnnn 
	    int crore = Integer.parseInt(snumber.substring(0,3));
	    // nnnXXnnnnn
	    int lacs  = Integer.parseInt(snumber.substring(3,5)); 
	    // nnnnnXXnnn
	    int thousand = Integer.parseInt(snumber.substring(5,7)); 
	    // nnnnnnnXXX
	    int hundreds = Integer.parseInt(snumber.substring(7,10));    

	    String sCrore;
	    switch (crore) {
	    case 0:
	    	sCrore = "";
	      break;
	    case 1 :
	    	sCrore = " ONE CRORE";
	      break;
	    default :
	    	sCrore = convertLessThanOneThousand(crore) 
	      + " CRORES";
	    }
	    String result =  sCrore;

	    String sLacs;
	    switch (lacs) {
	    case 0:
	    	sLacs = "";
	      break;
	    case 1 :
	    	sLacs = " ONE LAC";
	      break;
	    default :
	    	sLacs = convertLessThanOneThousand(lacs) 
	      + " LACS";
	    }
	    result =  result + sLacs;

	    String sThousands;
	    switch (thousand) {
	    case 0:
	    	sThousands = "";
	      break;
	    case 1 :
	    	sThousands = " ONE THOUSAND";
	      break;
	    default :
	    	sThousands = convertLessThanOneThousand(thousand) 
	      + " THOUSANDS";
	    }
	    result =  result + sThousands;

	    String shundreds;
	    shundreds = convertLessThanOneThousand(hundreds);
	    result =  result + shundreds;

	    // remove extra spaces!
	    return result.replaceAll("^\\s+", "").replaceAll("\\b\\s{2,}\\b", " ");
	  }
	private static String convertLessThanOneThousand(int number) {
	    String soFar;

	    
	    if (number % 100 < 20){
	      soFar = numNames[number % 100];
	      number /= 100;
	    }
	    else {
	      soFar = numNames[number % 10];
	      number /= 10;

	      soFar = tensNames[number % 10] + soFar;
	      number /= 10;
	    }
	    if (number == 0) return soFar;
	    return numNames[number] + " HUNDRED" + soFar;
	  }
	private static final String[] tensNames = {
	    "",
	    " TEN",
	    " TWENTY",
	    " THIRTY",
	    " FORTY",
	    " FIFTY",
	    " SIXTY",
	    " SEVENTY",
	    " EIGHTY",
	    " NINETY"
	  };
	
	private static final String[] numNames = {
	    "",
	    " ONE",
	    " TWO",
	    " THREE",
	    " FOUR",
	    " FIVE",
	    " SIX",
	    " SEVEN",
	    " EIGHT",
	    " NINE",
	    " TEN",
	    " ELEVEN",
	    " TWELVE",
	    " THIRTEEN",
	    " FOURTEEN",
	    " FIFTEEN",
	    " SIXTEEN",
	    " SEVENTEEN",
	    " EIGHTEEN",
	    " NINETEEN"
	  };
	public static String decodeString(String encodedString){
		String decodedString = "";
		if(encodedString != null){			
			decodedString = StringEscapeUtils.unescapeHtml(encodedString);		      
		}
		return decodedString;
	}
	public static long totalCount(List list){
		long totalCount = 0;
		if(list!=null && list.size()>0){			
			totalCount = list.size();	      
		}
		return totalCount;
	}
	
	public static String randomString(  ){
		String randomChars=Constants.AB;
		int len=Constants.RANDOM_STRING_LENGTH;
		SecureRandom rnd = new SecureRandom();
	   StringBuilder sb = new StringBuilder( len );
	   for( int i = 0; i < len; i++ ) 
	      sb.append( randomChars.charAt( rnd.nextInt(randomChars.length()) ) );
	   return sb.toString();
	}
	
	public static String getSendRedirectUrlPath(HttpServletRequest request){
		  String urlPath = request.getRequestURL().toString();
		  urlPath = urlPath.substring(0,urlPath.indexOf(request.getRequestURI()))+request.getContextPath();
			return urlPath;
	  }
	public static Long[] convertStringIds2Long(String value){
		if(value!=null && value!=""){
		String[] items=value.split(",");
		int j=0;
		for (int i=0;i<items.length;i++) {
			if(items[i].trim().isEmpty())
				j++;
		}
		Long[] itemlngs=new Long[items.length-j];
		for (int i=0;i<items.length;i++) {
			if(!items[i].trim().isEmpty())
			itemlngs[i]=Long.parseLong(items[i].trim());	
		}
		
		return itemlngs ;}
		else
			return null;
	}
	public static boolean numericValidation(String arg){
    	String regexFormat=Constants.INTEGER_REGEX;
    	Boolean b=true;
    	if(arg!=null && arg.length()>0){
    		if(arg.matches(regexFormat))
    			b=false;
    	}
		return b;
    	
    }
	
	public static List<String[]> getPaymentTypes() {

		List<String[]> paymentStatus = new ArrayList<String[]>();

		/*paymentStatus.add(new String[] { "Emitra", "Emitra" });*/
		/*paymentStatus.add(new String[] { "Axis Bank", "Axis Bank" });*/
		paymentStatus.add(new String[] { "PayU", "PayU" });
		paymentStatus.add(new String[] { "PayU Test", "PayU Test" });

		return paymentStatus;
	}
	public static String getRandomNum(){
	    long seed = System.currentTimeMillis(); 
        Random r = new Random();
        r.setSeed(seed);
        String randomNum=  Long.toString(Math.abs(r.hashCode()));
        return randomNum;
	    }
	
	public static String getHashCode(String type,String str)throws Exception { 
		
		byte[] hashseq=str.getBytes();
		StringBuffer hexString = new StringBuffer();
		try{
		MessageDigest algorithm = MessageDigest.getInstance(type);
		algorithm.reset();
		algorithm.update(hashseq);
		byte messageDigest[] = algorithm.digest();
            
		
		for (int i=0;i<messageDigest.length;i++) {
			String hex=Integer.toHexString(0xFF & messageDigest[i]);
			if(hex.length()==1) 
				hexString.append("0");
			hexString.append(hex);
		}
			
		}catch(NoSuchAlgorithmException nsae){ }
		
		return hexString.toString();
	}
	
	public static String getCurrentStringDateAndTime()
	{	
		DateFormat dateFormat = new SimpleDateFormat(Constants.DATE_TIME_DB_FORMAT);
		Date date = new Date();
		return dateFormat.format(date);
	}
	
	 public static String getNursingHomeCurrentStringDateAndTime() {
	        DateFormat dateFormat = new SimpleDateFormat(Constants.DATE_TIME_DB_FORMAT);
	        
	        Calendar calendar = Calendar.getInstance();
	        calendar.add(Calendar.YEAR, 3);
	        calendar.set(Calendar.MONTH, Calendar.MARCH);
	        calendar.set(Calendar.DATE, 31);
	        
	        Date date = calendar.getTime();
	        return dateFormat.format(date);
	 }
	
	public static String getCurrentMonthFirstDate()
    {
		String dateStr = getCurrentStringDate();
		dateStr = "01"+dateStr.substring(2);	
		return dateStr;
    }		
	
	public static List<String> getApplicationStatusList()
	{
		ArrayList<String> statusList = new ArrayList<String>();
		statusList.add("All");
		statusList.add(CoreConstants.APPL_STATUS_NEW);
		statusList.add(CoreConstants.APPL_STATUS_CREATE);
		statusList.add(CoreConstants.APPL_STATUS_VERIFICATION);
		statusList.add(CoreConstants.APPL_STATUS_APPROVED);
		statusList.add(CoreConstants.APPL_STATUS_CLOSED); 
		statusList.add(CoreConstants.APPL_STATUS_REJECTED);
		statusList.add(CoreConstants.APPL_STATUS_PARKED);

		return statusList;
	} 
	
	public static List<String> getPaymentModes()
    {
		ArrayList<String> paymentModeLists = new ArrayList<String>();	
		paymentModeLists.add(CoreConstants.CASH_LABEL);
		paymentModeLists.add(CoreConstants.DEMAND_DRAFT_LABEL);	
		paymentModeLists.add(CoreConstants.CHALLAN_LABEL);		
		paymentModeLists.add(CoreConstants.CHEQUE_LABEL);		
		paymentModeLists.add(CoreConstants.RTGS_LABEL);	
			
		
		return paymentModeLists;
    }

	//for upload
	
	public static void setUploadDocsOnEditMode(HttpServletRequest request,ServletContext servletContext,String applicationType,RTIApplication rtiapplication){
		   
		   String appNum = String.valueOf(rtiapplication.getRtiApplicationId());
		   String mainDir = null;
		   ServletContext context = servletContext;
		   String downloadPath = rtiapplication.getPdfUploadFromPortal();
		   List<String> paths = null;
		   int count=0;
		   if(downloadPath!=null){
			   String[] pathArr = downloadPath.split(",");
			   
			   for (String httppath : pathArr) {
				   if(count==0)
					   paths = new ArrayList<>(); 
				   paths.add(httppath);
				   count++;
			}
			   
		   }
		   request.setAttribute("downloadCount",count);
		   request.setAttribute("downloadPath",paths);
		   
		   if(appNum!=null && !appNum.equals("0")){
		    
		    //	if(applicationType.equals("BirthRegistration"))
		    		
		    		mainDir = servletContext.getRealPath("") +"/Upload/"+appNum+"/";
				if(applicationType.equals("DEBRIESPERMISSION"))
					mainDir = servletContext.getRealPath("") +"/DebriesPermissionUploads/"+appNum+"/";
				if(applicationType.equals("COMMUNITYCENTER"))
					mainDir = servletContext.getRealPath("") +"/CommunitycenterUploads/"+appNum+"/";
				if(applicationType.equals("FESTIVALPANDAL"))
					mainDir = servletContext.getRealPath("") +"/FestivalpandalUploads/"+appNum+"/";
				if(applicationType.equals("ROADDIGGING"))
					mainDir = servletContext.getRealPath("") +"/RoaddiggingUploads/"+appNum+"/";
				if(applicationType.equals("STALLFORDIWALI"))
					mainDir = servletContext.getRealPath("") +"/StallfordiwaliUploads/"+appNum+"/";
				if(applicationType.equals("STAGEPANDALINGROUND"))
					mainDir = servletContext.getRealPath("") +"/stagepandalingroundUploads/"+appNum+"/";
				if(applicationType.equals("SUCTIONPERMISSION"))
					mainDir = servletContext.getRealPath("") +"/suctionjettinguploads/"+appNum+"/";
				

			File idProofDir = new File(mainDir+"Upload");
			  if (idProofDir.exists()) {
				File[] idProofNameFiles = idProofDir.listFiles();
				if(idProofNameFiles.length>0){
					 request.setAttribute("idProofRequired",false);
					String[] idProofName = new String[10];
					int i=0;
					for (File file : idProofNameFiles) {
					    if (file.isFile()) {
					    	idProofName[i] = file.getName();
					        System.out.println(file.getName());
					        i++;
					    }
					}
					request.setAttribute("idProofName",idProofName);
				  }else{
					  request.setAttribute("idProofRequired",true);
			     	}
			   }else{
		     		request.setAttribute("idProofRequired",true);
		     	}
			  
			  File inspectionReportoneDir = new File(mainDir+"inspectionReportone");
			  if (inspectionReportoneDir.exists()) {
				File[] inspectionReportoneDirNameFiles = inspectionReportoneDir.listFiles();
				if(inspectionReportoneDirNameFiles.length>0){
					 request.setAttribute("inspectionReportoneRequired",false);
					String[] inspectionReportoneName = new String[10];
					int i=0;
					for (File file : inspectionReportoneDirNameFiles) {
					    if (file.isFile()) {
					    	inspectionReportoneName[i] = file.getName();
					        System.out.println(file.getName());
					        i++;
					    }
					}
					request.setAttribute("inspectionreport1",inspectionReportoneName);
				  }else{
					  request.setAttribute("inspectionReportoneRequired",true);
			     	}
			   }else{
		     		request.setAttribute("inspectionReportoneRequired",true);
		     	}
			  
			  File inspectionReporttwoDir = new File(mainDir+"inspectionReporttwo");
			  if (inspectionReporttwoDir.exists()) {
				File[] inspectionReporttwoDirNameFiles = inspectionReporttwoDir.listFiles();
				if(inspectionReporttwoDirNameFiles.length>0){
					 request.setAttribute("inspectionReporttwoRequired",false);
					String[] inspectionReporttwoName = new String[10];
					int i=0;
					for (File file : inspectionReporttwoDirNameFiles) {
					    if (file.isFile()) {
					    	inspectionReporttwoName[i] = file.getName();
					        System.out.println(file.getName());
					        i++;
					    }
					}
					request.setAttribute("inspectionreport2",inspectionReporttwoName);
				  }else{
					  request.setAttribute("inspectionReporttwoRequired",true);
			     	}
			   }else{
		     		request.setAttribute("inspectionReporttwoRequired",true);
		     	}
			  
			    File residProofDir = new File(mainDir+"dogPhoto");
			    if (residProofDir.exists()) {
				File[] residProofNameFiles = residProofDir.listFiles();
				if(residProofNameFiles.length>0){
					 request.setAttribute("residProofRequired",false);
				    String[] residProofName = new String[10];
					int j=0;
					for (File file : residProofNameFiles) {
					    if (file.isFile()) {
					    	residProofName[j] = file.getName();
					        System.out.println(file.getName());
					        j++;
					    }
					}
					request.setAttribute("residProofName",residProofName);
			     	}else{
			     		request.setAttribute("residProofRequired",true);
			     	}
		         }else{
			     		request.setAttribute("residProofRequired",true);
			     	}

			    File mapofplaceDir = new File(mainDir+"mapofplace");
			    if (mapofplaceDir.exists()) {
				File[] mapofplaceNameFiles = mapofplaceDir.listFiles();
				if(mapofplaceNameFiles.length>0){
					 request.setAttribute("mapofplaceRequired",false);
				    String[] mapofplaceName = new String[10];
					int k=0;
					for (File file : mapofplaceNameFiles) {
					    if (file.isFile()) {
					    	mapofplaceName[k] = file.getName();
					        System.out.println(file.getName());
					        k++;
					    }
					}
					request.setAttribute("mapofplaceName",mapofplaceName);
			     	}else{
			     		request.setAttribute("mapofplaceRequired",true);
			     	}
		         }else{
			     		request.setAttribute("mapofplaceRequired",true);
			     	}
			    File psnocDir = new File(mainDir+"psnoc");
			    if (psnocDir.exists()) {
				File[] psnocNameFiles = psnocDir.listFiles();
				if(psnocNameFiles.length>0){
					 request.setAttribute("psnocRequired",false);
				    String[] psnocName = new String[10];
					int l=0;
					for (File file : psnocNameFiles) {
					    if (file.isFile()) {
					    	psnocName[l] = file.getName();
					        System.out.println(file.getName());
					        l++;
					    }
					}
					request.setAttribute("psnocName",psnocName);
			     	}else{
			     		request.setAttribute("psnocRequired",true);
			     	}
		         }else{
			     		request.setAttribute("psnocRequired",true);
			     	}
			    File firenocDir = new File(mainDir+"firenoc");
			    if (firenocDir.exists()) {
				File[] firenocNameFiles = firenocDir.listFiles();
				if(firenocNameFiles.length>0){
					 request.setAttribute("firenocRequired",false);
				    String[] firenocName = new String[10];
					int l=0;
					for (File file : firenocNameFiles) {
					    if (file.isFile()) {
					    	firenocName[l] = file.getName();
					        System.out.println(file.getName());
					        l++;
					    }
					}
					request.setAttribute("firenocName",firenocName);
			     	}else{
			     		request.setAttribute("firenocRequired",true);
			     	}
		         }else{
			     		request.setAttribute("firenocRequired",true);
			     	}
			    File placenocDir = new File(mainDir+"placenoc");
			    if (placenocDir.exists()) {
				File[] placenocNameFiles = placenocDir.listFiles();
				if(placenocNameFiles.length>0){
					 request.setAttribute("placenocRequired",false);
				    String[] placenocName = new String[10];
					int m=0;
					for (File file : placenocNameFiles) {
					    if (file.isFile()) {
					    	placenocName[m] = file.getName();
					        System.out.println(file.getName());
					        m++;
					    }
					}
					request.setAttribute("placenocName",placenocName);
			     	}else{
			     		request.setAttribute("placenocRequired",true);
			     	}
		         }else{
			     		request.setAttribute("placenocRequired",true);
			     	}
			    File concertDir = new File(mainDir+"concert");
			    if (concertDir.exists()) {
				File[] concertNameFiles = concertDir.listFiles();
				if(concertNameFiles.length>0){
					 request.setAttribute("concertRequired",false);
				    String[] concertName = new String[10];
					int n=0;
					for (File file : concertNameFiles) {
					    if (file.isFile()) {
					    	concertName[n] = file.getName();
					        System.out.println(file.getName());
					        n++;
					    }
					}
					request.setAttribute("concertName",concertName);
			     	}else{
			     		request.setAttribute("concertRequired",true);
			     	}
		         }else{
			     		request.setAttribute("concertRequired",true);
			     	}
	      }else{
	    	  request.setAttribute("residProofRequired",true);
	    	  request.setAttribute("idProofRequired",true);
	    	  request.setAttribute("concertRequired",true);
	    	  request.setAttribute("placenocRequired",true);
	    	  request.setAttribute("psnocRequired",true);
	    	  request.setAttribute("firenocRequired",true);
	    	  request.setAttribute("mapofplaceRequired",true);
	    	  request.setAttribute("inspectionReportoneRequired",true);
	    	  request.setAttribute("inspectionReporttwoRequired",true);
	      }
	 }

 
}
