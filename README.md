# Triangle challenge #

Write a program that will determine the type of a triangle. It should take
the lengths of the triangle's three sides as input, and return whether the
triangle is equilateral, isosceles or scalene.

## Run tests and code coverage report ##
gradle test && gradle jacocoTestReport && ls -la build/jacocoHtml/index.html

## Build fat JAR and run the app ##
gradle fatJar && java -jar build/libs/TriangleEnterpriseEdition-all.jar 3 4 5
