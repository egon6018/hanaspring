<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- JSTL -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>공지사항</title>

  <!-- Main CSS : Header, Main, Footer -->
  <link rel="stylesheet" href="<c:url value="/css/main.css" />">
  <link rel="stylesheet" href="<c:url value="/css/common.css" />">
  <link rel="stylesheet" href="<c:url value="/css/community/community.css" />">

  <!-- Bootstrap CSS -->
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
  <!-- Bootstarp JS -->
  <script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-fQybjgWLrvvRgtW6bFlB7jaZrFsaBXjsOMm/tB9LTS58ONXgqbR9W8oWht/amnpF" crossorigin="anonymous"></script>

  <script>
    $(document).ready(function(){
      $('#headerTop').load("<c:url value="/headerTop-sub.jsp" />");
      $('#header').load("<c:url value="/header-sub.jsp" />");
      $('#footer').load("<c:url value="/footer-sub.jsp" />");
    });
  </script>

</head>
<body>
  <!-- 헤더 -->
  <div id="headerTop"></div>
  <div id="header" class="sticky-top"></div>

  <!-- 메인 -->
  <!-- 공지사항 -->
  <!-- COMMON -->
  <div class="commonSection1">
    <div class="commonContent1">
      <img src="<c:url value="/img/member/sub-visual02.jpg" />"
          style="width: 100%; height: 100%;">
      <div class="commonContent2 text-center">
        <div>
          <h3>COMMUNITY</h3>
        </div>
        <div>
          <p><img src="<c:url value="/img/icon-home.png" />"> > 커뮤니티 > 공지사항</p>
        </div>
      </div>
    </div>
  </div>
  <!-- COMMON - 드랍다운 -->
  <nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="<c:url value="/" />"><button class="homeBtn">H</button></a>
      <ul class="navbar-nav mr-auto navbar-nav-scroll" 
          style="max-height: 100px;">
        
        <li class="nav-item dropdown dropdownHide">
          <a class="nav-link dropdown-toggle" href="#" id="navbarScrollingDropdown" role="button" 
            data-toggle="dropdown" aria-expanded="false">
            커뮤니티
          </a>
          <ul class="dropdown-menu" aria-labelledby="navbarScrollingDropdown">
            <li><a class="dropdown-item" href="#">회사소개</a></li>
            <li><hr class="dropdown-divider"></li>
            <li><a class="dropdown-item" href="#">사업분야</a></li>
            <li><hr class="dropdown-divider"></li>
            <li><a class="dropdown-item" href="#">제품안내</a></li>
            <li><hr class="dropdown-divider"></li>
            <li><a class="dropdown-item" href="#">커뮤니티</a></li>
            <li><hr class="dropdown-divider"></li>
            <li><a class="dropdown-item" href="#">고객지원</a></li>
          </ul>
        </li>

        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" id="navbarScrollingDropdown" 
              role="button" data-toggle="dropdown" aria-expanded="false">
              공지사항
          </a>
          <ul class="dropdown-menu asd">
            <li><a class="dropdown-item" href="<c:url value="/community/community01" />">공지사항</a></li>
            <li><hr class="dropdown-divider"></li>
            <li><a class="dropdown-item" href="#">홍보자료</a></li>
            <li><hr class="dropdown-divider"></li>
            <li><a class="dropdown-item" href="#">채용안내</a></li>
          </ul>
        </li>
      </ul>
    </div>
  </nav>

  <!-- 공지사항 -->
  <div class="communitySection2 container text-center">
    <div>
      <div>공지사항</div>
      <div>The design and maintenance are excellent.</div>
    </div>
    <div class="Notice">
      <table>
        <thead>
          <tr>
            <th>번호</th>
            <th>제목</th>
            <th>작성일</th>
          </tr>
        </thead>
        <tbody>
          <c:forEach var="notice" items="${noticelist}">
            <tr>
              <td><a href="<c:url value="/community/community01_1"/>?idx=${notice.noticeIdx}">${notice.noticeIdx}</a></td>
              <td>${notice.noticeTitle}</td>
              <td>${notice.noticeDate}</td>
            </tr>
          </c:forEach>
        </tbody>
      </table>
    </div>
  </div>
  
  <!-- search bar -->
  <div class="search container">
    <form action="<c:url value="/community/communityOneSearch"/>" method="GET">
      <table>
        <tr>
          <td>
            <select name="select" id="select">
              <option value="title">제목</option>
              <option value="content">내용</option>
            </select>
          </td>
          <td>
            <input type="text" name = "keyword" id = "keyword">
          </td>
          <td>
            <input type="image" src="<c:url value="/img/community/search.gif" />">
          </td>
        </tr>
      </table>
    </form>
  </div>

  <!-- 푸터 -->
  <div id="footer"></div>
</body>
</html>