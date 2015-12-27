function getNextPage(){
	var currentPage = Number($("#currentPage").val());
	var nextPage = currentPage + 1;
	document.pageForm.action="iatSearch.action?pageIndex=" + nextPage;
	document.pageForm.submit();
}
function getPrePage(){
	var currentPage = Number($("#currentPage").val());
	var prePage = currentPage - 1;
	document.pageForm.action="iatSearch.action?pageIndex=" + prePage;
	document.pageForm.submit();
}
function getLastPage(){
	var lastPage = Number($("#pageCnt").val());
	document.pageForm.action="iatSearch.action?pageIndex=" + lastPage;
	document.pageForm.submit();
}
function getFirstPage(){
	document.pageForm.submit();
}
function search(){
	document.pageForm.submit();
}
function getIndexedPage(){
	var pageIndex = Number($("#pageIndex").val());
	var pageCnt = Number($("#pageCnt").val());
	if (pageIndex > pageCnt){
		alert("跳转不能超过最大页数!")
		document.getElementById("pageIndex").focus();
	}else{
		document.pageForm.action="iatSearch.action?pageIndex=" + pageIndex;
		document.pageForm.submit();
	}
}
function modiIat(seqNo){
	//var pageIndex = $("#currentPage").val();
	var cnd1 = $("input[name='cnd1']").val();
	var cnd2 = $("input[name='cnd2']").val();
	var glNo = $("input[name='glNo']").val();
	var url = "iatModiInit.action?seqNo=";
	if(seqNo){
		url += seqNo;
	}else{
		url += "";
	}
	  
	url += "&cnd1=" + cnd1 + "&cnd2=" + cnd2 + "&glNo=" + glNo;
	//alert(url);
	location.href=url;
}