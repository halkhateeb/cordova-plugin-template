/**
 * Cordova Template Plugin
 */

var Template = (function () { 
    
    function Template() {
    }
    
    Template.prototype.echo = function (echoValue, successCallback) {
        cordova.exec(successCallback, function () { alert('Error') }, 'Template', 'echo', [echoValue]);
    };

    Template.prototype.tm = function (tmValue, successCallback) {
        cordova.exec(successCallback, function () { alert('Error') }, 'Template', 'tm', [tmValue]);
    };

    return Template;

})();

var template = new Template();
module.exports = template;
