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
<h3>SignUp</h3>
<s:form action="create" method="POST" >
    <s:textfield name="user.email" label="Email"></s:textfield>
    <s:textfield name="user.password" label="Password" type="password"></s:textfield>
    <s:textfield name="user.role" label="Role"></s:textfield>
    <s:textfield name="user.firstName" label="First Name"></s:textfield>
    <s:textfield name="user.lastName" label="Last Name"></s:textfield>
    <s:textfield name="user.phone" label="Phone"></s:textfield>

    <s:textfield name="address.address1" label="Address Line1"></s:textfield>
    <s:textfield name="address.address2" label="Address Line2"></s:textfield>
    <s:textfield name="address.city" label="City"></s:textfield>
    <s:textfield name="address.postalCode" label="PostalCode"></s:textfield>
    <s:textfield name="address.country" label="Country"></s:textfield>

    <s:submit value="Sign Up"></s:submit>
</s:form>
</body>
</html>