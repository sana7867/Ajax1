$(document).ready(function () {
    
    $("#marque").change(function () {
            $.ajax ({
            url: 'MachineByMarqueController',
            data: {m:  $(this).val()},//this = élément sélectionné
            type: 'POST',
            success: function (data) {
                var ligne="";
                for (var i = 0; i < data.length; i++) {
                    ligne+='<tr>'
                            +'<td>'+data[i].id+'</td>'
                            +'<td>'+data[i].reference+'</td>'
                            +'<td>'+data[i].prix+'</td>'
                            +'<td>'+data[i].dateAchat+'</td>'
                            +'<td>'+data[i].marque.libelle+'</td>'
                          //  +'<td><a class="bndelete" href="MachineController?op=delete&id='+data[i].id+'">Supprimer</a></td>'
                          //  +'<td><a class="bnupdate" href="">Modifier</a></td>'
                        +'</tr>';
                }
                $("#body").html(ligne);
            },
            error: function (jqXHR, textStatus, errorThrown) {
                console.log(textStatus);
            }
        });
    });


});

$(document).ready(function () {
    $("#marque").change(function () {
        var marqueId = $(this).val();
        
        if (marqueId > 0) {
            // Effectuer une demande AJAX pour récupérer les machines filtrées
            $.get("MachineController/filterByMarque", { marqueId: marqueId }, function (data) {
                // Manipulez les données JSON renvoyées (les machines filtrées)
                var tbody = $("#body");
                tbody.empty(); // Effacez le contenu du tableau
                
                for (var i = 0; i < data.length; i++) {
                    var machine = data[i];
                    var row = $("<tr></tr>");
                    row.append("<td>" + machine.id + "</td>");
                    row.append("<td>" + machine.reference + "</td>");
                    row.append("<td>" + machine.prix + "</td>");
                    row.append("<td>" + machine.marque.libelle + "</td>");
                    row.append("<td>" + machine.dateAchat + "</td>");
                    
                    tbody.append(row);
                }
            });
        }
    });
});
$(document).ready(function () {
    // ... Votre code existant

    // Fonction pour confirmer la suppression
    function confirmerSuppression(id) {
        var confirmation = window.confirm("Voulez-vous vraiment supprimer cette machine ?");
        if (confirmation) {
            // Effectuez la suppression en utilisant une requête AJAX
            $.ajax({
                url: 'MachineByMarqueController?op=delete&id=' + id,
                type: 'GET', // Vous pouvez ajuster le type de requête en fonction de votre backend
                success: function (data) {
                    // Mettez à jour le tableau ou effectuez d'autres actions après la suppression
                    // Ici, vous pouvez recharger la liste des machines mises à jour
                    $("#marque").change();
                },
                error: function (jqXHR, textStatus, errorThrown) {
                    console.log(textStatus);
                }
            });
        } else {
            alert("Suppression annulée.");
        }
    }

    // Écoutez le clic sur les liens de suppression
    $("#body").on('click', '.bndelete', function (e) {
        e.preventDefault(); // Empêche le lien de naviguer vers une autre page
        var id = $(this).data("machineid"); // Récupérez l'ID de la machine à supprimer
        confirmerSuppression(id); // Appelez la fonction de confirmation
    });
});

