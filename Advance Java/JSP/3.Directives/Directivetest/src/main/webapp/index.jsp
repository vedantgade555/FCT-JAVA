<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.Date"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%-- <%@ page import="java.util.Date"  %> --%>

Today is : <%= new Date() %>>

</body>
</html>


<%-- Specifies the scripting language used in JSP --%>
<%-- Sets response MIME type and character encoding --%>
<%-- Encoding used for the JSP file itself --%>
<%-- Imports Date class so it can be used in JSP --%>
<%-- Enables HTTP session (default is true) --%>
<%-- Redirects to error.jsp if an exception occurs --%>
<%-- Indicates this page can handle exceptions --%>
<%-- JSP will extend this custom servlet class --%>