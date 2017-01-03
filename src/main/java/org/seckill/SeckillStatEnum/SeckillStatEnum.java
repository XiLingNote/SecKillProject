package org.seckill.SeckillStatEnum;

/**枚举常见数据字段
 * Created by shou on 2016/12/28.
 */
public enum SeckillStatEnum {
   SUCCESS(1,"秒杀成功") ,
   END(0,"秒杀结束") ,
    REPEAT_KIll(-1,"秒杀结束"),
    INNER_ERROR(-2,"系统异常"),
    DATA_REWRITE(-3,"数据篡改");


    private int state;
    private String stateInfo;

    public int getState() {
        return state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    SeckillStatEnum(int state, String stateInfo) {
        this.state = state;
        this.stateInfo = stateInfo;
    }
    public static SeckillStatEnum stateOf(int index){
        for (SeckillStatEnum state:values()){
            if(state.getState()==index){
                return state;
            }
        }
        return  null;
    }
}
