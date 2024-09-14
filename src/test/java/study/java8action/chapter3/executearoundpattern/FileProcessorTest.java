package study.java8action.chapter3.executearoundpattern;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;

class FileProcessorTest {

    String testFile = "/Users/hunpa/IdeaProjects/java8action_gradle/src/main/resources/test.txt";

    @Test
    public void testFileProcessor() throws IOException {
        FileProcessor fileProcessor = new FileProcessor();
        String result = FileProcessor.processFile(
                testFile);
        System.out.println(result);
    }

    //2. 실행어라운드패턴의 동작을 람다로 전달
    @Test
    public void testProcessFileByLambda() throws IOException {
        FileProcessor fileProcessor = new FileProcessor();
        String result = FileProcessor.processFileByLambda(
                testFile,
                (BufferedReader br) -> br.readLine() + br.readLine()); //동작
        System.out.println(result);
    }

}