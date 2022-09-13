// index.js

$(document).ready(function(){
  // 스크롤 시 메인 메뉴 고정
  $(window).on('scroll',function(){
    // 스크롤 되는 문서의 top이 #headerBox 이상이면 메인 메뉴 고정되고 그림자 표시
    if($(document).scrollTop() >= $('#headerBox').height()){
      $('#mainMenuBox').addClass('mainMenuFixed mainMenuShadow');
    }else{
      $('#mainMenuBox').removeClass('mainMenuFixed mainMenuShadow');
    }
  });

  // moveToTop 이미지 클릭시 위로
  $('#moveToTop').on('click', function(){
    $('html, body').animate({scrollTop:0}, 500);
  });
});
