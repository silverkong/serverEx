/**
 * login.js
 */
 
 $(document).ready(function(){
 	$('#loginForm').on('submit', function(){
 		// submit 이벤트 기본 기능 : 페이지 새로 고침
 		// 기본 기능 중단
 		event.preventDefault();
 		
 		$.ajax({
 			type: "post",
 			url: "/member/login",
 			data: { "id" :$('#id').val(),
 					"pwd" :$('#pwd').val()},
			dataType: "text",
			success: function(result){
				// 성공 시 수행되는 함수 : 반환되는 값을 result로 받음
				if(result == "success"){
					alert("로그인 성공 \n INDEX 페이지로 이동합니다");
					location.href="/";
				}else{
					alert("아이디 또는 비밀번호 일치하지 않습니다");
				}				
			},
			error: function(){
				// 오류 있을 경우 수행되는 함수
				alert("전송 실패");
			}
 		}); // ajax 끝
 	}); // submit 끝
 });