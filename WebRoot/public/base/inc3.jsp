<%@ include file="/public/base/inc_base.jsp"%>
<%@ page import="com.cmbc.edw.ex.*"%> 
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript"  src="<%=request.getContextPath()%>/public/js/jquery/jquery.min.js"></script>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/public/bootstrap3/css/bootstrap.min.css" />
<script type="text/javascript"  src="<%=request.getContextPath()%>/public/bootstrap3/js/bootstrap.js"></script>
<style  type="text/css">
 html, body  
     {  
         height: 100%;  
         width: 100%;  
         margin: 0;  
         padding: 0;  
     }
     
a:link {
	color: #FF0000;
	font-size: 14px;
}
</style>
<script type="text/javascript">

var app = {}
var currentUser = "";

app.PATH = '<%=request.getContextPath()%>';

function login(){
	var para = getFormValues($(".sign-in-up-form"));
	$.ajax({
		url:app.PATH+'/login.do?invoke=login',
		cache:false,
		data:para,
		success:function(response){
			console.log(response);
			currentUser = $("#login_userId").val();
			$("#sigin-div").modal('hide');
			$("#showUserMsg").text("欢迎您:"+currentUser);
		},
		error:function(response){
			currentUser = $("#login_userId").val();
			$("#sigin-div").modal('hide');
			$("#showUserMsg").text("欢迎您:"+currentUser);
		}
	});
	
}

//页面跳转前的操作.
function forwardPage(me){
	if(currentUser =="" || !currentUser){
		$("#sigin-div").modal('show');
		return;
	}
	console.log(me);
	var url = $(me).attr("target-page");
	
	window.open(app.PATH+url, "_blank");
}

function siginIn(){
	$("#sigin-div").modal('show');
}


function getFormValues(form){
	return $(form).serialize();
}

</script>

