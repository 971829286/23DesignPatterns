package com.design17_state;

public class ScoreStateTest {
    public static void main(String[] args) {
        ThreadContext context = new ThreadContext();
        context.start();
        context.getCPU();
        context.suspend();
        context.resume();
        context.getCPU();
        context.stop();
    }
}

//环境类
class ThreadContext {
    private ThreadState state;

    ThreadContext() {
        state = new New();
    }

    void setState(ThreadState state) {
        this.state = state;
    }

    public ThreadState getState() {
        return state;
    }

    void start() {
        ((New) state).start(this);
    }

    void getCPU() {
        ((Runnable) state).getCPU(this);
    }

    void suspend() {
        ((Running) state).suspend(this);
    }

    void stop() {
        ((Running) state).stop(this);
    }

    void resume() {
        ((Blocked) state).resume(this);
    }
}

//抽象状态类：线程状态
abstract class ThreadState {
    String stateName; //状态名
}

//具体状态类：新建状态
class New extends ThreadState {
    New() {
        stateName = "新建状态";
        System.out.println("当前线程处于：新建状态.");
    }

    void start(ThreadContext hj) {
        System.out.print("调用start()方法-->");
        if (stateName.equals("新建状态")) {
            hj.setState(new Runnable());
        } else {
            System.out.println("当前线程不是新建状态，不能调用start()方法.");
        }
    }
}

//具体状态类：就绪状态
class Runnable extends ThreadState {
    Runnable() {
        stateName = "就绪状态";
        System.out.println("当前线程处于：就绪状态.");
    }

    void getCPU(ThreadContext hj) {
        System.out.print("获得CPU时间-->");
        if (stateName.equals("就绪状态")) {
            hj.setState(new Running());
        } else {
            System.out.println("当前线程不是就绪状态，不能获取CPU.");
        }
    }
}

//具体状态类：运行状态
class Running extends ThreadState {
    Running() {
        stateName = "运行状态";
        System.out.println("当前线程处于：运行状态.");
    }

    void suspend(ThreadContext hj) {
        System.out.print("调用suspend()方法-->");
        if (stateName.equals("运行状态")) {
            hj.setState(new Blocked());
        } else {
            System.out.println("当前线程不是运行状态，不能调用suspend()方法.");
        }
    }

    void stop(ThreadContext hj) {
        System.out.print("调用stop()方法-->");
        if (stateName.equals("运行状态")) {
            hj.setState(new Dead());
        } else {
            System.out.println("当前线程不是运行状态，不能调用stop()方法.");
        }
    }
}

//具体状态类：阻塞状态
class Blocked extends ThreadState {
    Blocked() {
        stateName = "阻塞状态";
        System.out.println("当前线程处于：阻塞状态.");
    }

    void resume(ThreadContext hj) {
        System.out.print("调用resume()方法-->");
        if (stateName.equals("阻塞状态")) {
            hj.setState(new Runnable());
        } else {
            System.out.println("当前线程不是阻塞状态，不能调用resume()方法.");
        }
    }
}

//具体状态类：死亡状态
class Dead extends ThreadState {
    Dead() {
        stateName = "死亡状态";
        System.out.println("当前线程处于：死亡状态.");
    }
}