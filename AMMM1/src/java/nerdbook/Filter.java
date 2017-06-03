/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nerdbook;

import nerdbook.classi.User;
import nerdbook.classi.UserFactory;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author F4briK
 */
public class Filter extends HttpServlet {

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
        
        HttpSession session = request.getSession(false);
        
        //se la sessione esiste ed esiste anche l'attributo loggedIn impostato a true
        if(session!=null && 
           session.getAttribute("loggedIn")!=null &&
           session.getAttribute("loggedIn").equals(true))
        {
        
            String command = request.getParameter("q");
            if (command != null) 
            {
                // Verifica che commando e id siano stati impostati
                if (command.equals("search")) 
                {
                    Integer loggedUserID = (Integer)session.getAttribute("loggedUserID");
                    // Esegue la ricerca
                    List<User> listaUsers = UserFactory.getInstance().
                            getUserFriends(request.getParameter("nomeUtenteCercato"), loggedUserID);
                    
                    //Si aggiunge comunque un utente all'array se la ricerca non ha prodotto risultati
                    //per gestire successivamente questo evento nel javascript
                    if(listaUsers == null) {
                        listaUsers = new ArrayList<>();
                        User usr = new User();
                        listaUsers.add(usr);
                    }
                    request.setAttribute("listaUsers", listaUsers);

                    // Quando si restituisce del json e' importante segnalarlo ed evitare il caching
                    response.setContentType("application/json");
                    response.setHeader("Expires", "Sat, 6 May 1995 12:00:00 GMT");
                    response.setHeader("Cache-Control", "no-store, no-cache, "
                            + "must-revalidate");
                    
                    // Genero il json con una jsp
                    request.getRequestDispatcher("filter.jsp").forward(request, response);
                }
            }
        }
        else {
            request.getRequestDispatcher("Login").forward(request, response);
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
