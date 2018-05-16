<!DOCTYPE html>
<html>
<head>
    <title>Expense Reimbursement System</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>

<% request.getSession().getAttribute(""); %>

<div class="container">
    <nav class="navbar navbar-expand navbar-dark bg-dark">
        <a class="navbar-brand" href="./index.jsp">ERS</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse">
            <span class="navbar-toggler-icon"></span>
        </button>
    </nav>
</div>

<div class="container">

    <div class="jumbotron">

        <h1 class="display-4" align="center">Expense Reimbursement System</h1>

    </div>

</div>

<div class="container">

    <div class="container col-md-4 offset-md-4">

        <form action="login.do" class="form-signin" method="post">

            <input type="text" name="loginUsername" class="form-control border-dark " placeholder="Username" required
                   autofocus>

            <br>

            <input type="password" name="loginUserpass" class="form-control border-dark" placeholder="Password"
                   required>

            <br>

            <input type="submit" class="btn btn-md btn-dark btn-block" value="Sign In">

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
