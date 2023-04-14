<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="include/header.jsp"/>


<section class="pt-5 pb-5" style="background-color:rgb(218, 225, 234)">
    <div class="container text-center">
        <h2 class="m-0">Create New Account</h2>
    </div>
</section>

<c:if test="${bindingResult.hasFieldErrors()}">
    <section class="pt-5">
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-sm-10 col-md-7 col-xl-5">
                    <c:forEach items="${bindingResult.getFieldErrors()}" var="error">
                        <div style="color:red;">${error.getDefaultMessage()}</div>
                    </c:forEach>
                </div>
            </div>
        </div>
    </section>
</c:if>

<section class="pt-5 pb-5">
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-sm-10 col-md-7 col-xl-5">
                <form method="POST" action="/signupSubmit">
                    <div class="mb-3">
                        <label for="email" class="form-label">* Email address</label>
                        <input type="text" placeholder="Email address" name="email" value="${form.email}"
                               class="form-control" id="email"
                               aria-describedby="emailHelp">
                        <div id="emailHelp" class="form-text">We'll never share your email with anyone else.</div>
                    </div>
                    <div class="mb-3">
                        <label for="name" class="form-label">Full Name</label>
                        <input type="text" class="form-control" name="fullName" id="fullName" value="${form.fullName}"
                               aria-describedby="nameHelp">
                        <div id="nameHelp" class="form-text">Let us know who you are</div>
                    </div>
                    <div class="mb-3">
                        <label for="password" class="form-label">Password</label>
                        <input type="password" class="form-control" name="password" id="password"
                               value="${form.password}" aria-describedby="passwordHelp">
                        <div id="passwordHelp" class="form-text">Minimum 8 characaters with uppercase, lowercase,
                            and a number
                        </div>
                    </div>
                    <div class="mb-3">
                        <label for="confirmPassword" class="form-label">Confirm Password</label>
                        <input type="password" class="form-control" name="confirmPassword"
                               value="${form.confirmPassword}" id="confirmPassword"
                               aria-describedby="confirmPasswordHelp">
                        <div id="confirmPasswordHelp" class="form-text">Re-enter your password.</div>
                    </div>


                    <button type="submit" id="create_btn" class="btn btn-primary mt-3 me-2">Create Account</button>
                </form>
            </div>
        </div>
    </div>
</section>

<jsp:include page="include/footer.jsp"/>