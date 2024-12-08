<%--
  Created by IntelliJ IDEA.
  User: nthan
  Date: 12/8/2024
  Time: 12:44 AM
  To change this template use File | Settings | File Templates.
--%>
<div class="modal fade" id="confirmSignOutModal" tabindex="-1" aria-labelledby="confirmSignOutLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="confirmSignOutLabel">Sign Out</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                Are you sure you want to sign out?
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancel</button>
                <a href="http://localhost:8080/" class="btn btn-danger">Sign Out</a>
            </div>
        </div>
    </div>
</div>