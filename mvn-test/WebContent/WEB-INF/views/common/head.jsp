<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<c:set var="ver" value="1.0.2"/>    
    
<script src="${jsPath}/jquery-3.4.1.js?ver=${ver}"></script>
<script src="${jsPath}/bootstrap.js?ver=${ver}"></script>
<script src="${jsPath}/bootstrap.bundle.js?ver=${ver}"></script>
<script src="${jsPath}/common.js?ver=${ver}"></script>
<link rel="stylesheet" href="${cssPath }/bootstrap.css?ver=${ver}"/>
<link rel="stylesheet" href="${cssPath }/bootstrap-reboot.css?ver=${ver}"/>
<link rel="stylesheet" href="${cssPath }/bootstrap-grid.css?ver=${ver}"/>

<script>
function goPage(url){
	location.href = '/views' + url;
		
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
</script>