<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>

<html lang="en">

<head>
    <link rel="shortcut icon" href="image/R.jpeg" type="image/x-icon">  
    <% int count = 1;%>
    <title>Cart</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

    <!-- font awsome -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

    <!-- CSS -->
    <link rel="stylesheet" href="styleForForm.css">

    <style>
        * {
            margin: 0px;
            padding: 0px;
            box-sizing: border-box;
        }

        .css-container {
            display: flex;
        }

        .title {
            display: flex;
            justify-content: space-between;
            padding: 10px 30px 10px 20px;
            border-bottom: 1px solid black;
            background-color: #2c3e50;
            color: white;
            font-size: 33px;
        }

        .title i{
            position: relative;

        }
        .icon img{
            max-width: 100px;
        }
        .icon div{
            z-index: 1;
            position: absolute;
            right: 20px;
            border: 1px solid black;
            background-color: #f8f8f8;
        }
        .icon div p{
            padding: 10px 20px;
        }
        .title p {
            margin-bottom: 0px;
            cursor: pointer;
        }

        /* menu */
        .menu {
            background-color: #f8f8f8;
            border-right: 1px solid black;
            height: 400vh;
            width: 15vw;
        }

        .menu div {
            padding-top: 15px;
            padding-bottom: 15px;
            padding-left: 20px;
            border-bottom: 1px solid black;
        }
        .menu p{
            margin-bottom: 0px;
            cursor: pointer;
        }
        a{
            color: black;
        }
        a:hover {
            text-decoration: none;
            color: black;
        }

        /* search */
        .menu input {
            width: 80%;
            padding: 5px;
            height: 30px;
            border: none;
            border-right: 1px solid black;
        }


        .menu-search input:focus {
            border: none;
            outline: none;
        }

        .menu label {
            padding: 0px 3px;
        }

        /* content */
        .content {
            margin: 35px 40px;
            width: 75vw;
        }

        .title-form-input p {
            margin: 10px 0px;
        }

        .form-input form {
            background-color: white;
            border-radius: 0px 0px 5px 5px;
            padding-top: 10px;
        }
        .form-input button{
            padding: 5px 25px;
            background-color: white;
            border: black 1px solid;
            color: black;
        }

        .main-body-container div {
            border: 1px solid #aeaeae;
            background-color: white;
            padding: 10px;
        }



    </style>
</head>

<body>
<header>
    <div class="title">
        <p>Mercedes-Benz</p>
        <div class="icon">
            <img src="image/Mercedes-Benz-Logo-PNG010.png" alt="Logo">
        </div>

    </div>
</header>
<main>
    <div class="css-container">
        <div class="menu">
            <div>
                <p><i class="fa fa-plus" aria-hidden="true"></i> <a href="AddProduct.jsp" > Add Product</a></p>
            </div>
            <div  style="background-color: #2c3e50;color: whitesmoke">
                <p id="viewcontent"><i class="fa fa-product-hunt" aria-hidden="true" style="color: whitesmoke"></i> <a href="EditProductServlet" style="color: whitesmoke"> Edit Product</a></p>
            </div>
            <div>
                <p id="formcontent"><i class="fa fa-home" aria-hidden="true"></i> <a href="indexServlet"> Home</a></p>
            </div>
        </div>
        <div class="content">
            <div>
                <form>
                <table class="table">
                    <thead>
                    <tr>
                        <th scope="col">#</th>
                        <th scope="col">Image</th>
                        <th scope="col">Name</th>
                        <th scope="col">Price</th>
                        <th scope="col">Type</th>
                        <th scope="col">Description</th>
                        <th></th>
                    </tr>
                    </thead>
                    <tbody>

                    <c:forEach items="${requestScope.productList}" var="product">
                        <tr id="row${product.productId}">
                            <th scope="row"><%=count++%></th>
                            <td><img src="${product.productURLImg}" style="width: 300px;height: 300px;"> </td>
                            <td>${product.productName}</td>
                            <td>${product.productPrice}</td>
                            <td>${product.productType}</td>
                            <td>${product.productDes}</td>
                            <td>
                                <button type="button" id="delete" class="btn btn-danger"> <a href="<%=request.getContextPath()%>/my-product?action=delete&car-id=${product.getProductId()}" >DELETE</a> </button>
                                <button type="button" id="edit-product" class="btn btn-secondary"><a href="<%=request.getContextPath()%>/editDetails?car-id=${product.getProductId()}">EDIT</a></button>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
                </form>
            </div>
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

</body>

</html>
