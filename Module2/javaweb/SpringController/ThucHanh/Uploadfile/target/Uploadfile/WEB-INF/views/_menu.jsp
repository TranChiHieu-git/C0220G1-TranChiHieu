<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div style="border:1px solid #ccc;padding:5px;" enctype="multipart/form-data">
    <a href="${pageContext.request.contextPath} /uploadOneFile" enctype="multipart/form-data">Upload One File</a>&nbsp;|&nbsp;
    <a href="${pageContext.request.contextPath} /uploadMultiFile" enctype="multipart/form-data">Upload Multi File</a>
</div>
