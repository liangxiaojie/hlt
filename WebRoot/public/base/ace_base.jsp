<%@ include file="/public/base/inc_base.jsp"%>
<%@ page import="com.cmbc.edw.ex.*"%> 
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<!-- basic styles -->
<link href="<%=request.getContextPath()%>/public/base/assets/css/bootstrap.min.css" rel="stylesheet" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/public/base/assets/css/font-awesome.min.css" />

<!--[if IE 7]>
  <link rel="stylesheet" href="<%=request.getContextPath()%>/public/base/assets/css/font-awesome-ie7.min.css" />
<![endif]-->

<!-- page specific plugin styles -->

<!-- ace styles -->

<link rel="stylesheet" href="<%=request.getContextPath()%>/public/base/assets/css/ace.min.css" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/public/base/assets/css/ace-rtl.min.css" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/public/base/assets/css/ace-skins.min.css" />

<style>
	.navbar{
		height:50px;
	}
</style>

<!--[if lte IE 8]>
  <link rel="stylesheet" href="<%=request.getContextPath()%>/public/base/assets/css/ace-ie.min.css" />
<![endif]-->

<%-- <script src="<%=request.getContextPath()%>/public/bootstrap2/js/jquery.min.js"></script> --%>
<script type="text/javascript" src="<%=request.getContextPath()%>/public/base/assets/js/jquery.min.js"></script> 

<script src="<%=request.getContextPath()%>/public/base/assets/js/ace-extra.min.js"></script>
<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->

<!--[if lt IE 9]>
	<script src="<%=request.getContextPath()%>/public/base/assets/js/html5shiv.js"></script>
	<script src="<%=request.getContextPath()%>/public/base/assets/js/respond.min.js"></script>
<![endif]-->


<script src="<%=request.getContextPath()%>/public/base/assets/js/bootstrap.min.js"></script>
<script src="<%=request.getContextPath()%>/public/base/assets/js/typeahead-bs2.min.js"></script>

<!-- page specific plugin scripts -->

<!--[if lte IE 8]>
  <script src="<%=request.getContextPath()%>/public/base/assets/js/excanvas.min.js"></script>
<![endif]-->

<script src="<%=request.getContextPath()%>/public/base/assets/js/jquery-ui-1.10.3.custom.min.js"></script>
<script src="<%=request.getContextPath()%>/public/base/assets/js/jquery.ui.touch-punch.min.js"></script>
<script src="<%=request.getContextPath()%>/public/base/assets/js/jquery.slimscroll.min.js"></script>
<script src="<%=request.getContextPath()%>/public/base/assets/js/jquery.easy-pie-chart.min.js"></script>
<script src="<%=request.getContextPath()%>/public/base/assets/js/jquery.sparkline.min.js"></script>
<script src="<%=request.getContextPath()%>/public/base/assets/js/flot/jquery.flot.min.js"></script>
<script src="<%=request.getContextPath()%>/public/base/assets/js/flot/jquery.flot.pie.min.js"></script>
<script src="<%=request.getContextPath()%>/public/base/assets/js/flot/jquery.flot.resize.min.js"></script>

<!-- ace scripts -->

<script src="<%=request.getContextPath()%>/public/base/assets/js/ace-elements.min.js"></script>
<script src="<%=request.getContextPath()%>/public/base/assets/js/ace.min.js"></script>

<!-- inline scripts related to this page -->

<script type="text/javascript">

/* //使Iframe自适应高度.
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
 */
//使Iframe自适应高度.
function SetWinHeight(obj) { 
	var win=obj; 
	var outerWidth = 0;
	var innerWidth;
	outerWidth = window.innerHeight;
	outerWidth = outerWidth-130;
	if (document.getElementById) { 
	if (win && !window.opera) { 
		
		if (win.contentDocument && win.contentDocument.body.offsetHeight){ 
		    win.height=300;
			innerWidth = win.contentDocument.body.offsetHeight;
			console.log(outerWidth+":"+innerWidth);
			if(outerWidth<innerWidth){
				win.height = innerWidth;
			}else{
				win.height = outerWidth;
			} 
		}else if(win.Document && win.Document.body.scrollHeight){
			win.height=300;
			innerWidth = win.Document.body.scrollHeight;
			console.log(outerWidth+":"+innerWidth);
			if(outerWidth<innerWidth){
				win.height = innerWidth;
			}else{
				win.height = outerWidth;
			} 
		} 
			
		} 
	} 
}

</script>

