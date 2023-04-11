<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="../includes/header.jsp" />

<section class="py-5 bg-dark-grey">
    <div class="container text-center">
    <c:if test="${empty form.id}">
        <h1>Create Team</h1>
    </c:if>
    <c:if test="${not empty form.id}">
            <h1>Edit Team</h1>

    </c:if>
    </div>
</section>

<section>
        <div class="container">
            <form action="/team/createSubmit" style="width: 50%;">
            <input type="hidden" name="userId" value="${form.userId}"/>
                <div class="mb-4">
                  <label for="id" class="form-label">Team Number</label>
                  <input type="text" class="form-control" id="id" name="id"
                  aria-describedby="idHelp" value="${form.id}">
                </div>
                <div class="mb-4">
                    <label for="teamName" class="form-label">Team Name</label>
                    <input type="text" class="form-control" id="teamName" name="teamName"
                    aria-describedby="teamNameHelp" value="${form.teamName}">
                  </div>
                  <div class="mb-4">
                    <label for="teamPicture" class="form-label">Team Picture</label>
                    <input type="file" class="form-control" id="teamPicture" name="teamPicture"
                    aria-describedby="teamPictureHelp" value="${form.teamPicture}">
                  </div>

                <c:if test="${empty form.id}">
                  <button type="submit" id="create_btn" class="btn btn-primary mt-3 me-3" onclick="formSubmit()">Create Team</button>
                </c:if>
                <c:if test="${not empty form.id}">
                  <button type="submit" id="edit_btn" class="btn btn-primary mt-3 me-3" onclick="formSubmit()">Edit Team</button>

                </c:if>
            </form>
        </div>
    </section>

<jsp:include page="../includes/footer.jsp" />