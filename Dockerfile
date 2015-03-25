FROM nicolasbarbe/magnolia-base

MAINTAINER Nicolas Barbé "https://github.com/nicolasbarbe"

COPY quickstart-webapp/target/*.war $CATALINA_BASE/webapps/ROOT.war