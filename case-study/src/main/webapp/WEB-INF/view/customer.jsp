<%--
  Created by IntelliJ IDEA.
  User: nthan
  Date: 12/2/2024
  Time: 4:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <%@ include file="/WEB-INF/include/header.jsp" %>
</head>
<body>
<div class="container-fluid">
    <div class="row flex-nowrap">
        <%@ include file="/WEB-INF/include/sidebar.jsp" %>
        <div class="col py-3">
            <%@include file="/WEB-INF/include/search.jsp" %>
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
                    <th scope="col">Time_Book</th>
                    <th scope="col">Type Ticket</th>
                    <th scope="col">Number of Tickets</th>
                    <th scope="col">Event Name</th>
                    <th scope="col">Action</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="customer" items="${customers}" varStatus="c">
                    <tr>
                        <th scope="row">${customer.id}</th>
                        <td>${customer.name}</td>
                        <td>${customer.email}</td>
                        <td>${customer.phone}</td>
                        <td>${customer.status ? 'Paid' : 'Not Yet'}</td>
                        <td>${customer.timeBook}</td>
                        <td>${customer.ticketType}</td>
                        <td>${customer.ticketsNumber}</td>
                        <td>${customer.eventName}</td>
                        <td>
                            <c:if test="${customer.status}">
                                <form action="${pageContext.request.contextPath}/sendMail" method="post">
                                    <input type="hidden" name="email" value="${customer.email}" />
                                    <input type="hidden" name="name" value="${customer.name}" />
                                    <input type="hidden" name="eventName" value="${customer.eventName}" />
                                    <input type="hidden" name="ticketsNumber" value="${customer.ticketsNumber}" />
                                    <button type="submit" class="btn btn-primary">Send Email</button>
                                </form>
                            </c:if>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
            <%@include file="../include/deleteConfirm.jsp"%>
            <div class="toast-container position-fixed bottom-0 end-0 p-3">
                <c:if test="${not empty sessionScope.message}">
                    <div id="emailToast" class="toast align-items-center text-bg-${sessionScope.alertType} border-0" role="alert" aria-live="assertive" aria-atomic="true">
                        <div class="d-flex">
                            <div class="toast-body">
                                    ${sessionScope.message}
                            </div>
                            <button type="button" class="btn-close me-2 m-auto" data-bs-dismiss="toast" aria-label="Close"></button>
                        </div>
                    </div>
                </c:if>

                <%
                    session.removeAttribute("message");
                    session.removeAttribute("alertType");
                %>
            </div>
        </div>
    </div
</div>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"></script>
<script>
    document.addEventListener('DOMContentLoaded', function () {
        const toastElement = document.getElementById('emailToast');
        if (toastElement) {
            const toast = new bootstrap.Toast(toastElement);
            toast.show();
        }
    });
</script>
</html>