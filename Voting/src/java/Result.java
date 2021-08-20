import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

public class Result extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection(
                   "jdbc:mysql://localhost/vote?useTimezone=true&serverTimeZone=UTC","root","");
         
            Statement stmt;
            ResultSet resultSet;
            stmt=con.createStatement();
            resultSet=stmt.executeQuery("select * from vote");
            int d=0,s=0,n=0;
            while(resultSet.next())
            {
                String value = resultSet.getString("cand"); 
                if("dd".equals(value)){
                    d++;
                }
                else if("shals".equals(value)){
                    s++;
                }
                else if("nota".equals(value)){
                    n++;
                }
                
            }
                out.println("<h1>VOTE RESULTS</h1>");
                out.println("<p>DAZZLULLA: "+d+"<p>");
                out.println("<p>SHALS: "+s+"</p>");
                out.println("<p>NOTA: "+n+"<p>");
                
        }
        catch(Exception e) {
            out.println(e);
        }
        }
    }

}
