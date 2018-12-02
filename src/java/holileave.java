

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class holileave extends HttpServlet {

    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
                response.setContentType("text/html;charset=UTF-8");
        PrintWriter pw = response.getWriter();
        String URL;
        URL = "jdbc:mysql://localhost:3306/project?useSSL=false&allowPublicKeyRetrieval=true&verifyServerCertificate=false&allowMultiQueries=true";
        try{  
            String sname = request.getParameter("name");
            String ssnumber = request.getParameter("smob");
            String fathername = request.getParameter("fathername");
            String spnumber = request.getParameter("parentmob");
            String ssdate = request.getParameter("sdate");
            String sedate = request.getParameter("edate");
            String addr = request.getParameter("address");
            String sreason = request.getParameter("reason");
            pw.println(sname);
             pw.println(ssnumber);
            pw.println(fathername);
            pw.println(spnumber);
            pw.println(ssdate);
            pw.println(sedate);
            pw.println(addr);
            pw.println(sreason);
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection con = DriverManager.getConnection(URL,"root","@Loveismylife05")) {
                String q= "insert into holileave values (?,?,?,?,?,?,?,?)";
                PreparedStatement stat = con.prepareStatement(q);
                 stat.setString(1,sname);
                 stat.setString(2,ssnumber);
                 stat.setString(3,fathername);
                 stat.setString(4,spnumber);
                 stat.setString(5,ssdate);
                 stat.setString(6,sedate);
                 stat.setString(7,addr);
                 stat.setString(8,sreason);
                 
                 int i = stat.executeUpdate();
                 if(i>0){
//                     pw.println("<br>Record has been inserted");

  RequestDispatcher rd=request.getRequestDispatcher("holileave.jsp");
        rd.forward(request,response);
//        out.println("<script type=\"text/javascript\">");
//       out.println("alert('Successfully createing request');");
//       out.println("</script>");
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
