

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RecFileServlet
 */
@WebServlet("/RecFileServlet")
public class RecFileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	  static final String SAVE_DIR = "uploadedFiles";
	    static final int BUFFER_SIZE = 4096;

	    @Override
	    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	         doPost(req, resp);
	    }


	    protected void doPost(HttpServletRequest request,
	            HttpServletResponse response) throws ServletException, IOException {

	        // Gets file name for HTTP header
	        String fileName = request.getHeader("fileName");
	        String coursename = request.getHeader("coursename");
	        
	        File saveFile = new File(fileName);

	        // prints out all header values
	        System.out.println("===== Begin headers =====");
	        Enumeration<String> names = request.getHeaderNames();
	        while (names.hasMoreElements()) {
	            String headerName = names.nextElement();
	            System.out.println(headerName + " = " + request.getHeader(headerName));
	        }
	        System.out.println("===== End headers =====\n");

	        // opens input stream of the request for reading data
	        InputStream inputStream = request.getInputStream();

	        // opens an output stream for writing file
	        FileOutputStream outputStream = new FileOutputStream(saveFile);

	        byte[] buffer = new byte[BUFFER_SIZE];
	        int bytesRead = -1;
	        System.out.println("Receiving data...");

	        while ((bytesRead = inputStream.read(buffer)) != -1) {
	            outputStream.write(buffer, 0, bytesRead);
	        }

	        System.out.println("Data received.");
	        outputStream.close();
	        inputStream.close();

	        System.out.println("File written to: " + saveFile.getAbsolutePath());

	        // sends response to client
	        response.getWriter().print("UPLOAD DONE");
	        
	        
	        String driver="com.mysql.jdbc.Driver";
	        String url="jdbc:mysql://localhost:3306/universitydb";
	        String username="root";
	        String password="123";
			String sql= "insert into Notification (courseNAME,courseUpdate,URL_CourseUpdate) values(?,?,?)";
			
			try{    
		            Class.forName(driver);  
		            Connection con=DriverManager.getConnection(url,username,password); 
		            PreparedStatement ps=con.prepareStatement(sql);    
		            ps.setString(1,coursename);    
		             ps.setString(2,fileName);
		             ps.setString(3,saveFile.getAbsolutePath());
		             
		             int a=ps.executeUpdate(); 
		             
		             if(a==1)
		             {
		            	 System.out.println("data inserted");  
		             }
		              con.close(); 
		    
		         
		                    
		        }catch (ClassNotFoundException e){
			e.printStackTrace();}
		    		catch(SQLException e){e.printStackTrace();}
		    			
		            
	}
	    

	}