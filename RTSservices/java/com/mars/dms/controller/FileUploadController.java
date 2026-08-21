package com.mars.dms.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.jcr.Node;
import javax.jcr.RepositoryException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.DefaultFileItemFactory;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUpload;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.mars.common.utils.CommonUtils;
import com.mars.dms.service.ContentRetrieveService;


@Controller
public class FileUploadController extends MultiActionController implements InitializingBean
{

    private static Log log = LogFactory.getLog(FileUploadController.class);
    
    @Autowired
    private ContentRetrieveService contentRetrieveService;

   /* 
    private ContentPublishService contentPublishService;

    public void setContentPublishService(ContentPublishService contentPublishService) {
    this.contentPublishService = contentPublishService;
    }*/

    public void setContentRetrieveService(ContentRetrieveService contentRetrieveService) {
    this.contentRetrieveService = contentRetrieveService;
    }


    public void afterPropertiesSet() throws Exception
    {

    }

    @RequestMapping("/fileupload/uploadFile.do")
    public ModelAndView uploadFile(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, Exception
    {
	String BaseDir = request.getRealPath(request.getContextPath()) + "/uploads/";
	String strSourceDir = request.getParameter("sourceDir").toString();

	if (strSourceDir != null && strSourceDir.length() > 0)
	    BaseDir = BaseDir + strSourceDir + "/";

	String contentType = request.getContentType();
	String uuid = "Success";
	//if request is of type multipart/form-data, save contents to a map
	if ((contentType != null) && (contentType.indexOf("multipart/form-data") != -1))
	{
	    try
	    {
		FileItemFactory factory = new DefaultFileItemFactory();
		FileUpload fileUpload = new FileUpload(factory);
		List items = fileUpload.parseRequest(request);
		Iterator iter = items.iterator();
		while (iter.hasNext())
		{
		    FileItem item = (FileItem) iter.next();
		    String strFileName = item.getName();
		  
		    if (strFileName!=null)
		    {
		    	if(strFileName.lastIndexOf("\\") != -1)	
		    		strFileName = strFileName.substring(strFileName.lastIndexOf("\\") + 1);
		    
		    File file = new File(BaseDir);
		    file.mkdirs();
		    File uploadedFile = new File(BaseDir + strFileName);
		    
		    //Don't write to directory on Local server. Now it will be sent to DMS
		    item.write(uploadedFile);

		   /* Map<String, Object> requestMap = new HashMap<String, Object>();
		    requestMap.put(DMSConstants.JCR_FILE_PRIVACY,DMSConstants.STATUS_PUBLIC);
		    requestMap.put(DMSConstants.JCR_FILE_KEYWORD,new String("Water,Test,Upload"));
		    requestMap.put(DMSConstants.JCR_FILE_COMMENTS,new String("Test Comments"));
		    requestMap.put(DMSConstants.JCR_FILE_TYPE,new String("OC"));
		    
		    Node node = contentPublishService.saveFileToRepository(contentRetrieveService.getNodeByPath("/Property"), uploadedFile,requestMap);
		    uuid = node.getUUID();*/
		    break;
		    }
		    
		}
	    } catch (Exception exception)
	    {
		log.error(exception.getStackTrace(),exception);
		exception.printStackTrace();
	    }
	}
	//response.getWriter().write("Success");
	response.getWriter().write(uuid);
	return null;
    }
    
    
    @RequestMapping("/fileupload/downloadFile.do")
    public void downloadFile(HttpServletRequest request, HttpServletResponse response) throws ServletException, Exception 
    {
    	try {
	    	String strUUID = CommonUtils.decodeString(request.getParameter("uuid"));
	    	if (StringUtils.isNotEmpty(strUUID)) {
		    	Node node = contentRetrieveService.getByNodeId(strUUID);
		    	Node resource = node.getNode("jcr:content");
		    	response.setContentType("application/octet-stream");
		    	response.setHeader("Content-Disposition", "attachment; filename=\"" + node.getName() + "\"");
		    	InputStream in = resource.getProperty("jcr:data").getBinary().getStream();
		    	ServletOutputStream outs = response.getOutputStream();
		    	int i = 0;
		    	while ((i = in.read()) != -1) {
		    		outs.write(i);
		    	}
		    	outs.flush();
		    	outs.close();
		    	in.close();
	    	}

    	} catch (RepositoryException repositoryException) {
    	log.error(repositoryException.getMessage(),repositoryException);
    	PrintWriter pw = new PrintWriter(new FileOutputStream(new File("/root/Desktop/NOC/FileDownloadException1.txt"),true)); 
		 pw.println(new Date().toString());
        pw.println(repositoryException.getMessage());
        pw.println(org.apache.commons.lang.exception.ExceptionUtils.getStackTrace(repositoryException));
        pw.close();
    response.sendRedirect(request.getContextPath()+"/pages/common/exception.jsp");
       
    	} catch (FileNotFoundException fileNotFoundException) {
    	log.error(fileNotFoundException.getMessage());
    	PrintWriter pw = new PrintWriter(new FileOutputStream(new File("/root/Desktop/NOC/FileDownloadException2.txt"),true)); 
		 pw.println(new Date().toString());
       pw.println(fileNotFoundException.getMessage());
       pw.println(org.apache.commons.lang.exception.ExceptionUtils.getStackTrace(fileNotFoundException));
       pw.close();
   response.sendRedirect(request.getContextPath()+"/pages/common/exception.jsp");
       
    	} catch (IOException exception) {
    		PrintWriter pw = new PrintWriter(new FileOutputStream(new File("/root/Desktop/NOC/FileDownloadException4.txt"),true)); 
   		 pw.println(new Date().toString());
          pw.println(exception.getMessage());
          pw.println(org.apache.commons.lang.exception.ExceptionUtils.getStackTrace(exception));
          pw.close();
    	response.sendRedirect(request.getContextPath()+"/pages/common/exception.jsp");
          
    	
    	} catch (Exception exception) {
    		PrintWriter pw = new PrintWriter(new FileOutputStream(new File("/root/Desktop/NOC/FileDownloadException1.txt"),true)); 
      		 pw.println(new Date().toString());
             pw.println(exception.getMessage());
             pw.println(org.apache.commons.lang.exception.ExceptionUtils.getStackTrace(exception));
             pw.close();
         	response.sendRedirect(request.getContextPath()+"/pages/common/exception.jsp");
            
    	}
    	}
    @RequestMapping("/fileupload/showFile.do")
    public void showFile(HttpServletRequest request, HttpServletResponse response) throws ServletException, Exception 
    {
    	 
    	try {
	    	String strUUID = CommonUtils.decodeString(request.getParameter("uuid"));
	    	if (StringUtils.isNotEmpty(strUUID)) {
	    		Node node = contentRetrieveService.getByNodeId(strUUID);
		    	Node resource = node.getNode("jcr:content"); 
		    	ServletContext sc = request.getServletContext();
		    	 String contentType = sc.getMimeType(node.getName());
		         response.reset();
		         response.setContentType(contentType);
		         
		    	/*response.setHeader("Content-Disposition", "attachment; filename=\"" + node.getName() + "\"");*/
		    	InputStream in = resource.getProperty("jcr:data").getBinary().getStream();
		    	ServletOutputStream outs = response.getOutputStream();
		    	   
		    	int count;

                while ((count = in.read()) != -1) {
                	outs.write(count);
                }
                in.close();
                outs.close();
		    	  	
	    	}
	    	
	    				
    	} catch (RepositoryException repositoryException) {
    	log.error(repositoryException.getMessage(),repositoryException);	
    	} catch (FileNotFoundException fileNotFoundException) {
    	log.error(fileNotFoundException.getMessage());
    	} catch (IOException exception) {
    	log.error(exception.getMessage());
    	}catch (Exception exception) {
    	log.error(exception.getMessage());
    	}
    	}
    

}
