<%@ include file="/public/base/inc3.jsp"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE html >
<html>
<head>

<title>发起订单</title>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<style type="text/css">
.input-group-addon {
	width: 100px;
	min-width: 100px;
}

.container {
	padding-top: 20px;
}

.input-group {
	width: 100%;
}

.input-group-addon { /* background-color: #46A4D9; */
	font-style: #46A4D9
}
</style>

</head>
<body>



	<div class="form-content container-fluid ">

		<div class="orders-list">
			<div class="panel panel-default">
				<div class="panel-heading">
					<div class="summary">
						<span class="number last-item">
							当前仅提供上海、浙江地区发件服务，上海、浙江以外城市可通过以下方式发件：电话下单：95543
							【下午17：00以后下单，第二日取件】 </span>
					</div>
				</div>
				<div class="panel-body">
					<div class="row form-body">
						<!-- <div class="col-md-2"></div> -->
						<div class="col-md-6 form-left">
							<form class="form" role="form">
								<div class="form-group">
									<div class="input-group">
										<div class="input-group-addon">发货人</div>
										<input class="form-control" type="email" placeholder="输入您的姓名">
									</div>
								</div>
								<div class="form-group">
									<div class="input-group">
										<div class="input-group-addon">始发地</div>
										<input class="form-control" type="email" placeholder="输入您的发货地址">
									</div>
								</div>

								<div class="form-group">
									<div class="input-group">
										<div class="input-group-addon">手机号码</div>
										<input class="form-control" type="email" placeholder="输入您的手机号">
									</div>
								</div>

								<div class="form-group">
									<div class="input-group">
										<div class="input-group-addon">物品名称</div>
										<input class="form-control" type="email"
											placeholder="输入您的物品名称">
									</div>
								</div>

								<div class="form-group">
									<div class="input-group">
										<div class="input-group-addon">物品重量</div>
										<input class="form-control" type="number" placeholder="单位/kg">
									</div>
								</div>

								<div class="form-group">
									<div class="input-group">
										<div class="input-group-addon">物品体积</div>
										<input class="form-control" type="number" placeholder="单位/立方">
									</div>
								</div>

								<div class="form-group">
									<div class="input-group">
										<div class="input-group-addon">货运方式</div>
										<select class="form-control">
											<option>公路</option>
											<option>航空</option>
											<option>铁路</option>
										</select>
									</div>
								</div>

								<div class="form-group">
									<div class="input-group">
										<div class="input-group-addon">其他需求</div>
										<textarea class="form-control" rows="3"
											placeholder="请在此备注您的其他需求，如希望取件的时间；是否需要发票或其他服务等"></textarea>
									</div>
								</div>
							</form>
						</div>


						<!-- 收货人 -->
								
						<div class="col-md-6 form-right">
							<form class="form" role="form">
								<div class="form-group">
									<div class="input-group">
										<div class="input-group-addon">收货人</div>
										<input class="form-control" type="email" placeholder="输入您的姓名">
									</div>
								</div>

								<div class="form-group">
									<div class="input-group">
										<div class="input-group-addon">目的地</div>
										<input class="form-control" type="number" placeholder="输入您的手机号">
									</div>
								</div>

								<div class="form-group">
									<div class="input-group">
										<div class="input-group-addon">收货地址</div>
										<input class="form-control" type="email"
											placeholder="输入您的物品名称">
									</div>
								</div>

								<div class="form-group">
									<div class="input-group">
										<div class="input-group-addon">联系电话</div>
										<input class="form-control" type="number" placeholder="输入您的手机号（非常重要）">
									</div>
								</div>

							</form>

						</div>

					</div>

					<div class="row form-footer">
						<div class="col-md-4"></div>
						<div class="col-md-4">
							<button type="button" class="btn btn-primary btn-block btn-lg">&nbsp;完&nbsp;&nbsp;成&nbsp;</button>
						</div>
						<div class="col-md-4"></div>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>