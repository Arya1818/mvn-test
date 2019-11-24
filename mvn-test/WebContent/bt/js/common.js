/**
 * 
 */

function goPage(url) {
	location.href = '/views' + url;

}
function goGo(url){
	location.href = url;
}

function ajax(conf){
	var xhr = new XMLHttpRequest();
	xhr.open(conf.method, conf.url);
	xhr.onreadystatechange = function(){
		if(xhr.readyState==4){
			if(xhr.status==200){
				conf.callback(xhr.responseText);
			}
		}
	}
	xhr.send();
}



function makeFormData(){
	var objs = document.querySelectorAll('input[id],textarea[id]');
	var formData = new FormData();
	for(var i=0;i<objs.length;i++){
		var obj = objs[i];
		if(obj.type=='file'){
			if(obj.files.length){ 
				formData.append(obj.id, obj.files[0]);
			}
			
		}else{
			formData.append(obj.id, obj.value);
		}
	}
	return formData;
}


function send(conf){
	var xhr = new XMLHttpRequest();
	xhr.open(conf.method, conf.url);
	xhr.onreadystatechange = function(){
		if(xhr.readyState==4){
			if(xhr.status==200){
				conf.func(xhr.responseText);
			}
		}
	}
	xhr.send(conf.data);
}

//view
function ajax(conf) {  
	var xhr = new XMLHttpRequest();
	xhr.open(conf.method, conf.url);
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4) {
			if (xhr.status == 200) {
				conf.callback(xhr.responseText);
			}
		}
	}
	xhr.send();
}
