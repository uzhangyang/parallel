package book.ch8.phaser2;

import java.util.concurrent.Phaser;

public class CustomizedPhaser extends Phaser {

    @Override
    protected boolean onAdvance(int phase, int registeredPaties) {
        if (phase == 0) {
            return prepare();
        } else if (phase == 1) {
            return dispatch();
        } else if (phase == 2) {
            return collection_test1();
        } else if (phase == 3) {
            return collection_test2();
        } else if (phase == 4) {
            return over();
        } else {
            return true;
        }
    }

    private boolean prepare(){
        System.out.println("第"+this.getPhase()+"阶段,"
                + this.getRegisteredParties() + "个学生都已经准备好了，");
        return false;
    }
    private boolean dispatch(){
        System.out.println("第"+this.getPhase()+"阶段, 开始发卷, "
                +this.getRegisteredParties()+"个学生都已经拿到了试卷，");
        return false;
    }
    private boolean collection_test1(){
        System.out.println("第"+this.getPhase()+"阶段, 测试一部分结束，收取了"
                +this.getRegisteredParties()+"个学生科目一答题卡，");
        return false;
    }
    private boolean collection_test2(){
        System.out.println("第"+this.getPhase()+"阶段, 测试二部分结束，收取了"+this.getRegisteredParties()+"个学生科目二作文试卷，");
        return false;
    }
    private boolean over(){
        System.out.println("第"+this.getPhase()+"阶段, 考试结束.");
        return true;
    }

}
