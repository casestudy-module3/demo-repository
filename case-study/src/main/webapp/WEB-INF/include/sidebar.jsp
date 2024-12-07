<%--
  Created by IntelliJ IDEA.
  User: nthan
  Date: 12/2/2024
  Time: 1:34 PM
  To change this template use File | Settings | File Templates.
--%>
<div class="col-auto col-md-3 col-xl-2 px-sm-2 px-0 sidebar">
    <div class="d-flex flex-column align-items-center align-items-sm-start px-3 pt-2 text-light min-vh-100">
        <a href="/events" class="d-flex align-items-center pb-3 mb-md-0 me-md-auto text-black text-decoration-none">
            <span class="fs-2 d-none d-sm-inline">Menu</span>
        </a>
        <ul class="nav nav-pills flex-column mb-sm-auto mb-0 align-items-center align-items-sm-start " id="menu">
            <li class="nav-item">
                <a href="/events" class="nav-link align-middle px-0">
                    <i class="fs-4 bi-house"></i> <span class="ms-1 d-none d-sm-inline">Home</span>
                </a>
            </li>
            <li>
                <a href="#exampleModal" class="nav-link px-0 align-middle" data-bs-toggle="modal"
                   data-bs-target="#addEventModal" data-bs-whatever="@mdo">
                    <i class="fs-4 bi-plus-square"></i> <span class="ms-1 d-none d-sm-inline">AddEvent</span>
                </a>
            </li>

            <li>
                <a href="<%= request.getContextPath() %>/statistics" class="nav-link px-0 align-middle">
                <i class="fs-4 bi-table"></i> <span class="ms-1 d-none d-sm-inline">Statistic</span></a>
            </li>
            <li>
                <a href="/customers?action=customers" class="nav-link px-0 align-middle">
                    <i class="fs-4 bi-people"></i> <span class="ms-1 d-none d-sm-inline">Customers</span> </a>
            </li>
        </ul>
        <hr>
        <div class="dropdown pb-4">
            <a href="#" class="d-flex align-items-center text-black text-decoration-none dropdown-toggle"
               id="dropdownUser1" data-bs-toggle="dropdown" aria-expanded="false">
                <img src="https://github.com/mdo.png" alt="hugenerd" width="30" height="30" class="rounded-circle">
                <span class="d-none d-sm-inline mx-1">loser</span>
            </a>
            <ul class="dropdown-menu dropdown-menu-dark text-small shadow">
                <li><a class="dropdown-item"  href="<%= request.getContextPath() %>/adminProfile">Profile</a></li>
                <li>
                    <hr class="dropdown-divider">
                </li>
                <li><a class="dropdown-item" href="#" data-bs-toggle="modal" data-bs-target="#confirmSignOutModal">Sign out</a></li>
            </ul>
        </div>
    </div>
</div>
