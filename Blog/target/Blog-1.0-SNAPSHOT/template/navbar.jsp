<%@ page import="com.example.Blog.entity.User" %><%
    User user = (User) request.getSession().getAttribute("USER");

%>


<nav class="navbar navbar-expand-lg navbar-dark" style="background-color: mediumblue ">
    <div class="container-fluid">
        <a class="navbar-brand" href="/">Blog</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <%
                    if(user != null)
                    {
                %>
                <li class="nav-item">
                    <a class="nav-link" href = "/userData?email = <%=user.getEmail()%>"><%=user.getFullName()%></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/logout">log out</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/addBlog">addBlog</a>
                </li>
                <%
                    }
                    else{
                %>
                <li class="nav-item">
                    <a class="nav-link" href = "/register">Register</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/login">Login</a>
                </li>
                <%
                    }
                %>
            </ul>
            <form class="d-flex">
                <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                <button class="btn btn-outline-light" type="submit"><%=name%></button>
            </form>
        </div>
    </div>
</nav>