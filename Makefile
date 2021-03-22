clj_cmd = env clj

.PHONY: build
build:
	mkdir -p target
	$(clj_cmd) -X:depstar uberjar :jar target/tla-typeof.jar :sync-pom true :exclude '["util/.*" "tla2tex/.*" "tla2sany/.*" "com/.*" "javax/.*" "org/jline/.*" "pcal/.*"]'

.PHONY: deploy
deploy:
	mvn deploy:deploy-file -Dfile=target/tla-typeof.jar -DpomFile=pom.xml -DrepositoryId=clojars -Durl=https://clojars.org/repo/
