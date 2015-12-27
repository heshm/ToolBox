<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="/ERP/js/common/userInfo.js"></script>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/style.css" type="text/css">

  <div class="tab">
    <table>
      <thead>
        <tr>
          <th width="50">姓名</th>
          <th width="90">Email</th>
          <th width="100">操作</th>
        </tr>
      </thead>
      <tbody>
      <s:iterator var="user" value="%{userList}">
	    <tr>
		  <td><s:property value="#user.userName" /></td>
		  <td><s:property value="#user.email" /></td>
		  <td><input type="button" value="修改" onclick=""> <input
						type="button" value="删除" onclick=""> 
		  </td>
	    </tr>
	  </s:iterator>
      </tbody>
    </table>
  </div>
  <div class="modi_content">
    <table style="border:0px;height:80px">
      <tr>
        <td style="border:0px;text-align:right;">
          <input type="button" value="新增" onclick="" />
        </td>
        <td style="border:0px">
          <input type="button" value="返回" onclick="history.back();" />
        </td>
      </tr>
    </table>
  </div>
