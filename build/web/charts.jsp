<%@page import="ma.school.service.MarqueService"%>
<%@page import="ma.school.beans.Marque"%>
<%@page import="ma.school.service.MachineService"%>
<%@page import="java.util.List"%>
<%@page import="ma.school.beans.Machine"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
   
    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
     <script src="script/script.js" type="text/javascript"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <title>Graphique de machines par marque</title>
        <script src="script/jsonExemple.js" type="text/javascript"></script>
        <link href="style/css.css" rel="stylesheet" type="text/css"/>
        <link href="style/csslocal.css" rel="stylesheet" type="text/css"/>
        
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f7f7f7;
            padding: 20px;
        }
        #container {
            max-width: 800px;
            margin: 0 auto;
            background-color: #fff;
            border: 1px solid #ddd;
            padding: 20px;
            text-align: center;
        }

        #chartContainer {
            display: flex;
            justify-content: center;
        }

        canvas#machineChart {
            width: 80%;
        }

    </style>
</head>


<body>
<%@include file="template/menu.jsp" %>

<div id="container">
    <h1>Graphique de machines par marque</h1>
    </div>
    
    <canvas id="machineChart"></canvas>
</div>
<%
    // Remplacez cette partie avec le code Java pour récupérer les données de la base de données
    MachineService ms = new MachineService();
    MarqueService mrs = new MarqueService();
    List<Machine> machines = ms.findAll();
    List<Marque> marques = mrs.findAll();
%>
<script>
    // Déclaration des tableaux pour les étiquettes et les données
    var labels = [];
    var data = [];

    // Boucle pour extraire les données de la liste de marques
    <%
        for (Marque marque : marques) {
    %>
    labels.push("<%= marque.getLibelle()%>"); // Remplacez par le nom de la propriété de la marque
    data.push(<%= ms.findByMarque(marque).size() %>); // Remplacez par la propriété de la machine que vous souhaitez afficher
    <%
        }
    %>

    // Création du graphique de type "barre"
    var ctx = document.getElementById('machineChart').getContext('2d');
    var machineChart = new Chart(ctx, {
        type: "bar", // Type de graphique "barre"
        data: {
            labels: labels,
            datasets: [{
                label: 'Nombre de machines par marque',
                data: data,
                backgroundColor: 'rgba(75, 192, 192, 0.6)',
                borderColor: 'rgba(75, 192, 192, 1)',
                borderWidth: 1
            }]
        },
        options: {
            scales: {
                y: {
                    beginAtZero: true,
                    suggestedMax: 20
                }
            }
        }
    });
</script>
</body>
</html>

    