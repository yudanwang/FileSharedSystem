<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: WangYudan
  Date: 2016/3/17
  Time: 17:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="container">
    <h1>Artifact Management</h1>
    <hr/>

    <h3>Arifact <a href="/upload" type="button" class="btn btn-primary btn-sm">Upload</a></h3>


    <c:if test="${empty artifactList}">
        <div class="alert alert-warning" role="alert">
            <span class="glyphicon glyphicon-info-sign" aria-hidden="true"></span>Artifacat list is empty<a href="/artifact/add" type="button" class="btn btn-primary btn-sm">Upload</a>
        </div>
    </c:if>


    <c:if test="${!empty artifactList}">
        <table class="table table-bordered table-striped">
            <tr>
                <th>id</th>
                <th>name</th>

            </tr>

            <c:forEach items="${artifactList}" var="artifact">
                <tr>
                    <td>${artifact.id}</td>
                    <td>${artifact.name}</td>

                    <td>
                        <a href="/artifact/download/${artifact.id}" type="button" class="btn btn-sm btn-success">download</a>
                        <a href="/artifact/delete/${artifact.id}" type="button" class="btn btn-sm btn-warning">delete</a>
                        <a href="/artifact/update/${artifact.id}" type="button" class="btn btn-sm btn-warning">update</a>

                    </td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
</div>


<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>


<script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</body>
</html>
