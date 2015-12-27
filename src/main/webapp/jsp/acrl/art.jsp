<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s"  uri="/struts-tags"%>
<!DOCTYPE>
<html>
<head>
<s:head/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css" type="text/css">
<script type="text/javascript" src="<%=request.getContextPath()%>/js/acrl/art.js"></script>
<script type="text/javascript">

</script>

</head>
<body>
<div> 
  <table border="0" align="right" cellpadding="0" cellspacing="0">
    <tr>
      <td width="60"><table width="87%" border="0" cellpadding="0" cellspacing="0">
          <tr>
            <td class="STYLE1"><div align="center">
                <input type="checkbox" id="checkAll" name="checkAll" value="0" />
            </div></td>
            <td class="STYLE1"><div align="center">全选</div></td>
          </tr>
      </table></td>
      <td width="60"><table width="90%" border="0" cellpadding="0" cellspacing="0">
          <tr>
            <td class="STYLE1"><div align="center"><img src="<%=request.getContextPath()%>/images/001.gif" width="14" height="14" onclick="addArtRow()"/></div></td>
            <td class="STYLE1"><div align="center">新增</div></td>
          </tr>
      </table></td>
      <td width="60"><table width="90%" border="0" cellpadding="0" cellspacing="0">
          <tr>
            <td class="STYLE1"><div align="center"><img src="<%=request.getContextPath()%>/images/114.gif" width="14" height="14" onclick="modiArtRow()"/></div></td>
            <td class="STYLE1"><div align="center">修改</div></td>
          </tr>
      </table></td>
      <td width="52"><table width="88%" border="0" cellpadding="0" cellspacing="0">
          <tr>
            <td class="STYLE1"><div align="center"><img src="<%=request.getContextPath()%>/images/083.gif" width="14" height="14" onclick="deleteArtRow()"/></div></td>
            <td class="STYLE1"><div align="center">删除</div></td>
          </tr>
      </table></td>
    </tr>
  </table>
</div>
<div class="tab">
  <s:hidden id="txId" name="txId" value="%{#request.txId}"/>
  <s:hidden id="seqNo" name="seqNo" value="%{#request.seqNo}"/>
  <s:hidden id="artCnt" name="artCnt" value="%{#request.artCnt}"/>
  <s:form action="artModi" namespaces="/acrl" name="artForm" method="post">
  <table id="artTable">
    <thead>
      <tr>
        <th width="20"></th>
        <th width="50">条件号</th>
        <th width="50">序号</th>
        <th width="50">借贷别</th>
        <th width="50">会计分录</th>
        <th width="50">会计科目</th>
        <th width="50">记账行</th>
        <th width="50">金额说明</th>
        <th width="50">金额指针</th>
        <th width="50">内部分户账序号</th>
        <th width="50">允许Override</th>
      </tr>
    </thead>
    <tbody>
      <s:iterator var="art" value="%{artList}" status="stat">
      <tr id="row<s:property value="#stat.index"/>">
        <td><input type="checkbox" name="checkRow" value="<s:property value="#stat.index"/>" /></td>
        <td><s:property value="#art.acrlNo"/></td>
        <td><span><s:property value="#art.seqNo"/></span><s:hidden name="artList[%{#stat.index}].seqNo" theme="simple"/></td>
        <td>
          <s:select list="#{'D':'借(收)','C':'贷(付)'}" name="artList[%{#stat.index}].debitOrCredit" theme="simple" disabled="true" emptyOption="true"/>
          <s:hidden name="artList[%{#stat.index}].debitOrCredit" theme="simple"/>
        </td>
        <td><span><s:property value="#art.glName"/></span><s:hidden name="artList[%{#stat.index}].glName" theme="simple"/></td>
        <td><span><s:property value="#art.glNo"/></span><s:hidden name="artList[%{#stat.index}].glNo" theme="simple"/></td>
        <td>
            <s:select list="#{'1111':'交易行','2222':'开户行','0000':'' }" name="artList[%{#stat.index}].account" theme="simple" disabled="true"/>
            <s:hidden name="artList[%{#stat.index}].account" theme="simple"/>
        </td>
        <td><span><s:property value="#art.amtDscrb"/></span><s:hidden name="artList[%{#stat.index}].amtDscrb" theme="simple"/></td>
        <td><span><s:property value="#art.amtPoint"/></span><s:hidden name="artList[%{#stat.index}].amtPoint" theme="simple"/></td>
        <td><span><s:property value="#art.glSeqNo"/></span><s:hidden name="artList[%{#stat.index}].glSeqNo" theme="simple"/></td>
        <td>
          <s:select list="#{'Y':'Y','N':'N'}" name="artList[%{#stat.index}].overRide" theme="simple" disabled="true" emptyOption="true"/>
          <s:hidden name="artList[%{#stat.index}].overRide" theme="simple"/>
        </td>
      </tr>
      </s:iterator>
    </tbody>
  </table>
  </s:form>
</div>
<div class="modi_content">
  <table style="border:0px;height:80px">
    <tr>
      <td style="border:0px;text-align:right;">
        <input type="button" value="提交" onclick="artModify();" />
      </td>
      <td style="border:0px">
        <input type="button" value="返回" onclick="history.back();" />
      </td>
    </tr>
  </table>
</div>
</body>
</html>