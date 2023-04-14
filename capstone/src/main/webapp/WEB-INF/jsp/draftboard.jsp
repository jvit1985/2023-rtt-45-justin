<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="includes/header.jsp" />

<style>
        table {
            background-image: url("pub/images/FantasyDraft\ logo\ -\ 1528\ x\ 529\ TRANSPARENT\ BLACK.png");
            background-repeat: no-repeat;
            background-size: contain;
        }

    </style>

<main>
        <h1 class="text-center mt-3">Draftboard</h1>
        <div class="mb-3 d-flex align-items-center justify-content-center" id="selection">
            <h3>Select Your Player</h3>
            <select class="dropdown" id="dropdown" style="color: black;" name="playerId">
            <c:forEach items="${players}" var="player">
                <option value="${player.id}">${player.name}</option>
            </c:forEach>
            </select>
            <button type="button" class="btn btn-primary ms-2" id="draft">Draft Player</button>
        </div>
            <h2 class="text-center">Fantasy Football Draft</h2>
            <div class="mx-3">
            <form action="/draftboard" method="post">
            <input type="hidden" name="id" value="${form.id}"/>
            </div>
            <div class="mb-4">
               <label for="teamId" class="form-label">Team</label>
                 <select class="form-select" id="teamId" name="teamId">
                   <c:forEach items="${teams}" var="team">
                     <option value="${team.id}"
                       <c:if test="${team.id eq form.teamId}">
                         selected
                       </c:if>
                     >${team.name}</option>
                   </c:forEach>
                 </select>
            </div>
                <div class="mb-4">
                  <label for="draftPick" class="form-label">Extension</label>
                  <input type="text" class="form-control" id="extension" name="extension"
                  aria-describedby="extensionHelp" value="${form.extension}">

                </div>
    </main>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/select2@4.1.0-rc.0/dist/js/select2.min.js"></script>
    <script src="/pub/js/script.js"></script>

<jsp:include page="includes/footer.jsp" />