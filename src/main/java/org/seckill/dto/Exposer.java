package org.seckill.dto;

/**
 * Created by shou on 2016/12/27.
 */
public class Exposer {
    private boolean exposed;
    private String md5;
    private int seckillId;
    //系统时间
    private long now;
    private long start;
    private long end;

    public Exposer(boolean exposed, int seckillId) {
        this.exposed = exposed;
        this.seckillId = seckillId;
    }

    public Exposer(boolean exposed, String md5, int seckillId) {
        this.exposed = exposed;
        this.md5 = md5;
        this.seckillId = seckillId;
    }

    @Override
    public String toString() {
        return "Exposer{" +
                "exposed=" + exposed +
                ", md5='" + md5 + '\'' +
                ", seckillId=" + seckillId +
                ", now=" + now +
                ", start=" + start +
                ", end=" + end +
                '}';
    }

    public boolean isExposed() {
        return exposed;
    }

    public void setExposed(boolean exposed) {
        this.exposed = exposed;
    }

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    public int getSeckillId() {
        return seckillId;
    }

    public void setSeckillId(int seckillId) {
        this.seckillId = seckillId;
    }

    public long getNow() {
        return now;
    }

    public void setNow(long now) {
        this.now = now;
    }

    public long getStart() {
        return start;
    }

    public void setStart(long start) {
        this.start = start;
    }

    public long getEnd() {
        return end;
    }

    public void setEnd(long end) {
        this.end = end;
    }

    public Exposer(boolean exposed, long now, long start, long end, int seckillId) {
        this.exposed = exposed;
        this.now = now;
        this.start = start;
        this.end = end;
        this.seckillId=seckillId;
    }
}
