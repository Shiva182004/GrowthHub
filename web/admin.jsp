<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin</title>
        <%@include file="/WEB-INF/all_component/all_css.jsp" %>
        <style type="text/css">
            .back-img{
                background: url("image/job (2).png");
                height: 100vh;
                width: 100%;
                background-repeat: no-repeat;
                background-size: cover;
            }
        </style>
    </head>
    <body>
        <c:if test="${userobj.role ne 'admin'}">
            <c:redirect url="login.jsp"></c:redirect>
        </c:if>
        <%@include file="/WEB-INF/all_component/navbar.jsp"%>
        <div class="container-fluid back-img">
            <div class="text-center">
                <h1 class="text-purple p-4">Welcome Admin</h1>
            </div>
        </div>
    </body>
</html>
