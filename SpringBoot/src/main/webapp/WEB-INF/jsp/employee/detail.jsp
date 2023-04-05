<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="../include/header.jsp" />

<section class="py-5 bg-dark-grey">
    <div class="container text-center">
        <h1>Employee Detail</h1>
    </div>
</section>

<section class="py-5 bg-dark-grey">
    <div class="container">

        <table class="table table-striped border">
                <tr>
                    <th scope="row">Id</th>
                    <td>${employee.id}</td>
                </tr>
                <tr>
                    <th scope="row">First Name</th>
                    <td><a href="/employee/search?firstSearch=${employee.firstName}">${employee.firstName}</a></td>
                </tr>
                <tr>
                    <th scope="row">Last Name</th>
                    <td><a href="/employee/search?lastSearch=${employee.lastName}">${employee.lastName}</a></td>
                </tr>
                <tr>
                    <th scope="row">Email</th>
                    <td>${employee.email}</td>
                </tr>
                <tr>
                    <th scope="row">Job Title</th>
                    <td>${employee.jobTitle}</td>
                </tr>
                <tr>
                    <th scope="row">Office Id</th>
                    <td>${employee.officeId}</td>
                </tr>
                <tr>
                     <th scope="row">Reports To</th>
                     <td>${employee.reportsTo}</td>
                </tr>
                <tr>
                     <th scope="row">Vacation Hours</th>
                     <td>${employee.vacationHours}</td>
                </tr>
                <tr>
                      <th scope="row">Extension</th>
                      <td>${employee.extension}</td>
                </tr>
                <tr>
                      <th scope="row">Profile Image</th>
                      <td><img src="${employee.profileImage}"></td>
                </tr>
                <tr>
                      <th scope="row">Edit</th>
                      <td><a href="/employee/edit/${employee.id}">Edit</a></td>
                </tr>
        </table>
    </div>
</section>

<jsp:include page="../include/footer.jsp" />