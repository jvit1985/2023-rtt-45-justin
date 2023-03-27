
<jsp:include page="include/header.jsp" />

<style>

.page-header {
    margin-left:40px;
    margin-top:30px;
    color: rgb(61, 243, 61);
}

h1 {
    border: 1px solid;
}

    a:visited {
        color:purple;
    }

    a:hover {
    color:orange;
    }

    #firsth1 {
        text-decoration: underline;
    }

    .absolute-example {
        width: 200px;
        height: 400px;
        background-color: chartreuse;
        position: absolute;
    }

    .circle {
        width: 30px;
        height: 30px;
        background-color: blue;
        border-radius: 15px;
        color: aliceblue;
        align-content: center;
        text-align: center;
    }

</style>

<h1 id="firsth1" class = "page-header" style="color:red;">This is a page title</h1>
    <h2 class = "page-header" style="background-color: grey;">This is another page title</h2>
        <h1 class = "page-header">This is a second h1</h1>

    <br>
    <p><a href="#">This is a link</a></p>
    <p><a href="/asdf">This is not visited</a></p>
    <br>

    <div class="circle">1</div>

    <div class="container" style="padding-top:20px">
    <table class="table table-striped table-hover table-bordered">
        <thead>
          <tr>
            <th scope="col">#</th>
            <th scope="col">First</th>
            <th scope="col">Last</th>
            <th scope="col">Handle</th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <th scope="row">1</th>
            <td>Mark</td>
            <td>Otto</td>
            <td>@mdo</td>
          </tr>
          <tr>
            <th scope="row">2</th>
            <td>Jacob</td>
            <td>Thornton</td>
            <td>@fat</td>
          </tr>
          <tr>
            <th scope="row">3</th>
            <td colspan="2">Larry the Bird</td>
            <td>@twitter</td>
          </tr>
        </tbody>
      </table>

      <button type="button" class="btn btn-primary btn-sm">Save</button>
      <button type="button" class="btn btn-secondary btn-sm">Cancel</button>
    </div>

<jsp:include page="include/footer.jsp" />