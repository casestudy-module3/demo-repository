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
    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
</head>
<body>
<div class="container-fluid">
    <div class="row flex-nowrap">
        <%@ include file="/WEB-INF/include/sidebar.jsp" %>
        <div class="col py-3">
            <%@include file="/WEB-INF/include/search.jsp" %>
            <div class="container">
                <h2>Statistic</h2>
                <div class="d-flex justify-content-end align-items-center mb-3 ">
                    <a href="<%= request.getContextPath() %>/exportStatistics?action=export"
                       class="btn btn-primary bi bi-file-earmark-arrow-down"></a>
                </div>
                <div class="row">
                    <c:forEach var="entry" items="${statisticsMap}">
                        <div class="col-sm-4">
                            <div class="card">
                                <div class="card-body">
                                    <h5 class="card-title fw-bold text-primary">${entry.key}</h5>
                                    <p class="card-text text-muted fs-5">${entry.value}</p>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </div>
            <div class="container">
                <h3 class="mt-3">Event Statistics Chart</h3>
                <div style="max-width: 600px; margin: auto;">
                    <canvas id="statisticChart" style="max-width: 100%; height: 300px;"></canvas>
                </div>
            </div>
        </div>
        <%@include file="../include/deleteConfirm.jsp"%>
    </div>
</div>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"></script>
<script>
  function setEventId(eventId) {
    document.getElementById("deleteEventId").value = eventId;
  }
</script>
<script>
    fetch('<%= request.getContextPath() %>/statistics?action=chartData')
        .then(response => response.json())
        .then(data => {
            const ctx = document.getElementById('statisticChart').getContext('2d');
            new Chart(ctx, {
                type: 'bar',
                data: {
                    labels: Object.keys(data),
                    datasets: [{
                        label: 'Event Statistics',
                        data: Object.values(data),
                        backgroundColor: ['rgba(75, 192, 192, 0.2)', 'rgba(153, 102, 255, 0.2)', 'rgba(255, 159, 64, 0.2)'],
                        borderColor: ['rgba(75, 192, 192, 1)', 'rgba(153, 102, 255, 1)', 'rgba(255, 159, 64, 1)'],
                        borderWidth: 1
                    }]
                },
                options: {
                    scales: {
                        y: {
                            beginAtZero: true
                        }
                    }
                }
            });
        });
</script>
</html>