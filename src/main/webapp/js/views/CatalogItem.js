/**
 * Created with IntelliJ IDEA.
 * User: rodsmith
 * Date: 4/26/12
 * Time: 9:36 PM
 * To change this template use File | Settings | File Templates.
 */
B2C.CatalogItem = function(catalogItem) {
    var mainTemplate = _.template(' <div id="context-here"></div> '),
        self = new B2C.BaseView(), onError;


    B2C.CatalogItem.prototype.init = function ($el) {

        self.toggleMenu("catalog");
        $el.html(mainTemplate({}));

        var onSuccess = function(data){
            var html = TemplateManager('CatalogItem', {data:data});
            $('#context-here').html(html);
            renderPieCharts();
        };

        B2CCore.get('controllers/catalog/getcatalogItem/' + catalogItem, onSuccess, null, onError)
    };


    onError = function(){
        alert(e);
        $("#context-here").html(e.reponseText);
    }

    renderPieCharts = function(){
        $.each($('.piechart'), function(index, item) {

            var data =[ ['Target Number', parseInt($(item).attr('data-participantTargetNumber'))], [ 'Locked In', parseInt($(item).attr('data-currentParticipantNumber'))] ];

            var plot1 = jQuery.jqplot (item.id, [data],
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


        });

    };




};
