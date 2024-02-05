<%--
  Created by IntelliJ IDEA.
  User: immrdg
  Date: 03/02/24
  Time: 4:12 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>${title}</title>
    <%@ include file="parts/styles.jsp"%>
</head>
<body>
        <%@ include file="parts/nav.jsp"%>
        <h1>Welcome to "${title}" page</h1>
        <h1 class="card-title">${time}</h1>
        <c:if test="${error!=null}">
            <H1>${error}</H1>
        </c:if>

        <%@ include file="parts/js.jsp"%>
</body>
</html>
