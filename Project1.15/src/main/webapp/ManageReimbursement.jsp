<%--
  Created by IntelliJ IDEA.
  User: kirkl
  Date: 5/14/2018
  Time: 21:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.revature.model.Employee" %>
<%
    Employee employee = (Employee) request.getSession().getAttribute("authorizedEmployee");
%>
<html>
<head>
    <title><%=employee.getUsername()%>'s Reimbursement Management Page</title>
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
                    <a class="nav-link" href="./FinancialManagerHome.jsp"> Home <span
                            class="sr-only">(current)</span></a>
                </li>

                <li class="nav-item dropdown active">

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

                        <form id=manageReimbursements action="./manageReimbursements.do" method="post">
                            <a class="dropdown-item" onclick="document.getElementById('manageReimbursements').submit();"
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
                            <a class="dropdown-item" onclick="document.getElementById('viewMyInfo').submit();" href="#">View/Edit
                                Info</a>
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
        <li class="breadcrumb-item">Reimbursement</li>
        <li class="breadcrumb-item active">Manage Reimbursements</li>
    </ol>
</div>

<div class="container">
    <div class="card border-dark">
        <div class="card-header bg-dark text-light">
            <h2>View Reimbursements Requests</h2>
        </div>
        <div class="card-body">
            <div class="input-group mb-3">
                <div class="input-group-prepend">
                    <label class="input-group-text bg-dark text-light" for="statusSelect">Status:</label>
                </div>
                <select class="custom-select" id="statusSelect">
                    <option selected>Choose status...</option>
                    <option value="all">All Requests</option>
                    <option value="pending">Pending Requests</option>
                    <option value="accepted">Accepted Requests</option>
                    <option value="denied">Denied Requests</option>
                </select>
                <div class="input-group-append">
                    <input class="btn btn-dark" type="submit"
                           onclick="getRequests()" id="getRequests" value="View Requests">
                </div>
            </div>

            <div class="input-group mb-3">
                <div class="input-group-prepend">
                    <label class="input-group-text bg-dark text-light" for="idSelect">Employee ID#:</label>
                </div>
                <input type="number" min="0" id="idSelect" class="form-control" placeholder="Enter Employee ID#...">
                <select class="custom-select" id="statusIdSelect">
                    <option selected>Choose status...</option>
                    <option value="all">All Requests</option>
                    <option value="pending">Pending Requests</option>
                    <option value="accepted">Accepted Requests</option>
                    <option value="denied">Denied Requests</option>
                </select>
                <div class="input-group-append">
                    <input class="btn btn-dark" type="submit"
                           onclick="getIdRequests()" id="getIdRequests" value="View Requests">
                </div>
            </div>

            <br>
            <table class="table align-content-center table-responsive table-striped">
                <thead class="thead-dark">
                <tr>
                    <th>Reimbursement ID#</th>
                    <th>Requester ID#</th>
                    <th>Status</th>
                    <th>Category</th>
                    <th>Amount</th>
                    <th>Request Date</th>
                    <th>Requester Comment</th>
                    <th>Resolved Date</th>
                    <th>Resolver Comment</th>
                </tr>
                </thead>
                <tbody id="requestsTable">

                </tbody>
            </table>
        </div>
    </div>
</div>

<br>

<div class="container">

    <div class="card border-dark">

        <div class="card-header bg-dark text-light">
            <h2>Approve / Deny Reimbursement Request</h2>
        </div>

        <div class="card-body">
            <form action="./resolveReimbursement.do" method="post">
                <div class="input-group">
                    <input type="number" min="0" name="rId" class="form-control col-md-3"
                           placeholder="Enter Reimbursement ID#">
                    <input type="text" class="form-control" name="deciderComment"
                           placeholder="Decision Comment (Up to 256 Characters)"
                           aria-label="" aria-describedby="basic-addon2">
                    <div class="input-group-append">
                        <select class="custom-select" name="decisionSelect">
                            <option selected>Accept or Deny</option>
                            <option value="accept">Accept</option>
                            <option value="deny">Deny</option>
                        </select>
                        <button class="btn btn-dark" type="submit">Submit</button>
                    </div>
                    <div class="d-none"><input class="hidden" id="eid" type="number" name="resolver_id" required
                                               value=<%=employee.geteId()%>></div>
                </div>
            </form>
            <small class="form-text text-muted text-danger">
                Financial Managers cannot accept or deny their own reimbursement request.
            </small>
        </div>

    </div>

</div>

<br>

<div class="container">

    <div class="card border-dark">

        <div class="card-header bg-dark text-light">
            <h2>Employees</h2>
        </div>
        <div class="card-body text-center">
                <div class="row">
                    <div class="span6" style="float: none; margin: 0 auto;">
                        <p>
                            <button class="btn btn-dark" type="button"
                                    data-toggle="collapse" data-target="#collapseEmployee">
                                Toggle Employee Information
                            </button>
                        </p>
                        <div class="collapse" id="collapseEmployee">
                            <table class="table align-content-center table-responsive table-striped">
                                <thead class="thead-dark">
                                <tr>
                                    <th>Employee ID#</th>
                                    <th>Username</th>
                                    <th>First Name</th>
                                    <th>Last Name</th>
                                    <th>Role</th>
                                </tr>
                                </thead>
                                <tbody id="employeeTable">
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>


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

<script type="text/javascript" src="./js/ManageReimbursement.js"></script>

</body>
</html>
