package com.example.Blog.servlet;

import com.example.Blog.dao.DbManager;
import com.example.Blog.entity.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("login.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        User user = null;

        try {
             user = DbManager.getUserByEmail(email);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


        String redirect = "/login?error=1";

        if(user != null )
        {
            if(user.getPassword().equals(password))
            {
                redirect = "/home";
                    HttpSession session = request.getSession();
                session.setAttribute("USER",user);
            }
            else
            {
                 redirect = "/login?email =" + user.getEmail() + "&error=2";
            }
        }




        response.sendRedirect(redirect);

    }
}
