<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Print</title>
</head>
<body>
<c:set var="name" value="${name}"/>
<c:set var="age" value="${age}"/>
<label>Name of the person is: </label>
<div style="color: blueviolet; font-size:140%;" >
    <c:out value="${name}"/>
</div>
<f:verbatim><br /></f:verbatim>
<label>Age of the person is: </label>
<div style="color: burlywood; font-size:140%;">
    <c:out value="${age}"/>
</div>
</body>
</html>
