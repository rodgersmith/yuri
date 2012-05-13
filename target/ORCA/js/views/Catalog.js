/**
 * Created with IntelliJ IDEA.
 * User: rodsmith
 * Date: 4/26/12
 * Time: 9:36 PM
 * To change this template use File | Settings | File Templates.
 */
B2C.Catalog = function() {
    this.mainTemplate = _.template(' <h2>Browse our vendor catalog of items that have already been negotiated for a group savings price</h1><br> <div id="context-here"></div> ');

};

B2C.Catalog.prototype = new B2C.BaseView();

B2C.Catalog.prototype.init = function ($el) {
    var self = this;
    self.toggleMenu("catalog");

    $el.html(self.mainTemplate({}));


    $.ajax({
        url: 'controllers/catalog/getcatalog',
        type: 'GET',
        contentType: "application/json; charset=utf-8",
        dataType: 'json',
        data: null,
        success: function(data){

            var html = TemplateManager('Catalog', {data:data.products});

            $('#context-here').html(html);

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

    $("#catalogNavlist").click(function(){
        alert("hi");
    });

};
