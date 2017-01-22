package org.seckill.web;

import com.alibaba.fastjson.JSON;
import org.seckill.SeckillStatEnum.SeckillStatEnum;
import org.seckill.dto.Exposer;
import org.seckill.dto.SeckillResult;
import org.seckill.dto.seckillExcution;
import org.seckill.entity.Seckill;
import org.seckill.exception.RepeatKillExcetion;
import org.seckill.exception.SeckillCloseException;
import org.seckill.service.SeckillService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * Created by shou on 2017/1/4.
 */
@Controller//@service@Component
@RequestMapping("/seckill")//url:/模块/资源/{id}/seckill/lisrt
public class SeckillController {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private SeckillService seckillService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(Model model) {
        //获取列表页
        List<Seckill> list = seckillService.getSeckillList();
        model.addAttribute("list", list);
        //detail.jsp+model=NodeAndView
        return "list";//WEB
    }

    @RequestMapping(value = "/{seckillId}/detail", method = RequestMethod.GET)
    public String detail(@PathVariable("seckillId") int seckillId, Model model) {
        if (seckillId == 0) {
            return "redirect:/seckill/list";
        }
        Seckill seckill = seckillService.getById(seckillId);
        if (seckill == null) {
            return "forward:/seckill/list";
        }
        model.addAttribute("seckill", seckill);
        return "detail";
    }

    //ajax json
    @RequestMapping(value = "/{seckillId}/exposer", method = RequestMethod.POST,
            produces = {"application/json;charset=utf-8"})
   @ResponseBody
    public SeckillResult<Exposer> exposer(@PathVariable("seckillId")int seckillId) {
        SeckillResult<Exposer> result;
        Exposer exposer = seckillService.exportSeckillUrl(seckillId);
        try {
            result = new SeckillResult<Exposer>(true, exposer);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            result = new SeckillResult<Exposer>(false, e.getMessage());
        }
        System.out.println(JSON.toJSON(result));
        return result;
    }

    /**
     * 秒杀执行情况
     * @param seckillId
     * @param md5
     * @param phone
     * @return
     */
    @RequestMapping(value = "/{seckillId}/{md5}/execution", method = RequestMethod.POST, produces = {"application/json;charset=utf-8"})
   @ResponseBody
    public SeckillResult<seckillExcution> execute(@PathVariable("seckillId") int seckillId,
                                                  @PathVariable("md5") String md5,
                                                  @CookieValue(value = "killPhone", required = false) int phone) {
        if (phone==0){
            return new SeckillResult<seckillExcution>(false,new seckillExcution(seckillId, SeckillStatEnum.REGIST));
        }
        SeckillResult<seckillExcution> result;
        seckillExcution execution =null;
        try {
            execution = seckillService.excuteSeckill(seckillId, phone, md5);
            return new SeckillResult<seckillExcution>(true, execution);
        }catch (RepeatKillExcetion repeatKillExcetion){
            execution =new seckillExcution(seckillId, SeckillStatEnum.FALSE);
            return  new SeckillResult<seckillExcution>(true,execution);
        }
        catch (SeckillCloseException e) {
            execution =new seckillExcution(seckillId, SeckillStatEnum.END);
            return new SeckillResult<seckillExcution>(true, execution);
        }catch (Exception e){
            logger.error(e.getMessage());
            return new SeckillResult<seckillExcution>(false, e.getMessage());
        }
    }
    @RequestMapping(value = "/time/now",method =RequestMethod.GET )
    @ResponseBody
    public  SeckillResult<seckillExcution> time(){
        Date now =new Date();
        return new SeckillResult<seckillExcution>(true,Long.toString(now.getTime()));
    }
}
