<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="obj" class="com.Calculator"/>
<jsp:useBean id="objs" class="com.Square"/>
<% int a =obj.cube(5) ;
out.println(a);  

int b=objs.squareofno(5);
out.println(b); 
%>


</body>
</html>