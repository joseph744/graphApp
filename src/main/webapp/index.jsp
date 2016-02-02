<!DOCTYPE html>
<html>
<head>
  <title>Getting Started Example</title>
  <!--Load the AJAX API-->
  <script type="text/javascript" src="http://www.google.com/jsapi"></script>
  <script type="text/javascript">

  //Load the Visualization API and the ready-made Google table visualization
  google.load('visualization', '1', {'packages':['table']});

  // Set a callback to run when the API is loaded.
  google.setOnLoadCallback(init);

  // Send the query to the data source.
  function init() {

    // Specify the data source URL.
    var query = new google.visualization.Query('simpleexample');

    // Send the query with a callback function.
    query.send(handleQueryResponse);
  }

  // Handle the query response.
  function handleQueryResponse(response) {
    if (response.isError()) {
      alert('Error in query: ' + response.getMessage() + ' ' + response.getDetailedMessage());
      return;
    }

    // Draw the visualization.
    var data = response.getDataTable();
    var chart = new google.visualization.Table(document.getElementById('chart_div'));
    chart.draw(data, {width: 600, height: 150, is3D: true});
  }
  </script>
</head>
<body>
  <h1>Hello! Data Source!</h1>
  A table chart that shows data taken from the simple data source.
  <!--Div that will hold the visualization-->
  <div id="chart_div"></div>
</body>
</html>
