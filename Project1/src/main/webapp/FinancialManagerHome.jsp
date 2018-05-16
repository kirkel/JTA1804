<%--
  Created by IntelliJ IDEA.
  User: kirkl
  Date: 5/13/2018
  Time: 22:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.revature.model.Employee" %>
<%
    Employee employee = (Employee) request.getSession().getAttribute("authorizedEmployee");
%>
<html>
<head>
    <meta charset="UTF-8">
    <title>Financial Manager Home Page</title>
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

                <li class="nav-item active">
                    <a class="nav-link" href="./FinancialManagerHome.jsp"> Home <span
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

                        <form id=manageReimbursement action="./manageReimbursement.do" method="post">
                            <a class="dropdown-item" onclick="document.getElementById('manageReimbursement').submit();"
                               href="#">Manage Reimbursements</a>
                        </form>

                    </div>

                </li>

                <li class="nav-item dropdown">

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

    <div class="jumbotron">

        <h1 class="display-4">Greetings Financial Manager, <%=employee.getFirstName()%> <%=employee.getLastName()%>!</h1>

        <p class="lead">The Expense Reimbursement System is at you service!</p>

    </div>

</div>

<div class="container col-md-4">

    <div id="EmployeeView" class="container">

        <h2 align="center">Main Menu</h2>

        <br>

        <form action="./myInfo.do" method="post">
            <button type="submit" class="btn btn-md btn-dark btn-block">View/Edit Information
            </button>
        </form>

        <br>

        <form action="./myReimbursement.do" method="post">
            <button type="submit" class="btn btn-md btn-dark btn-block">View/Request Reimbursements
            </button>
        </form>

        <br>

        <form action="./manageReimbursement.do" method="post">
            <button type="submit" class="btn btn-md btn-dark btn-block">Manage Employees/Reimbursements
            </button>
        </form>

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

</body>
</html>