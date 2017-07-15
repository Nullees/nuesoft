<!-- 
三大指令
  page  --- 指定页面信息,比如编码格式等等
  include --- 包含指令,用以在一个页面导入另外一个页面
  taglib  --- 标签库指令
 -->
<%@ page language="java"  pageEncoding="GBK"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
   String path=request.getContextPath();
%>
<!-- 
    获取工程的名称，用于 28 行
 -->
<html>
<head>
<title>stu</title>
</head>
<body>
<TABLE width="99%" align="center" border="1">
  <TR>
    <TD width="15%" align="center" nowrap="nowrap" valign="top"> 
     <br>
             欢迎[${userinfo.saa102 }]归来
     <br>
	     <c:if test="${menus!=null }">
	        <c:forEach items="${menus }" var="ins">
	         <a href="<%=path %>/${ins.saa404 }" target="VIEW">${ins.saa403 }
	         </a>
	 <br>
	        </c:forEach>
	     </c:if>
    </TD>
    <TD width="85%">
        <iframe frameborder="1" width="1710" height="920" name="VIEW"></iframe>
    </TD>
  </TR>
</TABLE>
</body>
</html>