/**
 * 
 */
$(function(){
	initAppList();
})

function initAppList() {
	var str = "";
	$.ajax({
		url:"/sins/myapp/app!getAll",
		type:"post",
		dataType:"json",
		async:true,
		success:function(data) {
			if(data.message = "success") {
				for(var i=0;i<data.data.appList.length;i++) {
					str += "<tr><td class='col-md-1 col-sm-1 col-lg-1'>"+data.data.appList[i].name+"</td><td class='col-md-1 col-sm-1 col-lg-1'>"+data.data.appList[i].desc+"</td><td class='col-md-2 col-sm-2 col-lg-2'><input type='button' class='btn btn-info' value='启动' onclick='runApp(this);' name='"+data.data.appList[i].id+"'/><input type='button' class='btn btn-danger' value='停止' onclick='destroyApp(this);' name='"+data.data.appList[i].id+"'/></td></tr>";
				}
				$("#tb").html(str);
			}
		},
		error:function() {
			
		}
	})
}

function runApp(msg) {
	$.ajax({
		url:"/sins/myapp/app!run",
		type:"post",
		dataType:"json",
		async:true,
		data:{
			id : $(msg).attr("name")
		},
		success:function(data) {
			alert(data);
		},
		error:function() {
			
		}
	})
}

function destroyApp(msg) {
	$.ajax({
		url:"/sins/myapp/app!destroy",
		type:"post",
		dataType:"json",
		async:true,
		data:{
			id : $(msg).attr("name")
		},
		success:function(data) {
			alert(data);
		},
		error:function() {
			
		}
	})
}