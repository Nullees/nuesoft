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
<!-- ��ѯ������ -->
<div class="query">
  <table>
    <caption>
                 �˵�����
      <hr>
    </caption>
    <tr class="title">
      <td colspan="100">��ѯ����</td>
    </tr>
    <tr>
      <td>�˵����</td>
      <td>
        <input type="text" name="qsaa402" autofocus="autofocus">
      </td>
      <td>�˵�����</td>
      <td>
        <input type="text" name="qsaa403">
      </td>
    </tr>
  </table>
</div>  
<!-- ���ݵ����� -->
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
<!-- ��ť�� -->
<div class="button">
  <table>
    <tr class="title">
      <td colspan="100">
         <input type="submit" name="next" value="��ѯ">
         <input type="submit" name="next" value="���">
         <input type="submit" name="next" value="ɾ��" disabled="disabled">
      </td>
    </tr>
  </table>
</div>  
</form>
</body>
</html>