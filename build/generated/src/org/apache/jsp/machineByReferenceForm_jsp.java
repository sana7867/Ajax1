package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import ma.school.beans.Machine;
import ma.school.service.MachineService;
import ma.school.beans.Marque;
import ma.school.service.MarqueService;
import java.util.Date;
import ma.school.beans.Etudiant;
import ma.school.service.EtudiantService;

public final class machineByReferenceForm_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(2);
    _jspx_dependants.add("/template/header.jsp");
    _jspx_dependants.add("/template/menu.jsp");
  }

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("    <title>JSP Page</title>\n");
      out.write("    <link href=\"style/css.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("    <link href=\"style/csslocal.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("    <script src=\"script/jquery-3.3.1.min.js\" type=\"text/javascript\"></script>\n");
      out.write("    <script src=\"script/machineByReference.js\" type=\"text/javascript\"></script>\n");
      out.write(" \n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");
      out.write("\n");
      out.write("<div class=\"header\" style=\"height:110px;width: 100%;\">\n");
      out.write("    <img id=\"logo\" src=\"images/Logo_Ensaj.png\" alt=\"Logo Ensaj\" style=\"width:100px;height:100px;\"/>   \n");
      out.write("   \n");
      out.write("    <span id=\"horloge\" style=\"font-family: Courier New;text-align: center; width:100%;\"></span>\n");
      out.write("</div>\n");
      out.write("<script src=\"script/horloge.js\" type=\"text/javascript\"></script>\n");
      out.write("\n");
      out.write("        ");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<ul>\n");
      out.write("    <li><a class=\"active\" href=\"#home\">Home</a></li>\n");
      out.write("    <li><a href=\"etudiantForm.jsp\">Gestion des etudiants</a></li>\n");
      out.write("    <li><a href=\"marqueForm.jsp\">Gestion des marques</a></li>\n");
      out.write("    <li><a href=\"machineForm.jsp\">Gestion des machines</a></li>\n");
      out.write("    <li><a href=\"machineByMarqueForm.jsp\">Machines par marque</a></li>\n");
      out.write("    <li><a href=\"machineByReferenceForm.jsp\">Machines par référence</a></li>\n");
      out.write("    <li><a href=\"charts.jsp\">Le graphe</a></li>\n");
      out.write("</ul>");
      out.write("\n");
      out.write("\n");
      out.write("        <div class=\"content\">\n");
      out.write("            <form method=\"GET\" action=\"MachineByReferenceController\">\n");
      out.write("                <fieldset>\n");
      out.write("    <legend>Sélectionner une référence</legend>\n");
      out.write("    <table border=\"0\">\n");
      out.write("        <tr>\n");
      out.write("            <td>Référence :</td>\n");
      out.write("            <td>\n");
      out.write("                <select id=\"reference\" name=\"reference\">\n");
      out.write("                    <option value=\"0\">Choisir une référence</option>\n");
      out.write("                    ");

                        MachineService ms = new MachineService();
                        for (Machine m : ms.findAll()) {
                    
      out.write("\n");
      out.write("                    <option value=\"");
      out.print(m.getId());
      out.write('"');
      out.write('>');
      out.print(m.getReference());
      out.write("</option>\n");
      out.write("                    ");
}
      out.write("\n");
      out.write("                </select>\n");
      out.write("            </td>\n");
      out.write("        </tr>\n");
      out.write("    </table>\n");
      out.write("</fieldset>\n");
      out.write("\n");
      out.write("            </form>\n");
      out.write("                  <script>\n");
      out.write("                $(document).ready(function () {\n");
      out.write("\n");
      out.write("                    $(\"#reference\").change(function () {\n");
      out.write("                        $.ajax({\n");
      out.write("                            url: 'MachineByReferenceController',\n");
      out.write("                            data: {ref: $(this).val()},\n");
      out.write("                            type: 'POST',\n");
      out.write("                            success: function (data) {\n");
      out.write("                                var ligne = \"\";\n");
      out.write("                                for (var i = 0; i < data.length; i++) {\n");
      out.write("                                    ligne += '<tr>'\n");
      out.write("                                            + '<td>' + data[i].id + '</td>'\n");
      out.write("                                            + '<td>' + data[i].reference + '</td>'\n");
      out.write("                                            + '<td>' + data[i].prix + '</td>'\n");
      out.write("                                            + '<td>' + data[i].dateAchat + '</td>'\n");
      out.write("                                            + '<td>' + data[i].marque.libelle + '</td>'\n");
      out.write("                                            + '<td><a class=\"bndelete\" href=\"MachineController?op=delete&id=' + data[i].id + '\">Supprimer</a></td>'\n");
      out.write("                                            + '<td><a class=\"bnupdate\" href=\"\">Modifier</a></td>'\n");
      out.write("                                            + '</tr>';\n");
      out.write("                                }\n");
      out.write("                                $(\"#body\").html(ligne);\n");
      out.write("                            },\n");
      out.write("                            error: function (jqXHR, textStatus, errorThrown) {\n");
      out.write("                                console.log(textStatus);\n");
      out.write("                            }\n");
      out.write("                        });\n");
      out.write("                    });\n");
      out.write("\n");
      out.write("\n");
      out.write("                });\n");
      out.write("\n");
      out.write("\n");
      out.write("            </script>\n");
      out.write("\n");
      out.write("            ");

                MachineService mms = new MachineService();
            
      out.write("\n");
      out.write("\n");
      out.write("            <fieldset>\n");
      out.write("                <legend>Liste des Machines</legend>\n");
      out.write("                <table border=\"1\" class=\"tab\">\n");
      out.write("                    <thead>\n");
      out.write("                        <tr>\n");
      out.write("                            <th>Id</th>\n");
      out.write("                            <th>Reference</th>\n");
      out.write("                            <th>Prix</th>\n");
      out.write("                            <th>Date d'achat</th>\n");
      out.write("                            <th>Marque</th>\n");
      out.write("                            <th>Supprimer</th>\n");
      out.write("                            <th>Modifier</th>\n");
      out.write("                        </tr>\n");
      out.write("                    </thead>\n");
      out.write("                    <tbody id=\"body\"></tbody>\n");
      out.write("                </table>\n");
      out.write("            </fieldset>\n");
      out.write("        </form>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
