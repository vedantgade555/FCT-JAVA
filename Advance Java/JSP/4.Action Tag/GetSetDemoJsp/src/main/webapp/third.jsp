<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<jsp:useBean id="obj1" class="test.User"/>

<jsp:setProperty name="obj1" property="name" value="Ved" />

Record: <br>
<jsp:getProperty name="obj1" property="name"/><br>

</body>
</html>
