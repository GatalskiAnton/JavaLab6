public class Main {
    public static void main(String[] args) {
        Task1Frame frame = new Task1Frame("frame");
        frame.setSize(500,500);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        Task2Frame frame2 = new Task2Frame("frame");
        frame2.setLocationRelativeTo(null);
        frame2.setVisible(true);
    }
}
