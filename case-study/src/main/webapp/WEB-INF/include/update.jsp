<div class="modal fade" id="updateEventModal" tabindex="-1" aria-labelledby="updateEventModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h1 class="modal-title fs-5" id="updateEventModalLabel">Edit Events</h1>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <form id="updateEventForm" action="/events?action=edit" method="post" enctype="multipart/form-data">
                    <input type="hidden" name="id" id="editEventId">
                    <div class="mb-3">
                        <label for="editrecipient-name" class="col-form-label">Name Events:</label>
                        <input type="text" class="form-control" id="editrecipient-name" name="eventName">
                    </div>
                    <div class="mb-3">
                        <label for="editdate-time" class="col-form-label">Date-Time:</label>
                        <input type="date" id="editdate-time" class="form-control" name="eventStart">
                    </div>
                    <div class="mb-3">
                        <label for="editimg-text" class="col-form-label">Image:</label>
                        <input type="file" id="editimg-text" class="form-control" name="imgEvent">
                        <div class="text-center mt-2">
                            <img id="editEventImagePreview" src="" alt="Event Image Preview" class="img-fluid" style="max-height: 200px;">
                        </div>
                    </div>
                    <div class="mb-3">
                        <label for="editlocation-text" class="col-form-label">Location:</label>
                        <input type="text" id="editlocation-text" class="form-control" name="location">
                    </div>
                    <div class="mb-3">
                        <label for="editmessage-text" class="col-form-label">Description:</label>
                        <textarea class="form-control" id="editmessage-text" name="description"></textarea>
                    </div>
                    <div class="mb-3">
                        <label for="editstatus" class="col-form-label">Status:</label>
                        <select class="form-select" id="editstatus" name="isStatus">
                            <option value="1">Start</option>
                            <option value="0">Not Start</option>
                        </select>
                    </div>
                    <div class="mb-3">
                        <label for="editnumber-ticket" class="col-form-label">Number of Tickets:</label>
                        <input type="number" id="editnumber-ticket" class="form-control" name="ticketToSell">
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                <button type="submit" class="btn btn-primary" form="updateEventForm">Update Event</button>
            </div>
        </div>
    </div>
</div>
