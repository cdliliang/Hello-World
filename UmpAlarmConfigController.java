/*
 * Copyright (c) 2013 www.jd.com All rights reserved.
 * 本软件源代码版权归京东成都云平台所有,未经许可不得任意复制与传播.
 */
package com.jd.testMvvc.web.controller;

import javax.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.stereotype.Controller;
import com.jd.testMvvc.common.spring.velocity.BaseController;
import com.jd.testMvvc.common.spring.secret.AuthType;
import com.jd.testMvvc.common.spring.secret.Authentication;
import com.jd.testMvvc.domain.UmpAlarmConfig;
import com.jd.testMvvc.domain.common.Page;
import com.jd.testMvvc.domain.common.Message;
import com.jd.testMvvc.service.UmpAlarmConfigService;
import com.jd.ump.profiler.CallerInfo;
import com.jd.ump.profiler.proxy.Profiler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.jd.testMvvc.domain.common.SysUser;
/**
 * umpAlarmConfig controller层
 * @author J-ONE
 * @since 2013-11-13
 */
@Controller
@RequestMapping(value = "/umpAlarmConfig")
public class UmpAlarmConfigController extends BaseController {
	@Resource private UmpAlarmConfigService umpAlarmConfigService;
	private final Logger LOGGER = LoggerFactory.getLogger(UmpAlarmConfig.class);
	/**
	 * 列表展示
	 * @param umpAlarmConfig 实体对象
	 * @param page 分页对象
	 * @return
	 */
	@RequestMapping(method = {RequestMethod.GET,RequestMethod.POST})
	@Authentication(type=AuthType.NONE)
	public ModelAndView list(UmpAlarmConfig umpAlarmConfig,Page<UmpAlarmConfig> page){
	        LOGGER.info("statUmpAlarmConfig statPV=1 statUV=" + (true == true ?((SysUser)getLoginUser()).getName():null) + " statMOD=UmpAlarmConfigController.List ");
				CallerInfo callerInfo = Profiler.registerInfo("jone-umpAlarmConfig.List", false, false);
        Result result = new Result();
	try{
		
		result.addDefaultModel("umpAlarmConfig",umpAlarmConfig);
		result.addDefaultModel("page",umpAlarmConfigService.selectPage(umpAlarmConfig,page));
	}catch(Exception e) {
		LOGGER.error("失败:"+e.getMessage(),e);
			Profiler.functionError(callerInfo);
			}finally{
					Profiler.registerInfoEnd(callerInfo);
				}
		return toResultSkipLayout("umpAlarmConfig/list",result);	
		
	}
	
	/**
	 * 响应新增(修改)页面
	 * @param id 对象编号
	 * @return
	 */
	@RequestMapping(value="/{id}",method=RequestMethod.PUT)
	@Authentication(type=AuthType.NONE)
	public ModelAndView edit(@PathVariable Long id){
	    	LOGGER.info("statUmpAlarmConfig statPV=1 statUV=" + (true == true ?((SysUser)getLoginUser()).getName():null) + " statMOD=UmpAlarmConfigController.edit ");
				CallerInfo callerInfo = Profiler.registerInfo("jone-umpAlarmConfig.edit", false, false);
        Result result = new Result();
    try{
    	
		if(id != null && id > 0) {
			UmpAlarmConfig umpAlarmConfig = umpAlarmConfigService.selectEntry(id);
			if(umpAlarmConfig == null) {
				return toJSON(Message.failure("您要修改的数据不存在或者已被删除!"));
			}
			result.addDefaultModel("umpAlarmConfig",umpAlarmConfig);
		}
    }catch(Exception e) {
		LOGGER.error("失败:"+e.getMessage(),e);
			Profiler.functionError(callerInfo);
			}finally{
					Profiler.registerInfoEnd(callerInfo);
				}
		return toResultSkipLayout("umpAlarmConfig/edit",result);	
	}
	
	/**
	 * 通过编号删除对象
	 * @param id 对象编号
	 * @return
	 */
	@RequestMapping(value="/{id}",method=RequestMethod.DELETE)
	@Authentication(type=AuthType.NONE)
	public ModelAndView del(@PathVariable Long id){
	    	LOGGER.info("statUmpAlarmConfig statPV=1 statUV=" + (true == true ?((SysUser)getLoginUser()).getName():null) + " statMOD=UmpAlarmConfigController.del ");
				CallerInfo callerInfo = Profiler.registerInfo("jone-umpAlarmConfig.del", false, false);
        Message msg = null;
    try{
    	int res = umpAlarmConfigService.deleteByKey(id);
		msg  = res > 0 ? Message.success() : Message.failure();
		
    }catch(Exception e) {
		LOGGER.error("失败:"+e.getMessage(),e);
			Profiler.functionError(callerInfo);
			}finally{
					Profiler.registerInfoEnd(callerInfo);
				}
		return toJSON(msg);
	}
	
	/**
	 * 通过编号查看对象
	 * @param id 对象编号
	 * @return
	 */
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	@Authentication(type=AuthType.NONE)
	public ModelAndView view(@PathVariable Long id){
	    	LOGGER.info("statUmpAlarmConfig statPV=1 statUV=" + (true == true ?((SysUser)getLoginUser()).getName():null) + " statMOD=UmpAlarmConfigController.view ");
				CallerInfo callerInfo = Profiler.registerInfo("jone-umpAlarmConfig.view", false, false);
        Result result = new Result();
    try{
    	
		UmpAlarmConfig umpAlarmConfig = umpAlarmConfigService.selectEntry(id);
		if(umpAlarmConfig == null) {
			return toJSON(Message.failure("您要查看的数据不存在或者已被删除!"));
		}
		result.addDefaultModel("umpAlarmConfig",umpAlarmConfig);
		
    }catch(Exception e) {
		LOGGER.error("失败:"+e.getMessage(),e);
			Profiler.functionError(callerInfo);
			}finally{
					Profiler.registerInfoEnd(callerInfo);
				}
		return toResultSkipLayout("umpAlarmConfig/view",result);
	}
	
	/**
	 * 保存方法
	 * @param umpAlarmConfig 实体对象
	 * @return
	 */
	@RequestMapping(value="/save",method=RequestMethod.POST)
	@Authentication(type=AuthType.NONE)
	public ModelAndView save(UmpAlarmConfig umpAlarmConfig){
	    	LOGGER.info("statUmpAlarmConfig statPV=1 statUV=" + (true == true ?((SysUser)getLoginUser()).getName():null) + " statMOD=UmpAlarmConfigController.save ");
				CallerInfo callerInfo = Profiler.registerInfo("jone-umpAlarmConfig.save", false, false);
        Message msg = null;
    try{
    	int res = umpAlarmConfigService.saveOrUpdate(umpAlarmConfig);
		msg  = res > 0 ? Message.success() : Message.failure();
		
    }catch(Exception e) {
		LOGGER.error("失败:"+e.getMessage(),e);
			Profiler.functionError(callerInfo);
			}finally{
					Profiler.registerInfoEnd(callerInfo);
				}
		return toJSON(msg);	
	}
	
}