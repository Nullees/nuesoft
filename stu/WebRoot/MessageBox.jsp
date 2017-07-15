<%@ page language="java" pageEncoding="GBK"%>

<html> 
<head>
<title>信息提示</title>
<link href="<%=request.getContextPath()%>/css/message.css" type="text/css" rel="stylesheet"/>
</head>
<BODY leftMargin=0 topMargin=0 marginwidth="0" marginheight="0">
<BR>
<BR>
<BR>
<TABLE class=bgcolor5 cellSpacing=1 cellPadding=4 width=528 align=center border=0>
<TBODY>
  <TR class=bgcolor2>
    <TD class=f14w noWrap align=middle><B>[ 提 示 ]</B>&nbsp; </TD>
  </TR>
  <TR>
    <TD class=bgcolor1 align=middle colSpan=2 height=150>
      <P>
                  数据错误!
      </P>
  </TD>
  </TR>
  <TR>
    <TD class=bgcolor3 align=middle colSpan=2>
    	<input type="button" name="next" value="返回" onclick="JavaScript:history.back()">
    </TD>
  </TR>
 </TBODY>
</TABLE>
</BODY>
</html>
