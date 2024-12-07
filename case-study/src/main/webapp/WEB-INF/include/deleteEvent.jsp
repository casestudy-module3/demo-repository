<!-- Modal Xóa Sự Kiện -->
<div class="modal fade" id="deleteEventModal" tabindex="-1" aria-labelledby="deleteEventModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="deleteEventModalLabel">Confirm Delete</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                Are you sure you want to delete <span id="deleteEventName"></span>?
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancel</button>
                <form method="post" action="events?action=delete" id="deleteEventForm">
                    <input type="hidden" name="action" value="delete">
                    <input type="hidden" name="id" id="deleteEventId">
                    <button type="submit" class="btn btn-danger">Delete</button>
                </form>
            </div>
        </div>
    </div>
</div>
