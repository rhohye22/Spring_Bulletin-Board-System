<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="mul.cam.a.dto.MemberDto"%>
<%@page import="mul.cam.a.dao.BbsDao"%>
<%@page import="mul.cam.a.dto.BbsDto"%>
<%@page import="mul.cam.a.service.impl.MemberServiceImpl"%>
<%@page import="mul.cam.a.service.MemberService"%>

<%
String message = (String) request.getAttribute("message");
if (message != null && !message.equals("")) {
	if (message.equals("MEMBER_ADD_YES")) {
%>
<script type="text/javascript">
		alert("성공적으로 가입되었습니다");
		location.href = "login.do";
		</script>
<%
} else {
%>
<script type="text/javascript">
		alert("가입되지 않았습니다 다시 가입해 주십시오");
		location.href = "regi.do";
		</script>
<%
}
}

//MemberDto login = (MemberDto)request.getAttribute("login");
String YN = (String) request.getAttribute("YN");
if (YN != null && !YN.equals("")) {
if (YN.equals("MEMBER_YES")) {
%>
<script type="text/javascript">
		alert("성공적으로 로그인되었습니다");
		location.href = "bbslist.do";
		</script>
<%
} else {
%>
<script type="text/javascript">
		alert("로그인에 실패하였습니다");
		location.href = "login.do";
		</script>
<%
}
}



String bbswrite = (String) request.getAttribute("bbswrite");
if (bbswrite != null && !bbswrite.equals("")) {
if (bbswrite.equals("BBS_ADD_OK")) {
%>
<script type="text/javascript">
		alert("성공적으로 작성되었습니다");
		location.href = "bbs?param=bbslist";
		</script>
<%
} else {
%>
<script type="text/javascript">
		alert("다시 작성해 주십시오");
		location.href = "bbs?param=bbswrite";
		</script>
<%
}
}

String answer = (String) request.getAttribute("answer");

if (answer != null && !answer.equals("")) {
if (answer.equals("answer_added_fail")) {
%>
<script type="text/javascript">
		alert("답글 작성에 실패했습니다");
		/* location.href = "bbslist.do"; */
		</script>
<%
} 
}

String bbsupdate = (String) request.getAttribute("bbsupdate");
if (bbsupdate != null && !bbsupdate.equals("")) {
if (bbsupdate.equals("BBS_UPDATE_OK")) {
%>
<script type="text/javascript">
		alert("성공적으로 수정되었습니다");
		location.href = "bbs?param=bbslist";
		</script>
<%
} else {
int seq = (Integer) request.getAttribute("seq");
%>
<script type="text/javascript">
		alert("다시 작성해 주십시오");
		let seq = "<%=seq%>
	";
	location.href = "bbs?param=bbsupdate&seq=" + seq;
</script>
<%
}
}

String bbsdelete = (String) request.getAttribute("bbsdelete");
if (bbsdelete != null && !bbsdelete.equals("")) {
if (bbsdelete.equals("BBS_DELETE_OK")) {
%>
<script type="text/javascript">
	alert("성공적으로 삭제되었습니다");
	location.href = "bbs?param=bbslist";
</script>
<%
} else {
%>
<script type="text/javascript">
	alert("삭제되지 않았습니다");
	location.href = "bbs?param=bbslist";
</script>
<%
}
}
%>
--%>




