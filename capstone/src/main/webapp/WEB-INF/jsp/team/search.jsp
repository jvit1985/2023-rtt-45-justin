<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="../includes/header.jsp" />

<section class="py-5 bg-dark-grey">
    <div class="container text-center">
        <h1>Team Search</h1>
    </div>
</section>

<section class="py-5 bg-light-grey">
    <div class="container">
    <div class="row text-center justify-content-center">
    <div class="col-7">
        <form>
            <div class="input-group mb-3">
              <input type="text" class="form-control" name="teamSearch" placeholder="Team Name"
              aria-label="Team Name" aria-describedby="teamSearch" value="${teamSearchParam}">

              <button class="btn btn-outline-secondary" id="search">Search</button>
            </div>
        </form>
        </div>
    </div>
    </div>
</section>

<section class="py-5 bg-dark-grey">
    <div class="container text-center">

      <h4 class="pb-2">${teamList.size()} Search Results</h4>

        <table class="table table-striped border">
            <thead>
            <tr>
                <th scope="col">Team Id</th>
                <th scope="col">Team Name</th>
                <th scope="col">User Name</th>
                <th scope="col">Edit</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${teamList}" var="team">
                <tr>
                    <td><a href="/team/detail/${team.id}">${team.id}</a></td>
                    <td>${team.teamName}</td>
                    <td>${user.email}</td>
                    <td><a href="/team/edit/${team.id}">Edit</a></td>
                </tr>
              </c:forEach>
            </tbody>
        </table>
    </div>
</section>

<jsp:include page="../includes/footer.jsp" />