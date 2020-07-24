
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Blog</title>
    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet" />
    <script src="<c:url value="/resources/js/jquery-1.11.1.min.js" />"></script>
    <script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
</head>
<body>
<div class="container">
    <jsp:directive.include file="../layout/header.jsp" />
 <header class="col-lg-12">
    <h1>Tous les employées</h1>
        <div class="col-lg-12">
            <a href="${pageContext.request.contextPath}/showNewEmployeeForm" class="btn btn-primary">Ajouter Employée</a>
            <br/>
        </div>
        <table class="table table-bordered">
            <tr>
                <th>Id</th>
                <th>email</th>
                <th>first name</th>
                <th>last name</th>
                <th>Action</th>

            </tr>
            <c:forEach items="${listEmployees}" var="item">
                <tr>
                    <td>${item.getId()}</td>
                    <td>
                        <a href="">${item.getEmail()}</a>
                    </td>
                    <td>
                        <a href="">${item.getFirstName()}</a>
                    </td>
                    <td>
                        <a href="">${item.getLastName()}</a>
                    </td>
                    <td>
                        <a href="" class="btn btn-danger"
                           onclick="if (!(confirm('Vous Voulez supprimer cet elementr?'))) return false">Supprimer</a>
                        <a href="" class="btn btn-success">Modifier</a>
                    </td>
                </tr>

            </c:forEach>
        </table>





 </header>

</div>

</body>
</html>