
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
    <title>Ajouter article</title>
    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet" />
    <script src="<c:url value="/resources/js/jquery-1.11.1.min.js" />"></script>
    <script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
</head>
<body>
<div class="container">
    <jsp:directive.include file="../layout/header.jsp" />
    <header class="col-lg-12">
        <h1>Ajouter un employee</h1>
        <form:form method="post" action="./saveEmployee" modelAttribute="employee" >
            <form:input path="id" type="hidden" />
            <div class="form-group">
                <label for="firstName">First name</label>
                <form:input path="firstName" cssClass="form-control"  placeholder="first Name" />
                <form:errors path="firstName" cssClass="alert-danger" />
            </div>
            <div class="form-group">
                <label for="firstName">last Name</label>
                <form:input path="lastName" cssClass="form-control"  placeholder="last Name" />
                <form:errors path="lastName" cssClass="alert-danger" />
            </div>
            <div class="form-group">
                <label for="firstName">email</label>
                <form:input path="email" cssClass="form-control"  placeholder="email" />
                <form:errors path="email" cssClass="alert-danger" />
            </div>
            <div class="form-group">
                <label for="user">manager</label>
                <form:select  path="user">
                    <form:option value="1"> oussama</form:option>
                    <form:option value="2"> anass</form:option>
                    <form:option value="3"> hamid</form:option>
                    <form:option value="4"> ahmed</form:option>
                </form:select>
            </div>

            <div class="form-check">
                <label class="form-check-label">
                    departement
                </label>
                <form:select class="form-check-label"  path="departement" multiple="false">
                    <c:forEach items="${departement}" var="dep">
                        <form:option value="${dep.id}" >${dep.name}</form:option>
                    </c:forEach>
                </form:select>
                <form:errors path="departement" cssClass="alert-danger" />
            </div>

            <div class="form-group">
                <label for="subordinates">subordinates</label>
                <form:select  path="subordinates" multiple = "true">
                    <c:forEach items="${departement}" var="su^p">
                        <form:option value="${sup.id}" >${sup.name}</form:option>
                    </c:forEach>

                </form:select>
            </div>
            <div class="form-group">
                <label for="remuneration">remuneration fix</label>
                <form:input path="remuneration" cssClass="form-control"  placeholder="remuneration" />
                <form:errors path="remuneration" cssClass="alert-danger" />
            </div>
            <div class="form-group">
                <label >type rem</label>
                <form:radiobutton path = "temoinsrem" value = "1" label = "Rem_Fix" />
                <form:radiobutton path = "temoinsrem" value = "2" label = "Rem_Var" />
            </div>

            <input type = "submit" value = "Submit"/>
        </form:form>
    </header>
</div>
</body>
</html>