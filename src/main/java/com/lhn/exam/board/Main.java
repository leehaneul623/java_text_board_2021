package com.lhn.exam.board;

/*
TODO
-[x] 환영메세지 출력
-[x] 고객으로 부터 명령어 입력 받기
 -[x] 스캐너 객체 하나 만들어보기
 -[x] 받은 명령어 출력하기
-[ ] exit 명령어 처리
 -[x] exit 입력 받으면 종료 라고 출력하기
 -[x] exit 입력 받을때 까지 계속 실행
-[ ] /usr/article/write 명령어 입력 처리
 -[x] 시작 문구 라도 출력
 -[x] 제목과 내용이라도 입력 받기
 -[x] 생성된 게시물 번호 출력
 -[x] 생성될때 마다 게시물 번호가 증가
 -[x] 생성된 게시물을 객체에 담기
 -[x] Article 객체 생성하기
 -[x] Article 클래스 생성하기
-[ ] /usr/article/detail 명령어 입력 처리
 -[x] 명령어를 제대로 입력했다면, 입력 받은 명령어 문구는 안나오도록
 -[x] toString 메서드 오버라이드 하기
 -[x] 생성자 도입
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        System.out.println("== 게시판 v 0.1 ==");
        System.out.println("== 프로그램 시작 ==");

        Scanner sc = new Scanner(System.in);

        int articlesLastId = 0;

        while (true){
            System.out.printf("명령) ");
            String cmd = sc.nextLine();

            if(cmd.equals("exit")){
               break;
            }
            else if(cmd.equals("/usr/article/write")){
                System.out.println("- 게시물 등록 -");
                System.out.printf("제목 : ");
                String title = sc.nextLine();
                System.out.printf("내용 : ");
                String body = sc.nextLine();
                int id = articlesLastId +1;
                articlesLastId = id;

                Article article = new Article(id, title, body);

                System.out.println(article);

                System.out.printf("%d번 게시물이 입력 되었습니다.\n", id);
            }
            else{
                System.out.printf("입력받은 명령어 : %s\n", cmd);
            }
        }

        sc.close();

        System.out.println("== 프로그램 종료 ==");
    }
}

class Article{
    int id;
    String title;
    String body;

    public Article(int id, String title, String body) {
        this.id = id;
        this.title = title;
        this.body = body;
    }

    @Override
    public String toString(){
        String title = this.title != null ? "\"" + this.title + "\"" : null;

        return String.format("{id: %d, title: %s, body: %s}", id, title, body);
    }
}