package com.castor.netty.frame;

import org.slf4j.Logger;
import top.crossoverjie.cicada.server.action.WorkAction;
import top.crossoverjie.cicada.server.action.param.Param;
import top.crossoverjie.cicada.server.action.res.WorkRes;
import top.crossoverjie.cicada.server.annotation.CicadaAction;
import top.crossoverjie.cicada.server.enums.StatusEnum;
import top.crossoverjie.cicada.server.util.LoggerBuilder;

import java.util.concurrent.atomic.AtomicLong;

@CicadaAction(value = "demoAction")
public class DemoAction implements WorkAction {


	private static final Logger LOGGER = LoggerBuilder.getLogger(DemoAction.class) ;

	private static AtomicLong index = new AtomicLong() ;

	@Override
	public WorkRes<DemoResVO> execute(Param paramMap) throws Exception {
		String name = paramMap.getString("name");
		Integer id = paramMap.getInteger("id");
		LOGGER.info("name=[{}],id=[{}]" , name,id);

		DemoResVO demoResVO = new DemoResVO() ;
		demoResVO.setIndex(index.incrementAndGet());
		WorkRes<DemoResVO> res = new WorkRes();
		res.setCode(StatusEnum.SUCCESS.getCode());
		res.setMessage(StatusEnum.SUCCESS.getMessage());
		res.setDataBody(demoResVO) ;
		return res;
	}

}
