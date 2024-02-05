<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: immrdg
  Date: 03/02/24
  Time: 10:40 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav class="navbar navbar-expand-sm navbar-dark ">
    <div class="container-fluid">
        <a class="navbar-brand" href="${pageContext.request.contextPath}/">Paying Guest Application</a>
        <button
                data-mdb-collapse-init
                class="navbar-toggler"
                type="button"
                data-mdb-target="#navbarNav"
                aria-controls="navbarNav"
                aria-expanded="false"
                aria-label="Toggle navigation"
        >
            <i class="fas fa-bars"></i>
        </button>
        <div class="collapse navbar-collapse d-lg-flex justify-content-end fs-5" id="navbarNav">
            <ul class="navbar-nav">
                <c:choose>
                    <c:when test="${sessionScope.role==null}">
                        <li class="nav-item">
                            <a class="nav-link" href="<%= request.getContextPath() %>/register">Register</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="<%= request.getContextPath() %>/login">Login</a>
                        </li>
                    </c:when>
                    <c:otherwise>
                        <li class="nav-item">
                            <h5 class="text-danger fw-bolder nav-link">Welcome ${sessionScope.name}</h5>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="${pageContext.request.contextPath}/logout">Logout</a>
                        </li>

                    </c:otherwise>
                </c:choose>



            </ul>
        </div>
    </div>
</nav>