<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="includes/header.jsp" />

<main>
        <h1 class="text-center mt-3">Draftboard</h1>
        
        <form action="/draftboardSubmit" method="POST">
        <div class="mb-3 pr-5 d-flex align-items-right justify-content-center" id="selection">
            <label for="playerId" class="form-label mx-2">Select Your Player</label>
            <select class="form-select playerId" id="playerId" style="width:50%" name="playerId">
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
                                    <div style="color:white">${error.getDefaultMessage()}</div>
                                </c:forEach>
                              </c:if>
        </div>
            <div class="mx-3">
            <input type="hidden" name="id" value="${form.id}"/>

            </div>

                <div class="text-center">
                    <button type="submit" class="mb-3 btn btn-primary" id="draft_btn">Draft Player</button>
                </div>
            </form>

        <section class="py-5 bg-dark-grey">
            <div class="container text-center">
            <h4 class="pb-2">Draft Results</h4>
            
            <table class="table table-striped table-bordered">
                <colgroup>
                    <col span="12" style="width: 8%;">
                  </colgroup>
                <thead>
                    <tr class="row-normal">
                        <c:forEach items="${teams}" var="team">
                            <th scope="col"><a href="team/detail/${team.id}">${team.teamName}</a></th>
                        </c:forEach>
                    </tr>
                </thead>
                    
                
                <tbody>
                   
                <tr class="row-normal">
                    <c:forEach begin="0" end="11" items="${teamPlayers}" var="players">

                            <c:choose>
                                <c:when test="${players.position eq 'RB'}">
                                    <td style="background-color: aqua;"><a href="/player/detail/${players.id}">${players.name}</a><br />
                                        ${players.position}<br />
                                        ${players.team}<br />
                                        Bye: ${players.bye}</td>
                                </c:when>
                                <c:when test="${players.position eq 'WR'}">
                                    <td style="background-color: green;"><a href="/player/detail/${players.id}">${players.name}</a><br />
                                        ${players.position}<br />
                                        ${players.team}<br />
                                        Bye: ${players.bye}</td>
                                </c:when>
                                <c:when test="${players.position eq 'TE'}">
                                    <td style="background-color: orange;"><a href="/player/detail/${players.id}">${players.name}</a><br />
                                        ${players.position}<br />
                                        ${players.team}<br />
                                        Bye: ${players.bye}</td>
                                </c:when>
                                <c:when test="${players.position eq 'QB'}">
                                    <td style="background-color: red;"><a href="/player/detail/${players.id}">${players.name}</a><br />
                                        ${players.position}<br />
                                        ${players.team}<br />
                                        Bye: ${players.bye}</td>
                                </c:when>
                                <c:when test="${players.position eq 'D/ST'}">
                                    <td style="background-color: brown;"><a href="/player/detail/${players.id}">${players.name}</a><br />
                                        ${players.position}<br />
                                        ${players.team}<br />
                                        Bye: ${players.bye}</td>
                                </c:when>
                                <c:when test="${players.position eq 'K'}">
                                    <td style="background-color: pink;"><a href="/player/detail/${players.id}">${players.name}</a><br />
                                        ${players.position}<br />
                                        ${players.team}<br />
                                        Bye: ${players.bye}</td>
                                </c:when>
                            </c:choose>

                        </c:forEach>
                    </tr>
                    <tr class="draft-row">
                    
                    
                                        <c:forEach begin="12" end="23" items="${teamPlayers}" var="players">

                                                <c:choose>
                                                    <c:when test="${players.position eq 'RB'}">
                                                        <td style="background-color: aqua;"><a href="/player/detail/${players.id}">${players.name}</a><br />
                                                            ${players.position}<br />
                                                            ${players.team}<br />
                                                            Bye: ${players.bye}</td>
                                                    </c:when>
                                                    <c:when test="${players.position eq 'WR'}">
                                                        <td style="background-color: green;"><a href="/player/detail/${players.id}">${players.name}</a><br />
                                                            ${players.position}<br />
                                                            ${players.team}<br />
                                                            Bye: ${players.bye}</td>
                                                    </c:when>
                                                    <c:when test="${players.position eq 'TE'}">
                                                        <td style="background-color: orange;"><a href="/player/detail/${players.id}">${players.name}</a><br />
                                                            ${players.position}<br />
                                                            ${players.team}<br />
                                                            Bye: ${players.bye}</td>
                                                    </c:when>
                                                    <c:when test="${players.position eq 'QB'}">
                                                        <td style="background-color: red;"><a href="/player/detail/${players.id}">${players.name}</a><br />
                                                            ${players.position}<br />
                                                            ${players.team}<br />
                                                            Bye: ${players.bye}</td>
                                                    </c:when>
                                                    <c:when test="${players.position eq 'D/ST'}">
                                                        <td style="background-color: brown;"><a href="/player/detail/${players.id}">${players.name}</a><br />
                                                            ${players.position}<br />
                                                            ${players.team}<br />
                                                            Bye: ${players.bye}</td>
                                                    </c:when>
                                                    <c:when test="${players.position eq 'K'}">
                                                        <td style="background-color: pink;"><a href="/player/detail/${players.id}">${players.name}</a><br />
                                                            ${players.position}<br />
                                                            ${players.team}<br />
                                                            Bye: ${players.bye}</td>
                                                    </c:when>
                                                </c:choose>

                                            </c:forEach>
                                        
                                        </tr>
                                        
                                        <tr class="row-normal">

                                        <c:forEach begin="24" end="35" items="${teamPlayers}" var="players">

                                                <c:choose>
                                                    <c:when test="${players.position eq 'RB'}">
                                                        <td style="background-color: aqua;"><a href="/player/detail/${players.id}">${players.name}</a><br />
                                                            ${players.position}<br />
                                                            ${players.team}<br />
                                                            Bye: ${players.bye}</td>
                                                    </c:when>
                                                    <c:when test="${players.position eq 'WR'}">
                                                        <td style="background-color: green;"><a href="/player/detail/${players.id}">${players.name}</a><br />
                                                            ${players.position}<br />
                                                            ${players.team}<br />
                                                            Bye: ${players.bye}</td>
                                                    </c:when>
                                                    <c:when test="${players.position eq 'TE'}">
                                                        <td style="background-color: orange;"><a href="/player/detail/${players.id}">${players.name}</a><br />
                                                            ${players.position}<br />
                                                            ${players.team}<br />
                                                            Bye: ${players.bye}</td>
                                                    </c:when>
                                                    <c:when test="${players.position eq 'QB'}">
                                                        <td style="background-color: red;"><a href="/player/detail/${players.id}">${players.name}</a><br />
                                                            ${players.position}<br />
                                                            ${players.team}<br />
                                                            Bye: ${players.bye}</td>
                                                    </c:when>
                                                    <c:when test="${players.position eq 'D/ST'}">
                                                        <td style="background-color: brown;"><a href="/player/detail/${players.id}">${players.name}</a><br />
                                                            ${players.position}<br />
                                                            ${players.team}<br />
                                                            Bye: ${players.bye}</td>
                                                    </c:when>
                                                    <c:when test="${players.position eq 'K'}">
                                                        <td style="background-color: pink;"><a href="/player/detail/${players.id}">${players.name}</a><br />
                                                            ${players.position}<br />
                                                            ${players.team}<br />
                                                            Bye: ${players.bye}</td>
                                                    </c:when>
                                                </c:choose>

                                            </c:forEach>
                                        </tr>
                                        
<tr class="draft-row">

                                        <c:forEach begin="36" end="47" items="${teamPlayers}" var="players">

                                                <c:choose>
                                                    <c:when test="${players.position eq 'RB'}">
                                                        <td style="background-color: aqua;"><a href="/player/detail/${players.id}">${players.name}</a><br />
                                                            ${players.position}<br />
                                                            ${players.team}<br />
                                                            Bye: ${players.bye}</td>
                                                    </c:when>
                                                    <c:when test="${players.position eq 'WR'}">
                                                        <td style="background-color: green;"><a href="/player/detail/${players.id}">${players.name}</a><br />
                                                            ${players.position}<br />
                                                            ${players.team}<br />
                                                            Bye: ${players.bye}</td>
                                                    </c:when>
                                                    <c:when test="${players.position eq 'TE'}">
                                                        <td style="background-color: orange;"><a href="/player/detail/${players.id}">${players.name}</a><br />
                                                            ${players.position}<br />
                                                            ${players.team}<br />
                                                            Bye: ${players.bye}</td>
                                                    </c:when>
                                                    <c:when test="${players.position eq 'QB'}">
                                                        <td style="background-color: red;"><a href="/player/detail/${players.id}">${players.name}</a><br />
                                                            ${players.position}<br />
                                                            ${players.team}<br />
                                                            Bye: ${players.bye}</td>
                                                    </c:when>
                                                    <c:when test="${players.position eq 'D/ST'}">
                                                        <td style="background-color: brown;"><a href="/player/detail/${players.id}">${players.name}</a><br />
                                                            ${players.position}<br />
                                                            ${players.team}<br />
                                                            Bye: ${players.bye}</td>
                                                    </c:when>
                                                    <c:when test="${players.position eq 'K'}">
                                                        <td style="background-color: pink;"><a href="/player/detail/${players.id}">${players.name}</a><br />
                                                            ${players.position}<br />
                                                            ${players.team}<br />
                                                            Bye: ${players.bye}</td>
                                                    </c:when>
                                                </c:choose>

                                            </c:forEach>
                                        </tr>
                                        <tr class="row-normal">
                                            <c:forEach begin="48" end="59" items="${teamPlayers}" var="players">
                        
                                                    <c:choose>
                                                        <c:when test="${players.position eq 'RB'}">
                                                            <td style="background-color: aqua;"><a href="/player/detail/${players.id}">${players.name}</a><br />
                                                                ${players.position}<br />
                                                                ${players.team}<br />
                                                                Bye: ${players.bye}</td>
                                                        </c:when>
                                                        <c:when test="${players.position eq 'WR'}">
                                                            <td style="background-color: green;"><a href="/player/detail/${players.id}">${players.name}</a><br />
                                                                ${players.position}<br />
                                                                ${players.team}<br />
                                                                Bye: ${players.bye}</td>
                                                        </c:when>
                                                        <c:when test="${players.position eq 'TE'}">
                                                            <td style="background-color: orange;"><a href="/player/detail/${players.id}">${players.name}</a><br />
                                                                ${players.position}<br />
                                                                ${players.team}<br />
                                                                Bye: ${players.bye}</td>
                                                        </c:when>
                                                        <c:when test="${players.position eq 'QB'}">
                                                            <td style="background-color: red;"><a href="/player/detail/${players.id}">${players.name}</a><br />
                                                                ${players.position}<br />
                                                                ${players.team}<br />
                                                                Bye: ${players.bye}</td>
                                                        </c:when>
                                                        <c:when test="${players.position eq 'D/ST'}">
                                                            <td style="background-color: brown;"><a href="/player/detail/${players.id}">${players.name}</a><br />
                                                                ${players.position}<br />
                                                                ${players.team}<br />
                                                                Bye: ${players.bye}</td>
                                                        </c:when>
                                                        <c:when test="${players.position eq 'K'}">
                                                            <td style="background-color: pink;"><a href="/player/detail/${players.id}">${players.name}</a><br />
                                                                ${players.position}<br />
                                                                ${players.team}<br />
                                                                Bye: ${players.bye}</td>
                                                        </c:when>
                                                    </c:choose>
                        
                                                </c:forEach>
                                            </tr>
                                            <tr class="draft-row">
                                                <c:forEach begin="60" end="71" items="${teamPlayers}" var="players">
                            
                                                        <c:choose>
                                                            <c:when test="${players.position eq 'RB'}">
                                                                <td style="background-color: aqua;"><a href="/player/detail/${players.id}">${players.name}</a><br />
                                                                    ${players.position}<br />
                                                                    ${players.team}<br />
                                                                    Bye: ${players.bye}</td>
                                                            </c:when>
                                                            <c:when test="${players.position eq 'WR'}">
                                                                <td style="background-color: green;"><a href="/player/detail/${players.id}">${players.name}</a><br />
                                                                    ${players.position}<br />
                                                                    ${players.team}<br />
                                                                    Bye: ${players.bye}</td>
                                                            </c:when>
                                                            <c:when test="${players.position eq 'TE'}">
                                                                <td style="background-color: orange;"><a href="/player/detail/${players.id}">${players.name}</a><br />
                                                                    ${players.position}<br />
                                                                    ${players.team}<br />
                                                                    Bye: ${players.bye}</td>
                                                            </c:when>
                                                            <c:when test="${players.position eq 'QB'}">
                                                                <td style="background-color: red;"><a href="/player/detail/${players.id}">${players.name}</a><br />
                                                                    ${players.position}<br />
                                                                    ${players.team}<br />
                                                                    Bye: ${players.bye}</td>
                                                            </c:when>
                                                            <c:when test="${players.position eq 'D/ST'}">
                                                                <td style="background-color: brown;"><a href="/player/detail/${players.id}">${players.name}</a><br />
                                                                    ${players.position}<br />
                                                                    ${players.team}<br />
                                                                    Bye: ${players.bye}</td>
                                                            </c:when>
                                                            <c:when test="${players.position eq 'K'}">
                                                                <td style="background-color: pink;"><a href="/player/detail/${players.id}">${players.name}</a><br />
                                                                    ${players.position}<br />
                                                                    ${players.team}<br />
                                                                    Bye: ${players.bye}</td>
                                                            </c:when>
                                                        </c:choose>
                            
                                                    </c:forEach>
                                                </tr>
                                                <tr class="row-normal">
                                                    <c:forEach begin="72" end="83" items="${teamPlayers}" var="players">
                                
                                                            <c:choose>
                                                                <c:when test="${players.position eq 'RB'}">
                                                                    <td style="background-color: aqua;"><a href="/player/detail/${players.id}">${players.name}</a><br />
                                                                        ${players.position}<br />
                                                                        ${players.team}<br />
                                                                        Bye: ${players.bye}</td>
                                                                </c:when>
                                                                <c:when test="${players.position eq 'WR'}">
                                                                    <td style="background-color: green;"><a href="/player/detail/${players.id}">${players.name}</a><br />
                                                                        ${players.position}<br />
                                                                        ${players.team}<br />
                                                                        Bye: ${players.bye}</td>
                                                                </c:when>
                                                                <c:when test="${players.position eq 'TE'}">
                                                                    <td style="background-color: orange;"><a href="/player/detail/${players.id}">${players.name}</a><br />
                                                                        ${players.position}<br />
                                                                        ${players.team}<br />
                                                                        Bye: ${players.bye}</td>
                                                                </c:when>
                                                                <c:when test="${players.position eq 'QB'}">
                                                                    <td style="background-color: red;"><a href="/player/detail/${players.id}">${players.name}</a><br />
                                                                        ${players.position}<br />
                                                                        ${players.team}<br />
                                                                        Bye: ${players.bye}</td>
                                                                </c:when>
                                                                <c:when test="${players.position eq 'D/ST'}">
                                                                    <td style="background-color: brown;"><a href="/player/detail/${players.id}">${players.name}</a><br />
                                                                        ${players.position}<br />
                                                                        ${players.team}<br />
                                                                        Bye: ${players.bye}</td>
                                                                </c:when>
                                                                <c:when test="${players.position eq 'K'}">
                                                                    <td style="background-color: pink;"><a href="/player/detail/${players.id}">${players.name}</a><br />
                                                                        ${players.position}<br />
                                                                        ${players.team}<br />
                                                                        Bye: ${players.bye}</td>
                                                                </c:when>
                                                            </c:choose>
                                
                                                        </c:forEach>
                                                    </tr>
                                                    <tr class="draft-row">
                                                        <c:forEach begin="84" end="95" items="${teamPlayers}" var="players">
                                    
                                                                <c:choose>
                                                                    <c:when test="${players.position eq 'RB'}">
                                                                        <td style="background-color: aqua;"><a href="/player/detail/${players.id}">${players.name}</a><br />
                                                                            ${players.position}<br />
                                                                            ${players.team}<br />
                                                                            Bye: ${players.bye}</td>
                                                                    </c:when>
                                                                    <c:when test="${players.position eq 'WR'}">
                                                                        <td style="background-color: green;"><a href="/player/detail/${players.id}">${players.name}</a><br />
                                                                            ${players.position}<br />
                                                                            ${players.team}<br />
                                                                            Bye: ${players.bye}</td>
                                                                    </c:when>
                                                                    <c:when test="${players.position eq 'TE'}">
                                                                        <td style="background-color: orange;"><a href="/player/detail/${players.id}">${players.name}</a><br />
                                                                            ${players.position}<br />
                                                                            ${players.team}<br />
                                                                            Bye: ${players.bye}</td>
                                                                    </c:when>
                                                                    <c:when test="${players.position eq 'QB'}">
                                                                        <td style="background-color: red;"><a href="/player/detail/${players.id}">${players.name}</a><br />
                                                                            ${players.position}<br />
                                                                            ${players.team}<br />
                                                                            Bye: ${players.bye}</td>
                                                                    </c:when>
                                                                    <c:when test="${players.position eq 'D/ST'}">
                                                                        <td style="background-color: brown;"><a href="/player/detail/${players.id}">${players.name}</a><br />
                                                                            ${players.position}<br />
                                                                            ${players.team}<br />
                                                                            Bye: ${players.bye}</td>
                                                                    </c:when>
                                                                    <c:when test="${players.position eq 'K'}">
                                                                        <td style="background-color: pink;"><a href="/player/detail/${players.id}">${players.name}</a><br />
                                                                            ${players.position}<br />
                                                                            ${players.team}<br />
                                                                            Bye: ${players.bye}</td>
                                                                    </c:when>
                                                                </c:choose>
                                    
                                                            </c:forEach>
                                                        </tr>
                                                        <tr class="row-normal">
                                                            <c:forEach begin="96" end="107" items="${teamPlayers}" var="players">
                                        
                                                                    <c:choose>
                                                                        <c:when test="${players.position eq 'RB'}">
                                                                            <td style="background-color: aqua;"><a href="/player/detail/${players.id}">${players.name}</a><br />
                                                                                ${players.position}<br />
                                                                                ${players.team}<br />
                                                                                Bye: ${players.bye}</td>
                                                                        </c:when>
                                                                        <c:when test="${players.position eq 'WR'}">
                                                                            <td style="background-color: green;"><a href="/player/detail/${players.id}">${players.name}</a><br />
                                                                                ${players.position}<br />
                                                                                ${players.team}<br />
                                                                                Bye: ${players.bye}</td>
                                                                        </c:when>
                                                                        <c:when test="${players.position eq 'TE'}">
                                                                            <td style="background-color: orange;"><a href="/player/detail/${players.id}">${players.name}</a><br />
                                                                                ${players.position}<br />
                                                                                ${players.team}<br />
                                                                                Bye: ${players.bye}</td>
                                                                        </c:when>
                                                                        <c:when test="${players.position eq 'QB'}">
                                                                            <td style="background-color: red;"><a href="/player/detail/${players.id}">${players.name}</a><br />
                                                                                ${players.position}<br />
                                                                                ${players.team}<br />
                                                                                Bye: ${players.bye}</td>
                                                                        </c:when>
                                                                        <c:when test="${players.position eq 'D/ST'}">
                                                                            <td style="background-color: brown;"><a href="/player/detail/${players.id}">${players.name}</a><br />
                                                                                ${players.position}<br />
                                                                                ${players.team}<br />
                                                                                Bye: ${players.bye}</td>
                                                                        </c:when>
                                                                        <c:when test="${players.position eq 'K'}">
                                                                            <td style="background-color: pink;"><a href="/player/detail/${players.id}">${players.name}</a><br />
                                                                                ${players.position}<br />
                                                                                ${players.team}<br />
                                                                                Bye: ${players.bye}</td>
                                                                        </c:when>
                                                                    </c:choose>
                                        
                                                                </c:forEach>
                                                            </tr>
                                                            <tr class="draft-row">
                                                                <c:forEach begin="108" end="119" items="${teamPlayers}" var="players">
                                            
                                                                        <c:choose>
                                                                            <c:when test="${players.position eq 'RB'}">
                                                                                <td style="background-color: aqua;"><a href="/player/detail/${players.id}">${players.name}</a><br />
                                                                                    ${players.position}<br />
                                                                                    ${players.team}<br />
                                                                                    Bye: ${players.bye}</td>
                                                                            </c:when>
                                                                            <c:when test="${players.position eq 'WR'}">
                                                                                <td style="background-color: green;"><a href="/player/detail/${players.id}">${players.name}</a><br />
                                                                                    ${players.position}<br />
                                                                                    ${players.team}<br />
                                                                                    Bye: ${players.bye}</td>
                                                                            </c:when>
                                                                            <c:when test="${players.position eq 'TE'}">
                                                                                <td style="background-color: orange;"><a href="/player/detail/${players.id}">${players.name}</a><br />
                                                                                    ${players.position}<br />
                                                                                    ${players.team}<br />
                                                                                    Bye: ${players.bye}</td>
                                                                            </c:when>
                                                                            <c:when test="${players.position eq 'QB'}">
                                                                                <td style="background-color: red;"><a href="/player/detail/${players.id}">${players.name}</a><br />
                                                                                    ${players.position}<br />
                                                                                    ${players.team}<br />
                                                                                    Bye: ${players.bye}</td>
                                                                            </c:when>
                                                                            <c:when test="${players.position eq 'D/ST'}">
                                                                                <td style="background-color: brown;"><a href="/player/detail/${players.id}">${players.name}</a><br />
                                                                                    ${players.position}<br />
                                                                                    ${players.team}<br />
                                                                                    Bye: ${players.bye}</td>
                                                                            </c:when>
                                                                            <c:when test="${players.position eq 'K'}">
                                                                                <td style="background-color: pink;"><a href="/player/detail/${players.id}">${players.name}</a><br />
                                                                                    ${players.position}<br />
                                                                                    ${players.team}<br />
                                                                                    Bye: ${players.bye}</td>
                                                                            </c:when>
                                                                        </c:choose>
                                            
                                                                    </c:forEach>
                                                                </tr>
                                                                <tr class="row-normal">
                                                                    <c:forEach begin="120" end="131" items="${teamPlayers}" var="players">
                                                
                                                                            <c:choose>
                                                                                <c:when test="${players.position eq 'RB'}">
                                                                                    <td style="background-color: aqua;"><a href="/player/detail/${players.id}">${players.name}</a><br />
                                                                                        ${players.position}<br />
                                                                                        ${players.team}<br />
                                                                                        Bye: ${players.bye}</td>
                                                                                </c:when>
                                                                                <c:when test="${players.position eq 'WR'}">
                                                                                    <td style="background-color: green;"><a href="/player/detail/${players.id}">${players.name}</a><br />
                                                                                        ${players.position}<br />
                                                                                        ${players.team}<br />
                                                                                        Bye: ${players.bye}</td>
                                                                                </c:when>
                                                                                <c:when test="${players.position eq 'TE'}">
                                                                                    <td style="background-color: orange;"><a href="/player/detail/${players.id}">${players.name}</a><br />
                                                                                        ${players.position}<br />
                                                                                        ${players.team}<br />
                                                                                        Bye: ${players.bye}</td>
                                                                                </c:when>
                                                                                <c:when test="${players.position eq 'QB'}">
                                                                                    <td style="background-color: red;"><a href="/player/detail/${players.id}">${players.name}</a><br />
                                                                                        ${players.position}<br />
                                                                                        ${players.team}<br />
                                                                                        Bye: ${players.bye}</td>
                                                                                </c:when>
                                                                                <c:when test="${players.position eq 'D/ST'}">
                                                                                    <td style="background-color: brown;"><a href="/player/detail/${players.id}">${players.name}</a><br />
                                                                                        ${players.position}<br />
                                                                                        ${players.team}<br />
                                                                                        Bye: ${players.bye}</td>
                                                                                </c:when>
                                                                                <c:when test="${players.position eq 'K'}">
                                                                                    <td style="background-color: pink;"><a href="/player/detail/${players.id}">${players.name}</a><br />
                                                                                        ${players.position}<br />
                                                                                        ${players.team}<br />
                                                                                        Bye: ${players.bye}</td>
                                                                                </c:when>
                                                                            </c:choose>
                                                
                                                                        </c:forEach>
                                                                    </tr>
                                                                    <tr class="draft-row">
                                                                        <c:forEach begin="132" end="143" items="${teamPlayers}" var="players">
                                                    
                                                                                <c:choose>
                                                                                    <c:when test="${players.position eq 'RB'}">
                                                                                        <td style="background-color: aqua;"><a href="/player/detail/${players.id}">${players.name}</a><br />
                                                                                            ${players.position}<br />
                                                                                            ${players.team}<br />
                                                                                            Bye: ${players.bye}</td>
                                                                                    </c:when>
                                                                                    <c:when test="${players.position eq 'WR'}">
                                                                                        <td style="background-color: green;"><a href="/player/detail/${players.id}">${players.name}</a><br />
                                                                                            ${players.position}<br />
                                                                                            ${players.team}<br />
                                                                                            Bye: ${players.bye}</td>
                                                                                    </c:when>
                                                                                    <c:when test="${players.position eq 'TE'}">
                                                                                        <td style="background-color: orange;"><a href="/player/detail/${players.id}">${players.name}</a><br />
                                                                                            ${players.position}<br />
                                                                                            ${players.team}<br />
                                                                                            Bye: ${players.bye}</td>
                                                                                    </c:when>
                                                                                    <c:when test="${players.position eq 'QB'}">
                                                                                        <td style="background-color: red;"><a href="/player/detail/${players.id}">${players.name}</a><br />
                                                                                            ${players.position}<br />
                                                                                            ${players.team}<br />
                                                                                            Bye: ${players.bye}</td>
                                                                                    </c:when>
                                                                                    <c:when test="${players.position eq 'D/ST'}">
                                                                                        <td style="background-color: brown;"><a href="/player/detail/${players.id}">${players.name}</a><br />
                                                                                            ${players.position}<br />
                                                                                            ${players.team}<br />
                                                                                            Bye: ${players.bye}</td>
                                                                                    </c:when>
                                                                                    <c:when test="${players.position eq 'K'}">
                                                                                        <td style="background-color: pink;"><a href="/player/detail/${players.id}">${players.name}</a><br />
                                                                                            ${players.position}<br />
                                                                                            ${players.team}<br />
                                                                                            Bye: ${players.bye}</td>
                                                                                    </c:when>
                                                                                </c:choose>
                                                    
                                                                            </c:forEach>
                                                                        </tr>
                                                                        <tr class="row-normal">
                                                                            <c:forEach begin="144" end="155" items="${teamPlayers}" var="players">
                                                        
                                                                                    <c:choose>
                                                                                        <c:when test="${players.position eq 'RB'}">
                                                                                            <td style="background-color: aqua;"><a href="/player/detail/${players.id}">${players.name}</a><br />
                                                                                                ${players.position}<br />
                                                                                                ${players.team}<br />
                                                                                                Bye: ${players.bye}</td>
                                                                                        </c:when>
                                                                                        <c:when test="${players.position eq 'WR'}">
                                                                                            <td style="background-color: green;"><a href="/player/detail/${players.id}">${players.name}</a><br />
                                                                                                ${players.position}<br />
                                                                                                ${players.team}<br />
                                                                                                Bye: ${players.bye}</td>
                                                                                        </c:when>
                                                                                        <c:when test="${players.position eq 'TE'}">
                                                                                            <td style="background-color: orange;"><a href="/player/detail/${players.id}">${players.name}</a><br />
                                                                                                ${players.position}<br />
                                                                                                ${players.team}<br />
                                                                                                Bye: ${players.bye}</td>
                                                                                        </c:when>
                                                                                        <c:when test="${players.position eq 'QB'}">
                                                                                            <td style="background-color: red;"><a href="/player/detail/${players.id}">${players.name}</a><br />
                                                                                                ${players.position}<br />
                                                                                                ${players.team}<br />
                                                                                                Bye: ${players.bye}</td>
                                                                                        </c:when>
                                                                                        <c:when test="${players.position eq 'D/ST'}">
                                                                                            <td style="background-color: brown;"><a href="/player/detail/${players.id}">${players.name}</a><br />
                                                                                                ${players.position}<br />
                                                                                                ${players.team}<br />
                                                                                                Bye: ${players.bye}</td>
                                                                                        </c:when>
                                                                                        <c:when test="${players.position eq 'K'}">
                                                                                            <td style="background-color: pink;"><a href="/player/detail/${players.id}">${players.name}</a><br />
                                                                                                ${players.position}<br />
                                                                                                ${players.team}<br />
                                                                                                Bye: ${players.bye}</td>
                                                                                        </c:when>
                                                                                    </c:choose>
                                                        
                                                                                </c:forEach>
                                                                            </tr>
                                                                            <tr class="draft-row">
                                                                                <c:forEach begin="156" end="167" items="${teamPlayers}" var="players">
                                                            
                                                                                        <c:choose>
                                                                                            <c:when test="${players.position eq 'RB'}">
                                                                                                <td style="background-color: aqua;"><a href="/player/detail/${players.id}">${players.name}</a><br />
                                                                                                    ${players.position}<br />
                                                                                                    ${players.team}<br />
                                                                                                    Bye: ${players.bye}</td>
                                                                                            </c:when>
                                                                                            <c:when test="${players.position eq 'WR'}">
                                                                                                <td style="background-color: green;"><a href="/player/detail/${players.id}">${players.name}</a><br />
                                                                                                    ${players.position}<br />
                                                                                                    ${players.team}<br />
                                                                                                    Bye: ${players.bye}</td>
                                                                                            </c:when>
                                                                                            <c:when test="${players.position eq 'TE'}">
                                                                                                <td style="background-color: orange;"><a href="/player/detail/${players.id}">${players.name}</a><br />
                                                                                                    ${players.position}<br />
                                                                                                    ${players.team}<br />
                                                                                                    Bye: ${players.bye}</td>
                                                                                            </c:when>
                                                                                            <c:when test="${players.position eq 'QB'}">
                                                                                                <td style="background-color: red;"><a href="/player/detail/${players.id}">${players.name}</a><br />
                                                                                                    ${players.position}<br />
                                                                                                    ${players.team}<br />
                                                                                                    Bye: ${players.bye}</td>
                                                                                            </c:when>
                                                                                            <c:when test="${players.position eq 'D/ST'}">
                                                                                                <td style="background-color: brown;"><a href="/player/detail/${players.id}">${players.name}</a><br />
                                                                                                    ${players.position}<br />
                                                                                                    ${players.team}<br />
                                                                                                    Bye: ${players.bye}</td>
                                                                                            </c:when>
                                                                                            <c:when test="${players.position eq 'K'}">
                                                                                                <td style="background-color: pink;"><a href="/player/detail/${players.id}">${players.name}</a><br />
                                                                                                    ${players.position}<br />
                                                                                                    ${players.team}<br />
                                                                                                    Bye: ${players.bye}</td>
                                                                                            </c:when>
                                                                                        </c:choose>
                                                            
                                                                                    </c:forEach>
                                                                                </tr>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    
                </tbody>
            </table>
            
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
    <script src="../../pub/js/draftboard.js"></script>

<jsp:include page="includes/footer.jsp" />