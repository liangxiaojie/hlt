<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">


<title>京东订单</title>
</head>
<body>

	<!-- 订 单 -->
	<div class="w">
		<div class="breadcrumb">
			<strong><a href="http://home.jd.com/">我的京东</a>
			</strong><span>&nbsp;&gt;&nbsp;<a
				href="http://jd2008.jd.com/JdHome/OrderList.aspx">订单中心</a>&nbsp;&gt;&nbsp;订单：1628754666<span></span>
			</span>
		</div>
		<!--变量-->
		<span id="pay-button-order" style="display:none"></span>
		<!--状态、提示-->
<style type="text/css">

.icon-box {
	position: relative;
}

.icon-box .warn-icon {
	background-position: -96px 0;
}

.icon-box .m-icon {
 	background: url("http://misc.360buyimg.com/myjd/skin/2014/i/icon48.png")
		no-repeat scroll 0 0 rgba(0, 0, 0, 0); 
	display: inline-block;
	height: 48px;
	left: 0;
	position: absolute;
	top: 0;
	width: 48px;
}

.icon-box .item-fore {
	margin-left: 58px;
}

.tip-box .item-fore {
	overflow: hidden;
}

.tip-box h3 {
	font-family: "microsoft yahei";
	font-size: 16px;
	line-height: 30px;
}

.tip-box .ftx04,.tip-box .ftx-04 {
	color: #FF8A15;
}

.tip-box .ftx03,.tip-box .ftx-03 {
	color: #999999;
}

.tip-box .op-btns {
	margin-top: 20px;
}

.tip-box .btn-9:link,.tip-box .btn-9:visited,.tip-box .btn-10:link,.tip-box .btn-10:visited,.tip-box .btn-11:link,.tip-box .btn-11:visited,.tip-box .btn-12:link,.tip-box .btn-12:visited
	{
	color: #323333;
	text-decoration: none;
}

.tip-box a {
	color: #005EA7;
}

.tip-box .btn-9,.tip-box .btn-10,.tip-box .btn-11,.tip-box .btn-12 {
	background-color: #F7F7F7;
	background-image: linear-gradient(to top, #F7F7F7 0px, #F3F2F2 100%);
	border: 1px solid #DDDDDD;
	border-radius: 2px;
	color: #323333;
	display: inline-block;
	height: 18px;
	line-height: 18px;
	padding: 2px 14px 3px;
}

.tip-box a {
	color: #005EA7;
}

.tip-box .ml10 {
	margin-left: 10px;
}
</style>
		<div class="m" id="orderstate">
			<div class="mt">
				<strong>订单号：1628754666&nbsp;&nbsp;&nbsp;&nbsp;状态：<span
					class="ftx14">完成</span><span id="pay-button-1628754666"></span> <span
					class="thirdpop"></span> </strong>
				<div class="fr">
					<div class="toolbar"></div>
				</div>
			</div>

			<div class="mc" style="display:show">

				订单已经完成，感谢您在京东商城购物，欢迎您对本次交易及所购商品进行评价。<span class="flk13"><a
					href="http://club.jd.com/JdVote/TradeComment.aspx?ruleid=1628754666&amp;ot=0&amp;payid=4&amp;shipmentid=70">发表评价</a>
				</span>

			</div>

			<div class="mc" id="zxzf" style="display:none">
				<div>
					<p style="text-align:left;">尊敬的客户，您的订单商品已经从库房发出，请您做好收货准备。</p>
					<p style="text-align:left;">
						<span class="ftx-01">由京东提供</span> <s class="icon-bao"></s> <a
							target="_blank"
							href="http://help.jd.com/help/question-56.html#help1995">在线交易保障</a>
						<span>如果您已收到货，请确认收货，京东将与卖家结算。如果您对购买的商品不满意，您可在确认收货后发起返修/退换货申请!</span>
					</p>
				</div>
			</div>
		</div>

		<div id="hbdd" class="Tip360" style="width: 600px;">
			<div class="Tip_Title">
				<em>一张图片<!-- <img
					src="%E6%88%91%E7%9A%84%E4%BA%AC%E4%B8%9C--%E6%88%91%E7%9A%84%E8%AE%A2%E5%8D%95_files/tip_close.jpg"
					class="Tip_Close" height="13" width="14"> -->
				</em> 合并订单
			</div>
			<div class="Tip_Content">
				<div id="combin_main"></div>
				<div class="align_Left" style="padding: 15px 0 5px;">
					请选择要合并到主订单的订单：</div>
				<div id="combin_item"></div>
				<div class="Tip_Submit"
					style="background: none; border: 0; padding: 20px 250px 20px 0;">
					<a id="combinBtn"
						href="javascript:alert('%E8%AF%B7%E9%80%89%E6%8B%A9%E8%A6%81%E5%90%88%E5%B9%B6%E7%9A%84%E8%AE%A2%E5%8D%95%EF%BC%81');"><span>合并订单</span>
					</a>
				</div>
				<div class="align_Left">
					<font color="#FF6600">提示</font>：订单合并后，收货人信息、支付方式、配送方式等都将以主订单为准。
				</div>
			</div>
		</div>

		<div id="ddyq" class="Tip360" style="width: 360px;">
			<div class="Tip_Title">
				<em> <!-- <img
					src="%E6%88%91%E7%9A%84%E4%BA%AC%E4%B8%9C--%E6%88%91%E7%9A%84%E8%AE%A2%E5%8D%95_files/tip_close.jpg"
					class="Tip_Close" id="defercloseBtn" height="13" width="14"> -->
					一张图片
				</em>订单延期
			</div>
			<div class="Tip_Content">
				<div class="align_Left" style="padding: 5px 0 5px;">
					订单自提时间将延长至： <span id="defer_item"></span>
				</div>
				<div class="align_Left" style="padding: 5px 0 5px;">
					注：超过自提日期，您的订单商品将退库</div>
			</div>
		</div>


		<!--进度条-->

		<div id="process" class="section4">
			<div class="node fore ready">
				<ul>
					<li class="tx1">&nbsp;</li>
					<li class="tx2">提交订单</li>
					<li id="track_time_0" class="tx3">2014-07-09 <br>
						13:09:20</li>
				</ul>
			</div>
			<div class="proce ready">
				<ul>
					<li class="tx1">&nbsp;</li>
				</ul>
			</div>
			<div class="node ready">
				<ul>
					<li class="tx1">&nbsp;</li>
					<li class="tx2">付款成功</li>
					<li id="track_time_4" class="tx3"></li>
				</ul>
			</div>
			<div class="proce ready">
				<ul>
					<li class="tx1">&nbsp;</li>
				</ul>
			</div>
			<div class="node ready">
				<ul>
					<li class="tx1">&nbsp;</li>
					<li class="tx2">商品出库</li>
					<li id="track_time_1" class="tx3">2014-07-09 <br>
						13:35:31</li>
				</ul>
			</div>
			<div class="proce ready">
				<ul>
					<li class="tx1">&nbsp;</li>
				</ul>
			</div>
			<div class="node ready">
				<ul>
					<li class="tx1">&nbsp;</li>
					<li class="tx2">等待收货</li>
					<li id="track_time_5" class="tx3">2014-07-09 <br>
						20:26:52</li>
				</ul>
			</div>
			<div class="proce ready">
				<ul>
					<li class="tx1">&nbsp;</li>
				</ul>
			</div>
			<div class="node ready">
				<ul>
					<li class="tx1">&nbsp;</li>
					<li class="tx2">完成</li>
					<li id="track_time_6" class="tx3">2014-07-10 <br>
						12:59:02</li>
				</ul>
			</div>
		</div>

		<!--跟踪、付款信息、gis-->
		<div class="m" id="ordertrack">
			<ul class="tab">
				<li class="curr" clstag="click|keycount|orderinfo|ordertrack">
					<h2>订单跟踪</h2></li>

				<li class="" clstag="click|keycount|orderinfo|btn_payinfo">
					<h2>付款信息</h2></li>
				<li class="" id="orderlocustab" style="display: block;"
					clstag="click|keycount|orderinfo|btn_gis">
					<h2>订单轨迹</h2></li>
			</ul>
			<div class="clr"></div>
			<div style="display: block;" class="mc tabcon">
				<!--订单跟踪-->
				<input value="2014-07-09 13:09:20" id="datesubmit-1628754666"
					type="hidden">
				<table width="100%" cellpadding="0" cellspacing="0">
					<tbody id="tbody_track">
						<tr>
							<th width="15%"><strong>处理时间</strong>
							</th>
							<th width="50%"><strong>处理信息</strong>
							</th>
							<th width="35%"><strong>操作人</strong>
							</th>
						</tr>

					</tbody>
					<tbody>
						<tr>
							<td>2014-07-09 13:09:20</td>
							<td>您提交了订单，请等待系统确认</td>
							<td>客户</td>
						</tr>
						<tr>
							<td>2014-07-09 13:11:21</td>
							<td>您的订单已经进入北京6号库准备出库，不能修改</td>
							<td>系统</td>
						</tr>
						<tr>
							<td>2014-07-09 13:11:22</td>
							<td>您的订单预计7月10日送达您手中</td>
							<td>系统</td>
						</tr>
						<tr>
							<td>2014-07-09 13:12:31</td>
							<td>您的订单已经打印完毕</td>
							<td>李小艳</td>
						</tr>
						<tr>
							<td>2014-07-09 13:17:32</td>
							<td>您的订单已经拣货完成</td>
							<td>苏连章</td>
						</tr>
						<tr>
							<td>2014-07-09 13:35:28</td>
							<td>扫描员已经扫描</td>
							<td>袁文华</td>
						</tr>
						<tr>
							<td>2014-07-09 13:35:31</td>
							<td>打包成功</td>
							<td>京东打包员</td>
						</tr>
						<tr>
							<td>2014-07-09 13:44:03</td>
							<td>您的订单在【北京仓头分拣中心】分拣完成</td>
							<td>魏东明</td>
						</tr>
						<tr>
							<td>2014-07-09 16:28:15</td>
							<td>您的订单在【北京仓头分拣中心】发货完成，准备送往【北京金盏分拨中心】</td>
							<td>魏东明</td>
						</tr>
						<tr>
							<td>2014-07-09 19:26:21</td>
							<td>您的订单在【北京金盏分拨中心】分拣完成</td>
							<td>曹素真</td>
						</tr>
						<tr>
							<td>2014-07-09 20:26:52</td>
							<td>您的订单在【北京金盏分拨中心】发货完成，准备送往【牛栏山站】</td>
							<td>杨娜</td>
						</tr>
						<tr>
							<td>2014-07-10 07:10:54</td>
							<td>您的订单在【牛栏山站】验货完成，正在分配配送员</td>
							<td>龚顺朝</td>
						</tr>
						<tr>
							<td>2014-07-10 07:56:38</td>
							<td>配送员【郝海龙】已出发，联系电话【18511872043站点电话69417623】</td>
							<td>郝海龙</td>
						</tr>
						<tr>
							<td>2014-07-10 12:59:02</td>
							<td>感谢您在京东购物，欢迎您再次光临！</td>
							<td>郝海龙</td>
						</tr>
					</tbody>
				</table>

				<div class="extra">
					<span id="jdshfs"> 送货方式：普通快递 </span><span>承运人：京东快递</span><span>货运单号：1628754666</span>
				</div>
			</div>


			<div style="display: none;" class="mc tabcon hide">
				<!--付款信息-->
				<table width="100%" cellpadding="0" cellspacing="0">
					<tbody>
						<tr>
							<td id="daiFuName" width="30%">付款方式：在线支付</td>
							<td id="daiFuPeople" width="70%"></td>
						</tr>
						<tr>
							<td>商品金额：￥3799.00</td>
							<td>运费金额：￥0.00</td>
						</tr>
						<tr>
							<td>优惠金额：￥0.00</td>
							<td>实际运费：￥0.00</td>
						</tr>
						<tr>
							<td>应支付金额：￥3799.00</td>
							<td>交易余额：￥0.00</td>
						</tr>
						<tr>
							<td></td>
						</tr>
					</tbody>
				</table>
				<div class="tb-ul">
					<ul class="fore">
						<li class="fore1">支付时间</li>
						<li class="fore2">支付单号</li>
						<li class="fore3">支付来源</li>
						<li class="fore4">金额</li>
					</ul>
					<ul class="fore0">
						<li class="fore1">2014-07-09 13:11:14</li>
						<li class="fore2">140709131464498261700</li>
						<li class="fore3">网银在线</li>
						<li class="fore4"><strong class="ftx-01">￥3799</strong>
						</li>
					</ul>
				</div>
			</div>
			<div style="display: none;" class="mc tabcon hide">
<!-- 				<iframe id="gisFrame"
					src="%E6%88%91%E7%9A%84%E4%BA%AC%E4%B8%9C--%E6%88%91%E7%9A%84%E8%AE%A2%E5%8D%95_files/order.htm"
					scrolling="no" frameborder="0" height="710px" width="100%"></iframe>
				<div id="gis">
					<strong>备注：</strong>受天气、gps信号、运营商等各类因素影响，您看到的包裹位置和实际位置有时可能会有一些差别。请您谅解！
				</div> -->
			</div>
			<div class="i-ordertrack">
				<s></s><a href="http://app.jd.com/" target="_blank"
					clstag="click|keycount|orderinfo|i-ordertrack">手机查订单，更方便</a>
			</div>
			<div id="im"></div>
		</div>
		<!--留言-->
		<!--订单信息-->
		<div class="m" id="orderinfo">
			<div class="mt">
				<strong>订单信息</strong>
			</div>
			<div class="mc">
				<!-- 节能补贴信息 -->

				<!--顾客信息-->
				<dl class="fore">
					<dt>收货人信息</dt>
					<dd>
						<ul>
							<li>收&nbsp;货&nbsp;人：何航</li>
							<li>地&nbsp;&nbsp;&nbsp;&nbsp;址：北京顺义区马坡地区大营站 民生银行北门 门口</li>
							<li>手机号码：13120305031</li>
							<li>电子邮件：502101719@qq.com</li>
						</ul>
					</dd>
				</dl>
				<!-- 礼品购订单展示送礼人信息 -->

				<!--配送、支付方式-->
				<dl>
					<dt>支付及配送方式</dt>
					<dd>
						<ul>

							<li>支付方式：在线支付</li>


							<li>运&nbsp;&nbsp;&nbsp;&nbsp;费：￥0.00</li>

							<li>送货日期：2014-07-10</li>









						</ul>
					</dd>
				</dl>
				<!--发票-->
				<dl>
					<dt>发票信息</dt>
					<dd>

						<ul>
							<li>发票类型：普通发票</li>
							<li>发票抬头：个人</li>
							<li>发票内容：明细</li>


						</ul>
					</dd>
				</dl>
				<!-- 礼品购订单展示寄语信息 -->

				<!--备注-->

				<!--商品-->
				<dl>
					<dt>
						<span class="i-mt">商品清单</span>

						<div id="fquan" class="fquan">
							<div id="eventName" onmouseover="showCoupon()"
								onmouseout="hideCoupon()"></div>

							<div class="prompt p-fquan" id="couponListShow">
								<div class="pc" id="couponList"></div>
							</div>
						</div>

						<div class="clr"></div>

					</dt>

					<dd class="p-list">
						<table width="100%" cellpadding="0" cellspacing="0">
							<tbody>
								<tr>
									<th width="10%">商品编号</th>
									<th width="12%">商品图片</th>
									<th width="42%">商品名称</th>
									<th width="10%">京东价</th>
									<th width="8%">京豆数量</th>
									<th width="7%">商品数量</th>
									<th width="11%">操作</th>
								</tr>
								<tr>
									<td>1158083</td>

									<td>
										<div class="img-list">
											<a class="img-box" target="_blank"
												href="http://item.jd.com/1158083.html"> <!-- <img
												src="%E6%88%91%E7%9A%84%E4%BA%AC%E4%B8%9C--%E6%88%91%E7%9A%84%E8%AE%A2%E5%8D%95_files/rBEhWFJ4sNUIAAAAAAHJY7c4pHkAAFBugBwkz0AAcl7615.jpg"
												title="ThinkPad E431(62771U8) 14英寸笔记本电脑 (i5-3210M 4G 500G 7200转 2G独显 蓝牙 LINUX)"
												height="50" width="50"> -->一张图片 </a>
										</div></td>

									<td>
										<div class="al fl">

											<a class="flk13" target="_blank"
												href="http://item.jd.com/1158083.html"
												clstag="click|keycount|orderinfo|product_name"> ThinkPad
												E431(62771U8) 14英寸笔记本电脑 (i5-3210M 4G 500G 7200转 2G独显 蓝牙
												LINUX)</a>

										</div>
										<div class="clr"></div>
										<div id="coupon_1158083" class="fl"></div></td>

									<td><span class="ftx04"> ￥3799.00</span>
									</td>

									<td>0</td>

									<td>1</td>
									<td><span id="iwo1158083" class="flk13"><a
											target="_blank"
											href="http://club.jd.com/repay/1158083_42a2aa3a-2cd5-4f9b-9968-722329a085e1_1.html"
											clstag="click|keycount|orderinfo|product_comment">查看评价</a>|<a
											clstag="click|keycount|orderinfo|product_show"
											href="http://club.jd.com/orderbbs/1158083-1.html?orderId=1628754666"
											target="_blank">晒单</a> <br> <a
											href="http://myjd.jd.com/repair/ordersearchlist.action?searchString=1628754666"
											target="_blank"
											clstag="click|keycount|orderinfo|product_repair">申请返修/退换货</a>
									</span> <a class="btn-again" clstag="click|keycount|orderlist|buy"
										href="http://gate.jd.com/InitCart.aspx?pid=1158083&amp;pcount=1&amp;ptype=1"
										target="_blank">还要买</a></td>
								</tr>
							</tbody>
						</table>
					</dd>
				</dl>

				<!--条形码-->
				<div id="barcode">
					<span class="ftx13 fl">查看条形码</span>
					<ul id="sn_list" class="hide"></ul>
				</div>
				<!-- 商家运费险  -->
				<input id="venderIdListStr" value="" type="hidden">

				<div id="yunFeiXian"></div>
			</div>
			<!--金额-->
			<div class="total">
				<ul>
					<li><span>总商品金额：</span>￥3799.00</li>
					<li><span>- 返现：</span>￥0.00</li>
					<li><span>+ 运费：</span>￥0.00</li>


				</ul>
				<span class="clr">ad</span> <span style="color:#EDEDED;"></span>
				<div class="extra">
					应付总额：<span class="ftx04"><b>￥3799.00</b>
					</span>
				</div>
			</div>
		</div>
	</div>

</body>

	<link href="css/base.css" type="text/css" rel="stylesheet"/>
	<link href="css/002.css" type="text/css" rel="stylesheet"/>
</html>