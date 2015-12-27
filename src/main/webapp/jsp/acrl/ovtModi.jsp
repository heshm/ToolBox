<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s"  uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<s:head/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css" type="text/css">
<script type="text/javascript">
function insertOvt(){
	if(confirm("确认修改该记录!")){
		document.modiForm.submit();
	}
}
</script>
</head>
<body>
<div class="modi_content">
<s:form name="modiForm" method="post" action="ovt_update.action" namespace="/acrl" theme="simple">
  <table width="100%" cellpadding="0" cellspacing="0">
    <tr>
      <td width="20%" align="right"><div align="right">序号：</div></td>
      <td>
        <s:property value="%{ovtDS.seqNo}"/>
        <s:hidden name="ovtDS.seqNo" value="%{ovtDS.seqNo}"/>
      </td>
    </tr>
    <tr>
      <td width="20%" align="right"><div align="right">类别：</div></td>
      <td><s:textfield name="ovtDS.typ" cssStyle="width:20px" maxlength="2" /></td>
    </tr>
    <tr>
      <td width="20%" align="right"><div align="right">条件1：</div></td>
      <td><s:textfield name="ovtDS.cnd1" cssStyle="width:30px" maxlength="3" /></td>
    </tr>
    <tr>
      <td width="20%" align="right"><div align="right">条件2：</div></td>
      <td><s:textfield name="ovtDS.cnd2" cssStyle="width:30px" maxlength="3" /></td>
    </tr>
    <tr>
      <td width="20%" align="right"><div align="right">科目号：</div></td>
      <td><s:textfield name="ovtDS.glNo" cssStyle="width:70px" maxlength="8" /></td>
    </tr>
    <tr>
      <td colspan="2" align="center"><div align="center" >
          <input type="button" value="提交" onclick="insertOvt()" />
          <input type="button" value="返回" onclick="history.back();" />
        </div></td>
    </tr>
  </table>
</s:form>
</div>
</body>
</html>