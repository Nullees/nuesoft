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
      <td width="10%">�˵����</td>
      <td width="20%">
        <e:text name="qsaa402" autofocus="true"/>
      </td>
      <td width="10%">�˵�����</td>
      <td width="20%">
        <e:text name="qsaa403"/>
      </td>
      <td width="10%">�˵�״̬</td>
      <td width="30%">
        <e:select name="qsaa405"  value="����:1,ͣ��:2" header="true" />
      </td>
    </tr>
  </table>
</div>  
<!-- ���ݵ����� -->
<div class="data">
  <table>
    <tr class="title">
      <td>&nbsp;</td>
      <td>���</td>
      <td>�˵����</td>
      <td>�˵�����</td>
      <td>open·��</td>
      <td>�˵�״̬</td>
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
			      <td>${ins.saa405=='1'?'����':'ͣ��' }</td>
			      <td align="center">
			        <a href="#">[ɾ��]</a>
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
<!-- ��ť�� -->
<div class="button">
  <table>
    <tr class="title">
      <td colspan="100">
         <input type="submit" name="next" value="��ѯ" formaction="<%=path%>/s1011.html">
         <input type="submit" name="next" value="���">
         <input type="submit" name="next" value="ɾ��" disabled="disabled">
      </td>
    </tr>
  </table>
</div>  
</form>
</body>
</html>