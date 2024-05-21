<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- JSTL -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<!-- 탑메뉴 -->

<!-- href img-src 상대경로 잡는법 -->
<!-- 현재폴더 -->
<!-- 1.   ./index01.html      ./img/logo.png    -->
<!-- 상위폴더 -->
<!-- 2.   ../index01.htl      ../img/logo.png   -->
<!-- 루트폴더 -->
<!-- 3.   /index01.html       /img/logo.png   -->
<!-- 현재폴더 -->
<!-- 4.    index01.html       img/logo.pn 현재폴더 -->
  
<div class="toTopScroll">
  <img src="../img/icon-top.png" onClick="javascript:window.scrollTo(0,0)">
</div>
<div class="top d-none d-md-block">
  <div class="topMenu d-none d-md-block container">
    <span class="home"><a href="<c:url value="/" />">HOME</a></span>
    <c:choose>
      <c:when test="${sessionScope.id == null}">
        <span><a href="<c:url value="/member/login" />">LOGIN</a></span>
      </c:when>
      <c:otherwise>
        <span><a href="<c:url value="/member/logout" />">LOGOUT</a></span>
      </c:otherwise>
    </c:choose>
    <span><a href="<c:url value="/member/join2" />">JOIN</a></span>
    <span><a href="<c:url value="/company/company03" />">CONTACT US</a></span>
  </div>
</div>