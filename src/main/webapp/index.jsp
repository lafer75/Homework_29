<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Coffee Order Board</title>
</head>
<body>
<h1>Coffee Order Board</h1>
<form method="POST" action="addOrder">
    <label for="name">Name:</label>
    <input type="text" id="name" name="name"><br>
    <button type="submit">Add Order</button>
</form>
<hr>
<h2>Current Orders</h2>
<table>
    <thead>
    <tr>
        <th>Order Number</th>
        <th>Name</th>
        <th>Status</th>
        <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${orders}" var="order">
        <tr>
            <td>${order.orderNumber}</td>
            <td>${order.name}</td>
            <td>${order.status}</td>
            <td>
                <form method="POST" action="deliverOrder">
                    <input type="hidden" name="orderNumber" value="${order.orderNumber}">
                    <button type="submit">Deliver</button>
                </form>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
