/**
 * Created with IntelliJ IDEA.
 * User: rodsmith
 * Date: 4/21/12
 * Time: 3:27 PM
 * To change this template use File | Settings | File Templates.
 */
B2C.Home = function() {

};

B2C.Home.prototype = new B2C.BaseView();

B2C.Home.prototype.init = function ($el) {
    var self = this;
    self.toggleMenu("home");

    var html = TemplateManager('Home');
    $el.html(html);




};