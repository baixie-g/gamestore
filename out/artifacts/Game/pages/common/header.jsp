<%--
  Created by IntelliJ IDEA.
  User: jhu
  Date: 2024/10/5
  Time: 11:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String basePath = request.getScheme()
            +"://"
            +request.getServerName()
    +":"
    +request.getServerPort()
    +request.getContextPath()
    +"/";
    pageContext.setAttribute("bastPath",basePath);

%>
<!-- 写base标签，永远固定相对路径跳转的结果 -->
<base href=<%=basePath%>>
<link type="text/css" rel="stylesheet" href="static/css/style.css" >
<script type="text/javascript" src="static/script/jquery-1.7.2.js"></script>
