/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nerdbook;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import nerdbook.classi.Group;
import nerdbook.classi.GroupFactory;
import nerdbook.classi.User;
import nerdbook.classi.UserFactory;

/**
 *
 * @author Giacomo
 */
public class Profilo extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        
        HttpSession session = request.getSession(false);
        
        if(session != null && 
           session.getAttribute("loggedIn")!= null &&
           session.getAttribute("loggedIn").equals(true)){
            
            String user = request.getParameter("user");
            boolean submittedButton = request.getParameter("submit") != null;
            
            int userID;

            if(user != null){
                userID = Integer.parseInt(user);
            } 
            else {
                Integer loggedUserID = (Integer)session.getAttribute("loggedUserID");
                userID = loggedUserID;
            }
            
            User utente = UserFactory.getInstance().getUserById(userID);
            if(utente != null){
                request.setAttribute("utente", utente);
                
                List<User> friends = UserFactory.getInstance().getUserFriends(utente);
                request.setAttribute("friends", friends);
                
                List<Group> groups = GroupFactory.getInstance().getGroupsList(utente);
                request.setAttribute("groups", groups);
                
                if(submittedButton == true)
                    request.setAttribute("confirmed", true);

                request.getRequestDispatcher("profilo.jsp").forward(request, response);
                return;
            }
            else {
                response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            }
        }
        else {
            request.setAttribute("notLoggedIn", true);
            request.getRequestDispatcher("login.jsp").forward(request, response);
            return;
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
        processRequest(request, response);
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