<%@page import="web.project.*"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
</head>


<body>
<main>
		<div class="board">
			<div class="board_tit">
				<h2>REVIEW</h2>
				<a href = "insertReview">작성</a>
				<a href = "/index2.html">채팅</a>
				<div class="sort-wrap clearfix">
					<ul>
						<li>상품에 대한 후기를 남기는 공간입니다. 해당 게시판의 성격과 다른 글은 사전동의 없이 담당 게시판으로
							이동될 수 있습니다.</li>					
					</ul>
					<select id="howAsc" class="sort">
						<option value="recently">최근등록순</option>
						<option value="likes">좋아요많은순</option>
						<option value="myReview">내가 쓴 글</option>
						<a href="/delete/${ReviewDto.review_id}">글 삭제</a>
					</select>
				</div>
			</div>
			<div class="board_table" id="review">
			</div>
		</div>   
      
    </main>
<!-- review test -->	
	
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
  <script type="text/javascript">
  
  /* url에서 num 가져오기 */
  function getParameterByName(name) {
      name = name.replace(/[\[]/, "\\[").replace(/[\]]/, "\\]");
      var regex = new RegExp("[\\?&]" + name + "=([^&#]*)"),
              results = regex.exec(location.search);
      return results == null ? "" : decodeURIComponent(results[1].replace(/\+/g, " "));
  }
  
  /* 리뷰 상세내용 표시 */
  $(document).on('click', '.view_content', function(){
	  var id = this.id;
		$.ajax({
			type : "get",
			url : "view_count",
			data : {"review_id" : id},
			dataType : "json",
			async: false,
			success : function(data) {
				var content = id+"_content";
				if($('#'+content).css("display") == "none"){
					let howAsc = data.howAsc;
					 let pageId = data.page;
					 callReview(pageId, howAsc);
				}else{
					$('#'+content).toggle();
				 }
			},
			error : function(){
			     alert("내용표시 오류발생");  
			}
		});
	  });
  
  /* 좋아요 버튼 클릭 */
  $(document).on('click', '.like_btn',function(){
	  var review_id = this.id;
	 $.ajax({
		   type : "get",
		   url : "clickLikes",
		   data : {"review_id" : review_id},
		   dataType : "json",
		   success : function(data) {
			   let result = data.result;
			   let howAsc = data.howAsc;
			   let pageId = data.page;
			  if(result == "fail")
				  alert("로그인 후 이용해 주세요.")
			  else if(result == "like"){
				  alert("추천해 주셔서 감사합니다.")
				  callReview(pageId, howAsc);			  
			  }else{
				  alert("추천이 취소되었습니다.")
				  callReview(pageId, howAsc);	  
			  }
		   },
		   error : function(){
			   alert("오류발생");  
		   }
	 }); 
	  
  });
  
  
  /* 페이지 변경 */
  $(document).on('click', '.pagebtn', function page(){
	  var pageId = this.id;
	  var howAsc = $("#howAsc").val();
	  callReview(pageId, howAsc);
  });		
  
  /* 리뷰 정렬하기 */
  $(document).on('change', '#howAsc', function asc(){
	  var pageId = 1;
	  var howAsc = $("#howAsc").val();
	  callReview(pageId, howAsc);
  });		
  
  /* 리뷰목록 불러오기 */
  function callReview(pageId, howAsc) {
	var num = getParameterByName('num');
	 
	   $.ajax({
		   type : "get",
		   url : "reviewList",
		   data : {"num" : num,
			       "page" : pageId,
			       "howAsc" : howAsc},
		   dataType : "json",
		   success : function(review) {
				var str = "<table>";
				    str += "<tr class='view_content' id='tr_first'>";
					str += "<td class='tb_no'>번호</td>";
					str += "<td class='tb_tit'>제목</td>";
					str += "<td class='tb_name'>작성자</td>";
					str += "<td class='tb_date'>작성일</td>";
					str += "<td class='tb_help'>좋아요</td>";
					str += "<td class='tb_count'>조회</td>";
					str += "</tr>";
				let list = review.datas;
				$(list).each(function(i, rd){
					/* 리뷰목록 */
					str += "<tr class='view_content' id='" + rd.review_id + "_review' >";
					str += "<td class='tb_no'>" + rd.review_asc + "</td>";	
					str += "<td class='tb_tit'>" + rd.review_title + "</td>";
					str += "<td class='tb_name'>" + rd.cust_id + "</td>";
					str += "<td class='tb_date'>" + rd.review_date + "</td>";
					str += "<td class='tb_help'>" + rd.likes_count + "</td>";
					str += "<td class='tb_count'>" + rd.review_viewCount + "</td>";
					str += "</tr>";
					/* 리뷰 내용 */
					str += "<tr>";
					/* 이미지 여부 체크 */
					if(rd.review_img != null){
						str += "<td class='tb_content' colspan='6'><div class='review_content' id='"
						     + rd.review_id +"_review_content'><br/>";
						str += "<img src='" + rd.review_img +"'><br/>";
						str += rd.review_content + "</div>";
						str += "<button class='like_btn' id='" + rd.review_id + "_likes'>좋아요</button></td>";
					}else{
						str += "<td class='tb_content'><div class='review_content' id='"
						     + rd.review_id +"_review_content'>" + rd.review_content + "</div>";
						str += "<button class='like_btn' id='" + rd.review_id + "_likes'>좋아요</button></td>";     
					}
					
					str += "</tr>"
					
				});
					/* 리뷰 추가 */
					str += "<tr>";
					str += "<td><a href='insertReview?num="+num+"'> 리뷰 쓰기 </a></td>";
					str += "</tr>";
				    str += "</table>";
				    
					/* 페이징 */
					str += "<tr>";
					str += "<td>";
				let totalPage = review.totalPage;
				let page = review.page;
				for(let pageNum = 1; pageNum<=totalPage; pageNum++){
					if(pageNum == page){
					str += "<span class='pagebtn' id='" + pageNum + "'> <b>" + pageNum + "</b> </span>";
					}
					else{
					str += "<span class='pagebtn' id='" + pageNum + "'>" + pageNum + " </span>";
					}
				}
					str += "</td>";
					str += "</tr>";
				    
				    $("#review").html(str);
				    $('.review_content').hide();
				    let content =review.review_id + "_review_content";
				    $('#'+content).toggle();
		},
		   error : function(){
			   alert("오류발생");
			   
		   }
	   });
	
	}; 
  </script>	
<form action="review">
	<h1>출력</h1>
	<c:forEach items="${review}" var="rv">
		<h2>${rv.review_title } / ${rv.review_img }</h2>
	</c:forEach>
</form>
</body>
</html>