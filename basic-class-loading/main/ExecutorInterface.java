package main;
public interface ExecutorInterface {
    int CONTINUE = 0;
    int FINISH = 1;
    int process(String data);
}
