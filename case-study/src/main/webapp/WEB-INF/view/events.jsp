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
                <h2>Events</h2>
                <table class="table table-responsive">
                    <thead>
                    <tr>
                        <th scope="col">#</th>
                        <th scope="col">Name</th>
                        <th scope="col">Time</th>
                        <th scope="col">Image</th>
                        <th scope="col" class="d-none d-md-table-cell">Location</th>
                        <th scope="col">Status</th>
                        <th scope="col">Number Ticket</th>
                        <th scope="col" colspan="3">Action</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="event" items="${events}" varStatus="c">
                        <tr>
                            <th scope="row">${event.idEvents}</th>
                            <td>${event.eventName}</td>
                            <td>${event.eventStart}</td>
                            <td><img src="${event.imgEvent}" alt="Event Image" class="w-70 text-center" width="50" onclick="previewImage('${event.imgEvent}')" style="cursor: pointer;"></td>
                            <td>${event.location}</td>
                            <td>${event.isStatus ? 'Active' : 'Inactive'}</td>
                            <td>${event.ticketToSell}</td>
                            <td>
                                <button type="button"
                                        class="btn btn-warning bi bi-pencil"
                                        data-bs-toggle="modal"
                                        data-bs-target="#updateEventModal"
                                        style="width:80px; color:white;"
                                        onclick="setEditForm(${event.idEvents}, '${event.eventName}', '${event.eventStart}', '${event.imgEvent}', '${event.location}', '${event.description}', ${event.isStatus}, ${event.ticketToSell})">
                                </button>
                                <button type="button"
                                        class="btn btn-secondary bi bi-eye-fill"
                                        data-bs-toggle="modal"
                                        data-bs-target="#viewEventModal${event.idEvents}"
                                        style="width:80px;">
                                </button>
                                <button type="button"
                                        class="btn btn-danger bi bi-trash3"
                                        data-bs-toggle="modal"
                                        data-bs-target="#deleteEventModal"
                                        style="width:80px;"
                                        onclick="setDeleteModal(${event.idEvents}, '${event.eventName}')">
                                </button>
                            </td>
                        </tr>
                        <div class="modal fade" id="viewEventModal${event.idEvents}" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="viewEventModalLabel${event.idEvents}" aria-hidden="true">
                            <div class="modal-dialog modal-dialog-centered">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <h5 class="modal-title" id="viewEventModalLabel${event.idEvents}">
                                            <c:out value="${event.eventName}" />
                                        </h5>
                                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                    </div>
                                    <div class="modal-body">
                                        <p><c:out value="${event.description}" /></p>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="modal fade" id="imagePreviewModal" tabindex="-1" aria-labelledby="imagePreviewModalLabel" aria-hidden="true">
                            <div class="modal-dialog modal-dialog-centered">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <h5 class="modal-title" id="imagePreviewModalLabel">Image Preview</h5>
                                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                    </div>
                                    <div class="modal-body text-center">
                                        <img id="previewImage" src="" alt="Event Image Preview" class="img-fluid" />
                                    </div>
                                </div>
                            </div>
                        </div>
                        <%@include file="/WEB-INF/include/deleteEvent.jsp" %>
                        <%@include file="/WEB-INF/include/addEvent.jsp" %>
                        <%@include file="/WEB-INF/include/update.jsp" %>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
            <%@include file="../include/deleteConfirm.jsp"%>
        </div>
    </div
</div>
<%@include file="/WEB-INF/include/logOut.jsp" %>

</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"></script>
<script>
    function setDeleteModal(eventId, eventName) {
        document.getElementById("deleteEventId").value = eventId;
        document.getElementById("deleteEventName").innerText = eventName;
    }
    function setIdUpdate(eventId) {
        document.getElementById("editEventId").value = eventId;
    }
    function setEditForm(id, name, startDate, img, location, description, status, tickets) {
        document.getElementById("editEventId").value = id;
        document.getElementById("editrecipient-name").value = name;
        document.getElementById("editdate-time").value = startDate;
        document.getElementById("editEventImagePreview").src = img;
        document.getElementById("editlocation-text").value = location;
        document.getElementById("editmessage-text").value = description;
        document.getElementById("editstatus").value = status ? "1" : "0";
        document.getElementById("editnumber-ticket").value = tickets;
    }
</script>
<script>
    function previewImage(imageSrc) {
        document.getElementById("previewImage").src = imageSrc;
        var imagePreviewModal = new bootstrap.Modal(document.getElementById("imagePreviewModal"));
        imagePreviewModal.show();
    }
</script>

</html>