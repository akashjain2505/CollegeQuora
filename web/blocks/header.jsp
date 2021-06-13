<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String ctx = application.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Universal College</title>
<!--
Neaty HTML Template
http://www.templatemo.com/tm-501-neaty
-->
    <!-- load stylesheets -->
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Open+Sans:300,400">  <!-- Google web font "Open Sans" -->
    <link rel="stylesheet" href="<%=ctx%>/assets/css/bootstrap.min.css">                                      <!-- Bootstrap style -->
    <link rel="stylesheet" href="<%=ctx%>/assets/css/magnific-popup.css">                                <!-- Magnific pop up style, http://dimsemenov.com/plugins/magnific-popup/ -->
    <link rel="stylesheet" href="<%=ctx%>/assets/css/templatemo-style.css">                                   <!-- Templatemo style -->

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
          <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
          <![endif]-->
</head>
    <body>   
        
        <div class="container">
            <div class="row">
                <div class="tm-left-right-container">
                    <!-- Left column: logo and menu -->
                    <div class="tm-blue-bg tm-left-column">                        
                        <div class="tm-logo-div text-xs-center">
                            <img src="<%=ctx%>/assets/img/tm-neaty-logo.png" alt="Logo">
                            <h1 class="tm-site-name">Universal</h1>
                        </div>
                        <nav class="tm-main-nav">
                            <ul class="tm-main-nav-ul">
                                <li class="tm-nav-item">
                                    <a href="<%=ctx%>/web/index.jsp" class="tm-nav-item-link">Home</a>
                                </li>
                                
                                <li class="tm-nav-item">
                                    <a href="<%=ctx%>/web/register.jsp" class="tm-nav-item-link">Register</a>
                                </li>
                                
                                <li class="tm-nav-item">
                                    <a href="<%=ctx%>/web/login.jsp" class="tm-nav-item-link">Login</a>
                                </li>
                                
                                <li class="tm-nav-item">
                                    <a href="<%=ctx%>/web/contact.jsp" class="tm-nav-item-link">Contact</a>
                                </li>
                            </ul>
                        </nav>                                         
                    </div> <!-- Left column: logo and menu -->