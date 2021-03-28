package com.example.Blog.servlet;

import com.example.Blog.dao.DbManager;
import com.example.Blog.entity.Blog;
import com.example.Blog.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

@WebServlet("/edit")
public class EditServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Long id = Long.parseLong(request.getParameter("edit"));

        Blog blog = null;

        try {
           blog = DbManager.edit(id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }



        if(blog!=null) {
            request.setAttribute("editBlog", blog);
            request.getRequestDispatcher("editBlog.jsp").forward(request, response);
        }




    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String title = request.getParameter("title");
        String content = request.getParameter("content");
        LocalDate date = LocalDate.now();
        Long id = Long.parseLong(request.getParameter("editBlog"));


        try {
            DbManager.updateBlog(title,content,date,id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


        response.sendRedirect("/home");

    }
}
