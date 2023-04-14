<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="../include/header.jsp" />

<section class="pt-5 pb-5" style="background-color:rgb(218, 225, 234)">
    <div class="container text-center">
        <h2 class="m-0">Login</h2>
    </div>
</section>

<c:if test="${param['error'] != null}">
    <section class="pt-5 bg-light-grey">
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-sm-10 col-md-7 col-xl-5">
                    <div class="alert alert-danger" role="alert">
                        Invalid Username or Password
                    </div>
                </div>
            </div>
        </div>
    </section>
</c:if>

<section class="pt-5 pb-5 bg-light-grey">
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-sm-10 col-md-7 col-xl-5">
                <!-- the method must always be post and the action must match the security config  .loginProcessingUrl -->
                <form method="POST" action="/login/loginpost">
                    <div class="mb-3">
                        <label class="form-label">Email</label>
                        <!-- this input name must be username because that is what spring security wants -->
                        <input type="text" name="username"  class="form-control">
                    </div>
                    <div class="mb-3">
                        <label class="form-label">Password</label>
                        <!-- this input name must be password because that is what spring security wants -->
                        <input type="password" name="password"  class="form-control">
                    </div>

                    <button type="submit" id="create_btn" class="btn btn-primary mt-3 me-2">Login</button>
                </form>
            </div>
        </div>
    </div>
</section>

<jsp:include page="../include/footer.jsp" />