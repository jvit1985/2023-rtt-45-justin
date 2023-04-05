<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="../include/header.jsp" />

<section class="py-5 bg-dark-grey">
    <div class="container text-center">
    <c:if test="${empty form.id}">
        <h1>Create Employee</h1>
    </c:if>
    <c:if test="${not empty form.id}">
            <h1>Edit Employee</h1>

    </c:if>
    </div>
</section>

<section>
        <div class="container">
            <form action="/employee/createSubmit" style="width: 50%;">
            <input type="hidden" name="id" value="${form.id}"/>
                <div class="mb-4">
                  <label for="exampleInputEmail" class="form-label">Email address</label>
                  <input type="email" class="form-control" id="email" name="email"
                  aria-describedby="emailHelp" value="${form.email}">
                </div>
                <div class="mb-4">
                    <label for="firstName" class="form-label">First Name</label>
                    <input type="text" class="form-control" id="firstName" name="firstName"
                    aria-describedby="firstNameHelp" value="${form.firstName}">
                  </div>
                  <div class="mb-4">
                    <label for="lastName" class="form-label">Last Name</label>
                    <input type="text" class="form-control" id="lastName" name="lastName"
                    aria-describedby="lastNameHelp" value="${form.lastName}">
                  </div>
                  <div class="mb-4">
                     <label for="officeId" class="form-label">Office</label>
                     <select class="form-select" id="officeId" name="officeId">
                        <c:forEach items="${offices}" var="office">
                         <option value="${office.id}"
                                <c:if test="${office.id eq form.officeId}">
                                    selected
                                </c:if>
                         >${office.city}</option>
                        </c:forEach>
                     </select>
                  </div>
                <div class="mb-4">
                  <label for="extension" class="form-label">Extension</label>
                  <input type="text" class="form-control" id="extension" name="extension"
                  aria-describedby="extensionHelp" value="${form.extension}">

                </div>
                <div class="mb-4">
                    <label for="jobTitle" class="form-label">Job Title</label>
                    <input type="text" class="form-control" id="jobTitle" name="jobTitle"
                    aria-describedby="jobTitleHelp" value="${form.jobTitle}">
                  </div>
                <div class="mb-4">
                    <label for="profileImage" class="form-label">Profile Image</label>
                    <input type="text" class="form-control" id="profileImage" name="profileImage"
                     aria-describedby="profileImageHelp" value="${form.profileImage}">
                </div>
                <div class="mb-4">
                    <label for="vacationHours" class="form-label">Vacation Hours</label>
                    <input type="number" class="form-control" id="vacationHours" name="vacationHours"
                    aria-describedby="vacationHoursHelp" value="${form.vacationHours}">
                </div>
                <div class="mb-4">
                <c:if test="${not empty form.id}">
                     <label for="employeeDetail" class="form-label">Employee Detail</label>
                     <a href="/employee/detail/${form.id}">Detail</a>

                    </c:if>
                </div>
                <c:if test="${empty form.id}">
                     <button type="submit" id="create_btn" class="btn btn-primary mt-3 me-3" onclick="formSubmit()">Create Account</button>
                </c:if>
                <c:if test="${not empty form.id}">
                     <button type="submit" id="edit_btn" class="btn btn-primary mt-3 me-3" onclick="formSubmit()">Edit Account</button>

                </c:if>

            </form>
        </div>
    </section>

<jsp:include page="../include/footer.jsp" />