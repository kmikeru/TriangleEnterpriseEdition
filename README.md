gradle test && gradle jacocoTestReport && ls -la build/jacocoHtml/index.html

gradle fatJar && java -jar build/libs/TriangleEnterpriseEdition-all.jar 3 4 5