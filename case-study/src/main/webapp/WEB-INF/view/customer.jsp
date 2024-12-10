<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="com.example.casestudy.model.Customer" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
    <title>Management System Events</title>
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
                        <th></th>
                    </tr>
                    </thead>
                    <tbody>
                    <%
                        List<Customer> customerList = (List<Customer>) request.getAttribute("customers");
                        for(Customer customer : customerList) {
                    %>
                    <tr>
                        <th scope="row"><%= customer.getId()%></th>
                        <td> <%= customer.getName() %></td>
                        <td> <%= customer.getEmail() %></td>
                        <td> <%= customer.getPhone() %></td>
                        <% if (customer.getStatus()){ %>
                        <td>Paid</td>
                        <% } else {%>
                        <td>Not Yet</td>
                        <% } %>
                        <td> <%= customer.getTimeBook() %></td>
                        <td> <%= customer.getTicketType() %></td>
                        <td> <%= customer.getTicketsNumber() %></td>
                        <td> <%= customer.getEventName() %></td>
                        <% if (!customer.getStatus()){
                        %>
                        <td>
                            <button type="button"  class="btn btn-danger bi bi-trash3" data-bs-toggle="modal"
                                    data-bs-target="#deleteCustomerModal"
                                    onclick="deleteCustomer(
                                        <%=
                                           customer.getId()
                                        %>
                                            )"></button>
                        </td>
                        <%
                        }else{
                        %>
                        <td>
                            <button type="button" disabled class="btn btn-danger bi bi-trash3" data-bs-toggle="modal"></button>
                        </td>

                        <td>
                            <% if (customer.getStatus()) { %>
                            <form action="${pageContext.request.contextPath}/sendMail" method="post">
                                <input type="hidden" name="email" value="<%= customer.getEmail() %>" />
                                <input type="hidden" name="name" value="<%= customer.getName() %>" />
                                <input type="hidden" name="eventName" value="<%= customer.getEventName() %>" />
                                <input type="hidden" name="ticketsNumber" value="<%= customer.getTicketsNumber() %>" />
                                <button type="submit" class="btn btn-primary bi-envelope-arrow-up"></button>
                            </form>
                            <% } %>
                        </td>
                        <%
                                }
                            }
                        %>
                    </tr>
                    </tbody>
                </table>
            </div>
            <%@include file="/WEB-INF/include/logOut.jsp" %>
            <%@include file="/WEB-INF/include/deleteCustomer.jsp" %>
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
    </div>
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
<script>
    function deleteCustomer(customerStatus, customerId) {
        document.getElementById("deleteCustomerStatus").value = customerStatus;
        document.getElementById("deleteCustomerId").value = customerStatus;
    }
</script>
</html>
