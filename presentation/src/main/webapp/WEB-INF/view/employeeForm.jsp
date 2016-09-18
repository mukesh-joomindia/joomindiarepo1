<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
 <head>
  
  <title>Spring MVC Form Handling</title>
 </head>
 <body>
<h2>
Employee Data Form</h2>
<form:form action="/sdnext/addEmployee" method="POST">      
<table><tbody>
<tr>        <td><form:label path="empId">Employee :</form:label></td>      <td><form:input path="empId"></form:input></td>    </tr>
<tr>      <td><form:label path="name">EmployeeName:/form:label&gt;</form:label></td>       <td><form:input path="name"></form:input></td>    </tr>
<tr>       <td><form:label path="age">Employee Age:</form:label></td>       <td><form:input path="age"></form:input></td>     </tr>
<tr>      <td><form:label path="salary">Employee Salary:</form:label></td>     <td><form:input path="salary"></form:input></td>    </tr>
<tr>         <td colspan="2">&lt;input type="submit" value="Submit"/&gt;  </td>       </tr>
</tbody></table>
</form:form>
</body>
</html>