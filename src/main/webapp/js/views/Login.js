/**
 * Created with IntelliJ IDEA.
 * User: rodsmith
 * Date: 5/2/12
 * Time: 8:44 PM
 * To change this template use File | Settings | File Templates.
 */
B2C.Login = function() {

};

B2C.Login.prototype = new B2C.BaseView();

B2C.Login.prototype.init = function ($el) {
    var self = this;
    self.toggleMenu("login");


    var html = TemplateManager('login', {});

    $el.html(html);


}