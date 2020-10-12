#!/bin/sh

gradle buildMainHttpStarter
gradle CopyRuntimeLibsFolderToBUILD

cd ./BUILD-OUTPUT
java -jar hello-vertx.jar-1.0.jar