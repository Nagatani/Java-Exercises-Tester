# Java-Exercises-Tester
課題で出したJavaのプログラムをコンパイルしてJUnitでテストする感じのやつ

# Work in Progress...

## need

1. junit-4.12.jar
2. hamcrest-core-1.3.jar

## memo

```bash
javac -cp "hamcrest-core-1.3.jar:junit-4.12.jar" *.java
$ java -cp ".:hamcrest-core-1.3.jar:junit-4.12.jar" org.junit.runner.JUnitCore TestUploadedFile
```
