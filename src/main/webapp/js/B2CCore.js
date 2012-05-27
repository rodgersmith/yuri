B2CCore = (function() {
    var self = {}, ajax;

    self.post = function (url, success, options, errfn) {
        var o = options || {};
        o.verb = 'POST';
        ajax(url, success, o, errfn);
    };

    self.get = function (url, success, options, errfn) {
        var o = options || {};
        o.verb = 'GET';
        ajax(url, success, o, errfn);
    };

    ajax = function(url, success, options, errorfn){
        url = url || "";
        url = url.charAt(0) === "/" ? url.substr(1) : url;

        $.ajax({
            url: url,
            type:options.verb,
            contentType: "application/json; charset=utf-8",
            dataType: 'json',
            data: null,
            success: success,
            errorfunc:errorfn
        });
    };

    return self;
}) ();

FormatCurrency = function (num) {
        num = num.toString().replace(/\$|\,/g, '');
        if (isNaN(num)) num = "0";
        sign = (num == (num = Math.abs(num)));
        num = Math.floor(num * 100 + 0.50000000001);
        cents = num % 100;
        num = Math.floor(num / 100).toString();
        if (cents < 10) cents = "0" + cents;
        for (var i = 0; i < Math.floor((num.length - (1 + i)) / 3); i++)
            num = num.substring(0, num.length - (4 * i + 3)) + ',' + num.substring(num.length - (4 * i + 3));
        return (((sign) ? '' : '-') + '$' + num + '.' + cents);
};










