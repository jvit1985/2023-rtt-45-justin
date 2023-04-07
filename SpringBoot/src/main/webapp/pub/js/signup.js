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