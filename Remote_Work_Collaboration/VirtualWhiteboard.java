// VirtualWhiteboard.java
class VirtualWhiteboard {
    private String[] content;
    private int contentCount;

    public VirtualWhiteboard() {
        this.content = new String[100]; // Assuming a maximum of 100 content items
        this.contentCount = 0;
    }

    public void draw(String shape) {
        if (contentCount < content.length) {
            content[contentCount++] = "Drawn shape: " + shape;
        } else {
            System.out.println("Whiteboard is full.");
        }
    }

    public void display() {
        System.out.println("Whiteboard Content:");
        for (int i = 0; i < contentCount; i++) {
            System.out.println(content[i]);
        }
    }
}
