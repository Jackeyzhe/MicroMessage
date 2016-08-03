function deleteBatch(basePath){
	$("#mainForm").attr("action",basePath+"servlet/DeleteBatchServlet");
	$("#mainForm").submit();
}