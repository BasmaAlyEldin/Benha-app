

//import java.io.File;
//import java.io.FileInputStream;
import java.io.IOException;
//import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class dowonloadFile
 */
@WebServlet("/dowonloadFile")
public class dowonloadFile extends HttpServlet {
	private static final long serialVersionUID = 1L;

   
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      
		  /*String fileurl = request.getHeader("fileurl");
		
        System.out.println("fileurl "+fileurl);  


      File downloadedFile = new File(fileurl);
        
        FileInputStream in = new FileInputStream(downloadedFile);
        
        OutputStream out = response.getOutputStream();
       
        byte[] buffer = new byte[4096];
        int length;
        while ((length = in.read(buffer)) > 0){
           out.write(buffer, 0, length);
        }
        in.close();
        out.flush();

*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	String fileurl = request.getParameter("fileurl");
		System.out.println("fileurl "+fileurl);  
	}

}
