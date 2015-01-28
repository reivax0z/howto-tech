    <!-- Main jumbotron for a primary marketing message or call to action -->
    <div class="jumbotron">
      <div class="container">
        <h1>Search Engine</h1>
        <p>Results for: <b>$textSearched$</b></p>
      </div>
    </div>

    <div class="container">
      <!-- Example row of columns -->
      <div class="row">
            $matchedAdvice:{ advice |
            <div class="col-md-4">
                <h2>How to: $advice.title$</h2>
                <p>$advice.intro$</p>
                <p><a class="btn btn-default" href="/howto?id=$advice.id$" role="button">View details &raquo;</a></p>
            </div>
            }$
        </div>
    </div>