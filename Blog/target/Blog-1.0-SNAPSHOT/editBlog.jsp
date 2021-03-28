<%@ page import="java.util.List" %>
<%@ page import="com.example.Blog.entity.Blog" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <%@include file="template/head.jsp" %>
    <script src="https://cdn.tiny.cloud/1/no-api-key/tinymce/4/tinymce.min.js" referrerpolicy="origin"></script>
    <script>tinymce.init({selector:'#exampleFormControlTextarea1'});</script>
</head>
<body>
<%@include file="template/navbar.jsp" %>
<form action="/edit" method="post" class="row g-3">
    <%
       Blog blogs = (Blog) request.getAttribute("editBlog");
    %>

    <div class="col-sm-4 offset-4">
        <div class="mb-3">
            <label for="exampleFormControlInput1" class="form-label">Title</label>
            <input name="title" type="text" class="form-control" id="exampleFormControlInput1" value="<%=blogs.getTitle()%>">
        </div>
        <div class="mb-3">
            <label for="exampleFormControlTextarea1" class="form-label">Content</label>
            <textarea name="content" class="form-control" id="exampleFormControlTextarea1" rows="3"><%=blogs.getContent()%></textarea>
        </div>
        <div class="form-group">
            <input type="hidden" value="<%=blogs.getId()%>" name="editBlog">

            <button class="btn btn-success">OK</button>
        </div>
    </div>

</form>>

</body>
</html>
