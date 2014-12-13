<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
    <title>dialog demo</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/jquery/jquery-ui.css">
    <script src="<%=request.getContextPath()%>/jquery/jquery-1.8.3.js"></script>
    <script src="<%=request.getContextPath()%>/jquery/jquery-ui.js"></script>
</head>
<body>
<h1>Add New file</h1><div id="fileloader"><button name="Upload">UPLAOD</button></div>

<div id="dialog" title="UploadPath" width="100%" align="center">
<form action="AddMedia" method="post">
<input type="text" name="path" id="file"><br>
<input type="submit" name="submit" value="Submit">
</form>
</div>
<script>
$( "#dialog" ).dialog({ autoOpen: false });
$( "#dialog" ).dialog({ height: (150)});
$( "#dialog" ).dialog({ width: (300)});
$( "#dialog" ).dialog({ modal:true});
$( "#dialog" ).dialog({ zIndex: 20});
$( "#fileloader" ).click(function() {
    $( "#dialog" ).dialog( "open" );
});
</script>
</body>
</html>