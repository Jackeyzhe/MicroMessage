function deleteBatch(basePath){
	$("#mainForm").attr("action",basePath+"servlet/DeleteBatchServlet");
	$("#mainForm").submit();
}

function add(basePath){
	$("#mainForm").attr("action",basePath+"servlet/ListToAddServlet");
	$("#mainForm").submit();
}