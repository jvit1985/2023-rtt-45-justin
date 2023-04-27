<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

  <jsp:include page="includes/header.jsp" />

  <section>
    <h1 class="text-center">Signup</h1>

    <div class="d-flex container align-content-start">



      <div class="d-flex align-content-start">

        <form action="/signupSubmit" method="post">
          <c:if test="${success}">
            <div class="alert alert-success" role="alert">
              User Created
            </div>
          </c:if>

          <h3 class="justify-content-center">New User Form</h3>
          <c:if test="${bindingResult.hasFieldErrors()}">
            <section class="py-5">

              <div class="row justify-content-start">
                <div class="col-sm-10 col-md-7 col-xl-5">
                  <c:forEach items="${bindingResult.getFieldErrors()}" var="error">
                    <div style="color:white;">${error.getDefaultMessage()}</div>
                  </c:forEach>
                </div>
              </div>

            </section>
          </c:if>
          <div class="mb-3" style="width: 70%;">
            <label for="exampleInputEmail" class="form-label">Email address</label>
            <input type="text" class="form-control" name="email" id="email" aria-describedby="emailHelp">
            <c:if test="${bindingResult.hasFieldErrors('email')}">
              <c:forEach items="${bindingResult.getFieldErrors('email')}" var="error">
                <div style="color:white">${error.getDefaultMessage()}</div>
              </c:forEach>
            </c:if>
          </div>
          <div class="mb-3" style="width: 70%;">
            <label for="firstName" class="form-label">First Name</label>
            <input type="text" class="form-control" name="firstName" id="firstName" aria-describedby="firstNameHelp">
            <c:if test="${bindingResult.hasFieldErrors('firstName')}">
              <c:forEach items="${bindingResult.getFieldErrors('firstName')}" var="error">
                <div style="color:white">${error.getDefaultMessage()}</div>
              </c:forEach>
            </c:if>
          </div>
          <div class="mb-3" style="width: 70%;">
            <label for="lastName" class="form-label">Last Name</label>
            <input type="text" class="form-control" name="lastName" id="lastName" aria-describedby="lastNameHelp">
            <c:if test="${bindingResult.hasFieldErrors('lastName')}">
              <c:forEach items="${bindingResult.getFieldErrors('lastName')}" var="error">
                <div style="color:white">${error.getDefaultMessage()}</div>
              </c:forEach>
            </c:if>
          </div>
          <div class="mb-3" style="width: 70%;">
            <label for="password" class="form-label">Password</label>
            <input type="password" class="form-control" name="password" id="password" aria-describedby="PasswordHelp">
            <div id="passwordHelp" class="form-text">Password must be 8 characters long and contain 1 Uppercase, 1
              lowercase, and 1 number</div>
            <c:if test="${bindingResult.hasFieldErrors('password')}">
              <c:forEach items="${bindingResult.getFieldErrors('password')}" var="error">
                <div style="color:white">${error.getDefaultMessage()}</div>
              </c:forEach>
            </c:if>
          </div>
          <div class="mb-3" style="width: 70%;">
            <label for="confirmPassword" class="form-label">Confirm Password</label>
            <input type="password" class="form-control" id="confirmPassword" name="confirmPassword"
              aria-describedby="ConfirmPasswordHelp">
            <div id="confirmPasswordHelp" class="form-text">Please re-enter your password</div>
            <c:if test="${bindingResult.hasFieldErrors('confirmPassword')}">
              <c:forEach items="${bindingResult.getFieldErrors('confirmPassword')}" var="error">
                <div style="color:white">${error.getDefaultMessage()}</div>
              </c:forEach>
            </c:if>
          </div>

          <button type="submit" class="btn btn-primary mt-3" id="signup-submit">Signup</button>

        </form>
        <div class="align-items-end justify-content-end">
          <img src="../../pub/images/Logo NFL.png" alt="NFL Logo" style="width: 600px; height: 600px;">
        </div>
      </div>

    </div>


  </section>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
    integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
    crossorigin="anonymous"></script>
  <script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
    crossorigin="anonymous"></script>
  <script src="https://cdn.jsdelivr.net/npm/select2@4.1.0-rc.0/dist/js/select2.min.js"></script>
  <script src="pub/js/script.js"></script>

  <jsp:include page="includes/footer.jsp" />