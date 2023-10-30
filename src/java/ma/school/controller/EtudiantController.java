/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.school.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ma.school.beans.Etudiant;
import ma.school.service.EtudiantService;

/**
 *
 * @author leblond
 */
@WebServlet(name = "EtudiantController", urlPatterns = {"/EtudiantController"})
public class EtudiantController extends HttpServlet {

    String op = null;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */

    @Override
    public void init()
            throws ServletException {
        super.init(); //To change body of generated methods, choose Tools | Templates.
        op = null;
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        op = request.getParameter("op");
        EtudiantService es = new EtudiantService();

        if (op.equals("Envoyer")) {
            String nom = request.getParameter("nom");
            String prenom = request.getParameter("prenom");
            String ville = request.getParameter("ville");
            String date = request.getParameter("dateNaissance");
            System.out.println(date);
            Date dateNaissance = new Date(date.replace("-", "/"));
            String sexe = request.getParameter("sexe");
            es.create(new Etudiant(nom, prenom, ville, dateNaissance, sexe));
            response.sendRedirect("etudiantForm.jsp");
        } else if (op.equals("delete")) {
            int id = Integer.parseInt(request.getParameter("id"));
            es.delete(es.findById(id));
            response.sendRedirect("etudiantForm.jsp");
        } else if (op.equals("update")) {
            int id = Integer.parseInt(request.getParameter("id"));
            es.update(es.findById(id));
            response.sendRedirect("etudiantForm.jsp");

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
    int id = Integer.parseInt(request.getParameter("Id")); // Utilisez "Id" au lieu de "id"
    String nom = request.getParameter("Nom");
    String prenom = request.getParameter("Prenom");
    String ville = request.getParameter("Ville");
    String sexe = request.getParameter("Sexe");
    String dateNaissanceStr = request.getParameter("DateNaissance"); // Utilisez "DateNaissance" au lieu de "Date de Naissance"

    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    Date dateNaissance = null;

    try {
        if (dateNaissanceStr != null && !dateNaissanceStr.isEmpty()) {
            dateNaissance = dateFormat.parse(dateNaissanceStr);
        }
    } catch (ParseException ex) {
        Logger.getLogger(EtudiantController.class.getName()).log(Level.SEVERE, null, ex);
    }

    EtudiantService es = new EtudiantService();
    Etudiant etudiant = es.findById(id);
    etudiant.setNom(nom);
    etudiant.setPrenom(prenom);
    etudiant.setVille(ville);
    etudiant.setDateNaissance(dateNaissance);
    etudiant.setSexe(sexe);
    es.update(etudiant);

    response.sendRedirect("etudiantForm.jsp");
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
