<%--
  Created by IntelliJ IDEA.
  User: goeun
  Date: 2024-03-27
  Time: 오전 9:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<ul class="nav nav-pills flex-column">
    <p>CUST</p>
    <li class="nav-item">
        <a class="nav-link" href="<c:url value="/cust/add" />">add</a>
    </li>
    <li class="nav-item">
        <a class="nav-link" href="<c:url value="/cust/get" />">get</a>
    </li>
</ul>