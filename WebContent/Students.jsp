<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import= "java.util.ArrayList" %>
<%@ taglib uri= "http://java.sun.com/jsp/jstl/core" prefix= "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Students</title>
</head>
<body>

<h1>List of Students</h1>
<table><tbody>
<%	ArrayList<String>a=(ArrayList<String>)request.getAttribute("ListOfStudents");
 	for(String student:a) {
 		out.println("<tr><td>" + student + "</td></tr>");
 	}
 %>
</tbody></table>

</body>
</html>