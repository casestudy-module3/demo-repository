<div class="container">
    <nav class="navbar">
        <div class="container-fluid">
            <form class="d-flex ms-auto" role="search" action="/customers?action=search" method="get">
                <input type="hidden" name="action" value="search">
                <input class="form-control me-2" type="text" name="name" placeholder="Search Name" aria-label="Search" value="${param.name}">
                <button class="btn btn-outline-success bi bi-search" type="submit"></button>
            </form>
        </div>
    </nav>
</div>
