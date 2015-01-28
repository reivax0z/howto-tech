    <!-- Main jumbotron for a primary marketing message or call to action -->
    <div class="jumbotron">
      <div class="container">
        <h1>How to: $advice.title$</h1>
        <p>$advice.intro$</p>
      </div>
    </div>

    <div class="container">
      <!-- Example row of columns -->
      <div class="row">
            $advice.steps:{ step |
            <div class="col-md-6" id="step$step.number$">
                <h2>Step $step.number$</h2>
                <h4>$step.intro$</h4>
                <p>$step.content$</p>
                $if(step.pictureLink)$
                    <p><img src="$step.pictureLink$" class="img-responsive img-rounded" /></p>
                $endif$
            </div>
            }$
        </div>
    </div>