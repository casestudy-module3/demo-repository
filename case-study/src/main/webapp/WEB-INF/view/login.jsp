<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="<c:url value='/css/style.css' />">
</head>
<body>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<div class="wrapper fadeInDown">
    <div id="formContent">
        <div class="fadeIn first">
            <img src="https://static.vecteezy.com/system/resources/thumbnails/002/318/271/small_2x/user-profile-icon-free-vector.jpg" id="icon" alt="User Icon" />
        </div>
        <form method="post" action="logins?action=login">
            <input type="text" id="login" class="fadeIn second" name="user_name" placeholder="User name">
            <input type="password" id="password" class="fadeIn third" name="password" placeholder="Password">
            <input type="hidden"  value="login" name ="action">
            <input type="submit" class="fadeIn fourth" value="Log In">
            <div class="alert" style="color: red; font-weight: bold;">
                <c:if test="${not empty message}">
                    ${message}
                </c:if>
            </div>
        </form>
        <div id="formFooter">
            <a class="underlineHover" href="#">Forgot Password?</a>
        </div>
    </div>
</div>
</body>
</html>