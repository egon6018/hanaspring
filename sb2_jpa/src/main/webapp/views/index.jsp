<%--
  Created by IntelliJ IDEA.
  User: goeun
  Date: 2024-03-26
  Time: 오후 4:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- JSTL을 구현하기 위해 아래 c태그 사용 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="ko">
<head>
    <title>Bootstrap 4 Website Example</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">



    <script src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
    <%--  KAKAO Map API  --%>
<%--    <script src="http://dapi.kakao.com/v2/maps/sdk.js?appkey=011f6fe99444e793d9d566a663cd9851&autoload=false"></script>--%>
        <script src="//dapi.kakao.com/v2/maps/sdk.js?appkey=011f6fe99444e793d9d566a663cd9851"></script>

    <%-- HighChart API --%>
    <script src="https://code.highcharts.com/highcharts.js"></script>
    <script src="https://code.highcharts.com/highcharts-3d.js"></script>
    <script src="https://code.highcharts.com/modules/series-label.js"></script>
    <script src="https://code.highcharts.com/modules/exporting.js"></script>
    <script src="https://code.highcharts.com/modules/export-data.js"></script>
    <script src="https://code.highcharts.com/modules/accessibility.js"></script>

    <script src="<c:url value="/js/0327.js" />"></script>
    <style>
        .fakeimg {
            height: 200px;
            background: #aaa;
        }
    </style>
</head>
<body>

<div class="jumbotron text-center" style="margin-bottom:0">
    <h1>HTML5 & JavaScript</h1>
</div>
<c:choose> <%-- if-else문 --%>
    <c:when test="${id == null}"> <%-- 로그인 안됐을때 --%>
        <ul class="nav justify-content-end">
            <li class="nav-item">
                <a class="nav-link" href="<c:url value="/login" />">LOGIN</a>
                <%-- 무조건 절대경로! => root를 찾아감 => 127.0.0.1/ 또는 127.0.0.1/sb1/ --%>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="<c:url value="/register" />">REGISTER</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">ABOUT US</a>
            </li>
        </ul>
    </c:when>
    <c:otherwise> <%-- 로그인 되어있을때 --%>
        <ul class="nav justify-content-end">
            <li class="nav-item">
                <a class="nav-link" href="#">${id}</a>
                    <%-- 무조건 절대경로! => root를 찾아감 => 127.0.0.1/ 또는 127.0.0.1/sb1/ --%>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="<c:url value="/logout" />">LOGOUT</a>
            </li>
        </ul>
    </c:otherwise>
</c:choose>

<%-- Start Nav Bar --%>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
    <a class="navbar-brand" href="<c:url value="/" />">HOME</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="collapsibleNavbar">
        <ul class="navbar-nav">
            <li class="nav-item">
                <a class="nav-link" href="<c:url value="/html/" />">HTML5</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="<c:url value="/jquery/" />">jQuery</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="<c:url value="/ajax/" />">Ajax</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="<c:url value="/geo/" />">Geo</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="<c:url value="/chart/" />">Chart</a>
            </li>
            <c:if test="${id != null}">
                <li class="nav-item">
                    <a class="nav-link" href="<c:url value="/cust/" />">Cust</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Item</a>
                </li>
            </c:if>
        </ul>
    </div>
</nav>
<%-- End Nav Bar --%>

<%-- Start Center Area --%>
<div class="container-fluid" style="margin-top:30px">
    <div class="row">
        <div class="col-sm-3">
            <c:choose>
                <c:when test="${left == null}"> <%-- 만약 left가 null이면 --%>
                    <jsp:include page="left.jsp"/> <%-- 그냥 쓰고 --%>
                </c:when>
                <c:otherwise> <%-- 만약 left가 null이 아니면 --%>
                    <jsp:include page="${left}.jsp"/> <%-- 페이지 나타내기 --%>
                </c:otherwise>
            </c:choose>
        </div>
        <div class="col-sm-9">
            <c:choose>
                <c:when test="${center == null}">
                    <jsp:include page="center.jsp" />
                </c:when>
                <c:otherwise>
                    <jsp:include page="${center}.jsp" />
                </c:otherwise>
            </c:choose>
        </div>
    </div>
</div>
<%-- End Center Area --%>

<%-- Start Bottom Area --%>
<div class="text-center bg-dark" style="margin-bottom:0">
    <p>Footer</p>
</div>
<%-- End Center Area --%>

</body>
</html>

