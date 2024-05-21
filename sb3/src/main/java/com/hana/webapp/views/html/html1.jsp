<%--
  Created by IntelliJ IDEA.
  User: goeun
  Date: 2024-03-27
  Time: 오전 9:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
    p{
        color:red;
    }
</style>

<script>
    // jquery시작 $ (주어).ready(함수)
    $(document).ready(function(){
        $('#ptag').text('Replace Text');
        $('h5').click(function(){
            alert('ok');
            $(this).text('Click Event');
        });
    });

    // window.onload = function (){
    //     document.getElementById("ptag").innerHTML = 'Replace Text';
    //     document.querySelector('h5').addEventListener(onclick(function(){
    //         this.innerHTML = 'Click Event';
    //     }));
    // };
</script>

<div class="container">
    <h2>HTML1 Page</h2>
    <h5>Title description, Sep 2, 2017</h5>
    <div class="fakeimg">Fake Image</div>
    <p id="ptag">Some text..</p>
    <span>Span</span>
    <a href="#">A TAG</a>
</div>
