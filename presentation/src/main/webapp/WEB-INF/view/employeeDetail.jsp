<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
   <head>
 <title>Spring MVC Form Handling</title>
   </head>
<body>
<h2>
Submitted Employee Information</h2>
<table border="1"><tbody>
<tr>     <td>Employee ID </td>      <td>${empId}</td>   </tr>
<tr>      <td>Employee Name</td>      <td>${name}</td>  </tr>
<tr>     <td>Employee Age</td>      <td>${age}</td>     </tr>
<tr>      <td>Employee Salary</td>       <td>${salary}</td> </tr>
</tbody></table>
</body>
</html>