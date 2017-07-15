<%@ page language="java" pageEncoding="GBK"%>
<% String path=request.getContextPath(); %>
<html>
<head>
   <title>Insert title here</title>
   <style type="text/css">@IMPORT url("<%=path%>/css/style.css");</style>
</head>
<body>
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
      <td>菜单编号</td>
      <td>
        <input type="text" name="qsaa402" autofocus="autofocus">
      </td>
      <td>菜单名称</td>
      <td>
        <input type="text" name="qsaa403">
      </td>
    </tr>
  </table>
</div>  
<!-- 数据迭代区 -->
<div>
  <table>
    <tr>
      <td></td>
      <td></td>
      <td></td>
      <td></td>
    </tr>
  </table>
</div>  
<!-- 按钮区 -->
<div class="button">
  <table>
    <tr class="title">
      <td colspan="100">
         <input type="submit" name="next" value="查询">
         <input type="submit" name="next" value="添加">
         <input type="submit" name="next" value="删除" disabled="disabled">
      </td>
    </tr>
  </table>
</div>  
</form>
</body>
</html>