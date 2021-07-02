'use strict';

var gulp = require('gulp');
var liferayThemeTasks = require('liferay-theme-tasks');
var del = require('del');
var runSequence = require('run-sequence').use(gulp);

liferayThemeTasks.registerTasks({
  gulp: gulp,
  hookFn: function(gulp) {

        gulp.hook('after:build:move-compiled-css', function(done) {
            runSequence('remove-maps', 'remove-js-maps', done);
        })
  }
});

gulp.task('remove-maps', cb => {
	del('./build/css/*.map').then(() => cb());
});

gulp.task('remove-js-maps', cb => {
	del('./build/js/*.map').then(() => cb());
});