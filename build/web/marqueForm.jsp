<%@page import="ma.school.beans.Marque"%>
<%@page import="ma.school.service.MarqueService"%>
<%@page import="java.util.Date"%>
<%@page import="ma.school.beans.Etudiant"%>
<%@page import="ma.school.service.EtudiantService"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <script src="script/script.js" type="text/javascript"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="style/css.css" rel="stylesheet" type="text/css"/>
        <link href="style/csslocal.css" rel="stylesheet" type="text/css"/>
        
    <script>
    function confirmerSuppression(id) {
        var confirmation = window.confirm("Voulez-vous vraiment supprimer cette marque ?");
        if (confirmation) {
            
            window.location.href = "MarqueController?op=delete&id=" + id;
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
            <form method="GET" action="MarqueController">
                <fieldset>
                    <legend>Informations Marque</legend>
                    <table border="0">
                        <tr>
                            <td>Code</td>
                            <td><input id="code" type="text" name="code" value=""  required=""/></td>
                        </tr>
                        <tr>
                            <td>Libelle</td>
                            <td><input id="libelle" type="text" name="libelle" value="" required="" /></td>
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
                MarqueService ms = new MarqueService();
            %>
            <fieldset>
                <legend>Liste des marque</legend>

                <table border="1" class="tab">
                    <thead>
                        <tr>
                            <th>Id</th>
                            <th>Code <br>
                            <th>Libelle</th>
                            
                            <th>Supprimer</th>
                            <th>Modifier</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            for (Marque m : ms.findAll()) {
                        %>
                        <tr>
                            <td><%=m.getId()%></td>
                            <td><%=m.getCode()%></td>
                            <td><%=m.getLibelle()%></td>
                            
                            <td><button onclick="confirmerSuppression(<%=m.getId()%>)">Supprimer</button></td>
                            <td>
                                <form method="POST" action="MarqueController">
                                    <input type="hidden" name="id" value="<%=m.getId()%>">
                                    <label for="code">Code:</label>
                                    <input type="text" id="code" name="code" value="<%=m.getCode()%>">
                                    <label for="libelle">Libelle:</label>
                                    <input type="text" id="libelle" name="libelle" value="<%=m.getLibelle()%>">
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
