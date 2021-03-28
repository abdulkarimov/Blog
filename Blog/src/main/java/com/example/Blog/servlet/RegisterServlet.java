package com.example.Blog.servlet;

import com.example.Blog.dao.DbManager;
import com.example.Blog.entity.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("register.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String email = request.getParameter("email");
        String full_name = request.getParameter("full_name");
        String password = request.getParameter("password");
        String password2 = request.getParameter("password2");


        String redirect = "/register?error=1";

        if(!password.equals(password2))
        {
            redirect = "/register?error=2";
        }

        User user = null;

        try {
            user = DbManager.getUserByEmail(email);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


        if(user == null )
        {
            try {
                redirect = "/home";
                DbManager.addUser(email,full_name,password);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }





        response.sendRedirect(redirect);
    }
}
