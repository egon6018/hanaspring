<%--
  Created by IntelliJ IDEA.
  User: goeun
  Date: 2024-03-27
  Time: 오전 9:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- JSTL을 구현하기 위해 아래 c태그 사용 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
    .chart_layout{
        width: 250px;
        height: 200px;
        border: 2px solid red;
    }
</style>
<script>
    let chart3 = {
        init: function (){
            $('#get').click(()=>{
                this.get();
            });
            setInterval(this.get(), 3000);
        },
    };
    $(function(){
        chart3.init();
    });
</script>

<div class="container">
    <h2>CHART3 Page</h2>
    <div class="row well">
        <div id="c1" class="col-sm4 well chart_layout"></div>
        <div id="c2" class="col-sm4 well chart_layout"></div>
        <div id="c3" class="col-sm4 well chart_layout"></div>
    </div>

</div>
