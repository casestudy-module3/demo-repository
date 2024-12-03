<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
  Created by IntelliJ IDEA.
  User: 84357
  Date: 12/3/2024
  Time: 11:45 AM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customer</title>
    <%@ include file="/WEB-INF/include/header.jsp"%>
</head>
<body>
<div class="container-fluid">
    <div class="row flex-nowrap">
        <%@ include file="/WEB-INF/include/sidebar.jsp" %>
        <div class="col py-3">
            <%@include file="/WEB-INF/include/search.jsp"%>
            <div class="container">
                <h2>Customer Registered</h2>
                <table class="table table-responsive">
                    <thead>
                    <tr>
                        <th scope="col">ID</th>
                        <th scope="col">Name</th>
                        <th scope="col">Email</th>
                        <th scope="col">Phone</th>
                        <th scope="col">Status</th>
                        <th scope="col">Type Ticket</th>
                        <th scope="col">Time_Book</th>
                        <th scope="col">Number of Tickets</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="customer" items="${customers}" varStatus="c">
                        <tr>
                            <th scope="row">${customer.id}</th>
                            <td>${customer.name}</td>
                            <td>${customer.email}</td>
                            <td>${customer.phone}</td>
                            <td>${customer.status}</td>
                            <td>${customer.typeTicket}</td>
                            <td>${customer.date}</td>
                            <td>${customer.numberTickets}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"></script>
</html>
