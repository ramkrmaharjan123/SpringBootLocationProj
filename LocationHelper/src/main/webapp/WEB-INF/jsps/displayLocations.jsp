<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Locations</title>
</head>
<body>

<h2>Locations:</h2>

<table>
<thead>
<tr>
<th>id</th>
<th>code</th>
<th>name</th>
<th>type</th>
</tr>
<thead>
<tbody>
<c:forEach items = "${locations}" var="location">
<tr>
<td>${location.id} </td>
<td>${location.code } </td>
<td>${location.name} </td>
<td>${location.type} </td>
<td><a href="deleteLocation?id=${location.id}">Delete</a> </td>
</tr>
</c:forEach>

</tbody>
</table>

<a href="showCreate">Add Record</a>
</body>
</html>