<%@ include file="/WEB-INF/include/header.jsp"%>

<%@include file="/WEB-INF/include/navigation.jsp"%>
<div class="container">
    <div class="row">
        <h3>Admin</h3>
        <hr>
        <div class="col-xs-12 col-sm-10 col-md-8 col-sm-offset-1 col-md-offset-2">
            <form>
                <div class="form-group">
                    <label for="fname">First Name</label>
                    <input
                            type="text"
                            id="fname"
                            name="fname"
                            class="form-control">
                </div>
                <div class="form-group">
                    <label for="lname">Last Name</label>
                    <input
                            type="text"
                            id="lname"
                            name="lname"
                            class="form-control">
                </div>
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
                <input type="submit" class="btn btn-primary col-sm-3" value="Sign Up">
            </form>
            <button class="btn btn-primary col-sm-offset-3 col-sm-3" onclick="location.href='/auth/login.jsp'">Already have an Account</button>
        </div>
    </div>
</div>

<%@ include file="/WEB-INF/include/footer.jsp"%>