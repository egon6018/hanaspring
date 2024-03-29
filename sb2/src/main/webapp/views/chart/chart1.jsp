<%--
  Created by IntelliJ IDEA.
  User: goeun
  Date: 2024-03-27
  Time: 오전 9:37
  To change this template use File | Settings | File Templates.
--%>
<script>
    let ajax1 = {
        init: function (){
            setInterval(function(){
                $.ajax({
                    url:'/getservertime',
                    success:function (data){
                        ajax1.display(data);
                    },
                    error:function(){}
                });
            }, 1000);

        },
        display:function (data){
            $('#result').text(data);
        }
    };

    $(function(){
        ajax1.init();
    });
</script>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="container">
    <h2>CHART1 Page</h2>
    <h3>Server Time</h3>
    <h3 id="result"></h3>
</div>
