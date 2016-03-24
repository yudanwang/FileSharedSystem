<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Abi Abi
  Date: 2016/3/24
  Time: 12:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>FileSharedSystem</title>
</head>
<body>
<div class="container">
    <h1>Collection Management</h1>
    <hr/>

    <h4> Create a new Collection </h4>
    <form action="/collection" method="post" enctype="multipart/form-data">
        <input type="text" name="txtCollection" />
        <input type="submit" value="Create Collection" />
    </form>
    <hr/>
    <c:if test="${!empty collectionList}">
        <table class="table table-bordered table-striped">
            <tr>
                <th>id</th>
                <th>name</th>
            </tr>

            <c:forEach items="${collectionList}" var="collection">
                <tr>

                   <td><img src="http://icons.iconseeker.com/png/fullsize/leopard-folder-variations/smooth-navy-blue.png" height="20" width="20"></td> <td>${collection.id}</td>
                    <td>${collection.name}</td>

                    <td>
                        <a href="/collecton/view${collection.id}" type="button" class="btn btn-sm btn-success">View</a>
                        <a href="/artifact/delete/${collection.id}" type="button" class="btn btn-sm btn-warning">delete</a>
                        <a href="/artifact/update/${collection.id}" type="button" class="btn btn-sm btn-warning">update</a>
                    <td>

                </tr>
            </c:forEach>
        </table>
    </c:if>
</div>

<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>

<script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

</body>
</html>
