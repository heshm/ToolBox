<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s"  uri="/struts-tags"%>
<!DOCTYPE>
<html>
<head>
<s:head/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css" type="text/css">
<script type="text/javascript">
</script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/acrl/cnd.js"></script>
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
            <td class="STYLE1"><div align="center"><img src="<%=request.getContextPath()%>/images/001.gif" width="14" height="14" onclick="addRow()"/></div></td>
            <td class="STYLE1"><div align="center">新增</div></td>
          </tr>
      </table></td>
      <td width="60"><table width="90%" border="0" cellpadding="0" cellspacing="0">
          <tr>
            <td class="STYLE1"><div align="center"><img src="<%=request.getContextPath()%>/images/114.gif" width="14" height="14" onclick="modiRow()"/></div></td>
            <td class="STYLE1"><div align="center">修改</div></td>
          </tr>
      </table></td>
      <td width="52"><table width="88%" border="0" cellpadding="0" cellspacing="0">
          <tr>
            <td class="STYLE1"><div align="center"><img src="<%=request.getContextPath()%>/images/083.gif" width="14" height="14" onclick="deleteRow()"/></div></td>
            <td class="STYLE1"><div align="center">删除</div></td>
          </tr>
      </table></td>
    </tr>
  </table>
</div>
<div class="tab">
  <s:hidden id="txId" name="txId" value="%{#request.txId}"/>
  <s:hidden id="cndNo" name="cndNo" value="%{#request.cndNo}"/>
  <s:hidden id="cndCnt" name="cndCnt"/>
  <s:form action="cndModi" namespaces="/acrl" name="cndForm" method="post">
  <table id="cndTable">
    <thead>
      <tr>
        <th width="20"></th>
        <th width="50">条件号</th>
        <th width="50">条件说明</th>
        <s:iterator var="col" value="%{#session.cndColName}">
            <th width="50"><s:property value="#col.name"/></th>
        </s:iterator>
      </tr>
    </thead>
    <tbody>
      <s:iterator var="cnd" value="%{cndList}" status="stat">
      <tr id="row<s:property value="#stat.index"/>">
        <td><input type="checkbox" name="checkRow" value="<s:property value="#stat.index"/>" /></td>
        <td><s:property value="#cnd.cndNo"/></td>
        <td>
          <s:hidden name="cndList[%{#stat.index}].dscrb" theme="simple"/> 
          <s:textarea name="cndList[%{#stat.index}].dscrb" rows="4" cols="5" theme="simple" maxlength="20" disabled="true"/>  
        </td>
        <td><span><s:property value="#cnd.cnd1"/></span><s:hidden name="cndList[%{#stat.index}].cnd1" theme="simple"/></td>
        <td><span><s:property value="#cnd.cnd2"/></span><s:hidden name="cndList[%{#stat.index}].cnd2" theme="simple"/></td>
        <td><span><s:property value="#cnd.cnd3"/></span><s:hidden name="cndList[%{#stat.index}].cnd3" theme="simple"/></td>
        <td><span><s:property value="#cnd.cnd4"/></span><s:hidden name="cndList[%{#stat.index}].cnd4" theme="simple"/></td>
        <td><span><s:property value="#cnd.cnd5"/></span><s:hidden name="cndList[%{#stat.index}].cnd5" theme="simple"/></td>
        <td><span><s:property value="#cnd.cnd6"/></span><s:hidden name="cndList[%{#stat.index}].cnd6" theme="simple"/></td>
        <td><span><s:property value="#cnd.cnd7"/></span><s:hidden name="cndList[%{#stat.index}].cnd7" theme="simple"/></td>
        <td><span><s:property value="#cnd.cnd8"/></span><s:hidden name="cndList[%{#stat.index}].cnd8" theme="simple"/></td>
        <td><span><s:property value="#cnd.cnd9"/></span><s:hidden name="cndList[%{#stat.index}].cnd9" theme="simple"/></td>
        <td><span><s:property value="#cnd.cnd10"/></span><s:hidden name="cndList[%{#stat.index}].cnd10" theme="simple"/></td>
        <td><span><s:property value="#cnd.cnd11"/></span><s:hidden name="cndList[%{#stat.index}].cnd11" theme="simple"/></td>
        <td><span><s:property value="#cnd.cnd12"/></span><s:hidden name="cndList[%{#stat.index}].cnd12" theme="simple"/></td>
        <td><span><s:property value="#cnd.cnd13"/></span><s:hidden name="cndList[%{#stat.index}].cnd13" theme="simple"/></td>
        <td><span><s:property value="#cnd.cnd14"/></span><s:hidden name="cndList[%{#stat.index}].cnd14" theme="simple"/></td>
        <td><span><s:property value="#cnd.cnd15"/></span><s:hidden name="cndList[%{#stat.index}].cnd15" theme="simple"/></td>
        <td><span><s:property value="#cnd.cnd16"/></span><s:hidden name="cndList[%{#stat.index}].cnd16" theme="simple"/></td>
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
        <input type="button" value="提交" onclick="cndInfoModi();" />
      </td>
      <td style="border:0px">
        <input type="button" value="返回" onclick="goback();" />
      </td>
    </tr>
  </table>
</div>
</body>
</html>