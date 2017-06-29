
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


@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
    
	
	  String job ;
	  
	  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  
		  response.setContentType("text/plain");
	        response.getWriter().print(job);
	       
	 
	    }
	 
	  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("application/json");
		String n=request.getParameter("name");    
        String p=request.getParameter("pass");  
      
        System.out.println(n);  
        System.out.println(p); 
        
        String driver="com.mysql.jdbc.Driver";
        String url="jdbc:mysql://localhost:3306/universitydb";
        String username="root";
        String password="123";
		String sql= "select job from signup_login where Email=? and password=?";
		
		try{    
	            Class.forName(driver);  
	            Connection con=DriverManager.getConnection(url,username,password); 
	            PreparedStatement ps=con.prepareStatement(sql);    
	            ps.setString(1,n);    
	             ps.setString(2,p);    
	         
	             ResultSet a=ps.executeQuery(); 
	          /*   if(a.first())
	             {
	            	 do{
	            	 System.out.println(a.getString(1));  
	            	 }while(a.next());
	             } */
	             if(a.next()) {
	            	 job=a.getString(1);
	            	 System.out.println(a.getString(1)); }
	             else
	             {
	            	 job="no job";
	            	 System.out.println("data is incorrect"); 
	             }
	              con.close(); 
	                    
	        }catch (ClassNotFoundException e){
		e.printStackTrace();}
	    		catch(SQLException e){e.printStackTrace();}
	    	
		 
}
}
