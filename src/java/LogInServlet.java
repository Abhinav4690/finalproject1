
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class LogInServlet extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out= response.getWriter();
        String name="abc";
        String pwd="1234";
        String uname=request.getParameter("user");
        String upwd=request.getParameter("pwsd");
        if(name.equals(uname)&& pwd.equals(upwd)){
           
            HttpSession s= request.getSession();
            s.setAttribute("userName",uname);

          response.sendRedirect("");
           
        }
        else{
           
   request.getRequestDispatcher("LOGIN.jsp").include(request, response);  
 out.println("<script type=\"text/javascript\">");
       out.println("alert('WRONG USERNAME AND PASSWORD');");
       out.println("</script>");
       out.close();
           
            
        }
                
       
    }
    

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
// if(name.equals(uname)&& pwd.equals(upwd)){
//            //out.println("<h2>LOGIN SUCCESSFULL</h2>");
//            HttpSession s= request.getSession();
//            s.setAttribute("userName",uname);
////            RequestDispatcher rd= request.getRequestDispatcher("HOMEPAGE.html");
////            rd.forward(request,response);
//          response.sendRedirect("HOMEPAGE.jsp");
//            //USE response.sendRedirect(url of the page); to go to performed page            
//// RequestDispatcher rd= request.getRequestDispatcher("success.html");
////rd.forward(request,response);
//        }
//        else{
//            //out.println("<h2>LOGIN FAILED</h2>");
//            //response.sendRedirect("index.html"); eg google.com
//            
////          RequestDispatcher rd= request.getRequestDispatcher("LOGIN.html");
////          rd.forward(request,response);
////response.sendRedirect("LOGIN.html");
//   request.getRequestDispatcher("LOGIN.jsp").include(request, response);  
// out.println("<script type=\"text/javascript\">");
//       out.println("alert('WRONG USERNAME AND PASSWORD');");
//       out.println("</script>");
//       out.close();
//           
//            //
//        }
