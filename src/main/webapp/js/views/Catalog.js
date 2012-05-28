/**
 * Created with IntelliJ IDEA.
 * User: rodsmith
 * Date: 4/26/12
 * Time: 9:36 PM
 * To change this template use File | Settings | File Templates.
 */
B2C.Catalog = function(itemType, itemId) {
    var self = new B2C.BaseView(),
    getCatalog, getCatalogItemTypes, renderPieCharts, items, addEvents, onError;

    B2C.Catalog.prototype.init = function ($el) {
        self.toggleMenu("catalog");
        getCatalogItemTypes($el);

    };

    addEvents = function() {

        $("#navlist a").live("click", function(){

            var that = this;
            $("#navlist li").removeClass("active");
            $(that).parent().addClass("active");
            var itemType = $(that).attr("id");
            getCatalog(itemType);

            return false;
        });

        $('#itemSearch').autocomplete({
            source: function (request, response){
                var concepts = [], to;
                clearTimeout(to);
                to = setTimeout(function () { // new timeOut set
                    if ($.trim(request.term).length >= 3) {
                        var onSuccess = function(data){
                            concepts = convertJsonDataToNativeArray(data);
                            response(concepts);
                        };
                        B2CCore.get('controllers/catalog/searchcatalog/' + request.term, onSuccess, null, onError);
                    }
                }, 500);

            },
            select : function(event, ui) {
                if (!ui.item.isOnCurrentDashboard){
                    window.location = "#catalogItem/" + ui.item.value;
                }
            },
            focus : function() {
                return false;
            }
        });

    };



    getCatalog = function(type){

        var onSuccess = function(data){

            $('#' + itemType).parent('li').addClass("active");

            ee.emit("catalogTypeChosen", type);

            var html = TemplateManager('CatalogList', {data:data.products});

            $('#catalogList-Here').html(html);

            renderPieCharts();

            $('.catalogLink').live('click', function(){
                var that = this;
                window.location = "#catalogItem/" + that.id;
                return false;
            })
        };


        B2CCore.get('controllers/catalog/getcatalog/' + type,  onSuccess, null, onError);
    };


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

    onError = function(e){
        alert(e);
        $("#context-here").html(e.reponseText);
    };

    getCatalogItemTypes = function ($el){
        var success = function(list){
            var mainTemplate = TemplateManager('Catalog', {list: list});
            $el.html(mainTemplate);
            addEvents();
            if (itemId){
                var view = B2C.CatalogItem(itemId);
                view.render();
                $('#' + itemType).parent('li').addClass("active");
            } else {
                if (itemType){
                    getCatalog(itemType);
                }
            }

        };
        B2CCore.get('controllers/catalog/getcatalogitemtypes', success, null, onError);
    };

    var convertJsonDataToNativeArray = function(data){
        var array = [], count;

        if (data != null && data.length > 0){
            for (count = 0; count < data.length; count++){
                array.push( {label:data[count].name, value:data[count].id, isOnCurrentDashboard:data[count].isOnCurrentDashboard});
            }
        }

        return array;
    }
}