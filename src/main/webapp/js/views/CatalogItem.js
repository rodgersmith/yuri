/**
 * Created with IntelliJ IDEA.
 * User: rodsmith
 * Date: 4/26/12
 * Time: 9:36 PM
 * To change this template use File | Settings | File Templates.
 */
B2C.CatalogItem = function(catalogItem) {
    var self = this, onError, renderPieChart;


    self.render = function () {

        var onSuccess = function(data){
            var html = TemplateManager('CatalogItem', {data:data}), submitbtn;

            $('#catalogList-Here').html(html);
            renderPieChart();

        };

        B2CCore.get('controllers/catalog/getcatalogItem/' + catalogItem, onSuccess, null, onError)
    };


    onError = function(){
        alert(e);
        $("#context-here").html(e.reponseText);
    };

    renderPieChart = function(){

        var item = $('.piechart')[0];

        var data =[ ['Target Number', parseInt($(item).attr('data-participantTargetNumber'))], [ 'Locked In', parseInt($(item).attr('data-currentParticipantNumber'))] ];

        jQuery.jqplot (item.id, [data],
            {
                seriesColors: ["#6495ED","#00FF00"],
                seriesDefaults: {
                    // Make this a pie chart.
                    renderer: jQuery.jqplot.PieRenderer,
                    rendererOptions: {
                        // Put data labels on the pie slices.
                        // By default, labels show the percentage of the slice.
                        showDataLabels: true
                    }
                },
                legend: { show:false},
                grid:{  borderWidth: 0, shadow: false }

            }
        );
        $('#' + item.id).bind('jqplotDataHighlight', function(ev, seriesIndex, pointIndex, data) {
            var $this = $(this);

            $this.attr('title', data[0] + ": " + data[1]);
        });
        $('#' + item.id).bind('jqplotDataUnhighlight', function(ev, seriesIndex, pointIndex, data) {
            var $this = $(this);

            $this.attr('title', "");
        });




    };

    return self;


};
