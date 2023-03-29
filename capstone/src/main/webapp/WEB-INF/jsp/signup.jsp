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
            <form>
                <div class="mb-3" style="width: 50%;">
                  <label for="exampleInputEmail" class="form-label">Email address</label>
                  <input type="email" class="form-control" name="exampleInputEmail" id="exampleInputEmail" aria-describedby="emailHelp">
                </div>
                <div class="mb-3" style="width: 50%;">
                    <label for="firstName" class="form-label">First Name</label>
                    <input type="text" class="form-control" name="firstName" id="firstName" aria-describedby="firstNameHelp">
                  </div>
                  <div class="mb-3" style="width: 50%;">
                    <label for="lastName" class="form-label">Last Name</label>
                    <input type="text" class="form-control" name="lastName" id="lastName" aria-describedby="lastNameHelp">
                  </div>
                <div class="mb-3" style="width: 50%;">
                  <label for="password" class="form-label">Password</label>
                  <input type="password" class="form-control" id="password" aria-describedby="PasswordHelp">
                  <div id="passwordHelp" class="form-text" style="font-weight: bolder; color: white;">Password must be 8 characters long and contain 1 Uppercase, 1 lowercase, and 1 number</div>
                </div>
                <div class="mb-3" style="width: 50%;">
                    <label for="confirmPassword" class="form-label">Confirm Password</label>
                    <input type="password" class="form-control" id="confirmPassword" aria-describedby="ConfirmPasswordHelp">
                    <div id="confirmPasswordHelp" class="form-text" style="font-weight: bolder; color:white;">Please re-enter your password</div>
                  </div>
                    <div class="mb-3 dropdown">
                        <h6 class="mt-3 mb-1" style="font-weight: bold;">Draft Position</h6>
                        <select name="draftPosition" id="draftPosition">
                            <option value="option1">Team 1</option>
                            <option value="option2">Team 2</option>
                            <option value="option3">Team 3</option>
                            <option value="option4">Team 4</option>
                            <option value="option5">Team 5</option>
                            <option value="option6">Team 6</option>
                            <option value="option7">Team 7</option>
                            <option value="option8">Team 8</option>
                            <option value="option9">Team 9</option>
                            <option value="option10">Team 10</option>
                            <option value="option11">Team 11</option>
                            <option value="option12">Team 12</option>
                        </select>
                    </div>
                    <h6 class="mt-3 mb-1" style="font-weight: bold;">Are you the League Manager?</h6>
                    <div class="form-check">
                        <input class="form-check-input" type="radio" name="flexRadioDefault" id="flexRadioDefault1">
                        <label class="form-check-label" for="flexRadioDefault1">
                          Yes
                        </label>
                      </div>
                      <div class="form-check">
                        <input class="form-check-input" type="radio" name="flexRadioDefault" id="flexRadioDefault2">
                        <label class="form-check-label" for="flexRadioDefault2">
                          No
                        </label>
                      </div>
                      <div class="mt-3" style="width: 50%;">
                        <label htmlFor="image" style="font-weight: bold;">Upload Profile Picture(Optional)</label>
                        <input type="file" id="image" name="image" accept="image/jpeg, image/png, image/svg"/>
                      </div>
                <button type="submit" class="btn btn-primary mt-3" id="signup-submit" onclick="formSubmit()">Submit</button>
                <button type="cancel" class="btn btn-secondary mt-3" onclick="cancelClicked()">Cancel</button>
              </form>
        </div>
    </section>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/select2@4.1.0-rc.0/dist/js/select2.min.js"></script>
    <script src="pub/js/script.js"></script>

<jsp:include page="includes/footer.jsp" />