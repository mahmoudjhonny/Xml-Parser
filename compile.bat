java -cp javacc-7.0.12.jar jjtree -OUTPUT_DIRECTORY=src Parse_xml.jjt
pause

java -cp javacc-7.0.12.jar javacc -OUTPUT_DIRECTORY=src src\Parse_xml.jj
pause


javac -d classes src\*.java
pause