<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${suser eq null}">
	<jsp:forward page="/user/login"></jsp:forward>
</c:if>
<c:if test="${suser ne null}">
	<jsp:forward page="/list"></jsp:forward>
</c:if>