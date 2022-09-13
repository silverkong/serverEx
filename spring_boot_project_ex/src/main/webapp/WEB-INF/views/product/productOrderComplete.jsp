<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<style>
			section{
				margin: 200px 0;
			}
		</style>
	</head>
	<body>
		<div id="wrap">
			<c:import url="/WEB-INF/views/layout/top.jsp"></c:import>
			<section>
				<h3>주문이 완료되었습니다</h3><br><br>
				주문번호 : ${ordNo}
			</section>
			<c:import url="/WEB-INF/views/layout/bottom.jsp"></c:import>
		</div>	
	</body>
</html>