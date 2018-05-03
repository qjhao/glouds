/**
 * 
 */
$(function(){
	
})

function initAudio(obj) {
	if(obj) {
		console.log(obj);
		$(obj).attr("class", "navbar-fixed-bottom sin-audio music-container");
		var str = '<div class="music-pannel"><audio id="audio" src="" autoplay controls class="pull-left musiccomp"></audio><input id="playnext" class="musiccomp pull-left btn btn-info" value="下一首" title="随机下一首" type="button" /></div>';
		$(obj).html(str);
		beginPlay();
	}else {
		console.log("未识别的组件");
	}
}

function beginPlay() {
	initFirstMusic();
	$("#playnext").click(function() {
		nextRandom();
	});
	$("#audio")[0].onended = next;
}

function initMusicList() {
	var str = "";
	$.ajax({
		url:"/sins/music/getAll",
		type:"post",
		dataType:"json",
		async:true,
		success:function(data) {
			if(data.message = "success") {
				for(var i=0;i<data.data.musicList.length;i++) {
					str += "<a href='javascript:;' onclick='play(this);' name='"+data.data.musicList[i].url+"'>"+data.data.musicList[i].name+"</a></br>";
				}
				$("#musicList").html(str);
			}
		},
		error:function() {
			
		}
	})
}

function play(obj) {
	$("#audio").attr("src", $(obj).attr("name"));
}

function initFirstMusic() {
	$.ajax({
		url:"/sins/music/play",
		type:"post",
		dataType:"json",
		async:true,
		success:function(data) {
			if(data.flag = "success") {
				$("#audio").attr("src", data.data.url);
				$("#audio").attr("autoplay","autoplay");
				document.title = data.data.name;
			}else {
				console.log(data.message);
			}
		},
		error:function() {
			
		}
	})
}

function next() {
	$.ajax({
		url:"/sins/music/next",
		type:"post",
		dataType:"json",
		async:true,
		success:function(data) {
			if(data.flag = "success") {
				$("#audio").attr("src", data.data.url);
				document.title = data.data.name;
			}else {
				console.log(data.message);
			}
		},
		error:function() {
			
		}
	})
}

function nextRandom() {
	$.ajax({
		url:"/sins/music/nextRandom",
		type:"post",
		dataType:"json",
		async:true,
		success:function(data) {
			if(data.flag = "success") {
				$("#audio").attr("src", data.data.url);
				document.title = data.data.name;
			}else {
				console.log(data.message);
			}
		},
		error:function() {
			
		}
	})
}