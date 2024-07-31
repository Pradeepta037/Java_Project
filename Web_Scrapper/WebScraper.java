import java.util.Scanner;

public class WebScraper {
    private Page page;

    public WebScraper(String url) {
        this.page = new Page(url);
    }

    public void scrape() {
        try {
            String content = ScraperUtils.fetchContent(page.getUrl());
            page.setContent(content);
            System.out.println("Content fetched successfully!");
            System.out.println(page.getContent());
        } catch (Exception e) {
            System.err.println("Error fetching content: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the URL of the website to scrape: ");
        String url = scanner.nextLine();

        WebScraper scraper = new WebScraper(url);
        scraper.scrape();

        scanner.close();
    }
}