<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="EUC-KR">
    <title></title>
</head>
<body>
<script>
    let msg = "<c:out value='${msg}'/>";
    let url = "<c:out value='${location}'/>";
    alert(msg);
    location.href = url;
</script>
</body>
</html>