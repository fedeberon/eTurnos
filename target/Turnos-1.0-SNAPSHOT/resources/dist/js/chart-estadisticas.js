/**
 * Created by Fede Beron on 30/6/2017.
 */

var colors = [];
colors.push(
    {
        fillColor : "rgba(95,137,250,0.5)",
        strokeColor : "rgba(95,137,250,0.9)",
        highlightFill: "rgba(95,137,250,0.75)",
        highlightStroke: "rgba(95,137,250,1)"
    });
colors.push(
    {
        fillColor : "rgba(245,75,75,0.5)",
        strokeColor : "rgba(245,75,75,0.8)",
        highlightFill : "rgba(245,75,75,0.75)",
        highlightStroke : "rgba(245,75,75,1)"
    });
colors.push(
    {
        fillColor : "rgba(98,223,114,0.5)",
        strokeColor : "rgba(98,223,114,0.8)",
        highlightFill : "rgba(98,223,114,0.75)",
        highlightStroke : "rgba(98,223,114,1)",
    });

function generateLabelsFromTable(){
    var labels = [];
    var rows = $("tr");
    rows.each(function(index){
        if (index != 0) {
            var cols = $(this).find("td");
            cols.each(function(innerIndex){
                if (innerIndex == 0)  labels.push(cols.first().text());

            });
        }
    });
    return labels;
}


function generateDataSetsFromTableSocio() {
    var data = [];
    var rows = jQuery("tr");
    rows.each(function(index){
        if (index != 0) {
            var cols = $(this).find("td:eq(1)");
            cols.each(function(innerIndex){
                data.push($(this).text());
            });
        }
    });
    return data;
}

function generateDataSetsFromTableNoSocio() {
    var data = [];
    var rows = jQuery("tr");
    rows.each(function(index){
        if (index != 0 ) {
            var cols = $(this).find("td:eq(2)");
            cols.each(function(innerIndex){
                data.push($(this).text());
            });
        }
    });
    return data;
}

var areaChartData = {
    labels: generateLabelsFromTable(),//["Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio"],
    datasets:
        [
            {
                label: "Socios",
                fillColor: "rgba(210, 214, 222, 1)",
                strokeColor: "rgba(210, 214, 222, 1)",
                pointColor: "rgba(210, 214, 222, 1)",
                pointStrokeColor: "#c1c7d1",
                pointHighlightFill: "#fff",
                pointHighlightStroke: "rgba(220,220,220,1)",
                data: generateDataSetsFromTableSocio()
            },
            {
                label: "No Socios",
                fillColor: "rgba(60,141,188,0.9)",
                strokeColor: "rgba(60,141,188,0.8)",
                pointColor: "#3b8bba",
                pointStrokeColor: "rgba(60,141,188,1)",
                pointHighlightFill: "#fff",
                pointHighlightStroke: "rgba(60,141,188,1)",
                data: generateDataSetsFromTableNoSocio()
            }
        ]
};

$(function () {
    var barChartCanvas = $("#canvas_bar").get(0).getContext("2d");
    var barChart = new Chart(barChartCanvas);
    var barChartData = areaChartData;
    barChartData.datasets[1].fillColor = "#00a65a";
    barChartData.datasets[1].strokeColor = "#00a65a";
    barChartData.datasets[1].pointColor = "#00a65a";
    var barChartOptions = {
            //Boolean - Whether the scale should start at zero, or an order of magnitude down from the lowest value
            scaleBeginAtZero: true,
            //Boolean - Whether grid lines are shown across the chart
            scaleShowGridLines: true,
            //String - Colour of the grid lines
            scaleGridLineColor: "rgba(0,0,0,.05)",
            //Number - Width of the grid lines
            scaleGridLineWidth: 1,
            //Boolean - Whether to show horizontal lines (except X axis)
            scaleShowHorizontalLines: true,
            //Boolean - Whether to show vertical lines (except Y axis)
            scaleShowVerticalLines: true,
            //Boolean - If there is a stroke on each bar
            barShowStroke: true,
            //Number - Pixel width of the bar stroke
            barStrokeWidth: 2,
            //Number - Spacing between each of the X value sets
            barValueSpacing: 5,
            //Number - Spacing between data sets within X values
            barDatasetSpacing: 1,
        //String - A legend template
    //Boolean - whether to make the chart responsive
    responsive: true,
        maintainAspectRatio: true
};

    barChartOptions.datasetFill = false;
    barChart.Bar(barChartData, barChartOptions);

});
