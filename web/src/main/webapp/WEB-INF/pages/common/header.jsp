<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- Header -->
<header>
    <div class="container cr-custom">
        <div class="row">
            <ul class="nav nav-tabs">
                <li<c:if test="${page == 'index'}"> class="active"</c:if>>
                    <a href="/">Home</a>
                </li>
                <li<c:if test="${page == 'currencies'}"> class="active"</c:if>>
                    <a href="/currencies">Currencies</a>
                </li>
                <li<c:if test="${page == 'currencyCoefficients'}"> class="active"</c:if>>
                    <a href="/currencyCoefficients">Currency coefficients</a>
                </li>
                <li<c:if test="${page == 'statistics'}"> class="active"</c:if>>
                    <a href="/statistics">Statistic</a>
                </li>
                <li>
                    <a href='<c:url value="/j_spring_security_logout"/>'>Sign out</a>
                </li>
            </ul>
        </div>
    </div>
</header>
<!-- /Header -->