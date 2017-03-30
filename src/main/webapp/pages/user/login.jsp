<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%-- Using Struts2 Tags in JSP --%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Login Page</title>
</head>
<body>
<h3>Login</h3>
<s:form action="login">
    <s:textfield name="user.email" label="Email"></s:textfield>
    <s:textfield name="user.password" label="Password" type="password"></s:textfield>
    <s:submit value="Login"></s:submit>
</s:form>
<a href="<s:url value="register/createForm"  />" target="_blank">SignUp Here</a>
</body>
</html>