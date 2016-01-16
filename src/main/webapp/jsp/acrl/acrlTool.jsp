<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s"  uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css" type="text/css">
</head>
<body>
<div class="modi_content">
  <table width="100%" cellpadding="0" cellspacing="0">
    <tr>
      <td>文件名</td>
      <td>下载文件</td>
    </tr>
    <tr>
      <td><s:property value="%{#session.groupId}"/>ART</td>
      <td><a href="getAcrl.action?typ=ART">下载</a></td>
    </tr>
    <tr>
      <td><s:property value="%{#session.groupId}"/>CND</td>
      <td><a href="getAcrl.action?typ=CND">下载</a></td>
    </tr>
    <tr>
      <td><s:property value="%{#session.groupId}"/>OVT</td>
      <td><a href="getAcrl.action?typ=OVT">下载</a></td>
    </tr>
    <tr>
      <td><s:property value="%{#session.groupId}"/>IAT</td>
      <td><a href="getAcrl.action?typ=IAT">下载</a></td>
    </tr>
    <tr>
      <td><s:property value="%{#session.groupId}"/>CSS</td>
      <td><a href="getAcrl.action?typ=CSS">下载</a></td>
    </tr>
  </table>
</div>
</body>
</html>