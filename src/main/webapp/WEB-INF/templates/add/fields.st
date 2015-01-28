    <!-- Main jumbotron for a primary marketing message or call to action -->
    <div class="jumbotron">
      <div class="container">
        <h1>Add a new Tip</h1>
        <p>Fill in the fields below to add a new entry into the database.</p>
      </div>
    </div>

    <div class="container">
        <form action="/add" method="POST">
          <div class="form-group">
            <label for="exampleInputTitle">Title</label>
            <input name="title" type="text" class="form-control" id="exampleInputTitle" placeholder="Enter title">
          </div>
          <div class="form-group">
            <label for="exampleInputIntro">Intro</label>
            <textarea name="intro" class="form-control" rows="3" placeholder="Enter intro"></textarea>
          </div>
          <button type="submit" class="btn btn-default">Submit</button>
        </form>
    </div>