import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.PreparedStatement;
import java.sql.SQLException;  

@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
    
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("application/json");
		String n=request.getParameter("name");    
        String p=request.getParameter("pass");  
        String j=request.getParameter("job");  
        System.out.println(n);  
        System.out.println(p); 
        System.out.println(j); 
        
        String driver="com.mysql.jdbc.Driver";
        String url="jdbc:mysql://localhost:3306/universitydb";
        String username="root";
        String password="123";
		String sql= "insert into signup_login (Email,password,job) values(?,?,?)";
		
		try{    
	            Class.forName(driver);  
	            Connection con=DriverManager.getConnection(url,username,password); 
	            PreparedStatement ps=con.prepareStatement(sql);    
	            ps.setString(1,n);    
	             ps.setString(2,p);
	             ps.setString(3,j);
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
	

