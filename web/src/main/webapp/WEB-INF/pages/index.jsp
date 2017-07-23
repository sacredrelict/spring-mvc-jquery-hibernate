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
            <h4>Please, choose currencies pair and date range.</h4>
            <div class="form-group col-md-8">
                <label for="currencyFirst">Currency first</label>
                <div>
                    <select name="currencyFirst" id="currencyFirst" class="form-control currencyFirstSelect">
                        <option></option>
                        <c:forEach items="${currenciesFirst}" var="currencyCoefficientFirst">
                            <option value="${currencyCoefficientFirst.id}">${currencyCoefficientFirst.name}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>
            <div class="form-group col-md-8">
                <label for="currencySecond">Currency second</label>
                <div>
                    <select name="currencySecond" id="currencySecond" class="form-control currencySecondSelect">
                        <c:forEach items="${currencyCoefficientsSecond}" var="currencyCoefficientSecond">
                            <option value="${currencyCoefficientSecond.id}">${currencyCoefficientSecond.name}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>
            <div class="form-group col-md-8">
                <label for="dateFrom">Date from</label>
                <input type="text" id="dateFrom" name="dateFrom" class="form-control dateFrom">
                <label for="dateTo">to</label>
                <input type="text" id="dateTo" name="dateTo"  class="form-control dateTo">
            </div>
            <div class="form-group col-md-8">
                <button class="btn currencyPairBtn">Get data</button>
            </div>
            <div class="form-group col-md-8 bg-warning error-block d-none">
                <p>Please, fill out all required fields!</p>
            </div>
        </div>
    </div>

    <div class="container">
        <div class="row">
            <h4>List of currency coefficients:</h4>
            <div class="table-responsive">
                <table class="table table-hover table-condensed table-striped ajax-table">
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

    <script>
        $( function() {
            var dateFormat = "mm/dd/yy",
                    from = $( "#dateFrom" )
                            .datepicker({
                                defaultDate: new Date(2017, 4, 7),
                                changeMonth: true,
                                numberOfMonths: 1,
                                minDate: new Date(2017, 4, 7),
                                maxDate: new Date(2017, 4, 14)
                            })
                            .on( "change", function() {
                                to.datepicker( "option", "minDate", getDate( this ) );
                            }),
                    to = $( "#dateTo" ).datepicker({
                                defaultDate: new Date(2017, 4, 14),
                                changeMonth: true,
                                numberOfMonths: 1,
                                minDate: new Date(2017, 4, 7),
                                maxDate: new Date(2017, 4, 14)
                            })
                            .on( "change", function() {
                                from.datepicker( "option", "maxDate", getDate( this ) );
                            });

            function getDate( element ) {
                var date;
                try {
                    date = $.datepicker.parseDate( dateFormat, element.value );
                } catch( error ) {
                    date = null;
                }

                return date;
            }
        } );
    </script>
</body>
</html>