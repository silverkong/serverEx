package com.spring_boot.projectEx.dao;

import java.util.ArrayList;
import java.util.HashMap;

import com.spring_boot.projectEx.model.CartVO;
import com.spring_boot.projectEx.model.MemberVO;
import com.spring_boot.projectEx.model.OrderInfoVO;

public interface ICartDAO {
	public void insertCart(CartVO vo);								// 장바구니에 추가
	public int checkPrdInCart(HashMap<String, Object> map);			// 동일 상품 존재 여부 확인
	public void updateQtyInCart(CartVO vo);							// 동일 상품이 존재하는 경우 수량만 변경
	public ArrayList<CartVO> cartList(String memId);				// 장바구니에서 해당하는 멤버만 보여줌
	public void deleteCart(String cartNo);							// 장바구니에서 삭제
	
	// 주문 처리 작업
	public void updateCart(CartVO vo);
	public MemberVO getMemberInfo(String memId);					// 주문서에 출력할 회원정보 알아오기
	
	// 주문 내역 저장
	public void insertOrderInfo(OrderInfoVO ordInfoVo);				// 주문 관련 정보 저장
	public void insertOrderProduct(HashMap<String, Object> map);	// 주문 상품 내용 저장
	public void deleteCartAfterOrder(String memId);					// 주문 후 장바구니에서 삭제
}
