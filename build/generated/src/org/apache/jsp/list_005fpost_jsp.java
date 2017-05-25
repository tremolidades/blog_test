package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import model.dto.Post;
import model.dao.PostDAO;

public final class list_005fpost_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

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

  PostDAO pstDao = new PostDAO();
  ArrayList<Post> posts = pstDao.listar();

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1>Blog</h1>\n");
      out.write("        <h3>Listar Post</h3>\n");
      out.write("        \n");
      out.write("        <table>\n");
      out.write("            <tr>\n");
      out.write("                <td>Modificar</td>\n");
      out.write("                <td>Eliminar</td>\n");
      out.write("                <td>Id Post</td>\n");
      out.write("                <td>Titulo</td>\n");
      out.write("            </tr>\n");
      out.write("            \n");
      out.write("            ");
 for(Post p : posts){ 
      out.write("\n");
      out.write("            <tr>\n");
      out.write("                    <td><a href=\"Post/buscar?id=");
      out.print(p.getId() );
      out.write("\"><img src=\"img/edit.png\" /></a></td>\n");
      out.write("                <td><a href=\"Post/eliminar?id=");
      out.print(p.getId() );
      out.write("\"><img src=\"img/delete.png\" /></a></td>\n");
      out.write("                <td>");
      out.print(p.getId() );
      out.write("</td>\n");
      out.write("                <td>");
      out.print(p.getTitulo() );
      out.write("</td>\n");
      out.write("            </tr>\n");
      out.write("            \n");
      out.write("            ");
 } 
      out.write("\n");
      out.write("        </table>\n");
      out.write("        \n");
      out.write("        <a href=\"index.html\">Volver</a>\n");
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
