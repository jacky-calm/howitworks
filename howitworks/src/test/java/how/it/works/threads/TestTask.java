package how.it.works.threads;

public class TestTask implements Task{
    private String name;

    public TestTask(String name) {
        this.name = name;
    }
    @Override
    public void execute() {
        System.out.println("I am " + name);
    }
}
