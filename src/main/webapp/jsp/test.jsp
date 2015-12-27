<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s"  uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<style type="text/css">
</style>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-2.1.4.js"></script>
<script type="text/javascript">
function addRow(){
	var newRow = "<tr><td class=\"tdLabel\"></td><td><input type=\"text\" name=\"list[3]\" value=\"\" id=\"testmodi_list_2_\"/></td></tr>";
	$("#table1").append(newRow);
}
</script>
</head>
<body>
<div>
  
  <s:form action="testmodi.action" method="post">
    <table id="table1">
      <tr>
        <th>测试</th>
      </tr>
      <s:iterator value="%{list}" status="stat">
        <s:textfield name="list[%{#stat.index}]" />
      </s:iterator>
    </table>
    <input type="button" value="add" onclick="addRow()"/>
    <s:submit value="提交"/>
  </s:form>
</div>
</body>
</html>