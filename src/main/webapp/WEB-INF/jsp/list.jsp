
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="common/tag.jsp"%>
<%@include file="common/head.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <title>秒杀列表页</title>
</head>
<body>
<div class="container">

    <div class="panel panel-default">
        <div class="panel-heading text-center">
            <h2>秒杀列表</h2>
        </div>
        <div class="panel-body">
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th>名称</th>
                        <th>库存</th>
                        <th>开始时间</th>
                        <th>结束时间</th>
                        <th>创建时间</th>
                        <th>详情页</th>
                    </tr>
                </thead>
                <tbody>
                <c:forEach var="sk" items="${list}">
                    <tr>
                        <td>${sk.SEC_NAME}</td>
                        <td>${sk.SEC_NUMBER}</td>
                        <td>
                             <fmt:formatDate value="${sk.START_TIME}" pattern="yyyy-MM-dd"/>
                        </td>
                        <td>
                             <fmt:formatDate value="${sk.END_TIME}" pattern="yyyy-MM-dd"/>
                        </td>
                        <td>
                             <fmt:formatDate value="${sk.CREATE_TIME}" pattern="yyyy-MM-dd"/>
                        </td>
                        <td>
                            <a class="btn btn-info" href="/seckill/${sk.SECKILL_ID}/detail" target="_blank">詳情</a>
                        </td>

                    </tr>

                </c:forEach>

                </tbody>
            </table>
        </div>
    </div>

</div>
</body>
</html>
