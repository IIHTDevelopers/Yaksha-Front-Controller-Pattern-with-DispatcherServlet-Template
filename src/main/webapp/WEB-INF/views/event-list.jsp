<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Event List</title>
</head>
<body>
    <h1>Event List</h1>
    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Date</th>
                <th>Description</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="event" items="${events}">
                <tr>
                    <td>${event.id}</td>
                    <td>${event.name}</td>
                    <td>${event.date}</td>
                    <td>${event.description}</td>
                    <td>
                        <a href="/event/edit/${event.id}">Edit</a>
                        <a href="/event/delete/${event.id}">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <a href="/event/add">Add New Event</a>
</body>
</html>
