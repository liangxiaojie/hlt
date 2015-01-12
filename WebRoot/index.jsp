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
	margin-top:12%;
	width: 450px;
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
            <li class="dropdown">
               <a href="#" target-page="/tester/qt/xdd.jsp" onclick="forwardPage(this)" >发起订单</a>
            </li>              
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

	<div id="myCarousel" class="carousel slide ">
		<!-- 轮播（Carousel）指标 -->
		<ol class="carousel-indicators">
			<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
			<li data-target="#myCarousel" data-slide-to="1"></li>
			<li data-target="#myCarousel" data-slide-to="2"></li>
		</ol>
		<!-- 轮播（Carousel）项目 -->
		<div class="carousel-inner">
			<div class="item active">
				<img src="public/images/idx/slide3.jpg" width="200%" height="420px;" alt="First slide">
				<div class="carousel-caption">标题 1</div>
			</div>
			<div class="item">
				<img src="public/images/idx/slide2.jpg" width="100%" height="420px;"  alt="Second slide">
				<div class="carousel-caption">标题 2</div>
			</div>
			<div class="item">
				<img src="public/images/idx/slide1.jpg" width="100%" height="420px;" alt="Third slide">
				<div class="carousel-caption">标题 3</div>
			</div>
		</div>
		<!-- 轮播（Carousel）导航 -->
<!--  		<a class="carousel-control left" href="#myCarousel" data-slide="prev">&lsaquo;</a>
		<a class="carousel-control right" href="#myCarousel" data-slide="next">&rsaquo;</a>  -->

	</div>


	<div class="container bottom-menu">
		<div class="row  section s1 top-grids">
			<div class="col-md-3 top-grid">
				<a href="#" target-page="/tester/qt/xdd.jsp" onclick="forwardPage(this)" >
				<span class="icon1"> </span>
				</a>
					<h2>发起订单</h2>
				<p>当前仅提供上海、浙江地区发件服务，上海、浙江以外城市可通过以下方式发件：电话下单：95543 【下午17：00以后下单，第二日取件】
				 </p>
			</div>
			<div class="col-md-3 top-grid">
				<a  href="#" target-page="/tester/dzd/dzd.jsp" onclick="forwardPage(this)">
				<span class="icon2"> </span>
				</a>
				<h2>每月对账</h2>
				<p>  夏日里花叶田田的荷塘，此时都只剩下了根根枯管，片片残叶。早已没了衔露含珠的
				风韵。寒风轻摇，枯和倓叶，仿佛悄悄的诉说着昔日美艳，又仿佛轻轻暗泣着如今没落。</p>
			</div>
			<div class="col-md-3 top-grid">
				<a href="#" target-page="/tester/dd/dd.jsp" onclick="forwardPage(this)" >
					<span class="icon3"> </span>
				</a>
				<h2>订单跟踪</h2>
				<p> 南方的山向来不如北方的高大巍峨，到了冬日更失了往日的润朗，之留下了略带灰蒙的身影悄然耸立于天地间。默守着一份寂静。</p>
			</div>
			<div class="col-md-3 top-grid">
				<span class="icon4"> </span>
				<h2>关于我们..</h2>
				<p>了解我们，给您最满意的保障和体验..</p>
			</div>
			<div class="clearfix"></div>
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
				
<!-- 					<iframe width="400px" align="center" height="270px" id="win" name="win" 
						 frameborder="0" scrolling="no" src="/hlt/login.jsp">
					</iframe>  -->	
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

window.onload = function(){
	$('.carousel').carousel();  //图片轮播
}	
	

</script>

</body>

</html>
