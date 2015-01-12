<%@ include file="/public/base/inc3.jsp"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html >
<html>
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />

<title>对账单</title>
<style type="text/css">
/* body {
	background: #EEEEEE;
} */

.orders-info {
	padding-top: 3px;
	padding-bottom: 3px;
}

.li-moth {
	display: none;
}

.modal-dialog{
	width:450px;
}

.pagination>li>a,.pagination>li>span {
	position: relative;
	float: left;
	padding: 23px 46px;
	margin-left: -1px;
	line-height: 1.42857143;
	color: #428bca;
	text-decoration: none;
	background-color: #fff;
	border: 1px solid #ddd;
}

.pagination { /* display: inline-block; */
	padding-left: 0px;
	padding-right: 0px;
	margin:0px;
	/* border-radius: 4px; */
}

.month-nav{
	padding:0px;
}

.panel {
	margin-bottom: 5px;
}

.panel-heading {
	padding: 10px 5px;
}



.page-center{
	width:947px;
	margin:0px;
}
.col-sm-8{
	width:947px!important;
}

.dealtime {
	font-weight: 700;
	font-family: verdana;
}
.panel-body .row .text-block{
	/* border: solid 1px;*/
}
.orders-info{
	margin-bottom:8px;
}

.glyphicon.glyphicon-comment {
	color: #ec7700;
	top: 20px;
	left: 5px;
}

</style>
</head>
<body>
	<!-- top 菜单栏 -->
 <div class="navbar navbar-inverse navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <button class="navbar-toggle collapsed" type="button" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="sr-only">菜单导航</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand hidden-sm" href="<%=request.getContextPath()%>">主页</a>
         <!--  <a href="javascript:void(0)" class="navbar-brand hidden-sm" >后台管理</a> -->
        </div>
        <div class="navbar-collapse collapse" role="navigation">
          <ul class="nav navbar-nav">
            <li class="dropdown">
               <a href="#" target-page="/tester/qt/xdd.jsp" onclick="forwardPage(this)" >发起订单</a>
            </li>  
            <li>
               <a href="#" target-page="/tester/dd/dd.jsp" onclick="forwardPage(this)" >订单跟踪</a>
            </li>
          </ul>
          <ul class="nav navbar-nav navbar-right hidden-sm">
            <li><a href="javascript:void(0)" onclick="siginIn();" id="showUserMsg">登&nbsp;陆</a></li>
          </ul>
        </div>
      </div>
    </div> 

	 <div class="page-body" style="margin-top:60px;"> 
	<div class="page-body-left col-sm-2"></div>
	<div class="page-body-center col-sm-8">
		<span class="glyphicon glyphicon-comment"></span>
		<div class="alert alert-info orders-info" role="alert">&nbsp;&nbsp;【提示】您可以查看每月订单的详情及月结账单信息</div>

		<div class="panel panel-info">
			<div class="panel-heading">
				<h3 class="panel-title">查询项</h3>
			</div>
			<div class="panel-body">Panel content</div>
		</div>


		<nav class="month-nav">
			<ul class="pagination" id="order-months">
				<li><a href='javascript:void(0)' class='order-prep'>&laquo;</a>
				</li>

				<li><a href='javascript:void(0)' class='li-moth moth-1'>&nbsp;1月</a>
				</li>
				<li><a href='javascript:void(0)' class='li-moth moth-2'>&nbsp;2月</a>
				</li>
				<li><a href='javascript:void(0)' class='li-moth moth-3'>&nbsp;3月</a>
				</li>
				<li><a href='javascript:void(0)' class='li-moth moth-4'>&nbsp;4月</a>
				</li>
				<li><a href='javascript:void(0)' class='li-moth moth-5'>&nbsp;5月</a>
				</li>
				<li><a href='javascript:void(0)' class='li-moth moth-6'>&nbsp;6月</a>
				</li>
				<li><a href='javascript:void(0)' class='li-moth moth-7'>7月</a>
				</li>
				<li><a href='javascript:void(0)' class='li-moth moth-8'>8月</a>
				</li>
				<li><a href='javascript:void(0)' class='li-moth moth-9'>9月</a>
				</li>
				<li><a href='javascript:void(0)' class='li-moth moth-10'>10月</a>
				</li>
				<li><a href='javascript:void(0)' class='li-moth moth-11'>11月</a>
				</li>
				<li><a href='javascript:void(0)' class='li-moth moth-12'>12月</a>
				</li>

				<li><a href="javascript:void(0)" class='order-next'>&raquo;</a>
				</li>
			</ul>
		</nav>
		<div class="orders-list">
			<div class="panel panel-default">
				<div class="panel-heading">
					<div class="summary">
						<span> <input type="checkbox" class="J_Selector selector"
							id="cb873697090334379" name="biz_order_id"
							value="873697090334379"> </span> <span class="dealtime"
							title="2014-12-09 22:56">2014-12-09</span> <span
							class="number last-item">订单号：<em>873697090334379</em>
						</span>
					</div>
				</div>
				<div class="panel-body">
					<div class="row">
						<div class="col-md-2 text-block">木质材质，运输加工，木板材质</div>
						<div class="col-md-2 text-block">200kg/空运</div>
						<div class="col-md-4 text-block">暂时未定填什么</div>
						<div class="col-md-2 text-block">
							<strong>$20000</strong><br/>
							<div>
								  运费  :1000.00<br/>
								  费用2:2000.00<br/>
								  其  他 :17000.00<br/>
							 </div> 
						</div>
						<div class="col-md-2">
							<button type="button" class="btn btn-info">查看详情</button>
						</div>
					</div>
				</div>
			</div>
			<div class="panel panel-default">
				<div class="panel-heading">
					<div class="summary">
						<span> <input type="checkbox" class="J_Selector selector"
							id="cb873697090334379" name="biz_order_id"
							value="873697090334379"> </span> <span class="dealtime"
							title="2014-12-09 22:56">2014-12-09</span> <span
							class="number last-item">订单号：<em>873697090334379</em>
						</span>
					</div>
				</div>
				<div class="panel-body">
					<div class="row">
						<div class="col-md-2">木质材质，运输加工，木板材质质材质，运输加工，木板材质质材质，运输加工.</div>
						<div class="col-md-2">200kg/空运</div>
						<div class="col-md-4">暂时未定填什么</div>
						<div class="col-md-2">
							<strong>$20000</strong><br/>
							<div>
								  运费  :1000.00
								  费用2:2000.00
								  其  他 :17000.00
							 </div> 
						</div>
						<div class="col-md-2">
							<button type="button" class="btn btn-info">查看详情</button>
						</div>
					</div>
				</div>
			</div>
			<div class="panel panel-default">
				<div class="panel-heading">
					<div class="summary">
						<span> <input type="checkbox" class="J_Selector selector"
							id="cb873697090334379" name="biz_order_id"
							value="873697090334379"> </span> <span class="dealtime"
							title="2014-12-09 22:56">2014-12-09</span> <span
							class="number last-item">订单号：<em>873697090334379</em>
						</span>
					</div>
				</div>
				<div class="panel-body">
					<div class="row">
						<div class="col-md-2">木质材质，运输加工，木板材质</div>
						<div class="col-md-2">200kg/空运</div>
						<div class="col-md-4">暂时未定填什么</div>
						<div class="col-md-2">
							<strong>$20000</strong><br/>
							<div>
								  运费  :1000.00<br/>
								  费用2:2000.00<br/>
								  其  他 :17000.00<br/>
							 </div> 
						</div>
						<div class="col-md-2">
							<button type="button" class="btn btn-info">查看详情</button>
						</div>
					</div>
				</div>
			</div>

			<div class="panel panel-default">
				<div class="panel-heading">
					<div class="summary">
						<span> <input type="checkbox" class="J_Selector selector"
							id="cb873697090334379" name="biz_order_id"
							value="873697090334379"> </span> <span class="dealtime"
							title="2014-12-09 22:56">2014-12-09</span> <span
							class="number last-item">订单号：<em>873697090334379</em>
						</span>
					</div>
				</div>
				<div class="panel-body">
					<div class="row">
						<div class="col-md-2">木质材质，运输加工，木板材质</div>
						<div class="col-md-2">200kg/空运</div>
						<div class="col-md-4">暂时未定填什么</div>
						<div class="col-md-2">
							<strong>$20000</strong><br/>
							<div>
								  运费  :1000.00<br/>
								  费用2:2000.00<br/>
								  其  他 :17000.00<br/>
							 </div> 
						</div>
						<div class="col-md-2">
							<button type="button" class="btn btn-info">查看详情</button>
						</div>
					</div>
				</div>
			</div>
			
			<div class="panel panel-default">
				<div class="panel-heading">
					<div class="summary">
						<span> <input type="checkbox" class="J_Selector selector"
							id="cb873697090334379" name="biz_order_id"
							value="873697090334379"> </span> <span class="dealtime"
							title="2014-12-09 22:56">2014-12-09</span> <span
							class="number last-item">订单号：<em>873697090334379</em>
						</span>
					</div>
				</div>
				<div class="panel-body">Panel content</div>
			</div>
			<div class="panel panel-default">
				<div class="panel-heading">
					<div class="summary">
						<span> <input type="checkbox" class="J_Selector selector"
							id="cb873697090334379" name="biz_order_id"
							value="873697090334379"> </span> <span class="dealtime"
							title="2014-12-09 22:56">2014-12-09</span> <span
							class="number last-item">订单号：<em>873697090334379</em>
						</span>
					</div>
				</div>
				<div class="panel-body">Panel content</div>
			</div>
			<div class="panel panel-default">
				<div class="panel-heading">
					<div class="summary">
						<span> <input type="checkbox" class="J_Selector selector"
							id="cb873697090334379" name="biz_order_id"
							value="873697090334379"> </span> <span class="dealtime"
							title="2014-12-09 22:56">2014-12-09</span> <span
							class="number last-item">订单号：<em>873697090334379</em>
						</span>
					</div>
				</div>
				<div class="panel-body">Panel content</div>
			</div>
			
			<div class="panel panel-default">
				<div class="panel-heading">
					<div class="summary">
						<span> <input type="checkbox" class="J_Selector selector"
							id="cb873697090334379" name="biz_order_id"
							value="873697090334379"> </span> <span class="dealtime"
							title="2014-12-09 22:56">2014-12-09</span> <span
							class="number last-item">订单号：<em>873697090334379</em>
						</span>
					</div>
				</div>
				<div class="panel-body">Panel content</div>
			</div>	
					
		</div>
	</div>
	<div class="page-body-right col-sm-2"></div>
	</div>

<!-- 登陆页面 -->

	<div class="modal fade" id="sigin-div" tabindex="-1" role="dialog"
		aria-labelledby="addlabel" aria-hidden="false">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header"></div>
				<div class="modal-body">
				

					<div class="row sigin-body">
						<div class="col-md-12">
							<figure class="text-center">
								<a href="./index.html"> <img class="img-logo"
									src="images/logo.png" alt=""> </a>
							</figure>
						</div>
					</div>
					<section class="sign-in-up-content" style="display:block">
						<div class="row">
							<div class="col-md-12">
								<h4 class="text-center">用户登入</h4>
								<form class="sign-in-up-form" action="login.do?invoke=login"
									role="form">
									<!-- <input type="hidden" name="invoke" value="login" /> -->
									<!-- Input 1 -->
									<div class="form-group">
										<input class="form-control" id="login_userId" name="userId"
											type="text" placeholder="输入您的用户名">
									</div>
									<!-- /.form-group -->
									<!-- Input 2 -->
									<div class="form-group">
										<input class="form-control" id="login_password" name="password"
											type="password" placeholder="输入您的密码">
									</div>
									<!-- /.form-group -->
									<!-- Button -->
									<button class="btn btn-success btn-block" type="button" onClick="login();">登&nbsp;&nbsp;&nbsp;&nbsp;陆</button>
									<!-- Checkbox -->
									<section class="text-center">
										<div class="checkbox">
											<label> <input type="checkbox" checked="">
												记住登陆状态 </label>
										</div>
										<!-- /.checkbox -->
									</section>
									<!-- /.text-center -->
									<!-- Sign In/Sign Up links -->
									<section class="sign-in-up-links text-center">
										<p>
											<a href="./forgot-password.html">忘记密码?</a> <span class="sep">–</span>
											<a href="./sign-up.html">申请账户?</a>
										</p>
									</section>
								</form>
							</div>
						</div>
					</section>
					<div class="row">
						<div class="col-md-12">
							<section class="footer-copyright text-center"></section>

						</div>
					</div>
				
<!-- 					<iframe width="400px" align="center" height="270px" id="win" name="win" 
						 frameborder="0" scrolling="no" src="/hlt/login.jsp">
					</iframe>  -->	
				</div>
				<div class="modal-footer"></div>
			</div>
		</div>
	</div>


<script type="text/javascript">

var currentMonth = (new Date().getMonth())+1;  //当前月.

window.onload = function(){
	initMonths();
}


//创建日期列表
function initMonths(){

	initMothList(currentMonth);
	//绑定事件
	$(".li-moth").click(function(me){
		$(".li-moth").parent().removeClass("active");
		$(me.target).parent().addClass("active");
	});

	//绑定淡入淡出效果
	$(".order-next").click(function(){
		$(".li-moth").fadeOut("fast",function(){
			initMothList(12);
		});
	});	

	//绑定淡入淡出效果
	$(".order-prep").click(function(){
		$(".li-moth").fadeOut("fast",function(){
			initMothList(1);
		});
	});		
}

function initMothList(start){
	$(".li-moth").parent().removeClass("active");
	$(".li-moth").hide();
	if(!start) start = 1;  //默认值为1月
	var max = 6;
	if(start>6){ start = 7; max = 12};
	
	for(start;start <= max;start++){
		if(start == currentMonth){ $(".moth-"+start).parent().addClass("active") };
		$(".moth-"+start).show();
	}

}


</script>
</body>
</html>