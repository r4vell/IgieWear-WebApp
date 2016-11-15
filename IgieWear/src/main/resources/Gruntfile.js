module.exports = function(grunt) {

  // Project configuration.
  grunt.initConfig({
    pkg: grunt.file.readJSON('package.json'),

    copy : {
      main : {
        files : [
        {flatten: true, src: "packages/angular/angular.min.js", dest: "static/js/angular.min.js", filter: "isFile"},
        {flatten: true, src: "packages/jquery/dist/jquery.min.js", dest: "static/js/jquery.min.js", filter: "isFile"},
        {expand: true, cwd: "packages/materialize/dist/", src: "**", dest: "static/css/materialize/"}
        ]
      },
    },

  });

  grunt.loadNpmTasks('grunt-contrib-copy');

}