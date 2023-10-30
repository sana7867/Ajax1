/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.school.controller;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Tecra
 */
import com.google.gson.Gson;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "MachineCountByMarqueController", urlPatterns = {"/MachineCountByMarqueController"})
public class MachineCountByMarqueController extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Récupérez les données depuis la base de données ou une autre source
        List<MarqueCount> data = new ArrayList<>();
        data.add(new MarqueCount("Marque1", 10));
        data.add(new MarqueCount("Marque2", 20));

        // Convertissez les données en JSON
        String jsonData = new Gson().toJson(data);

        // Définissez le type de contenu de la réponse HTTP
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        // Écrivez les données JSON dans la réponse
        response.getWriter().write(jsonData);
    }
}

class MarqueCount {
    private String libelle;
    private int count;

    public MarqueCount(String libelle, int count) {
        this.libelle = libelle;
        this.count = count;
    }

    public String getLibelle() {
        return libelle;
    }

    public int getCount() {
        return count;
    }
}
