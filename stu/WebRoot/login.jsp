<!-- ָ�� -->
<%@ page language="java" pageEncoding="GBK"%>
<html>
<head>
  <title>stu</title>
</head>
<body>
<BR>
<BR>
<BR>
<BR>
<BR>
<BR>
<form action="/stu/login" method="post">
  <table border="1" width="30%" align="center">
    <caption>
                   �û���¼
      <hr width="160">
    </caption>
     <tr>
       <td colspan="100" align="center">
        &nbsp;${msg }&nbsp;
       </td>
     </tr>
     <tr>
       <td>�û���</td>
       <td>
         <input type="text" name="username" required="required" autofocus="autofocus">
       </td>
     </tr>
     <tr>
       <td>����</td>
       <td>
         <input type="password" name="password" required="required">
       </td>
     </tr>
     <tr>
       <td colspan="100" align="center">
          <input type="submit" name="next" value="��¼">
       </td>
     </tr>
  </table>

</form>   
</body>
</html>