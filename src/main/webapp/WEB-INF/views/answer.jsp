<%@page import="mul.cam.a.dto.BbsDto"%>
<%@page import="mul.cam.a.dto.MemberDto"%>
<%@page import="mul.cam.a.util.Utility"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%
MemberDto login = (MemberDto) session.getAttribute("login");
if (login == null) {
%>
<script>
	alert('로그인 해 주십시오');
	location.href = "login.do";
</script>
<%
}
%>	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>
	<%

	BbsDto dto = (BbsDto)request.getAttribute("dto");
	%>
	<div align="center">
		<h1>부모글</h1>

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
				<th>내용</th>
				<td><textarea
						style="width: 439px; height: 149px; resize: none;"
						readonly="readonly"> <%=dto.getContent()%></textarea></td>
			</tr>
		</table>
	</div>

	<div align="center">
		<h1>답글</h1>
		<form action="answerAf.do" method="post">
			<table border="1">
				<col width="80">
				<col width="500">

				<tr>
					<th>작성자</th>
					<td><%=login.getId()%>
					<input type="hidden" value="<%=login.getId()%>" name="id"> 
					<input type="hidden" value="<%=dto.getSeq()%>" name="seq">
					 
					</td>
					
				</tr>
				<tr>
					<th>제목</th>
					<td><input type="text" id="title" name="title"
						style="width: 470px;" placeholder="제목기입"></td>
				</tr>

				</tr>
				<tr>
					<th>내용</th>
					<td><textarea  id="content" name="content"
							style="width: 439px; height: 149px; resize: none;"
							placeholder="내용기입"> </textarea></td>
				</tr>

				<tr>
					<td align="center" colspan="2"><input type="submit"
						value="작성완료"></td>
				</tr>
			</table>
		</form>
	</div>


</body>
</html>