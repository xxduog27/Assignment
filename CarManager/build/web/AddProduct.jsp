<%--
  Created by IntelliJ IDEA.
  User: DELLINS
  Date: 3/10/2023
  Time: 11:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">

<head>
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
            height: 125vh;
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
        .btn-primary {
            background-color: #2c3e50;
            border-color: #2c3e50;
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
            <div style="background-color: #2c3e50;color: whitesmoke">
                <p><i class="fa fa-plus" aria-hidden="true"></i> <a href="AddProduct.jsp" style="color: whitesmoke"> Add Product</a></p>
            </div>
            <div>
                <p id="viewcontent"><i class="fa fa-product-hunt" aria-hidden="true"></i> <a href=""> Edit Product</a></p>
            </div>
            <div>
                <p id="formcontent"><i class="fa fa-home" aria-hidden="true"></i> <a href="indexServlet"> Home</a></p>
            </div>
        </div>
        <div class="content">
            <div>
                <form action="AddProductServlet" method="post" enctype="multipart/form-data">
                    <div>
                        <input type="file" name="img-input" id="fileinput" accept="image/*" hidden onchange="previewFile()">
                        <div id="product-img-input" class="btn btn-primary">Thêm hình ảnh</div>
                        <img id="product-photo" style="max-height: 380px;">
                    </div>
                    <div class="form-row" >
                        <div class="form-group col-md-6">
                            <label for="product_name">Name</label>
                            <input type="text" class="form-control" id="product_name" name="product_name" placeholder="Car's Name">
                        </div>
                        <div class="form-group col-md-6">
                            <label for="type_product">Car Type</label>
                            <select id="type_product" class="form-control" name="product_type">
                                <option value="Gasoline Car" selected>Gasoline Car</option>
                                <option value="Electric Car">Electric Car</option>
                                <option value="Hybrid Car">Hybrid Car</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <div>
                            <label for="product_price">Price</label><br>
                        </div>
                        <div class="input-group mb-3">
                            <input type="text" class="form-control" placeholder="Car's Price" aria-label="Dollar amount (with dot and two decimal places)" id="product_price" name="product_price">
                            <div class="input-group-append">
                                <span class="input-group-text">$</span>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="product_des">Example textarea</label>
                        <textarea class="form-control" id="product_des" rows="3" name="product_des" placeholder="Description"></textarea>
                    </div>
                    <button type="submit" id="submitBtn" class="btn btn-primary">Submit</button>
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

<script>
    //submit button
    const input1 = document.getElementById('fileinput');
    const input2 = document.getElementById('product_name');
    const input3 = document.getElementById('product_price');
    const input4 = document.getElementById('product_des');


    submitBtn.disabled = true; // Disable the submit button by default

    function checkInputs() {
        if (input1.value && input2.value &&  input3.value &&  input4.value) { // Check if both input fields have a value
            submitBtn.disabled = false; // Enable the submit button
        } else {
            submitBtn.disabled = true; // Disable the submit button
        }
    }

    input1.addEventListener('input', checkInputs); // Add an event listener to the input fields
    input2.addEventListener('input', checkInputs);
    input3.addEventListener('input', checkInputs);
    input4.addEventListener('input', checkInputs);
    // demo img
    $("#product-img-input").on('click', function () {
        $("#fileinput").click();
    })

    $("#fileinput").on('click', function(){
        $("#product-img-input").css("display","none");
    })



    function previewFile() {
        var fileInput = document.getElementById('fileinput');
        var preview = document.getElementById('product-photo');

        var file = fileInput.files[0];
        var reader = new FileReader();

        reader.onloadend = function () {
            preview.src = reader.result;
        }

        if (file) {
            reader.readAsDataURL(file);
        } else {
            preview.src = "";
        }
    }
</script>
</body>

</html>
