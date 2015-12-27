function search(){
	document.searchForm.submit();
}
function txinfoMod(txId){
	var location = "txinfoModi.action?ID=" + txId;
	document.txinfoForm.action=location;
	document.txinfoForm.submit();
}
function updateTxInfo(){
	if(confirm("确认更新该条数据?")){
		document.modiForm.submit();
	}
}