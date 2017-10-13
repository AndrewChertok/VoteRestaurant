
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Meal</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<section>
    <h3><a href="index.html">Home</a></h3>

    <h2>${param.action == 'create' ? 'Create restaurant' : 'Edit restaurant'}</h2>
    <hr>
   <c:if test="${param.action == 'edit'}"> <jsp:useBean id="restaurant" type="com.restaurants.model.Restaurant" scope="request"/>
    </c:if>
    <form method="post" action=${param.action == 'create' ?  "restaurants?action=create" : "restaurants?action=edit"}>
        <input type="hidden" name="id" value="${restaurant.id}">
        <input type="hidden" name="votes" value="${restaurant.votes}">
        <dl>
            <dt>Restaurant</dt>
            <dd><input type="text" value="${restaurant.name}" name="name"></dd>
        </dl>
        <dl>

            <c:if test="${param.action == 'create'}">
                <dt>Dish</dt>
                <dd><input type="text" value="${dish.name}" size=10 name="dish" ></dd>
                <dt>Price</dt>
                <dd><input type="text" value="${dish.price}" size=10 name="price" ></dd>
            </c:if>

        <c:forEach items="${restaurant.menu}" var="dish">
            <dt>Dish</dt>
            <dd><input type="text" value="${dish.name}" size=20 name="dishes" class="dishes"></dd>
            <dt>Price</dt>
            <dd><input type="text" value="${dish.price}" size=20 name="prices" class="prices"></dd>
        </dl>
        </c:forEach>
        <button type="submit">Save</button>
        <button onclick="window.history.back()" type="button">Cancel</button>
    </form>
</section>
</body>
</html>