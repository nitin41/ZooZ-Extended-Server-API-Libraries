<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String errorMessage = request.getParameter("errorMessage");

%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<meta http-equiv="cache-control" content="no-cache" />
<title>Super Mario - Failed Transaction</title>	
<link rel="stylesheet" href="css/jquery.mobile-1.1.0.min.css" />
<link rel="stylesheet" type="text/css" href="css/mario-style.css" />
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.6.4/jquery.min.js"></script>
<script src="js/jquery.mobile-1.1.0.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	var errorMsg = '<%=errorMessage%>';
	if (errorMsg != null && errorMsg != 'null') {
		$('#error').html(errorMsg);
	}
});
</script>
</head>

<body>
	<div data-role="page" data-theme="d">
		<div data-role="content" data-contnet-theme="d">

			<table id="wrapper">
				<tr>
					<td>
						<h3>Sorry, your transaction failed.</h3>
						<h5 id="error"></h5>		
						
					</td>
				</tr>
				<tr>
					<td><img alt="Super Mario"
						src="img/supermario-mushrooms.png" /></td>
				</tr>
			</table>
		</div>

	</div>

</body>
</html>