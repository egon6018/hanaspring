<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- JSTL -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<!-- 탑메뉴 -->
<div class="toTopScroll">
  <img src="<c:url value="/img/icon-top.png" />" onClick="javascript:window.scrollTo(0,0)">
</div>
<div class="top d-none d-md-block">
  <div class="topMenu d-none d-md-block container">
    <span class="home"><a href="<c:url value="/" />">HOME</a></span>
    <span><a href="<c:url value="/member/login" />">LOGIN</a></span>
    <span><a href="<c:url value="/member/join2" />">JOIN</a></span>
    <span><a href="<c:url value="/company/company03"/>">CONTACT US</a></span>
  </div>
</div>