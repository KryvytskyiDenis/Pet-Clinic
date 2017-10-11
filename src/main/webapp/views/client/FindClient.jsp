<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/resources/css/reset.css"/>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/style.css"/>"/>
    <title>Find Client</title>
</head>
<body>

<div class="main">
    <%@include file="header.jsp"%>
    <form action="${pageContext.servletContext.contextPath}/client/find" method="get"
          class="find-client">

        <ul>
            <li>
                <h2>Find client</h2>
            </li>
            <li>
                <label for="nameOfClient">Client name:</label>
                <input name="nameOfClient" id="nameOfClient" placeholder="Jack Holver">
            </li>
            <li>
                <button class="submit">Submit</button>
            </li>

        </ul>

    </form>
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
            <c:forEach items="${found}" var="client" varStatus="status">
                <tr valign="top">
                    <td>${client.getNameOfClient()}</td>
                    <td>${client.getPhoneOfClient()}</td>
                    <td>${client.getCityOfClient()}</td>
                    <td>${client.getAddressOfClient()}</td>
                    <td>
                        <c:forEach items="${client.getPetsOfClient()}" var="pet" varStatus="status">
                            ${pet.getNameOfPet()}
                        </c:forEach>
                    </td>
                    <td>
                        <c:forEach items="${client.getPetsOfClient()}" var="pet" varStatus="status">
                            ${pet.getTypeOfPet()}
                        </c:forEach>
                    </td>
                    <td>
                        <a href="${pageContext.servletContext.contextPath}/client/edit?id=${client.id}">Edit</a>
                        <a href="${pageContext.servletContext.contextPath}/client/delete?id=${client.id}">Delete</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>

    <%@include file="footer.jsp"%>
</div>
</body>
</html>
