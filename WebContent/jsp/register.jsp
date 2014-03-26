<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.util.TransCodeTool" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:useBean id="person" class="com.model.Person" scope="request">
	<jsp:setProperty name="person" property="*" />
</jsp:useBean>
<jsp:forward page="show.jsp"/>
