
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.Blog.entity.Blog" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="template/head.jsp" %>
</head>
<body>
<div class="container-fluid">
    <%@include file="template/navbar.jsp" %>
</div>

<%

    ArrayList<Blog> blogs = (ArrayList) request.getAttribute("blogs");


    for (Blog u : blogs) {

%>
<div class="card">
    <div class="card-body">
        <h5 class="card-title"><%=u.getTitle() %>
        </h5>
        <p class="card-text"><%=u.getContent()%>
        </p>
        <h6 class="card-subtitle mb-2 text-muted"><%=u.getAuthor().getFullName()%>       <%=u.getDate()%>
        </h6>
        <%

            if(user!=null)
            {
                if(u.getAuthor().getId().equals(user.getId()))
                {
        %>
        <form method="post" action="/delete">
            <div class="form-group">
                <input type="hidden" value="<%=u.getId()%>" name="delete">
                <button class="btn btn-success">Delete</button>
            </div>
        </form>
        <form method="get" action="/edit">
            <div class="form-group">
                <input type="hidden" value="<%=u.getId()%>" name="edit">
                <button class="btn btn-success">edit</button>
            </div>
        </form>

        <%
                }
            }
        %>

    </div>


</div>



<%
    }
%>


</body>
</html>
