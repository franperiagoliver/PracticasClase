package com.bpe.servlet;

import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class DownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Map<String, String> filesMap = new HashMap<String, String>();


	
	@Override
	public void init() throws ServletException {
		 filesMap.put("1", "Catalogo.xlsx");
		 filesMap.put("2", "Catalogo.pdf");
	}

	private String getContentType(String fileName){
		String name = fileName.toLowerCase();
		String type = null;
		if (name.endsWith(".pdf")) {
			type = "application/pdf";
		} else if (name.endsWith(".xlsx")){
			type = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";			
		} else {
			throw new RuntimeException("Tipo desconocido de archivo: " + fileName);
		}
		
		return type;
	}

	private void copyStream(InputStream is, OutputStream os) 
	        throws IOException {
	    int size = 1024;
	    byte[] buffer = new byte[size];
	    int len;
	    while ((len = is.read(buffer, 0, size)) > -1) {
	        os.write(buffer, 0, len);
	    }
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletOutputStream outstream = null;
	    FileInputStream fis = null;
	    BufferedInputStream bis = null;
	    
	    PrintWriter pw = null;
	    
	    try {
	        
	        String id = request.getParameter("id_doc");
	        if (id == null) {
	            throw new RuntimeException("Missing parameter 'id_doc'");
	        }
	        
            String fileName = filesMap.get(id);
            if (fileName == null) {
                throw new RuntimeException("File name not found for id = '" + id + "'");
            }
	        
            File file = new File("C:/Users/josecgra/Documents/JAVA/curso JSP y Servlet/CURSO/CP-Fuentes/dataFiles", fileName);
	        if (!file.exists()) {
                throw new RuntimeException("File not found: '" + file.getAbsolutePath() + "'");
	        }
	        
	        fis = new FileInputStream(file);
	        bis = new BufferedInputStream(fis);
	        
	        String contentType = getContentType(fileName);
	        
	        outstream = response.getOutputStream();

	        response.setContentType(contentType);

 	        //String option = "attachment";
	        String option = "inline";
	        response.setHeader("Content-disposition", option + 
	                ";filename=\"" + fileName + "\"");

	        response.addHeader("Pragma", "no cache");
	        response.addHeader("Cache-control", "private, must-revalidate");
	        copyStream(bis, outstream);

	        
        } catch (Exception e) {
            response.setContentType("text/html");
            pw = response.getWriter();
            pw.println("<html>");
            pw.println("<head><title>Download error</title></head>");
            pw.println("<body>");
            pw.println(" <h3>" + e.getMessage() + "</h3>");
            pw.println("</body>");
            pw.println("</html>");
            
        } finally {
            close(outstream);
            close(bis);
            close(pw);
        }
			
		
	}

	private void close(Closeable c) {
        if (c != null) {
    	    try {
    	        c.close();
            } catch (Exception e) {}
        }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
