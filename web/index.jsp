<%--
  Created by IntelliJ IDEA.
  User: DELLINS
  Date: 3/6/2023
  Time: 1:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Index</title>
        <!-- Link Font Awsome CND -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css"
              integrity="sha512-5A8nwdMOWrSz20fDsjczgUidUBR8liPYU+WymTZP1lmY9G6Oc7HlZv156XqnsgNUzTyMefFTcsFH/tnJE/+xBg=="
              crossorigin="anonymous" referrerpolicy="no-referrer" />
        <link rel="stylesheet" href="styles.css">
        <link rel="stylesheet" href="responsive.css">
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Golos+Text&display=swap" rel="stylesheet">
        <style>
            * {
                padding: 0;
                margin: 0;
                box-sizing: border-box;
                font-family: monospace;
            }

            body {
                position: relative;
            }

            .header {
                position: relative;
            }

            .contain-task-bar {
                background-color: #2c3e50;
                position: fixed;
                z-index: 100;
                width: 100vw;
            }

            .task-bar {
                max-width: 1200px;
                display: flex;
                justify-content: space-between;
                align-items: center;
                margin: 0 auto;
                padding: 10px 0px;
                color: white;
            }

            .task-bar-logo>h1 {
                font-size: 25px;
            }

            .task-bar-logo {
                margin: 0px 30px;
            }

            .task-bar-menu-responsive {
                display: none;
            }

            .menu {
                list-style-type: none;
                display: flex;
                gap: 1rem;
                align-items: center;
                padding: 10px;
            }

            .menu-item {
                cursor: pointer;
                padding: 0px 20px;
                font-size: 16px;
            }

            .header-logo {
                /* background-color: #1abc9c;
                color: white;
                text-align: center;
                padding: 80px 0px; */
                /* background-image: url(image/S_maybach-hero-poster.jpg); */
            }
            .header-logo{
                position: relative;
            }
            .img-logo img{
                max-width: 100%;
            }
            .content-logo{
                position: absolute;
                left: 11%;
                top: 17%;

            }

            .logo-avatat>img {
                width: 320px;
                margin-bottom: 20px;
                margin-left: 43px;

            }

            .header-logo-content>h1 {
                font-size: 60px;
            }

            .line {
                height: 2px;
                width: 198px;
                background-color: white;
                display: inline-block;
                margin-bottom: 6.5px;
            }

            .star {
                display: inline-block;
                font-size: 21px;
                color: white;
            }

            .logo-star {
                margin-bottom: 20px;
            }

            .logo-text>p {
                font-size: 21px;
                color: white;
            }

            .main-content {
                max-width: 1200px;
                position: relative;
                margin: 40px auto;
            }

            .main-content-head {
                text-align: center;
                padding: 30px 0px;
            }

            .main-content-head h2 {
                font-size: 50px;
            }

            .line-black {
                height: 2px;
                width: 60px;
                background-color: black;
                display: inline-block;
                margin-bottom: 6.5px;
            }

            .star-black {
                display: inline-block;
                font-size: 21px;
            }

            .type-car{
                margin-bottom: 32px;
                display: flex;
                justify-content: center;
            }

            .main-product {
                display: grid;
                grid-template-columns: 1fr 1fr 1fr;
                gap: 60px;
                margin: 0px auto 60px auto;
            }

            .product-item {
                width: 100%;
                border-radius: 6px;
            }

            .about-content p {
                text-align: left;
            }

            .about {
                color: white;
                background-color: #2c3e50;
                font-size: 16px;
                text-align: center;
                padding: 60px 0px;
            }

            .about-head {
                margin: auto;
            }

            .about h2 {
                font-size: 30px;
            }

            .about-content {
                display: grid;
                grid-template-columns: 1fr 1fr;
                gap: 30px;
                max-width: 700px;
                margin: 30px auto;
            }

            .download p {
                display: inline;
            }

            .download {
                border: 1px solid white;
                border-radius: 4px;
                display: inline-block;
                padding: 10px;
                margin: auto;
                cursor: pointer;
                margin-top: 20px;
            }

            .contact {
                width: 720px;
                margin: 60px auto;
            }

            .contact-head {
                text-align: center;
            }

            #name,
            #email,
            #phone-number,
            #message {
                width: 100%;
                border: none;
                border-bottom: 1px solid black;

            }

            #name,
            #email,
            #phone-number{
                height: 35px;
            }


            .name,
            .email,
            .phone-number,
            .message {
                margin: 20px;
            }

            button {
                padding: 15px 22px;
                background-color: #2c3e50;
                border: none;
                color: white;
                border-radius: 4px;
                margin-left: 20px;
                font-size: 14px;
            }

            button:hover{
                background-color: #2c3e70;
                cursor: pointer;
            }

            form {
                margin: 40px 0px
            }

            .information {
                background-color: #2c3e50;
                color: white;
            }

            .information-content {
                max-width: 1200px;
                margin: auto;
                display: grid;
                grid-template-columns: 1fr 1fr 1fr;
                gap: 40px;
                text-align: center;
                padding: 40px;
            }

            .web-icon i {
                padding: 9px;
                border: 1px solid white;
                border-radius: 50%;
                display: inline-block;
            }

            .freelancer span {
                color: #1abc9c;
                cursor: pointer;
            }

            .footer-end {
                background-color: #1a252f;
                color: white;
                text-align: center;
                padding: 16px;
            }
            a{
                text-decoration: none;
                color: white;
            }
            a:hover{
                color: darkgrey;
            }
            a:visited{
                text-decoration: none;
                color: white;
            }
            .product{
                border: 3px solid #2c3e50;
                border-radius: 7px;
            }
        </style>
    </head>

    <body>
        <div class="header">
            <div class="contain-task-bar">
                <div class="task-bar">
                    <div class="task-bar-logo">
                        <h1>
                            <a href="#top">
                                Mercedes-Benz
                            </a>
                        </h1>
                    </div>
                    <div class="task-bar-menu">

                        <ul class="menu">
                            <li class="menu-item"><a href="LogoutServlet">LOGOUT</a></li>
                            <li class="menu-item"><a href="#footer">ABOUT</a></li>
                            <li class="menu-item"> <a href="#contact">CONTACT</a></li>
                                <%
                                    if (session.getAttribute("adminSession") != null) {
                                %>
                            <li class="menu-item"> <a href="AddProduct.jsp">PRODUCT</a></li>
                                <%}%>




                        </ul>
                    </div>
                    <div class="task-bar-menu-responsive">
                        <button>MENU <i class="fa fa-bars" aria-hidden="true"></i></button>
                    </div>
                </div>
            </div>
            <div class="header-logo" id="top">
                <div class="img-logo">
                    <img src="image/S_maybach-hero-poster.jpg" alt="NOT FOUND">
                </div>
                <div class="content-logo">
                    <div class="logo-avatat">
                        <img src="image/Mercedes-Benz-Logo-PNG010.png" alt="Header Logo">
                    </div>
                    <div class="header-logo-content" style="background-color: aliceblue;opacity: 0.6;border-radius: 2px;">
                        <h1> Mercedes-Benz </h1>
                    </div>
                    <div class="logo-star">
                        <div class="line"></div>
                        <div class="star"><i class="fa fa-star" aria-hidden="true"></i></div>
                        <div class="line"></div>
                    </div>
                    <div class="logo-text">
                        <p>
                            Car - Web Designer - Illustrator
                        </p>
                    </div>
                </div>

            </div>
        </div>

        <div class="main-content">
            <div class="main-content-head">
                <h2>
                    Mercedes-Benz Models
                </h2>
                <div class="logo-star-black">
                    <div class="line-black"></div>
                    <div class="star-black"><i class="fa fa-star" aria-hidden="true"></i></div>
                    <div class="line-black"></div>
                </div>
            </div>
            <div class="type-car">
                <button onclick="showElements()">All Car</button>
                <button onclick="showElectric()">Electric Car</button>
                <button onclick="showHybrid()">Hybrid Car</button>
                <button onclick="showGasoline()">Gasoline Car</button>
            </div>
            <div class="main-product">          

                <c:forEach items="${requestScope.productList}" var="product">
                    <div  onmouseover="callHover${product.productId}()" onmouseleave="deleteHover${product.productId}()" class="product ${product.productType}">

                        <div style="position: relative;">
                            <img src="${product.productURLImg}" alt="Cabin" class="product-item">
                            <div style="font-family: 'Golos Text';position: absolute;top: 0px;background-color: #2c3e50;display: none;font-size: 16px;color: whitesmoke;width: 100%" id="car${product.productId}">
                                <p>Car's Name: ${product.productName}</p>
                                <p>Price: ${product.productPrice}$</p>
                                <p>Car's Type: ${product.productType}</p>
                                <p>Description: ${product.productDes}</p>
                            </div>
                        </div>
                    </div>
                </c:forEach>



            </div>
        </div>

        <div class="footer" id="footer">
            <div class="about">
                <div class="about-head">
                    <h2>ABOUT</h2>
                    <div class="logo-star">
                        <div class="line"></div>
                        <div class="star"><i class="fa fa-star" aria-hidden="true"></i></div>
                        <div class="line"></div>
                    </div>
                </div>
                <div class="about-content">
                    <p>Lorem ipsum, dolor sit amet consectetur adipisicing elit. Eum laudantium eos enim nulla possimus?
                        Architecto, non laudantium? Magni assumenda obcaecati, harum id animi quam nam consequuntur
                        laboriosam mollitia doloremque unde.</p>
                    <p>Lorem ipsum dolor sit, amet consectetur adipisicing elit. Corrupti ratione repellat non odit rem, ab
                        dolores soluta laudantium sit qui porro. Consequatur soluta excepturi nihil et ab at? Obcaecati,
                        eaque.</p>
                </div>
                <div class="download">
                    <i class="fa fa-download" aria-hidden="true"></i>
                    <p>Free Download!</p>
                </div>
            </div>
            <div class="contact" id="contact">
                <div class="contact-head">
                    <h2>CONTACT ME</h2>
                    <div class="logo-star-black">
                        <div class="line-black"></div>
                        <div class="star-black"><i class="fa fa-star" aria-hidden="true"></i></div>
                        <div class="line-black"></div>
                    </div>
                </div>
                <form action="">
                    <div class="name">
                        <label for="name">Name</label>
                        <input type="text" name="name" id="name">
                    </div>
                    <div class="email">
                        <label for="email">Email Address</label>
                        <input type="email" name="email" id="email">
                    </div>
                    <div class="phone-number">
                        <label for="phone-number">Phone Number</label>
                        <input type="text" name="phone-number" id="phone-number">
                    </div>
                    <div class="message">
                        <label for="message">Message</label>
                        <textarea name="message" id="message" cols="30" rows="10"></textarea>
                    </div>
                    <button type="submit">Send</button>
                </form>
            </div>
            <div class="information">
                <div class="information-content">
                    <div class="location">
                        <h3>LOCATION</h3>
                        <P>2215 John Daniel Drive Clark, MO 65243</P>
                    </div>
                    <div class="web">
                        <h3>AROUNF THE WEB</h3>
                        <div class="web-icon">
                            <i class="fa fa-facebook" aria-hidden="true"></i>
                            <i class="fa fa-twitter" aria-hidden="true"></i>
                            <i class="fa fa-instagram" aria-hidden="true"></i>
                        </div>
                    </div>
                    <div class="freelancer">
                        <h3>ABOUT FREELANCER</h3>
                        <p>Lorem, ipsum dolor sit amet consectetur adipisicing elit. Incidunt, quae harum perspiciatis culpa
                            voluptate exped <span>Start Bootstrap</span>.</p>
                    </div>
                </div>
            </div>
            <p class="footer-end">Copyright <i class="fa fa-copyright" aria-hidden="true"></i> Your Website 21020</p>
        </div>

        <script>
            function showElements() {
                const elements = document.querySelectorAll('.Car');
                for (let i = 0; i < elements.length; i++) {
                    elements[i].style.display = 'block';
                }
            }

            function showElectric() {
                
                const elements2 = document.querySelectorAll('.Car');
                for (let i = 0; i < elements2.length; i++) {
                    elements2[i].style.display = 'none';
                }
                
                const elements = document.querySelectorAll('.Electric');
                for (let i = 0; i < elements.length; i++) {
                    elements[i].style.display = 'block';
                }
            }
            
            function showHybrid() {
                
                const elements2 = document.querySelectorAll('.Car');
                for (let i = 0; i < elements2.length; i++) {
                    elements2[i].style.display = 'none';
                }
                
                const elements = document.querySelectorAll('.Hybrid');
                for (let i = 0; i < elements.length; i++) {
                    elements[i].style.display = 'block';
                }
            }
            
            function showGasoline() {
                
                const elements2 = document.querySelectorAll('.Car');
                for (let i = 0; i < elements2.length; i++) {
                    elements2[i].style.display = 'none';
                }
                
                const elements = document.querySelectorAll('.Gasoline');
                for (let i = 0; i < elements.length; i++) {
                    elements[i].style.display = 'block';
                }
            }

            <c:forEach items="${requestScope.productList}" var="product">
            function callHover${product.productId}() {
                document.getElementById("car${product.productId}").style.display = 'block'
            }

            function deleteHover${product.productId}() {
                document.getElementById("car${product.productId}").style.display = 'none'
            }
            </c:forEach>



        </script>
    </body>

</html>
