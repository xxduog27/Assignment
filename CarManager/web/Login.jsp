<%--
  Created by IntelliJ IDEA.
  User: DELLINS
  Date: 3/3/2023
  Time: 1:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Login</title>
  <!-- Required meta tags -->
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <!-- Bootstrap CSS -->
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
        integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
  <style>
    *{
      margin: 0px;
      padding: 0px;
      box-sizing: border-box;
    }

    main{
      width: 100vw;
      height: 100vh;
      background-color: #f8f8f8;
      display: flex !important;
      justify-content: center;
      align-items: center;
    }

    .card-img-top{
      background-color: #f5f5f5;
    }
    .card-img-top p{
      margin-top: 1rem;
      margin-left: 2rem;
      font-size: 20px;
      font-weight: 500;
    }

    input[type = checkbox]{
      width: 15px;
      height: 15px;
    }

    .form-group button[type = submit]{
      width: 100%;
      padding: 10px 0px !important;
      border: none;
      background-color: #5cb85c;

    }

    .form-group button[type = submit] a{
      color: white;
    }

    a{
      text-decoration: none;
    }

  </style>
</head>

<body>
<main>
  <div class="card" style="width: 30rem;box-shadow: rgba(0, 0, 0, 0.16) 0px 1px 4px;;margin-bottom: 150px;">

    <div class="card-img-top">
      <p>Please Sign In</p>
    </div>
    <div class="card-body">
      <form action="UserServlet" method="post">
        <div class="form-group">
          <input type="email" name="email" class="form-control required" id="inputEmail" placeholder="E-mail" maxlength="50">
          <span class="err"></span>
        </div>
        <div class="form-group">
          <input type="password" name="password" class="form-control required" id="inputPassword" placeholder="Password" maxlength="50">
          <span class="err"></span>
        </div>
        <div class="form-group">
          <input type="checkbox" id="remember" aria-label="Checkbox for following text input">
          <label for="remember">Login With Admin Rights </label>
        </div>
        <div class="form-group">
          <button type="submit" class="btn btn-primary">Sign in</button>
        </div>
        <div class="form-group">
          <a href="Register.jsp">Click here to Register</a>
        </div>
      </form>
    </div>
  </div>
</main>

<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.6.1.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
<script src="ajax.js"></script>
</body>
</html>
