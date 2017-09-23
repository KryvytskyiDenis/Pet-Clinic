<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link rel="stylesheet" href="<c:url value="/resources/css/reset.css"/>"/>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/style.css"/>"/>
    <script type="text/javascript"
            src="${pageContext.servletContext.contextPath}/resources/js/jquery-3.2.1.js"></script>
    <script type="text/javascript" src="${pageContext.servletContext.contextPath}/resources/js/form.js"></script>
    <title>Add client</title>
</head>
<body>
<div class="main">
    <%@include file="header.jsp"%>

    <div class="form-wrapper">
        <form action="${pageContext.servletContext.contextPath}/client/create" method="post"
              class="add-client">

            <ul>
                <li>
                    <h2>Add client</h2>
                    <span class="required_notification">* required field</span>
                </li>

                <li>
                    <label for="nameOfClient">Name: *</label>
                    <input name="nameOfClient" id="nameOfClient" placeholder="Jack Holver">
                </li>

                <li>
                    <label for="phone">Phone: *</label>
                    <input name="phoneOfClient" id="phone" placeholder="+3804636247235">
                </li>

                <li>
                    <label for="city">Client city: *</label>
                    <input name="cityOfClient" id="city" placeholder="London">
                </li>

                <li>
                    <label for="address">Client address: *</label>
                    <input name="addressOfClient" id="address" placeholder="Gozhulanskaya 30a">
                </li>

                <li>
                    <label for="nameOfPet">Pet name:</label>

                    <input name="nameOfPet" id="nameOfPet" placeholder="Yasha">
                </li>

                <li>
                    <label for="petType">Pet type:</label>
                    <select size="1" name="ClassOfPet" id="petType">
                        <option value="Cat">Cat</option>
                        <option value="Bird">Bird</option>
                        <option value="Dog">Dog</option>
                        <option value="Fish">Fish</option>
                        <option value="Rodent">Rodent</option>
                    </select>
                </li>

                <li>
                    <button class="submit" onclick="return createClient();">Submit</button>
                </li>
            </ul>

        </form>
    </div>

    <%@include file="footer.jsp"%>
</div>
</body>
</html>
