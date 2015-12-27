function searchAcrl(){
	document.searchForm.submit();
}
function cndShow(txId,cndNo){
	
	var locat = "cndInit.action?txId=" + txId + "&cndNo=" + cndNo;
	location.href=locat;
}
function insertAcrl(){
	location.href="acrlModiInit.action";
}
function acrlUpdate(txId,seqNo){
	var locat = "acrlModiInit.action?txId=" + txId + "&seqNo=" + seqNo;
	location.href=locat;
}
function back(){
	location.href="acrlGoBack.action";
}