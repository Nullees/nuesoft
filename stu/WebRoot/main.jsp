<!-- 
����ָ��
  page  --- ָ��ҳ����Ϣ,��������ʽ�ȵ�
  include --- ����ָ��,������һ��ҳ�浼������һ��ҳ��
  taglib  --- ��ǩ��ָ��
 -->
<%@ page language="java"  pageEncoding="GBK"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
   String path=request.getContextPath();
%>
<!-- 
    ��ȡ���̵����ƣ����� 28 ��
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
             ��ӭ[${userinfo.saa102 }]����
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