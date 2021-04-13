package com.escalab.filters;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

public class HeaderPreFilter extends ZuulFilter {
	
	private static Logger LOGGER = LoggerFactory.getLogger(HeaderPreFilter.class);
    private static final String FILTERTYPE = "pre";
    private static final Integer FILTERORDER = 1;

    public HeaderPreFilter(){ }
    
	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		RequestContext ctx = RequestContext.getCurrentContext();		
		final HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
		boolean cabecera = false;
		if(request.getRequestURI().contains("oauth/token")) 
			cabecera = true;
		else
			try {
				cabecera = request.getHeader("zuul").toString().equalsIgnoreCase("true");
			} catch (Exception e) {
				cabecera = false;
			}
		long startTime = Instant.now().toEpochMilli();
		
		ctx.put("startTime", startTime);
		if(!cabecera) 	
			ctx.setSendZuulResponse(false);
		else 
			ctx.setSendZuulResponse(true);
		return null;
	}

	@Override
	public String filterType() {
		return FILTERTYPE;
	}

	@Override
	public int filterOrder() {
		return FILTERORDER;
	}

}
