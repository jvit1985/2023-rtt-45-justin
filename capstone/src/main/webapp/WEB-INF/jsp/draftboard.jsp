<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="includes/header.jsp" />

<main>
        <h1 class="text-center mt-3">Draftboard</h1>
        <form action="/draftboardSubmit" method="POST">
        <div class="mb-3 d-flex align-items-center justify-content-center" id="selection">
            <h3>Select Your Player</h3>
            <label for="playerId" class="form-label"></label>
            <select class="form-select" id="playerId" style="color: black;" name="playerId">
            <c:forEach items="${players}" var="player">
                <option value="${player.id}"
                    <c:if test="${player.id eq form.playerId}">
                        selected
                    </c:if>
                >${player.name}</option>
            </c:forEach>
            </select>
            <c:if test="${bindingResult.hasFieldErrors('playerId')}">
                                <c:forEach items="${bindingResult.getFieldErrors('playerId')}" var="error">
                                    <div style="color:red">${error.getDefaultMessage()}</div>
                                </c:forEach>
                              </c:if>
        </div>
            <h2 class="text-center">Fantasy Football Draft</h2>
            <div class="mx-3">
            <input type="hidden" name="id" value="${form.id}"/>
            </div>
             <c:if test="${success}">
                            <div class="alert alert-success" role="alert">
                                Draft Pick Created
                            </div>
                        </c:if>
            <div class="mb-4">
               <label for="teamId" class="form-label">Team</label>
                 <select class="form-select" id="teamId" name="teamId">
                   <c:forEach items="${teams}" var="team">
                     <option value="${team.id}"
                       <c:if test="${team.id eq form.teamId}">
                         selected
                       </c:if>
                     >${team.teamName}</option>
                   </c:forEach>
                 </select>
                 <c:if test="${bindingResult.hasFieldErrors('teamId')}">
                                     <c:forEach items="${bindingResult.getFieldErrors('teamId')}" var="error">
                                         <div style="color:red">${error.getDefaultMessage()}</div>
                                     </c:forEach>
                                   </c:if>
            </div>
                <div class="mb-4">
                  <label for="draftPickNumber" class="form-label">Draft Pick</label>
                  <input type="number" class="form-control" id="draftPickNumber" name="draftPickNumber"
                  aria-describedby="draftPickHelp" value="${form.draftPickNumber}">
            <c:if test="${bindingResult.hasFieldErrors('draftPickNumber')}">
                                <c:forEach items="${bindingResult.getFieldErrors('draftPickNumber')}" var="error">
                                    <div style="color:red">${error.getDefaultMessage()}</div>
                                </c:forEach>
                              </c:if>
                </div>
                <button type="submit" class="btn btn-primary ms-2" id="draft_btn">Draft Player</button>
            </form>
        <section class="py-5 bg-dark-grey">
            <div class="container text-center">
            <h4 class="pb-2">Draft Results</h4>

            <table class="table table-striped border">
                <thead>
                <tr>
                    <th scope="col">Pick Number</th>
                    <th scope="col">Name</th>
                    <th scope="col">Position</th>
                    <th scope="col">Team</th>
                    <th scope="col">Bye</th>
                </tr>
            </thead>
            <tbody>
            <c:forEach items="${teamPlayers}" var="players">
                <tr>
                    <td>${players.draft_pick_number}</td>
                    <td><a href="/player/detail/${players.id}">${players.name}</a></td>
                    <td>${players.position}</td>
                    <td>${players.team}</td>
                    <td>${players.bye}</td>
                </tr>
            </c:forEach>
            </tbody>
            </table>
        </div>
        </section>
    </main>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/select2@4.1.0-rc.0/dist/js/select2.min.js"></script>
    <script src="/pub/js/script.js"></script>

<jsp:include page="includes/footer.jsp" />