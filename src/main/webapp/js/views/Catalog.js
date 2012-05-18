/**
 * Created with IntelliJ IDEA.
 * User: rodsmith
 * Date: 4/26/12
 * Time: 9:36 PM
 * To change this template use File | Settings | File Templates.
 */
B2C.Catalog = function() {

};

B2C.Catalog.prototype = new B2C.BaseView();

B2C.Catalog.prototype.init = function ($el) {
    var self = this, getCatalog, getCatalogItemTypes;
    self.toggleMenu("catalog");

    $("#navlist a").live("click", function(){

        var that = this;
        $("#navlist li").removeClass("active");
        $(that).parent().addClass("active");
        var itemType = $(that).attr("id");
        getCatalog(itemType);

       return false;
    });



    getCatalog = function(type){

        $.ajax({
            url: 'controllers/catalog/getcatalog/' + type,
            type: 'GET',
            contentType: "application/json; charset=utf-8",
            dataType: 'json',
            data: null,
            success: function(data){

                var html = TemplateManager('CatalogList', {data:data.products});

                $('#catalogList-Here').html(html);

                $('.catalogLink').live('click', function(){
                    var that = this;

                    window.location = "#catalogItem/" + that.id;
                    return false;
                })



            },
            error: function(e){
                alert(e);
                $("#context-here").html(e.reponseText);
            }
        });
    };



    getCatalogItemTypes = function (){
        $.ajax({
            url: 'controllers/catalog/getcatalogitemtypes',
            type: 'GET',
            contentType: "application/json; charset=utf-8",
            dataType: 'json',
            data: null,
            success: function(list){

                var mainTemplate = TemplateManager('Catalog', {list: list});

                $el.html(mainTemplate);

                getCatalog('Gloves');

            },
            error: function(e){
                alert(e);
                $("#context-here").html(e.reponseText);
            }
        });
    };

    getCatalogItemTypes();

};
