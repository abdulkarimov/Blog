package com.example.Blog.servlet;

import com.example.Blog.dao.DbManager;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("delete"));

        try {
            DbManager.delete(id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


        response.sendRedirect("/home");
    }
}
