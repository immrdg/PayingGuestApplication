<%--
  Created by IntelliJ IDEA.
  User: immrdg
  Date: 04/02/24
  Time: 11:58 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>Places</title>
    <%@ include file="parts/styles.jsp"%>
</head>
<body>
    <%@include file="parts/nav.jsp"%>
    <div class="container mt-5">

        <h2 class="mb-4">Places Table</h2>

        <div class="mb-4">
            <c:if test="${sessionScope.role eq 'PG'}">
                <form action="search" method="GET" class="form-inline">
                    <div class="form-group">
                        <input type="text" name="query" class="form-control" placeholder="Search">
                    </div>
                    <button type="submit" class="btn btn-primary ml-2">Search</button>
                </form>
            </c:if>
            <c:if test="${sessionScope.role eq 'OWNER'}">
                <button class="btn btn-success">Add Place</button>
            </c:if>
        </div>

        <table class="table">
            <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Address</th>
                <th>City</th>
                <th>Country</th>
                <th>Rent</th>
                <th>Status</th>
                <th>Actions</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="place" items="${placesList}">
                <tr>
                    <td>${place.id}</td>
                    <td>${place.name}</td>
                    <td>${place.address}</td>
                    <td>${place.city}</td>
                    <td>${place.country}</td>
                    <td>${place.rent}</td>
                    <td>${place.status}</td>
                    <td>
                        <c:if test="${sessionScope.role eq 'PG' || sessionScope.role eq 'OWNER'}">
                            <a class="btn btn-info" href="viewDetailsPage?id=${place.id}">View</a>
                        </c:if>
                        <c:if test="${sessionScope.role eq 'OWNER'}">
                            <a class="btn btn-warning" href="editPlacePage?id=${place.id}">Edit</a>
                            <a class="btn btn-danger" href="deletePlace?id=${place.id}">Delete</a>
                        </c:if>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

        <div class="mt-3">
            <p class="text-muted">Total Records: ${fn:length(placesList)}</p>
        </div>

    </div>
    <%@ include file="parts/js.jsp"%>
</body>
</html>

