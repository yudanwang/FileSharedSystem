<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>SpringMVC</title>


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
    <h1>Remove Element</h1>
    <hr/>
    <form:form action="/admin/collection/view/${collectionId}/remove" method="post" commandName="artifact" role="form">

        <div class="form-group">
            <label for="artifact.id">Artifact:</label>
            <select class="form-control" id="artifact.id" name="artifact.name">
                <c:forEach items="${artifactList}" var="artifact">
                    <option value="${artifact.id}" selected="selected">${artifact.name}</option>
                </c:forEach>
            </select>
        </div>
        <div class="form-group">
            <button type="submit" class="btn btn-sm btn-success">Remove</button>
        </div>
    </form:form>
</div>


<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>


<script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</body>
</html>