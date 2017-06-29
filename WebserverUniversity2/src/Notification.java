
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;  


@WebServlet("/Notification")
public class Notification extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
    
	
	  String res=" " ;
	  
	  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  
		  response.setContentType("text/plain");
		  if(res.length()!=0)
		  {
	        response.getWriter().print(res);
		  }
	 
	    }
	 
	  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("application/json");
		
		 String coursename = request.getParameter("coursename");      
                //res=request.getHeader("res");   
        
        
        String driver="com.mysql.jdbc.Driver";
        String url="jdbc:mysql://localhost:3306/universitydb";
        String username="root";
        String password="123";
		String sql= "select courseUpdate , URL_CourseUpdate  from Notification where courseNAME=?";
		
		try{    
	            Class.forName(driver);  
	            Connection con=DriverManager.getConnection(url,username,password); 
	            PreparedStatement ps=con.prepareStatement(sql);    
	            ps.setString(1,coursename);    
	         
	             ResultSet a=ps.executeQuery(); 
	          res=" ";
	             while(a.next()) {
	            	 
 res+=a.getString(1)+" is added and saved in-->"+a.getString(2)+"?";

	             }
	            	
	              con.close(); 
	                    
	        }catch (ClassNotFoundException e){
		e.printStackTrace();}
	    		catch(SQLException e){e.printStackTrace();}
	    	
		 
}
}
