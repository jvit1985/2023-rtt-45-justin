<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="../includes/header.jsp" />

<section class="py-5 bg-dark-grey">
    <div class="container text-center">
    <c:if test="${empty form.id}">
        <h1>Create Player</h1>
    </c:if>
    <c:if test="${not empty form.id}">
            <h1>Edit Player</h1>

    </c:if>
    </div>
</section>

<section>
        <div class="container">
            <form action="/player/createSubmit" style="width: 50%;">
            <input type="hidden" name="id" value="${form.id}"/>
                <div class="mb-4">
                  <label for="playerName" class="form-label">Player Name</label>
                  <input type="text" class="form-control" id="name" name="name"
                  aria-describedby="playerNameHelp" value="${form.name}">
                </div>
                <div class="mb-4">
                    <label for="team" class="form-label">Team</label>
                    <input type="text" class="form-control" id="team" name="team"
                    aria-describedby="teamHelp" value="${form.team}">
                  </div>
                  <div class="mb-4">
                    <label for="position" class="form-label">Position</label>
                    <input type="text" class="form-control" id="position" name="position"
                    aria-describedby="positionHelp" value="${form.position}">
                  </div>

                <div class="mb-4">
                  <label for="bye" class="form-label">Bye Week</label>
                  <input type="text" class="form-control" id="bye" name="bye"
                  aria-describedby="byeHelp" value="${form.bye}">
                </div>
                <c:if test="${empty form.id}">
                     <button type="submit" id="create_btn" class="btn btn-primary mt-3 me-3" onclick="formSubmit()">Create Player</button>
                </c:if>
                <c:if test="${not empty form.id}">
                     <button type="submit" id="edit_btn" class="btn btn-primary mt-3 me-3" onclick="formSubmit()">Edit Player</button>

                </c:if>


            </form>
        </div>
    </section>

<jsp:include page="../includes/footer.jsp" />