<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>

<form role="form" action='<c:url value="/j_spring_security_check" />' method="POST" id="signin-form">
    <table style="margin: 0px auto;">
        <tr>
            <td style="padding: 10px;"><label for="username">Login:</label></td>
            <td><input id="username" name="j_username" type="text" class="form-control"/></td>
        </tr>
        <tr>
            <td><label for="password">Password:</label></td>
            <td><input id="password" name="j_password" type="password" class="form-control"/></td>
        </tr>
        <tr>
            <td colspan="2" style="text-align: center; padding-top: 24px;">
                <button class="btn btn-primary" id="signin-button" style="width: 140px;">Sign in</button>
            </td>
        </tr>
        <tr>
            <td colspan="2" style="text-align: center; padding-top: 24px; color:red;">
                <c:if test="${not empty SPRING_SECURITY_LAST_EXCEPTION && SPRING_SECURITY_LAST_EXCEPTION.getClass().getSimpleName() == 'BadCredentialsException'}">
                    <font color="red">
                        Invalid password or login!
                        <c:remove var = "SPRING_SECURITY_LAST_EXCEPTION" scope = "session" />
                    </font>
                </c:if>
            </td>
        </tr>
    </table>
</form>

<script type="text/javascript">

    function enableLogin(){
        var button = document.getElementById('signin-button');

        button.disabled = document.getElementById('password').value.length == 0
                || document.getElementById('username').value.length == 0;
    }

    var passwordInput = document.getElementById('password');
    passwordInput.oninput = function() {enableLogin();}
    var usernameInput = document.getElementById('username');
    usernameInput.oninput = function() {enableLogin();}

    var myForm = document.getElementById('signin-form');
    myForm.onsubmit = function() {
        var allInputs = myForm.getElementsByTagName('input');
        var input, i;
        var result = true;
        for (i = 0; input = allInputs[i]; i++) {
            if (!input.value || input.value.trim() === '') {
                input.value = '';
                result = false;
            }
        }
        return result;
    };
</script>