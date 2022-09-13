// subMenu.js

$(document).ready(function(){
  // 전체보기 눌렀을 때 메뉴항목 보이게
    $('#showAllMenu').on('click', function(){
      if ($(this).text() == '전체보기 ▼') {
        $('#subMenuBox').css('visibility','visible');
        $(this).text('메뉴닫기 ▲').css('color','blue');
      }else{
        $('#subMenuBox').css('visibility','hidden');
        $(this).text('전체보기 ▼').css('color','black');
      }
    });
});
