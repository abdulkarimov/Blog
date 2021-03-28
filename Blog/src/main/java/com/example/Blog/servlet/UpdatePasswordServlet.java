package com.example.Blog.servlet;

import com.example.Blog.dao.DbManager;
import com.example.Blog.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/updatePassword")
public class UpdatePasswordServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        request.getRequestDispatcher("userData.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        User user = (User) request.getSession().getAttribute("USER");

        String email = user.getEmail();
        String oldPass = request.getParameter("password1");
        String newPass = request.getParameter("password2");
        String newPass2 = request.getParameter("password3");


        String redirect = "/userData?email="+email+"&error=1";//страый пароль не верен


        if(user.getPassword().equals(oldPass))
        {
            if(newPass.equals(newPass2))
            {
                try {
                    DbManager.updateUserPassword(newPass,email);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                redirect = "/userData";
            }
            else
                redirect = "/userData?email="+email+"&error=2";//пароли не совпадают
        }


        response.sendRedirect(redirect);

    }
}
