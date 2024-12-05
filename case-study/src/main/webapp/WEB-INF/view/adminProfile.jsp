<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Admin Profile</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    <%@include file="../include/header.jsp" %>
    <style>
        .profile-card {
            max-width: 20rem;
            margin: 2rem;
            text-align: center;
            padding: 20px;
        }
        .profile-card img {
            width: 100px;
            height: 100px;
            border-radius: 50%;
        }
        .card-body label {
            font-weight: bold;
        }
        .info-card {
            padding: 20px;
            margin-top: 2rem;
        }
        .btn-container {
            margin-top: 20px;
        }
    </style>
</head>
<body>
<div class="container-fluid">
    <div class="row flex-nowrap" style="height: 100vh;">
        <jsp:include page="/WEB-INF/include/sidebar.jsp" />
        <div class="col d-flex justify-content-center align-items-start" style="height: 100vh;">
            <div class="profile-card card col-md-3 d-flex flex-column align-items-center" style="margin-right: 1rem; height: fit-content;">
                <img src="https://via.placeholder.com/100" alt="Profile Picture" class="mx-auto d-block">
                <div class="card-body">
                    <c:forEach var="admin" items="${admin}">
                        <h5 class="card-title">${admin.fullName}</h5>
                        <p class="card-text">${admin.position}</p>
                        <p class="card-text">${admin.address}</p>
                    </c:forEach>
                </div>
            </div>
            <div class="info-card card col-md-6" style="max-width: 45rem;">
                <div class="card-body">
                    <h5 class="card-title">Admin Profile</h5>
                    <form action="/adminProfile" method="post">
                        <c:forEach var="admin" items="${admin}">
                            <div class="form-row">
                                <div class="form-group col-md-12">
                                    <label for="fullName">Full Name:</label>
                                    <input type="text" class="form-control" id="fullName" name="fullName" value="${admin.fullName}" readonly>
                                </div>
                            </div>
                            <div class="form-row">
                                <div class="form-group col-md-6">
                                    <label for="phone">Phone Number:</label>
                                    <input type="text" class="form-control" id="phone" name="phone" value="${admin.phone}" readonly>
                                </div>
                                <div class="form-group col-md-6">
                                    <label for="dob">Date of Birth:</label>
                                    <input type="date" class="form-control" id="dob" name="dob" value="${admin.dob}" readonly>
                                </div>
                            </div>
                            <div class="form-row">
                                <div class="form-group col-md-6">
                                    <label for="gender">Gender:</label>
                                    <select class="form-control" id="gender" name="gender" disabled>
                                        <option value="Male" ${admin.gender == 'Male' ? 'selected' : ''}>Male</option>
                                        <option value="Female" ${admin.gender == 'Female' ? 'selected' : ''}>Female</option>
                                    </select>
                                </div>
                                <div class="form-group col-md-6">
                                    <label for="email">Email:</label>
                                    <input type="email" class="form-control" id="email" name="email" value="${admin.email}" readonly>
                                </div>
                            </div>
                            <div class="form-row">
                                <div class="form-group col-md-6">
                                    <label for="address">Address:</label>
                                    <input type="text" class="form-control" id="address" name="address" value="${admin.address}" readonly>
                                </div>
                                <div class="form-group col-md-6">
                                    <label for="position">Position:</label>
                                    <input type="text" class="form-control" id="position" name="position" value="${admin.position}" readonly>
                                </div>
                            </div>
                            <div class="btn-container">
                                <button type="button" class="btn btn-primary bi bi-pen btn-lg" id="editButton" name="edit" onclick="enableEditing()"></button>
                                <button type="submit" class="btn btn-success bi bi-floppy btn-lg" id="saveButton"  name="save"></button>
                            </div>
                        </c:forEach>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>
