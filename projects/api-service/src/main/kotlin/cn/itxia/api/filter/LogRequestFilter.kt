package cn.itxia.api.filter

import cn.itxia.api.service.RequestLogService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.annotation.Order
import org.springframework.stereotype.Component
import javax.servlet.Filter
import javax.servlet.FilterChain
import javax.servlet.ServletRequest
import javax.servlet.ServletResponse

@Component
@Order(2)
class LogRequestFilter : Filter {

    @Autowired
    private lateinit var requestLogService: RequestLogService

    override fun doFilter(servletRequest: ServletRequest, servletResponse: ServletResponse, chain: FilterChain) {
        requestLogService.logMemberActivity(servletRequest, servletResponse)
        chain.doFilter(servletRequest, servletResponse)
    }

}
