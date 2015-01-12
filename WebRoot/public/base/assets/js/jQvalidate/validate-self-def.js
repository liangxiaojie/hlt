
jQuery.extend(jQuery.validator.messages, {
  required: "必填字段",
  remote: "请修正该字段",
  email: "请输入正确格式的电子邮件",
  url: "请输入合法的网址",
  date: "请输入合法的日期",
  dateISO: "请输入合法的日期 (ISO).",
  number: "请输入合法的数字",
  digits: "只能输入整数",
  creditcard: "请输入合法的信用卡号",
  equalTo: "请再次输入",
  accept: "请输入合法的后缀名",
  maxlength: jQuery.validator.format("长度不大于 {0}的字符"),
  minlength: jQuery.validator.format("长度不少于 {0}个字符"),
  rangelength: jQuery.validator.format("输入长度介于 {0} 和 {1} 之间"),
  range: jQuery.validator.format("请输入一个介于 {0} 和 {1} 之间的值"),
  max: jQuery.validator.format("请输入一个最大为{0} 的值"),
  min: jQuery.validator.format("请输入一个最小为{0} 的值")
});


jQuery.validator.addMethod("phone", function (value, element) {
	return this.optional(element) || /^\(\d{3}\) \d{3}\-\d{4}( x\d{1,6})?$/.test(value);
}, "请键入有效的数值!");
