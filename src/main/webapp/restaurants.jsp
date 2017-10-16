<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Restaurants</title>
</head>
<body>
<hr>
    <h3><a href="index.html">Home</a></h3>
    <h2>Vote for Restaurant</h2>
    <hr/>

    <div>
        <form method="post" action="restaurants?action=filter">
            <dl>
                <dt>From Date:</dt>
                <dd><input type="date" name="startDate" value="${param.startDate}"></dd>
            </dl>
            <dl>
                <dt>To Date:</dt>
                <dd><input type="date" name="endDate" value="${param.endDate}"></dd>
            </dl>
            <button type="submit">Filter</button>
        </form>

    </div>

</hr>
    <a href="restaurants?action=create">Add Restaurant</a>



    <table border="1" cellpadding="8" cellspacing="0">
        <thead>
        <tr>
            <th>ID</th>
            <th>Created</th>
            <th>Restaurant</th>
            <th>Dishes</th>
            <th>Votes</th>
            <th>Vote</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        </thead>

        <c:forEach items="${dishes}" var="dish">
            <jsp:useBean id="dish" type="com.restaurants.model.Dish" scope="page"/>
            <tr >
                <td>${dish.restaurant.id}</td>
                <td>${dish.restaurant.createdOrUpdated}</td>
                <td>${dish.restaurant.name}</td>
                <td>${dish.restaurant.menu}</td>
                <td>${dish.restaurant.votes}</td>
                <td><a href="restaurants?action=vote&id=${dish.restaurant.id}">Vote</a></td>
                <td><a href="restaurants?action=edit&id=${dish.restaurant.id}">Edit</a></td>
                <td><a href="restaurants?action=delete&id=${dish.restaurant.id}">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</section>
</body>
</html>
