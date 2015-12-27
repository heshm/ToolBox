<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s"  uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<s:head/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css" type="text/css">
<script type="text/javascript" src="<%=request.getContextPath()%>/js/acrl/acrlShow.js"></script>
<script type="text/javascript">
function artShow(txId,cndNo){
	
	var locat = "artInit.action?txId=" + txId + "&seqNo=" + cndNo;
	location.href=locat;
}
</script>
</head>
<body>
<div class="search" style="text-align:center;"> 
  <s:form name="searchForm" method="post" action="acrlSearch.action" namespace="/acrl" theme="simple">
    <span>交易ID</span>
    <s:textfield name="acrlId" maxlength="9" cssStyle="width:80px"/>
    <span>分录名称</span>
    <s:textfield name="acrlName" maxlength="60" cssStyle="width:100px"/>
    <input type="button" value="检索" onclick="searchAcrl()">
  </s:form>
</div>
<div class="tab">
  <table>
    <thead>
      <tr>
        <th width="50">序号</th>
        <th width="50">条件号</th>
        <th width="90">交易ID</th>
        <th>分录名称</th>
        <th width="150">分录表</th>
      </tr>
    </thead>
    <tbody>
      <s:set name="sn" value="1"/>
      <s:iterator var="acrl" value="%{acrlList}">
      <tr>
        <td><s:property value="#sn"/></td>
        <td><s:property value="#acrl.seqNo"/></td>
        <td><s:property value="#acrl.txId"/></td>
        <td>
          <a href="javascript:acrlUpdate('<s:property value="#acrl.txId"/>','<s:property value="#acrl.seqNo"/>')">
          <s:property value="#acrl.dscrb"/></a>
        </td>
        <td>
          <a href="javascript:cndShow('<s:property value="#acrl.txId"/>','<s:property value="#acrl.seqNo"/>')">CND</a>&nbsp;&nbsp;&nbsp;
          <a href="javascript:artShow('<s:property value="#acrl.txId"/>','<s:property value="#acrl.seqNo"/>')">ART</a>
        </td>
      </tr>
      <s:set var="sn" value="#sn + 1" />  
      </s:iterator>
    </tbody>
  </table>
</div>
<div class="modi_content">
  <table style="border:0px;height:80px">
    <tr>
      <td style="border:0px;text-align:right;">
        <input type="button" value="新增" onclick="insertAcrl()" />
      </td>
      <td style="border:0px">
        <input type="button" value="返回" onclick="back();" />
      </td>
    </tr>
  </table>
</div>
</body>
</html>