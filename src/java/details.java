
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class details extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       response.setContentType("text/html;charset=UTF-8");
        PrintWriter pw = response.getWriter();
        String URL;
        URL = "jdbc:mysql://localhost:3306/project?useSSL=false&allowPublicKeyRetrieval=true&verifyServerCertificate=false&allowMultiQueries=true";
        try{  String sname = request.getParameter("name");
             
             String sfathname = request.getParameter("fath_name");
             String susername = request.getParameter("username"); 
            
              Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection con = DriverManager.getConnection(URL,"root","@Loveismylife05")) {
                String q= "insert into details values (?,?,?)";
                PreparedStatement stat = con.prepareStatement(q);
                 stat.setString(1,sname);       
              stat.setString(2,susername);
                     stat.setString(3,sfathname);
                     
                int i = stat.executeUpdate();
                 if(i>0){
//                     pw.println("<br>Record has been inserted");
 RequestDispatcher rd=request.getRequestDispatcher("accounts.jsp");
     
 

        rd.forward(request,response);
        
       
                 }
                 else{
                     pw.println("failed to insert the data");
                 }  
                 stat.executeUpdate(q);
        }
        }
        catch (Exception e){
  pw.println();
    
    }
    }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
