FROM nicolasbarbe/magnolia-base
COPY quickstart-webapp/target/quickstart-webapp*.war $CATALINA_BASE/webapps/ROOT.war