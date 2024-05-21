<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<link rel="stylesheet" href="<c:url value="/css/admin/admin.css"/>">   <!-- COMMON -->

<script src="https://cdn.ckeditor.com/4.15.1/standard/ckeditor.js"></script>
<!-- <script>CKEDITOR.replace('editor4');</script> -->
<script>
  var ckeditor_config = {
    resize_enaleb: false,
    enterMode: CKEDITOR.ENTER_BR,
    shiftEnterMode: CKEDITOR.ENTER_P,
    filebrowserUploadUrl: "/ckUpload",
  };
  CKEDITOR.replace("editor4", ckeditor_config);
</script>

<script>
  // back to top 기능
  $(document).ready(function () {
    $(window).scroll(function () {
      if ($(this).scrollTop() > 50) {
        console.log("fadeIn");
        $("#back-to-top").fadeIn();
      } else {
        console.log("fadeOut");
        $("#back-to-top").fadeOut();
      }
    });
    // scroll body to 0px on click
    $("#back-to-top").click(function () {
      console.log("click");
      $("#back-to-top").tooltip("hide");
      $("body,html").animate(
              {
                scrollTop: 0,
              },
              500
      );
      return false;
    });
    $("#back-to-top").tooltip("show");
  });
</script>

<div class="commonSection1">
  <div class="commonContent1">
    <img
            src="<c:url value="/img/member/sub-visual01.jpg" />"
            style="width: 100%; height: 100%"
    />
    <div class="commonContent2 text-center">
      <div>
        <h3>관리자페이지</h3>
      </div>
      <div>
        <p><img src="<c:url value="/img/icon-home.png" />" /> > 관리자페이지</p>
      </div>
    </div>
  </div>
</div>

<div id="adminMain">
  <!-- 사이드메뉴 -->
  <div id="adminSide">
    <ul>
      <li><a href="<c:url value="/admin_member" />">회원 관리</a></li>
      <li>
        <a href="<c:url value="/admin_notice" />" class="adminSideActive">공지사항 관리</a>
      </li>
      <li><a href="#">1:1문의 관리</a></li>
      <li><a href="#">묻고답하기 관리</a></li>
      <li><a href="#">FAQ 관리</a></li>
      <li><a href="#">제품 관리</a></li>
    </ul>
  </div>
  <!-- 메인 -->
  <div id="adminSection">
    <div class="adminDiv">
      <h3>공지사항 관리</h3>
    </div>
    <form action="<c:url value="/admin_notice_modify"/>" method="post">
      <div class="noticeViewTitle adminDiv2">
        <input type="hidden" value="${data.noticeIdx}" name="noticeIdx">
        <span >${data.noticeTitle}</span>
        <span>
            <span>글쓴이:${data.noticeMemberId}</span>
            <span>${data.noticeIdx}</span>
          </span>
      </div>
      <div class="adminDiv2">
        <div class="noticeViewContent">
            <textarea rows="5" cols="50" id="editor4" name="noticeContent">
              ${data.noticeContent}</textarea >
        </div>
      </div>
      <div class="noticeViewBtns adminDiv2">
        <div>
          <button onclick="submit()">수정</button>
          <a href="<c:url value="/admin_notice_delete"/>?idx=${data.noticeIdx}">삭제</a>
        </div>
        <div>
          <a href="<c:url value="/admin_notice"/>">목록</a>
        </div>
      </div>
    </form>
  </div>
</div>

