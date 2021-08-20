import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

public class NewServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        String name = request.getParameter("name");
        String cand = request.getParameter("cand");
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/vote?useTimezone=true&serverTimeZone=UTC","root","");
            Statement stmt = con.createStatement();
            if("dd".equals(cand)){
               stmt.executeUpdate("insert into vote values('"+name+"','"+cand+"')");
               out.println("<h1>Successfully Inserted</h1>"); 
            }
            else if("shals".equals(cand)){
                stmt.executeUpdate("insert into vote values('"+name+"','"+cand+"')");
                out.println("<h1>Successfully Inserted</h1>"); 
            }
            else if("nota".equals(cand)){
                stmt.executeUpdate("insert into vote values('"+name+"','"+cand+"')");
                out.println("<h1>Successfully Inserted</h1>"); 
            }
        }
        catch(Exception e){
            out.println(e);
        }
    }
}