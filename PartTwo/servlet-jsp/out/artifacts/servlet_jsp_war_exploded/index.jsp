<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
  <head>
    <title>Current Date and time</title>
  </head>
  <body>


  <div style="color: dodgerblue; font-size:140%;" >
    Date and hour are shown through index.jsp and DateHourServlet2:
  </div>
  <f:verbatim><br /></f:verbatim>
  <c:set var="dateTimeListValues" value="${dateTimeList}"/>
  <c:forEach items="${dateTimeListValues}" var="dateTime">
    <div style="color: green; font-size:120%;">
      <c:out value="${dateTime}"/>
    </div>
    <f:verbatim><br /></f:verbatim>
  </c:forEach>
  <form method="post">
    <input type="submit" name="generate" value="Go to Generate">
    <input type="submit" name="datetime" value="Get simple DATE/TIME">
    <input type="submit" name="home" value="Go to home.html">
  </form>

  </body>
</html>
