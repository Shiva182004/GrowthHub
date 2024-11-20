<%@page import="com.DB.DBConnect"%>
<%@page import="java.sql.Connection" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style type="text/css">
            .back-img{
                background: url("image/job (2).png");
                width: 100%;
                height: 86vh;
                background-repeat: no-repeat;
                background-size: cover;
            }
        </style>
        <%@include file="/WEB-INF/all_component/all_css.jsp" %>
    </head>
    <body>
        <%@include file="/WEB-INF/all_component/navbar.jsp" %>
        
        
        
        <div class="container-fluid back-img">
            <div class="text-center">
                <h1 class="text-yellow p-4">
                    <i class="fa fa-book" aria-hidden="true"></i> Online job Portal
                </h1>
            </div>
        </div>
        <%@include file="/WEB-INF/all_component/footer.jsp"  %>
    </body>
</html>
