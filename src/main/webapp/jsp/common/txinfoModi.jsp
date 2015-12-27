<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s"  uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<s:head/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css" type="text/css">
<script type="text/javascript" src="<%=request.getContextPath()%>/js/common/txinfo.js"></script>
<script type="text/javascript">
function insertTxInfo(){
	if(confirm("确认插入该条数据?")){
		document.modiForm.action="txinfo_insert.action";
		document.modiForm.submit();
	}
}
</script>
</head>
<body>
<div class="modi_content">
<s:form name="modiForm" method="post" action="txinfoUpdate.action" namespace="/acrl" theme="simple">
  <table width="100%" cellpadding="0" cellspacing="0">
    <tr>
      <td width="30%" align="right"><div align="right">交易ID：</div></td>
      <td>
        <s:if test="#request.isUpdate">
          <s:property value="%{txInfo.txId}"/>
          <s:hidden name="txInfo.txId" value="%{txInfo.txId}"/>
        </s:if>
        <s:else>
          <s:textfield name="txInfo.txId" cssStyle="width:70px" maxlength="7" />
        </s:else>
      </td>
    </tr>
    <tr>
      <td width="30%" align="right"><div align="right">交易类型：</div></td>
      <td>
        <s:radio name="txInfo.txTyp" list="#{'G':'ONBB','K':'KB' }"/>
        <!--  
         <s:textfield name="txInfo.txTyp" cssStyle="width:20px" maxlength="2" /> -->
      </td>
    </tr>
    <tr>
      <td width="30%" align="right"><div align="right">交易名称：</div></td>
      <td><s:textfield name="txInfo.txName" cssStyle="width:260px" maxlength="60" /></td>
    </tr>
    <tr>
      <td colspan="2" align="center"><div align="center" >
        <s:if test="#request.isUpdate">
          <input type="button" value="更新" onclick="updateTxInfo()" />
        </s:if>
        <s:else>
          <input type="button" value="提交" onclick="insertTxInfo()" />
        </s:else>
          <input type="button" value="返回" onclick="history.back();" />
        </div></td>
    </tr>
  </table>
  <s:hidden name="searchId" value="%{#request.searchId}"/>
  <s:hidden name="searchName" value="%{#request.searchName}"/>
</s:form>
</div>
</body>
</html>