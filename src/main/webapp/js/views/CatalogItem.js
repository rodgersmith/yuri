/**
 * Created with IntelliJ IDEA.
 * User: rodsmith
 * Date: 4/26/12
 * Time: 9:36 PM
 * To change this template use File | Settings | File Templates.
 */
B2C.CatalogItem = function(catalogItem) {
    this.mainTemplate = _.template(' <div id="context-here"></div> ');
    this.catalogItem = catalogItem;
};

B2C.CatalogItem.prototype = new B2C.BaseView();

B2C.CatalogItem.prototype.init = function ($el) {
    var self = this;
    self.toggleMenu("catalog");
    $el.html(self.mainTemplate({}));

    $.ajax({
        url: 'controllers/catalog/getcatalogItem/' + self.catalogItem,
        type: 'GET',
        contentType: "application/json; charset=utf-8",
        dataType: 'json',
        data: null,
        success: function(data){

            var html = TemplateManager('CatalogItem', {data:data});

            $('#context-here').html(html);

        },
        error: function(e){
            alert(e);
            $("#context-here").html(e.reponseText);
        }
    })








};
