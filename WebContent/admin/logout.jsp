<%@ include file="/WEB-INF/include/header.jsp"%>

<%@include file="/WEB-INF/include/navigation.jsp"%>
<div class="container">
    <c:set var="auth" value="0" scope="session"/>
    <p>logout page</p>
    <% session.invalidate(); %>
    <c:redirect url="/index.jsp"/>
</div>

<%@ include file="/WEB-INF/include/footer.jsp"%>