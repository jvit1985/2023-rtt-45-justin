<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <jsp:include page="../includes/header.jsp" />

    <section class="py-5 bg-dark-grey">
        <div class="container text-center">
            <h1>Player Search</h1>
        </div>
    </section>

    <section class="my-5">
        <div class="container">
            <div class="row text-center justify-content-center">
                <div class="col-7">
                    <form>
                        <div class="input-group mb-3">
                            <input type="text" class="form-control" name="playerSearch" placeholder="Player Name"
                                aria-label="Player Name" aria-describedby="playerSearch" value="${playerSearchParam}">

                            <button class="btn btn-primary" id="search">Search</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </section>

    <section class="py-5">
        <div class="container text-center">

            <h4 class="pb-2">${playerList.size()} Search Results</h4>

            <table class="table table-striped border">
                <thead>
                    <tr>
                        <th scope="col">Player Id</th>
                        <th scope="col">Player Name</th>
                        <th scope="col">Player Position</th>
                        <th scope="col">Player Team</th>
                        <th scope="col">Player Bye</th>
                        <th scope="col">Edit</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${playerList}" var="player">
                        <tr>
                            <td><a href="/player/detail/${player.id}">${player.id}</a></td>
                            <td>${player.name}</td>
                            <td>${player.position}</td>
                            <td>${player.team}</td>
                            <td>${player.bye}</td>
                            <td><a href="/player/edit/${player.id}">Edit</a></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </section>

    <jsp:include page="../includes/footer.jsp" />