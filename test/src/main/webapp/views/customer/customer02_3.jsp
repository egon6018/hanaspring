<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- JSTL -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>비밀번호 확인</title>

  <!-- My CSS -->
  <link rel="stylesheet" href="<c:url value="/css/customer/checkPW.css" />">

  <!-- Bootstrap CSS -->
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
  <!-- Bootstarp JS -->
  <script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-fQybjgWLrvvRgtW6bFlB7jaZrFsaBXjsOMm/tB9LTS58ONXgqbR9W8oWht/amnpF" crossorigin="anonymous"></script>

  <script>
    function submit() {
      var form = document.qnaFindForm;

      form.submit();
    }
  </script>

</head>
<body>
  <div class="main">
    <form action="<c:url value="/customer/customer02_3impl" />" name="qnaFindForm">
      <input type="hidden" id="qnaidx" name="qnaidx" value="${qnaidx.qnaIdx}" />
      <table>
        <tr>
          <td colspan="2">비밀번호입력</td>
        </tr>
        <tr>
          <td colspan="2">글 작성시 입력한 비밀번호를 입력하세요.</td>
        </tr>
        <tr>
          <td style="width: 20%;"><img src="<c:url value="/img/customer/txt_pass.gif" />"></td>
          <td style="width: 80%;"><input type="password" id="qnaPw" name="qnaPw"></td>
        </tr>
      </table>
    </form>
    <div><input type="image" src="<c:url value="/img/customer/btn_confirm.gif" />" onclick="submit()"></div>
    <div><input class="closeBtn" type="image" onclick="window.close()" src="<c:url value="/img/member/btn_close.gif" />"/></div>
  </div>
  
</body>
</html>