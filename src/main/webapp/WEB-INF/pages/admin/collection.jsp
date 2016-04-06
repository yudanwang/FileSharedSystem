<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Abi Abi
  Date: 2016/3/24
  Time: 12:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>FileSharedSystem</title>
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

    <h4> Create a new Collection </h4>
    <form action="/admin/collection" method="post" enctype="multipart/form-data">
        <input type="text" name="txtCollection" />
        <input type="submit" value="Create Collection" />
    </form>
    <hr/>

    <h4> Shared Collection </h4>
    <form action="/admin/collection/shared/" method="post" enctype="multipart/form-data">
        <input type="text" name="token" />
        <input type="submit" value="Enter Collection" />
    </form>
    <hr/>


    <c:if test="${empty collectionList}">
        <div class="alert alert-warning" role="alert">
            <span class="glyphicon glyphicon-info-sign" aria-hidden="true">Collection list is empty</span>
        </div>
    </c:if>


    <c:if test="${!empty collectionList}">
        <table class="table table-bordered table-striped">
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Token</th>
                <th>Operate</th>
            </tr>

            <c:forEach items="${collectionList}" var="collection">
                <tr>
                    <td>${collection.id}</td>
                    <td>${collection.name}</td>
                    <td>${collection.key}</td>
                    <td>
                        <a href="/admin/collection/view/${collection.id}" type="button" class="btn btn-sm btn-success">View</a>
                        <a href="/admin/collection/delete/${collection.id}" type="button" class="btn btn-sm btn-danger">Delete</a>
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
