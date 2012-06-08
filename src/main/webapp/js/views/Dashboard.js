/**
 * Created with IntelliJ IDEA.
 * User: rodsmith
 * Date: 5/28/12
 * Time: 11:32 AM
 * To change this template use File | Settings | File Templates.
 */

B2C.Dashboard = function(customerId, sortType, itemId){
    var self = new B2C.BaseView(),
        getDashboardInventory, renderPieCharts, wireUpEvents, inventoryList, renderList, el, sortDashboardInventory;



    B2C.Dashboard.prototype.init = function($el) {
        self.toggleMenu("dashboard");
        el = $el;

        var mainTemplate = TemplateManager('Dashboard');
        el.html(mainTemplate);

        getDashboardInventory(customerId);


        $('.dropdown-toggle').dropdown();
        $('.dropdown-menu a').live('click',function() {
            var that = $(this).text();
            $("#dashboardItem-sort-title").text(that);
            sortDashboardInventory(that);

        });
    };



    sortDashboardInventory = function(sort){
         var list = [];

         switch (sort){
             case "Alphabetically":
                 list = _.sortBy(inventoryList, function(item){
                    return item.name;
                 });
                 break;
             case "Current-to-Target Ratio":
                 list = _.sortBy(inventoryList, function(item){
                     return (item.currentParticipantNumber / item.participantTargetNumber) * 100;
                 });

                 break;
             case "Days Remaining On Offer":
                 list = _.sortBy(inventoryList, function(item){
                     return item.daysRemainingOnOffer;
                 });
                 list.reverse();
                 break;

         }
         ee.emit("dashboardSort", sort);
         renderList(list);
    };

    getDashboardInventory = function(id) {

        var onSuccess = function(data){
            inventoryList = data.products;
            if (sortType){
                $("#dashboardItem-sort-title").text(sortType);
                sortDashboardInventory(sortType);
            } else{
                renderList(inventoryList);
            }
        };

        B2CCore.get('controllers/dashboard/getInventoryByCustomer/' + id,  onSuccess, null, onError);
    };

    renderList = function(list){
        var template = TemplateManager('DashboardList', {list: list}), selectedItem;
        $("#dashboardList-Here").html(template);
        renderPieCharts();
        wireUpEvents();

        if (itemId){
            selectedItem = $("#thumbnail-" + itemId);
            selectedItem = selectedItem.children()[0];
            $("#dashboardList-Here>ul>li>div.selected").removeClass("selected");
            $(selectedItem).addClass("selected");

            var view = B2C.DashboardItem(itemId);
            view.render();
        }
    };

    wireUpEvents = function(){

        $(".thumbnail").click(function(){
            var index, selectedItem;
            selectedItem = $(this).closest('li');
            id = selectedItem.attr("id");
            index = id.indexOf("-");
            id = id.substr(index + 1);


            window.location = "#dashboardItem/" + id;
        });

        $(".label").tooltip();

    };

    onError = function(e){
        alert(e);
        $("#context-here").html(e.reponseText);
    };

    renderPieCharts = function(){
        $.each($('.piechart'), function(index, item) {

            var data =[ ['Remaining Orders', parseInt($(item).attr('data-participantTargetDiff'))], [ 'Locked In', parseInt($(item).attr('data-currentParticipantNumber'))] ];

            var plot1 = jQuery.jqplot (item.id, [data],
                {
                    seriesColors: ["#6495ED","#00FF00"],
                    seriesDefaults: {
                        // Make this a pie chart.
                        renderer: jQuery.jqplot.PieRenderer,
                        rendererOptions: {
                            // Put data labels on the pie slices.
                            // By default, labels show the percentage of the slice.
                            showDataLabels: true,
                            padding: 10
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

    getThumbnailLabelClass = function( item ){

        if (item.daysRemainingOnOffer === 0){
            return "label-info";
        }
        if (item.participantTargetDiff === 0){
            return "label-success";
        }
        return "label-warning"
    }

};
