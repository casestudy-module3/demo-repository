<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <%@ include file="include/header.jsp" %>
</head>
<body>
<div class="container-fluid">
    <div class="row flex-nowrap">
        <%@ include file="include/sidebar.jsp" %>
        <div class="col py-3">
            <%@include file="include/search.jsp"%>
            <div class="container">
                <h2>Events</h2>
            </div>
        </div>
    </div>
</div>
<%@include file="include/addEvent.jsp"%>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"></script>
</html>