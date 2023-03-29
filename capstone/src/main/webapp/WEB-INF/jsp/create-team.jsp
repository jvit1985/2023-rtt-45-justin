<jsp:include page="includes/header.jsp" />

<style>
    section {
        background-image: url("pub/images/The\ League.jpg");
        background-repeat: no-repeat;
        background-size: contain;
    }

    .container {
        border: none;
        opacity: .8;
    }

    .mb-3 {
        width: 50%;
        color: white;
        font-weight: bolder;
    }
</style>

<script>

        function checkNames() {
            //need to check all team names for text and highlight in red if no text in box

            let team1Input = document.querySelector("#team1name");
            let team1Value = team1Input.value;

            let team2Input = document.querySelector("#team2name");
            let team2Value = team2Input.value;

            let team3Input = document.querySelector("#team3name");
            let team3Value = team3Input.value;

            let team4Input = document.querySelector("#team4name");
            let team4Value = team4Input.value;

            let team5Input = document.querySelector("#team5name");
            let team5Value = team5Input.value;

            let team6Input = document.querySelector("#team6name");
            let team6Value = team6Input.value;

            let team7Input = document.querySelector("#team7name");
            let team7Value = team7Input.value;

            let team8Input = document.querySelector("#team8name");
            let team8Value = team8Input.value;

            let team9Input = document.querySelector("#team9name");
            let team9Value = team9Input.value;

            let team10Input = document.querySelector("#team10name");
            let team10Value = team10Input.value;

            let team11Input = document.querySelector("#team11name");
            let team11Value = team11Input.value;

            let team12Input = document.querySelector("#team12name");
            let team12Value = team12Input.value;

            let name = document.getElementById("team1name");
        console.log(name);
        console.log(name.value);

        // lets make the name value required
        if ( name.value == "" ) {
            console.log("Name is required");
            name.classList.add("is-invalid")
        }

        // create a new regular expression
        const re = new RegExp("[a-zA-Z]+");

        // the value that we want to match the regex against is - name.value
        // this is the value of the input field
        // the function match in javascript is going to do the regex match and we pass in the regex itself
        // match returns boolean true or false if matched or not
        const found = name.value.match(re);
        if ( found ) {
            console.log("the name matches the regex")
        } else {
            console.log("the name does not match the regex")
        }

      }
    </script>
    <section>
        <h1 class="text-center mt-3">Create Teams</h1>
        <div class="container">
        <h3 class="justify-content-start my-3">Add Team Owner Names</h3>
            <form>
                <div class="mb-3">
                    <label for="team1" class="form-label">Team 1</label>
                    <input type="text" class="form-control" name="team1name" id="team1name">
                  </div>
                  <div class="mb-3">
                    <label for="team2" class="form-label">Team 2</label>
                    <input type="text" class="form-control" name="team2name" id="team2name">
                  </div>
                  <div class="mb-3">
                    <label for="team3" class="form-label">Team 3</label>
                    <input type="text" class="form-control" name="team3name" id="team3name">
                  </div>
                  <div class="mb-3">
                    <label for="team4" class="form-label">Team 4</label>
                    <input type="text" class="form-control" name="team4name" id="team4name">
                  </div>
                  <div class="mb-3">
                    <label for="team5" class="form-label">Team 5</label>
                    <input type="text" class="form-control" name="team5name" id="team5name">
                  </div>
                  <div class="mb-3">
                    <label for="team6" class="form-label">Team 6</label>
                    <input type="text" class="form-control" name="team6name" id="team6name">
                  </div>
                  <div class="mb-3">
                    <label for="team7" class="form-label">Team 7</label>
                    <input type="text" class="form-control" name="team7name" id="team7name">
                  </div>
                  <div class="mb-3">
                    <label for="team8" class="form-label">Team 8</label>
                    <input type="text" class="form-control" name="team8name" id="team8name">
                  </div>
                  <div class="mb-3">
                    <label for="team9" class="form-label">Team 9</label>
                    <input type="text" class="form-control" name="team9name" id="team9name">
                  </div>
                  <div class="mb-3">
                    <label for="team10" class="form-label">Team 10</label>
                    <input type="text" class="form-control" name="team10name" id="team10name">
                  </div>
                  <div class="mb-3">
                    <label for="team11" class="form-label">Team 11</label>
                    <input type="text" class="form-control" name="team11name" id="team11name">
                  </div>
                  <div class="mb-3">
                    <label for="team12" class="form-label">Team 12</label>
                    <input type="text" class="form-control" name="team12name" id="team12name">
                  </div>
                <button type="submit" class="btn btn-primary mt-3" id="team-submit" onclick="checkNames()">Submit</button>
              </form>
        </div>
    </section>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/select2@4.1.0-rc.0/dist/js/select2.min.js"></script>

<jsp:include page="includes/footer.jsp" />