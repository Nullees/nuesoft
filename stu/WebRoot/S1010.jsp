<%@ page language="java" pageEncoding="GBK"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://org.wangxg/jsp/extl"  prefix="e" %>
<% String path=request.getContextPath(); %>
<html>
<head>
   <title>Insert title here</title>
   <style type="text/css">@IMPORT url("<%=path%>/css/style.css");</style>
</head>
<body>
<msg>
  <e:message/>  
</msg>
<br>
<br>
<form action="<%=path%>/S1011.jsp" method="post">
<!-- 查询条件区 -->
<div class="query">
  <table>
    <caption>
                 菜单管理
      <hr>
    </caption>
    <tr class="title">
      <td colspan="100">查询条件</td>
    </tr>
    <tr>
      <td width="10%">菜单编号</td>
      <td width="20%">
        <e:text name="qsaa402" autofocus="true"/>
      </td>
      <td width="10%">菜单名称</td>
      <td width="20%">
        <e:text name="qsaa403"/>
      </td>
      <td width="10%">菜单状态</td>
      <td width="30%">
        <e:select name="qsaa405"  value="在用:1,停用:2" header="true" />
      </td>
    </tr>
  </table>
</div>  
<!-- 数据迭代区 -->
<div class="data">
  <table>
    <tr class="title">
      <td>&nbsp;</td>
      <td>序号</td>
      <td>菜单编号</td>
      <td>菜单名称</td>
      <td>open路径</td>
      <td>菜单状态</td>
      <td>&nbsp;</td>
    </tr>
    <c:choose>
      <c:when test="${rows!=null }">
	      <c:forEach items="${rows }" var="ins" varStatus="vs">
			    <tr>
			      <td>
			        <input type="checkbox" name="idlist" value="${ins.saa401 }">
			      </td>
			      <td>${vs.index+1 }</td>
			      <td>${ins.saa402 }</td>
			      <td>${ins.saa403 }</td>
			      <td>${ins.saa404 }</td>
			      <td>${ins.saa405=='1'?'在用':'停用' }</td>
			      <td align="center">
			        <a href="#">[删除]</a>
			      </td>
			    </tr>
	      </c:forEach>
      </c:when>
      <c:otherwise>
          <c:forEach begin="1" end="15" step="1">
              <tr>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
              </tr>            
          </c:forEach>
      </c:otherwise>
    </c:choose>
    
    
   
  </table>
</div>  
<!-- 按钮区 -->
<div class="button">
  <table>
    <tr class="title">
      <td colspan="100">
         <input type="submit" name="next" value="查询" formaction="<%=path%>/s1011.html">
         <input type="submit" name="next" value="添加">
         <input type="submit" name="next" value="删除" disabled="disabled">
      </td>
    </tr>
  </table>
</div>  
</form>
</body>
</html>