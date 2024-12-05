<%--
  Created by IntelliJ IDEA.
  User: nthan
  Date: 12/5/2024
  Time: 3:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin Profile</title>
    <%@ include file="/WEB-INF/include/header.jsp" %>
</head>
<body>
    <div class="container-fluid">
        <div class="row flex-nowrap">
            <%@ include file="/WEB-INF/include/sidebar.jsp" %>
            <div class="col py-3">
                <div class="container my-5">
                    <div class="row">
                        <!-- Left Card -->
                        <div class="col-md-4">
                            <div class="card text-center">
                                <div class="card-body">
                                    <img src="https://via.placeholder.com/100" alt="Profile Picture" class="rounded-circle mb-3">
                                    <h5 class="card-title">John Doe</h5>
                                    <p class="card-text">Full Stack Developer<br>Bay Area, San Francisco, CA</p>
                                </div>
                            </div>
                        </div>
                        <!-- Right Card -->
                        <div class="col-md-8">
                            <div class="card">
                                <div class="card-body">
                                    <form>
                                        <div class="mb-3">
                                            <label for="fullName" class="form-label">Full Name</label>
                                            <input type="text" class="form-control" id="fullName" value="John Doe">
                                        </div>
                                        <div class="mb-3">
                                            <label for="age" class="form-label">Age</label>
                                            <input type="number" class="form-control" id="age" value="23">
                                        </div>
                                        <div class="mb-3">
                                            <label for="email" class="form-label">Email</label>
                                            <input type="email" class="form-control" id="email" value="john@example.com">
                                        </div>
                                        <div class="mb-3">
                                            <label for="phone" class="form-label">Phone</label>
                                            <input type="text" class="form-control" id="phone" value="(239) 816-9029">
                                        </div>
                                        <div class="mb-3">
                                            <label for="address" class="form-label">Address</label>
                                            <input type="text" class="form-control" id="address" value="Bay Area, San Francisco, CA">
                                        </div>
                                        <button type="submit" class="btn btn-success btn-lg bi bi-floppy"></button>
                                        <button type="button" class="btn btn-primary btn-lg bi bi-pencil-square"></button>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"></script>
</html>
