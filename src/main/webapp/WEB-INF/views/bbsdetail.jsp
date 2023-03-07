<%@page import="mul.cam.a.dto.MemberDto"%>
<%@page import="mul.cam.a.dao.BbsDao"%>
<%@page import="mul.cam.a.dto.BbsDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!-- jQuery CDN -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>

<%
MemberDto login = (MemberDto) session.getAttribute("login");
if (login == null) {
%>
<script type="text/javascript">
	alert("로그인 해주세요");
	location.href = "login.do";
</script>
<%
}
%>

</head>

<%
request.setCharacterEncoding("utf-8");

BbsDto dto = (BbsDto)request.getAttribute("bbsdto");

%>

<body>


	<h1>상세 글보기</h1>

<div align="center">
	<table border="1">
		<col width="80">
		<col width="500">

		<tr>
			<th>작성자</th>
			<td><%=dto.getId()%></td>
		</tr>
		<tr>
			<th>제목</th>
			<td><%=dto.getTitle()%></td>
		</tr>
		<tr>
			<th>작성일</th>
			<td><%=dto.getWdate()%></td>
		</tr>
		<tr>
			<th>조회수</th>
			<td><%=dto.getReadcount()%></td>
		</tr>
		<tr>
			<th>답글정보</th>
			<td></td>
		</tr>
		<tr>
			<th>내용</th>
			<td><textarea style="width: 483px; height: 271px; " readonly="readonly"> <%=dto.getContent()%></textarea></td>
		</tr>

	</table>
	<br>
	<input type="button" value="글목록" id="golist"> 
	<% if( dto.getDepth() == 0){ %> <!-- 답글 1단계로 제한 -->
	<input type="button" value="답글" onclick="answerBbs(<%=dto.getSeq()%>)"> 
	<% } %>
		
	<% if(dto.getId().equals(login.getId())){ %><!-- 작성자가 아니면 버튼X -->
	<input type="button" value="수정" onclick="updateBbs(<%=dto.getSeq()%>)"> 

	<input type="button" value="삭제" onclick="deleteBbs(<%=dto.getSeq()%>)"> 
	<% } %>
</div>
<script type="text/javascript">
	
	$("#golist").click(function() {
		location.href="bbslist.do";
	})
	function answerBbs() {
		location.href="answer.do?seq=<%=dto.getSeq()%>";
	}
	function updateBbs() {
		location.href="bbsupdate.do?seq=<%=dto.getSeq()%>";
	}
	function deleteBbs() {
		location.href="bbsdelete.do?seq=<%=dto.getSeq()%>";
	}
	
	
	
	
	
	
	
</script>







</body>
</html>