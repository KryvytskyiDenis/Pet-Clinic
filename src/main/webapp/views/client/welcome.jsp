<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/resources/css/reset.css"/>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/style.css"/>"/>
    <title>Pet clinic</title>
</head>
<body id="welcome-page-body">
<div class="main">
<%@include file="header.jsp" %>
<div class="welcome-text">
    <div class="main-title">
        <div>

        </div>
        <h1>Pet Clinic</h1>
    </div>

    <%--<p>--%>
        <%--We will help your pet!--%>
    <%--</p>--%>
</div>
<%@include file="footer.jsp" %>
</div>
</body>
</html>