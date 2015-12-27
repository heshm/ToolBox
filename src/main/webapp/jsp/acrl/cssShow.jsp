<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s"  uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css" type="text/css">
<script type="text/javascript">
function search(){
	document.searchForm.submit();
}
</script>
</head>
<body>
<div class="search" style="text-align:center;"> 
  <s:form name="searchForm" method="post" action="cssSearch" namespace="/acrl" theme="simple">
    <span>行号</span>
    <s:textfield name="brhno" maxlength="9" cssStyle="width:80px"/>
    <span>交易ID</span>
    <s:textfield name="txid" maxlength="60" cssStyle="width:100px"/>
    <input type="button" value="检索" onclick="search()">
  </s:form>
</div>
<div class="tab">
  <table>
    <thead>
      <tr>
        <th width="50">序号</th>
        <th width="90">法人行号</th>
        <th width="150">交易ID</th>
        <th>原条件号</th>
        <th>新条件号</th>
        <th width="150">操作</th>
      </tr>
    </thead>
    <tbody>
      <s:iterator var="css" value="%{cssList}">
      <tr>
        <td><s:property value="#css.seqno"/></td>
        <td><s:property value="#css.brhno"/></td>
        <td><s:property value="#css.txid"/></td>
        <td><s:property value="#css.oldCnd"/></td>
        <td><s:property value="#css.newCnd"/></td>
        <td><a href="">修改</a></td>
      </tr>
      </s:iterator>
    </tbody>
  </table>
</div>
<div class="modi_content">
  <table style="border:0px;height:80px">
    <tr>
      <td style="border:0px;text-align:right;">
        <input type="button" value="新增" onclick="insertTxInfo()" />
      </td>
      <td style="border:0px">
        <input type="button" value="返回" onclick="history.back();" />
      </td>
    </tr>
  </table>
</div>
</body>
</html>