<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>상품 상세 정보 조회</title>
		<style>
			table{
				width: 800px;
			}
		</style>
	</head>
	<body>
		<div id="wrap">
			<c:import url="/WEB-INF/views/layout/top.jsp"></c:import>
			<section><br><br>
			<h3>상품 상세 정보 조회</h3><br>
			<form method="post" action="<c:url value='/product/insertCart'/>">
				<table border="1">
					<tr>
						<td rowspan="9"><img src="<c:url value='/images/${prd.prdImg}'/>" width="300" height="250"></td>
					</tr>
					<tr>
						<th>상품번호</th>
						<td><input type="hidden" name="prdNo" value="${prd.prdNo}">${prd.prdNo}</td>
					</tr>
					<tr>
						<th>상품명</th>
						<td>${prd.prdName}</td>
					</tr>
					<tr>
						<th>상품가격</th>
						<td><fmt:formatNumber value="${prd.prdPrice}" pattern="#,###"/>원</td>
					</tr>
					<tr>
						<th>제조회사</th>
						<td>${prd.prdCompany}</td>
					</tr>					
					<tr>
						<th>상품설명</th>
						<td>${prd.prdDescript}</td>
					</tr>
					<tr>
						<th>주문수량</th>
						<td>
							<input type="button" value="-" onClick="qtyChange(-1)">
							<input type="text" id="cartQty" name="cartQty" value="1" size="5" readonly>
							<input type="button" value="+" onClick="qtyChange(1)">개
							<script>
								var qty = 1;
								
								// 주문수량 증감하는 함수
								function qtyChange(num){
									qty = qty + num;
									if(qty < 1){
										qty = 1;
									}
									
									calAmount();
								}
								
								// 주문액 계산하는 함수
								function calAmount(){
									var cartQty = document.getElementById('cartQty');
									var amount = document.getElementById('amount');
									
									var total = qty * ${prd.prdPrice};
									cartQty.value = qty;
									amount.innerHTML = total.toLocaleString(); //천단위 구분
								}
							</script>
						</td>
					</tr>
					<tr>
						<th>구매 예정 금액</th>
						<td><span id="amount"><fmt:formatNumber value="${prd.prdPrice}" pattern="#,###"/></span>원</td>
					</tr>
					<tr>
						<td colspan="2">
							<!-- 로그인 하지 않은 경우에는 [로그인] 버튼 출력 -->
							<!-- 로그인 하지 않은 경우 -->
							<c:if test="${empty sessionScope.sid}">
								<button><a href="<c:url value='/loginForm'/>">로그인</a></button>
							</c:if>
							<!-- 로그인 성공한 경우 -->
							<c:if test="${not empty sessionScope.sid}">
								<input type="submit" id="insertCart" value="장바구니">
								<input type="button" id="insertOrder" value="주문하기">
							</c:if>							
							<!-- 로그인 한 경우에는 [장바구니] [주문하기] 버튼 출력 -->
						</td>
					</tr>
				</table>
			</form><br><br>
			<a href="<c:url value='/product/productListCtg/${prd.ctgId}'/>"><button>상품 목록으로 돌아가기</button></a>
			</section>
			<c:import url="/WEB-INF/views/layout/bottom.jsp"></c:import>
		</div>		
	</body>
</html>