<%@ page language="java" pageEncoding="GBK"%>
<%@ taglib uri="http://org.wangxg/jsp/extl" prefix="e" %>
<%String path=request.getContextPath(); %>
<html>
<head>
   <title>Insert title here</title>
   <style type="text/css">@IMPORT url("<%=path%>/css/style.css");</style>
</head>
<body>
<br>
<br>
<form action="<%=path%>/s1010.html" method="post">
  <div class="edit">
     <table>
       <caption>
                     �˵����
         <hr>
       </caption>
       <tr class="title">
         <td colspan="100">�˵���Ϣ</td>
       </tr>
       <tr>
         <td>�˵����</td>
         <td>
           <e:text name="saa402" autofocus="true" required="true"/>
         </td>
       </tr>
       <tr>
         <td>�˵�����</td>
         <td>
           <e:text name="saa403" required="true"/>
         </td>
       </tr>
       <tr>
         <td>open·��</td>
         <td>
           <e:text name="saa404" required="true"/>
         </td>
       </tr>
       
       <tr>
         <td>��������1</td>
         <td>
           <e:text name="saa4041"/>
         </td>
       </tr>
       <tr>
         <td>��������2</td>
         <td>
           <e:text name="saa4042"/>
         </td>
       </tr>
       <tr>
         <td>��������3</td>
         <td>
           <e:text name="saa4043"/>
         </td>
       </tr>
       <tr>
         <td>��������4</td>
         <td>
           <e:text name="saa4044"/>
         </td>
       </tr>
       <tr>
         <td>��������5</td>
         <td>
           <e:text name="saa4045"/>
         </td>
       </tr>

       <tr>
         <td>����</td>
         <td>
           <e:groupbox name="ah" value="C++:1,JAVA:2,C#:3,����:4"/>
         </td>
       </tr>
       <tr class="title">
         <td colspan="100" align="center">
           <input type="submit" name="next" value="���">
           <input type="submit" name="next" value="����">
         </td>
       </tr>
     </table>
  </div>

</form>

</body>
</html>