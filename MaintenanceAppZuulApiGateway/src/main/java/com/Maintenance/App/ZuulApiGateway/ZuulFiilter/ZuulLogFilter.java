package com.Maintenance.App.ZuulApiGateway.ZuulFiilter;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;  
import org.slf4j.LoggerFactory;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;


public class ZuulLogFilter extends ZuulFilter{

	@Override
	public boolean shouldFilter() {
		// TODO Auto-generated method stub
		return false;
	}
	
	private Logger logger=LoggerFactory.getLogger(this.getClass());  

	@Override
	public Object run() throws ZuulException {
		HttpServletRequest request=RequestContext.getCurrentContext().getRequest(); 
		logger.info("request -> {} request uri-> {}", request, request.getRequestURI());  
		return null;  
	}

	@Override
	public String filterType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int filterOrder() {
		// TODO Auto-generated method stub
		return 0;
	}

}
