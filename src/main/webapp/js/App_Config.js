/**
 * Created by IntelliJ IDEA.
 * User: totia
 * Date: 4/2/12
 * Time: 4:08 PM
 * To change this template use File | Settings | File Templates.
 */
//namespace
B2C = {};

$(function () {

    B2C.clearAlerts = function() {
        $("alerts-here").html('');
    };

    var $el = $("#main-here");

    B2C.B2CController = Backbone.Router.extend({
        routes: {
            "": "index",
            "about": "about",
            "catalog": "catalog",
            "catalogItem/:itemId" : "catalogItem",
            "dashboard" : "dashboard",
            "vendorportal": "vendorportal",
            "login": "login"
        },

        index: function(){
            B2C.clearAlerts();
            new B2C.Home().init($el);
        },

        about: function(){
            B2C.clearAlerts();
            new B2C.About().init($el);
        },

        catalog: function(){
            B2C.clearAlerts();
            new B2C.Catalog().init($el);
        },

        catalogItem: function(itemId){
            B2C.clearAlerts();
            new B2C.CatalogItem(itemId).init($el);
        },

        dashboard: function(){
            B2C.clearAlerts();
            new B2C.Dashboard().init($el);
        },

        vendorportal: function(){
            B2C.clearAlerts();
            new B2C.Vendorportal().init($el);
        },

        login: function(){
            B2C.clearAlerts();
            new B2C.Login().init($el);
        }

    });

    new B2C.B2CController();
    Backbone.history.start();
});
