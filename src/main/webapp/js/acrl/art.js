$(document).ready(function(){
	rowNo = Number($("#artCnt").val());
	$("#checkAll").click(function(){
		if(this.checked){
			$("input[name='checkRow']").prop("checked",true);
		}else{
			$("input[name='checkRow']").prop("checked",false);
		}
	})
});
function deleteArtRow(){
	if (confirm("确认删除选中行?")){
	    $("input[name='checkRow']").each(function(){
		    if($(this).prop("checked")){
			    var deletedRowId = "#row" + $(this).val();
			//alert(deletedRowId);
			    $(deletedRowId).remove();
		    }
	    })
	}
}
function addArtRow(){
	var seqNo = $("#seqNo").val();
	//alert(seqNo);
	var newRow = "<tr id=\"row" + rowNo + "\">" +
	    "<td><input type=\"checkbox\" name=\"checkRow\" value=\"" + rowNo + "\" /></td>" +
	    "<td>" + seqNo + "</td>" +
	    "<td><input type=\"text\" name=\"artList[" + rowNo + "].seqNo\" style=\"width:20px\" maxlength=\"1\"/></td>" +
	    "<td><select name=\"artList[" + rowNo + "].debitOrCredit\"><option value=\"D\">借(收)</option><option value=\"C\">贷(付)</option><option value=\"\"></option></select></td>" +
	    "<td><input type=\"text\" name=\"artList[" + rowNo + "].glName\" style=\"width:70px\"/></td>" +
	    "<td><input type=\"text\" name=\"artList[" + rowNo + "].glNo\" style=\"width:70px\" maxlength=\"8\"/></td>" +
	    "<td><select name=\"artList[" + rowNo + "].account\"><option value=\"1111\">交易行</option><option value=\"2222\">开户行</option><option value=\"0000\"></option></select></td>" +
	    "<td><input type=\"text\" name=\"artList[" + rowNo + "].amtDscrb\" style=\"width:70px\"/></td>" +
	    "<td><input type=\"text\" name=\"artList[" + rowNo + "].amtPoint\" style=\"width:60px\" maxlength=\"5\"/></td>" +
	    "<td><input type=\"text\" name=\"artList[" + rowNo + "].glSeqNo\" style=\"width:50px\" maxlength=\"6\"/></td>" +
	    "<td><select name=\"artList[" + rowNo + "].overRide\"><option value=\"\"></option><option value=\"Y\">Y</option><option value=\"N\">N</option></select></td></tr>" ;
	//alert(newRow);
	$("#artTable").append(newRow);
	rowNo = rowNo + 1;
}
function modiArtRow(){
	$("input[name='checkRow']").each(function(){
		if($(this).prop("checked")){
			var rowNo = $(this).val();
			var modiRowId = "#row" + rowNo;
			$obj = $(modiRowId).children("td");
			var text = "";
			for(var i=0;i<$obj.length;i++){
				if(i==2){
					text = getText($obj.eq(i));
					$obj.eq(i).html("");
					var str = "<input type=\"text\" name=\"artList[" + rowNo + "].seqNo\" value=\"";
					str += text ;
					str += "\" style=\"width:20px\" maxlength=\"1\"/>";
				    $obj.eq(i).html(str);	
				}
				if(i==4){
					text = getText($obj.eq(i));
					$obj.eq(i).html("");
					var str = "<input type=\"text\" name=\"artList[" + rowNo + "].glName\" value=\"" + text + "\" style=\"width:70px\"/>";
				    $obj.eq(i).html(str);
				}
				if(i==5){
					text = getText($obj.eq(i));
					$obj.eq(i).html("");
					var str = "<input type=\"text\" name=\"artList[" + rowNo + "].glNo\" value=\"" + text + "\" style=\"width:70px\" maxlength=\"8\"/>";
				    $obj.eq(i).html(str);
				}
				if(i==7){
					text = getText($obj.eq(i));
					$obj.eq(i).html("");
					var str = "<input type=\"text\" name=\"artList[" + rowNo + "].amtDscrb\" value=\"" + text + "\" style=\"width:70px\"/>";
				    $obj.eq(i).html(str);
				}
				if(i==8){
					text = getText($obj.eq(i));
					$obj.eq(i).html("");
					var str = "<input type=\"text\" name=\"artList[" + rowNo + "].amtPoint\" value=\"" + text + "\" style=\"width:40px\" maxlength=\"5\"/>";
				    $obj.eq(i).html(str);
				}
				if(i==9){
					text = getText($obj.eq(i));
					$obj.eq(i).html("");
					var str = "<input type=\"text\" name=\"artList[" + rowNo + "].glSeqNo\" value=\"" + text + "\" style=\"width:50px\" maxlength=\"6\"/>";
				    $obj.eq(i).html(str);
				}
				if(i==3 || i==6 || i== 10){
					$obj.eq(i).children("input").remove();
					$obj.eq(i).children("select").removeAttr("disabled");
				}
			}
		}
	});
	function getText($obj){
		var text = $.trim($obj.text());
		if(""==text){
			text = $obj.find("input").val();
		}
		return text;
	}
}
function artModify(){
	var txId = $("#txId").val();
	var seqNo = $("#seqNo").val();
	var locat = "artModi.action?txId=" + txId + "&seqNo=" + seqNo;
	if(confirm("确认提交?")){
		document.artForm.action = locat;
		document.artForm.submit();
	}
}