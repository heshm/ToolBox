<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s"  uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<s:head/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="<%=request.getContextPath()%>/js/acrl/iat.js"></script>
<script type="text/javascript">


</script>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css" type="text/css">
</head>
<body>
<s:form name="pageForm" method="post" action="iatSearch" namespace="/acrl" theme="simple">
<div class="search"> 
  <span>条件1</span>
  <s:textfield name="cnd1" cssStyle="width:50px" maxlength="3"/>
  <span>条件2</span>
  <s:textfield name="cnd2" cssStyle="width:30px" maxlength="3"/>
  <span>科目号</span>
  <s:textfield name="glNo" cssStyle="width:70px" maxlength="8"/>
  <input type="button" value="检索" onclick="search()">
  <input type="button" value="新增" onclick="modiIat()">
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
</div>
<div>
  <div class="tab">
    <table>
      <thead>
        <tr>
          <th width="50">序号</th>
          <th width="70">科目号</th>
          <th>科目名称</th>
          <th width="80">条件1</th>
          <th width="80">条件2</th>
          <th width="150">账户序号</th>
          <th width="100">操作</th>
        </tr>
      </thead>
      <tbody>
        <s:iterator var="pageData" value="%{pageDataSet.pageData}">
        <tr>
          <td><s:property value="#pageData.seqNo"/></td>
          <td><s:property value="#pageData.glNo"/></td>
          <td><s:property value="#pageData.glaDS.name"/></td>
          <td><s:property value="#pageData.cnd1"/></td>
          <td><s:property value="#pageData.cnd2"/></td>
          <td><s:property value="#pageData.glSeqNo"/></td>
          <td><a href="javascript:modiIat('<s:property value="#pageData.seqNo"/>')">修改</a>
          </td>
        </tr>
        </s:iterator>
      </tbody>
    </table>
  </div>
</div>
<div class="pageInfo">
  <table width="100%" border="0" cellspacing="0" cellpadding="0">
    <tr>
      <td width="25%" height="29" nowrap="nowrap"><table width="342" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="44%" class="STYLE1">&nbsp;&nbsp;当前页:<s:property value="%{pageDataSet.currentPage}"/>/<s:property value="%{pageDataSet.pageCnt}"/>页 </td>
          </tr>
        </table></td>
      <td width="75%" valign="top" class="STYLE1"><div align="right">
          <table width="400" height="20" border="0" cellpadding="0" cellspacing="0">
            <tr>
              <s:set name="currentPage" value="%{pageDataSet.currentPage}"/>
              <s:if test="#currentPage==1">
                <td width="62" height="22" valign="middle"><input type="button" value="首页" disabled="disabled" style="background: #cde5ef;"/></td>
                <td width="50" height="22" valign="middle"><input type="button" value="上一页" disabled="disabled" style="background: #cde5ef;"/></td>
              </s:if>
              <s:else>
                <td width="62" height="22" valign="middle"><input type="button" value="首页" onclick="getFirstPage()"/></td>
                <td width="50" height="22" valign="middle"><input type="button" value="上一页" onclick="getPrePage()"/></td>
              </s:else>
              <td width="54" height="22" valign="middle">
                <s:if test="%{pageDataSet.hasNextPage}">
                  <input type="button" value="下一页" onclick="getNextPage()"/>
                </s:if>
                <s:else>
                  <input type="button" value="下一页" disabled="disabled" style="background: #cde5ef;"/>
                </s:else>
              </td>
              <s:set name="lastPage" value="%{pageDataSet.pageCnt}"/>
              <td width="49" height="22" valign="middle">
                <s:if test="#currentPage==#lastPage">
                  <input type="button" value="末页" disabled="disabled" style="background: #cde5ef;"/>
                </s:if>
                <s:else>
                  <input type="button" value="末页" onclick="getLastPage()"/>
                </s:else>
              </td>
              <td width="59" height="22" valign="middle"><div align="right">转到第</div></td>
              <td width="25" height="22" valign="middle"><span class="STYLE7"> 
                <input id="pageIndex" type="text" class="STYLE1" style="height:10px; width:25px;" size="5" />
                </span></td>
              <td width="23" height="22" valign="middle">页</td>
              <td width="30" height="22" valign="middle"><input type="button" value="转" onclick="getIndexedPage()"/></td>
            </tr>
          </table>
        </div></td>
    </tr>
  </table>
  <s:hidden id="currentPage" name="pageDataSet.currentPage" value="%{pageDataSet.currentPage}"/>
  <s:hidden name="pageDataSet.pageSize" value="%{pageDataSet.pageSize}"/>
  <s:hidden id="pageCnt" name="pageDataSet.pageCnt" value="%{pageDataSet.pageCnt}"/>
  <s:hidden name="pageDataSet.recordCnt" value="%{pageDataSet.recordCnt}"/>
</div>
</s:form>
</body>
</html>