package study.java8action.chapter3.executearoundpattern;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileProcessor {

    //1. try with resource로 파일 처리(기본)
    // - 파일과 같이 close해줘야 하는 코드는 try-catch가 아닌 try-with-resource 패턴으로 해주는게 좋음
    // - 정리하면 우리는 다음과 같은 이유로 반드시 try-catch-finally가 아닌 try-with-resources를 사용해주어야 한다.
    //코드를 간결하게 만들 수 있음
    //번거로운 자원 반납 작업을 하지 않아도 됨
    //실수로 자원을 반납하지 못하는 경우를 방지할 수 있음
    //에러로 자원을 반납하지 못하는 경우를 방지할 수 있음
    //모든 에러에 대한 스택 트레이스를 남길 수 있음
    //출처: https://mangkyu.tistory.com/217 [MangKyu's Diary:티스토리]
    public static String processFile(String filePath) throws IOException {
        try(BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            return br.readLine(); //동작, 그러나 동작이 달라지면 매번 동작 구현 및 실행어라운트패턴(자원준비 및 정리)을 해줘야 함
        }
    }

    //2. 실행어라운트패턴의 동작만 받아서 처리할 수 있음
    public static String processFileByLambda(String filePath, BufferedReaderProcessor p) throws IOException {
        try(BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            return p.process(br); //전달받은 동작 처리
        }
    }
}
