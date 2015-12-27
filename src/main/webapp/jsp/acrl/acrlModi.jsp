<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s"  uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<s:head/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css" type="text/css">
<script type="text/javascript" src="<%=request.getContextPath()%>/js/common/acrl.js"></script>
<script type="text/javascript">
function addAcrl(){
	if(confirm("确认提交?")){
		document.modiForm.submit();
	}
}
function updateAcrl(){
	if(confirm("确认提交?")){
		document.modiForm.submit();
	}
}
function back(){
	location.href="acrlModiGoBack.action";
}
</script>
</head>
<body>
<div class="modi_content">
<s:form name="modiForm" method="post" action="acrlModi.action" namespace="/acrl" theme="simple">
  <table width="100%" cellpadding="0" cellspacing="0">
    <s:if test="#request.isUpdate">
    <tr>
      <td width="30%" align="right"><div align="right">交易ID：</div></td>
      <td><s:hidden name="acrlDS.txId"/><s:property value="%{acrlDS.txId}"/></td>
    </tr>
    <tr>
      <td width="30%" align="right"><div align="right">条件号：</div></td>
      <td> 
         <s:hidden name="acrlDS.seqNo"/><s:property value="%{acrlDS.seqNo}"/>
      </td>
    </tr>    
    </s:if>
    <s:else>
    <tr>
      <td width="30%" align="right"><div align="right">交易ID：</div></td>
      <td><s:textfield name="acrlDS.txId" cssStyle="width:70px" maxlength="7" /></td>
    </tr>
    <tr>
      <td width="30%" align="right"><div align="right">条件号：</div></td>
      <td> 
         <s:textfield name="acrlDS.seqNo" cssStyle="width:50px" maxlength="4" /> 
      </td>
    </tr>
    </s:else>
    <tr>
      <td width="30%" align="right"><div align="right">分录名称：</div></td>
      <td><s:textfield name="acrlDS.dscrb" cssStyle="width:260px" maxlength="60" /></td>
    </tr>
    <s:if test="#request.isUpdate">
    <tr>
      <td width="30%" align="right"><div align="right">是否有效：</div></td>
      <td><s:radio name="acrlDS.isValid" list="#{'1':'有效','0':'无效' }"/></td>
    </tr>
    </s:if>
    <tr>
      <td colspan="2" align="center"><div align="center" >
        <s:if test="#request.isUpdate">
          <input type="button" value="更新" onclick="updateAcrl()" />
        </s:if>
        <s:else>
          <input type="button" value="提交" onclick="addAcrl()" />
        </s:else>
          <input type="button" value="返回" onclick="back();" />
        </div></td>
    </tr>
  </table>
  <s:hidden name="isUpdate" value="%{#request.isUpdate}"/>
</s:form>
</div>
</body>
</html>