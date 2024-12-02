<%--
  Created by IntelliJ IDEA.
  User: nthan
  Date: 12/2/2024
  Time: 1:51 PM
  To change this template use File | Settings | File Templates.
--%>
<div class="modal fade" id="addEventModal" tabindex="-1" aria-labelledby="addEventModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h1 class="modal-title fs-5" id="addEventModalLabel">New Events</h1>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
        <form>
          <div class="mb-3">
            <label for="recipient-name" class="col-form-label">Name Events:</label>
            <input type="text" class="form-control" id="recipient-name">
          </div>
          <div class="mb-3">
            <label for="date-time" class="col-form-label">Date-Time</label>
            <input type="date" id="date-time" class="form-control">
          </div>
          <div class="mb-3">
            <label for="img-text" class="col-form-label">Image</label>
            <input type="file" id="img-text" class="form-control">
          </div>
          <div class="mb-3">
            <label for="location-text" class="col-form-label">Location</label>
            <input type="text" id="location-text" class="form-control">
          </div>
          <div class="mb-3">
            <label for="message-text" class="col-form-label">Description:</label>
            <textarea class="form-control" id="message-text"></textarea>
          </div>
          <div class="mb-3">
            <label for="img-text" class="col-form-label">Status</label>
            <select class="form-select" aria-label="Default select example">
              <option selected>Select Status</option>
              <option value="1">Start</option>
              <option value="2">Not Start</option>
            </select>
          </div>
          <div class="mb-3">
            <label for="number-ticket" class="col-form-label">Number Ticket</label>
            <input type="number" id="number-ticket" class="form-control">
          </div>
        </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary">Add Event</button>
      </div>
    </div>
  </div>
</div>
