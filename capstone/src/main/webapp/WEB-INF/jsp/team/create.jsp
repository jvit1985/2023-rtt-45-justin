<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

  <jsp:include page="../includes/header.jsp" />

  <section class="py-5">
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
      <div class="row justify-content-center">

        <form action="/team/createSubmit" method="post" enctype="multipart/form-data" style="width: 50%;">
          <c:if test="${success}">
            <div class="alert alert-success" role="alert">
              Team Created
            </div>
          </c:if>
          <input type="hidden" name="id" value="${form.id}" />
          <div class="mb-4 align-content-center">
            <label for="teamName" class="form-label">Team Name</label>
            <input type="text" class="form-control" id="teamName" name="teamName" aria-describedby="teamNameHelp"
              value="${form.teamName}">
            <c:if test="${bindingResult.hasFieldErrors('teamName')}">
              <c:forEach items="${bindingResult.getFieldErrors('teamName')}" var="error">
                <div style="color:white">${error.getDefaultMessage()}</div>
              </c:forEach>
            </c:if>
          </div>
          <div class="mb-4">
            <label for="teamPicture" class="form-label">Team Picture</label>
            <input type="file" class="form-control" id="fileUpload" name="fileUpload" aria-describedby="teamPictureHelp"
              value="$(form.teamPicture)">
          </div>

          <c:if test="${empty form.id}">
            <button type="submit" id="create_btn" class="btn btn-primary mt-3 me-3">Create Team</button>
          </c:if>
          <c:if test="${not empty form.id}">
            <button type="submit" id="edit_btn" class="btn btn-primary mt-3 me-3">Edit Team</button>

          </c:if>
        </form>
      </div>

    </div>
    <div class=" pt-5 text-center create-team-image">

      <img src="../../../pub/images/The League.jpg" alt="The League Picture" style="height: 40%; width: 40%;">
    </div>

  </section>

  <jsp:include page="../includes/footer.jsp" />