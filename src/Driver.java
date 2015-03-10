public class Driver {

    public static void main(String[] args) throws Exception {
        if (args.length == 1) {
            Class<?> clazz = Class.forName(args[0]);
            Object instance = clazz.newInstance();
            if (instance instanceof Runnable) {
                Thread thread = new Thread((Runnable) instance);
                thread.start();
            } else {
                throw new Exception("Specied class name must be an instance of Runnable.");
            }
        } else {
            throw new Exception("The expected number of parameters is one.");
        }
    }

}
