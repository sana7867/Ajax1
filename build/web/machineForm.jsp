<%@page import="ma.school.beans.Machine"%>
<%@page import="ma.school.service.MachineService"%>
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
         
     <title>Confirmation de suppression</title>
    <script>
    function confirmerSuppression(id) {
        var confirmation = window.confirm("Voulez-vous vraiment supprimer cette machine ?");
        if (confirmation) {
            
            window.location.href = "MachineController?op=delete&id=" + id;
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
            <form method="GET" action="MachineController">
                <fieldset>
                    <legend>Informations Machine</legend>
                    <table border="0">
                        <tr>
                            <td>Reference</td>
                            <td><input id="ref" type="text" name="ref" value=""  required=""/></td>
                        </tr>
                        <tr>
                            <td>Prix</td>
                            <td><input id="prix" type="text" name="prix" value="" required="" /></td>
                        </tr>
                        <tr>
                            <td>Marque</td>
                            <td>
                                <select id="marque" name="marque">
                                    <%
                                        MarqueService ms = new MarqueService();
                                        for(Marque m : ms.findAll()){
                                    %>
                                    <option value="<%=m.getId()%>"><%=m.getLibelle()%></option>
                                    <%}%>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td>Date Achat</td>
                            <td><input id="date" type="date" name="dateAchat" value="" required="" /></td>
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
                MachineService mms = new MachineService();
            %>
            <fieldset>
                <legend>Liste des Machines</legend>

                <table border="1" class="tab">
                    <thead>
                        <tr>
                            <th>Id</th>
                            <th>Reference <br>
                                <input id="f" type="text" name="f" value="" /></th>
                            <th>Prix</th>
                            <th>Marque</th>
                            <th>Date d'achat</th>
                       
                            <th>Supprimer</th>
                            <th>Modifier</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            for (Machine mm : mms.findAll()) {
                        %>
                        <tr>
                            <td><%=mm.getId()%></td>
                            <td><%=mm.getReference()%></td>
                            <td><%=mm.getPrix()%></td>
                            <td><%=mm.getMarque().getLibelle()%></td>
                            <td><%=mm.getDateAchat()%></td>
                            <td><button onclick="confirmerSuppression(<%=mm.getId()%>)">Supprimer</button></td>
                            <td>
                                <form method="POST" action="MachineController">
                                    <input type="hidden" name="id" value="<%=mm.getId()%>">

                                    <label for="Reference">Référence :</label>
                                    <input type="text" id="Reference" name="Reference" value="<%=mm.getReference()%>">

                                    <label for="Prix">Prix :</label>
                                    <input type="text" id="Prix" name="Prix" value="<%=mm.getPrix()%>">

                                    <label for="Marque">Marque :</label>
                                    <select id="Marque" name="Marque">
                                        <%
                                            MarqueService mas = new MarqueService();
                                            for (Marque m : mas.findAll()) {
                                        %>
                                        <option value="<%=m.getId()%>"<% if(m.getId() == mm.getMarque().getId()) out.print(" selected"); %>><%=m.getLibelle()%></option>
                                        <% }%>
                                    </select>

                                    <label for="DateAchat">Date d'Achat :</label>
                                    <input type="date" id="DateAchat" name="DateAchat" value="<%=mm.getDateAchat()%>">

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
