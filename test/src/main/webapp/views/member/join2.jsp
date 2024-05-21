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
  <title>회원가입2</title>

  <!-- Main CSS : Header, Main, Footer -->
  <link rel="stylesheet" href="<c:url value="/css/main.css" />">
  <link rel="stylesheet" href="<c:url value="/css/common.css" />">
  <link rel="stylesheet" href="<c:url value="/css/member/join.css" />">

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

    <%--$(function(){--%>
    <%--  join2.init('<c:url value="/join2impl"/>');--%>
    <%--});--%>


    let join2 = {
      idPossible: false, // 아이디 중복 확인 여부
      init: function() {
        /* 아이디중복확인 button handler */
        $('#idDoubleCheckBtn').click(() => {
          // console.log("1000000000000000000000");
          let memberId = $('#memberId').val();
          if(memberId == '' || memberId == null) {
            alert('아이디가 입력되지 않았습니다');
            $('#memberId').focus();
            return;
          }

          $.ajax({
            url: '<c:url value="/member/join2checkid" />',
            data: {'memberId': memberId},
            success: (res) => {
              if(res === '0') {
                alert('아이디가 중복됩니다');
                join2.idPossible = false;
                $('#memberId').focus();
              } else {
                alert('아이디 사용가능합니다');
                join2.idPossible = true;
              }
            }
          })
        });

        /* 확인 button handler */
        $('#confirmBtn').click(() => {

          /* 각 정보 입력 여부 검사 */

          // memberId
          let memberId = $('#memberId').val();
          console.log("memberId: " + memberId);
          if(memberId == '' || memberId == null){
            alert('아이디가 입력되지 않았습니다');
            $('#memberId').focus();
            return;
          }
          if(!join2.idPossible) {
            alert("아이디 중복을 확인해주세요");
            return;
          }


          // memberPw
          let memberPw = $('#memberPw').val();
          console.log("memberPw: " + memberPw);

          if(memberPw == '' || memberPw.length < 4) {
            alert('비밀번호를 4자리 이상 입력하세요');
            $('#memberPw').focus();
            return;
          }

          // memberPwCheck
          let memberPwCheck = $('#memberPwCheck').val();
          console.log("memberPwCheck: " + memberPwCheck);

          if(memberPw !== memberPwCheck) {
            alert('암호가 일치하지 않습니다. 다시 입력해주세요');
            $('#memberPwCheck').focus();
            return;
          }

          // memberName
          let memberName = $('#memberName').val();
          console.log("memberName: " + memberName);

          if(memberName == '' || memberName == null) {
            alert('이름을 입력하세요');
            $('#memberName').focus();
            return;
          }

          // memberEmail
          let memberEmail = $('#memberEmail').val();

          if(memberEmail == '' || memberEmail == null) {
            alert('이메일을 입력하세요');
            $('#memberEmail').focus();
            return;
          }
          // if (!memberEmailFront || !memberEmailBack) {
          //   alert('이메일을 정확히 입력해 주세요');
          //   $('#memberEmailFront').focus();
          //   return;
          // }


          let emailReceive = $('input[name="memberEmailReceive"]:checked').val();
          if (!emailReceive) {
            alert('이메일 수신여부를 선택해 주세요');
            // $('#agreeEmailReceive').focus();
            return;
          }

          let memberPwQuestion = $('#memberPwQuestion').val();
          if (memberPwQuestion === "0") {
            alert('비밀번호 확인 질문을 선택해 주세요');
            // $('#memberPwQuestion').focus();
            return;
          }
          let memberPwAnswer = $('#memberPwAnswer').val();
          if (!memberPwAnswer) {
            alert('비밀번호 확인 답변을 입력해 주세요');
            $('#memberPwAnswer').focus();
            return;
          }
          let memberGender = $('input[name="memberGender"]:checked').val();
          if (!memberGender) {
            alert('성별을 선택해 주세요');
            // $('#male').focus();
            return;
          }
          let memberBirthDate = $('#memberBirthDate').val();
          console.log("memberBirthDate: " + memberBirthDate);
          if (memberBirthDate === "") {
            alert('생년월일을 입력해 주세요');
            return;
          }

          join2.send();
        });
      },
      send: function() {
        $('#joinForm').attr({
          method:'post',
          action:'<c:url value="/member/join2impl"/>'
        });
        $('#joinForm').submit();
      }
    };

    $(function () {
      join2.init();
    });

  </script>

</head>
<body>
  <!-- 헤더 -->
  <div id="headerTop"></div>
  <div id="header" class="sticky-top"></div>

  <!-- 메인 -->
  <!-- COMMON -->
  <div class="commonSection1">
    <div class="commonContent1">
      <img src="<c:url value="/img/member/sub-visual02.jpg"/>"
           style="width: 100%; height: 100%;">
      <div class="commonContent2 text-center">
        <div>
          <h3>MEMBER</h3>
        </div>
        <div>
          <p><img src="<c:url value="/img/icon-home.png"/>"> > 회원가입</p>
        </div>
      </div>
    </div>
  </div>

  <!-- 메인 -->
  <!-- 회원가입 -->
  <div class="joinForm container">

    <div class="joinSection1">
      <div><h3>회원가입</h3></div>
      <div><p>The design and maintenance are excellent.</p></div>
    </div>
    <div class="wellcome">
      <h3>OOO사이트에 오신 것을 환영합니다.</h3>
      <h5>-이름과 이메일을 입력해 주시면 가입여부를 확인 후 회원가입 절차가 이루어집니다.</h5>
    </div>
    <br><br>
    <div class="contents">
      <h3>회원가입을 위해서 아래의 양식에 있는 내용을 입력해 주셔야 합니다.</h3>
      <h5>-회원님의 개인정보를 신중하게 보호하고 있으며 회원님의 동의 없이는 기재하신 회원정보가 누출되지 않습니다.
        자세한 내용은 개인정보보호정책에서 확인하세요.</h5>
    </div>

    <!-- 입력폼 -->

    <form id="joinForm">
      <div class="information1">
        <div>기본정보</div>
        <table>
          <tr>
            <td>아이디</td> <%-- member_id --%>
            <td>
              <input id="memberId" type="text" name="memberId">
              <img id="idDoubleCheckBtn" src="<c:url value="/img/member/btn_iddupl.gif"/>" style="cursor: pointer">
              (영문 소문자, 숫자로 4~16자)
            </td>
          </tr>
          <tr>
            <td>비밀번호</td> <%-- member_pw --%>
            <td>
              <input id="memberPw" type="password" name="memberPw">
              영문/숫자/특수문자조합으로 8~16자리. 첫글자는 영문자로 사용
            </td>
          </tr>
          <tr>
            <td>비밀번호 확인</td> <%-- X --%>
            <td><input id="memberPwCheck" type="password" name="memberPwCheck"></td>
          </tr>
          <tr>
            <td>이름</td> <%-- member_name --%>
            <td><input id="memberName" type="text" name="memberName"></td>
          </tr>
          <tr>
            <td>이메일</td> <%-- member_email --%>
            <%--          <td><input id="memberEmailFront" type="text">@<input id="memberEmailBack" type="text"></td>--%>
            <td><input id="memberEmail" type="text" name="memberEmail"></td>

          </tr>
          <tr>
            <td>이메일 수신여부</td> <%-- member_email_receive (int) --%>
            <td>
              <input id="agreeEmailReceive" type="radio" name="memberEmailReceive" value="1">수신
              <input id="disagreeEmailReceive" type="radio" name="memberEmailReceive" value="0">수신안함
            </td>
          </tr>
          <tr>
            <td>비밀번호 확인시 질문</td> <%-- member_email_receive (int) --%>
            <td>
              <select id="memberPwQuestion" class="size" name="memberPwQuestion">
                <option value="0">========선택========</option>
                <option value="1">기억에 남는 추억의 장소는?</option>
                <option value="2">자신의 인생 좌우명은?</option>
                <option value="3">자신의 보물 제1호는?</option>
                <option value="4">가장 기억에 남는 선생님 성함은?</option>
                <option value="5">내가 좋아하는 캐릭터는?</option>
              </select>
            </td>
          </tr>
          <tr>
            <td>비밀번호 확인시 답변</td> <%-- member_pw_answer --%>
            <td><input id="memberPwAnswer" type="text" name="memberPwAnswer" value=""></td>
          </tr>
          <tr>
            <td>성별</td> <%-- member_memberGender --%>
            <td>
              <input id="male" type="radio" name="memberGender" value="male">남자
              <input id="female" type="radio" name="memberGender" value="female">여자
            </td>
          </tr>
          <tr>
            <td>생년월일</td> <%-- member_birth_date --%>
            <td>
              <%--          <select name="year" id="year" title="년도" class="birthdaySelect"></select>--%>
              <%--          <select name="month" id="month" title="월" class="birthdaySelect"></select>--%>
              <%--          <select name="day" id="day" title="일" class="birthdaySelect"></select>--%>
              <input type="date"
                     id="memberBirthDate"
                     min="1900-01-01"
                     max="2024-12-31"
                     value="2024-01-01"
                     name="memberBirthDate">
            </td>
          </tr>
        </table>
      </div>

    </form>
    <div class="imageBtn2">
      <input id="confirmBtn" type="image" src="<c:url value="/img/member/btn_confirm.gif"/>">
      <input id="cancleBtn" type="image" src="<c:url value="/img/member/btn_cancel.gif"/>">
    </div>
    <%-- 부가정보 ?? --%>
    <div class="Information2">부가정보</div>

    <%-- 확인, 취소 버튼 --%>


  </div>



  <!-- 푸터 -->
  <div id="footer"></div>

</body>
</html>