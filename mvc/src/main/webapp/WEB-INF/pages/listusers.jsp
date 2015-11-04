<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  <title>List of users</title>
  <meta http-equiv="Content-Type" content="text/html;charset=UTF-8"/>
</head>
<body>
<h1>Our users are:</h1>
<ul>
<c:forEach items="${requestScope.listusers}" var="listuser">
  <li>${listuser}</li>
</c:forEach>
</ul>
</body>
</html>
