
<jsp:include page="../includes/header.jsp" />

<section class="py-5 bg-dark-grey">
    <div class="container text-center">
        <h1>Login</h1>
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

<section class="pt-5 pb-5">
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-sm-10 col-md-7 col-xl-5">
                <form action="/login/loginpost" method="POST">
                    <div class="mb-3">
                        <label class="form-label">Email</label>
                        <input type="email" name="username"  class="form-control">
                    </div>
                    <div class="mb-3">
                        <label class="form-label">Password</label>
                        <input type="password" name="password"  class="form-control">
                    </div>

                    <button type="submit" id="create-btn" class="btn btn-primary mt-3 me-3">Login</button>
                </form>
            </div>
        </div>
    </div>
</section>



<jsp:include page="../includes/footer.jsp" />