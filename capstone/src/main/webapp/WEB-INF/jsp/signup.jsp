<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="includes/header.jsp" />

<style>

body {
        background-image: url("pub/images/Logo\ NFL.png");
        background-repeat: none;
        background-color: rgb(121, 22, 22);
        color: white;

    }

    form {
        font-weight: bold;
        opacity: .9;
    }

</style>

<script>

        function cancelClicked() {

        let passwordInput = document.getElementById('password');

        let confirmPasswordInput = document.getElementById('confirmPassword');

        let emailInput = document.getElementById('exampleInputEmail');
        emailInput.classList.remove("is-invalid");
        passwordInput.classList.remove("is-invalid");
        confirmPasswordInput.classList.remove("is-invalid");
        emailInput.value = "";
        passwordInput.value = "";
        confirmPasswordInput.value = "";

    }
        function formSubmit() {

        let emailInput = document.getElementById('exampleInputEmail');
        let emailValue = emailInput.value;

        let passwordInput = document.getElementById('password');
        let passwordValue = passwordInput.value;

        let confirmPasswordInput = document.getElementById('confirmPassword');
        let confirmPasswordValue = confirmPasswordInput.value;

        if (passwordValue == '') {
          passwordInput.classList.add("is-invalid");
        }

        if (confirmPasswordValue == '') {
          confirmPasswordInput.classList.add("is-invalid");
        }

        if (confirmPasswordValue != passwordValue) {
          confirmPasswordInput.classList.add("is-invalid");
          passwordInput.classList.add("is-invalid");
          document.getElementById('confirmPasswordHelp').innerText= "Password does not match";
          document.getElementById('confirmPasswordHelp').style.cssText += "color:red;";
        }

        if (emailValue == '') {
          emailInput.classList.add("is-invalid");
          emailInput.value = "Enter your email";
          document.getElementById('emailHelp').innerText= "Please enter your email address";
          document.getElementById('emailHelp').style.cssText += "color:red;";
        }

        var pass = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{7,20}$/;
        if (!passwordValue.match(pass)) {
            alert("Invalid password");
        }

      }
    </script>
    <section>
        <h1 class="text-center">Signup</h1>
        <div class="container">
        <h3 class="justify-content-start">New User Form</h3>
            <form action="/signupSubmit" method="post">
            <c:if test="${success}">
              <div class="alert alert-success" role="alert">
                 User Created
              </div>
            </c:if>

                <div class="mb-3" style="width: 50%;">
                  <label for="exampleInputEmail" class="form-label">Email address</label>
                  <input type="text" class="form-control" name="email" id="email" aria-describedby="emailHelp">
                  <c:if test="${bindingResult.hasFieldErrors('email')}">
                    <c:forEach items="${bindingResult.getFieldErrors('email')}" var="error">
                        <div style="color:white">${error.getDefaultMessage()}</div>
                    </c:forEach>
                  </c:if>
                </div>
                <div class="mb-3" style="width: 50%;">
                    <label for="firstName" class="form-label">First Name</label>
                    <input type="text" class="form-control" name="firstName" id="firstName" aria-describedby="firstNameHelp">
                  <c:if test="${bindingResult.hasFieldErrors('firstName')}">
                    <c:forEach items="${bindingResult.getFieldErrors('firstName')}" var="error">
                        <div style="color:white">${error.getDefaultMessage()}</div>
                    </c:forEach>
                  </c:if>
                  </div>
                  <div class="mb-3" style="width: 50%;">
                    <label for="lastName" class="form-label">Last Name</label>
                    <input type="text" class="form-control" name="lastName" id="lastName" aria-describedby="lastNameHelp">
                  <c:if test="${bindingResult.hasFieldErrors('lastName')}">
                    <c:forEach items="${bindingResult.getFieldErrors('lastName')}" var="error">
                        <div style="color:white">${error.getDefaultMessage()}</div>
                    </c:forEach>
                  </c:if>
                  </div>
                <div class="mb-3" style="width: 50%;">
                  <label for="password" class="form-label">Password</label>
                  <input type="password" class="form-control" name="password" id="password" aria-describedby="PasswordHelp">
                  <div id="passwordHelp" class="form-text" style="font-weight: bolder; color: white;">Password must be 8 characters long and contain 1 Uppercase, 1 lowercase, and 1 number</div>
                  <c:if test="${bindingResult.hasFieldErrors('password')}">
                    <c:forEach items="${bindingResult.getFieldErrors('password')}" var="error">
                        <div style="color:white">${error.getDefaultMessage()}</div>
                    </c:forEach>
                  </c:if>
                </div>
                <div class="mb-3" style="width: 50%;">
                    <label for="confirmPassword" class="form-label">Confirm Password</label>
                    <input type="password" class="form-control" id="confirmPassword" name="confirmPassword" aria-describedby="ConfirmPasswordHelp">
                    <div id="confirmPasswordHelp" class="form-text" style="font-weight: bolder; color:white;">Please re-enter your password</div>
                  <c:if test="${bindingResult.hasFieldErrors('confirmPassword')}">
                    <c:forEach items="${bindingResult.getFieldErrors('confirmPassword')}" var="error">
                        <div style="color:white">${error.getDefaultMessage()}</div>
                    </c:forEach>
                  </c:if>
                  </div>

                <button type="submit" class="btn btn-primary mt-3" id="signup-submit">Submit</button>

              </form>
        </div>
    </section>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/select2@4.1.0-rc.0/dist/js/select2.min.js"></script>
    <script src="pub/js/script.js"></script>

<jsp:include page="includes/footer.jsp" />