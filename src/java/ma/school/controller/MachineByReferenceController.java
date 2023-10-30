
package ma.school.controller;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ma.school.beans.Machine;
import ma.school.service.MachineService;
import ma.school.service.MarqueService;

/**
 *
 * @author Tecra
 */
@WebServlet(name = "MachineByReferenceController", urlPatterns = {"/MachineByReferenceController"})
public class MachineByReferenceController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
       MarqueService ms = new MarqueService();
    MachineService mms = new MachineService();
   protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       String ref = request.getParameter("ref");
       System.out.println(ref);
        String reference = request.getParameter("reference"); 
        System.out.println("========================");
        System.out.println(reference);
        List<Machine> machines = mms.findByReference(ref);
        response.setContentType("application/json;charset=UTF-8");
        String json = new Gson().toJson(machines);
        response.getWriter().write(json);
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