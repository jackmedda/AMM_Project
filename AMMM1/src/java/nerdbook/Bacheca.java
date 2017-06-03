/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nerdbook;

import nerdbook.classi.*;
import java.util.List;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Giacomo
 */
public class Bacheca extends HttpServlet {

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
           session.getAttribute("loggedIn").equals(true)) {
            
            String user = request.getParameter("user");
            String group = request.getParameter("group");
            
            int userID;
            int groupID;

            if(user != null){
                userID = Integer.parseInt(user);
            } 
            else {
                Integer loggedUserID = (Integer)session.getAttribute("loggedUserID");
                userID = loggedUserID;
            }
            
            if(group != null){
                groupID = Integer.parseInt(group);
            }
            else {
                groupID = -1;
            }
            
            Integer loggedID = (Integer)session.getAttribute("loggedUserID");
            User loggedUser = UserFactory.getInstance().getUserById(loggedID);
            
            User utente = UserFactory.getInstance().getUserById(userID);
            Group currGrp = GroupFactory.getInstance().getGroupById(groupID);
            if(currGrp != null && utente != null){
                request.setAttribute("currGrp", currGrp);
                session.setAttribute("loggedUser", loggedUser);
                
                List<Post> posts = PostFactory.getInstance().getPostList(currGrp);
                request.setAttribute("posts", posts);
                
                List<User> friends = UserFactory.getInstance().getUserFriends(loggedUser);
                request.setAttribute("friends", friends);
                
                List<Group> groups = GroupFactory.getInstance().getOtherGroups(currGrp, loggedUser);
                request.setAttribute("groups", groups);
                
                if(request.getParameter("riepilogo") != null)
                    newPost(currGrp, posts, loggedUser, request, response);               
                
                request.getRequestDispatcher("bachGroup.jsp").forward(request, response);
            }
            else if(utente != null){
                request.setAttribute("utente", utente);
                session.setAttribute("loggedUser", loggedUser);

                List<Post> posts = PostFactory.getInstance().getPostList(utente);
                request.setAttribute("posts", posts);
                
                List<User> friends = UserFactory.getInstance().getUserFriends(loggedUser);
                request.setAttribute("friends", friends);
                
                List<Group> groups = GroupFactory.getInstance().getGroupsList(loggedUser);
                request.setAttribute("groups", groups);
                
                if(request.getParameter("riepilogo") != null)
                    newPost(utente, posts, loggedUser, request, response);
                
                request.getRequestDispatcher("bacheca.jsp").forward(request, response);
            }          
        }
        else {
            request.setAttribute("notLoggedIn", true);
            request.getRequestDispatcher("login.jsp").forward(request, response);
            return;
        } 
    }   
    private void newPost(Shared sha, List<Post> posts, User loggedUser,
                         HttpServletRequest request, HttpServletResponse response) {
        String message = null;
        String image = null;
        
        switch (Integer.parseInt(request.getParameter("riepilogo"))) {
            case 1:
                message = request.getParameter("formFriendBach");
                image = request.getParameter("imagePost");
                request.setAttribute("message", message);
                request.setAttribute("image", image);
                request.setAttribute("riep", 1);
                break;
            case 2:
                request.setAttribute("riep", 2);
                
                message = request.getParameter("formFriendBach");
                image = request.getParameter("imagePost");
                
                Post post = new Post();
                if(sha instanceof User)
                    post.setShared((User)sha);
                else
                    post.setShared((Group)sha);
                post.setSharer(loggedUser);
                post.setContent(message);
                if(image.isEmpty()) {
                    post.setPostType(Post.Type.TEXT);
                }
                else {
                    post.setPostType(Post.Type.IMAGE);
                    post.setPostContent(image);
                }
                PostFactory.getInstance().addNewPost(post);
                posts.add(post);
                break;
            default:
                response.setStatus(HttpServletResponse.SC_NOT_FOUND);
                break;
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
