
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>后台界面</title>

</head>
<body>

<%--      <h1> 欢迎管理员 ${sessionScope.adminInfo.getAdminName}登录</h1>--%>
<%--      <h1> 你的密码是 ${sessionScope.adminInfo.getAdminPwd}</h1>--%>

      <h1>欢迎管理员  ${requestScope.adminInfo.adminName} 登录</h1>
      <h1>密码是 ${requestScope.adminInfo.adminPwd} </h1>
</body>
</html>
