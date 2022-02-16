package cg.zz.chapter01

// 执行java的Process功能

println "svn help".execute().text

println "svn help".execute().getClass().name

println "cmd /C dir".execute().text

println "go version".execute().text

println "groovy -version".execute().text