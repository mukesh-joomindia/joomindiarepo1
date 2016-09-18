<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<fmt:setBundle basename="label"/>
<fmt:setLocale value="en"/>
<!DOCTYPE html >
<html>
<head>
 <%@include file="header.jsp" %>
</head>
<body class="hold-transition login-page">
<div class="login-box">
  <div class="login-logo">
    <a href="../../index2.html"><b>Admin</b>LTE</a>
  </div>
  <!-- /.login-logo -->
  <div class="login-box-body">
    <p class="login-box-msg"><fmt:message key="user.login.msg"></fmt:message></p>

	<c:if test="${not empty error}">
					
			<h1><c:out value="${error}"></c:out></h1>
	</c:if>

    <form:form action="login" method="post" commandName="userForm">
      <div class="form-group has-feedback">
        <form:input type="email" class="form-control" placeholder="email " path="email"/>
        <span class="glyphicon glyphicon-envelope form-control-feedback"></span>
      	<form:errors path="email"/>
      </div>
      <div class="form-group has-feedback">
        <form:input type="password" class="form-control" placeholder="Password" path="password"/>
        <span class="glyphicon glyphicon-lock form-control-feedback"></span>
      	<form:errors path="password"></form:errors>
      </div>
      <div class="row">
        <div class="col-xs-8">
          <div class="checkbox icheck">
            <label>
              <form:checkbox path="rememberMe"/> <fmt:message key="checkbox.remeberme"></fmt:message>
            </label>
          </div>
        </div>
        <!-- /.col -->
        <div class="col-xs-4">
          <button type="submit" class="btn btn-primary btn-block btn-flat"><fmt:message key="button.signin"/>    </button>
        </div>
        <!-- /.col -->
      </div>
    </form:form>

    <div class="social-auth-links text-center">
      <p>- OR -</p>
      <a href="#" class="btn btn-block btn-social btn-facebook btn-flat"><i class="fa fa-facebook"></i> <fmt:message key="button.facebook"></fmt:message></a>
      <a href="#" class="btn btn-block btn-social btn-google btn-flat"><i class="fa fa-google-plus"></i> <fmt:message key="button.google"></fmt:message></a>
    </div>
    <!-- /.social-auth-links -->

    <a href="#">I forgot my password</a><br>
    <a href="register.html" class="text-center">Register a new membership</a>

  </div>
  <!-- /.login-box-body -->
</div>
<!-- /.login-box -->

<script>
  $(function () {
    $('input').iCheck({
      checkboxClass: 'icheckbox_square-blue',
      radioClass: 'iradio_square-blue',
      increaseArea: '20%' // optional
    });
  });
</script>
</body>
</html>