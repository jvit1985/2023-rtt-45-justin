<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <jsp:include page="../includes/header.jsp" />


    <main>
        <h1 class="text-center mt-3">${team.teamName}</h1>
        <div class="profile-picture text-center">
            <img src="${team.teamPicture}" alt="${team.teamName} Profile Picture" style="height: 20%; width: 20%;">
            <!-- "${team.teamPicture}" -->
        </div>
        <div class="mt-3 text-center">
            <a class="btn btn-primary" href="/team/edit/${team.id}">Edit Team</a>
        </div>
        <div class="mx-5 mt-3">
            <table class="table table-striped table-bordered">
                <thead>
                    <tr>
                        <th scope="col">Player Position</th>
                        <th scope="col">Player Name</th>
                        <th scope="col">Player Team</th>
                        <th scope="col">Player Bye Week</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${players}" var="player">
                        <tr>
                            <td>${player.position}</td>
                            <td><a href="/player/detail/${player.id}">${player.name}</a></td>
                            <td>${player.team}</td>
                            <td>${player.bye}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
        <div class="text-center view-teams-image">
            <img src="../../../pub/images/Updated football trophy.jpg" alt="Fantasy Football Trophy"
                style="height: 60%; width: 60%;">
        </div>
    </main>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/jquery-3.6.0.js"
        integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/select2@4.1.0-rc.0/dist/js/select2.min.js"></script>
    <script src="./assets/script.js"></script>

    <jsp:include page="../includes/footer.jsp" />