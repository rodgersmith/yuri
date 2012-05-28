/**
 * Created with IntelliJ IDEA.
 * User: rodsmith
 * Date: 4/21/12
 * Time: 3:23 PM
 * To change this template use File | Settings | File Templates.
 */
B2C.BaseView = function(){};

B2C.BaseView.prototype.toggleMenu = function (menu) {
    $(".nav li").removeClass("active");
    $("." + menu).toggleClass("active", true);
};


