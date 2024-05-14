/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.emergentes.controlador;

import com.emergentes.dao.BlogPostDAO;
import com.emergentes.dao.BlogPostDAOimpl;
import com.emergentes.modelo.BlogPost;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Inicio", urlPatterns = {"/inicio"})
public class Inicio extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Inicio</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Inicio at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try{
            BlogPostDAO dao = new BlogPostDAOimpl();
            int id;
            BlogPost bp = new BlogPost();
            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
            
            switch(action){
                case "add":
                    request.setAttribute("blogpost", bp);
                    request.getRequestDispatcher("frmblogpost.jsp"). forward(request, response);
                    break;
                case "edit":
                    id = Integer.parseInt(request.getParameter("id"));
                    bp = dao.getById(id);
                    System.out.println(bp);
                    request.setAttribute("blogpost", bp);
                    request.getRequestDispatcher("frmblogpost").forward(request, response);
                    break;
                case "delete":
                    id = Integer.parseInt(request.getParameter("id"));
                    dao.delete(id);
                    response.sendRedirect(request.getContextPath()+"/inicio");
                    break;
                case "view":
                    List<BlogPost> lista = dao.getAll();
                    request.setAttribute("blogposts", lista);
                    request.getRequestDispatcher("index.jsp").forward(request,response);
                default:
                    break;
            }
        } catch (Exception ex){
            System.out.println("Error "+ ex.getMessage());
        }
    }
   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String fecha = request.getParameter("fecha");
        String titulo = request.getParameter("titulo");
        String contenido = request.getParameter("contenido");
        
        BlogPost bp = new BlogPost();
        
        bp.setId(id);
        bp.setFecha(fecha);
        bp.setTitulo(titulo);
        bp.setContenido(contenido);
        
        if(id==0){
            try{
                BlogPostDAO dao = new BlogPostDAOimpl();
                dao.insert(bp);
                response.sendRedirect(request.getContextPath()+"/inicio");
            } catch (Exception ex){
                System.out.println("Error "+ ex.getMessage());
            }
        }else{
            try{
                BlogPostDAO dao = new BlogPostDAOimpl();
                dao.update(bp);
                response.sendRedirect(request.getContextPath()+"/inicio");
            } catch (Exception ex){
                System.out.println("Error en Post"+ ex.getMessage());
            }
        }
            
    }        

}
