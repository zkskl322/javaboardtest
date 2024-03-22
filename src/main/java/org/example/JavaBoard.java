package org.example;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;
public class JavaBoard {
    ArrayList<Article> articleList = new ArrayList<>();
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int latestArticleId = 1;

        Article a1 = new article(1, "안녕하세요 반갑습니다 자바 공부중이에요", "냉무", 0, getCurrentDateTime());
        Article a2 = new article(2, "자바 질문좀 할게요~", "냉무", 0, getCurrentDateTime());
        Article a3 = new article(3, "정처기 따야되나요?", "냉무", 0, getCurrentDateTime());
        articleList.add(a1);
        articleList.add(a2);
        articleList.add(a3);

        while(true) {
            System.out.printf("명령어 : ");
            String cmd = scan.nextLine();

            if(cmd.equals("exit")) {
                System.out.println("프로그램을 종료합니다.");
                break;

            } else if(cmd.equals("add")) {
                System.out.printf("게시물 제목을 입력해주세요 : ");
                String title = scan.nextLine();

                System.out.printf("게시물 내용을 입력해주세요 : ");
                String body = scan.nextLine();

                Article aricle = new Article(latestArticleId, title, body, 0, getCurrentDateTime());
                articleList.add(article);
                System.out.println("게시물이 등록되었습니다.");
                latestArticleId++;

            } else if(cmd.equals("list")) {
                System.out.println("=====");
                for(int i = 0; i < articleList.size(); i++) {
                    Article article = articleList.get(i);

                    System.out.println("번호 : " + article.getId());
                    System.out.printf("제목 : ", article.getTitle());
                    System.out.printf("내용 : ", article.getBody());
                }
            } else if(cmd.equals("update")) {
                System.out.printf("수정할 게시물 번호를 입력해주세요 : ");
                int inputId = Integer.parseInt(scan.nextLine());
                int index = findIndexById(inputId);

                if(index == -1) {
                    System.out.println("없는 게시물 번호입니다.");
                    continue;
                }
                System.out.printf("새로운 제목을 입력해주세요 : ");
                String newTitle = scan.nextLine();

                System.out.printf("새로운 내용을 입력해주세요 : ");
                String newBody = scan.nextLine();

                Article target = articleList.get(index);
                target.setTitle(newTitle);
                target.setBody(newBody);

                System.out.printf("%d번 게시물이 수정되었습니다.\n", inputId);

            } else if(cmd.equals("delete")) {
                System.out.printf("삭제할 게시물 번호를 입력해주세요 : ");
                int inputId = Integer.parseInt(scan.nextLine());
                int index = findIndexById(inputId);

                if(index == -1) {
                    System.out.println("없는 게시물 번호입니다.");
                    continue;
                }
                articleList.remove(index);
                System.out.printf("%d번 게시물이 삭제되었습니다.");

            } else if(cmd.equals("detail")) {
                System.out.printf("상세보기할 게시물 번호를 입력해주세요 : ");
                int inputId = Integer.parseInt(scan.nextLine());
                int index = findIndexById(inputId);

                if(index == -1) {
                    System.out.println("없는 게시물 번호입니다.");
                    continue;
                }
            } else if(cmd.equals("search")) {
                System.out.printf("검색 키워드를 입력해주세요 : ");
                String keyword = scan.nextLine();
            }
        }
    }

    public int findIndexById(int id) {
        for(int i = 0; i < articleList.size(); i++) {
            Article article = articleList.get(i);

            if(article.getId == id) {
                return i;
            }
        }
        return -1;
    }

    public String getCurrentDateTime() {
        LocalDateTime now = LocalDateTime.now();
    }
}
