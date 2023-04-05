<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="../include/header.jsp" />

<section class="py-5 bg-dark-grey">
    <div class="container text-center">
        <h1>Employee Search</h1>
    </div>
</section>

<section class="py-5 bg-light-grey">
    <div class="container">
    <div class="row text-center justify-content-center">
    <div class="col-7">
        <form>
            <div class="input-group mb-3">
              <input type="text" class="form-control" name="firstSearch" placeholder="Employee First Name"
              aria-label="Employee First Name" aria-describedby="firstSearch" value="${firstSearchParam}">
              <input type="text" class="form-control" name="lastSearch" placeholder="Employee Last Name"
              aria-label="Employee Last Name" aria-describedby="lastSearch" value="${lastSearchParam}">
              <button class="btn btn-outline-secondary" id="search">Search</button>
            </div>
        </form>
        </div>
    </div>
    </div>
</section>

<section class="py-5 bg-dark-grey">
    <div class="container text-center">

      <h4 class="pb-2">${employeesList.size()} Search Results</h4>

        <table class="table table-striped border">
            <thead>
            <tr>
                <th scope="col">Employee Id</th>
                <th scope="col">First Name</th>
                <th scope="col">Last Name</th>
                <th scope="col">Email</th>
                <th scope="col">Office City</th>
                <th scope="col">Job Title</th>
                <th scope="col">Edit</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${employeesList}" var="emp">
                <tr>
                    <td><a href="/employee/detail/${emp.id}">${emp.id}</a></td>
                    <td>${emp.firstName}</td>
                    <td>${emp.lastName}</td>
                    <td>${emp.email}</td>
                    <td>${emp.city}</td>
                    <td>${emp.job_title}</td>
                    <td><a href="/employee/edit/${emp.id}">Edit</a></td>
                </tr>
              </c:forEach>
            </tbody>
        </table>
    </div>
</section>

<jsp:include page="../include/footer.jsp" />