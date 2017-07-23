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
        <h4>List of currency coefficients:</h4>
        <div class="table-responsive">
            <table class="table table-hover table-condensed table-striped">
                <thead>
                <tr>
                    <th class="col-md-2">ID</th>
                    <th class="col-md-2">Time</th>
                    <th class="col-md-2">Currency 1</th>
                    <th class="col-md-2">Coefficient</th>
                    <th class="col-md-2">Currency 2</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${currencyCoefficients}" var="currencyCoefficient">
                    <tr>
                        <td>${currencyCoefficient.id}</td>
                        <td>${currencyCoefficient.time}</td>
                        <td>${currencyCoefficient.currencyFirst.name}</td>
                        <td>${currencyCoefficient.coefficient}</td>
                        <td>${currencyCoefficient.currencySecond.name}</td>
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