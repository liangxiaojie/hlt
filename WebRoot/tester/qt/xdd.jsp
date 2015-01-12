<%@ include file="/public/base/inc3.jsp"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE html >
<html>
<head>

<title>恒路通物流</title>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<style type="text/css">
.modal-dialog {
	margin-top: 12%;
	width: 450px;
}
input:invalid{  color:red; }
.glyphicon{
	right:35px;
}


</style>
<script type="text/javascript"  src="<%=request.getContextPath()%>/index.js"></script>
</head>
<body>

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
            <li >
     			 <a href="#" target-page="/tester/dzd/dzd.jsp" onclick="forwardPage(this)" >每月对账</a>
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


	
	<!-- body 主体页面内容 -->
	<div class="wrap page-body">
	<div class="page-body-left col-sm-1"></div>
	<div class="page-body-center col-sm-5">
			<div class="form-horizontal" role="form" style="margin-top:70px;width:500px;">
			<form class="main form-horizontal" id="order-form" onsubmit="return before_submit();"
				action="main/active" onsubmit="return check();">
					<div class="progress">
						<div class="progress-bar" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 0%;"></div>
					</div>	
				<fieldset>
				<div class="order-step-1">	
					<legend>发货人信息<font  size="2">（请输入手机/邮箱，系统将对您进行自动注册）</font></legend>
					<div class="form-group">
						<label for="inputEmail3" class="col-sm-3 control-label">发&nbsp;货&nbsp;人</label>
						<div class="col-sm-7">
							<input id="username" name="username" type="text" class="form-control"
								placeholder="发货人姓名" required>
						</div>
					</div>

					<div class="form-group">
						<label for="inputEmail3" class="col-sm-3 control-label">始&nbsp;发&nbsp;地</label>
						<div class="col-sm-7">
							<input id="sfd" name="sfd" type="text" class="form-control"
								 placeholder="必填项" required>
						</div>
					</div>


					<div class="form-group">
						<label for="inputEmail3" class="col-sm-3 control-label">发货单位</label>
						<div class="col-sm-7">
							<input id="userId" name="userId" type="text" class="form-control"
								id="exampleInputEmail1" placeholder="必填项" required>
						</div>
					</div>
					<!-- <legend>管理员信息</legend> -->

<!-- 					
					<div class="form-group">
						<label for="inputEmail3" class="col-sm-3 control-label">性别</label>
						<div class="col-sm-7">
							<label class="radio-inline"> <input type="radio"
								name="inlineRadioOptions" id="inlineRadio1" value="option1">
								男 </label> <label class="radio-inline"> <input type="radio"
								name="inlineRadioOptions" id="inlineRadio2" value="option2">
								女 </label>
						</div>
					</div> 
-->

					<div class="form-group">
						<label for="inputEmail3" class="col-sm-3 control-label">发货地址</label>
						<div class="col-sm-7">
							<input id="userId" name="userId" type="text" class="form-control"
								id="exampleInputEmail1" placeholder="必填项" required>
						</div>
					</div>
					<div class="form-group">
						<label for="inputEmail3" class="col-sm-3 control-label">联系电话</label>
						<div class="col-sm-7">
							<input id="userId" name="userId" type="number" class="form-control"
								pattern="[0-9]+" title="请填写正确联系"
							 placeholder="非常重要"  required>
							 <span class="glyphicon glyphicon-earphone form-control-feedback"></span>
						</div>
					</div>
 				<legend>收货人信息</legend>
<!--  					<div class="form-group">
						<label for="inputEmail3" class="col-sm-3 control-label">邮箱</label>
						<div class="col-sm-7">
							<input name="email" type="text" placeholder="必填项"
								class="form-control" required
								pattern="^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$"
								title="邮箱正确格式：xxx@xxx.xxx">
						</div>
					</div>  -->

					<div class="form-group">
						<label for="inputEmail3" class="col-sm-3 control-label">收货人</label>
						<div class="col-sm-7">
							<input id="userId" name="userId" type="text" class="form-control"
								id="exampleInputEmail1" placeholder="收货人姓名" required>
						</div>
					</div>

					<div class="form-group">
						<label for="inputEmail3" class="col-sm-3 control-label">目的地</label>
						<div class="col-sm-7">
							<input id="userId" name="userId" type="text" class="form-control"
								id="exampleInputEmail1" placeholder="非常重要" required>
						</div>
					</div>		
					<div class="form-group">
						<label for="inputEmail3" class="col-sm-3 control-label">收货单位</label>
						<div class="col-sm-7">
							<input id="userId" name="userId" type="text" class="form-control"
								id="exampleInputEmail1" placeholder="收货单位" required>
						</div>
					</div>	
					<div class="form-group">
						<label for="inputEmail3" class="col-sm-3 control-label">收货地址</label>
						<div class="col-sm-7">
							<input id="userId" name="userId" type="text" class="form-control"
								id="exampleInputEmail1" placeholder="收货地址" required>
						</div>
					</div>		
						
					<div class="form-group">
						<label for="inputEmail3" class="col-sm-3 control-label">联系电话</label>
						<div class="col-sm-7">
							<input id="userId" name="userId" type="number" class="form-control"
								id="exampleInputEmail1" placeholder="非常重要" required>
							<span class="glyphicon glyphicon-earphone form-control-feedback"></span>
						</div>
					</div>
				</div>		
				<div class="order-step-2" style="display:none;">	
					<legend>货物信息</legend>
					<div class="form-group">
						<label for="inputEmail3" class="col-sm-3 control-label">物品名称</label>
						<div class="col-sm-7">
							<input id="userId" name="userId" type="text" class="form-control"
								id="exampleInputEmail1" placeholder="物品描述" required>
						</div>
					</div>

					<div class="form-group">
						<label for="inputEmail3" class="col-sm-3 control-label">物品件数</label>
						<div class="col-sm-7">
							<input id="userId" name="userId" type="number" class="form-control"
								id="exampleInputEmail1" placeholder="必填项"   required>
						</div>
					</div>

					<div class="form-group">
						<label for="inputEmail3" class="col-sm-3 control-label">重量</label>
						<div class="col-sm-7">
							<input id="userId" name="userId" type="number" class="form-control"
								id="exampleInputEmail1" placeholder="单位/kg" required>
						</div>
					</div>
					
					<div class="form-group">
						<label for="inputEmail3" class="col-sm-3 control-label">体积</label>
						<div class="col-sm-7">
							<input id="userId" name="userId" type="number" class="form-control"
								id="exampleInputEmail1" placeholder="单位/立方" required>
						</div>
					</div>
					
					<div class="form-group">
						<label for="inputEmail3" class="col-sm-3 control-label">运输方式</label>
						<div class="col-sm-7">
							<select class="form-control">
							  <option>航空</option>
							  <option>铁路</option>
							  <option>公路</option>
							</select>
						</div>
					</div>
					
					<div class="form-group">
						<label for="inputEmail3" class="col-sm-3 control-label">包装方式</label>
						<div class="col-sm-7">
							<input id="userId" name="userId" type="text" class="form-control"
								id="exampleInputEmail1" placeholder="请描述您货物的包装外貌" required>
						</div>
					</div>
					
					<div class="form-group">
						<label for="inputEmail3" class="col-sm-3 control-label">运费</label>
						<div class="col-sm-7">
							<input id="userId" name="userId" type="number" class="form-control"
								 placeholder="运输费用" required>
						</div>
					</div>					
					
					<div class="form-group">
						<label for="inputEmail3" class="col-sm-3 control-label">备注信息</label>
						<div class="col-sm-8">
							<textarea class="form-control" rows="4"
								placeholder="请在此备注您的其他需求，如希望取件的时间；是否需要发票或其他服务等"></textarea>
						</div>
					</div>
				</div>
																				
					<div class="control-group">
						<label class="control-label"> </label>
						<div class="controls">
							<div class="col-sm-3"></div>
							<div class="col-sm-3">
								<button type="button" class="btn btn-default btn-block order-next-prep" onClick="orderPrep()">上一步</button>
							</div>
							<div class="col-sm-3 order-next-step">
								<button type="button" class="btn btn-primary btn-block " onClick="orderNext()" >下一步</button>
							</div>

							<div class="col-sm-3 order-next-complete" style="display:none;" >
								<!-- <button type="reset" class="btn btn-primary btn-block "  >重置</button> -->
								<button type="submit" class="btn btn-primary btn-block " >完成订单</button>
							</div>
						</div>
					</div>
				</fieldset>
			</form>
		</div>
		</div>
		<div class="page-body-right col-sm-5" style="margin-top:70px">
			<img alt="" src="register_bg.png">
		</div>		
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

				</div>
				<div class="modal-footer"></div>
			</div>
		</div>
	</div>


<style type="text/css" >
	body{
		padding:0px;
	}
	
	.carousel-inner>.item>img{
		height:400px;
	}
	
	
	.bottom-menu{
		padding-top:25px!important;
	}

	.top-grid span {
		cursor:pointer;
		width: 143px;
		height: 143px;
		display: inline-block;
		background: url(public/images/idx/icons.png) no-repeat 0px 0px;
	}

	.top-grid span.icon1{
		background-position:0px 0px;
	}
	.top-grid span.icon2{
		background-position: -284px 0px;
	}
	.top-grid span.icon3{
		/* background-position: -569px 0px; */
	}
	.top-grid span.icon4{
		background-position: -855px 0px;
	}
	.top-grid span.icon1:hover,.top-grid:hover span.icon1{
		background-position:0px -148px;
	}
	.top-grid span.icon2:hover,.top-grid:hover span.icon2{
		background-position:-284px -148px;
	}
	.top-grid span.icon3:hover,.top-grid:hover span.icon3{
		background-position:-569px -148px;
	}
	.top-grid span.icon4:hover,.top-grid:hover span.icon4{
		background-position:-855px -148px;
	}
</style>

<script type="text/javascript">

function siginIn(){
	$("#sigin-div").modal('show');
}


function orderPrep(){
	$(".order-step-1").show();
	$(".order-next-step").show();
	
	$(".order-step-2").hide();
	$(".order-next-complete").hide();
}

function orderNext(){
	$(".order-step-1").hide();
	$(".order-next-step").hide();
	$(".order-step-2").show();
	$(".order-next-complete").show();
}

//订单进度监听,并动态改变进度值.
self.setInterval("orderProccessListener()",1500);

function orderProccessListener(){
	var formValues  = $("#order-form").serializeArray();
	var step = 0;
	var total = formValues.length;
	var text = "";
	$.each(formValues, function(i, field){
  		if(field.value!="") step+=1; 
	});
	if(step==0) return ;
	var proccess = Math.ceil((step/total)*100);
	
	if(proccess<12) text= proccess+"%";
	else text = "进度"+proccess+"%";
	$(".progress-bar").css('width',proccess+"%"); 
	$(".progress-bar").text(text);
	
	if(proccess == 100) $(".progress-bar").text("已完成，100%");
}

//html5 相关提示




</script>

</body>

</html>
