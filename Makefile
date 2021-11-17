assert = $(if $2,$(if $1,,$(error $2)))

ifeq (run,$(firstword $(MAKECMDGOALS)))
  # use the rest as arguments for "run"
  RUN_ARGS := $(wordlist 2,$(words $(MAKECMDGOALS)),$(MAKECMDGOALS))
  # ...and turn them into do-nothing targets
  $(eval $(RUN_ARGS):dummy;@:)
endif


JUnit.ver  = 1.8.1
JUnit.jar  = junit-platform-console-standalone-$(JUnit.ver).jar
Maven.http = https://repo1.maven.org/maven2/org/junit/platform/junit-platform-console-standalone
JUnit.mvn  = $(Maven.http)/$(JUnit.ver)/$(JUnit.jar)

all: check-variable test

check-variable:
	$(call assert,$(JAVA_HOME),JAVA_HOME is not defined)

dirs:
	-mkdir -p target
	-mkdir -p lib

compile-java: dirs
	$(JAVA_HOME)/bin/javac -d target/classes src/main/*.java

junit-download:
	curl -s -z lib/$(JUnit.jar) \
          -o lib/$(JUnit.jar) \
          $(JUnit.mvn)

compile-test: compile-java junit-download
	$(JAVA_HOME)/bin/javac -d target/test-classes \
          -cp lib/$(JUnit.jar):target/classes \
          src/test/*.java

test: compile-test
	$(JAVA_HOME)/bin/java -jar lib/$(JUnit.jar) \
           --class-path target/classes:target/test-classes \
           --scan-class-path

run:
	$(JAVA_HOME)/bin/java -cp target/classes main.MarsRovers $(RUN_ARGS)

clean:
	-rm -rf lib
	-rm -rf target

.PHONY: dummy