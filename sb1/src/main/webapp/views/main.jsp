<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
	<!-- 127.0.0.1:8080/sb1/ -->
	<link href="<c:url value="/css/main.css"  />" rel="stylesheet">
	<!--
        그냥 /main.css(절대경로)라고 쓰면 root application에서 main.css를 찾는거기 때문에 css파일 적용이 안됨
        하지만 그냥 main.css(상대경로)라고 하면 css파일 적용됨

        근데 taglib태그에 쓴 c이용하여 href="c태그 안에있는 내용 쓰면" css파일 잘 적용됨!
        -->
	<style>
	</style>
</head>

<body>
<header>
	<h1>Main Page</h1>
	<ul>
		<li><a href="<c:url value="/" />">MAIN</a></li>
		<li><a href="<c:url value="/login" />">LOGIN</a></li>
		<li><a href="<c:url value="/register" />">REGISTER</a></li>
		<li><a href="<c:url value="/cust/add" />">CUST ADD</a></li>
		<li><a href="<c:url value="/cust/get" />">CUST GET</a></li>
		<li><a href="<c:url value="/item/add" />">ITEM ADD</a></li>
		<li><a href="<c:url value="/item/get" />">ITEM GET</a></li>
	</ul>	
</header>
<section>
	<c:choose>
		<c:when test="${centerpage == null }">
		   <jsp:include page="center.jsp"></jsp:include>
		</c:when>
		<c:otherwise>
		   <jsp:include page="${centerpage}.jsp"></jsp:include>
		</c:otherwise>
	</c:choose>
	
	
</section>
<footer></footer>
</body>
</html>






