<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/resources/css/reset.css"/>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/style.css"/>"/>
    <title>Edit Client</title>
</head>
<body>
<div class="main">
    <%@include file="header.jsp" %>

    <div class="form-wrapper">
        <form action="${pageContext.servletContext.contextPath}/client/edit" method="post"
              class="edit-client">

            <ul>
                <li>
                    <h2>Edit information</h2>
                    <span class="required_notification">* required field</span>
                </li>
                <li>
                    <label for="nameOfClient">Name: *</label>
                    <input name="nameOfClient" id="nameOfClient" placeholder="${client.getNameOfClient()}">
                </li>

                <li>
                    <label for="nameOfPet">Pet name: *</label>
                    <input name="nameOfPet" id="nameOfPet" placeholder="${client.petOfClient.nameOfPet}">
                </li>
                <li>
                    <button class="submit">Submit</button>
                </li>

                <li>
                    <input type="hidden" name="id" value="${client.id}">
                </li>
            </ul>
        </form>
    </div>

    <%@include file="footer.jsp" %>
</div>
</body>
</html>
