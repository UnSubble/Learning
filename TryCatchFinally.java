public class TryCatchFinally {
    public static void main(String[] args) {

    }

    void tryBlock() {
        try {
            int c = 25 / 0;
            System.out.println("s");
        } catch (NullPointerException e) {
            e.printStackTrace();
        } finally {
            int c = 25 / 0;
            System.out.println("d");
        }

        // finally bloğundaki exception try bloğundakini keserek kendisi atar. Ne s ne de d bastırılır.
        // eğer finally bloğunda exception atılmasaydı try'ınkini catch ile yakalamasaydık bile d bastırılırdı.
    }
}