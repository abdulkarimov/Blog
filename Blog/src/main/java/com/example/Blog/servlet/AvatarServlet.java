package com.example.Blog.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

@WebServlet("/updateAva")
@MultipartConfig(
        fileSizeThreshold   = 1024 * 1024 * 1,  // 1 MB
        maxFileSize         = 1024 * 1024 * 10, // 10 MB
        maxRequestSize      = 1024 * 1024 * 15, // 15 MB
        location            = ""
)
public class AvatarServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Part part = request.getPart("avatar");
        try (InputStream fileInput = part.getInputStream()) {
            String path = getServletContext().getRealPath("/avatars");
            File file = new File(path + "/" + part.getSubmittedFileName());
            Files.copy(fileInput, file.toPath(), StandardCopyOption.REPLACE_EXISTING);
        }
        catch (Exception e)
            {
                e.printStackTrace();
            }

    }
}
