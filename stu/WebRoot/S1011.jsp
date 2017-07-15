<%@ page language="java" pageEncoding="GBK"%>
<%@ taglib uri="http://org.wangxg/jsp/extl" prefix="e" %>
<%String path=request.getContextPath(); %>
<html>
<head>
   <title>Insert title here</title>
   <style type="text/css">@IMPORT url("<%=path%>/css/style.css");</style>
</head>
<body>
<msg>
  ${msg }
</msg>
<br>
<br>
<form action="<%=path%>/s1010.html" method="post">
  <div class="edit">
     <table>
       <caption>
                     菜单添加
         <hr>
       </caption>
       <tr class="title">
         <td colspan="100">菜单信息</td>
       </tr>
       <tr>
         <td>菜单编号</td>
         <td>
           <e:text name="saa402" autofocus="true" required="true"/>
         </td>
       </tr>
       <tr>
         <td>菜单名称</td>
         <td>
           <e:text name="saa403" required="true"/>
         </td>
       </tr>
       <tr>
         <td>open路径</td>
         <td>
           <e:text name="saa404" required="true"/>
         </td>
       </tr>
       <tr class="title">
         <td colspan="100" align="center">
           <input type="submit" name="next" value="添加">
           <input type="submit" name="next" value="返回">
         </td>
       </tr>
     </table>
  </div>

</form>

</body>
</html>