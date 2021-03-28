<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Login</title>
    <%@include file="template/head.jsp" %>
</head>
<body>
<%@include file="template/navbar.jsp" %>

<div class="containter mt-5">
    <div class="row">
        <div class="col-sm-4 offset-4">
            <%
                Object error = request.getParameter("error");
                if (error != null && error.equals("1")) {
            %>
            <div class="alert alert-warning ">
                <strong>old password is incorrect</strong>
                <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
            </div>
            <%
                }
                else if (error != null && error.equals("2")){
            %>

            <div class="alert alert-warning ">
                <strong>Password mismatch</strong>
                <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
            </div>

            <%
                }
            %>



            <div class="row">
                <div class="col-sm-6 offset-3">
                    <div class="card">
                        <img src="avatars/image.png" class="card-img-top">
                    </div>
                    <form action="/updateAva" method="post" enctype="multipart/form-data">
                        <div class="form-group">
                            <label for="exampleFormControlFile1">Example file input</label>
                            <input type="file" class="form-control-file" id="exampleFormControlFile1" name="avatar">
                        </div>
                        <div class="form-group  mt-2">
                            <div class="btn btn-sm btn-success">
                                Update Avatar
                            </div>
                        </div>


                    </form>
                </div>
            </div>


            <form action="/userData" method="post" class="row g-3">
                <div class="col-md-6">
                    <label for="inputEmail4" class="form-label">Email</label>
                    <input type="email" class="form-control" id="inputEmail4" required value="<%=user.getEmail()%> "
                           name="email" readonly>
                    <%--request.getSession().getAttribute("USER") != null ? request.getAttribute("email") : ""--%>
                </div>

                <div class="col-12">
                    <label for="inputAddress" class="form-label">Full_Name</label>
                    <input type="text" class="form-control" id="inputAddress" name="full_name">
                </div>

                <div class="form-group">
                    <button class="btn btn-success">OK</button>
                </div>

            </form>


            <form action="/updatePassword" method="post" class="row g-3">
                <div class="col-md-6">
                    <label class="form-label">Current password</label>
                    <input type="password" class="form-control" name="password1">
                </div>
                <div class="col-md-6">
                    <label class="form-label">New Password</label>
                    <input type="password" class="form-control" name="password2">

                    <label class="form-label">Repeat New Password</label>
                    <input type="password" class="form-control" name="password3">
                </div>

                <div class="form-group">
                    <button class="btn btn-success">OK</button>
                </div>

            </form>
            >

        </div>
    </div>
</div>


</body>
</html>
