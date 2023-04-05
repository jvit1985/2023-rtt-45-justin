<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="../includes/header.jsp" />

<style>
        table {
            background-image: url("pub/images/Updated\ football\ trophy.jpg");
            background-repeat: repeat;
            background-size: contain;
            opacity: .8;
        }

        td {
            color: black;
        }
    </style>

<main>
        <h1 class="text-center mt-3">{team.teamName}</h1>
        <div class="profile-picture text-center">
            <img src="pub/images/profileImage.png" alt="Team${team.id} Profile Picture" style="height: 20%; width: 20%;">
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
              <c:forEach items="${teamPlayers}" var="player">
                <tr>
                    <td>{player.position}</td>
                    <td>{player.name}</td>
                    <td>{player.team}</td>
                    <td>{player.bye}</td>
                </tr>
              </c:forEach>
            </tbody>
        </table>
        </div>
    </main>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/select2@4.1.0-rc.0/dist/js/select2.min.js"></script>
    <script src="./assets/script.js"></script>

<jsp:include page="../includes/footer.jsp" />