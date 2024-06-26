<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- JSTL -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<!-- 네비바 -->
<nav class="navbar navbar-expand-md navbar-light bg-white sticky-top">
  <div class="container">
    <a class="navbar-brand" href="<c:url value="/" />"><img src="<c:url value="/img/logo.png" />" alt="로고"></a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" 
            data-target="#collapsibleNavbar"> 
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="collapsibleNavbar">
      <!-- ml-auto : margin-left  -->
      <ul class="navbar-nav ml-auto">
        <!-- d-block : display: block  display: none -->
        <li class="nav-item d-sm-block d-md-none ljoin">
          <a href="<c:url value="/member/login" />"> <img src="<c:url value="/img/icon-member.png" />">&nbsp;&nbsp;Login</a>&nbsp;
          <a href="<c:url value="/member/join2" />"> <img src="<c:url value="/img/icon-join.png" />">&nbsp;&nbsp;Join</a>
        </li>
        <li class="nav-item dropdown">
          <a class="nav-link" href="#">회사소개</a>
          <div class="dropdown-content">
            <a href="<c:url value="/company/company01" />">회사개요</a>
            <a href="#">CEO인사말</a>
            <a href="<c:url value="/company/company03" />">오시는길</a>
          </div>
        </li>
        <li class="nav-item dropdown">
          <a class="nav-link" href="#">사업분야</a>
          <div class="dropdown-content">
            <a href="<c:url value="/business/business01" />">사업분야01</a>
            <a href="#">사업분야02</a>
            <a href="#">사업분야03</a>
          </div>
        </li>
        <li class="nav-item dropdown">
          <a class="nav-link" href="#">제품안내</a>
          <div class="dropdown-content">
            <a href="<c:url value="/product/product01" />">제품안내01</a>
            <a href="#">제품안내02</a>
            <a href="#">제품안내03</a>
          </div>
        </li>
        <li class="nav-item dropdown">
          <a class="nav-link" href="#">커뮤니티</a>
          <div class="dropdown-content">
            <a href="<c:url value="/community/community01" />">공지사항</a>
            <a href="#">홍보자료</a>
            <a href="#">채용안내</a>
          </div>
        </li>
        <li class="nav-item dropdown">
          <a class="nav-link" href="#">고객지원</a>
          <div class="dropdown-content">
            <a href="<c:url value="/customer/customer01" />">1:1문의</a>
            <a href="<c:url value="/customer/customer02" />">묻고답하기</a>
            <a href="<c:url value="/customer/customer03" />">FAQ</a>
          </div>
        </li>
      </ul>
    </div>
  </div>
</nav>