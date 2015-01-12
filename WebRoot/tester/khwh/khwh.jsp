<%@ include file="/public/base/ace_base.jsp"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE html >
<html>
<head>

<title>客户维护</title>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/public/base/assets/table/bootstrap-table.min.css" />
<script src="<%=request.getContextPath()%>/public/base/assets/table/bootstrap-table.min.js"></script>
<script src="<%=request.getContextPath()%>/public/base/assets/table/locale/bootstrap-table-zh-CN.min.js"></script>
<style type="text/css">

	body{ background: white; }
	#modal-dialog{ width:700px; }
	#customerDef_table-toolbar { margin-top: -20px; }
	select{	width:165px; }
</style>
</head>
<body >

<div id="customer-table">
		<div id="custom-toolbar">
		    <div class="form-inline" role="form">
		        <div class="form-group">
		            <div class="input-group" style="width:200px">
		            	<button class="btn btn-primary" data-toggle="modal" data-target="#customerDef" data-zh="编辑客户" onClick="loadCusDefs()" data-es="Ver modal">编辑客户</button>
		            </div>
		        </div>
		    </div>
		</div>
		
		<table id="customer" data-method="get"  data-toggle="table" data-url="/hlt/service/base.user.UserService/queryUser" 
			data-height="540" data-click-to-select="true" data-side-pagination="server" data-pagination="true"  data-query-params ="beforeLoad"
			data-page-list="[5, 10, 20, 50]" data-toolbar="#custom-toolbar" >
		    <thead>
		    	<tr>
		        	<th data-field="state" data-checkbox="true"></th>
		        	<th data-field="userId" data-align="left" data-sortable="true">用户Id</th>
		        	<th data-field="userName" data-align="center" data-sortable="true">用户名</th>
		        	<th data-field="userPwd" data-sortable="true">密&nbsp;码</th>
		   		</tr>
		    </thead>
		</table>
</div>	

<div class="modal fade" id="customerDef" tabindex="-1" role="dialog"  aria-labelledby="myModalLabel" aria-hidden="true" >
   <div class="modal-dialog" id="modal-dialog" >
      <div class="modal-content" >
         <div class="modal-header">
            <button type="button" class="close"  data-dismiss="modal" aria-hidden="true">&times;</button>
            <h4 class="modal-title" id="myModalLabel">客户定义</h4>
         </div>
         <div class="modal-body">
     	                  
			<div id="customerDef_table-toolbar">
			    <div class="form-inline" role="form">
			        <div class="form-group">
			            <div class="input-group" >
			            	<button class="btn btn-primary" data-toggle="modal" data-target="#addPsDef"   data-zh="新增"  data-es="Ver modal">新增</button>
			            	<button class="btn btn-info" data-toggle="modal"    onClick="deletePsDef()"  data-zh="删除"  data-es="Ver modal">删除</button>
			            </div>
			        </div>
			    </div>
			</div> 
			<table id="customerDef_table" data-toggle="table" data-method="get" data-url="/hlt/service/base.psdef.service.PsDefService/queryPsDef"
			 data-click-to-select="true" data-side-pagination="server" data-pagination="true" data-cache="false" 
		     data-height="329"  data-query-params = "beforeLoad" data-page-list="[5, 10, 20, 50]"  data-toolbar="#customerDef_table-toolbar" >
			    <thead>
			        <tr>
			        	<th data-field="def" data-checkbox="true"></th>
			            <!-- <th data-field="userId">用户Id</th> -->
			            <th data-field="psMdd">目的地</th>
			            <th data-field="psfs">配送方式</th>
			            <th data-field="psJsfs">配送计算方式</th>
			            <th data-field="psDj">配送单价</th>
			        </tr>
			    </thead>
			</table>     
         </div>
<!--    
		 <div class="modal-footer">
            <button type="button" class="btn btn-default"  data-dismiss="modal">关闭 </button>
            <button type="button" class="btn btn-primary"> 提交更改 </button>
         </div> 
-->
      </div>
	</div>
</div>


<!-- 客户目的地定义操作  -->

<div class="modal fade" id="addPsDef" tabindex="-1" role="dialog" data-backdrop="false"  aria-labelledby="myModalLabel" aria-hidden="true" >
   <div class="modal-dialog psDef-operation"  style="width:400px;" >
      <div class="modal-content" >
         <div class="modal-header">
            <button type="button" class="close"  data-dismiss="modal" aria-hidden="true">&times;</button>
            <h4 class="modal-title" id="myModalLabel">新增</h4>
         </div>
         <div class="modal-body">
					<form class="form-horizontal" id="operCusDef-form" method="get" novalidate="novalidate">
						<div class="form-group hidden">
							<label class="control-label col-xs-12 col-sm-3 no-padding-right"
								for="email">用户Id:</label>
							<div class="col-xs-12 col-sm-9">
								<div class="clearfix">
									<input  readonly  name="userId" id="userId" class="col-xs-12 col-sm-8" />
								</div>
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-xs-12 col-sm-3 no-padding-right"
								for="text">目的地:</label>

							<div class="col-xs-12 col-sm-9">
								<div class="clearfix">
									<input type="text" name="psMdd" class="col-xs-12 col-sm-8" /> 
								</div>
							</div>
						</div>
		
						<div class="form-group">
							<label class="control-label col-xs-12 col-sm-3 no-padding-right"
								for="text">配送方式:</label>
							<div class="col-xs-12 col-sm-9">
								<div class="clearfix">
								<select  name="psfs"  data-placeholder="选择配送方式">
									<option value="0">航空</option>
									<option value="1">铁路</option>
									<option value="2">公路</option>
								</select>	
								</div>
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-xs-12 col-sm-3 no-padding-right"
								for="text">计算方式:</label>
							<div class="col-xs-12 col-sm-9">
								<div class="clearfix">
									<input type="text" name="psJsfs"  class="col-xs-12 col-sm-8" />
								</div>
							</div>
						</div>
						
						<div class="form-group">
							<label class="control-label col-xs-12 col-sm-3 no-padding-right"
								for="text">配送单价:</label>

							<div class="col-xs-12 col-sm-9">
								<div class="clearfix">
									<input type="number" name="psDj" id="text" class="col-xs-12 col-sm-8" />
								</div>
							</div>
						</div>
					</form>
         </div>
		 <div class="modal-footer">
            <button type="button" class="btn btn-default  btn-xs"  data-dismiss="modal">取消 </button>
            <button type="button" class="btn btn-primary  btn-xs" onClick="addPsDef()"> 确认 </button>
         </div> 
      </div>
	</div>
</div>



<div class="modal" id="confirm" tabindex="-1" role="dialog" data-backdrop="false"  aria-labelledby="confirmLabel" aria-hidden="true" >
   <div class="modal-dialog confirm-public"  style="width:400px;" >
      <div class="modal-content" >
         <div class="modal-header">
            <button type="button" class="close"  data-dismiss="modal" aria-hidden="true">&times;</button>
            <h4 class="modal-title" id="myModalLabel">警告</h4>
         </div>
         <div class="modal-body">
				确认删除这几行吗?
         </div>
		 <div class="modal-footer">
            <button type="button" class="btn btn-default  btn-xs confirm-no"  data-dismiss="modal" >取消 </button>
            <button type="button" class="btn btn-primary  btn-xs confirm-yes" > 确认 </button>
         </div> 
      </div>
	</div>
</div>




</body>
<script src="<%=request.getContextPath()%>/public/base/assets/js/fuelux/fuelux.wizard.min.js"></script>
<script src="<%=request.getContextPath()%>/public/base/assets/js/jQvalidate/jquery.validate.min.js"></script>
<script src="<%=request.getContextPath()%>/public/base/assets/js/jQvalidate/validate-self-def.js"></script>
<script src="<%=request.getContextPath()%>/public/base/assets/js/additional-methods.min.js"></script>
<script src="<%=request.getContextPath()%>/public/base/assets/js/bootbox.min.js"></script>
<script src="<%=request.getContextPath()%>/public/base/assets/js/jquery.maskedinput.min.js"></script>
<script src="<%=request.getContextPath()%>/public/base/assets/js/select2.min.js"></script>
<script type="text/javascript">

/* - 用户操作  start  */  
var loadCustomers = '/hlt/service/base.user.UserService/queryUser';


/* - 用户操作  end    */



/* - 客户目的地定义 start    */
var currentDef;  
 
var loadCusDefUrl   = '/hlt/service/base.psdef.service.PsDefService/queryPsDef';
var addCusDefUrl    = '/hlt/service/base.psdef.service.PsDefService/addPsDef';
var deleteCusDefUrl = '/hlt/service/base.psdef.service.PsDefService/deletePsDef';

function loadCusDefs(){

	var rcds = $('#customer').bootstrapTable('getSelections');
	var para = [];  para = rcds;
	if(!rcds ||rcds.length>1){
		alert("请选择一条记录");
	}
	currentDef = rcds[0];
	para[para.length] = 0;
	para[para.length] = 10;
	$.ajax({
	   type: "POST",
	   url: loadCusDefUrl,
	   data: {para:JSON.stringify(para)},
	   success: function(msg){
		   	var data = JSON.parse(msg,function(key,value){ return value; });
	   		$('#customerDef').bootstrapTable('load', data.data.rows);
	   }
	});
}


function addPsDef(){
	var para = [];
	if(!$('#operCusDef-form').valid()) return false;
	var values = getFormValues("#operCusDef-form");
	console.log(currentDef);
	values.userId = currentDef.userId;
	para[para.length] = values;
 	$.ajax({
	   type: "POST",
	   url: addCusDefUrl,
	   data: {para:JSON.stringify(para)},
	   success: function(msg){
   		 var res = JSON.parse(msg);
		 alert(res.data);
	   }
	}); 
}

function deletePsDef(){

	$("#confirm").modal("show");

}


/* - 客户目的地定义 end     */

//数据加载前
function beforeLoad(p){ 

	var rcds = $('#customer').bootstrapTable('getSelections');
	return {para:'[{"test":"11"},'+(p.offset/p.limit)+','+p.limit+']'};
	
}

//bootstrap table 配置属性
$.fn.bootstrapTable.defaults.responseHandler = function(res){ return res.data; }  //数据返回时,回调函数.


function eidtCusDef(){

	//$('#customer').bootstrapTable('load', { });
	//var rcds = $('#customer').bootstrapTable('getSelections');
	//console.log('loaded ...');

}


function confirmCall(pub){

}



//根据jquery serializeArray函数 格式化 并转换为js对象返回.
function getFormValues(formKey){
	var formValues = {};
	$.each($(formKey).serializeArray(), function(i, field){
  		formValues[field.name] = field.value;
	});
	return formValues;
}

//jquery验证.
jQuery(function($) {

//documentation : http://docs.jquery.com/Plugins/Validation/validate
	$.mask.definitions['~']='[+-]';
	$('#phone').mask('(999) 999-9999');

	$('#operCusDef-form').validate({
		errorElement: 'div',
		errorClass: 'help-block',
		focusInvalid: false,
		rules: {
			psMdd:     {required: true},
			psfs: 	   {required: true},
			psJsfs:    {required: true},
			psDj:      {required: true}	
		},
		invalidHandler: function (event, validator) { //display error alert on form submit   
			$('.alert-danger', $('.login-form')).show();
		},
		highlight: function (e) {
			$(e).closest('.form-group').removeClass('has-info').addClass('has-error');
		},
		success: function (e) {
			$(e).closest('.form-group').removeClass('has-error').addClass('has-info');
			$(e).remove();
		},
		errorPlacement: function (error, element) {
			if(element.is(':checkbox') || element.is(':radio')) {
				var controls = element.closest('div[class*="col-"]');
				if(controls.find(':checkbox,:radio').length > 1) controls.append(error);
				else error.insertAfter(element.nextAll('.lbl:eq(0)').eq(0));
			}
			else if(element.is('.select2')) {
				error.insertAfter(element.siblings('[class*="select2-container"]:eq(0)'));
			}
			else if(element.is('.chosen-select')) {
				error.insertAfter(element.siblings('[class*="chosen-container"]:eq(0)'));
			}
			else error.insertAfter(element.parent());
		},
		submitHandler: function (form) {
			//alert('handler');
		},
		invalidHandler: function (form) {
			//alert('invalid');
		}
	});
	

})

</script>

</html>