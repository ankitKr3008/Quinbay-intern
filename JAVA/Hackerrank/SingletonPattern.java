class Singleton{
    private Singleton(){
    }
    public String str;
    private static Singleton singleton;
    public static Singleton getSingleInstance(){
        if (singleton == null) {
            singleton = new Singleton();
        }
        return singleton;
    }
}
