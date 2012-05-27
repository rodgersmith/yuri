/**
 * Created with IntelliJ IDEA.
 * User: rodsmith
 * Date: 5/26/12
 * Time: 9:34 PM
 * To change this template use File | Settings | File Templates.
 */
var tmpl_cache = {};
var TemplateManager = function(tmpl_name, tmpl_data) {

    if ( ! tmpl_cache[tmpl_name] ) {
        var tmpl_dir = '/templates';
        var tmpl_url = tmpl_dir + '/' + tmpl_name + '.html';

        var tmpl_string;
        $.ajax({
            url: tmpl_url,
            method: 'GET',
            async: false,
            success: function(data) {
                tmpl_string = data;
            }
        });

        tmpl_cache[tmpl_name] = _.template(tmpl_string);
    }

    return tmpl_cache[tmpl_name](tmpl_data);
};

