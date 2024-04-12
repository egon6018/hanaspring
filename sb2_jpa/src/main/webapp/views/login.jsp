<%--
  Created by IntelliJ IDEA.
  User: goeun
  Date: 2024-03-27
  Time: 오전 9:37
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script>

    $(function(){
        login.init('<c:url value="/loginimpl"/>');
    });

</script>
<div class="container">
    <h2>Login Page</h2>
    <form id="login_form">
        <div class="form-group">
            <label for="id">ID:</label>
            <input type="text" class="form-control" id="id" placeholder="Enter id" name="id">

        </div>
        <div class="form-group">
            <label for="pwd">Password:</label>
            <input type="password" class="form-control" id="pwd" placeholder="Enter password" name="pwd">

        </div>

        <button type="button" class="btn btn-primary">LOGIN</button>
    </form>
</div>











<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%--<script>--%>
<%--    let login = {--%>
<%--        init:function (){--%>
<%--            $('#login_form > button').click(function(){--%>
<%--                //let id = $('#id').text(); // html 태그 사이에 있는 글씨를 가져오고 싶을때--%>
<%--                let id = $('#id').val(); // home에서 가져오고 싶을때--%>
<%--                let pwd = $('#pwd').val();--%>
<%--                if(id == '' || id == null){--%>
<%--                    alert('ID를 입력하세요');--%>
<%--                    $('#id').focus();--%>
<%--                    return;--%>
<%--                }--%>
<%--                if(pwd == '' || pwd == null){--%>
<%--                    alert('PWD를 입력하세요');--%>
<%--                    $('#pwd').focus();--%>
<%--                    return;--%>
<%--                }--%>

<%--                login.send();--%>
<%--            });--%>
<%--        },--%>
<%--        send:function (){--%>
<%--            $('#login_form').attr({--%>
<%--                'method': 'post',--%>
<%--                'action':'<c:url value="loginimpl"/>'--%>
<%--            });--%>
<%--            $('#login_form').submit();--%>
<%--        }--%>
<%--    };--%>

<%--    $(function (){--%>
<%--       login.init();--%>
<%--    });--%>
<%--</script>--%>
<%--<div class="container">--%>
<%--    <h2>Login Page</h2>--%>
<%--    <form id="login_form">--%>
<%--        <div class="form-group">--%>
<%--            <label for="id">ID:</label>--%>
<%--            <input type="text" class="form-control" id="id" placeholder="Enter id" name="id">--%>
<%--        </div>--%>
<%--        <div class="form-group">--%>
<%--            <label for="pwd">Password:</label>--%>
<%--            <input type="password" class="form-control" id="pwd" placeholder="Enter password" name="pwd">--%>
<%--        </div>--%>
<%--        <button type="button" class="btn btn-primary">LOGIN</button>--%>
<%--    </form>--%>

<%--</div>--%>
