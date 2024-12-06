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
                <h2>Events</h2>
                <table class="table table-responsive">
                    <thead>
                    <tr>
                        <th scope="col">#</th>
                        <th scope="col">Name Event</th>
                        <th scope="col">Time</th>
                        <th scope="col">Image Event</th>
                        <th scope="col" class="d-none d-md-table-cell">Location</th>
                        <th scope="col" class="d-none d-md-table-cell">Description</th>
                        <th scope="col">Status</th>
                        <th scope="col">Ticket To Buy</th>
                        <th scope="col" colspan="2">Action</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="event" items="${events}" varStatus="c">
                        <tr>
                            <th scope="row">${event.idEvents}</th>
                            <td>${event.eventName}</td>
                            <td>${event.eventStart}</td>
                            <td><img src="${event.imgEvent}" alt="Event Image" class="w-70 text-center" width="50"></td>
                            <td>${event.location}</td>
                            <td>${event.description}</td>
                            <td>${event.isStatus ? 'Active' : 'Inactive'}</td>
                            <td>${event.ticketToSell}</td>
                            <td>
                                <button type="button" class="btn btn-warning bi bi-pen"
                                        data-bs-toggle="modal"
                                        data-bs-target="#updateEventModal"
                                        onclick="setIdUpdate(${event.idEvents})">
                                </button>
                            </td>

                            <td>
                                <button type="button" class="btn btn-danger bi bi-trash3" data-bs-toggle="modal"
                                        data-bs-target="#deleteEventModal"
                                        onclick="setEventId(${event.idEvents})"></button>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
<%@include file="/WEB-INF/include/deleteEvent.jsp" %>
<%@include file="/WEB-INF/include/addEvent.jsp" %>
<%@include file="/WEB-INF/include/update.jsp" %>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"></script>
<script>
    function setEventId(eventId) {
        document.getElementById("deleteEventId").value = eventId;
    }
    function setIdUpdate(eventId) {
        document.getElementById("editEventId").value = eventId;
    }
</script>

</html>