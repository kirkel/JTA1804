<%--
  Created by IntelliJ IDEA.
  User: kirkl
  Date: 5/14/2018
  Time: 03:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.revature.model.Employee" %>
<%
    Employee employee = (Employee) request.getSession().getAttribute("authorizedEmployee");
%>
<html>
<head>
    <title><%=employee.getUsername()%>'s Reimbursements</title>
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
        <li class="breadcrumb-item active">My Reimbursements</li>
    </ol>
</div>

<div class="container">
    <div class="card border-dark">
        <div class="card-header bg-dark text-light">
            <h2>My Reimbursements Requests</h2>
        </div>
        <div class="card-body">
            <p>
                View by: <select class="btn btn-dark" required name="request" id="requestSelector">
                <option value="all">All Requests</option>
                <option value="pending">Pending Requests</option>
                <option value="accepted">Accepted Requests</option>
                <option value="denied">Denied Requests</option>
            </select>
                <input class="btn btn-dark" type="submit"
                       id="getRequests" value="View Requests">
            </p>
            <br>
            <table class="table align-content-center table-responsive table-striped">
                <thead class="thead-dark">
                <tr>
                    <th>Status</th>
                    <th>Category</th>
                    <th>Amount</th>
                    <th>Comment</th>
                    <th>Request Date</th>
                    <th>Resolved Date</th>
                    <th>Resolved Comment</th>
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
            <h2>Submit New Reimbursement Request</h2>
        </div>
        <div class="card-body">
            <form action="./submitReimbursement.do" method="post">
                <div class="form-group">
                    <div>
                        <p>Reimbursement Category: <select class="btn btn-dark" required name="requestCategory">
                            <option value="travel">Travel</option>
                            <option value="food">Food</option>
                            <option value="lodging">Lodging</option>
                            <option value="other">Other</option>
                        </select>
                        </p>
                    </div>
                </div>

                <div class="d-none"><input class="hidden" id="eid" type="number" name="requester_id" required
                                           value=<%=employee.geteId()%>></div>

                <div class="form-group">
                    <input class="form-control" type="number" min="0.00" step="0.01" max="9999"
                           name="reimbursementAmount" required
                           placeholder="Reimbursement Amount">
                </div>

                <div class="form-group">
                    <input class="form-control" type="text" name="comment" required
                           placeholder="Request Comment (Up to 256 Characters)">
                </div>

                <div class="form-group">
                    <input class="btn btn-dark" type="file" id="file1" name="file"/>
                </div>

                <div class="form-group">
                    <small id="passwordHelpInline" class="text-muted">Photo of receipt must be 2MB or less.
                    </small>
                </div>

                <div class="button-group">
                    <input class="btn btn-dark" type="submit"
                           name="reimbursement_request_submit" value="Submit Request">
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
<script src="./js/MyReimbursement.js" type="text/javascript"></script>

</body>
</html>
