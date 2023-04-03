<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="../include/header.jsp" />

<section class="py-5 bg-dark-grey">
    <div class="container text-center">
        <h1>Create Employee</h1>
    </div>
</section>

<section>
        <div class="container">
            <form action="/employee/createSubmit" style="width: 50%;">
                <div class="mb-4">
                  <label for="exampleInputEmail" class="form-label">Email address</label>
                  <input type="email" class="form-control" id="email" name="email" aria-describedby="emailHelp">
                </div>
                <div class="mb-4">
                    <label for="firstName" class="form-label">First Name</label>
                    <input type="text" class="form-control" id="firstName" name="firstName" aria-describedby="firstNameHelp">
                  </div>
                  <div class="mb-4">
                    <label for="lastName" class="form-label">Last Name</label>
                    <input type="text" class="form-control" id="lastName" name="lastName" aria-describedby="lastNameHelp">
                  </div>
                  <div class="mb-4">
                     <label for="officeId" class="form-label">Office</label>
                     <select class="form-select" id="officeId" name="officeId">
                        <c:forEach items="${offices}" var="office">
                         <option value="${office.id}">${office.city}</option>
                        </c:forEach>
                     </select>
                  </div>
                <div class="mb-4">
                  <label for="extension" class="form-label">Extension</label>
                  <input type="text" class="form-control" id="extension" name="extension" aria-describedby="extensionHelp">

                </div>
                <div class="mb-4">
                    <label for="jobTitle" class="form-label">Job Title</label>
                    <input type="text" class="form-control" id="jobTitle" name="jobTitle" aria-describedby="jobTitleHelp">
                  </div>
                <div class="mb-4">
                    <label for="vacationHours" class="form-label">Vacation Hours</label>
                    <input type="number" class="form-control" id="vacationHours" name="vacationHours" aria-describedby="vacationHoursHelp">
                </div>

                <button type="submit" class="btn btn-primary mt-3 me-3" onclick="formSubmit()">Create Account</button>
            </form>
        </div>
    </section>

<jsp:include page="../include/footer.jsp" />