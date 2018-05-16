<%--
  Created by IntelliJ IDEA.
  User: kirkl
  Date: 5/14/2018
  Time: 00:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.revature.model.Employee" %>
<%
    Employee employee = (Employee) request.getSession().getAttribute("authorizedEmployee");
%>
<html>
<head>
    <title><%=employee.getUsername()%>'s Info </title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>

<div class="container">

    <nav class="navbar navbar-expand navbar-dark bg-dark">

        <a class="navbar-brand" href="./index.jsp">ERS</a>

        <button class="navbar-toggler" type="button" data-toggle="collapse">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse">

            <ul class="navbar-nav mr-auto">

                <li class="nav-item">
                    <a class="nav-link" href="./<%=employee.getRole().replaceAll(" ","")%>Home.jsp"> Home <span
                            class="sr-only">(current)</span></a>
                </li>

                <li class="nav-item dropdown">

                    <a class="nav-link dropdown-toggle" href="#" id="reimbursementDropdownMenuLink"
                       data-toggle="dropdown"
                       aria-haspopup="true" aria-expanded="false">
                        Reimbursement
                    </a>

                    <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                        <form id=viewMyReimbursement action="./myReimbursement.do" method="post">
                            <a class="dropdown-item" onclick="document.getElementById('viewMyReimbursement').submit();"
                               href="#">View Reimbursements</a>
                        </form>
                    </div>

                </li>

                <li class="nav-item dropdown active">

                    <a class="nav-link dropdown-toggle" href="#" id="accountDropdownMenuLink" data-toggle="dropdown"
                       aria-haspopup="true" aria-expanded="false">
                        Account
                    </a>

                    <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">

                        <form id=viewMyInfo action="./myInfo.do" method="post">
                            <a class="dropdown-item" onclick="document.getElementById('viewMyInfo').submit();" href="#">View/Edit Info</a>
                        </form>

                    </div>

                </li>

            </ul>

            <form action="./logout.do" class="form-logout my-2 my-lg-0" method="post">
                <button class="btn btn-danger my-2 my-sm-0" type="submit">Logout</button>
            </form>

        </div>

    </nav>

</div>

<div class="container">
    <ol class="breadcrumb">
        <li class="breadcrumb-item">Home</li>
        <li class="breadcrumb-item">Account</li>
        <li class="breadcrumb-item active">My Info</li>
    </ol>
</div>

<div class="container">
    <div class="card-deck">
        <div class="card text-white bg-dark" style="max-width: 18rem;">
            <div class="card-header" align="center">My Info</div>
            <div class="card-body text-white">
                <h5 class="card-title">Username: <%=employee.getUsername()%>
                </h5>
                <p class="card-text">ID#: <%=employee.geteId()%>
                </p>
                <p class="card-text">First Name: <%=employee.getFirstName()%>
                </p>
                <p class="card-text">Last Name: <%=employee.getLastName()%>
                </p>
            </div>
        </div>

        <div class="card border-dark text-center">
            <div class="card-header">Edit My Info</div>
            <form action="./updateInfo.do" method="post">
                <div class="card-body text-dark">
                    <div class="input-group mb-3">
                        <div class="input-group-prepend">
                            <span class="input-group-text">Username:</span>
                        </div>
                        <input class="form-control" type="text" name="update_username" placeholder="Username"
                               required value=<%=employee.getUsername()%>>
                    </div>
                    <div class="input-group mb-3">
                        <div class="input-group-prepend">
                            <span class="input-group-text">First Name:</span>
                        </div>
                        <input class="form-control" type="text" name="update_firstname" required
                               placeholder="First Name" value=<%=employee.getFirstName()%>>
                    </div>
                    <div class="input-group mb-3">
                        <div class="input-group-prepend">
                            <span class="input-group-text">Last Name:</span>
                        </div>
                        <input class="form-control" type="text" name="update_lastname"
                               required placeholder="Last Name" value=<%=employee.getLastName()%>>
                    </div>
                    <div class="input-group mb-3">
                        <div class="input-group-prepend">
                            <span class="input-group-text">Password:</span>
                        </div>
                        <input class="form-control" type="password" name="update_userpass"
                               required placeholder="Enter New Password">
                    </div>
                    <input class="btn btn-success" type="submit"
                           name="update_submit" value="Update My Info">
                </div>
            </form>
        </div>
    </div>
</div>

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
        integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
        integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
        crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
        integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
        crossorigin="anonymous"></script>

</body>
</html>
