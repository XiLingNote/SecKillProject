
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>秒杀详情页</title>
    <%@include file="common/head.jsp"%>
    <%@include file="common/tag.jsp"%>

</head>
<body>
<div class="container">
        <div class="panel panel-default text-center">
            <div class="panel-heading">
                <h1>${seckill.SEC_NAME}</h1>
            </div>
            <div class="panel-body">
                <h2 class="text-danger">
                    <%--time图标--%>
                    <span class="glyphicon glyphicon-time"></span>
                    <%--展示倒计时--%>
                    <span class="glyphicon" id="seckill-box"></span>
                </h2>
            </div>
        </div>

</div>
<%--登陆弹出层，输入电话--%>
<div id="killPhoneModel" class="modal fade">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h3 class=" modal-title text-center">
                    <span class="glyphicon glyphicon-phone"></span>
                    秒杀电话
                </h3>
            </div>
            <div class=" modal-body">
                <div class="row">
                    <div class="col-xs-8-offset-2">
                        <input type="text" name="killPhone" id="killPhoneKey" placeholder="请填写手机号码" class="form-control"/>
                    </div>
                </div>
            </div>
            <div class="modal-footer">
                <span id="killPhoneMessage" class="glyphicon"></span>
                <button type="button" id="killlPhoneBtn" class="btn btn-success">
                    <span class="glyphicon glyphicon-phone"></span>
                    Submit
                </button>
            </div>
        </div>
    </div>
</div>
</body>
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<%--<script src="/resource/javaScript/jquery.min.js"></script>--%>
<%--<script src="/resource/javaScript/bootstrap.js"></script>--%>
<%--<script src="/resource/javaScript/jquery-cookie.js"></script>--%>
<%--<script src="/resource/javaScript/jquery-countDown.js"></script>--%>

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="http://cdn.bootcss.com/jquery/3.1.1/jquery.min.js"></script>
<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="http://cdn.bootcss.com/jquery-cookie/1.4.1/jquery.cookie.js"></script>
<script src="http://cdn.bootcss.com/jquery.countdown/2.2.0/jquery.countdown.js"></script>


<script src="/resource/javaScript/seckill.js" type="text/javascript"></script>
<script type="text/javascript" >
    $(function () {
        //使用el表达式传入参数
        seckill.detail.init({
            seckillId:${seckill.SECKILL_ID},
            startTime:${seckill.START_TIME.time},
            endTime:${seckill.END_TIME.time}
        });
    });


</script>
</html>
