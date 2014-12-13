<%@page import="org.sumanta.bean.Media"%>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>dialog demo</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/jquery/jquery-ui.css">
    <script src="<%=request.getContextPath()%>/jquery/jquery-1.8.3.js"></script>
    <script src="<%=request.getContextPath()%>/jquery/jquery-ui.js"></script>
</head>
<body>
 
<%
Media mda=((Media)request.getAttribute("media"));
%>

 
<div id="opener">open the dialog</div>
<div id="dialog" title="FlashPlayer" width="100%" align="center">
<video width="600" height="400" controls="controls">
  <source src="Player?id=<%=mda.getId() %>" type="audio/mpeg" autoplay="autoplay" ">
</video>
<button onclick="javascript:val()">close</button>
</div>
 
<script>
$( "#dialog" ).dialog({ autoOpen: false });
$( "#dialog" ).dialog({ height: (510)});
$( "#dialog" ).dialog({ width: (700)});
$( "#dialog" ).dialog({ modal:true});
$( "#dialog" ).dialog({ zIndex: 20});
$( "#opener" ).click(function() {
    $( "#dialog" ).dialog( "open" );
});
</script>
 <script>
function val()
{
var con=confirm("hi closing!!");
if(con==true)
$( "#dialog" ).dialog("destroy");
else
	{
	$( "#dialog" ).dialog({ modal:false});
	}
}
</script>
</body>
</html>