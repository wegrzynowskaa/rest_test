//inject angular file upload directive.
angular.module('myApp', ['ngFileUpload']);
var MyCtrl = [ '$scope', 'Upload', function($scope, Upload) {
    $scope.onFileSelect = function($files) {
        //$files: an array of files selected, each file has name, size, and type.
        for (var i = 0; i < $files.length; i++) {
            var $file = $files[i];
            Upload.upload({
                url: '/Users/wegrzynowskaa/dev',
                file: $file,
                progress: function(e){}
            }).then(function(data, status, headers, config) {
                // file is uploaded successfully
                console.log(data);
            });
        }
    }
}];