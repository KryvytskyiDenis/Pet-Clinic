<header>
    <nav>
        <ul class="menu">
            <li class="home">
                <a href="${pageContext.servletContext.contextPath}/views/client/welcome.jsp">Home</a>
            </li>
            <%----%>
            <li class="clients">
                <a href="${pageContext.servletContext.contextPath}/client/view">Clients</a>
                <ul class="submenu">
                    <li class="find">
                        <a href="${pageContext.servletContext.contextPath}/views/client/FindClient.jsp">Find</a>
                    </li>
                    <%----%>
                    <li class="add">
                        <a href="${pageContext.servletContext.contextPath}/views/client/CreateClient.jsp">Add</a>
                    </li>
                    <%----%>
                </ul>
            </li>
            <%----%>
            <li class="contacts">
                <a href="">Contact</a>
            </li>
            <%----%>
            <li class="main-menu-item about">
                <a href="">About us</a>
            </li>
        </ul>
    </nav>
</header>