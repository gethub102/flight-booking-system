<%@ include file="header.jsp"%>

<%@include file="navigation.jsp"%>

<div class="container">
    <div class="row">
        <h3>Admin</h3>
        <hr>
        <div class="col-xs-12 col-sm-10 col-md-8 col-sm-offset-1 col-md-offset-2">
            <form action="/admin/loginPost" method="get">
                <div class="form-group">
                    <label for="email">Mail</label>
                    <input
                            type="email"
                            id="email"
                            name="email"
                            class="form-control">
                </div>
                <div class="form-group">
                    <label for="password">Password</label>
                    <input
                            type="password"
                            id="password"
                            name="password"
                            class="form-control">
                </div>
                <input type="submit" class="btn btn-primary col-sm-3" value="Sign In">
            </form>
            <button class="btn btn-primary col-sm-offset-3 col-sm-3" onclick="location.href='/admin/register'">Register Account</button>
        </div>
    </div>
</div>




<%@ include file="footer.jsp"%>
