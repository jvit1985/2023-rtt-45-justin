
<jsp:include page="include/header.jsp" />

<script>
      function cancelClicked() {

        // let passwordInput = document.getElementById('password');

        // let confirmPasswordInput = document.getElementById('confirmPassword');

        // let emailInput = document.getElementById('exampleInputEmail');
        // emailInput.classList.remove("is-invalid");
        // passwordInput.classList.remove("is-invalid");
        // confirmPasswordInput.classList.remove("is-invalid");
        // emailInput.value = "";
        // passwordInput.value = "";
        // confirmPasswordInput.value = "";

        let items = document.querySelectorAll(".is-invalid");

        for ( i of items) {
          console.log(i);
          item = i;
          item.classList.remove("is-invalid");
        }

      }

      function formSubmit() {

        let emailInput = document.getElementById('exampleInputEmail');
        let emailValue = emailInput.value;
        console.log(emailValue);

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
          alert("Invalid password")
        }
      }

      function arrayForEach() {
        let sum = 0;
        const numbers = [65, 44, 12, 4, 6];
        numbers.forEach(myFunction);

        function myFunction(item) {
          sum+= item;
        }
         console.log(sum);
      }

      arrayForEach();
    </script>

    <section>
        <div class="container">
        <h1 style="text-align: center;">New User Form</h1>
            <form style="width: 50%;">
                <div class="mb-3">
                  <label for="exampleInputEmail" class="form-label">Email address</label>
                  <input type="email" class="form-control" id="exampleInputEmail" aria-describedby="emailHelp">
                  <div id="emailHelp" class="form-text">We'll never share your email with anyone else.</div>
                </div>
                <div class="mb-3"">
                    <label for="firstName" class="form-label">First Name</label>
                    <input type="name" class="form-control" id="firstName" aria-describedby="firstNameHelp">
                  </div>
                  <div class="mb-3">
                    <label for="lastName" class="form-label">Last Name</label>
                    <input type="name" class="form-control" id="lastName" aria-describedby="lastNameHelp">
                  </div>
                <div class="mb-3">
                  <label for="password" class="form-label">Password</label>
                  <input type="password" class="form-control" id="password" aria-describedby="passwordHelp">
                  <div id="passwordHelp" class="form-text">Password must contain 1 Uppercase, 1 lowercase, and 1 number and be 8 characters long</div>
                </div>
                <div class="mb-3">
                    <label for="confirmPassword" class="form-label">Confirm Password</label>
                    <input type="password" class="form-control" id="confirmPassword" aria-describedby="confirmPasswordHelp">
                    <div id="confirmPasswordHelp" class="form-text">Please re-enter your password</div>
                  </div>
                    <!-- <div class="mb-3 dropdown">
                        <h6 class="mt-3 mb-3 text-decoration-underline">Country</h6>
                        <select name="Country" id="Country">
                            <option value="option1">USA</option>
                            <option value="option2">France</option>
                            <option value="option3">Canada</option>
                            <option value="option4">UK</option>
                        </select>
                    </div>
                    <h6 class="mt-3 mb-3 text-decoration-underline">Gender</h6>
                    <div class="form-check">
                        <input class="form-check-input" type="radio" name="flexRadioDefault" id="flexRadioDefault1">
                        <label class="form-check-label" for="flexRadioDefault1">
                          Male
                        </label>
                      </div>
                      <div class="form-check">
                        <input class="form-check-input" type="radio" name="flexRadioDefault" id="flexRadioDefault2">
                        <label class="form-check-label" for="flexRadioDefault2">
                          Female
                        </label>
                      </div>
                      <div class="form-check">
                        <input class="form-check-input" type="radio" name="flexRadioDefault" id="flexRadioDefault3">
                        <label class="form-check-label" for="flexRadioDefault3">
                          Other
                        </label>
                      </div>
                      <h6 class="mt-3 mb-3 text-decoration-underline">Favorite Color</h6>
                      <div class="form-check">
                        <input class="form-check-input" type="checkbox" value="" id="flexCheckRed">
                        <label class="form-check-label" for="flexCheckDefault">
                          Red
                        </label>
                      </div>
                      <div class="form-check">
                        <input class="form-check-input" type="checkbox" value="" id="flexCheckGreen">
                        <label class="form-check-label" for="flexCheckDefault">
                          Green
                        </label>
                      </div>
                      <div class="form-check">
                        <input class="form-check-input" type="checkbox" value="" id="flexCheckBlue">
                        <label class="form-check-label" for="flexCheckDefault">
                          Blue
                        </label>
                      </div> -->
                <button type="button" class="btn btn-primary mt-3 me-3" onclick="formSubmit()">Submit</button>
                <button type="cancel" class="btn btn-secondary mt-3" onclick="cancelClicked()">Cancel</button>
            </form>
        </div>
    </section>

<jsp:include page="include/footer.jsp" />