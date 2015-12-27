/**
 * 查询首页
 */
function getFirstPage(){
	document.pageForm.action="ovt_query.action";
	document.pageForm.submit();
}
/**
 * 查询上一页
 */
function getPrePage(){
	document.pageForm.action="ovt_query_pre.action";
	document.pageForm.submit();
}
/**
 * 查询下一页
 */
function getNextPage(){
	document.pageForm.action="ovt_query_next.action";
	document.pageForm.submit();
}
/**
 * 查询指定页
 */
function getIndexedPage(){
	var pageIndex = document.getElementById("pageIndex").value;
	var maxPage = document.getElementById("pageCnt").value;
	if(pageIndex > maxPage){
		alert("跳转不能超过最大页数!")
		document.getElementById("pageIndex").focus();
	}else{
	    var locat = "ovt_query.action?pageIndex=" + pageIndex;
	    document.pageForm.action=locat;
	    document.pageForm.submit();
	}
}
/**
 * 查询尾页
 */
function getLastPage(){
	var lastPage = document.getElementById("pageCnt").value;
	var locat = "ovt_query.action?pageIndex=" + lastPage;
	document.pageForm.action=locat;
	document.pageForm.submit();
}
/**
 * 条件查询
 */
function searchOvt(){
	document.searchForm.action="ovt_query.action";
	document.searchForm.submit();
}
/**
 * 删除记录
 */
function deleteOvt(seqNo){
	var currentPage = document.getElementById("currentPage").value;
	var locat = "ovt_delete.action?seqNo=" + seqNo + "&pageIndex=" + currentPage;
	document.searchForm.action=locat;
	if (confirm("确认删除该条记录!")){
		document.searchForm.submit();
	}
}
function addOvt(){
	document.searchForm.action="ovt_modi.action";
	document.searchForm.submit();
}
function updateOvt(seqNo){
	var location = "ovt_modi.action?seqNo=" + seqNo;
	document.searchForm.action=location;
	document.searchForm.submit();
}
