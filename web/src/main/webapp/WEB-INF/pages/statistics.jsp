<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
    <jsp:include page="common/head.jsp"/>
</head>
<body>

<jsp:include page="common/header.jsp"/>

<div class="container">
    <div class="row">
        <h4>Statistic:</h4>
        <div class="table-responsive">
            <table class="table table-hover table-condensed table-striped">
                <thead>
                <tr>
                    <th class="col-md-2">ID</th>
                    <th class="col-md-2">Time</th>
                    <th class="col-md-2">Ip</th>
                    <th class="col-md-2">Currency First</th>
                    <th class="col-md-2">Currency Second</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${statistics}" var="statistic">
                    <tr>
                        <td>${statistic.id}</td>
                        <td>${statistic.time}</td>
                        <td>${statistic.ip}</td>
                        <td>${statistic.currencyFirst.name}</td>
                        <td>${statistic.currencySecond.name}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>

<jsp:include page="common/footer.jsp"/>
</body>
</html>