$(document).ready(function(){
    rowNo = Number($("#cndCnt").val());
	$("#checkAll").click(function(){
		if(this.checked){
			$("input[name='checkRow']").prop("checked",true);
		}else{
			$("input[name='checkRow']").prop("checked",false);
		}
	})
});
function deleteRow(){
	if (confirm("确认删除选中行?")){
	    $("input[name='checkRow']").each(function(){
		    if($(this).prop("checked")){
			    var deletedRowId = "#row" + $(this).val();
			//alert(deletedRowId);
			    $(deletedRowId).remove();
		    }
	    })
	}
	//alert("Hello");
	//$("#row1").remove();
};
function addRow(){
	var newStr;
	var cndNo = $("#cndNo").val();
	var newRow = "<tr id=\"row" + rowNo + "\">";
	newRow += "<td><input type=\"checkbox\" name=\"checkRow\" value=\"" + rowNo + "\" /></td>";
	newRow +=  "<td>" + cndNo + "</td>";
	newRow +=  "<td><textarea name=\"cndList[" + rowNo + "].dscrb\" cols=\"5\" rows=\"4\" maxlength=\"20\"></textarea></td>";
	var str = "<td><input type=\"text\" name=\"cndList[" + rowNo + "].cnd";
	var newStr = "";
	for(var i=1;i<=16;i++){
		newStr = str + i + "\" value=\"\" style=\"width:40px\"/></td>";
		newRow += newStr;
	}
	newRow = newRow + "</tr>";
	$("#cndTable").append(newRow);
	rowNo = rowNo + 1;
};
function modiRow(){
	$("input[name='checkRow']").each(function(){
		if($(this).prop("checked")){
			var rowNo = $(this).val();
			var deletedRowId = "#row" + rowNo;
			//alert($(deletedRowId).$("td").html());
			$obj = $(deletedRowId).children("td");
			var text = "";
			for(var i=0;i<$obj.length;i++){
				if(i==2){
					text = $.trim($obj.eq(i).text());
					$obj.eq(i).html("");
					var str = "<textarea name=\"cndList[" + rowNo;
					str += "].dscrb\" cols=\"5\" rows=\"4\" maxlength=\"20\">";
					str += text + "</textarea>";
					$obj.eq(i).html(str);
					//alert(str);
				}
				if(i>=3){
					var j = i - 2;
					text = $.trim($obj.eq(i).text());
					if(""==text){
						text = $obj.eq(i).find("input").val();
					}
					$obj.eq(i).html("");
					var str = "<input type=\"text\" name=\"cndList[" + rowNo + "].cnd" + j;
					str += "\" value=\"";
					str += text ;
					str += "\" style=\"width:40px\"/>"
				    $obj.eq(i).html(str);	
				}
			}
		}
	})
}
function cndInfoModi(){
	if(confirm("确认提交?")){
		var txid = $("#txId").val();
		var cndNo = $("#cndNo").val();
		var location = "cndModi.action?txId=" + txid + "&cndNo=" + cndNo;
		//alert(location);
		document.cndForm.action = location;
		document.cndForm.submit();
	}
}
function goback(){
	location.href="../acrl/acrlInit.action";
}