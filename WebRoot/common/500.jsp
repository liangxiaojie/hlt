<%@include file="/public/base/inc2.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>系统消息</title>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<!-- <link rel="stylesheet" href="css/bootstrap.min.css" /> -->
<!-- <link rel="stylesheet" href="css/bootstrap-responsive.min.css" />
<link rel="stylesheet" href="css/matrix-style.css" />
<link rel="stylesheet" href="css/matrix-media.css" /> 
-->
<style type="text/css">
	body{
		background: none repeat scroll 0 0 #eeeeee;
		margin: 0px;
		line-height: 0px;
		
	}

</style>
</head>
<body>
<div id="contenta">
  <div id="content-headera">
    <!-- <div id="breadcrumb"> <a href="#" title="Go to Home" class="tip-bottom"><i class="icon-home"></i> Home</a> <a href="#">Sample pages</a> <a href="#" class="current">Error</a> </div> -->
    <h1>Error 500</h1>
  </div>
  <div class="container-fluid">
    <div class="row-fluid">
      <div class="span12">
        <div class="widget-box">
          <div class="widget-title"> <span class="icon"> <i class="icon-info-sign"></i> </span>
            <h5>错误 500</h5>
          </div>
          <div class="widget-content">
            <div class="error_ex">
              <h1>500</h1>
              <h3>服务器异常.</h3>
              <p>服务器出现异常，请返回重新尝试，或联系管理员。</p>
              <a class="btn btn-warning btn-big" href="<%=request.getContextPath()%>/">返回主页</a> </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>

</body>
</html>
