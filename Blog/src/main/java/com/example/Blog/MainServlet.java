package com.example.Blog;

import com.example.Blog.dao.DbManager;
import com.example.Blog.entity.Blog;

import java.io.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet("/home")
public class MainServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException ,IOException {


        ArrayList<Blog> allBlog = null;
        try {
            allBlog = DbManager.getALLBlog();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        request.setAttribute("blogs",allBlog);

        request.getRequestDispatcher("home.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }
}