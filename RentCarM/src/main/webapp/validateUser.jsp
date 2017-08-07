<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%
	if (session.getAttribute("normalUser") == null) {
		response.sendRedirect("login.jsp");
	}
 %>
