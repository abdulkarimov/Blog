<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <%@include file="template/head.jsp"%>
</head>
<body>
    <%@include file="template/navbar.jsp"%>

<div class="containter mt-5" >
    <div class="row">
        <div class="col-sm-4 offset-4">
            <%
                Object error = request.getParameter("error");
                if (error != null && error.equals("1")){
            %>
            <div class="alert alert-danger ">
                <strong>User doesn`t exist!</strong>
                <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
            </div>
            <%
                }
            %>

            <%
                if (error != null && error.equals("2")){
            %>
            <div class="alert alert-warning">
                <strong>Password doesn`t match!</strong>
            </div>
            <%
                }
            %>

            <form action="/login" method="post">
                <div class="form-group">
                    <label>EMAIL</label>
                    <input class="form-control" type="email" name="email" required >
                    <label>PASSWORD</label>
                    <input class="form-control" type="password" name="password" required>
                </div>
                <div class="form-group">
                    <button class="btn btn-success">SIGN IN</button>
                </div>
            </form>
        </div>
    </div>
</div>




</body>
</html>
