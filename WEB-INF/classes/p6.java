import java.io.*;
import javax.servlet.http.*;  
import javax.servlet.*;  

class Obje{
    public String username;
    public String password;
    public void setData(String na,String ra)
    {
        username=na;
        password=ra;
    }
}

public class p6 extends HttpServlet{
    public Obje[] obj=new Obje[4];
    private String ran;
    private String nam;
    public int hit;
    public int j;
    public void init()
    {
        hit=0;
        obj[0]=new Obje();
        obj[1]=new Obje();
        obj[2]=new Obje();
        obj[0].setData("Babiana", "190203");
        obj[1].setData("Roy", "6374");
        obj[2].setData("Babloo", "9994");
    }
    public void doGet(HttpServletRequest req,HttpServletResponse response)throws ServletException,IOException{
        response.setContentType("text/html");
        String user=req.getParameter("username");
        String pas=req.getParameter("pass");
        PrintWriter out=response.getWriter();
        hit++;
        j=0;
        for(int i=0;i<3;i++)
        {
            if(obj[i].username.equals(user) && obj[i].password.equals(pas))
            {
                j=1;
                out.println("<h3>Scolarship Application Requirements</h3>");
                out.println("<p>Marks requirements is above 75% in 12th</p>");
                out.println("<p>Should not have received scholarship from any other institutions</p>");
                out.println("<h3>Number of page visits:"+hit+"</h3>");
                break;
            }
            if(j==1)
            {
                out.println("<h3>Invalid Username and Password</h3>");
            }
        }
    }
    public void destroy(){
        //do nothing
    }
}
