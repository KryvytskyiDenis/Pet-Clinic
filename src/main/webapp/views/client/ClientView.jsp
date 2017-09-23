<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/reset.css"/>"/>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/style.css"/>"/>
    <link href="https://fonts.googleapis.com/css?family=Leckerli+One|Norican|Pacifico" rel="stylesheet">
    <title>Pet clinic</title>
</head>
<body>
<div class="main">
    <%@include file="header.jsp" %>

    <div id="tableWrap">
        <table class="clientsTable">
            <thead>
            <tr>
                <th class="tHead">Client name</th>
                <th class="tHead">Phone</th>
                <th class="tHead">City</th>
                <th class="tHead">Address</th>
                <th class="tHead">Pet name</th>
                <th class="tHead">Pet type</th>
                <th class="tHead">Actions</th>
            </tr>
            </thead>

            <tbody>
            <c:forEach items="${clients}" var="client" varStatus="status">
                <tr valign="top">
                    <td>${client.getNameOfClient()}</td>
                    <td>${client.getPhoneOfClient()}</td>
                    <td>${client.getCityOfClient()}</td>
                    <td>${client.getAddressOfClient()}</td>
                    <td> ${client.petOfClient.nameOfPet}</td>
                    <td> ${client.petOfClient.getTypeOfPet()}</td>
                    <td>
                        <a href="${pageContext.servletContext.contextPath}/client/edit?id=${client.id}">Edit</a>
                        <a href="${pageContext.servletContext.contextPath}/client/delete?id=${client.id}">Delete</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>

    <%@include file="footer.jsp" %>
</div>
</body>
</html>
