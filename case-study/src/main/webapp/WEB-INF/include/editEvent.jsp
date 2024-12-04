<div class="modal fade" id="editEventModal" tabindex="-1" aria-labelledby="editEventModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h1 class="modal-title fs-5" id="editEventModalLabel">Edit Events</h1>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
        <form id="editEventForm" action="${pageContext.request.contextPath}/events" method="post">
          <input type="hidden" name="action" value="edit" />
          <input type="hidden" id="idEvent" name="id" />
          <div class="mb-3">
            <label for="recipient-name" class="col-form-label">Name Events:</label>
            <input type="text" class="form-control" id="recipient-name" name="eventName" required>
          </div>
          <div class="mb-3">
            <label for="date-time" class="col-form-label">Date-Time:</label>
            <input type="date" id="date-time" class="form-control" name="eventStart" required>
          </div>

          <!-- Hình ảnh -->
          <div class="mb-3">
            <label for="img-text" class="col-form-label">Image:</label>
            <input type="text" id="img-text" class="form-control" name="imgEvent">
          </div>

          <!-- Địa điểm -->
          <div class="mb-3">
            <label for="location-text" class="col-form-label">Location:</label>
            <input type="text" id="location-text" class="form-control" name="location">
          </div>

          <!-- Mô tả -->
          <div class="mb-3">
            <label for="message-text" class="col-form-label">Description:</label>
            <textarea class="form-control" id="message-text" name="description"></textarea>
          </div>

          <!-- Trạng thái -->
          <div class="mb-3">
            <label for="status" class="col-form-label">Status:</label>
            <select class="form-select" id="status" name="isStatus">
              <option value="1">Start</option>
              <option value="0">Not Start</option>
            </select>
          </div>

          <!-- Số vé -->
          <div class="mb-3">
            <label for="number-ticket" class="col-form-label">Number of Tickets:</label>
            <input type="number" id="number-ticket" class="form-control" name="ticketToSell" required>
          </div>
        </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
        <button type="submit" class="btn btn-primary" form="editEventForm">Edit Events</button>
      </div>
    </div>
  </div>
</div>
