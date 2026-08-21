//package com.mars.rti.controller;
//
//import java.io.*;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.multipart.MultipartFile;
//import org.springframework.web.multipart.MultipartHttpServletRequest;
//import org.springframework.web.servlet.ModelAndView;
//
//import com.google.zxing.NotFoundException;
//import com.google.zxing.WriterException;
//import com.mars.rti.model.RTIApplication;
//import com.mars.rti.service.RTIApplicationService;
//
//@Controller
//public class QRController {
//    
//    private static final int MAX_FILE_SIZE = 10 * 1024 * 1024; // 10MB
//    private static final Log log = LogFactory.getLog(QRController.class);
//
//    @Autowired
//    private ApplicationQRCodeGenerator qrGenerator;
//
//    @Autowired
//    private RTIApplicationService rtiApplicationService;
//
//    @RequestMapping("/rtsapplication/searchApplicaationIdQR.do")
//    public ModelAndView searchApplicationIdQR(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException {
//        return new ModelAndView("manageSearchApplicationIdQR");
//    }
//    @RequestMapping("/rtsapplication/generateQR.do")
//    public ModelAndView generateQR(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException, WriterException {
//
//        if (!(request instanceof MultipartHttpServletRequest)) {
//            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
//            response.getWriter().write("Invalid request type. Please use a file upload form.");
//            return null;
//        }
//
//        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
//        MultipartFile file = multipartRequest.getFile("file");
//
//        if (file == null || file.isEmpty() || !file.getContentType().equals("application/pdf")) {
//            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
//            response.getWriter().write("Invalid PDF file.");
//            return null;
//        }
//
//        // Store file in session for later use in download
//        HttpSession session = request.getSession();
//        session.setAttribute("uploadedPdf", file.getBytes());
//
//        String applicationNo = request.getParameter("applicationNumber");
//        RTIApplication application = rtiApplicationService.findByRTIApplicationNumber(applicationNo);
//
//        if (application == null) {
//            request.setAttribute("error", "Application Number does not exist.");
//            return new ModelAndView("manageSearchApplicationIdQR");
//        }
//
//        int applicationId = (int) application.getRtiApplicationId();
//        
//        // Generate QR Code
//        String serverUrl = request.getRequestURL().toString();
//        String ctx = request.getContextPath();
//        String baseUrl = serverUrl.substring(0, serverUrl.indexOf(ctx)) + ctx;
//        String qrCodeBase64;
//		try {
//			qrCodeBase64 = qrGenerator.getQrCode(applicationId, baseUrl);
//		} catch (NotFoundException | WriterException | IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//        // Set attributes for preview and download
//        request.setAttribute("qrCodeBase64", "data:image/png;base64," + qrCodeBase64);
//        request.setAttribute("downloadLink", "downloadQRPDF.do?applicationNumber=" + applicationNo);
//
//        return new ModelAndView("QRGeneratorSuccess");
//    }
//
//
//}
//
