<%@ include file="./WEB-INF/include/header.jsp"%>

<%@include file="./WEB-INF/include/navigation.jsp"%>

<div class="container">
    <h6>This is index using container</h6>
    <c:if test="${sessionScope.auth == 1}">
        <p>login successfully</p>
    </c:if>
    <c:if test="${sessionScope.auth != 1}">
        <p>not login</p>
    </c:if>
</div>



<%@ include file="./WEB-INF/include/footer.jsp"%>