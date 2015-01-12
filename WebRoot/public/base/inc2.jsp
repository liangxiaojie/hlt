<%@ include file="/public/base/inc_base.jsp"%>
<%@ page import="com.cmbc.edw.ex.*"%> 
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/public/bootstrap2/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/public/bootstrap2/css/matrix-style.css" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/public/bootstrap2/css/matrix-media.css" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/public/bootstrap2/css/bootstrap-responsive.min.css" />
<link href="<%=request.getContextPath()%>/public/bootstrap2/font-awesome/css/font-awesome.css" rel="stylesheet" /><!-- 菜单图标css -->

<script src="<%=request.getContextPath()%>/public/bootstrap2/js/jquery.min.js"></script>
<script type="text/javascript"  src="<%=request.getContextPath()%>/public/bootstrap2/js/bootstrap.min.js"></script> 
<script type="text/javascript">
//使Iframe自适应高度.
function SetWinHeight(obj) { 
	var win=obj; 
	if (document.getElementById) { 
	if (win && !window.opera) { 
		if (win.contentDocument && win.contentDocument.body.offsetHeight){ 
			win.height = win.contentDocument.body.offsetHeight;
			$("#content").css("height",win.contentDocument.body.offsetHeight+200);
		}else if(win.Document && win.Document.body.scrollHeight){
			win.height = win.Document.body.scrollHeight; 
			$("#content").css("height",win.Document.body.scrollHeight+100);
		} 
			
		} 
	} 
}
</script>


