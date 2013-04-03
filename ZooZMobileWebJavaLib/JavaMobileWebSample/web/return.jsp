<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.net.URLEncoder"%>

<% 
	String transactionId = request.getParameter("transactionID");
	String transactionDisplayId = request.getParameter("transactionDisplayID");
	String sessionToken = request.getParameter("sessionToken");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1" />
<meta http-equiv="pragma" content="no-cache"/>
<meta http-equiv="expires" content="0"/> 
<meta http-equiv="cache-control" content="no-cache" />
<title>Super Mario</title>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.6.4/jquery.min.js"></script>
<script type="text/javascript">
		$(document).ready(function() {
			$('#confirmForm').trigger('submit');
		});
</script>
</head>
<body>
	<form id="confirmForm" action="/mobilewebsample/SampleServlet">
		<input type="hidden" name="cmd" value="verifyTrx">
		<input type="hidden" name="transactionID" value="<%=transactionId%>">
		<input type="hidden" name="transactionDisplayID" value="<%=transactionDisplayId%>">
		<input type="hidden" name="sessionToken" value="<%=sessionToken%>">
	</form>
</body>
</html>