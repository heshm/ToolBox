<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s"  uri="/struts-tags"%>
<!DOCTYPE HTML>
<html>

<head>
<s:head/>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>欢迎登陆系统</title>
  <link rel="stylesheet" href="<%=request.getContextPath()%>/css/login.css" type="text/css"> 
<head>
<body>

  <section class="container">
    <div class="login">
      <h1>用户登录</h1>
      <s:form method="post" action="login" namespace="/" theme="simple">
        <p><s:textfield name="userName" theme="simple" placeholder="用户名"/></p>
        <p><s:password name="passWord" theme="simple" placeholder="密码"/></p>
        <p><s:actionerror /></p>
        <p class="remember_me">
          <label>
            <input type="checkbox" name="rememberMe" id="rememberMe" value="true">记住密码
          </label>
        </p>
        <p class="submit"><s:submit value="登录" theme="simple"/></p>
      </s:form>
    </div>

    <div class="login-help">
      <p>忘记密码? <a href="index.html">点击修改</a>.</p>
    </div>
  </section>
<div style="text-align:center;">
<p>版本：V1.0</p>
</div>
</body>
</html>
