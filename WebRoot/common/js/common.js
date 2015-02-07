var _record = 0;
var myTitle = document.title;
//标题变化
function titleBlink(){
	_record++;
	if(_record==3){//当变量_record累加到3是，将其赋值为1。相当于无限循环。
		_record=1;
	}
	if(_record==1){
		document.title='【您好，欢迎来到有人贷！ 】'+myTitle;
	}
	if(_record==2){
		//document.title='【新消息】'+myTitle;
		document.title=myTitle;
	}
	setTimeout("titleBlink()",1000);//调节时间，单位毫秒。
}
var isHasApp = false;//是否有应用名
function getContextPath() {
	   if(!isHasApp){
	   	  return "";
	   }
	   var contextPath = document.location.pathname;
	   var index =contextPath.substr(1).indexOf("/");
	   contextPath = contextPath.substr(0,index+1);
	   delete index;
	   return contextPath;
}
var contextPath=getContextPath();//得到上下文路径,保证通用
//序列化表单
function serialize(obj){
	if(!(obj instanceof jQuery))obj = $(obj);
	var formdata = "";
	obj.find("input[type=text],input[type=hidden],input[type=password],select,textarea").each(function(){
		if(this.name&&this.value){
			formdata=formdata  + this.name + "="+encodeURIComponent(this.value) + "&";
		}
	});
	obj.find("input[type=radio]").each(function(){
		if(this.checked&&this.name&&this.value){
			formdata=formdata + this.name+"="+encodeURIComponent(this.value) + "&";
		}
	});
	formdata = formdata.substring(0,formdata.length-1);
	return formdata;
}

//xh 序列化表单成JSON对象,注意,现在应该不支持同名的name
function serializeToJson(obj){
	if(!(obj instanceof jQuery))obj = $(obj);
	var formdata = {};
	obj.find("input[type=text],input[type=hidden],input[type=password],select,textarea").each(function(){
		if(this.name&&this.value){
			formdata[$(this).attr('name')]=$(this).attr('value');
		}
	});
	obj.find("input[type=radio]").each(function(){
		if(this.checked&&this.name&&this.value){
			formdata[$(this).attr('name')]=$(this).attr('value');
		}
	});
	return formdata;
}

//清空
function cleanObj(obj) {
	if(!(obj instanceof jQuery))obj = $(obj);
	if(obj){
		obj.find("input[type=text],input[type=hidden],select,textarea").each(function(){
			if($(this).val()){$(this).val("");}
			($(this)[0].tagName != 'SELECT') && $(this).text() && $(this).text("");
			if($(this).attr('title')){$(this).attr('title',"");}
		});
		obj.find("input[type=radio],input[type=checkbox]").each(function(){
			$(this).attr('checked',false);
		});
	}
}
//yhs 监听回车查询事件
$(document).on("keyup",function(e) {
	if(e.keyCode == 13) {
		$("input:button[value='查询']").click();
	}
});
function showErrorMsg(errorMsg){
	$.messager.alert('错误信息','<font style="font: bold; color: red;">'+errorMsg+'</font>');
}
function showMsg(msg){
	$.messager.show({
		title:'操作提示',
		msg:msg,
		timeout:5000,
		showType:'slide',
		style:{
			right:'',
			top:document.body.scrollTop+document.documentElement.scrollTop,
			bottom:''
			}
		});
}
function commonConfirm(fn) {
	confirmWithMsg('',fn)
}
function confirmWithMsg(msg,fn) {
	$.messager.confirm("确认",('<font style="font: bold; color: red;">'+(msg?msg:'您确认想要删除吗？')+'</font>'),fn);
}


//获取静态页面url参数
function getParam(name){

	var url = location.href;  
	var paraString = url.substring(url.indexOf("?")+1,url.length).split("&");  
	var paraObj = {}  
	for (i=0; j=paraString[i]; i++){  
		paraObj[j.substring(0,j.indexOf("=")).toLowerCase()] = j.substring(j.indexOf("=")+1,j.length);  
	}  
	var returnValue = paraObj[name.toLowerCase()];  
	if(typeof(returnValue)=="undefined"){  
		return "";  
	}else{  
		return returnValue; 
	}
}

function verfyLogin(){
	var username = $.cookie('username');
	var userId = $.cookie('userid');
	if(userId==''||userId==null){
//		var hostName = location.hostname;
//		var parten = "http://"+hostName;
//		var url = window.location.href.replace(parten,""); 
//		if(url.indexOf(":")>=0){
//			url=url.substring(5);
//		}
	  		//alert("请先登录!");
	  		window.open("/userlogin.shtml?fromUrl=true");
			return false;
	}	
		return true;
	}
/**弹出页显示项目详情*/
function frontopendetail(projectid){
	window.open("/index/projectdetail/"+projectid+".shtml");
}