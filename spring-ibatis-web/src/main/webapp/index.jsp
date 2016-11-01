<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script type="text/javascript">
function showAllTables() {
	var form = document.myForm;
	form.action="allTables.do"
	form.method = "post";
	form.submit();
}
</script>
</head>
<body>
Hello world!!!
<form name="myForm">
	<input type="button" value="테이블보기" onclick="javascript:showAllTables();"/>
</form>
</body>
</html>