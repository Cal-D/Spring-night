<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


//
\\172.16.3.100

workspace
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script type="text/javascript">
	$(function () {
		$("h1").click(function(){
			$.ajax({
				url : "menu.get",
				success : function(xml){
					var ar = xml.menu;
					$.each(ar,function(i,m){
						alert(m.m_name);
						alert(ar[i].m_price);
					});						
					
				/*	$(xml).find("menu").each(function(i,m){
						alert($(this).find("m_name").text());
					});*/
				}  
			});
		});
	
	});
	

</script>
<title>Insert title here</title>
</head>
<body>
<h1>눌러보시오</h1>
	<c:forEach var= "m" items ="${menus}">
		${m.m_name } :
		<fmt:formatNumber value="${m.m_price}" type="currency"/> 
		<br>
	</c:forEach>


</body>
</html>