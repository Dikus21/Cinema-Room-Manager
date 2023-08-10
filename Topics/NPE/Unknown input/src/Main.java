class Util {
    // correct this method to avoid NPE
    public static void printLength(String name) {
        int size = name == null ? 0 : name.length();
        System.out.println(size);
    }
}