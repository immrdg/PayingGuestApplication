<%--
  Created by IntelliJ IDEA.
  User: immrdg
  Date: 04/02/24
  Time: 11:32 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>${title}</title>
  <%@ include file="parts/styles.jsp"%>
  <style>
    .container{
      font-family:  serif;
    }
  </style>
</head>
<body>
<%@ include file="parts/nav.jsp"%>
<div class="container mt-5">
  <div class="row d-flex justify-content-center">
    <div class="col-md-4">

      <!-- Login Card -->
      <div class="card">

        <!-- Card Header -->
        <div class="card-header text-center">
          <h3>Login</h3>
        </div>

        <!-- Card Body -->
        <div class="card-body">
          <c:if test="${error!=null}">
            <div class="card bg-danger mb-1" id="error">
              <div class="card-header d-flex justify-content-between align-items-center">
                <h5 class="mb-0 text-white">${error}</h5>
                <button class="btn-close" onclick="closeError()"></button>
              </div>
            </div>
          </c:if>
          <!-- Login Form -->
          <form method="post">
            <!-- Form fields go here -->
            <div class="mb-3">
              <label for="name" class="form-label text-dark fs-5">Name</label>
              <input type="text" class="form-control" id="name" name="name" required>
            </div>
            <div class="mb-3">
              <label for="email" class="form-label text-dark fs-5">Email</label>
              <input type="text" class="form-control" id="email" name="email" required>
            </div>
            <div class="mb-3">
              <label for="password" class="form-label text-dark fs-5">Password</label>
              <input type="password" class="form-control" id="password" name="password" required>
            </div>
            <button type="submit" class="btn btn-primary">Register</button>
          </form>

        </div>
      </div>
    </div>
  </div>
</div>


<%@ include file="parts/js.jsp"%>
</body>
</html>


