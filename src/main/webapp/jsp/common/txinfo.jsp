<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s"  uri="/struts-tags"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css" type="text/css">
<script type="text/javascript" src="<%=request.getContextPath()%>/js/common/txinfo.js"></script>
<script type="text/javascript">
function insertTxInfo(){
	var location = "txinfoModi.action";
	document.txinfoForm.action=location;
	document.txinfoForm.submit();
}
</script>
</head>
<div class="search" style="text-align:center;"> 
  <s:form name="searchForm" method="post" action="txInfoQuery" namespace="/common" theme="simple">
    <span>交易ID</span>
    <s:textfield name="txInfo.txId" maxlength="9" cssStyle="width:80px"/>
    <span>交易名称</span>
    <s:textfield name="txInfo.txName" maxlength="60" cssStyle="width:100px"/>
    <input type="button" value="检索" onclick="search()">
  </s:form>
</div>
<s:form name="txinfoForm" namespace="/common" method="post" theme="simple">
   <s:hidden name="txInfo.txId"/>
   <s:hidden name="txInfo.txName"/>
</s:form>
<div class="tab">
  <table>
    <thead>
      <tr>
        <th width="50">序号</th>
        <th width="90">交易ID</th>
        <th width="100">交易类型</th>
        <th>交易名称</th>
      </tr>
    </thead>
    <tbody>
      <s:set name="sn" value="1"/>
      <s:set name="groupId" value="%{#session.groupId}"/>
      <s:iterator var="tx" value="%{txInfoList}">
      <tr>
        <s:set name="typ" value="#tx.txTyp"/>
        <td><s:property value="#sn"/></td>
        <td><s:property value="#tx.txId"/></td>
        <td>
          <s:if test="#typ=='K'">KB</s:if>
          <s:else>ONBB</s:else>
        </td>
        <td>
          <a id="<s:property value="#tx.txId"/>" href="javascript:txinfoMod('<s:property value="#tx.txId"/>')">
          <s:property value="#tx.txName"/></a>
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
        <input type="button" value="新增" onclick="insertTxInfo()" />
      </td>
      <td style="border:0px">
        <input type="button" value="返回" onclick="history.back();" />
      </td>
    </tr>
  </table>
</div>