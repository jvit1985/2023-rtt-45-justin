
<jsp:include page="include/header.jsp" />

    <section>
        <div class="container">
        <h1 style="text-align: center;">New User Form</h1>
            <form action="/signupSubmit" method="POST" style="width: 50%;">
                <div class="mb-3">
                  <label for="exampleInputEmail" class="form-label">Email address</label>
                  <input type="email" class="form-control" id="email" name="email" aria-describedby="emailHelp">
                  <div id="emailHelp" class="form-text">We'll never share your email with anyone else.</div>
                </div>
                <div class="mb-3"">
                    <label for="fullName" class="form-label">Full Name</label>
                    <input type="text" class="form-control" id="fullName" name="fullName" aria-describedby="firstNameHelp">
                  </div>
                <div class="mb-3">
                  <label for="password" class="form-label">Password</label>
                  <input type="password" class="form-control" id="password" name="password" aria-describedby="passwordHelp">
                  <div id="passwordHelp" class="form-text">Password must contain 1 Uppercase, 1 lowercase, and 1 number and be 8 characters long</div>
                </div>
                <div class="mb-3">
                    <label for="confirmPassword" class="form-label">Confirm Password</label>
                    <input type="password" class="form-control" id="confirmPassword" name="confirmPassword" aria-describedby="confirmPasswordHelp">
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
                <button type="submit" id="create-btn" class="btn btn-primary mt-3 me-3">Create Account</button>

            </form>
        </div>
    </section>

<jsp:include page="include/footer.jsp" />