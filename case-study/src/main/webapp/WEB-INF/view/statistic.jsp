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
        <h2>Statistic</h2>
        <div class="d-flex justify-content-left align-items-center mb-3 mt-3">
          <a href="<%= request.getContextPath() %>/exportStatistics?action=export" class="btn btn-primary bi bi-file-earmark-arrow-down"></a>
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
    </div>
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

</script>
</html>