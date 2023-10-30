<%@page import="java.util.Date"%>
<%@page import="ma.school.beans.Etudiant"%>
<%@page import="ma.school.service.EtudiantService"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns:h="http://xmlns.jcp.org/jsf/html" xmlns:f="http://xmlns.jcp.org/jsf/core">
    <head>
        <script src="script/script.js" type="text/javascript"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script src="script/jsonExemple.js" type="text/javascript"></script>
        <link href="style/css.css" rel="stylesheet" type="text/css"/>
        <link href="style/csslocal.css" rel="stylesheet" type="text/css"/>
        
   <title>Confirmation de suppression</title>
    <script>
    function confirmerSuppression(id) {
        var confirmation = window.confirm("Voulez-vous vraiment supprimer cet étudiant ?");
        if (confirmation) {
            
            window.location.href = "EtudiantController?op=delete&id=" + id;
        } else {
            
            alert("Suppression annulée.");
        }
    }
</script>

     

    </head>
    <body>
       
        <%@include file="template/header.jsp" %>
        
        <%@include file="template/menu.jsp" %>
        
        
        
        <div class="content">
            <form method="GET" action="EtudiantController">
                
                <fieldset>
                    <legend>Informations Etudiant</legend>
                    <table border="0">
                        <tr>
                            <td>Nom</td>
                            <td><input id="nom" type="text" name="nom" value=""  required=""/></td>
                        </tr>
                        <tr>
                            <td>Prenom</td>
                            <td><input id="prenom" type="text" name="prenom" value="" required="" /></td>
                        </tr>
                        <tr>
                            <td>Ville</td>
                            <td>
                                <select id="ville" name="ville">
                                    <option value="Rabat">Rabat</option>
                                    <option value="Fes">Fes</option>
                                    <option value="Marakech">Marrakech</option>
                                    <option value="CasaBlanca">CasaBlanca</option>
                                    <option value="Agadir">Agadir</option>
                                    <option value="Tanger">Tanger</option>

                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td>Date de naissance</td>
                            <td><input id="date" type="date" name="dateNaissance" value="" required="" /></td>
                        </tr>
                        <tr>
                            <td>Sexe</td>
                            <td>M<input id="m" type="radio" name="sexe" value="homme" />
                                F<input id="f" type="radio" name="sexe" value="femme" checked="checked" /></td>
                        </tr>
                        <tr>
                            <td></td>
                            <td>
                                <input name="op" type="submit" value="Envoyer" />
                            </td>
                        </tr>
                    </table>
                </fieldset>
            </form>
            <%
                EtudiantService es = new EtudiantService();
            %>
            <fieldset>
                <legend>Liste des étudiants</legend>

                <table border="1" class="tab">
                    <thead>
                        <tr>
                            <th>Id</th>
                            <th>Nom <br>
                                <input id="f" type="text" name="f" value="" /></th>
                            <th>Prenom</th>
                            <th>Ville</th>
                            <th>Date de naissance</th>
                            <th>Sexe</th>
                            <th>Supprimer</th>
                            <th>Modifier</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            for (Etudiant e : es.findAll()) {
                        %>
                        <tr>
                            <td><%=e.getId()%></td>
                            <td><%=e.getNom()%></td>
                            <td><%=e.getPrenom()%></td>
                            <td><%=e.getVille()%></td>
                            <td><%=e.getDateNaissance()%></td>
                            <td><%=e.getSexe()%></td>
                            <td><button onclick="confirmerSuppression(<%=e.getId()%>)">Supprimer</button></td>
                            <td>
                                <form method="POST" action="EtudiantController">
                                    <input type="hidden" name="Id" value="<%=e.getId()%>">
                                    <label for="Nom">Nom :</label>
                                    <input type="text" name="Nom" value="<%=e.getNom()%>" >
                                    <label for="Prenom">Prénom :</label>
                                    <input type="text" name="Prenom" value="<%=e.getPrenom()%>" >
                                    <label for="Ville">Ville: </label>
                                    <input type="text" name="Ville" value="<%=e.getVille()%>" >
                                    <label for="DateNaissance">DateNaissance : </label>
                                    <input type="text" name="DateNaissance" value="<%=e.getDateNaissance()%>" >
                                    <label for="Sexe">Sexe : </label>
                                    <input type="text" name="Sexe" value="<%=e.getSexe()%>" >
                                    <input type="submit" value="Mettre à jour">
                                </form>
                            </td>
                        </tr>
                        <%}%>
                    </tbody>
                </table>

            </fieldset>
        </form>            
</body>
</html>
