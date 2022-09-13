package com.spring_boot.projectEx.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.spring_boot.projectEx.dao.ICartDAO;
import com.spring_boot.projectEx.model.CartVO;
import com.spring_boot.projectEx.model.MemberVO;
import com.spring_boot.projectEx.model.OrderInfoVO;

@Service
public class CartService implements ICartService {
	
	@Autowired
	@Qualifier("ICartDAO")
	ICartDAO dao;

	@Override
	public void insertCart(CartVO vo) {
		dao.insertCart(vo);
	}

	@Override
	public int checkPrdInCart(String prdNo, String memId) {
		// 전달 받은 prdNo, memId를 mapper에 전달
		// 매개변수가 2개 이상인 경우 HashMap으로 전달
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("prdNo", prdNo);
		map.put("memId", memId);
		
		return dao.checkPrdInCart(map);
	}

	@Override
	public void updateQtyInCart(CartVO vo) {
		dao.updateQtyInCart(vo);
	}

	@Override
	public ArrayList<CartVO> cartList(String memId) {
		return dao.cartList(memId);
	}

	@Override
	public void deleteCart(String cartNo) {
		dao.deleteCart(cartNo);
	}

	@Override
	public void updateCart(CartVO vo) {
		dao.updateCart(vo);
	}

	@Override
	public MemberVO getMemberInfo(String memId) {
		return dao.getMemberInfo(memId);
	}

	@Override
	public void insertOrder(OrderInfoVO ordInfoVo) {
		// 1. 주문 정보 저장 : order_info 테이블
		dao.insertOrderInfo(ordInfoVo);
		
		// 2. 주문 상품 내용 저장 : order_product 테이블
		// cart 테이블에서 바로 order_product 테이블로 저장 / cart 가져오기 위해 memId 필요, 주문번호 필요
		// mapper에게 파라미터 2개 전달 : HashMap
		// HashMap에 넣는 작업 필요
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("ordNo", ordInfoVo.getOrdNo());
		map.put("memId", ordInfoVo.getMemId());		
		
		dao.insertOrderProduct(map);
		
		// 3. 주문 완료 후 장바구니 비우기. 해당 회원 것만 삭제 (필요한 정보 : memId)
		dao.deleteCartAfterOrder(ordInfoVo.getMemId());
	}

}
