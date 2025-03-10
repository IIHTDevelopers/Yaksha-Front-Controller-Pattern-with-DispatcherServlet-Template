<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Edit Event</title>
</head>
<body>
    <h1>Edit Event</h1>
    <form action="/event/edit/${event.id}" method="POST">
        <input type="hidden" name="id" value="${event.id}"/>

        <label for="name">Event Name:</label>
        <input type="text" id="name" name="name" value="${event.name}" required/><br><br>

        <label for="date">Event Date:</label>
        <input type="text" id="date" name="date" value="${event.date}" required/><br><br>

        <label for="description">Event Description:</label>
        <textarea id="description" name="description" required>${event.description}</textarea><br><br>

        <button type="submit">Update Event</button>
    </form>

    <br><a href="/">Back to Event List</a>
</body>
</html>
