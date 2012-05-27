(function ($) {
    $.fn.ellipsis = function () {
        return this.each(function () {
            var el = $(this);

            if (el.css("overflow") == "hidden") {
                var text = el.html();
                var multiline = el.hasClass('multiline');
                var t = $(this.cloneNode(true))
                                        .hide()
                                        .css('position', 'absolute')
                                        .css('overflow', 'visible')
                                        .width(multiline ? el.width() : 'auto')
                                        .height(multiline ? 'auto' : el.height())
                                        ;

                el.after(t);

                var w = el.width;
                var str = el.attr("style");
                if (str) {
                    el.width = function () {
                        var begin = str.indexOf("width:") + 6;
                        if (begin > 5) {
                            var end = str.indexOf(";", begin)
                            if (end === -1) { end = str.length; }
                            return parseInt(str.substring(begin, end));
                        } else {
                            return w();
                        }
                    }
                }
                function height() { return t.height() > el.height(); };
                function width() { return t.width() > el.width(); };

                var func = multiline ? height : width;

                while (text.length > 0 && func()) {
                    text = text.substr(0, text.length - 1);
                    t.html(text + "...");
                }

                el.html(t.html());
                t.remove();
            }
        });
    };
})(jQuery);
