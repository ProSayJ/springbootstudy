package com.prosayj.springboot.models.seckill.api;

import com.prosayj.springboot.models.seckill.constant.SeckillStatEnum;
import com.prosayj.springboot.models.seckill.dto.ExposerDTO;
import com.prosayj.springboot.models.seckill.dto.SeckillDTO;
import com.prosayj.springboot.models.seckill.dto.SeckillResult;
import com.prosayj.springboot.models.seckill.exception.RepeatKillException;
import com.prosayj.springboot.models.seckill.exception.SeckillCloseException;
import com.prosayj.springboot.models.seckill.exception.SeckillExecution;
import com.prosayj.springboot.models.seckill.service.SeckillService;
import jdk.internal.org.objectweb.asm.tree.TryCatchBlockNode;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.logging.Logger;


@Controller//@Service @Compent
@RequestMapping("/seckill")//url:/模块/资源/{id}/细分
public class SeckillController {
    private final org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SeckillService seckillService;

    //    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @RequestMapping("/list")
    public String list(Model model) {
        //list.jsp+model=ModelAndView
        List<SeckillDTO> seckills = seckillService.getSeckillList();
        model.addAttribute("list", seckills);
        return "list";
    }

    @RequestMapping(value = "/{seckillId}/detail", method = RequestMethod.GET)
    public String datail(@PathVariable("seckillId") Long seckillId, Model model) {

        if (seckillId == null) {
            return "redirect:/seckill/list";
        }
        SeckillDTO seckill = seckillService.getById(seckillId);
        if (seckill == null) {
            return "forward:/seckill/list";
        }
        model.addAttribute("seckill", seckill);
        return "detail";
    }


    //ajax json
    @RequestMapping(value = "/{seckillId}/exposer", method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"}//告诉浏览器输出的json的编码格式
    )
    @ResponseBody
    public SeckillResult<ExposerDTO> exposer(@PathVariable Long seckillId) {
        SeckillResult<ExposerDTO> result;

        try {
            ExposerDTO exposer = seckillService.exportSeckillUrl(seckillId);
            result = new SeckillResult<ExposerDTO>(true, exposer);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            result = new SeckillResult<ExposerDTO>(false, e.getMessage());
        }

        return result;
    }


    @RequestMapping(value = "/{seckillId}/{md5}/execution",
            method = RequestMethod.POST,
            produces = {"application/json;charser=UTF-8 "}
    )
    @ResponseBody
    public SeckillResult<SeckillExecution> execute(
            @PathVariable("seckillId") Long seckillId,
            @PathVariable("md5") String md5,
            @CookieValue(value = "killPhone", required = false) Long phone) {//required = false：防止获取不到cookie的时候报错
        //复杂验证使用springmvc valid
        if (phone == null) {
            return new SeckillResult<SeckillExecution>(false, "未注册");
        }

//        SeckillResult<SeckillExecution> result=null;
//        SeckillResult<SeckillExecution> result;
        try {
            SeckillExecution seckillExecution = seckillService.executeSeckill(seckillId, phone, md5);
            return new SeckillResult<SeckillExecution>(true, seckillExecution);

        } catch (RepeatKillException e) {
            SeckillExecution execution = new SeckillExecution(seckillId, SeckillStatEnum.REPEAT_KILL);
            return new SeckillResult<SeckillExecution>(true, execution);

        } catch (SeckillCloseException e) {
            SeckillExecution execution = new SeckillExecution(seckillId, SeckillStatEnum.END);
            return new SeckillResult<SeckillExecution>(true, execution);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            SeckillExecution execution = new SeckillExecution(seckillId, SeckillStatEnum.INNER_ORROR);
            return new SeckillResult<SeckillExecution>(true, execution);

        }

    }

    @RequestMapping(value = "/time/now", method = RequestMethod.GET)
    @ResponseBody
    public SeckillResult<Long> time() {
        return new SeckillResult<Long>(true, System.currentTimeMillis());
    }

}
