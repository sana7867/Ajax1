/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.school.controller;

import com.google.gson.Gson;
import com.sun.faces.action.RequestMapping;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ma.school.beans.Machine;
import ma.school.beans.Marque;
import ma.school.service.MachineService;
import ma.school.service.MarqueService;

/**
 *
 * @author a
 */
@WebServlet(name = "MachineController", urlPatterns = {"/MachineController"})
public class MachineController extends HttpServlet {
    MarqueService ms = new MarqueService();
    MachineService mms = new MachineService();
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String op = request.getParameter("op");
        if(op.equalsIgnoreCase("envoyer")){
            String ref = request.getParameter("ref");
            double prix = Double.parseDouble(request.getParameter("prix"));
            Date dateAchat = new Date(request.getParameter("dateAchat").replace("-", "/"));
            Marque marque = ms.findById(Integer.parseInt(request.getParameter("marque")));
            mms.create(new Machine(ref, dateAchat, prix, marque));
            response.sendRedirect("machineForm.jsp");
        }else if(op.equalsIgnoreCase("delete")){
            mms.delete(mms.findById(Integer.parseInt(request.getParameter("id"))));
            response.sendRedirect("machineForm.jsp");
        }
        else if(op.equalsIgnoreCase("update")){
            mms.delete(mms.findById(Integer.parseInt(request.getParameter("id"))));
            response.sendRedirect("machineForm.jsp");
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
    int id = Integer.parseInt(request.getParameter("id"));
    String reference = request.getParameter("Reference");
    double prix = Double.parseDouble(request.getParameter("Prix"));
    int marqueId = Integer.parseInt(request.getParameter("Marque"));
    String dateAchatStr = request.getParameter("DateAchat");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); // Format attendu (AAAA-MM-JJ)
        Date dateAchat = null;
        try {
            dateAchat = dateFormat.parse(dateAchatStr);
        } catch (ParseException ex) {
            Logger.getLogger(MachineController.class.getName()).log(Level.SEVERE, null, ex);
        }

    // Récupérez la marque correspondante
    MarqueService mas = new MarqueService();
    Marque marque = mas.findById(marqueId);

    // Mettez à jour la machine
    Machine machine = mms.findById(id);
    machine.setReference(reference);
    machine.setPrix(prix);
    machine.setMarque(marque);
    machine.setDateAchat(dateAchat);

    mms.update(machine);

    // Redirigez l'utilisateur vers une page de confirmation ou autre
    response.sendRedirect("machineForm.jsp");
}

   
@RequestMapping("/filterByMarque")
public void filterByMarque(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    int marqueId = Integer.parseInt(request.getParameter("marqueId"));
    
    // Appelez votre service pour obtenir l'objet Marque correspondant à l'ID
    MarqueService marqueService = new MarqueService();
    Marque marque = marqueService.findById(marqueId);
    
    // Ensuite, utilisez cette instance de Marque pour filtrer les machines
    MachineService machineService = new MachineService();
    List<Machine> filteredMachines = machineService.findByMarque(marque);
    
    // Convertissez la liste de machines en JSON
    Gson gson = new Gson();
    String json = gson.toJson(filteredMachines);
    
    response.setContentType("application/json");
    response.setCharacterEncoding("UTF-8");
    response.getWriter().write(json);
}

 @RequestMapping("/filterByReference")
    public void filterByReference(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String ref = request.getParameter("ref");
       System.out.println(ref);
        String reference = request.getParameter("reference"); 
        System.out.println("========================");
        System.out.println(reference);
        
        // Appelez votre service pour obtenir l'objet Machine correspondant à l'ID de référence
        MachineService machineService = new MachineService();
        List<Machine> filteredMachines = machineService.findByReference(ref);
        
        // Convertissez la liste de machines en JSON
        Gson gson = new Gson();
        String json = gson.toJson(filteredMachines);
        
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);
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
