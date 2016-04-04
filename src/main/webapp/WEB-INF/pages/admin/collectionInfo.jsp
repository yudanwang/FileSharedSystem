<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Artifact Management</title>


    <link rel="stylesheet" href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="//cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="//cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<div class="container">
    <h1>Collection Management</h1>
    <hr/>

    <h3>Artifacts List
        <a href="/admin/collection/view/${collectionId}/upload" type="button" class="btn btn-primary btn-sm">Upload</a>
        <a href="/admin/collection/view/${collectionId}/add" type="button" class="btn btn-primary btn-sm">Add</a>
        <a href="/admin/collection/view/${collectionId}/remove" type="button" class="btn btn-primary btn-sm">Remove</a>
    </h3>


    <c:if test="${empty artifactList}">
        <div class="alert alert-warning" role="alert">
            <span class="glyphicon glyphicon-info-sign" aria-hidden="true"></span>Artifact list is empty<a href="/admin/collection/view/${collectionId}/upload" type="button" class="btn btn-primary btn-sm">Upload</a>
        </div>
    </c:if>


    <c:if test="${!empty artifactList}">
        <table class="table table-bordered table-striped">
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Operate</th>
            </tr>

            <c:forEach items="${artifactList}" var="artifact">
                <tr>
                    <td>${artifact.id}</td>
                    <td>${artifact.name}</td>
                    <td>
                        <a href="/admin/artifact/download/${artifact.id}" type="button" class="btn btn-sm btn-success">download</a>
                        <a href="/admin/artifact/update/${artifact.id}" type="button" class="btn btn-sm btn-warning">update</a>
                        <a href="/admin/artifact/delete/${artifact.id}" type="button" class="btn btn-sm btn-danger">delete</a>

                    </td>
                </tr>
            </c:forEach>
        </table>
    </c:if>

    <h3>Collection List
        <a href="/admin/collection/view/${collectionId}/addc" type="button" class="btn btn-primary btn-sm">Add</a>
        <a href="/admin/collection/view/${collectionId}/removec" type="button" class="btn btn-primary btn-sm">Remove</a>
    </h3>

    <c:if test="${empty subcollectionList}">
    <div class="alert alert-warning" role="alert">
        <span class="glyphicon glyphicon-info-sign" aria-hidden="true"></span>Collection list is empty</a>
    </div>
    </c:if>


    <c:if test="${!empty subcollectionList}">
        <table class="table table-bordered table-striped">
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Operate</th>
            </tr>

            <c:forEach items="${subcollectionList}" var="subcollection">
                <tr>
                    <td>${subcollection.id}</td>
                    <td>${subcollection.name}</td>
                    <td>
                        <a href="/admin/collection/view/${subcollection.id}" type="button" class="btn btn-sm btn-success">View</a>
                        <a href="/admin/collection/delete/${subcollection.id}" type="button" class="btn btn-sm btn-danger">Delete</a>
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