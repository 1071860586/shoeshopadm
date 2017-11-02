<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="sidebar-nav">
    <ul>
        <c:forEach items="${percontentList }" var="percontent">
            <jsp:include page="${percontent.pcmenu }"></jsp:include>
        </c:forEach>
    </ul>
</div>