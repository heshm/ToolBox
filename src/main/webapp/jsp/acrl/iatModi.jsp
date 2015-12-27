<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s"  uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<s:head/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css" type="text/css">
<script type="text/javascript" src="<%=request.getContextPath()%>/js/common/iat.js"></script>
<script type="text/javascript">
function modiIat(){
	if(confirm("确认提交?")){
		document.modiForm.submit();
	}
}
</script>
</head>
<body>
<div class="modi_content">
<s:hidden name="isUpdate" value="%{#request.isUpdate}"/>
<s:form name="modiForm" method="post" action="iatModi.action" namespace="/acrl" theme="simple">
  <table width="100%" cellpadding="0" cellspacing="0">
    <tr>
      <td width="30%" align="right"><div align="right">序号：</div></td>
      <td>
        <s:if test="#request.isUpdate">
          <s:property value="%{iatDS.seqNo}"/>
          <s:hidden name="iatDS.seqNo"/>
        </s:if>
        <s:else>
          <s:property value="%{seqNo}"/>
          <s:hidden name="iatDS.seqNo" value="%{seqNo}"/>
        </s:else>
      </td>
    </tr>
    <tr>
      <td width="30%" align="right"><div align="right">科目号：</div></td>
      <td> 
         <s:textfield name="iatDS.glNo" cssStyle="width:80px" maxlength="8" /> 
      </td>
    </tr>
    <tr>
      <td width="30%" align="right"><div align="right">条件1：</div></td>
      <td><s:textfield name="iatDS.cnd1" cssStyle="width:50px" maxlength="10" /></td>
    </tr>
    <tr>
      <td width="30%" align="right"><div align="right">条件2：</div></td>
      <td><s:textfield name="iatDS.cnd2" cssStyle="width:50px" maxlength="10" /></td>
    </tr>
    <tr>
      <td width="30%" align="right"><div align="right">内部账序号：</div></td>
      <td><s:textfield name="iatDS.glSeqNo" cssStyle="width:60px" maxlength="6" /></td>
    </tr>
    <s:if test="#request.isUpdate">
    <tr>
      <td width="30%" align="right"><div align="right">是否有效：</div></td>
      <td><s:radio name="iatDS.stat" list="#{'1':'有效','0':'无效' }"/></td>
    </tr>
    </s:if>
    <tr>
      <td colspan="2" align="center"><div align="center" >
        <s:if test="#request.isUpdate">
          <input type="button" value="更新" onclick="modiIat()" />
        </s:if>
        <s:else>
          <input type="button" value="提交" onclick="modiIat()" />
        </s:else>
          <input type="button" value="返回" onclick="history.back();" />
        </div></td>
    </tr>
  </table>
  <s:hidden name="cnd1"/>
  <s:hidden name="cnd2"/>
  <s:hidden name="glNo"/>
</s:form>
</div>
</body>
</html>