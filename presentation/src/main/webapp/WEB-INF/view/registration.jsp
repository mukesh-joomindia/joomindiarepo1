<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<head>
   <%@include file="header.jsp" %>
</head>
<body class="hold-transition register-page">
<div class="register-box">
  <div class="register-logo">
    <a href="../../index2.html"><b>Admin</b>LTE</a>
  </div>

  <div class="register-box-body">
    <p class="login-box-msg">Register a new membership</p>

	<div id="warnDiv"></div>
    
    <form:form  method="post" id="regform" action="register" modelAttribute="userForm">
      <div class="form-group has-feedback">
        <form:input type="text" class="form-control" placeholder="First Name" name="firstname" required="required" path="firstName"/>
        <span class="glyphicon glyphicon-user form-control-feedback"></span>
        <form:errors path="firstName"></form:errors>
      </div>
      <div class="form-group has-feedback">
        <form:input type="text" class="form-control" placeholder="Last Name" name="lastname"  path="lastName" required="required"/>
        <span class="glyphicon glyphicon-user form-control-feedback"></span>
  		<form:errors path="lastName"></form:errors>
  		
      </div>
      <div class="form-group has-feedback">
        <form:input type="email" class="form-control" placeholder="Email" name="email" required="required" path="email"/>
        
        <span class="glyphicon glyphicon-envelope form-control-feedback"></span>
      	<form:errors path="email"></form:errors>
      </div>
      <div class="form-group has-feedback">
        <form:input type="password" class="form-control" placeholder="Password" name="password" required="required" onkeyPress="passStrCheck() " id="pass" path="password"/>
        <span class="glyphicon glyphicon-lock form-control-feedback"></span>
        <form:errors path="password"></form:errors>
        <p id="passwarning"></p>
      </div>
      <div class="form-group has-feedback">
        <form:input type="password" class="form-control" placeholder="Retype password" name="repass" required="required" path="repassword"/>
        <span class="glyphicon glyphicon-log-in form-control-feedback"></span>
		<form:errors path="repassword"></form:errors>
      </div>
      
      <div class="form-group has-feedback">
    		<form:select class="selectpicker" path="country">
    		<form:options items="${userForm.countries}" itemValue="name" itemLabel="name"/>
    		<!--<c:forEach items="${countries}" var="countries">   		
      				<option><c:out value="${countries.name}"></c:out></option>
      		</c:forEach>-->
    </form:select>
       
      
    <form:select class="selectpicker" path="state">
    
    		<form:options items="${userForm.states}" itemValue="name" itemLabel="name"/>
    
    		<!--<c:forEach items="${states}" var="state">
      				<option><c:out value="${state.name}"></c:out></option>
      		</c:forEach>-->   		
      		
    </form:select>
    
    <form:select class="selectpicker" path="city">
    		   		
    		   		<form:options items="${userForm.cities}" itemValue="name" itemLabel="name"/>
    		   		
    		<!--<c:forEach items="${cities}" var="city"> 
      				<option><c:out value="${city.name}"></c:out></option>
      		</c:forEach>-->   		
    </form:select>
  </div>
      
      <div class="row">
        <div class="col-xs-8">
          <div class="checkbox icheck">
            <label>
              <input type="checkbox" id="termsCheck" > I agree to the <a href="#">terms</a>
            </label>
          </div>
        </div>
        <!-- /.col -->
        <div class="col-xs-4">
          <button type="submit" class="btn btn-primary btn-block btn-flat" id="formSubmit">Register</button>
        </div>
        <!-- /.col -->
      </div>
      <input type="hidden" name="hidden" value="regularuser"/>
    </form:form>

    <div class="social-auth-links text-center">
      <p>- OR -</p>
      <a href="#" class="btn btn-block btn-social btn-facebook btn-flat"><i class="fa fa-facebook"></i> Sign up using
        Facebook</a>
      <a href="#" class="btn btn-block btn-social btn-google btn-flat"><i class="fa fa-google-plus"></i> Sign up using
        Google+</a>
    </div>

    <a href="login.html" class="text-center">I already have a membership</a>
  </div>
  <!-- /.form-box -->
</div>
<!-- /.register-box -->

<!-- jQuery 2.2.0 -->

<!-- Bootstrap 3.3.6 -->
<script src="bootstrap/js/bootstrap.min.js"></script>
<!-- iCheck -->
<script src="plugins/iCheck/icheck.min.js"></script>
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