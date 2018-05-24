<%@ include file="header.jsp"%>

<%@include file="navigation.jsp"%>

<div class="container">
    <h6>This is index using container</h6>
    <c:if test="${sessionScope.auth == 1}">
        <p>login successfully</p>
    </c:if>
    <c:if test="${sessionScope.auth != 1}">
        <p>not login</p>
    </c:if>
</div>

${admin.getEmail()}

<%@ include file="footer.jsp"%>