/**
 * Created with IntelliJ IDEA.
 * User: rodsmith
 * Date: 4/21/12
 * Time: 3:21 PM
 * To change this template use File | Settings | File Templates.
 */
B2C.About = function(){
    this.mainTemplate = _.template('<h1>About 5DE</h1> \
<p>Some interesting things about Yuri here. <br>He is from Russia! <br>He drives a BMW <br>He likes planking</p>\
 \
');

}
B2C.About.prototype = new B2C.BaseView();

B2C.About.prototype.init = function($el){
    var self = this;
    self.toggleMenu("about");
    $el.html(self.mainTemplate({}));
}